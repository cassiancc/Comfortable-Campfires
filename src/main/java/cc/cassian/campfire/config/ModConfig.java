package cc.cassian.campfire.config;

import folk.sisby.kaleido.api.WrappedConfig;
import folk.sisby.kaleido.lib.quiltconfig.api.annotations.Comment;

import java.nio.file.Path;

public class ModConfig extends WrappedConfig {

    //General settings
    @Comment("Maximum distance from campfire")
    public int distance = 3;
    @Comment("Maximum duration of effect")
    public int duration = 5;
    @Comment("Amplifier of effect")
    public int amplifier = 0;
    @Comment("Give Comfort effect instead of Regeneration.")
    public boolean useComfort = true;
}