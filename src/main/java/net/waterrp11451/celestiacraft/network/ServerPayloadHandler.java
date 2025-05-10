package net.waterrp11451.celestiacraft.network;

import com.mojang.logging.LogUtils;
import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.phys.*;
import net.neoforged.neoforge.network.PacketDistributor;
import net.neoforged.neoforge.network.handling.PlayPayloadContext;
import net.waterrp11451.celestiacraft.capability.ModCapabilities;
import net.waterrp11451.celestiacraft.item.Moditems;
import net.waterrp11451.celestiacraft.network.data.SpiritualPowerData;
import org.slf4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;


public class ServerPayloadHandler {
    private static final ServerPayloadHandler INSTANCE = new ServerPayloadHandler();
    private static final Logger LOGGER =LogUtils.getLogger();

    public static ServerPayloadHandler getInstance() {
        return INSTANCE;
    }

    public void handlePowerData(final SpiritualPowerData data, final PlayPayloadContext context) {
        context.workHandler().submitAsync(() -> {
            context.player().ifPresent(player -> {
                // 玩家应该是服务端的玩家
                if (player instanceof ServerPlayer serverPlayer) {
                    // 服务端的level
                    ServerLevel level = (ServerLevel) player.level();
                    // 判断玩家手上是否拿的是灵石
                    if (player.getMainHandItem().getItem()==Moditems.spirit_stone.get()) {
                        // 从玩家身上获得灵力的能力，如果存在就增加数值，并发包同步数据
                        Optional.ofNullable(player.getCapability(ModCapabilities.SPIRITUAL_POWER_HANDLER)).ifPresent(power -> {
                            power.increase_spiritual_power(1, power.get_power(), player.experienceLevel);
                            player.sendSystemMessage((Component.translatable("celestiacraft.message.current_power",power.get_power()))
                                    .withStyle(ChatFormatting.AQUA));

                            PacketDistributor.PLAYER.with(serverPlayer).send(new SpiritualPowerData(power.get_power()));
                            player.getMainHandItem().setCount(player.getMainHandItem().getCount()-1);
                        });



                    }
                    if (player.getMainHandItem().getItem()==Moditems.fire_spiritual_sword_item.get()) {

                        Vec3 start = player.getEyePosition();
                        Vec3 end = player.getLookAngle().normalize().scale(32f).add(start);
                        BlockHitResult blockHitResult = player.level().clip(new ClipContext(start,end, ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE,player));
                        end = blockHitResult.getLocation();
                        AABB range = player.getBoundingBox().expandTowards(end.subtract(start));
                        List<HitResult> hits = new ArrayList<>();
                        List<? extends Entity> entities = player.level().getEntities(player,range,entity -> entity.isPickable()&&entity.isAlive());
                        for(var e : entities){
                            Vec3 Vec3 = e.getBoundingBox().clip(start,end).orElse(null);
                            if(Vec3!=null){
                                EntityHitResult entityHitResult = new EntityHitResult(e,Vec3);
                                hits.add(entityHitResult);
                            }
                        }
                        if (!hits.isEmpty()){
                            hits.sort((o1, o2) -> o1.getLocation().distanceToSqr(start)<o2.getLocation().distanceToSqr(start)?-1:1);
                            HitResult hitResult = hits.get(0);
                            Optional.ofNullable(player.getCapability(ModCapabilities.SPIRITUAL_POWER_HANDLER)).ifPresent(power -> {
                                power.use_power(1, power.get_power());
                                player.sendSystemMessage((Component.translatable("celestiacraft.message.power_after_using",power.get_power()))
                                        .withStyle(ChatFormatting.AQUA));

                                PacketDistributor.PLAYER.with(serverPlayer).send(new SpiritualPowerData(power.get_power()));

                                if(power.get_power()>0) {
                                    if (hitResult instanceof EntityHitResult entityHitResult && entityHitResult.getEntity() instanceof LivingEntity livingEntity) {
                                        livingEntity.lavaHurt();
                                    }

                                } else{
                                    player.sendSystemMessage((Component.translatable("celestiacraft.message.not_enough_power"))
                                            .withStyle(ChatFormatting.AQUA));
                                }
                                });
                            }


                    }
                    if (player.getMainHandItem().getItem()==Moditems.spiritual_pickaxe.get()) {

                        Vec3 start = player.getEyePosition();
                        Vec3 end = player.getLookAngle().normalize().scale(32f).add(start);
                        BlockHitResult blockHitResult = player.level().clip(new ClipContext(start,end, ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE,player));
                        end = blockHitResult.getLocation();
                        AABB range = player.getBoundingBox().expandTowards(end.subtract(start));
                        List<HitResult> hits = new ArrayList<>();
                        List<? extends Entity> entities = player.level().getEntities(player,range,entity -> entity.isPickable()&&entity.isAlive());
                        for(var e : entities){
                            Vec3 Vec3 = e.getBoundingBox().clip(start,end).orElse(null);
                            if(Vec3!=null){
                                EntityHitResult entityHitResult = new EntityHitResult(e,Vec3);
                                hits.add(entityHitResult);
                            }
                        }
                        if (!hits.isEmpty()){
                            hits.sort((o1, o2) -> o1.getLocation().distanceToSqr(start)<o2.getLocation().distanceToSqr(start)?-1:1);
                            HitResult hitResult = hits.get(0);
                            Optional.ofNullable(player.getCapability(ModCapabilities.SPIRITUAL_POWER_HANDLER)).ifPresent(power -> {
                                power.use_power(1, power.get_power());
                                player.sendSystemMessage((Component.translatable("celestiacraft.message.power_after_using",power.get_power()))
                                        .withStyle(ChatFormatting.AQUA));

                                PacketDistributor.PLAYER.with(serverPlayer).send(new SpiritualPowerData(power.get_power()));

                                if(power.get_power()>0) {
                                    if (hitResult instanceof EntityHitResult entityHitResult && entityHitResult.getEntity() instanceof LivingEntity livingEntity) {
                                    }
                                    else {
                                        level.destroyBlock(blockHitResult.getBlockPos(),true);
                                    }

                                } else{
                                    player.sendSystemMessage((Component.translatable("celestiacraft.message.not_enough_power"))
                                            .withStyle(ChatFormatting.AQUA));
                                }
                            });
                        }
                    }
                }
            });
        }).exceptionally(e -> {
            context.packetHandler().disconnect(Component.translatable("my_mod.networking.failed", e.getMessage()));
            return null;
        });
    }




}
