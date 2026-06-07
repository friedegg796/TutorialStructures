package com.awanderingmuslim.tutorialstructures.structures;

import com.awanderingmuslim.tutorialstructures.TutorialStructures;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;
import net.minecraft.world.level.levelgen.placement.RarityFilter;

import java.util.List;

public class TutorialStructuresPlacedFeatures {
    public static int brewingPlacementRarity = 16;
    public static final ResourceKey<PlacedFeature> MINESHAFT_TUTORIAL_PLACED_KEY = registerKey("brewing_tutorial_place_feature");

    public static void bootstrap(BootstapContext<PlacedFeature> context) {
        HolderGetter<ConfiguredFeature<?, ?>> configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);

        register(context, MINESHAFT_TUTORIAL_PLACED_KEY, configuredFeatures.getOrThrow(TutorialStructuresConfiguredFeatures.MINESHAFT_TUTORIAL_KEY),
                VegetationPlacements.treePlacement(RarityFilter.onAverageOnceEvery(brewingPlacementRarity)
                )

        );


    }


    private static ResourceKey<PlacedFeature> registerKey(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation(TutorialStructures.MODID, name));
    }

    private static void register(BootstapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key, Holder<ConfiguredFeature<?, ?>> configuration,
                                 List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));

    }
}
