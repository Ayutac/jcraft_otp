package studio.abos.mc.jcraftotp.forge.capability.impl.living;

import lombok.NonNull;
import net.arna.jcraft.forge.capability.api.JCapability;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.CapabilityToken;
import net.minecraftforge.common.util.LazyOptional;
import studio.abos.mc.jcraftotp.common.component.impl.CommonCivilWarComponentImpl;

public class CivilWarCapability extends CommonCivilWarComponentImpl implements JCapability {

    public static Capability<CivilWarCapability> CAPABILITY = CapabilityManager.get(new CapabilityToken<>() {});

    public CivilWarCapability(final @NonNull LivingEntity living) {
        super(living);
    }

    @Override
    public CompoundTag serializeNBT() {
        CompoundTag tag = new CompoundTag();
        super.writeToNbt(tag);
        return tag;
    }

    @Override
    public void deserializeNBT(final CompoundTag tag) {
        super.readFromNbt(tag);
    }

    public static LazyOptional<CivilWarCapability> getCapabilityOptional(final Entity entity) {
        return entity.getCapability(CAPABILITY);
    }
    public static CivilWarCapability getCapability(final LivingEntity entity) {
        return entity.getCapability(CAPABILITY).orElse(new CivilWarCapability(entity));
    }

}
