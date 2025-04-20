package net.waterrp11451.celestiacraft.data;

import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.waterrp11451.celestiacraft.block.ModBlocks;

import java.util.Collections;
import java.util.Set;

public class ModBlockLootProvider extends BlockLootSubProvider {

    public static final Set<Block> BLOCK = Set.of(
            ModBlocks.SPIRIT_STONE_ORE.get(),
            ModBlocks.SPIRIT_TABLE.get()
    );

    public ModBlockLootProvider() {
        super(Collections.emptySet(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        this.dropSelf(ModBlocks.SPIRIT_STONE_ORE.get());
        this.dropSelf(ModBlocks.SPIRIT_TABLE.get());
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return BLOCK;
    }
}