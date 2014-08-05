package com.nisheeth.testmod.item.tools.sword;

import com.nisheeth.testmod.creativetab.CreativeTabTest;
import com.nisheeth.testmod.init.ModItems;
import com.nisheeth.testmod.item.ItemSteelIngot;
import com.nisheeth.testmod.item.MaterialsTest;
import com.nisheeth.testmod.reference.Reference;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import com.nisheeth.testmod.utility.NBTHelper;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.IIcon;
import net.minecraftforge.oredict.OreDictionary;

import java.util.List;

public class ItemSteelSword extends ItemSword
{
	private static IIcon coldSwordIcon;
	private static IIcon warmSwordIcon;
	private static IIcon hotSwordIcon;

	public static final String TAG_TEMPERATURE = "Temperature";
	public static final int warmTemperature = 1;
	public static final int hotTemperature = 2;


	public ItemSteelSword()
    {
		super(MaterialsTest.SteelMaterial);
        this.setUnlocalizedName("steelSword");
        this.setMaxStackSize(1);
        this.setMaxDamage(1600);
		this.setCreativeTab(CreativeTabTest.TEST_TABS);
	}

	@Override
	public void addInformation(ItemStack itemStack, EntityPlayer player, List list, boolean bool)
	{
		int temperature = NBTHelper.getInt(itemStack, TAG_TEMPERATURE);
		String temper = "";

		if (temperature >= 0 && temperature < warmTemperature)
			temper = "";
		else if (temperature >= warmTemperature && temperature < hotTemperature)
			temper = "Warm";
		else if (temperature >= hotTemperature)
			temper = "Hot";

		list.add(TAG_TEMPERATURE +  ": " + temperature);
		list.add(temper);
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
		coldSwordIcon = iconRegister.registerIcon("testmod:steelSword");
		warmSwordIcon = iconRegister.registerIcon("testmod:warmsteelSword");
		hotSwordIcon = iconRegister.registerIcon("testmod:hotsteelSword");
	}

	@Override
	public IIcon getIcon(ItemStack stack, int renderPass, EntityPlayer player, ItemStack usingItem, int useRemaining)
	{
		int temperature = NBTHelper.getInt(stack,TAG_TEMPERATURE);

		if (temperature >= 0 && temperature < warmTemperature)
			return coldSwordIcon;
		else if (temperature >= warmTemperature && temperature < hotTemperature)
			return warmSwordIcon;
		else if (temperature >= hotTemperature)
			return hotSwordIcon;
		else
			return coldSwordIcon;
	}

	public static void heatSword()
	{
		ItemStack coldGenSwordStack = new ItemStack(ModItems.steelSword, 1, OreDictionary.WILDCARD_VALUE);
		ItemStack warmGenSwordStack = new ItemStack(ModItems.steelSword, 1, OreDictionary.WILDCARD_VALUE);
		ItemStack warmOutSwordStack = new ItemStack(ModItems.steelSword);
		ItemStack hotOutSwordStack = new ItemStack(ModItems.steelSword);

		NBTHelper.setInteger(coldGenSwordStack, TAG_TEMPERATURE, 0);
		NBTHelper.setInteger(warmOutSwordStack, TAG_TEMPERATURE, warmTemperature);
		NBTHelper.setInteger(warmGenSwordStack, TAG_TEMPERATURE, warmTemperature);
		NBTHelper.setInteger(hotOutSwordStack, TAG_TEMPERATURE, hotTemperature);

		GameRegistry.addSmelting(coldGenSwordStack,warmOutSwordStack,0);
		GameRegistry.addSmelting(warmGenSwordStack, hotOutSwordStack,0);
	}
}