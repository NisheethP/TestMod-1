package com.nisheeth.testmod.init;

import com.nisheeth.testmod.block.BlockSuperCobble;
import com.nisheeth.testmod.block.BlockTest;
import com.nisheeth.testmod.reference.Reference;
import cpw.mods.fml.common.registry.GameRegistry;


@GameRegistry.ObjectHolder(Reference.MOD_ID)
public class ModBlocks
{
	public static final BlockTest superCobble = new BlockSuperCobble();

	public static void Init ()
	{
		GameRegistry.registerBlock(superCobble, "superCobble");
	}
}