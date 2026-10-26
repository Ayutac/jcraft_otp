package studio.abos.mc.jcraftotp.api.component.living;

import lombok.NonNull;
import net.arna.jcraft.api.attack.IAttacker;
import net.arna.jcraft.api.component.JComponent;
import net.minecraft.world.entity.LivingEntity;
import studio.abos.mc.jcraftotp.platform.ComponentPlatformUtils;

public interface CommonCivilWarComponent extends JComponent {

    boolean isGhost();

    void setGhost(boolean ghost);

    IAttacker<?,?> getSummoner();

    void setSummoner(final IAttacker<?,?> summoner);

    LivingEntity getTarget();

    void setTarget(final LivingEntity target);

    float getSummonRadius();

    void setSummonRadius(final float summonRadius);

    float getTargetRadius();

    void setTargetRadius(final float targetRadius);

    /**
     * Will create a new (or override an existing) Civil War component (as a ghost) based on the parameters.
     */
    static CommonCivilWarComponent create(final @NonNull LivingEntity living, final @NonNull IAttacker<?,?> summoner, final @NonNull LivingEntity target, final float summonRadius, final float targetRadius) {
        final CommonCivilWarComponent civilWarComponent = ComponentPlatformUtils.getCivilWarComponent(living);
        civilWarComponent.setGhost(true);
        civilWarComponent.setSummoner(summoner);
        civilWarComponent.setTarget(target);
        civilWarComponent.setSummonRadius(summonRadius);
        civilWarComponent.setTargetRadius(targetRadius);
        return civilWarComponent;
    }

}
