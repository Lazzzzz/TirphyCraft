package com.laz.tirphycraft.objects.items.other;

import java.util.List;

import com.laz.tirphycraft.init.BlockInit;
import com.laz.tirphycraft.init.ItemInit;
import com.laz.tirphycraft.objects.base.ItemBase;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityTNTPrimed;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.init.MobEffects;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArrow;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;

public class ItemRoseFinder extends ItemBase {

	public ItemRoseFinder(String name, int stack) {
		super(name, stack);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void addInformation(ItemStack stack, World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
		tooltip.add("\u00A75" + "Find blue rose in an area of 200x200");
		tooltip.add("\u00A75" + "Use 1 Frozen Crystal");

	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
		ItemStack item = playerIn.getHeldItem(handIn);
		if (!worldIn.isRemote) {
			if (playerIn.inventory.hasItemStack(new ItemStack(BlockInit.FROZEN_CRYSTAL))) {
				for (int x = -100; x < 100; x++) {
					for (int y = -20; y < 20; y++) {
						for (int z = -100; z < 100; z++) {
							if (worldIn.getBlockState(new BlockPos(x + playerIn.posX, y + playerIn.posY,
									z + playerIn.posZ)) == BlockInit.FROZ_PLANT_BLUE_ROSE.getDefaultState()) {

								playerIn.sendMessage(new TextComponentString(
										"\u00a7f" + "found at : x=" + (int) (x + playerIn.posX) + " y="
												+ (int) (y + playerIn.posY) + " z=" + (int) (z + playerIn.posZ)));

								playerIn.inventory.clearMatchingItems(
										new ItemStack(BlockInit.FROZEN_CRYSTAL, (int) (1)).getItem(), -1, 1, null);

								if (playerIn instanceof EntityPlayer) {
									if (!playerIn.isCreative())
										((EntityPlayer) playerIn).getCooldownTracker().setCooldown(this, 300);
								}
								return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, item);

							}
						}

					}
				}

				playerIn.sendMessage(new TextComponentString("\u00a7f" + "nothing..."));

				playerIn.inventory.clearMatchingItems(new ItemStack(BlockInit.FROZEN_CRYSTAL, (int) (1)).getItem(), -1,
						1, null);
			}

		}
		return new ActionResult<ItemStack>(EnumActionResult.FAIL, item);
	}

}
