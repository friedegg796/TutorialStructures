package com.awanderingmuslim.tutorialstructures.datagen;

import com.awanderingmuslim.tutorialstructures.TutorialStructures;
import com.awanderingmuslim.tutorialstructures.structures.TutorialStructuresBiomeModifers;
import com.awanderingmuslim.tutorialstructures.structures.TutorialStructuresConfiguredFeatures;
import com.awanderingmuslim.tutorialstructures.structures.TutorialStructuresPlacedFeatures;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.DatapackBuiltinEntriesProvider;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class TutorialStructuresWorldDatagenProvider extends DatapackBuiltinEntriesProvider {
    public static final RegistrySetBuilder BUILDER = new RegistrySetBuilder()
            .add(Registries.CONFIGURED_FEATURE, TutorialStructuresConfiguredFeatures::bootstrap)
            .add(Registries.PLACED_FEATURE, TutorialStructuresPlacedFeatures::bootstrap)
            .add(ForgeRegistries.Keys.BIOME_MODIFIERS, TutorialStructuresBiomeModifers::bootstrap);


    public TutorialStructuresWorldDatagenProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {

        super(output, registries, BUILDER, Set.of(TutorialStructures.MODID));
    }


}
