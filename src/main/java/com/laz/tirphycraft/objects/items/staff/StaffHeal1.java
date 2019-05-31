package com.laz.tirphycraft.objects.items.staff;

import java.util.List;

import com.laz.tirphycraft.Main;
import com.laz.tirphycraft.init.ItemInit;
import com.laz.tirphycraft.util.interfaces.IHasModel;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

public class StaffHeal1 extends Item implements IHasModel{
	public StaffHeal1(String name) {
		{
			setUnlocalizedName(name);
			setRegistryName(name);	
			this.maxStackSize = 1;
			this.setMaxDamage(9);
			this.setCreativeTab(Main.tirphycrafttab);
			ItemInit.ITEMS.add(this);
		}
	}
	
	@Override
	public void addInformation(ItemStack stack, World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
		tooltip.add("\u00A75" + "When used :");
		tooltip.add("\u00A74" + "+ 2 heart");
		tooltip.add("");
		tooltip.add("\u00A7c" + "cooldown : 5s");

	}	
	

	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
		ItemStack item = playerIn.getHeldItem(handIn);
		if (playerIn.getHealth() < playerIn.getMaxHealth()) {
			playerIn.addPotionEffect(new PotionEffect(MobEffects.INSTANT_HEALTH, 1, 0, false, false));
			item.damageItem(1, playerIn);
			return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, item);
		}
		
		if (playerIn instanceof EntityPlayer) {
			((EntityPlayer) playerIn).getCooldownTracker().setCooldown(this, 100);
		}
		
		return new ActionResult<ItemStack>(EnumActionResult.PASS, item);
	}
	@Override
	public void registerModels() {
		Main.proxy.registerItemRenderer(this, 0, "inventory");
		
	}
}
