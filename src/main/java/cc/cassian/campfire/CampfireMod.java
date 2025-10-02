package cc.cassian.campfire;

import cc.cassian.campfire.config.ModConfig;
import dev.architectury.injectables.annotations.ExpectPlatform;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;

import java.util.List;
import java.util.Objects;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public final class CampfireMod {
    public static final String MOD_ID = "comfortable_campfires";
    public static final Logger LOGGER = LogManager.getLogManager().getLogger("Comfortable Campfires");
    public static final ModConfig CONFIG = ModConfig.createToml(ModConfig.configPath(), "", MOD_ID, ModConfig.class);

    public static void init() {

    }

    public static void applyPlayerEffects(Level world, BlockPos pos) {
        if (!world.isClientSide()) {
            int amplifier = CONFIG.amplifier;

            AABB box = new AABB(pos).inflate(CONFIG.distance).expandTowards(0.0, CONFIG.distance, 0.0);
            List<Player> list = world.getEntitiesOfClass(Player.class, box);
            var statusEffect = checkConfigAndGetEffect();

            for (Player playerEntity : list) {
                if (playerEntity.hasEffect(statusEffect)) {
                    if (Objects.requireNonNull(playerEntity.getEffect(statusEffect)).getDuration() < 60) {
                        playerEntity.addEffect(new MobEffectInstance(statusEffect, CONFIG.duration*20, amplifier, true, true));
                    }
                } else {
                    playerEntity.addEffect(new MobEffectInstance(statusEffect, CONFIG.duration*20, amplifier, true, true));
                }
            }
        }
    }

    //? if >1.21 {
    public static Holder<MobEffect> checkConfigAndGetEffect() {
    //?} else {
    /*public static MobEffect checkConfigAndGetEffect() {
    *///?}
        if (CONFIG.useComfort) {
            return getEffect();
        } else {
            return MobEffects.REGENERATION;
        }
    }

    @ExpectPlatform
    //? if >1.21 {
    public static Holder<MobEffect> getEffect() {
    //?} else {
    /*public static StatusEffect getEffect() {
    *///?}
        throw new AssertionError();
    }

}
