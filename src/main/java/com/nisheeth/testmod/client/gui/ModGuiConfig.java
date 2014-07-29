package com.nisheeth.testmod.client.gui;

import com.nisheeth.testmod.handler.ConfigurationHandler;
import com.nisheeth.testmod.reference.Reference;
import cpw.mods.fml.client.config.GuiConfig;
import cpw.mods.fml.client.config.IConfigElement;
import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.common.config.ConfigElement;
import net.minecraftforge.common.config.Configuration;

import java.util.List;

public class ModGuiConfig extends GuiConfig
{

	public ModGuiConfig(GuiScreen guiScreen)
	{
		super(
					 guiScreen,
					 new ConfigElement (ConfigurationHandler.configuration.getCategory(Configuration.CATEGORY_GENERAL)).getChildElements(),
					 Reference.MOD_ID,
					 false,
					 false,
					 GuiConfig.getAbridgedConfigPath(ConfigurationHandler.configuration.toString())
			);
	}
}
