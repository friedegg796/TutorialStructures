package com.awanderingmuslim.tutorialstructures.datagen;

import com.awanderingmuslim.tutorialstructures.TutorialStructures;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.concurrent.CompletableFuture;

@Mod.EventBusSubscriber(modid = TutorialStructures.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class TutorialStructuresDatagen {
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {

        DataGenerator tutorialStructuresDataGenerator = event.getGenerator();
        PackOutput tutorialStructuresPackOutput = tutorialStructuresDataGenerator.getPackOutput();
        ExistingFileHelper tutorialStructureExistingFileHelper = event.getExistingFileHelper();
        CompletableFuture<HolderLookup.Provider> tutorialStructureLookupProvider = event.getLookupProvider();

        tutorialStructuresDataGenerator.addProvider(event.includeServer(), new TutorialStructuresWorldDatagenProvider(tutorialStructuresPackOutput, tutorialStructureLookupProvider));
    }


}
