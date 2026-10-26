package studio.abos.mc.jcraftotp;

import dev.architectury.event.events.common.LifecycleEvent;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import studio.abos.mc.jcraftotp.api.registry.EntityTypeRegistry;
import studio.abos.mc.jcraftotp.api.registry.StandTypeRegistry;
import net.minecraft.resources.ResourceLocation;
import studio.abos.mc.jcraftotp.platform.ComponentPlatformUtils;

public final class JCraftOtp {

    public static final String MOD_ID = "jcraftotp";
    public static final String BASE_CONTROLLER = "base_controller";

    public static void init() {
        EntityTypeRegistry.REGISTRY.register();
        StandTypeRegistry.REGISTRY.register();

        EntityTypeRegistry.registerAttributes();
        LifecycleEvent.SERVER_STOPPING.register(JCraftOtp::discardAllGhosts);
    }

    private static void discardAllGhosts(final MinecraftServer server) {
        for (final ServerLevel level : server.getAllLevels()) {
            for (final Entity entity : level.getAllEntities()) {
                if (entity instanceof final LivingEntity living && ComponentPlatformUtils.getCivilWarComponent(living).isGhost()) {
                    living.discard();
                }
            }
        }
    }

    public static ResourceLocation id(String path) {
        return new ResourceLocation(MOD_ID, path);
    }
}
