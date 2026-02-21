package cc.cassian.campfire.forge;

//? forge {

/*import cc.cassian.campfire.Platform;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.loading.FMLPaths;

import java.nio.file.Path;

public class ForgePlatformImpl implements Platform {

    public boolean isModLoaded(String mod) {
        return ModList.get().isLoaded(mod);
    }

    @Override
    public String loader() {
        return "forge";
    }

    @Override
    public Path getConfigFolder() {
        return FMLPaths.CONFIGDIR.get();
    }

}
*///?}