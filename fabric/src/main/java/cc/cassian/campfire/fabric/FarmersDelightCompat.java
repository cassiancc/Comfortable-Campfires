package cc.cassian.campfire.fabric;

import com.nhoryzon.mc.farmersdelight.registry.EffectsRegistry;
import net.minecraft.entity.effect.StatusEffect;

public class FarmersDelightCompat {
    public static StatusEffect getComfortEffect() {
        return EffectsRegistry.COMFORT.get();
    }
}
