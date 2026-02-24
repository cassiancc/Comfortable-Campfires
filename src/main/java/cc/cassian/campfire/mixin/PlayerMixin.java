package cc.cassian.campfire.mixin;

import com.mojang.authlib.GameProfile;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import static cc.cassian.campfire.ComfortableCampfires.*;

@Mixin(ServerPlayer.class)
public abstract class PlayerMixin extends Player {
    public PlayerMixin(Level level, GameProfile gameProfile) {
        super(level, gameProfile);
    }

    @Inject(method = "tick", at = @At(value = "HEAD"))
    private void mixin(CallbackInfo ci)
    {
        AABB box = new AABB(BlockPos.containing(position())).inflate(CONFIG.distance).expandTowards(0.0, CONFIG.distance, 0.0);
        level().getBlockStatesIfLoaded(box).forEach(blockState -> {
            if (VALID_BLOCKS.contains(blockState.getBlock())) {
                applyPlayerEffects(level(), blockState, this);
            }
        });
    }

}
