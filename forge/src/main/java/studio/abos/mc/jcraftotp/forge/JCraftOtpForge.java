package studio.abos.mc.jcraftotp.forge;

import dev.architectury.platform.forge.EventBuses;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

import studio.abos.mc.jcraftotp.JCraftOtp;

@Mod(JCraftOtp.MOD_ID)
public final class JCraftOtpForge {
    public JCraftOtpForge(FMLJavaModLoadingContext ctx) {
        // Submit our event bus to let Architectury API register our content on the right time.
        EventBuses.registerModEventBus(JCraftOtp.MOD_ID, ctx.getModEventBus());

        // Run our common setup.
        JCraftOtp.init();
    }
}
