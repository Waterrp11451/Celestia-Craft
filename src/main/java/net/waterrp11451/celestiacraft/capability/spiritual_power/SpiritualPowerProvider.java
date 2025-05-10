package net.waterrp11451.celestiacraft.capability.spiritual_power;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.player.Player;
import net.neoforged.neoforge.capabilities.ICapabilityProvider;
import net.neoforged.neoforge.common.util.INBTSerializable;

import javax.annotation.Nullable;

public class SpiritualPowerProvider implements ICapabilityProvider<Player,Void, SpiritualPowerManager>, INBTSerializable<CompoundTag> {
    // 存储玩家灵力值的实例
    private SpiritualPowerManager spiritual_power = null;

    // 创建SpiritualPowerManager 实例的私有方法
    private SpiritualPowerManager createPlayerThirst() {
        if (this.spiritual_power == null) {
            this.spiritual_power = new SpiritualPowerManager();
        }
        return this.spiritual_power;
    }

    // 实现 INBTSerializable 接口的 serializeNBT 方法，用于将灵力值保存到 NBT 数据中
    @Override
    public CompoundTag serializeNBT() {
        CompoundTag nbt = new CompoundTag();
        createPlayerThirst().saveNBTData(nbt);
        return nbt;
    }

    // 实现 INBTSerializable 接口的 deserializeNBT 方法，用于从 NBT 数据中加载灵力值
    @Override
    public void deserializeNBT(CompoundTag nbt) {
        createPlayerThirst().loadNBTData(nbt);
    }

    // 实现 ICapabilityProvider 接口的 getCapability 方法，用于获取玩家的灵力值实例
    @Override
    public @Nullable SpiritualPowerManager getCapability(Player player, Void context) {
        return this.createPlayerThirst();
    }
}
