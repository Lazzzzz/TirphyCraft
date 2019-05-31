package com.laz.tirphycraft.objects.items.canon.noxis;

import java.util.List;

import com.laz.tirphycraft.objects.base.ItemBase;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.init.Enchantments;
import net.minecraft.init.Items;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.world.World;

public class CanonNixium extends ItemBase {

	public CanonNixium() {
		super("canon_nixium", 1);
		this.setMaxDamage(100);
	}
	@Override
	public void addInformation(ItemStack stack, World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
		tooltip.add("\u00A75" + "WIP");

	}
	
	@Override
	public void onUsingTick(ItemStack itemstack, EntityLivingBase entityLivingBase, int count) {
		World world = entityLivingBase.world;
		if (!world.isRemote && entityLivingBase instanceof EntityPlayer) {
			EntityPlayer entity = (EntityPlayer) entityLivingBase;
			boolean flag = entity.capabilities.isCreativeMode || EnchantmentHelper.getEnchantmentLevel(Enchantments.INFINITY, itemstack) > 0;
			if (flag || entity.inventory.hasItemStack(new ItemStack(Items.GUNPOWDER, (int) (1)))) {
				float f = 1F;
				NixiumArrow entityarrow = new NixiumArrow(world, entity);
				entityarrow.shoot(entity.getLookVec().x, entity.getLookVec().y, entity.getLookVec().z, f * 2.0F, 0);
				entityarrow.setIsCritical(true);
				entityarrow.setDamage(5);
				entityarrow.setKnockbackStrength(5);
				entityarrow.setFire(100);
				itemstack.damageItem(1, entity);
				int x = (int) entity.posX;
				int y = (int) entity.posY;
				int z = (int) entity.posZ;
				world.playSound((EntityPlayer) null, (double) x + 0.5D, (double) y + 0.5D, (double) z + 0.5D,
						(net.minecraft.util.SoundEvent) net.minecraft.util.SoundEvent.REGISTRY.getObject(new ResourceLocation(
								("entity.arrow.shoot"))), SoundCategory.NEUTRAL, 1.0F, 1.0F / (itemRand.nextFloat() * 0.4F + 1.2F) + f * 0.5F);
				if (flag) {
					entityarrow.pickupStatus = EntityArrow.PickupStatus.CREATIVE_ONLY;
				} else {
					entity.inventory.clearMatchingItems(new ItemStack(Items.GUNPOWDER, (int) (1)).getItem(), -1, 1, null);
				}
				if (!world.isRemote)
					world.spawnEntity(entityarrow);
			}
			entity.stopActiveHand();
		}
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer entity, EnumHand hand) {
		entity.setActiveHand(hand);
		return new ActionResult(EnumActionResult.SUCCESS, entity.getHeldItem(hand));
	}

	@Override
	public EnumAction getItemUseAction(ItemStack itemstack) {
		return EnumAction.BOW;
	}

	@Override
	public int getMaxItemUseDuration(ItemStack itemstack) {
		return 72000;
	}
}


