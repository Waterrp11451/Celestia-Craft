package net.waterrp11451.celestiacraft.capability.spiritual_power;

import net.minecraft.nbt.CompoundTag;

public class SpiritualPowerManager {
    public int spiritual_power;
    public int get_power() {
        return spiritual_power;
    }
    public void increase_spiritual_power(int added_power, int current_power, int max_power){
        this.spiritual_power=Math.min(current_power + added_power, max_power);
    }
    public void use_power(int used_power, int current_power){
        this.spiritual_power=Math.max(current_power-used_power,0);
    }
    // 从另一个 SpiritualPowerManager 对象复制灵力值
    public void copyFrom(SpiritualPowerManager source) {
        this.spiritual_power = source.spiritual_power;
    }

    // 将灵力值保存到 NBT 数据中
    public void saveNBTData(CompoundTag nbt) {
        nbt.putInt("spiritual_power", spiritual_power);
    }

    // 从 NBT 数据中加载灵力值
    public void loadNBTData(CompoundTag nbt) {
        spiritual_power = nbt.getInt("spiritual_power");
    }
}
