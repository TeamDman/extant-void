package ca.teamdman.extant_void.datagen;

import ca.teamdman.extant_void.ExtantVoid;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.data.loading.DatagenModLoader;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = ExtantVoid.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)

public class MyDatagen {
    @SubscribeEvent
    public static void onGather(GatherDataEvent event) {
        if (!DatagenModLoader.isRunningDataGen()) return;
        if (event.includeServer()) {
            event.getGenerator().addProvider(event.includeClient(), new MyBlockStatesAndModels(event));
            event.getGenerator().addProvider(event.includeClient(), new MyItemModels(event));
            event.getGenerator().addProvider(event.includeClient(), new MyBlockTags(event));
            event.getGenerator().addProvider(event.includeClient(), new MyLootTables(event));
            event.getGenerator().addProvider(event.includeClient(), new MyRecipes(event));
            event.getGenerator().addProvider(event.includeClient(), new MyLanguageProvider(event));
        }
    }
}
