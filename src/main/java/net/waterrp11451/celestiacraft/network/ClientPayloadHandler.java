package net.waterrp11451.celestiacraft.network;

import com.mojang.logging.LogUtils;
import net.minecraft.network.chat.Component;
import net.neoforged.neoforge.network.handling.PlayPayloadContext;
import net.waterrp11451.celestiacraft.client.spiritual_power.ClientPlayerSpiritualPowerData;
import net.waterrp11451.celestiacraft.network.data.SpiritualPowerData;
import org.slf4j.Logger;

public class ClientPayloadHandler {
    private static final Logger LOGGER = LogUtils.getLogger();
    private static final ClientPayloadHandler INSTANCE = new ClientPayloadHandler();

    public static ClientPayloadHandler getInstance() {
        return INSTANCE;
    }
    // 给我们的在客户端存储thirst的地方赋值
    public void handlePowerData(final SpiritualPowerData data, final PlayPayloadContext context){
        context.workHandler().submitAsync(()->{
            ClientPlayerSpiritualPowerData.set(data.power());
        }).exceptionally(e->{
            context.packetHandler().disconnect(Component.translatable("my_mod.networking.failed", e.getMessage()));
            return null;
        });
    }

}
