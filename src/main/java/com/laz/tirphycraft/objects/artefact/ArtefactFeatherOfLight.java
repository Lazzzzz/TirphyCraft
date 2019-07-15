package com.laz.tirphycraft.objects.artefact;

import java.util.List;

import com.laz.tirphycraft.objects.base.ItemBase;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ArtefactFeatherOfLight extends ItemBase {

	public ArtefactFeatherOfLight() {
		super("feather_of_light", 1);

	}
	
	@Override
	public void addInformation(ItemStack stack, World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
		tooltip.add("\u00A75" + "When in inventory :");
		tooltip.add("\u00A74" + "no fall damage");

	}

	@Override
	public void onUpdate(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
		entityIn.fallDistance = 0;
	}

}
