package com.nisheeth.testmod.creativetab;

import com.nisheeth.testmod.init.ModItems;
import com.nisheeth.testmod.reference.Reference;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class CreativeTabTest
{
    public static final CreativeTabs TEST_TABS = new CreativeTabs (Reference.MOD_ID)
    {
        @Override
        public Item getTabIconItem()
        {
            return ModItems.rock;
        }
    };

}
