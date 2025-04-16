package net.waterrp11451.celestiacraft.client.entity;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.waterrp11451.celestiacraft.CelestiaCraft;
import net.waterrp11451.celestiacraft.client.model.entity.FlyingSwordModel;
import net.waterrp11451.celestiacraft.entity.FlyingSwordEntity;

public class FlyingSwordEntityRenderer extends EntityRenderer {
    private EntityModel<FlyingSwordEntity> flyingSwordModel;

    public FlyingSwordEntityRenderer(EntityRendererProvider.Context pContext) {
        super(pContext);
        flyingSwordModel = new FlyingSwordModel(pContext.bakeLayer(FlyingSwordModel.LAYER_LOCATION));
    }
    @Override
    public ResourceLocation getTextureLocation(Entity pEntity) {
        return new ResourceLocation(CelestiaCraft.MODID, "textures/entity/flying_sword_entity.png");
    }
    @Override//Render the entity
    public void render(Entity pEntity, float pEntityYaw, float pPartialTick, PoseStack pPoseStack, MultiBufferSource pBuffer, int pPackedLight) {
        super.render(pEntity, pEntityYaw, pPartialTick, pPoseStack, pBuffer, pPackedLight);
        pPoseStack.pushPose();
        pPoseStack.mulPose(Axis.YN.rotationDegrees(45));
        pPoseStack.translate(0,-1,0);
        VertexConsumer buffer = pBuffer.getBuffer(this.flyingSwordModel.renderType(this.getTextureLocation(pEntity)));
        this.flyingSwordModel.renderToBuffer(pPoseStack,buffer,pPackedLight, OverlayTexture.NO_OVERLAY,1f,1f,1f,1f);
        pPoseStack.popPose();
    }
}
