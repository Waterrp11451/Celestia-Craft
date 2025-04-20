package net.waterrp11451.celestiacraft.data;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.waterrp11451.celestiacraft.block.ModBlocks;

import javax.annotation.Nullable;
import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends BlockTagsProvider {
    public ModBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, String modId, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, modId, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        this.tag(BlockTags.NEEDS_DIAMOND_TOOL).add(ModBlocks.SPIRIT_STONE_ORE.get());
        this.tag(BlockTags.MINEABLE_WITH_PICKAXE).add(ModBlocks.SPIRIT_STONE_ORE.get());
        this.tag(BlockTags.NEEDS_DIAMOND_TOOL).add(ModBlocks.SPIRIT_TABLE.get());
        this.tag(BlockTags.MINEABLE_WITH_PICKAXE).add(ModBlocks.SPIRIT_TABLE.get());
    }
}