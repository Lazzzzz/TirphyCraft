package com.laz.tirphycraft.objects.items.legendary;

import java.util.List;

import com.laz.tirphycraft.Main;
import com.laz.tirphycraft.init.ItemInit;
import com.laz.tirphycraft.objects.base.ItemBase;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class TotemLevitation extends ItemBase {

	public TotemLevitation() {
		super("totem_levitation", 1);
		this.setMaxDamage(10);

	}

	@Override
	public void addInformation(ItemStack stack, World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
		tooltip.add("\u00A75" + "10 use");
		tooltip.add("\u00A75" + "20s cooldown");
		tooltip.add(" ");
		tooltip.add("\u00A74" + "+ Every mob will levitate in a radius of 20 blocks");


	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
		ItemStack item = playerIn.getHeldItem(handIn);
		BlockPos pos = playerIn.getPosition();
		AxisAlignedBB box = new AxisAlignedBB(pos.getX() - 10, pos.getY() - 10, pos.getZ() - 10, pos.getX() + 10,
				pos.getY() + 10, pos.getZ() + 10);

		List list = worldIn.getEntitiesWithinAABB(EntityLivingBase.class, box);
		if (!list.isEmpty()) {
			
			for (int i = 0; i <= list.size() - 1; i++) {
				if (!(list.get(i) instanceof EntityPlayer)) {
					((EntityLivingBase) list.get(i))
							.addPotionEffect(new PotionEffect(MobEffects.LEVITATION, (worldIn.rand.nextInt(15) + 15) * 20, 0, false, false));

				}
			}
			item.damageItem(1, playerIn);
			((EntityPlayer) playerIn).getCooldownTracker().setCooldown(this, 20 * 20);
			return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, item);

		}
		return new ActionResult<ItemStack>(EnumActionResult.FAIL, item);
	}

	@Override
	public void registerModels() {
		Main.proxy.registerItemRenderer(this, 0, "inventory");

	}

}
