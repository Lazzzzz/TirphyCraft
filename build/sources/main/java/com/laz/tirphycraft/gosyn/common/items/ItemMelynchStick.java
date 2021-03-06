package com.laz.tirphycraft.gosyn.common.items;

import com.laz.tirphycraft.Main;
import com.laz.tirphycraft.init.ItemInit;
import com.laz.tirphycraft.util.interfaces.IHasModel;

import net.minecraft.item.Item;

public class ItemMelynchStick extends Item implements IHasModel {
	public ItemMelynchStick() {
		setUnlocalizedName("melynch_stick");
		setRegistryName("melynch_stick");
		setCreativeTab(Main.tirphycrafttab);
		setMaxStackSize(64);

		ItemInit.ITEMS.add(this);

	}

	@Override
	public void registerModels() {
		Main.proxy.registerItemRenderer(this, 0, "inventory");

	}

}
