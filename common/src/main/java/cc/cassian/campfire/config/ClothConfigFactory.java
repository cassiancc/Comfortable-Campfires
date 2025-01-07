package cc.cassian.campfire.config;


import me.shedaniel.clothconfig2.api.ConfigBuilder;
import me.shedaniel.clothconfig2.api.ConfigCategory;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.Text;

import static cc.cassian.campfire.ModHelpers.*;

public class ClothConfigFactory {

    private static final ModConfig DEFAULT_VALUES = new ModConfig();

    public static Screen create(Screen parent) {
        final var builder = ConfigBuilder.create()
                .setParentScreen(parent)
                .setTitle(Text.translatable("config.item-descriptions.title"));

        final var entryBuilder = builder.entryBuilder();

        for (var field : ModConfig.class.getFields()) {
            ConfigCategory category = builder.getOrCreateCategory(Text.translatable("config.comfortable_campfires.title"));

            if (field.getType() == boolean.class) {
                category.addEntry(entryBuilder.startBooleanToggle(fieldName(field), fieldGet(ModConfig.get(), field))
                        .setSaveConsumer(fieldSetter(ModConfig.get(), field))
                        .setDefaultValue((boolean) fieldGet(DEFAULT_VALUES, field)).build());

            }
            else if (field.getType() == String.class) {
                category.addEntry(entryBuilder.startStrField(fieldName(field), fieldGet(ModConfig.get(), field))
                        .setSaveConsumer(fieldSetter(ModConfig.get(), field))
                        .setDefaultValue((String) fieldGet(DEFAULT_VALUES, field)).build());
            }
            else if (field.getType() == int.class) {
                category.addEntry(entryBuilder.startIntField(fieldName(field), fieldGet(ModConfig.get(), field))
                        .setSaveConsumer(fieldSetter(ModConfig.get(), field))
                        .setDefaultValue((int) fieldGet(DEFAULT_VALUES, field)).build());
            }
        }
        builder.setSavingRunnable(ModConfig::save);
        return builder.build();
    }
}