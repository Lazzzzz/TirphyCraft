package com.laz.tirphycraft.objects.items.amulets;

import java.util.List;

import com.laz.tirphycraft.Main;
import com.laz.tirphycraft.objects.base.ItemBase;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

public class Amulet_2_speed extends ItemBase{

	public Amulet_2_speed() {
		super("amulet_2_speed", 1);
		this.setMaxDamage(1);
			
	}
	
	@Override
	public void addInformation(ItemStack stack, World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
		tooltip.add("\u00A75" + "TIER 2");
		tooltip.add("\u00A75" + "Single use :");
		tooltip.add(" ");		
		tooltip.add("\u00A74" + "+ 50% attack speed");

	}	
	

	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
		ItemStack item = playerIn.getHeldItem(handIn);
		
		((EntityLivingBase) playerIn).getEntityAttribute(SharedMonsterAttributes.ATTACK_SPEED).setBaseValue(6D);
		item.damageItem(2, playerIn);
		return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, item);

	}
	
	@Override
	public void registerModels() {
		Main.proxy.registerItemRenderer(this, 0, "inventory");
		
	}	

}
