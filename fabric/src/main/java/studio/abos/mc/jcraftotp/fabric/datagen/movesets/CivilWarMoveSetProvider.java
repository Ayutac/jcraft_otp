package studio.abos.mc.jcraftotp.fabric.datagen.movesets;

import studio.abos.mc.jcraftotp.api.registry.StandTypeRegistry;
import studio.abos.mc.jcraftotp.common.stand.CivilWarEntity;
import net.arna.jcraft.api.attack.MoveMap;
import net.arna.jcraft.api.attack.MoveSet;
import net.arna.jcraft.api.datagen.JCraftMoveSetProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;

import java.util.function.Consumer;

public class CivilWarMoveSetProvider extends JCraftMoveSetProvider<CivilWarEntity, CivilWarEntity.State> {

    public CivilWarMoveSetProvider(FabricDataOutput dataOutput) {
        super(dataOutput, MoveMap.Entry.codecFor(CivilWarEntity.State.class), StandTypeRegistry.CIVIL_WAR.getId());
    }

    @Override
    protected void configureMoveSets(Consumer<MoveSet<CivilWarEntity, CivilWarEntity.State>> provider) {
        provider.accept(CivilWarEntity.MOVE_SET);
    }

}
