package com.laz.tirphycraft.objects.items.other;

import java.util.List;

import com.laz.tirphycraft.objects.base.ItemBase;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemQueenHeart extends ItemBase {
	public ItemQueenHeart() {
		super("queen_heart", 64);
		setUnlocalizedName("queen_heart");
	}

	@Override
	public void addInformation(ItemStack stack, World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
		tooltip.add("\u00A75" + "Trade with villager");
		tooltip.add("\u00A75" + "to get explosion core");

	}

	@Override
	public boolean hasEffect(ItemStack stack) {
		return true;
	}

}
