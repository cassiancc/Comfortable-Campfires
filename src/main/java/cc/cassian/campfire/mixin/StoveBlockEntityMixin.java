package cc.cassian.campfire.mixin;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.item.crafting.CampfireCookingRecipe;
import net.minecraft.world.item.crafting.RecipeManager;
import net.minecraft.world.item.crafting.SingleRecipeInput;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.CampfireBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Pseudo;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import vectorwing.farmersdelight.common.block.StoveBlock;
import vectorwing.farmersdelight.common.block.entity.StoveBlockEntity;

import static cc.cassian.campfire.ComfortableCampfires.applyPlayerEffects;

@Pseudo
@Mixin(StoveBlockEntity.class)
public class StoveBlockEntityMixin {
    @Inject(method = "cookingTick", at = @At(value = "HEAD"))
    private static void mixin(Level level, BlockPos pos, BlockState blockState, StoveBlockEntity stove, CallbackInfo ci)
    {
        boolean isStoveLit = blockState.getValue(StoveBlock.LIT);
        if (isStoveLit)
            applyPlayerEffects(level, pos, blockState);
    }

}
