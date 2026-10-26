package studio.abos.mc.jcraftotp.forge;

import dev.architectury.platform.forge.EventBuses;
import net.arna.jcraft.common.events.EntityTickEvent;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

import studio.abos.mc.jcraftotp.JCraftOtp;
import studio.abos.mc.jcraftotp.common.component.impl.CommonCivilWarComponentImpl;
import studio.abos.mc.jcraftotp.forge.capability.impl.living.CivilWarCapability;

@Mod(JCraftOtp.MOD_ID)
public final class JCraftOtpForge {

    public JCraftOtpForge(final FMLJavaModLoadingContext ctx) {
        // Submit our event bus to let Architectury API register our content on the right time.
        EventBuses.registerModEventBus(JCraftOtp.MOD_ID, ctx.getModEventBus());

        // Run our common setup.
        JCraftOtp.init();

        EntityTickEvent.ENTITY_PRE.register(JCraftOtpForge::tickEntityCaps);
    }

    public static void tickEntityCaps(final Entity entity) {
        if (entity instanceof final LivingEntity living) {
            CivilWarCapability.getCapabilityOptional(living)
                    .ifPresent(CommonCivilWarComponentImpl::tick);
        }
    }

}
