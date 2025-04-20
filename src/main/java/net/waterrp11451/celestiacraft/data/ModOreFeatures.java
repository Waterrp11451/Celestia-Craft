package net.waterrp11451.celestiacraft.data;

import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;
import net.waterrp11451.celestiacraft.CelestiaCraft;
import net.waterrp11451.celestiacraft.block.ModBlocks;

import java.util.List;

public class ModOreFeatures {
    // 创建OreFeature对应的ResourceKey
    //
    public static final ResourceKey<ConfiguredFeature<?, ?>> ORE_SPIRIT_STONE = createKey("spirit_stone");

    //BootstapContext 是我们datagen的上下文，等会我们使用数据生成的时候说。
    public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> pContext) {
        //  创建对应的tag，如果有多个就创建多个
        RuleTest stoneOreReplaceRuleTest = new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest deepSlateOreReplaceRuleTest = new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);

        // 创建一个list
        List<OreConfiguration.TargetBlockState> list = List.of(
                OreConfiguration.target(stoneOreReplaceRuleTest, ModBlocks.SPIRIT_STONE_ORE.get().defaultBlockState()),
                OreConfiguration.target(deepSlateOreReplaceRuleTest, ModBlocks.SPIRIT_STONE_ORE.get().defaultBlockState())
        );
        // 注册对应orefeature，使用listOreConfiguration，9 上文提到的size
        FeatureUtils.register(pContext, ORE_SPIRIT_STONE, Feature.ORE, new OreConfiguration(list, 9));

    }
    // 创建ResourceKey的方法
    public static ResourceKey<ConfiguredFeature<?, ?>> createKey(String pName) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation(CelestiaCraft.MODID,pName));
    }

}
