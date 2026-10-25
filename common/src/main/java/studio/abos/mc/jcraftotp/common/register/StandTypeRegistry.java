package studio.abos.mc.jcraftotp.common.register;

import studio.abos.mc.jcraftotp.JCraftOtp;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.arna.jcraft.api.JRegistries;
import net.arna.jcraft.api.stand.StandType;

public interface StandTypeRegistry {
    DeferredRegister<StandType> REGISTRY = DeferredRegister.create(JCraftOtp.MOD_ID, JRegistries.STAND_TYPE_REGISTRY_KEY);

    RegistrySupplier<StandType> CIVIL_WAR = REGISTRY.register(JCraftOtp.id("civil_war"), () ->
            StandType.of(JCraftOtp.id("civil_war"), EntityTypeRegistry.CIVIL_WAR));
}
