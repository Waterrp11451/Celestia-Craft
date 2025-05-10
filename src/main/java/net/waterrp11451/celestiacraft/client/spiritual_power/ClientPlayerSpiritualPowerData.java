package net.waterrp11451.celestiacraft.client.spiritual_power;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class ClientPlayerSpiritualPowerData {
    private static int playerPower;

    public static void set(int power) {
        ClientPlayerSpiritualPowerData.playerPower = power;
    }

    public static int getPlayerPower() {
        return playerPower;
    }
}
