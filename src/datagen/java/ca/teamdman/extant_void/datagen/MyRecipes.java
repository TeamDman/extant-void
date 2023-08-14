package ca.teamdman.extant_void.datagen;

import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraftforge.data.event.GatherDataEvent;

import java.util.function.Consumer;

public class MyRecipes extends RecipeProvider {
    public MyRecipes(GatherDataEvent event) {
        super(event.getGenerator().getPackOutput());
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> consumer) {
    }

}
