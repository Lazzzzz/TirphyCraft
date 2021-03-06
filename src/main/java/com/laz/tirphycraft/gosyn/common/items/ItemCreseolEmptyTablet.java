package com.laz.tirphycraft.gosyn.common.items;

import com.laz.tirphycraft.Main;
import com.laz.tirphycraft.init.ItemInit;
import com.laz.tirphycraft.util.interfaces.IHasModel;

import net.minecraft.item.Item;

public class ItemCreseolEmptyTablet extends Item implements IHasModel {
	public ItemCreseolEmptyTablet() {
		setUnlocalizedName("creseol_empty_tablet");
		setRegistryName("creseol_empty_tablet");
		setCreativeTab(Main.tirphycrafttab);
		setMaxStackSize(1);

		ItemInit.ITEMS.add(this);

	}

	@Override
	public void registerModels() {
		Main.proxy.registerItemRenderer(this, 0, "inventory");

	}

}
