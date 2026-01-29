package cc.cassian.campfire.fabric;

//? fabric {
/*import cc.cassian.campfire.Platform;
import net.fabricmc.loader.api.FabricLoader;
import java.nio.file.Path;

public class FabricPlatformImpl implements Platform {

	@Override
	public boolean isModLoaded(String modid) {
		return FabricLoader.getInstance().isModLoaded(modid);
	}

	@Override
	public String loader() {
		return "fabric";
	}

	public Path getConfigFolder() {
		return FabricLoader.getInstance().getConfigDir();
	}


}
*///?}