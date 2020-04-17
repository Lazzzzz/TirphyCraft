package com.laz.tirphycraft.objects.items.legendary;

import java.util.List;

import com.laz.tirphycraft.Main;
import com.laz.tirphycraft.objects.base.ItemBase;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class TotemThunder extends ItemBase {

	public TotemThunder() {
		super("totem_thunder", 1);
		this.setMaxDamage(10);

	}

	@Override
	public void addInformation(ItemStack stack, World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
		tooltip.add("\u00A75" + "10 use");
		tooltip.add("\u00A75" + "20s cooldown");
		tooltip.add(" ");
		tooltip.add("\u00A74" + "+ Every mob will be struck down twice in a row in a radius of 10 blocks");

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
					BlockPos p = ((EntityLivingBase) list.get(i)).getPosition();
					for (int j = 0; j < 2; j++) {
						EntityLightningBolt m = new EntityLightningBolt(worldIn, p.getX(), p.getY(), p.getZ(), false);
						worldIn.addWeatherEffect(m);
					}
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
