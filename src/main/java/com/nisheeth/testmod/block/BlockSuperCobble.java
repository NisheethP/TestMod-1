package com.nisheeth.testmod.block;

import com.nisheeth.testmod.init.ModItems;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;

import java.util.Random;


public class BlockSuperCobble extends BlockTest
{
	public BlockSuperCobble ()
	{
		super(Material.iron);
		this.setBlockName("superCobble");
		this.setBlockTextureName("superCobble");
		this.setHardness(2.5F);
	}

	@Override
	public Item getItemDropped (int metadata, Random random, int fortune)
	{
		return ModItems.rock;
	}
}
