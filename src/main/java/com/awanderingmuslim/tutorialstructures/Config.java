package com.awanderingmuslim.tutorialstructures;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.config.ModConfigEvent;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

// An awanderingmuslim config class. This is not required, but it's a good idea to have one to keep your config organized.
// Demonstrates how to use Forge's config APIs
@Mod.EventBusSubscriber(modid = TutorialStructures.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class Config {
    private static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();


    // Space between brewing tutorial below

    public static final ForgeConfigSpec.ConfigValue<Integer> BREWING_TUTORIAL_SPACING = BUILDER
            .comment("Average distance in chunks between two neighboring generation attempts for the Brewing Tutorial, MUST be bigger than separation ")
            .define("brewingTutorialSpacing:", 35);

    public static final ForgeConfigSpec.ConfigValue<Integer> BREWING_TUTORIAL_SEPARATION = BUILDER
            .comment("Minimum distance in chunks between two neighboring generation attempts for the Brewing Tutorial, MUST be smaller than spacing. Maximum distance is 2*spacing - separation")
            .define("brewingTutorialSeparation:", 11);


    static final ForgeConfigSpec SPEC = BUILDER.build();

    public static int brewingTutorialSpacing;
    public static int brewingTutorialSeparation;

    @SubscribeEvent
    static void onLoad(final ModConfigEvent event) {

        brewingTutorialSpacing = BREWING_TUTORIAL_SPACING.get();

        brewingTutorialSeparation = BREWING_TUTORIAL_SEPARATION.get();

    }
}
