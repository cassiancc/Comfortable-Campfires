package cc.cassian.campfire.config.fabric;


import net.fabricmc.loader.api.FabricLoader;

import java.nio.file.Path;

public class ModConfigImpl {
    public static Path configPath() {
        return FabricLoader.getInstance().getConfigDir().resolve("item-descriptions.json");
    }
}
