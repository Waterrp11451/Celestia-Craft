package net.waterrp11451.celestiacraft.data;

import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.neoforged.neoforge.common.world.BiomeModifier;
import net.neoforged.neoforge.common.world.BiomeModifiers;
import net.neoforged.neoforge.registries.NeoForgeRegistries;
import net.waterrp11451.celestiacraft.CelestiaCraft;

public class ModBiomeModifiers {
    // 注册的key
    public static final ResourceKey<BiomeModifier> ADD_SPIRIT_ORE = registerKey("add_spirit_ore");
    // BootstapContext 数据生成的上下文
    public static void bootstrap(BootstapContext<BiomeModifier> context) {
        // 通过上下文获得PLACED_FEATURE的注册HolderGetter
        var placedFeatures = context.lookup(Registries.PLACED_FEATURE);
        // 通过上下文获得BIOME的HolderGetter
        var biomes = context.lookup(Registries.BIOME);
        // 生成json文件，第一个参数是key，第二个参数是BiomeModifiers，
        // 我们使用了子类AddFeaturesBiomeModifier，是指添加feature给biome
        // 第一个参数是holderset的biome ，这里是否是主世界的生物群系。即返回了主世界的生物群系
        // 第二个holdlerSet是指所有的feature，我们通过placedFeatures获得
        // 丢三个参数要求给出在世界生成的什么阶段加你的feature，我们这里是地下矿物生成的时候，你可以到该类下面看看，这是个枚举，
        context.register(ADD_SPIRIT_ORE, new BiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
                HolderSet.direct(placedFeatures.getOrThrow(ModOrePlacements.ORE_RUBY)),
                GenerationStep.Decoration.UNDERGROUND_ORES));

    }

    private static ResourceKey<BiomeModifier> registerKey(String name) {
        return ResourceKey.create(NeoForgeRegistries.Keys.BIOME_MODIFIERS, new ResourceLocation(CelestiaCraft.MODID, name));
    }

}
