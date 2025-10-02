package cc.cassian.campfire.compat.fabric;

import net.minecraft.world.effect.MobEffect;
//? if >1.21 {
import net.minecraft.core.Holder;
//?}
//? if >1.20 {
import vectorwing.farmersdelight.common.registry.ModEffects;
//?} else {
/*import com.nhoryzon.mc.farmersdelight.registry.EffectsRegistry;
*///?}

public class FarmersDelightCompat {

    public static
    //? if >1.21 {
    Holder<MobEffect> getComfortEffect() {
        return ModEffects.COMFORT;
    
    //?} else if >1.20 {
     /*MobEffect getComfortEffect() {
         return ModEffects.COMFORT.get();

         *///?} else {
         /*MobEffect getComfortEffect() {
             return EffectsRegistry.COMFORT.get();
         *///?}
     }
}
