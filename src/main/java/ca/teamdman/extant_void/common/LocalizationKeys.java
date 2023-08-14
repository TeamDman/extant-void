package ca.teamdman.extant_void.common;

import ca.teamdman.extant_void.ExtantVoid;
import net.minecraft.client.resources.language.I18n;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.network.chat.contents.TranslatableContents;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public final class LocalizationKeys {
//    public static final LocalizationEntry PROGRAM_EDIT_SCREEN_TITLE = new LocalizationEntry(
//            "gui.sfm.text_editor.title",
//            "Text Editor"
//    );
//
//    @SuppressWarnings("unused") // used by minecraft without us having to directly reference
//    public static LocalizationEntry CABLE_BLOCK = new LocalizationEntry(
//            () -> SFMBlocks.CABLE_BLOCK.get().getDescriptionId(),
//            () -> "Inventory Cable"
//    );

    public static LocalizationEntry ANTIBLOCK_BLOCK = new LocalizationEntry(
            () -> ExtantVoid.ANTIBLOCK_BLOCK.get().getDescriptionId(),
            () -> "Anti-block"
    );

    public static List<LocalizationEntry> getEntries() {
        // use reflection to get all the public static LocalizationEntry fields
        var rtn = new ArrayList<LocalizationEntry>();
        for (var field : LocalizationKeys.class.getFields()) {
            if (field.getType() == LocalizationEntry.class) {
                try {
                    rtn.add((LocalizationEntry) field.get(null));
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
        return rtn;
    }

    public record LocalizationEntry(
            Supplier<String> key,
            Supplier<String> value
    ) {
        public LocalizationEntry(String key, String value) {
            this(() -> key, () -> value);
        }

        public TranslatableContents get(Object... args) {
            return new TranslatableContents(key.get(), null, args);
        }

        public TranslatableContents get() {
            return new TranslatableContents(key.get(), null, new Object[]{});
        }

        public String getString() {
            return I18n.get(key.get());
        }

        public String getString(Object... args) {
            return I18n.get(key.get(), args);
        }

        public MutableComponent getComponent() {
            return Component.translatable(key.get());
        }

        public MutableComponent getComponent(Object... args) {
            return Component.translatable(key.get(), args);
        }
    }
}
