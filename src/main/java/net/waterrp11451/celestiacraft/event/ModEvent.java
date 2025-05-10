package net.waterrp11451.celestiacraft.event;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.LogicalSide;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.capabilities.RegisterCapabilitiesEvent;
import net.neoforged.neoforge.client.event.ClientChatReceivedEvent;
import net.neoforged.neoforge.event.TickEvent;
import net.neoforged.neoforge.event.entity.EntityJoinLevelEvent;
import net.neoforged.neoforge.network.PacketDistributor;
import net.waterrp11451.celestiacraft.CelestiaCraft;
import net.waterrp11451.celestiacraft.capability.ModCapabilities;
import net.waterrp11451.celestiacraft.capability.spiritual_power.SpiritualPowerManager;
import net.waterrp11451.celestiacraft.capability.spiritual_power.SpiritualPowerProvider;
import net.waterrp11451.celestiacraft.item.Moditems;
import net.waterrp11451.celestiacraft.network.data.SpiritualPowerData;

import java.util.Optional;
import java.util.logging.Level;

public class ModEvent {
    @Mod.EventBusSubscriber(modid = CelestiaCraft.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class ModEventBus {
        @SubscribeEvent
        private static void registerCapabilities(RegisterCapabilitiesEvent event) {
            event.registerEntity(ModCapabilities.SPIRITUAL_POWER_HANDLER,
                    EntityType.PLAYER,
                    new SpiritualPowerProvider());
        }
    }
    @Mod.EventBusSubscriber(modid = CelestiaCraft.MODID,bus = Mod.EventBusSubscriber.Bus.FORGE)
    public static class ForgeEvents{

        @SubscribeEvent
        public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
            Player player = event.player;
            if(event.side == LogicalSide.SERVER) {
                Optional<SpiritualPowerManager> optionalPlayerThirst = Optional.ofNullable(event.player.getCapability(ModCapabilities.SPIRITUAL_POWER_HANDLER));
                optionalPlayerThirst .ifPresent(power -> {
                    if(power.get_power() > 0 && event.player.getRandom().nextFloat() < 0.00005f) { // Once Every 10 Seconds on Avg
                        power.increase_spiritual_power(1,power.get_power(),player.experienceLevel);
                        PacketDistributor.PLAYER.with((ServerPlayer) event.player).send(new SpiritualPowerData(power.get_power()));
                        event.player.sendSystemMessage(Component.translatable("celestiacraft.message.add_power"));
                    }
                });

            }
        }}
        // 当玩家刚刚加入世界时候同步数据
        @SubscribeEvent
        public static void onPlayerJoinWorld(EntityJoinLevelEvent event) {
            if(!event.getLevel().isClientSide()) {
                if(event.getEntity() instanceof ServerPlayer player) {
                    Optional<SpiritualPowerManager> optionalPlayerPower = Optional.ofNullable(player.getCapability(ModCapabilities.SPIRITUAL_POWER_HANDLER));
                    optionalPlayerPower.ifPresent(power -> {
                        PacketDistributor.PLAYER.with((ServerPlayer) player).send(new SpiritualPowerData(power.get_power()));
                    });

                }
            }
        }

    }

