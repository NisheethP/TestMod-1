package com.nisheeth.testmod.item.tools.sword;

import com.nisheeth.testmod.creativetab.CreativeTabTest;
import com.nisheeth.testmod.item.MaterialsTest;
import com.nisheeth.testmod.reference.Reference;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;

public class ItemSteelSword extends ItemSword
{
    public ItemSteelSword()
    {
		super(MaterialsTest.SteelMaterial);
        this.setUnlocalizedName("steelSword");
        this.setMaxStackSize(1);
        this.setMaxDamage(1600);
		this.setCreativeTab(CreativeTabTest.TEST_TABS);
	}

	@Override
	public String getUnlocalizedName()
	{
		return String.format("item.%s%s", Reference.MOD_ID.toLowerCase() + ":", getUnwrappedUnlocalizedName(super.getUnlocalizedName()));
	}

	@Override
	public String getUnlocalizedName(ItemStack itemStack)
	{
		return String.format("item.%s%s", Reference.MOD_ID.toLowerCase() + ":", getUnwrappedUnlocalizedName(super.getUnlocalizedName()));
	}

	protected String getUnwrappedUnlocalizedName(String unlocalizedName)
	{
		return unlocalizedName.substring(unlocalizedName.indexOf(".") + 1);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister iconRegister)
	{
		itemIcon = iconRegister.registerIcon(this.getUnlocalizedName().substring(this.getUnlocalizedName().indexOf(".") + 1));
	}
}
