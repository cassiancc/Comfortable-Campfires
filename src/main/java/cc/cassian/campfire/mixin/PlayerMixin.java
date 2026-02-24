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

    //? if >1.21.2 {
    public PlayerMixin(Level level, GameProfile gameProfile) {
        super(level, gameProfile);
    }
    //?} else {
    /*public PlayerMixin(Level level, BlockPos pos, float yRot, GameProfile gameProfile) {
        super(level, pos, yRot, gameProfile);
    }
    *///?}

    //? fabric {
    @Inject(method = "tick", at = @At(value = "HEAD"))
    private void mixin(CallbackInfo ci)
    {
        applyPlayerEffects(this);
    }
    //?}

}
