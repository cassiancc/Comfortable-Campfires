package cc.cassian.campfire.compat.fabric;

import net.minecraft.entity.effect.StatusEffect;
//? if >1.21 {
import net.minecraft.registry.entry.RegistryEntry;
//?}

//? if >1.20 {
import vectorwing.farmersdelight.common.registry.ModEffects;
//?} else {
/*import com.nhoryzon.mc.farmersdelight.registry.EffectsRegistry;
*///?}

public class FarmersDelightCompat {

    public static
    //? if >1.21 {
     RegistryEntry<StatusEffect> getComfortEffect() {
        return ModEffects.COMFORT;
    
    //?} else if >1.20 {
     /*StatusEffect getComfortEffect() {
         return ModEffects.COMFORT.get();

         *///?} else {
         /*StatusEffect getComfortEffect() {
             return EffectsRegistry.COMFORT.get();
         *///?}
     }
}
