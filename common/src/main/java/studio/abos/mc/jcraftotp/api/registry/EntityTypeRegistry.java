package studio.abos.mc.jcraftotp.api.registry;

import studio.abos.mc.jcraftotp.JCraftOtp;
import studio.abos.mc.jcraftotp.common.stand.CivilWarEntity;
import dev.architectury.registry.level.entity.EntityAttributeRegistry;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;

public interface EntityTypeRegistry {

    DeferredRegister<EntityType<?>> REGISTRY = DeferredRegister.create(JCraftOtp.MOD_ID, Registries.ENTITY_TYPE);

    RegistrySupplier<EntityType<CivilWarEntity>> CIVIL_WAR = REGISTRY.register("civil_war", () ->
            EntityType.Builder.of((EntityType.EntityFactory<CivilWarEntity>)
                            (t, level) -> new CivilWarEntity(level),
                            MobCategory.CREATURE)
                    .sized(0.6f, 1.8f)
                    .build("civil_war"));

    static void registerAttributes() {
        EntityAttributeRegistry.register(CIVIL_WAR, CivilWarEntity::createMobAttributes);
    }

}
