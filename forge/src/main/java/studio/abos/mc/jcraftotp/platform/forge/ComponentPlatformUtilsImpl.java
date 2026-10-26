package studio.abos.mc.jcraftotp.platform.forge;

import lombok.experimental.UtilityClass;
import net.minecraft.world.entity.LivingEntity;
import studio.abos.mc.jcraftotp.api.component.living.CommonCivilWarComponent;
import studio.abos.mc.jcraftotp.forge.capability.impl.living.CivilWarCapability;

@UtilityClass
public class ComponentPlatformUtilsImpl {

    public CommonCivilWarComponent getCivilWarComponent(final LivingEntity entity) {
        return CivilWarCapability.getCapability(entity);
    }

}
