package studio.abos.mc.jcraftotp.platform.fabric;

import lombok.NonNull;
import lombok.experimental.UtilityClass;
import net.minecraft.world.entity.LivingEntity;
import studio.abos.mc.jcraftotp.api.component.living.CommonCivilWarComponent;
import studio.abos.mc.jcraftotp.fabric.common.component.Components;

@UtilityClass
public class ComponentPlatformUtilsImpl {

    public CommonCivilWarComponent getCivilWarComponent(final @NonNull LivingEntity entity) {
        return Components.CIVIL_WAR.get(entity);
    }

}
