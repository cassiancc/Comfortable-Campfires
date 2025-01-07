package cc.cassian.campfire.forge;

import cc.cassian.campfire.compat.forge.FarmersDelightCompat;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraftforge.fml.ModList;

public class CampfireModImpl {

    public static StatusEffect getEffect() {
        if (ModList.get().isLoaded("farmersdelight")) {
            return FarmersDelightCompat.getComfortEffect();
        }
        else return StatusEffects.REGENERATION;
    }


}
