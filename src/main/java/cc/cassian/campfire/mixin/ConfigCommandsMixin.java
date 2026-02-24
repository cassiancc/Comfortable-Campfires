package cc.cassian.campfire.mixin;

import com.lx862.qomc.ConfigCommands;
import com.lx862.qomc.core.ValueType;
import com.mojang.brigadier.context.CommandContext;
import folk.sisby.kaleido.lib.quiltconfig.api.values.TrackedValue;
import folk.sisby.kaleido.lib.quiltconfig.api.values.ValueMap;
import net.minecraft.commands.CommandSourceStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Pseudo;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import static cc.cassian.campfire.ComfortableCampfires.*;

@Pseudo
@Mixin(ConfigCommands.class)
public class ConfigCommandsMixin {

	@Inject(method = "configSetMap", at = @At(value = "RETURN"))
	private static <T> void mixin(CommandContext<CommandSourceStack> ctx, TrackedValue<ValueMap<T>> value, String key, T item, ValueType childType, CallbackInfoReturnable<Integer> cir)
	{
		if (ctx.getInput().contains("comfortable_campfires")) {
			populateEffectMap();
		}
	}
}
