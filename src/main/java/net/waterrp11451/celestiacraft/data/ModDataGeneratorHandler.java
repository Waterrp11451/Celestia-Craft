package net.waterrp11451.celestiacraft.data;

import net.minecraft.data.DataProvider;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;
import net.waterrp11451.celestiacraft.CelestiaCraft;

import java.util.Collections;
import java.util.List;

@Mod.EventBusSubscriber(modid = CelestiaCraft.MODID,bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModDataGeneratorHandler {
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        ExistingFileHelper efh = event.getExistingFileHelper();
        var lp = event.getLookupProvider();
        event.getGenerator().addProvider(
                event.includeServer(),
                (DataProvider.Factory<ModLootTableProvider>) pOutput -> new ModLootTableProvider(pOutput, Collections.emptySet(),
                        List.of(
                                new LootTableProvider.SubProviderEntry(ModBlockLootProvider::new, LootContextParamSets.BLOCK)
                        ))
        );
        // recipe
        event.getGenerator().addProvider(
                event.includeServer(),
                (DataProvider.Factory<ModRecipeProvider>) pOutput -> new ModRecipeProvider(pOutput,lp)
        );
        // tag
        event.getGenerator().addProvider(
                event.includeServer(),
                (DataProvider.Factory<ModBlockTagProvider>) pOutput -> new ModBlockTagProvider(pOutput,lp,CelestiaCraft.MODID,efh)
        );
        //world  gen
        event.getGenerator().addProvider(event.includeServer(), (DataProvider.Factory<ModWorldGen>) pOutput -> new ModWorldGen(pOutput,lp));
    }

}
