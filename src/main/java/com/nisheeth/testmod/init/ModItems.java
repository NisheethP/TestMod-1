package com.nisheeth.testmod.init;

import com.nisheeth.testmod.item.ItemCoalIron;
import com.nisheeth.testmod.item.ItemRock;
import com.nisheeth.testmod.item.ItemSteel;
import com.nisheeth.testmod.item.ItemTest;
import com.nisheeth.testmod.reference.Reference;
import cpw.mods.fml.common.registry.GameRegistry;

@GameRegistry.ObjectHolder(Reference.MOD_ID)
public class ModItems
{
	public static final ItemTest rock = new ItemRock();
    public static final ItemTest coalIron = new ItemCoalIron();
    public static final ItemTest steel = new ItemSteel();

	public static void init ()
	{
		GameRegistry.registerItem(rock, "Rock");
        GameRegistry.registerItem(coalIron, "Coal Iron");
        GameRegistry.registerItem(steel, "Steel");
	}
}
