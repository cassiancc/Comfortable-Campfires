package cc.cassian.campfire.fabric;
//? fabric {

import cc.cassian.campfire.CampfireMod;
import net.fabricmc.api.ModInitializer;

public class FabricEntrypoint implements ModInitializer {
	@Override
	public void onInitialize() {
		CampfireMod.init();
	}
}
//?}
