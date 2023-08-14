package ca.teamdman.extant_void.datagen;

import ca.teamdman.extant_void.ExtantVoid;
import net.minecraft.core.HolderLookup;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.data.event.GatherDataEvent;

public class MyBlockTags extends BlockTagsProvider {
    public MyBlockTags(GatherDataEvent event) {
        super(
                event.getGenerator().getPackOutput(),
                event.getLookupProvider(),
                ExtantVoid.MOD_ID,
                event.getExistingFileHelper()
        );
    }

    @Override
    public String getName() {
        return "Extant Void Tags";
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {

    }
}
