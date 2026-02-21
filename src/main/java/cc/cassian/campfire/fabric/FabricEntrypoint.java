package cc.cassian.campfire.fabric;
//? fabric {

import cc.cassian.campfire.ComfortableCampfires;
import net.fabricmc.api.ModInitializer;

public class FabricEntrypoint implements ModInitializer {
	@Override
	public void onInitialize() {
		ComfortableCampfires.init();
	}
}
//?}
