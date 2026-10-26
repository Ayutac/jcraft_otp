package studio.abos.mc.jcraftotp.fabric.datagen;

import lombok.experimental.UtilityClass;
import net.arna.jcraft.api.registry.JEntityTypeRegistry;
import net.arna.jcraft.api.registry.JTagRegistry;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.core.HolderLookup;
import studio.abos.mc.jcraftotp.api.registry.TagRegistry;

import java.util.concurrent.CompletableFuture;

@UtilityClass
public class TagProviders {

    public class EntitiyTags extends FabricTagProvider.EntityTypeTagProvider {

        public EntitiyTags(final FabricDataOutput output, final CompletableFuture<HolderLookup.Provider> provider) {
            super(output, provider);
        }

        @Override
        protected void addTags(final HolderLookup.Provider provider) {
            final var doesntCreateCwGhosts = getOrCreateTagBuilder(TagRegistry.DOESNT_CREATE_CW_GHOST);
            doesntCreateCwGhosts.forceAddTag(JTagRegistry.STANDS);
            doesntCreateCwGhosts.add(JEntityTypeRegistry.TRAINING_DUMMY.getId());
            doesntCreateCwGhosts.add(JEntityTypeRegistry.BLOCK_PROJECTILE.getId());
            doesntCreateCwGhosts.add(JEntityTypeRegistry.HG_NET.getId());
            doesntCreateCwGhosts.add(JEntityTypeRegistry.HAMON_WAVE.getId());
            doesntCreateCwGhosts.add(JEntityTypeRegistry.LIFE_DETECTOR.getId());
            doesntCreateCwGhosts.add(JEntityTypeRegistry.RED_BIND.getId());
            doesntCreateCwGhosts.add(JEntityTypeRegistry.SAND_TORNADO.getId());
            doesntCreateCwGhosts.add(JEntityTypeRegistry.SHEER_HEART_ATTACK.getId());
            doesntCreateCwGhosts.add(JEntityTypeRegistry.GER_SCORPION.getId());
            doesntCreateCwGhosts.add(JEntityTypeRegistry.GE_BUTTERFLY.getId());
            doesntCreateCwGhosts.add(JEntityTypeRegistry.GE_SNAKE.getId());
            doesntCreateCwGhosts.add(JEntityTypeRegistry.GE_FROG.getId());
            doesntCreateCwGhosts.add(JEntityTypeRegistry.GE_TREE.getId());
            doesntCreateCwGhosts.add(JEntityTypeRegistry.GE_VINES.getId());
            doesntCreateCwGhosts.add(JEntityTypeRegistry.ROAD_ROLLER.getId());
            doesntCreateCwGhosts.add(JEntityTypeRegistry.PLAYER_CLONE.getId());
        }

    }

}
