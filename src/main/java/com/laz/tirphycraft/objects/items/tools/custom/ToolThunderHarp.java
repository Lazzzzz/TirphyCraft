package com.laz.tirphycraft.objects.items.tools.custom;

import com.laz.tirphycraft.objects.base.ItemBase;

import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class ToolThunderHarp extends ItemBase {

	public ToolThunderHarp(String name) {
		super(name, 1);
		this.setMaxDamage(150);
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
		ItemStack item = playerIn.getHeldItem(handIn);
		Vec3d dir = playerIn.getLookVec();
		for (int i = 3; i < 8; i++) {

			double x = playerIn.posX + (dir.x * i * i);
			double y = playerIn.posY + (dir.y * i * i);
			double z = playerIn.posZ + (dir.z * i * i);
			EntityLightningBolt m = new EntityLightningBolt(worldIn, x, y, z, false);

			worldIn.addWeatherEffect(m);

		}

		if (playerIn instanceof EntityPlayer) {
			((EntityPlayer) playerIn).getCooldownTracker().setCooldown(this, 30);
		}
		item.damageItem(1, playerIn);
		return super.onItemRightClick(worldIn, playerIn, handIn);
	}

}