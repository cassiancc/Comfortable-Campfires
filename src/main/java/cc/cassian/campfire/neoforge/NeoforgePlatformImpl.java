package cc.cassian.campfire.neoforge;

//? neoforge {

import cc.cassian.campfire.Platform;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.fml.ModList;
import net.neoforged.fml.loading.FMLEnvironment;
import net.neoforged.fml.loading.FMLPaths;
import net.neoforged.fml.loading.LoadingModList;
import net.neoforged.neoforge.client.event.RegisterGuiLayersEvent;

import java.nio.file.Path;

public class NeoforgePlatformImpl implements Platform {

    public boolean isModLoaded(String mod) {
        return ModList.get().isLoaded(mod);
    }

    @Override
    public String loader() {
        return "neoforge";
    }

    @Override
    public Path getConfigFolder() {
        return FMLPaths.CONFIGDIR.get();
    }

}
//?}