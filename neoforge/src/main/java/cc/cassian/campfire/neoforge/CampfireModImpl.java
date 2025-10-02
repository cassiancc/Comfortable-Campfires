package cc.cassian.campfire.neoforge;

import cc.cassian.campfire.compat.neoforge.FarmersDelightCompat;
import net.minecraft.core.Holder;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffects;
import net.neoforged.fml.ModList;

public class CampfireModImpl {

    public static Holder<MobEffect> getEffect() {
        if (ModList.get().isLoaded("farmersdelight")) {
            return FarmersDelightCompat.getComfortEffect();
        }
        else return MobEffects.REGENERATION;
    }


}
