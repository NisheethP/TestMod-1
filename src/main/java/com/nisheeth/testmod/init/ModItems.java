package com.nisheeth.testmod.init;

import com.nisheeth.testmod.item.ItemRock;
import com.nisheeth.testmod.item.ItemTest;
import com.nisheeth.testmod.reference.Reference;
import cpw.mods.fml.common.registry.GameRegistry;

@GameRegistry.ObjectHolder(Reference.MOD_ID)
public class ModItems
{
	public static final ItemTest rock = new ItemRock();

	public static void init ()
	{
		GameRegistry.registerItem(rock, "Rock");
	}
}
