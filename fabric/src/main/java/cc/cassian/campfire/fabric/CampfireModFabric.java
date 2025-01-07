package cc.cassian.campfire.fabric;

import net.fabricmc.api.ModInitializer;

import cc.cassian.campfire.CampfireMod;

public final class CampfireModFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        CampfireMod.init();
    }
}
