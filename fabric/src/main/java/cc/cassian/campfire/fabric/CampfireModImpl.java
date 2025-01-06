package cc.cassian.campfire.fabric;

import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.registry.entry.RegistryEntry;

public class CampfireModImpl {

    public static RegistryEntry<StatusEffect> getEffect() {
        if (FabricLoader.getInstance().isModLoaded("farmersdelight")) {
            return FarmersDelightCompat.getComfortEffect();
        }
        else return StatusEffects.REGENERATION;
    }
}
