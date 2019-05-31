package com.laz.tirphycraft.objects.base;

import com.laz.tirphycraft.Main;
import com.laz.tirphycraft.init.ItemInit;
import com.laz.tirphycraft.util.interfaces.IHasModel;

import net.minecraft.item.Item;

public class ItemBase extends Item implements IHasModel {

	public ItemBase(String name, int stack) {
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(Main.tirphycrafttab);
		setMaxStackSize(stack);
		
		ItemInit.ITEMS.add(this);
		System.out.println("initialization " + name);

		
	}

	@Override
	public void registerModels() {
		Main.proxy.registerItemRenderer(this, 0, "inventory");
		
	}

}
