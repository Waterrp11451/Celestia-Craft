package net.waterrp11451.celestiacraft.event.client;

import net.minecraft.client.Minecraft;
import net.minecraft.client.player.KeyboardInput;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.client.event.InputEvent;
import net.neoforged.neoforge.client.event.RenderGuiOverlayEvent;
import net.neoforged.neoforge.client.gui.overlay.VanillaGuiOverlay;
import net.neoforged.neoforge.event.TickEvent;
import net.neoforged.neoforge.network.PacketDistributor;
import net.waterrp11451.celestiacraft.CelestiaCraft;
import net.waterrp11451.celestiacraft.client.spiritual_power.ClientPlayerSpiritualPowerData;
import net.waterrp11451.celestiacraft.event.key.KeyBinding;
import net.waterrp11451.celestiacraft.item.Moditems;
import net.waterrp11451.celestiacraft.network.data.SpiritualPowerData;

import javax.swing.text.JTextComponent;

@Mod.EventBusSubscriber(modid = CelestiaCraft.MODID,value = Dist.CLIENT)
public class ForgeClientEventHandler {

    @SubscribeEvent
    public static void onKeyInput(InputEvent.Key event) {
        if(KeyBinding.DRINKING_KEY.consumeClick()){

            PacketDistributor.SERVER.noArg().send(new SpiritualPowerData(ClientPlayerSpiritualPowerData.getPlayerPower()));
        }

    }
}
