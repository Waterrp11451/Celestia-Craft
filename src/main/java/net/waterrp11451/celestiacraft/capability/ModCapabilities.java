package net.waterrp11451.celestiacraft.capability;

import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.capabilities.EntityCapability;
import net.waterrp11451.celestiacraft.CelestiaCraft;
import net.waterrp11451.celestiacraft.capability.spiritual_power.SpiritualPowerManager;

public class ModCapabilities {

    public static final EntityCapability<SpiritualPowerManager,Void> SPIRITUAL_POWER_HANDLER =
            EntityCapability.createVoid(new ResourceLocation(CelestiaCraft.MODID,"spiritual_power_handler"),
                    SpiritualPowerManager.class);

}
