package cc.cassian.campfire;

//? fabric {
import cc.cassian.campfire.fabric.FabricPlatformImpl;
import net.fabricmc.loader.api.FabricLoader;
//?}
import java.nio.file.Path;
//? neoforge {
/*import cc.cassian.campfire.neoforge.NeoforgePlatformImpl;
 *///?}

public interface Platform {

	//? fabric {
	Platform INSTANCE = new FabricPlatformImpl();
	//?}
	//? neoforge {
	/*Platform INSTANCE = new NeoforgePlatformImpl();
	 *///?}


	boolean isModLoaded(String modid);

	String loader();

	Path getConfigFolder();


}