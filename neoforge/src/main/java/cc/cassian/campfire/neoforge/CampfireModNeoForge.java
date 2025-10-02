package cc.cassian.campfire.neoforge;

import cc.cassian.campfire.CampfireMod;
import net.neoforged.fml.ModList;
import net.neoforged.fml.ModLoadingContext;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.client.gui.IConfigScreenFactory;

@Mod(CampfireMod.MOD_ID)
public final class CampfireModNeoForge {
    public CampfireModNeoForge() {
        CampfireMod.init();
    }
}
