package com.laz.tirphycraft.objects.items.tools.custom;

import com.laz.tirphycraft.objects.items.tools.ToolSwordBase;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;

public class ToolSwordExplosion extends ToolSwordBase {

	public ToolSwordExplosion(String name, ToolMaterial material) {
		super(name, material);
	}

	@Override
	public boolean hitEntity(ItemStack stack, EntityLivingBase target, EntityLivingBase attacker) {

		double x = ((EntityLivingBase) target).posX;
		double y = ((EntityLivingBase) target).posY;
		double z = ((EntityLivingBase) target).posZ;
		attacker.world.createExplosion(attacker, x, y + attacker.height / 8, z, 0.4F, false);

		return super.hitEntity(stack, target, attacker);
	}

}