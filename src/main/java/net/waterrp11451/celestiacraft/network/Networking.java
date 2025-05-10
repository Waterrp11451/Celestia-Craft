package net.waterrp11451.celestiacraft.network;

import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.network.event.RegisterPayloadHandlerEvent;
import net.neoforged.neoforge.network.registration.IPayloadRegistrar;
import net.waterrp11451.celestiacraft.CelestiaCraft;
import net.waterrp11451.celestiacraft.network.data.SpiritualPowerData;

@Mod.EventBusSubscriber(modid = CelestiaCraft.MODID,bus = Mod.EventBusSubscriber.Bus.MOD)
public class Networking {
    @SubscribeEvent
    public static void register(final RegisterPayloadHandlerEvent event) {
        final IPayloadRegistrar registrar = event.registrar(CelestiaCraft.MODID);
        registrar.play(SpiritualPowerData.ID,SpiritualPowerData::new, handler ->
                handler.client(ClientPayloadHandler.getInstance()::handlePowerData)
                        .server(ServerPayloadHandler.getInstance()::handlePowerData));
    }

}