package studio.abos.mc.jcraftotp.fabric.common.component.impl.living;

import lombok.NonNull;
import net.minecraft.world.entity.LivingEntity;
import studio.abos.mc.jcraftotp.common.component.impl.CommonCivilWarComponentImpl;
import studio.abos.mc.jcraftotp.fabric.common.component.living.CivilWarComponent;

public class CivilWarComponentImpl extends CommonCivilWarComponentImpl implements CivilWarComponent {

    public CivilWarComponentImpl(final @NonNull LivingEntity living) {
        super(living);
    }

}
