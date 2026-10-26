package studio.abos.mc.jcraftotp.forge.event;

import net.arna.jcraft.forge.capability.api.JCapabilityProvider;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import studio.abos.mc.jcraftotp.JCraftOtp;
import studio.abos.mc.jcraftotp.forge.capability.impl.living.CivilWarCapability;

@Mod.EventBusSubscriber
public class RuntimeEvents {

    @SubscribeEvent
    public static void attachEntityCapability(AttachCapabilitiesEvent<Entity> event) {
        if (event.getObject() instanceof LivingEntity living) {
            event.addCapability(JCraftOtp.id("civil_war"), new JCapabilityProvider<>(CivilWarCapability.CAPABILITY, () -> new CivilWarCapability(living)));
        }
    }

}
