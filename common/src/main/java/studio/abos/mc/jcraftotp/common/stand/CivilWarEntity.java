package studio.abos.mc.jcraftotp.common.stand;

import lombok.NonNull;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntitySelector;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.phys.AABB;
import studio.abos.mc.jcraftotp.JCraftOtp;
import studio.abos.mc.jcraftotp.api.component.living.CommonCivilWarComponent;
import studio.abos.mc.jcraftotp.api.registry.StandTypeRegistry;
import mod.azure.azurelib.animation.dispatch.command.AzCommand;
import mod.azure.azurelib.animation.play_behavior.AzPlayBehaviors;
import net.arna.jcraft.JCraft;
import net.arna.jcraft.api.attack.MoveMap;
import net.arna.jcraft.api.attack.MoveSet;
import net.arna.jcraft.api.attack.MoveSetManager;
import net.arna.jcraft.api.attack.enums.MoveClass;
import net.arna.jcraft.api.registry.JSoundRegistry;
import net.arna.jcraft.api.stand.StandData;
import net.arna.jcraft.api.stand.StandEntity;
import net.arna.jcraft.api.stand.StandInfo;
import net.arna.jcraft.common.attack.moves.shared.MainBarrageAttack;
import net.arna.jcraft.common.attack.moves.shared.SimpleAttack;
import net.arna.jcraft.common.util.StandAnimationState;
import net.minecraft.network.chat.Component;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import org.jetbrains.annotations.NotNull;
import studio.abos.mc.jcraftotp.api.registry.TagRegistry;
import studio.abos.mc.jcraftotp.platform.ComponentPlatformUtils;

import java.util.Optional;
import java.util.function.Predicate;

public class CivilWarEntity extends StandEntity<CivilWarEntity, CivilWarEntity.State> {

    public static final MoveSet<CivilWarEntity, State> MOVE_SET = MoveSetManager.create(StandTypeRegistry.CIVIL_WAR,
            CivilWarEntity::registerMoves, State.class);
    public static final StandData DATA = StandData.of(StandInfo.of(Component.literal("Civil War")));

    public static final SimpleAttack<CivilWarEntity> LIGHT = new SimpleAttack<CivilWarEntity>(JCraft.LIGHT_COOLDOWN,
            5, 8, 0.75f, 5f, 16, 1.5f, 0.2f, -0.1f)
            .withImpactSound(JSoundRegistry.IMPACT_1)
            .withInfo(
                    Component.literal("Punch"),
                    Component.literal("An example punch attack")
            );
    public static final MainBarrageAttack<CivilWarEntity> BARRAGE = new MainBarrageAttack<CivilWarEntity>(280,
            0, 40, 0.75f, 1f, 30, 2f, 0.25f, 0f, 3, Blocks.OBSIDIAN.defaultDestroyTime())
            .withSound(JSoundRegistry.STAR_PLATINUM_BARRAGE)
            .withInfo(
                    Component.translatable("jcraft.generic.barrage"),
                    Component.literal("An example barrage attack")
            );

    public static final int SPAWN_FREQUENCY = 20; // in ticks
    public static final float SUMMON_RADIUS = 9f; // in meter
    public static final float SUMMON_RADIUS_SQR = SUMMON_RADIUS * SUMMON_RADIUS;
    public static final float TARGET_RADIUS = SUMMON_RADIUS; // in meter
    public static final float TARGET_RADIUS_SQR = TARGET_RADIUS * TARGET_RADIUS;

    public CivilWarEntity(Level world) {
        super(StandTypeRegistry.CIVIL_WAR.get(), world);
    }

    private static void registerMoves(MoveMap<CivilWarEntity, State> moveMap) {
        moveMap.register(MoveClass.LIGHT, LIGHT, State.LIGHT);
        moveMap.register(MoveClass.HEAVY, LIGHT, State.LIGHT);
        moveMap.register(MoveClass.BARRAGE, BARRAGE, State.BARRAGE);
    }

    @Override
    public void tick() {
        super.tick();
        if (tickCount % SPAWN_FREQUENCY == 1) {
            summonGhosts();
        }
    }

    public void summonGhosts() {
        if (!hasUser() || level().isClientSide()) {
            return;
        }
        final Predicate<Entity> selector = EntitySelector.NO_CREATIVE_OR_SPECTATOR
                .and(EntitySelector.LIVING_ENTITY_STILL_ALIVE)
                .and(entity -> !entity.getType().is(TagRegistry.DOESNT_CREATE_CW_GHOST))
                .and(entity -> getUserOrThrow().position().distanceToSqr(entity.position()) <= SUMMON_RADIUS_SQR); // radial distance
        level().getEntities(this, AABB.ofSize(position(), SUMMON_RADIUS, SUMMON_RADIUS, SUMMON_RADIUS), selector).stream()
                .map(LivingEntity.class::cast)
                .filter(target -> !ComponentPlatformUtils.getCivilWarComponent(target).isGhost())
                .forEach(this::summonGhostOn);
    }

    public void summonGhostOn(final @NonNull LivingEntity target) {
        if (level().isClientSide) {
            return;
        }
        final Optional<EntityType<? extends LivingEntity>> ghostType = randomGhostType(target, random);
        if (ghostType.isPresent()) {
            final LivingEntity ghost = ghostType.get().create(level());
            if (ghost == null) {
                return;
            }
            ghost.setPos(target.position()); // TODO randomize more
            CommonCivilWarComponent.create(ghost, this, target, SUMMON_RADIUS, TARGET_RADIUS);
            ghost.setLastHurtByMob(target);
            level().addFreshEntity(ghost);
        }
    }

    public static Optional<EntityType<? extends LivingEntity>> randomGhostType(final @NonNull LivingEntity target, final @NonNull RandomSource rng) {
        // TODO: actually randomize
        return Optional.of(EntityType.ZOMBIE);
    }

    @NotNull
    @Override
    public CivilWarEntity getThis() {
        return this;
    }

    @Override
    protected State[] getStateValues() {
        return State.values();
    }

    @Override
    public State getBlockState() {
        return State.BLOCK;
    }

    public enum State implements StandAnimationState<CivilWarEntity> {
        IDLE(AzCommand.create(JCraftOtp.BASE_CONTROLLER, "idle", AzPlayBehaviors.LOOP)),
        LIGHT(AzCommand.create(JCraftOtp.BASE_CONTROLLER, "light", AzPlayBehaviors.HOLD_ON_LAST_FRAME)),
        BLOCK(AzCommand.create(JCraftOtp.BASE_CONTROLLER, "block", AzPlayBehaviors.LOOP)),
        BARRAGE(AzCommand.create(JCraftOtp.BASE_CONTROLLER, "barrage", AzPlayBehaviors.LOOP));

        private final AzCommand animator;

        State(AzCommand animator) {
            this.animator = animator;
        }

        @Override
        public void playAnimation(CivilWarEntity attacker) {
            animator.sendForEntity(attacker);
        }
    }

}
