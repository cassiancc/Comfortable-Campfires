package cc.cassian.campfire;

import cc.cassian.campfire.config.ModConfig;
import net.minecraft.core.BlockPos;
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
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public final class ComfortableCampfires {
    public static final String MOD_ID = "comfortable_campfires";
    public static final Logger LOGGER = LogManager.getLogManager().getLogger("Comfortable Campfires");
    public static final ModConfig CONFIG = ModConfig.createToml(Platform.INSTANCE.getConfigFolder(), "", MOD_ID, ModConfig.class);
    public static final List<Block> VALID_BLOCKS = List.of(Blocks.CAMPFIRE, Blocks.SOUL_CAMPFIRE);


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

    public static
    //? if >1.21 {
    Holder<MobEffect>
    //?} else
    /*MobEffect*/
    checkConfigAndGetEffect(BlockState blockState) {
        var id = BuiltInRegistries.BLOCK.getKey(blockState.getBlock()).toString();
        if (CONFIG.effects.containsKey(id)) {
			var result = getFromRegistry(BuiltInRegistries.MOB_EFFECT, parse(CONFIG.effects.get(id)));
            if (result.isPresent()) {
                return result.get();
            }
        }
        return MobEffects.REGENERATION;
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

    public static Identifier parse(String string) {
        //? if >1.21 {
        return Identifier.parse(string);
        //?} else {
        /*return new Identifier(string);
        *///?}
    }
}
