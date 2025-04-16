package net.waterrp11451.celestiacraft.block;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.Block;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.waterrp11451.celestiacraft.CelestiaCraft;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(Registries.BLOCK, CelestiaCraft.MODID);

    public static final Supplier<Block> SPIRIT_TABLE = BLOCKS.register("spirit_table", spirit_table::new);
    public static final Supplier<Block> SPIRIT_STONE_ORE = BLOCKS.register("spirit_stone_ore", spirit_stone_ore::new);

    public static void register(IEventBus eventBus){
        BLOCKS.register(eventBus);
    }
}
