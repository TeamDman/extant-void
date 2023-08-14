package ca.teamdman.extant_void.datagen;

import ca.teamdman.extant_void.ExtantVoid;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.registries.RegistryObject;

public class MyItemModels extends ItemModelProvider {
    public MyItemModels(
            GatherDataEvent event
    ) {
        super(event.getGenerator().getPackOutput(), ExtantVoid.MOD_ID, event.getExistingFileHelper());
    }

    @Override
    protected void registerModels() {
        justParent(ExtantVoid.ANTIBLOCK_ITEM, ExtantVoid.ANTIBLOCK_BLOCK);
    }

    private void justParent(
            RegistryObject<? extends Item> item, RegistryObject<? extends Block> block
    ) {
        justParent(item, block, "");
    }

    private void justParent(
            RegistryObject<? extends Item> item, RegistryObject<? extends Block> block, String extra
    ) {
        withExistingParent(block.getId().getPath(), ExtantVoid.MOD_ID + ":block/" + item.getId().getPath() + extra);
    }

    private void basicItem(
            RegistryObject<? extends Item> item
    ) {
        withExistingParent(item.getId().getPath(), mcLoc("item/generated")).texture(
                "layer0",
                modLoc("item/" + item
                        .getId()
                        .getPath())
        );
    }
}
