package cc.cassian.campfire.compat.fabric;

import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.registry.entry.RegistryEntry;
import vectorwing.farmersdelight.common.registry.ModEffects;

public class FarmersDelightCompat {
    public static RegistryEntry<StatusEffect> getComfortEffect() {
        return ModEffects.COMFORT;
    }
}
