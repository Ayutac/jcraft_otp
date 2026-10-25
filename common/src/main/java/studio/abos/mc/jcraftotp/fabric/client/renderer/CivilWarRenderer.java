package studio.abos.mc.jcraftotp.fabric.client.renderer;

import studio.abos.mc.jcraftotp.common.register.StandTypeRegistry;
import studio.abos.mc.jcraftotp.common.stand.CivilWarEntity;
import net.arna.jcraft.client.renderer.entity.stands.StandEntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

public class CivilWarRenderer extends StandEntityRenderer<CivilWarEntity> {
    public CivilWarRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, StandTypeRegistry.CIVIL_WAR.get());
    }
}
