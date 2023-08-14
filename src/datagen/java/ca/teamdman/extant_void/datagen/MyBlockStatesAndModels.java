package ca.teamdman.extant_void.datagen;

import ca.teamdman.extant_void.ExtantVoid;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.data.event.GatherDataEvent;

public class MyBlockStatesAndModels extends BlockStateProvider {
    public MyBlockStatesAndModels(GatherDataEvent event) {
        super(event.getGenerator().getPackOutput(), ExtantVoid.MOD_ID, event.getExistingFileHelper());
    }

    @Override
    protected void registerStatesAndModels() {
        simpleBlock(ExtantVoid.ANTIBLOCK_BLOCK.get());
    }
}
