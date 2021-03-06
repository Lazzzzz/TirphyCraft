package com.laz.tirphycraft.gosyn.common.items;

import com.laz.tirphycraft.Main;
import com.laz.tirphycraft.init.ItemInit;
import com.laz.tirphycraft.util.interfaces.IHasModel;

import net.minecraft.item.Item;

public class ItemAiguiteGem extends Item implements IHasModel {
	public ItemAiguiteGem() {
		setUnlocalizedName("aiguite_gem");
		setRegistryName("aiguite_gem");
		setCreativeTab(Main.tirphycrafttab);
		setMaxStackSize(64);

		ItemInit.ITEMS.add(this);

	}

	
	@Override
	public void registerModels() {
		Main.proxy.registerItemRenderer(this, 0, "inventory");

	}
}
