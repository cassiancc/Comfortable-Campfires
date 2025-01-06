package cc.cassian.campfire;

import dev.architectury.injectables.annotations.ExpectPlatform;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.world.World;

import java.util.List;

public final class CampfireMod {
    public static final String MOD_ID = "comfortable_campfires";

    public static void applyPlayerEffects(World world, BlockPos pos) {
        if (!world.isClient) {
            double distance = 3;
            int amplifier = 0;
            int duration = 1800;

            Box box = new Box(pos).expand(distance).stretch(0.0, world.getHeight(), 0.0);
            List<PlayerEntity> list = world.getNonSpectatingEntities(PlayerEntity.class, box);

            for (PlayerEntity playerEntity : list) {
                if (playerEntity.hasStatusEffect(getEffect())) {
                    if (playerEntity.getStatusEffect(getEffect()).getDuration() < 1700) {
                        playerEntity.addStatusEffect(new StatusEffectInstance(getEffect(), duration, amplifier, true, true));
                    }
                } else {
                    playerEntity.addStatusEffect(new StatusEffectInstance(getEffect(), duration, amplifier, true, true));
                }
            }
        }
    }

    @ExpectPlatform
    public static RegistryEntry<StatusEffect> getEffect() {
        throw new AssertionError();
    }

    @ExpectPlatform
    public static boolean isModLoaded(String mod) {
        throw new AssertionError();
    }

}
