package com.nisheeth.testmod.init;

import com.nisheeth.testmod.item.*;
import com.nisheeth.testmod.item.tools.sword.ItemSteelBlade;
import com.nisheeth.testmod.item.tools.sword.ItemSteelGuard;
import com.nisheeth.testmod.item.tools.sword.ItemSteelHilt;
import com.nisheeth.testmod.item.tools.sword.ItemSteelSword;
import com.nisheeth.testmod.reference.Reference;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;

@GameRegistry.ObjectHolder(Reference.MOD_ID)
public class ModItems
{
	public static final ItemTest rock = new ItemRock();
    public static final ItemTest coalIron = new ItemCoalIron();
    public static final ItemTest steelIngot = new ItemSteelIngot();
	public static final ItemSteelSword steelSword = new ItemSteelSword();
	public static final ItemTest steelHilt = new ItemSteelHilt();
	public static final ItemTest steelGuard = new ItemSteelGuard();
	public static final ItemTest steelBlade = new ItemSteelBlade();

	public static void init ()
	{
		GameRegistry.registerItem(rock, "Rock");
        GameRegistry.registerItem(coalIron, "Coal Iron");
        GameRegistry.registerItem(steelIngot, "Steel");
		GameRegistry.registerItem(steelSword, "Steel Sword");
		GameRegistry.registerItem(steelBlade, "Steel Blade");
		GameRegistry.registerItem(steelHilt, "Steel Hilt");
		GameRegistry.registerItem(steelGuard, "Steel Guard");

	}
}
