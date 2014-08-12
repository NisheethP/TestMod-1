package com.nisheeth.testmod.block;

import com.nisheeth.testmod.reference.Reference;
import com.nisheeth.testmod.tileentity.TileEntityMicroChest;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockMicroChest extends BlockTest implements ITileEntityProvider
{
	public BlockMicroChest()
	{
		super(new Material(MapColor.woodColor));
		this.setBlockName("microChest");
		this.setBlockTextureName("microChest");
		this.setBlockBounds(0.0625f, 0.0f, 0.0625f, 0.9375f, 0.875f, 0.9375f);
	}

	@Override
	public TileEntity createNewTileEntity(World par1World, int par2Int)
	{
		return new TileEntityMicroChest();
	}

	@Override
	public String getUnlocalizedName()
	{
		return String.format("tile.%s%s", Reference.MOD_ID.toLowerCase() + ":", getUnwrappedUnlocalizedName(super.getUnlocalizedName()));
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister iconRegister)
	{
		blockIcon = iconRegister.registerIcon(String.format("%s", getUnwrappedUnlocalizedName(this.getUnlocalizedName())));
	}

	protected String getUnwrappedUnlocalizedName(String unlocalizedName)
	{
		return unlocalizedName.substring(unlocalizedName.indexOf(".") + 1);
	}

	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int p_149727_6_, float p_149727_7_, float p_149727_8_, float p_149727_9_)
	{
		if (player.isSneaking())
		{
			return true;
		}
		else
		{
			if (!world.isRemote && world.getTileEntity(x, y, z) instanceof TileEntityMicroChest)
			{
				//player.openGui(TileEntityMicroChest, GuiId.ALCHEMICAL_CHEST.ordinal(), world, x, y, z);
			}

			return true;
		}
	}

	@Override
	public int damageDropped(int metadata)
	{
		return super.damageDropped(metadata);
	}

	@Override
	public boolean renderAsNormalBlock()
	{
		return false;
	}

	@Override
	public boolean isOpaqueCube()
	{
		return false;
	}

	@Override
	public int getRenderType()
	{
		return 22;
	}
}
