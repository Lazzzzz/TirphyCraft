package com.laz.tirphycraft.objects.items.other;

import com.laz.tirphycraft.objects.base.ItemBase;

import net.minecraft.item.ItemStack;

public class ItemTeniumIngot extends ItemBase{

	public ItemTeniumIngot(String name, int stack) {
		super(name, stack);
	}
	@Override
	public boolean hasEffect(ItemStack stack) {
		return true;
	}

	
}
