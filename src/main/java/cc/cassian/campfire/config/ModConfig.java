package cc.cassian.campfire.config;

import folk.sisby.kaleido.api.WrappedConfig;
import folk.sisby.kaleido.lib.quiltconfig.api.annotations.Comment;
import folk.sisby.kaleido.lib.quiltconfig.api.values.ValueMap;

import java.util.Map;

public class ModConfig extends WrappedConfig {

    //General settings
    @Comment("Maximum distance from campfire")
    public int distance = 3;
    @Comment("Maximum duration of effect")
    public int duration = 5;
    @Comment("Amplifier of effect")
    public int amplifier = 0;
    @Comment("What effects should be applied")
    public Map<String, String> effects = ValueMap.builder("").put("minecraft:campfire", "minecraft:regeneration").put("minecraft:soul_campfire", "minecraft:regeneration").build();
}