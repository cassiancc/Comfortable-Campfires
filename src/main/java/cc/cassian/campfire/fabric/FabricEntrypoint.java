package cc.cassian.campfire.fabric;
//? fabric {

import cc.cassian.campfire.ComfortableCampfires;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;

public class FabricEntrypoint implements ModInitializer {
	@Override
	public void onInitialize() {
		ComfortableCampfires.init();
		ServerLifecycleEvents.SERVER_STARTED.register(server -> ComfortableCampfires.populateEffectMap());
	}
}
//?}
