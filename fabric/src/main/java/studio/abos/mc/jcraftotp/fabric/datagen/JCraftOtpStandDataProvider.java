package studio.abos.mc.jcraftotp.fabric.datagen;

import studio.abos.mc.jcraftotp.common.register.StandTypeRegistry;
import studio.abos.mc.jcraftotp.common.stand.CivilWarEntity;
import net.arna.jcraft.api.datagen.JCraftStandDataProvider;
import net.arna.jcraft.api.stand.StandData;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.resources.ResourceLocation;

import java.util.function.BiConsumer;

public class JCraftOtpStandDataProvider extends JCraftStandDataProvider {
    public JCraftOtpStandDataProvider(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    protected void configure(BiConsumer<ResourceLocation, StandData> provider) {
        provider.accept(StandTypeRegistry.CIVIL_WAR.getId(), CivilWarEntity.DATA);
    }
}
