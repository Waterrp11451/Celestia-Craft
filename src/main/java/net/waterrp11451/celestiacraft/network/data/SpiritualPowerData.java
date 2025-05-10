package net.waterrp11451.celestiacraft.network.data;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;
import net.waterrp11451.celestiacraft.CelestiaCraft;

// 需要同步的数据只有thirst
public record SpiritualPowerData(int power) implements CustomPacketPayload {
    public static final ResourceLocation ID = new ResourceLocation(CelestiaCraft.MODID,"spiritual_power_data");

    public SpiritualPowerData(final FriendlyByteBuf buf){
        this(buf.readInt());
    }

    @Override
    public void write(FriendlyByteBuf pBuffer) {
        pBuffer.writeInt(power());
    }

    @Override
    public ResourceLocation id() {
        return ID;
    }
}