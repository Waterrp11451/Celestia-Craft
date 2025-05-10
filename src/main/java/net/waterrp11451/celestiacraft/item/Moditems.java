package net.waterrp11451.celestiacraft.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.Tiers;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.waterrp11451.celestiacraft.CelestiaCraft;
import net.waterrp11451.celestiacraft.block.ModBlocks;
import net.waterrp11451.celestiacraft.item.custom.*;
import net.waterrp11451.celestiacraft.item.custom.spiritual_sword_blank;

import java.util.function.Supplier;

import static net.waterrp11451.celestiacraft.item.ModCreativeTab.CREATIVE_MODE_TABS;
//Register items
public class Moditems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(Registries.ITEM, CelestiaCraft.MODID);

    public static final Supplier<Item> spiritual_sword_blank = ITEMS.register("spiritual_sword_blank",() -> new spiritual_sword_blank(new Item.Properties().stacksTo(1)));
    public static final Supplier<Item> spirit_stone = ITEMS.register("spirit_stone",() -> new spirit_stone(new Item.Properties().stacksTo(64)));
    public static final Supplier<Item> fire_spirit_stone = ITEMS.register("fire_spirit_stone",() -> new fire_spirit_stone(new Item.Properties().stacksTo(64)));
    public static final Supplier<Item> water_spirit_stone = ITEMS.register("water_spirit_stone",() -> new water_spirit_stone(new Item.Properties().stacksTo(64)));
    public static final Supplier<Item> wood_spirit_stone = ITEMS.register("wood_spirit_stone",() -> new wood_spirit_stone(new Item.Properties().stacksTo(64)));
    public static final Supplier<Item> dirt_spirit_stone = ITEMS.register("dirt_spirit_stone",() -> new dirt_spirit_stone(new Item.Properties().stacksTo(64)));
    public static final Supplier<Item> gold_spirit_stone = ITEMS.register("gold_spirit_stone",() -> new gold_spirit_stone(new Item.Properties().stacksTo(64)));
    public static final Supplier<Item> spiritual_sword_item = ITEMS.register("spiritual_sword_item", spiritual_sword_item::new);
    public static final Supplier<Item> spirit_table = ITEMS.register("spirit_table",()->new BlockItem(ModBlocks.SPIRIT_TABLE.get(), new Item.Properties()));
    public static final Supplier<Item> spirit_stone_ore = ITEMS.register("spirit_stone_ore",()->new BlockItem(ModBlocks.SPIRIT_STONE_ORE.get(), new Item.Properties()));
    public static final Supplier<Item> spiritual_pickaxe = ITEMS.register("spiritual_pickaxe", spiritual_pickaxe::new);
    public static final Supplier<Item> fire_spiritual_sword_item = ITEMS.register("fire_spiritual_sword_item", fire_spiritual_sword_item::new);
    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
        CREATIVE_MODE_TABS.register(eventBus);
    }

}