package com.nisheeth.testmod.init;

import com.nisheeth.testmod.item.ItemSteelIngot;
import com.nisheeth.testmod.item.tools.sword.ItemSteelSword;
import com.nisheeth.testmod.utility.NBTHelper;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

public class Recipes
{
    public static void init ()
    {
        /**
         * Declaring all Item stacks here;
         * Add which recipe it being registered in a comment.
         */

		//Mod-Stacks
		ItemStack rockStack = new ItemStack(ModItems.rock);
		ItemStack superCobbleStack = new ItemStack(ModBlocks.superCobble);
		ItemStack coalIronStack = new ItemStack(ModItems.coalIron);
		ItemStack steelStack = new ItemStack(ModItems.steelIngot);
		ItemStack steelSwordGeneralStack = new ItemStack(ModItems.steelSword,1, OreDictionary.WILDCARD_VALUE);
		ItemStack steelHiltStack = new ItemStack(ModItems.steelHilt);
		ItemStack steelGuardStack = new ItemStack(ModItems.steelGuard);
		ItemStack steelBladeStack = new ItemStack(ModItems.steelBlade);
		ItemStack steelSwordStack = new ItemStack(ModItems.steelSword);

		//Vanilla-Stacks
        ItemStack cobbleStack = new ItemStack(Blocks.cobblestone);
        ItemStack coalStack = new ItemStack(Items.coal);
        ItemStack ironStack = new ItemStack(Items.iron_ingot);

		/**
		 * NBT-Tags to allot to the ItemStacks
		 */
		NBTHelper.setInteger(steelSwordStack,ItemSteelSword.TAG_TEMPERATURE,0);

		/**
		 * The Recipes. Finally...
		 */

		//Rocks to cobblestone:
        GameRegistry.addShapedRecipe(cobbleStack, "xx", "xx", 'x', rockStack);

        //Cobblestone to super Cobble-stone:
        GameRegistry.addShapedRecipe(superCobbleStack, "xxx","xxx","xxx", 'x', cobbleStack);

        //CoalIron Recipe:
        GameRegistry.addShapedRecipe(coalIronStack, "ccc", "cic", "ccc", 'c', coalStack, 'i', ironStack);

        //Steel Recipe:
        GameRegistry.addSmelting(coalIronStack, steelStack, 30.0F);

		//Steel Guard Recipe:
		GameRegistry.addShapedRecipe(steelGuardStack, "scs", 'c', superCobbleStack, 's', steelStack);

		//Steel Guard Recipe:
		GameRegistry.addShapedRecipe(steelHiltStack, " s "," s ", " c ", 'c', superCobbleStack, 's', steelStack);

		//Steel Blade Recipe:
		GameRegistry.addShapedRecipe(steelBladeStack, " s ","scs", "scs", 'c', superCobbleStack, 's', steelStack);

		//Steel Sword Recipe:
		GameRegistry.addShapedRecipe(steelSwordStack, "  b"," g ","h  ",
											'b', steelBladeStack, 'g', steelGuardStack, 'h', steelHiltStack);

		//Heating the Sword:
		ItemSteelSword.heatSword();

	}
}
