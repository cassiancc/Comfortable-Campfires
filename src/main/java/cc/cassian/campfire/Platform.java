package cc.cassian.campfire;

//? fabric {
import cc.cassian.campfire.fabric.FabricPlatformImpl;
import net.fabricmc.loader.api.FabricLoader;
//?}
import java.nio.file.Path;
//? neoforge {
/*import cc.cassian.campfire.neoforge.NeoforgePlatformImpl;
*///?}
//? forge {
/*import cc.cassian.campfire.forge.ForgePlatformImpl;
*///?}

public interface Platform {

	//? fabric {
	Platform INSTANCE = new FabricPlatformImpl();
	//?}
	//? neoforge {
	/*Platform INSTANCE = new NeoforgePlatformImpl();
	 *///?}
	//? forge {
	/*Platform INSTANCE = new ForgePlatformImpl();
	 *///?}


	boolean isModLoaded(String modid);

	String loader();

	Path getConfigFolder();


}