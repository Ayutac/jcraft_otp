package studio.abos.mc.jcraftotp.mixin;

import com.llamalad7.mixinextras.injector.wrapmethod.WrapMethod;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import net.minecraft.world.entity.LivingEntity;
import org.spongepowered.asm.mixin.Mixin;
import studio.abos.mc.jcraftotp.api.component.living.CommonCivilWarComponent;
import studio.abos.mc.jcraftotp.platform.ComponentPlatformUtils;

@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin {

    @WrapMethod(method = "setLastHurtByMob(Lnet/minecraft/world/entity/LivingEntity;)V")
    public void jcraftotp$dontChangeGhostTarget(final LivingEntity livingEntity, final Operation<Void> original) {
        final LivingEntity living = (LivingEntity)(Object)this;
        final CommonCivilWarComponent civilWarComponent = ComponentPlatformUtils.getCivilWarComponent(living);
        if (living.getLastHurtByMob() == null || !civilWarComponent.isGhost() || civilWarComponent.getTarget() == livingEntity) {
            original.call(livingEntity);
        }
    }

}
