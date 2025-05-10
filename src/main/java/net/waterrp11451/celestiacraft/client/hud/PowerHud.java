package net.waterrp11451.celestiacraft.client.hud;

import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.client.gui.overlay.IGuiOverlay;
import net.waterrp11451.celestiacraft.CelestiaCraft;
import net.waterrp11451.celestiacraft.client.spiritual_power.ClientPlayerSpiritualPowerData;

public class PowerHud {
    // 有水和无水的水瓶
    private static final ResourceLocation FILLED_THIRST = new ResourceLocation(CelestiaCraft.MODID,
            "textures/gui/filled_thirst.png");
    private static final ResourceLocation EMPTY_THIRST = new ResourceLocation(CelestiaCraft.MODID,
            "textures/gui/empty_thirst.png");
//    public static final IGuiOverlay HUD_THIRST = (gui, guiGraphics, partialTick, screenWidth, screenHeight) -> {
//        int x = screenWidth / 2;
//        int y = screenHeight;
//        // 绘制无水的水瓶
//        for(int i = 0; i < 10; i++) {
//            guiGraphics.blit(EMPTY_THIRST,x - 94 + (i * 9), y - 54,90,0,0,12,12,
//                    12,12);
//        }
//        // 绘制有水的水瓶
//        // ClientPlayerThirstData我们提供的client辅助的类存储数值
//        for(int i = 0; i < 10; i++) {
//            if(ClientPlayerSpiritualPowerData.getPlayerPower() > i) {
//                guiGraphics.blit(FILLED_THIRST,x - 94 + (i * 9),y - 54,90,0,0,12,12,
//                        12,12);
//            } else {
//                break;
//            }
//        }
    };
