package studio.abos.mc.jcraftotp.common.component.impl;

import lombok.NonNull;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.LivingEntity;
import studio.abos.mc.jcraftotp.api.component.living.CommonCivilWarComponent;

public abstract class CommonCivilWarComponentImpl implements CommonCivilWarComponent {

    protected final @NonNull LivingEntity living;

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

    }

}
