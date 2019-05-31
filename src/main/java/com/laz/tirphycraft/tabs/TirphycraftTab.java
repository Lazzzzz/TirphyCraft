package com.laz.tirphycraft.tabs;

import com.laz.tirphycraft.init.BlockInit;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class TirphycraftTab extends CreativeTabs {
	
	public TirphycraftTab(String label) { 
		super("tirphycrafttab");
		this.setBackgroundImageName("item_search.png");
		
	}

	public ItemStack getTabIconItem() { 
		return new ItemStack(Item.getItemFromBlock(BlockInit.BRICK_DUNGEON));
	}
	
	@SideOnly(Side.CLIENT)
	public boolean hasSearchBar() {
		return true;
	}

}
