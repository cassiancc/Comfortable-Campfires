package cc.cassian.campfire;

import cc.cassian.campfire.config.ModConfig;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;

public final class ComfortableCampfires {
    public static final String MOD_ID = "comfortable_campfires";
    public static final Logger LOGGER = LogManager.getLogger("Comfortable Campfires");
    public static final ModConfig CONFIG = ModConfig.createToml(Platform.INSTANCE.getConfigFolder(), "", MOD_ID, ModConfig.class);
    public static final LinkedHashMap<Block,
            //? if >1.21 {
            Holder<MobEffect>
            //?} else
            /*MobEffect*/
            > EFFECT_MAP = new LinkedHashMap<>();


    public static void applyPlayerEffects(Level world, BlockState blockState, Player playerEntity) {
        if (!world.isClientSide()) {
            int amplifier = CONFIG.amplifier;

            var statusEffect = checkConfigAndGetEffect(blockState);

            if (playerEntity.hasEffect(statusEffect)) {
                if (Objects.requireNonNull(playerEntity.getEffect(statusEffect)).getDuration() < 60) {
                    playerEntity.addEffect(new MobEffectInstance(statusEffect, CONFIG.duration*20, amplifier, true, true));
                }
            } else {
                playerEntity.addEffect(new MobEffectInstance(statusEffect, CONFIG.duration*20, amplifier, true, true));
            }
        }
    }

    public static void populateEffectMap() {
        ComfortableCampfires.LOGGER.info("Updating effects from config.");
        EFFECT_MAP.clear();
        CONFIG.effects.forEach((blockKey, effectKey)-> {
            var blockHolder = ComfortableCampfires.getFromRegistry(BuiltInRegistries.BLOCK, parse(blockKey));
            var effect = getFromRegistry(BuiltInRegistries.MOB_EFFECT, parse(effectKey));
            if (blockHolder.isPresent()) {
                if (effect.isPresent())
                    EFFECT_MAP.put(blockHolder.get()
                            //? if >1.21
                            .value()
                            , effect.get());
                else
                    EFFECT_MAP.put(blockHolder.get()
                            //? if >1.21
                            .value()
                            , MobEffects.REGENERATION);
            }
        });
    }

    public static
    //? if >1.21 {
    Holder<MobEffect>
    //?} else
    /*MobEffect*/
    checkConfigAndGetEffect(BlockState blockState) {
        return EFFECT_MAP.getOrDefault(blockState.getBlock(), MobEffects.REGENERATION);
    }

    // static init the config
	public static void init() {
		//noop
	}

    //? if >1.21.2 {
    static <T> Optional<Holder.Reference<T>> getFromRegistry(Registry<T> registry, Identifier name) {
        return registry.get(name);
    }
    //?} else if >1.21 {
    /*static <T> Optional<Holder.Reference<T>> getFromRegistry(Registry<T> registry, Identifier name) {
        return registry.getHolder(name);
    }
    *///?} else {
    /*static <T> Optional<T> getFromRegistry(Registry<T> registry, Identifier name) {
        return registry.getOptional(name);
    }
    *///?}

    private static Identifier parse(String string) {
        //? if >1.21 {
        return Identifier.parse(string);
        //?} else {
        /*return new Identifier(string);
        *///?}
    }
}
