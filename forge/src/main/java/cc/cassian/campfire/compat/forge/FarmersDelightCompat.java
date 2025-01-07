package cc.cassian.campfire.compat.forge;

import net.minecraft.entity.effect.StatusEffect;
import vectorwing.farmersdelight.common.registry.ModEffects;

public class FarmersDelightCompat {
    public static StatusEffect getComfortEffect() {
        return ModEffects.COMFORT.get();
    }
}
