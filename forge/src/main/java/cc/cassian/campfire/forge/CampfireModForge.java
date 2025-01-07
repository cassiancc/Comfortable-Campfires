package cc.cassian.campfire.forge;

import cc.cassian.campfire.config.forge.ModConfigFactory;
import net.minecraftforge.client.ConfigScreenHandler;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;

import cc.cassian.campfire.CampfireMod;

@Mod(CampfireMod.MOD_ID)
public final class CampfireModForge {
    public CampfireModForge() {
        CampfireMod.init();
        registerModsPage();
    }

    //Integrate Cloth Config screen (if mod present) with Forge mod menu.
    public static void registerModsPage() {
        if (ModList.get().isLoaded("cloth_config"))
            ModLoadingContext.get().registerExtensionPoint(ConfigScreenHandler.ConfigScreenFactory.class, () -> new ConfigScreenHandler.ConfigScreenFactory(ModConfigFactory::createScreen));
    }
}
