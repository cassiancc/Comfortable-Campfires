package cc.cassian.campfire.neoforge;

//? neoforge {
/*import cc.cassian.campfire.ComfortableCampfires;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.event.server.ServerLifecycleEvent;
import net.neoforged.neoforge.event.server.ServerStartedEvent;

import static cc.cassian.campfire.ComfortableCampfires.MOD_ID;

@EventBusSubscriber(modid = MOD_ID)
@Mod(MOD_ID)
public class NeoForgeEntrypoint {

	public NeoForgeEntrypoint() {
		ComfortableCampfires.init();
	}

	@SubscribeEvent
	public static void updateEffectMap(ServerStartedEvent event) {
		ComfortableCampfires.populateEffectMap();
	}

}
*///?}