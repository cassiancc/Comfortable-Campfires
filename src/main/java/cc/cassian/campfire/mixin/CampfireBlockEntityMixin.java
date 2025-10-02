package cc.cassian.campfire.mixin;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.item.crafting.CampfireCookingRecipe;
import net.minecraft.world.item.crafting.RecipeManager;
import net.minecraft.world.item.crafting.SingleRecipeInput;
import net.minecraft.world.level.block.entity.CampfireBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import static cc.cassian.campfire.CampfireMod.applyPlayerEffects;

@Mixin(CampfireBlockEntity.class)
public class CampfireBlockEntityMixin {
    @Inject(method = "cookTick", at = @At(value = "HEAD"))
    //? if >1.21.2 {
    private static void mixin(ServerLevel serverLevel, BlockPos pos, BlockState blockState, CampfireBlockEntity campfireBlockEntity, RecipeManager.CachedCheck<SingleRecipeInput, CampfireCookingRecipe> cachedCheck, CallbackInfo ci)

        //?} else {
        /*private static void mixin(ServerLevel world, BlockPos pos, BlockState state, CampfireBlockEntity campfire, CallbackInfo ci)
         *///?}
    {
        applyPlayerEffects(serverLevel, pos);
    }

}
