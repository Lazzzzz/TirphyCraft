package com.laz.tirphycraft.objects.blocks.machine.pyrodes.slots;

import com.laz.tirphycraft.objects.blocks.machine.pyrodes.TileEntityPyrodesFurnace;

import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class SlotPyrodesFurnaceFuel extends Slot{
	public SlotPyrodesFurnaceFuel(IInventory inventory, int index, int x, int y) {
		super(inventory, index, x, y);
		
	}
	
	@Override
	public boolean isItemValid(ItemStack stack) {
		return TileEntityPyrodesFurnace.isItemFuel(stack);
	}
	
	@Override
	public int getItemStackLimit(ItemStack stack) {
		return super.getItemStackLimit(stack);
	}

}
