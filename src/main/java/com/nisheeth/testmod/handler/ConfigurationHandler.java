package com.nisheeth.testmod.handler;

import com.nisheeth.testmod.reference.Reference;
import cpw.mods.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.common.config.Configuration;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

import java.io.File;
import java.util.Locale;

public class ConfigurationHandler
{
    public static Configuration configuration;
	public static boolean testValue;

    public static void init (File configFile)
    {
        //Creating the config object based on config file:
        if (configuration == null)
		{
			configuration = new Configuration(configFile);
			loadConfiguration();
		}
    }


    @SubscribeEvent
    public void onConfigurationChangedEvent (ConfigChangedEvent.OnConfigChangedEvent event)
    {
        if (event.modID.equalsIgnoreCase(Reference.MOD_ID))
        {
            //Resync the config; i.e Reading from the config again:
			loadConfiguration();

        }
    }

    private static void loadConfiguration()
    {
        try
        {
            //Loading the config:
            configuration.load();

            //Reading the config file:
            testValue = configuration.getBoolean("testValue", Configuration.CATEGORY_GENERAL, false, "Test Config value");

        }
        catch(Exception e)
        {
            //Log the exception
        }

        finally
        {
            //Saving the config
            if (configuration.hasChanged())
            {
                configuration.save();
            }
        }
    }

}
