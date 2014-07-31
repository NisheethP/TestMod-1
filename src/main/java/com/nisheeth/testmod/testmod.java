package com.nisheeth.testmod;

import com.nisheeth.testmod.handler.ConfigurationHandler;
import com.nisheeth.testmod.init.ModBlocks;
import com.nisheeth.testmod.init.ModItems;
import com.nisheeth.testmod.init.Recipes;
import com.nisheeth.testmod.proxy.IProxy;
import com.nisheeth.testmod.utility.LogHelper;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import com.nisheeth.testmod.reference.Reference;


@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.VERSION,guiFactory = Reference.GUI_FACTORY_CLASS)
public class testmod
{
    @Mod.Instance (Reference.MOD_ID)
    public static testmod instance;

    @SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.SERVER_PROXY_CLASS)
    public static IProxy proxy;

    @Mod.EventHandler
    public void preInit (FMLPreInitializationEvent event)
    {
        ConfigurationHandler.init(event.getSuggestedConfigurationFile());
		FMLCommonHandler.instance().bus().register(new ConfigurationHandler());
		ModItems.init();
		ModBlocks.Init();
	}

    @Mod.EventHandler
    public void Init (FMLInitializationEvent event)
    {
        Recipes.init();
		LogHelper.info("Intitalization Complete!");
    }

    @Mod.EventHandler
    public void postInit (FMLPostInitializationEvent event)
    {
		LogHelper.info("Post-intitalization Complete!");
    }
}
