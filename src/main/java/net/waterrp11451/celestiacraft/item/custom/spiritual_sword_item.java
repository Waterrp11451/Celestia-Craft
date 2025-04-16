package net.waterrp11451.celestiacraft.item.custom;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tiers;

public class spiritual_sword_item extends SwordItem {
    public spiritual_sword_item() {
        super(
                Tiers.NETHERITE, // 武器材质（可替换为 DIAMOND、IRON 等）
                8,              // 基础攻击伤害（实际伤害 = 材质基础值 + 此值）
                -2.4F,          // 攻击速度修正（负值表示攻击更慢但伤害更高）
                new Item.Properties().durability(3000) // 耐久度（Netherite 材质默认值）
        );
    }
}
