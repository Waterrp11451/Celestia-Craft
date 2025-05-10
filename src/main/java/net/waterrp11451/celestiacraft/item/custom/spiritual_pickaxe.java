package net.waterrp11451.celestiacraft.item.custom;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;

public class spiritual_pickaxe extends PickaxeItem {
    public spiritual_pickaxe() {
        super(Tiers.NETHERITE,
                1,
                -2.5f,
                new Item.Properties().durability(3000) );
    }
}
