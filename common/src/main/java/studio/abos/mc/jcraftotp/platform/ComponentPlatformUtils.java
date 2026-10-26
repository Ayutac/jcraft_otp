package studio.abos.mc.jcraftotp.platform;

import dev.architectury.injectables.annotations.ExpectPlatform;
import lombok.NonNull;
import lombok.experimental.UtilityClass;
import net.minecraft.world.entity.LivingEntity;
import studio.abos.mc.jcraftotp.api.component.living.CommonCivilWarComponent;

@UtilityClass
public class ComponentPlatformUtils {

    @ExpectPlatform
    public CommonCivilWarComponent getCivilWarComponent(final @NonNull LivingEntity entity) {
        throw new AssertionError("This shouldn't happen!");
    }

}
