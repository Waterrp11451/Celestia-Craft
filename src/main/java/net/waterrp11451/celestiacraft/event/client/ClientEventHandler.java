package net.waterrp11451.celestiacraft.event.client;

import net.minecraft.client.renderer.entity.EntityRenderers;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.waterrp11451.celestiacraft.client.entity.FlyingSwordEntityRenderer;
import net.waterrp11451.celestiacraft.client.model.entity.FlyingSwordModel;
import net.waterrp11451.celestiacraft.entity.ModEntityTypes;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD,value = Dist.CLIENT)
public class ClientEventHandler {
    @SubscribeEvent
    public static void registerEntityLayers(EntityRenderersEvent.RegisterLayerDefinitions evt) {
        evt.registerLayerDefinition(FlyingSwordModel.LAYER_LOCATION, FlyingSwordModel::createBodyLayer);
    }
    @SubscribeEvent
    public static void onClientEvent(FMLClientSetupEvent event){
        event.enqueueWork(()->{
            EntityRenderers.register(ModEntityTypes.FLYING_SWORD_ENTITY.get(), FlyingSwordEntityRenderer::new);
        });
    }
}
