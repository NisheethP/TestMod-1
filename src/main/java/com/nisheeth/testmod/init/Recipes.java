package com.nisheeth.testmod.init;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class Recipes
{
    public static void init ()
    {
        /**
         * Declaring all Item stacks here;
         * Add which recipe it being registered in a comment.
         */

        ItemStack cobbleStack = new ItemStack(Blocks.cobblestone);
        ItemStack rockStack = new ItemStack(ModItems.rock);
        ItemStack superCobbleStack = new ItemStack(ModBlocks.superCobble);
        ItemStack coalIronStack = new ItemStack(ModItems.coalIron);
        ItemStack coalStack = new ItemStack(Items.coal);
        ItemStack ironStack = new ItemStack(Items.iron_ingot);
        ItemStack steelStack = new ItemStack(ModItems.steel);


        //Rocks to cobblestone:
        GameRegistry.addShapedRecipe(cobbleStack, "xx ", "xx ", "   ", 'x', rockStack);

        //Cobblestone to super Cobble-stone:
        GameRegistry.addShapedRecipe(superCobbleStack, "xxx","xxx","xxx", 'x', cobbleStack);

        //CoalIron Recipe:
        GameRegistry.addShapedRecipe(coalIronStack, "ccc", "cic", "ccc", 'c', coalStack, 'i', ironStack);

        //Steel recipe
        GameRegistry.addSmelting(coalIronStack, steelStack, 30.0F);
    }

}
