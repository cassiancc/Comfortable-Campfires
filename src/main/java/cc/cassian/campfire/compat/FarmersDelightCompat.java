package cc.cassian.campfire.compat;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.core.Holder;
import vectorwing.farmersdelight.common.registry.ModEffects;

public class FarmersDelightCompat {

    public static Holder<MobEffect> getComfortEffect() {
        return ModEffects.COMFORT;
     }
}
