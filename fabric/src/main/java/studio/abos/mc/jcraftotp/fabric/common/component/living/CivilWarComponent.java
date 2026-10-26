package studio.abos.mc.jcraftotp.fabric.common.component.living;

import dev.onyxstudios.cca.api.v3.component.Component;
import dev.onyxstudios.cca.api.v3.component.sync.AutoSyncedComponent;
import dev.onyxstudios.cca.api.v3.component.tick.CommonTickingComponent;
import studio.abos.mc.jcraftotp.api.component.living.CommonCivilWarComponent;

public interface CivilWarComponent extends CommonCivilWarComponent, Component, AutoSyncedComponent, CommonTickingComponent {
    // intentionally left empty
}
