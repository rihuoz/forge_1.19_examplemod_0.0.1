package com.example.examplemod;

import com.example.examplemod.item.ModItems;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModCreativeModeTab {
    public static final CreativeModeTab EXAMPLE_TAB = new CreativeModeTab("example_tab") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.GLASS_GEM.get());
        }
    };
}
