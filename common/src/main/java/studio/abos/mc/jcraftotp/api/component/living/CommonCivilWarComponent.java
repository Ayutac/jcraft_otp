package studio.abos.mc.jcraftotp.api.component.living;

import net.arna.jcraft.api.component.JComponent;
import net.minecraft.world.entity.LivingEntity;

public interface CommonCivilWarComponent extends JComponent {

    LivingEntity getTarget();

    void setTarget(LivingEntity target);

}
