package net.waterrp11451.celestiacraft;

import com.mojang.logging.LogUtils;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.server.ServerStartingEvent;
import net.waterrp11451.celestiacraft.block.ModBlocks;
import net.waterrp11451.celestiacraft.entity.ModEntityTypes;
import org.slf4j.Logger;

import static net.waterrp11451.celestiacraft.item.Moditems.register;
//The main class of the mod
@Mod(CelestiaCraft.MODID)
public class CelestiaCraft
{
    public static final String MODID ="celestiacraft";
    private static final Logger LOGGER = LogUtils.getLogger();
    public CelestiaCraft(IEventBus modEventBus)
    {
        modEventBus.addListener(this::commonSetup);
        ModEntityTypes.register(modEventBus);
        ModBlocks.register(modEventBus);
        register(modEventBus);
        NeoForge.EVENT_BUS.register(this);
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {
    }


}
