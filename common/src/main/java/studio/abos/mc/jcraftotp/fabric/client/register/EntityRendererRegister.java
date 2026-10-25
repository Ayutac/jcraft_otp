package studio.abos.mc.jcraftotp.fabric.client.register;

import studio.abos.mc.jcraftotp.fabric.client.renderer.CivilWarRenderer;
import studio.abos.mc.jcraftotp.common.register.EntityTypeRegistry;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;

import java.util.function.Supplier;

public interface EntityRendererRegister {

    static void register(EntityRendererRegistrar registrar) {
        registrar.register(EntityTypeRegistry.CIVIL_WAR, CivilWarRenderer::new);
    }

    @FunctionalInterface
    interface EntityRendererRegistrar {
        <T extends Entity> void register(Supplier<? extends EntityType<? extends T>> type,
                                         EntityRendererProvider<T> rendererProvider);
    }

}
