package net.waterrp11451.celestiacraft.entity;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.waterrp11451.celestiacraft.CelestiaCraft;

import java.util.function.Supplier;
//Register entities
public class ModEntityTypes {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(Registries.ENTITY_TYPE, CelestiaCraft.MODID);
    public static final Supplier<EntityType<FlyingSwordEntity>> FLYING_SWORD_ENTITY = ENTITY_TYPES.register("flying_sword_entity", () -> EntityType.Builder.of(FlyingSwordEntity::new, MobCategory.MISC).sized(2, 0.5F).build("flying_sword_entity"));

    public static void register(IEventBus eventBus){
        ENTITY_TYPES.register(eventBus);
    }
}