package studio.abos.mc.jcraftotp;

import studio.abos.mc.jcraftotp.api.registry.EntityTypeRegistry;
import studio.abos.mc.jcraftotp.api.registry.StandTypeRegistry;
import net.minecraft.resources.ResourceLocation;

public final class JCraftOtp {

    public static final String MOD_ID = "jcraftotp";
    public static final String BASE_CONTROLLER = "base_controller";

    public static void init() {
        EntityTypeRegistry.REGISTRY.register();
        StandTypeRegistry.REGISTRY.register();

        EntityTypeRegistry.registerAttributes();
    }

    public static ResourceLocation id(String path) {
        return new ResourceLocation(MOD_ID, path);
    }
}
