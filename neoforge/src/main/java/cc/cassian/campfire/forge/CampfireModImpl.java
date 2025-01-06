package cc.cassian.campfire.forge;

import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.registry.entry.RegistryEntry;
import net.neoforged.fml.ModList;

public class CampfireModImpl {

    public static RegistryEntry<StatusEffect> getEffect() {
        if (ModList.get().isLoaded("farmersdelight")) {
            return FarmersDelightCompat.getComfortEffect();
        }
        else return StatusEffects.REGENERATION;
    }


}
