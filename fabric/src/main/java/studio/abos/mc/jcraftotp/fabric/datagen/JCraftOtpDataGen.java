package studio.abos.mc.jcraftotp.fabric.datagen;

import studio.abos.mc.jcraftotp.fabric.datagen.movesets.CivilWarMoveSetProvider;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

public class JCraftOtpDataGen implements DataGeneratorEntrypoint {
    @Override
    public void onInitializeDataGenerator(FabricDataGenerator dataGen) {
        FabricDataGenerator.Pack pack = dataGen.createPack();
        pack.addProvider(CivilWarMoveSetProvider::new);
        pack.addProvider(JCraftOtpStandDataProvider::new);
    }
}
