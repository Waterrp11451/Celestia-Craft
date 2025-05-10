package net.waterrp11451.celestiacraft.data;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.waterrp11451.celestiacraft.block.ModBlocks;
import net.waterrp11451.celestiacraft.item.Moditems;

import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider {

    //https://docs.neoforged.net/docs/datagen/server/recipes
    public ModRecipeProvider(PackOutput pPackOutput, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(pPackOutput, lookupProvider);
    }

    @Override
    protected void buildRecipes(RecipeOutput pRecipeOutput) {
        // 有序合成
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Moditems.spiritual_sword_item.get())
                .pattern("aaa")
                .pattern("aba")
                .pattern("aaa")
                .define('a', Moditems.spirit_stone.get())
                .define('b', Moditems.spiritual_sword_blank.get())
                .unlockedBy("has_spirit_stone", has(Moditems.spirit_stone.get()))
                .save(pRecipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Moditems.spirit_table.get())
                .pattern("aaa")
                .pattern("aba")
                .pattern("aaa")
                .define('b', Items.ENCHANTING_TABLE)
                .define('a', Moditems.spirit_stone.get())
                .unlockedBy("has_spirit_stone", has(Moditems.spirit_stone.get()))
                .save(pRecipeOutput);
        // 有序合成
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Moditems.fire_spirit_stone.get())
                .pattern("aaa")
                .pattern("aba")
                .pattern("aaa")
                .define('a', Items.MAGMA_BLOCK)
                .define('b', Moditems.spirit_stone.get())
                .unlockedBy("has_spirit_stone", has(Moditems.spirit_stone.get()))
                .save(pRecipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Moditems.water_spirit_stone.get())
                .pattern("aaa")
                .pattern("aba")
                .pattern("aaa")
                .define('a', Items.ICE)
                .define('b', Moditems.spirit_stone.get())
                .unlockedBy("has_spirit_stone", has(Moditems.spirit_stone.get()))
                .save(pRecipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Moditems.gold_spirit_stone.get())
                .pattern("aaa")
                .pattern("aba")
                .pattern("aaa")
                .define('a', Items.GOLD_INGOT)
                .define('b', Moditems.spirit_stone.get())
                .unlockedBy("has_spirit_stone", has(Moditems.spirit_stone.get()))
                .save(pRecipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Moditems.dirt_spirit_stone.get())
                .pattern("aaa")
                .pattern("aba")
                .pattern("aaa")
                .define('a', Items.DIRT)
                .define('b', Moditems.spirit_stone.get())
                .unlockedBy("has_spirit_stone", has(Moditems.spirit_stone.get()))
                .save(pRecipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Moditems.wood_spirit_stone.get())
                .pattern("aaa")
                .pattern("aba")
                .pattern("aaa")
                .define('a', Items.STICK)
                .define('b', Moditems.spirit_stone.get())
                .unlockedBy("has_spirit_stone", has(Moditems.spirit_stone.get()))
                .save(pRecipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Moditems.fire_spiritual_sword_item.get())
                .pattern("aaa")
                .pattern("aba")
                .pattern("aaa")
                .define('a', Moditems.fire_spirit_stone.get())
                .define('b', Moditems.spiritual_sword_item.get())
                .unlockedBy("has_spirit_stone", has(Moditems.spirit_stone.get()))
                .save(pRecipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Moditems.spiritual_pickaxe.get())
                .pattern("aaa")
                .pattern(" b ")
                .pattern(" b ")
                .define('b', Items.STICK)
                .define('a', Moditems.spirit_stone.get())
                .unlockedBy("has_spirit_stone", has(Moditems.spirit_stone.get()))
                .save(pRecipeOutput);
        // 冶炼
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(ModBlocks.SPIRIT_STONE_ORE.get()), RecipeCategory.MISC, Moditems.spirit_stone.get(), 0.3f, 100)
                .unlockedBy("has_spirit_stone_ore", has(ModBlocks.SPIRIT_STONE_ORE.get()))
                .save(pRecipeOutput);
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(Items.IRON_SWORD), RecipeCategory.MISC, Moditems.spiritual_sword_blank.get(), 0.3f, 100)
                .unlockedBy("has_spirit_stone_ore", has(ModBlocks.SPIRIT_STONE_ORE.get()))
                .save(pRecipeOutput);

    }
}