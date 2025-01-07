package cc.cassian.campfire.neoforge;

import cc.cassian.campfire.CampfireMod;
import cc.cassian.campfire.config.neoforge.ModConfigFactory;
import net.neoforged.fml.ModList;
import net.neoforged.fml.ModLoadingContext;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.client.gui.IConfigScreenFactory;

@Mod(CampfireMod.MOD_ID)
public final class CampfireModNeoForge {
    public CampfireModNeoForge() {
        CampfireMod.init();
        registerModsPage();
    }

    //Integrate Cloth Config screen (if mod present) with NeoForge mod menu.
    public void registerModsPage() {
        if (ModList.get().isLoaded("cloth_config")) ModLoadingContext.get().registerExtensionPoint(IConfigScreenFactory.class, ModConfigFactory::new);
    }
}
