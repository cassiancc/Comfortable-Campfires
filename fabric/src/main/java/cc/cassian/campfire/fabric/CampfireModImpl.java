package cc.cassian.campfire.fabric;

import cc.cassian.campfire.compat.fabric.FarmersDelightCompat;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffects;
//? if >1.21 {
import net.minecraft.core.Holder;
//?}

public class CampfireModImpl {

    //? if >1.21 {
    public static Holder<MobEffect> getEffect() {
     
    //?} else {
    /*public static StatusEffect getEffect() {
        *///?}
        if (FabricLoader.getInstance().isModLoaded("farmersdelight")) {
            return FarmersDelightCompat.getComfortEffect();
        }
        else return MobEffects.REGENERATION;
    }
}
