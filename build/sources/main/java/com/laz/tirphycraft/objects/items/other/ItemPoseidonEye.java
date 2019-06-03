package com.laz.tirphycraft.objects.items.other;

import java.util.List;

import com.laz.tirphycraft.objects.base.ItemBase;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemPoseidonEye extends ItemBase {

	public ItemPoseidonEye() {
		super("poseidon_eye", 64);
		setUnlocalizedName("poseidon_eye");
	}
	
	@Override
	public void addInformation(ItemStack stack, World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
		tooltip.add("\u00A75" + "Trade with villager");
		tooltip.add("\u00A75" + "to get sea core");

	}	

	@Override
	public boolean hasEffect(ItemStack stack) {
		return true;
	}
	
}
