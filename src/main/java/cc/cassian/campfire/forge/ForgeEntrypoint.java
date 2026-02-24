package cc.cassian.campfire.forge;
//? forge {
/*import cc.cassian.campfire.ComfortableCampfires;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.server.ServerStartedEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = ComfortableCampfires.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
@Mod(ComfortableCampfires.MOD_ID)
public class ForgeEntrypoint {
	public ForgeEntrypoint() {
		ComfortableCampfires.init();
	}

	@SubscribeEvent
	public static void updateEffectMap(ServerStartedEvent event) {
		ComfortableCampfires.populateEffectMap();
	}

	@SubscribeEvent
	public static void tickCampfire(TickEvent.PlayerTickEvent event) {
		ComfortableCampfires.applyPlayerEffects(event.player);
	}
}
*///?}