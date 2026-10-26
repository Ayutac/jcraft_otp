package studio.abos.mc.jcraftotp.common.component.impl;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import net.arna.jcraft.api.attack.IAttacker;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.LivingEntity;
import studio.abos.mc.jcraftotp.api.component.living.CommonCivilWarComponent;

public abstract class CommonCivilWarComponentImpl implements CommonCivilWarComponent {

    protected final @NonNull LivingEntity living;
    @Getter
    @Setter
    protected boolean ghost;
    @Getter
    @Setter
    protected IAttacker<?,?> summoner;
    @Getter
    @Setter
    protected LivingEntity target;
    @Getter
    protected float summonRadius;
    protected float summonRadiusSqr;
    @Getter
    protected float targetRadius;
    protected float targetRadiusSqr;

    public CommonCivilWarComponentImpl(final @NonNull LivingEntity living) {
        this.living = living;
    }

    @Override
    public void setSummonRadius(final float summonRadius) {
        this.summonRadius = summonRadius;
        summonRadiusSqr = summonRadius * summonRadius;
    }

    @Override
    public void setTargetRadius(final float targetRadius) {
        this.targetRadius = targetRadius;
        targetRadiusSqr = targetRadius * targetRadius;
    }

    public void tick() {
        if (!ghost || living.level().isClientSide()) {
            return;
        }
        if (target == null || target.isDeadOrDying() || summoner == null || summoner.getBaseEntity().isDeadOrDying() || !summoner.hasUser() || summoner.getUserOrThrow().isDeadOrDying()) {
            living.discard();
        }
        if (target.position().distanceToSqr(summoner.getUserOrThrow().position()) > summonRadiusSqr ||
                target.position().distanceToSqr(living.position()) > targetRadiusSqr) {
            living.discard();
        }
    }

    @Override
    public void readFromNbt(@NonNull final CompoundTag compoundTag) {
        // intentionally left empty
    }

    @Override
    public void writeToNbt(@NonNull final CompoundTag compoundTag) {
        // intentionally left empty
    }

}
