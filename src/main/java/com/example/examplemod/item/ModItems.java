package com.example.examplemod.item;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.ModCreativeModeTab;
import com.example.examplemod.block.ModBlocks;
import com.example.examplemod.item.custom.AdvancedItem;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {

    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, ExampleMod.MOD_ID);

    public static final RegistryObject<Item> GLASS_GEM = ITEMS.register("glass_gem",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.EXAMPLE_TAB)));

    public static final RegistryObject<Item> POLISHED_GLASS_GEM = ITEMS.register("polished_glass_gem",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.EXAMPLE_TAB)));

    public static final RegistryObject<Item> ADVANCED_ITEM = ITEMS.register("advanced_item",
            () -> new AdvancedItem(new Item.Properties().stacksTo(1).tab(ModCreativeModeTab.EXAMPLE_TAB)));

    public static final RegistryObject<Item> TEA_SEEDS = ITEMS.register("tea_seeds",
            () -> new ItemNameBlockItem(ModBlocks.TEA_CROP.get(),
                    new Item.Properties().tab(ModCreativeModeTab.EXAMPLE_TAB)));

    public static final RegistryObject<Item> TEA_LEAVES = ITEMS.register("tea_leaves",
            () -> new Item(new Item.Properties()
                    .food(new FoodProperties.Builder().nutrition(1).saturationMod(1f)
                            .effect(new MobEffectInstance(MobEffects.GLOWING, 20), 1.0f)
                            .build()).
                    tab(ModCreativeModeTab.EXAMPLE_TAB)));



    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
