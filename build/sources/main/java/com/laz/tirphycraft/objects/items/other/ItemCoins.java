package com.laz.tirphycraft.objects.items.other;

import java.util.List;

import com.laz.tirphycraft.objects.base.ItemBase;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemCoins extends ItemBase {

	public ItemCoins() {
		super("coins", 64);
		setUnlocalizedName("coins");
	}
	
	@Override
	public void addInformation(ItemStack stack, World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
		tooltip.add("\u00A75" + "Trade with villager");
		tooltip.add("\u00A75" + "to get awesome loot");

	}	

	@Override
	public boolean hasEffect(ItemStack stack) {
		return true;
	}
	
}
