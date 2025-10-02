package cc.cassian.campfire.config.neoforge;

import net.neoforged.fml.loading.FMLPaths;

import java.nio.file.Path;

public class ModConfigImpl {
    public static Path configPath() {
        return FMLPaths.CONFIGDIR.get();
    }
}
