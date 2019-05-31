package com.laz.tirphycraft.objects.items.staff;

import java.util.List;

import com.laz.tirphycraft.Main;
import com.laz.tirphycraft.init.ItemInit;
import com.laz.tirphycraft.util.interfaces.IHasModel;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.item.EntityTNTPrimed;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class StaffExplosion2 extends Item implements IHasModel{
	public StaffExplosion2(String name) {
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
		tooltip.add("\u00A74" + "fire 2 tnt");
		tooltip.add("");
		tooltip.add("\u00A7c" + "cooldown : 2s");
		
	}	
	

	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
		ItemStack item = playerIn.getHeldItem(handIn);
		Vec3d aim = playerIn.getLookVec();
		
		if (!worldIn.isRemote) {
			double x = (playerIn.posX + aim.x * 1.5D);
			double y = (playerIn.posY + aim.y * 1.5D + 1);
			double z = (playerIn.posZ + aim.z * 1.5D);
			
			item.damageItem(1, playerIn);
	
			EntityTNTPrimed tnt  = new EntityTNTPrimed(worldIn, x, y, z, playerIn);
			EntityTNTPrimed tnt2 = new EntityTNTPrimed(worldIn, x, y, z, playerIn);
			
			tnt.motionX = aim.x * 1.1D;
			tnt.motionY = aim.y * 1.1D;
			tnt.motionZ = aim.z * 1.1D;
	
			tnt2.motionX = aim.x * 1D;
			tnt2.motionY = aim.y * 2D;
			tnt2.motionZ = aim.z * 1D;		
			
			worldIn.spawnEntity(tnt);
			worldIn.spawnEntity(tnt2);
	
			if (playerIn instanceof EntityPlayer)
	        {
	            ((EntityPlayer)playerIn).getCooldownTracker().setCooldown(this, 40);
	        }		
		}
		
		return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, item);

	}
	@Override
	public void registerModels() {
		Main.proxy.registerItemRenderer(this, 0, "inventory");
		
	}
}
