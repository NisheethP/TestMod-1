package com.nisheeth.testmod.item;

import com.nisheeth.testmod.utility.NBTHelper;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

import java.util.List;

public class ItemSteelIngot extends ItemTest
{
    private static IIcon coldSteelIngotIcon;
    private static IIcon warmSteelIngotIcon;
    private static IIcon hotSteelIngotIcon;

    public static final String TAG_TEMPERATURE = "Temperature";

    private static final int warmTemperature = 1;
    private static final int hotTemperature = 2;

	public ItemSteelIngot()
    {
        super();
        this.setUnlocalizedName("steelIngot");
    }

    @Override
    public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean bool)
    {
        int temperature = NBTHelper.getInt(stack, TAG_TEMPERATURE);
        String heat = "";
        if (temperature >=0 && temperature < warmTemperature)
            heat = "";
        else if (temperature >= warmTemperature && temperature < hotTemperature)
            heat = "Warm";
		else if (temperature >= hotTemperature)
			heat = "Hot";

		list.add(heat);
        list.add(TAG_TEMPERATURE + ": " + temperature);
    }

	@Override
	public void registerIcons(IIconRegister iconRegister)
	{
		super.registerIcons(iconRegister);
		coldSteelIngotIcon = iconRegister.registerIcon("testmod:steelIngot");
		warmSteelIngotIcon = iconRegister.registerIcon("testmod:warmsteelIngot");
		hotSteelIngotIcon = iconRegister.registerIcon("testmod:hotsteelIngot");
	}
}
