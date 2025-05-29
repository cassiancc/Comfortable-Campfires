package cc.cassian.campfire;

import net.minecraft.text.Text;

import java.lang.reflect.Field;
import java.util.function.Consumer;

import static cc.cassian.campfire.CampfireMod.MOD_ID;

public class ModHelpers {

    // Automatically generate translation keys for config options.
    public static Text fieldName(Field field) {
        return Text.translatable("config."+MOD_ID+".config." + field.getName());
    }

    // Get the current value of a config field.
    @SuppressWarnings("unchecked")
    public static <T> T fieldGet(Object instance, Field field) {
        try {
            return (T) field.get(instance);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    // Set a config field.
    public static <T> Consumer<T> fieldSetter(Object instance, Field field) {
        return t -> {
            try {
                field.set(instance, t);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        };
    }
}
