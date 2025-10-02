package cc.cassian.campfire.compat.neoforge;

import net.minecraft.core.Holder;
import net.minecraft.world.effect.MobEffect;
import vectorwing.farmersdelight.common.registry.ModEffects;

public class FarmersDelightCompat {
    public static Holder<MobEffect> getComfortEffect() {
        return ModEffects.COMFORT;
    }
}
