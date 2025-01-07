package cc.cassian.campfire.config.forge;


import net.minecraftforge.fml.loading.FMLLoader;

import java.nio.file.Path;

import static cc.cassian.campfire.CampfireMod.MOD_ID;

public class ModConfigImpl {
    public static Path configPath() {
        return Path.of(FMLLoader.getGamePath() + "/config").resolve(MOD_ID + ".json");
    }
}
