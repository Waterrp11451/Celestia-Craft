package net.waterrp11451.celestiacraft.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.waterrp11451.celestiacraft.CelestiaCraft;

import java.util.function.Supplier;
//Create a creative tab
public class ModCreativeTab {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS=DeferredRegister.create(Registries.CREATIVE_MODE_TAB, CelestiaCraft.MODID);
    public static final String CELESTIA_CRAFT_TAB_STRING="creative.celestia_tab";
    public static final Supplier<CreativeModeTab> EXAMPLE_TAB  = CREATIVE_MODE_TABS.register("celestia_tab",() -> CreativeModeTab.builder()
            .withTabsBefore(CreativeModeTabs.COMBAT)
           .title(Component.translatable(CELESTIA_CRAFT_TAB_STRING))
            .icon(()->Moditems.spiritual_sword_blank.get().getDefaultInstance())
            .displayItems((pParameters, pOutput) -> {
        pOutput.accept(Moditems.spiritual_sword_blank.get());
        pOutput.accept(Moditems.spiritual_sword_item.get());
        pOutput.accept(Moditems.spirit_stone.get());
        pOutput.accept(Moditems.fire_spirit_stone.get());
        pOutput.accept(Moditems.water_spirit_stone.get());
        pOutput.accept(Moditems.gold_spirit_stone.get());
        pOutput.accept(Moditems.wood_spirit_stone.get());
        pOutput.accept(Moditems.dirt_spirit_stone.get());
        pOutput.accept(Moditems.spirit_table.get());
        pOutput.accept(Moditems.spirit_stone_ore.get());
    })
            .build());
}
