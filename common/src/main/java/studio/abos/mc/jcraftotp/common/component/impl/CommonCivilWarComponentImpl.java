package studio.abos.mc.jcraftotp.common.component.impl;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.LivingEntity;
import studio.abos.mc.jcraftotp.api.component.living.CommonCivilWarComponent;

public abstract class CommonCivilWarComponentImpl implements CommonCivilWarComponent {

    protected final @NonNull LivingEntity living;
    @Getter
    @Setter
    protected LivingEntity target;

    public CommonCivilWarComponentImpl(final @NonNull LivingEntity living) {
        this.living = living;
    }

    @Override
    public void readFromNbt(@NonNull final CompoundTag compoundTag) {

    }

    @Override
    public void writeToNbt(@NonNull final CompoundTag compoundTag) {

    }

    public void tick() {
        if (target == null || target.isDeadOrDying()) {
            living.discard();
        }
    }

}
