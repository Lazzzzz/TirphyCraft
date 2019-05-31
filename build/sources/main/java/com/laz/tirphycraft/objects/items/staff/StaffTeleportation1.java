package com.laz.tirphycraft.objects.items.staff;

import java.util.List;

import com.laz.tirphycraft.Main;
import com.laz.tirphycraft.init.ItemInit;
import com.laz.tirphycraft.util.interfaces.IHasModel;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class StaffTeleportation1 extends Item implements IHasModel {
	public StaffTeleportation1(String name) {
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
		tooltip.add("\u00A74" + "teleport 10 blocks");
		tooltip.add("");
		tooltip.add("\u00A7c" + "cooldown : 1s");

	}		
	
	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
		ItemStack item = playerIn.getHeldItem(handIn);
		Vec3d aim = playerIn.getLookVec();

		double x = (playerIn.posX + aim.x * 10);
		double y = (playerIn.posY + aim.y * 10);
		double z = (playerIn.posZ + aim.z * 10);
		
		if (worldIn.getBlockState(new BlockPos(x,y,z)).getBlock() == Blocks.AIR) {

			playerIn.setPosition(x, y, z);
			item.damageItem(1, playerIn);
			
			if (playerIn instanceof EntityPlayer) {
				((EntityPlayer) playerIn).getCooldownTracker().setCooldown(this, 20);
			}
			
			return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, item);

		}
		
		return new ActionResult<ItemStack>(EnumActionResult.PASS, item);
	}

	@Override
	public void registerModels() {
		Main.proxy.registerItemRenderer(this, 0, "inventory");

	}
}
