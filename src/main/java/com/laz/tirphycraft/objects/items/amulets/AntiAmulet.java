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

public class AntiAmulet extends ItemBase{

	public AntiAmulet() {
		super("anti_amulet", 1);
		this.setMaxDamage(16);
			
	}
	
	@Override
	public void addInformation(ItemStack stack, World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
		tooltip.add("\u00A75" + "When used :");
		tooltip.add("\u00A74" + "Remove all amulets addons");

	}	
	

	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
		ItemStack item = playerIn.getHeldItem(handIn);
		
		((EntityLivingBase) playerIn).getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(20D);
		((EntityLivingBase) playerIn).getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(2.0D);
		((EntityLivingBase) playerIn).getEntityAttribute(SharedMonsterAttributes.ATTACK_SPEED).setBaseValue(4.0D);
		item.damageItem(1, playerIn);
		return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, item);

	}
	
	@Override
	public void registerModels() {
		Main.proxy.registerItemRenderer(this, 0, "inventory");
		
	}	

}
