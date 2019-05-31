package com.laz.tirphycraft.objects.items.staff;

import java.util.List;

import com.laz.tirphycraft.Main;
import com.laz.tirphycraft.init.ItemInit;
import com.laz.tirphycraft.util.interfaces.IHasModel;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityLargeFireball;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class StaffFireBall2 extends Item implements IHasModel {
	public StaffFireBall2(String name) {
		{
			setUnlocalizedName(name);
			setRegistryName(name);
			this.maxStackSize = 1;
			this.setMaxDamage(30);
			this.setCreativeTab(Main.tirphycrafttab);
			ItemInit.ITEMS.add(this);
		}
	}

	@Override
	public void addInformation(ItemStack stack, World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
		tooltip.add("\u00A75" + "When used :");
		tooltip.add("\u00A74" + "shoot fireball");
		tooltip.add("");
		tooltip.add("\u00A7c" + "cooldown : 0.5s");

	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
		ItemStack item = playerIn.getHeldItem(handIn);
		Vec3d aim = playerIn.getLookVec();
		
		EntityLargeFireball entity = new EntityLargeFireball(worldIn, playerIn, 1, 1, 1);
		
		entity.setPosition(playerIn.posX + aim.x, playerIn.posY + aim.y + 1, playerIn.posZ + aim.z);
		entity.accelerationX = aim.x * 0.2;
		entity.accelerationY = aim.y * 0.2;
		entity.accelerationZ = aim.z * 0.2;
		
		worldIn.spawnEntity(entity);
		
		item.damageItem(1, playerIn);

		if (playerIn instanceof EntityPlayer) {
			((EntityPlayer) playerIn).getCooldownTracker().setCooldown(this, 10);
		}
		
		return new ActionResult<ItemStack>(EnumActionResult.PASS, item);
	}

	@Override
	public void registerModels() {
		Main.proxy.registerItemRenderer(this, 0, "inventory");

	}
}
