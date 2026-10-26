package studio.abos.mc.jcraftotp.api.registry;

import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EntityType;
import studio.abos.mc.jcraftotp.JCraftOtp;

public interface TagRegistry {

    TagKey<EntityType<?>> DOESNT_CREATE_CW_GHOST = TagKey.create(Registries.ENTITY_TYPE, JCraftOtp.id("doesnt_create_cw_ghost"));

}
