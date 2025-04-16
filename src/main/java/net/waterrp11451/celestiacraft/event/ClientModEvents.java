package net.waterrp11451.celestiacraft.event;

import net.minecraft.client.KeyMapping;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.client.event.RegisterKeyMappingsEvent;
import net.waterrp11451.celestiacraft.CelestiaCraft;
import net.waterrp11451.celestiacraft.client.entity.FlyingSwordEntityRenderer;
import net.waterrp11451.celestiacraft.client.model.entity.FlyingSwordModel;
import net.waterrp11451.celestiacraft.entity.ModEntityTypes;
import org.lwjgl.glfw.GLFW;

@Mod.EventBusSubscriber(modid = CelestiaCraft.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientModEvents {

    @SubscribeEvent
    public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
//Register renderer
        event.registerEntityRenderer(ModEntityTypes.FLYING_SWORD_ENTITY.get(), FlyingSwordEntityRenderer::new);
    }

    @SubscribeEvent
    public static void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
//Register layer
        event.registerLayerDefinition(FlyingSwordModel.LAYER_LOCATION, FlyingSwordModel::createBodyLayer);
    }
    public static final KeyMapping ASCEND_KEY = new KeyMapping(
            "key.ascend",
            GLFW.GLFW_KEY_SPACE,
            "key.category.flying_sword"
    );

    @SubscribeEvent
    public static void onKeyRegister(RegisterKeyMappingsEvent event) {
        event.register(ASCEND_KEY);
    }
}
