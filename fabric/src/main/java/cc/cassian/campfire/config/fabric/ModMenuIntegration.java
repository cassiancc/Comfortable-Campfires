package cc.cassian.campfire.config.fabric;

import cc.cassian.campfire.CampfireMod;
import com.terraformersmc.modmenu.api.ConfigScreenFactory;
import com.terraformersmc.modmenu.api.ModMenuApi;
import net.fabricmc.loader.api.FabricLoader;

public class ModMenuIntegration implements ModMenuApi {

    @Override
    public ConfigScreenFactory<?> getModConfigScreenFactory() {
        //Display Cloth Config screen if mod present, else error.
        if (FabricLoader.getInstance().isModLoaded("cloth-config")) return new ModConfigFactory();
        else {
            CampfireMod.LOGGER.warning("User attempted to edit config, but Cloth Config is not present!");
            return parent -> null;
        }
    }
}