package com.nisheeth.testmod.init;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Blocks;
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

        //Rocks to cobblestone
        GameRegistry.addShapedRecipe(cobbleStack, "xx ", "xx ", "   ", 'x', rockStack);

        //Cobblestone to super Cobble-stone
        GameRegistry.addShapedRecipe(superCobbleStack, "xxx","xxx","xxx", 'x', cobbleStack);

    }

}
