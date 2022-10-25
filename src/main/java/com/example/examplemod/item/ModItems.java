package com.example.examplemod.item;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.ModCreativeModeTab;
import net.minecraft.world.item.Item;
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


    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
