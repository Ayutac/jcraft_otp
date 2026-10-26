package studio.abos.mc.jcraftotp.fabric.common.component;

import dev.onyxstudios.cca.api.v3.component.ComponentKey;
import dev.onyxstudios.cca.api.v3.component.ComponentRegistry;
import dev.onyxstudios.cca.api.v3.entity.EntityComponentFactoryRegistry;
import dev.onyxstudios.cca.api.v3.entity.EntityComponentInitializer;
import dev.onyxstudios.cca.api.v3.entity.RespawnCopyStrategy;
import lombok.NonNull;
import net.minecraft.world.entity.LivingEntity;
import studio.abos.mc.jcraftotp.JCraftOtp;
import studio.abos.mc.jcraftotp.fabric.common.component.impl.living.CivilWarComponentImpl;
import studio.abos.mc.jcraftotp.fabric.common.component.living.CivilWarComponent;

public class Components implements EntityComponentInitializer {

    public static final ComponentKey<CivilWarComponent> CIVIL_WAR =
            ComponentRegistry.getOrCreate(JCraftOtp.id("civil_war"), CivilWarComponent.class);

    @Override
    public void registerEntityComponentFactories(final @NonNull EntityComponentFactoryRegistry registry) {
        registry.beginRegistration(LivingEntity.class, CIVIL_WAR)
                .respawnStrategy(RespawnCopyStrategy.ALWAYS_COPY)
                .impl(CivilWarComponentImpl.class)
                .end(CivilWarComponentImpl::new);
    }

}
