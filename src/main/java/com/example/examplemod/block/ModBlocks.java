package com.example.examplemod.block;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.ModCreativeModeTab;
import com.example.examplemod.block.custom.GlassGemLamp;
import com.example.examplemod.block.custom.JumpyBlock;
import com.example.examplemod.block.custom.TeaCropBlock;
import com.example.examplemod.item.ModItems;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {


    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, ExampleMod.MOD_ID);

    public static final RegistryObject<Block> GLASS_GEM_BLOCK = registerBlock("glass_gem_block",
            () -> new Block(
                    BlockBehaviour.Properties.of(Material.GLASS).
                    strength(3f ).
                    requiresCorrectToolForDrops()
            ), ModCreativeModeTab.EXAMPLE_TAB);

    public static final RegistryObject<Block> GLASS_GEM_ORE = registerBlock("glass_gem_ore",
            () -> new DropExperienceBlock(
                    BlockBehaviour.Properties.of(Material.GLASS).
                            strength(3f ).
                            requiresCorrectToolForDrops(),
                    UniformInt.of(3, 7)
            ), ModCreativeModeTab.EXAMPLE_TAB);

    public static final RegistryObject<Block> DEEPSLATE_GLASS_GEM_ORE = registerBlock("deepslate_glass_gem_ore",
            () -> new DropExperienceBlock(
                    BlockBehaviour.Properties.of(Material.GLASS).
                            strength(4f ).
                            requiresCorrectToolForDrops(),
                    UniformInt.of(5, 9)
            ), ModCreativeModeTab.EXAMPLE_TAB);

    public static final RegistryObject<Block> JUMPY_BLOCK = registerBlock("jumpy_block",
            () -> new JumpyBlock(
                    BlockBehaviour.Properties.of(Material.SPONGE).
                            strength(2f ).
                            requiresCorrectToolForDrops()
            ), ModCreativeModeTab.EXAMPLE_TAB);

    public static final RegistryObject<Block> GLASS_GEM_LAMP = registerBlock("glass_gem_lamp",
            () -> new GlassGemLamp(
                    BlockBehaviour.Properties.of(Material.GLASS).
                            strength(2f ).
                            requiresCorrectToolForDrops().
                            lightLevel(state -> state.getValue(GlassGemLamp.LIT)? 15 : 9)
            ), ModCreativeModeTab.EXAMPLE_TAB);

    public static final RegistryObject<Block> TEA_CROP = BLOCKS.register("tea_crop",
            () -> new TeaCropBlock(
                    BlockBehaviour.Properties.copy(Blocks.WHEAT)));



    private static <T extends Block>RegistryObject<T> registerBlock(String name, Supplier<T> block, CreativeModeTab tab){
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn, tab);
        return toReturn;
    }
    private static <T extends Block>RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block, CreativeModeTab tab){
        return ModItems.ITEMS.register(name, ()-> new BlockItem(block.get(), new Item.Properties().tab(tab)));
    }

    public static void register(IEventBus eventBus){
        BLOCKS.register(eventBus);
    }
}

