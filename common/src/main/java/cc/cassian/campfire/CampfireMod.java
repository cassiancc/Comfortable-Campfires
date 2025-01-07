package cc.cassian.campfire;

import cc.cassian.campfire.config.ModConfig;
import dev.architectury.injectables.annotations.ExpectPlatform;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.world.World;

import java.util.List;
import java.util.Objects;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public final class CampfireMod {
    public static final String MOD_ID = "comfortable_campfires";
    public static final Logger LOGGER = LogManager.getLogManager().getLogger("Comfortable Campfires");

    public static void init() {
        ModConfig.load();
    }

    public static void applyPlayerEffects(World world, BlockPos pos) {
        if (!world.isClient) {
            int amplifier = 0;

            Box box = new Box(pos).expand(ModConfig.get().distance).stretch(0.0, ModConfig.get().distance, 0.0);
            List<PlayerEntity> list = world.getNonSpectatingEntities(PlayerEntity.class, box);
            StatusEffect statusEffect = checkConfigAndGetEffect();

            for (PlayerEntity playerEntity : list) {
                if (playerEntity.hasStatusEffect(statusEffect)) {
                    if (Objects.requireNonNull(playerEntity.getStatusEffect(statusEffect)).getDuration() < 60) {
                        playerEntity.addStatusEffect(new StatusEffectInstance(statusEffect, ModConfig.get().duration*20, amplifier, true, true));
                    }
                } else {
                    playerEntity.addStatusEffect(new StatusEffectInstance(statusEffect, ModConfig.get().duration*20, amplifier, true, true));
                }
            }
        }
    }

    public static StatusEffect checkConfigAndGetEffect() {
        if (ModConfig.get().useComfort) {
            return getEffect();
        }
        else {
            return StatusEffects.REGENERATION;
        }
    }

    @ExpectPlatform
    public static RegistryEntry<StatusEffect> getEffect() {
        throw new AssertionError();
    }

}
