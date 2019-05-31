package com.laz.tirphycraft.objects.items.armor;

import java.util.List;

import com.laz.tirphycraft.Main;
import com.laz.tirphycraft.init.ItemInit;
import com.laz.tirphycraft.util.interfaces.IHasModel;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class ArmorRose extends ItemArmor implements IHasModel {
	public ArmorRose(String name, ArmorMaterial materialIn, int renderIndexIn, EntityEquipmentSlot equipmentSlotIn) {
		super(materialIn, renderIndexIn, equipmentSlotIn);
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(Main.tirphycrafttab);

		ItemInit.ITEMS.add(this);
	}

	@Override
	public void addInformation(ItemStack stack, World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
		tooltip.add("\u00A75" + "When equipped :");
		tooltip.add("\u00A74" + "+ Walk on powder snow");
		tooltip.add("\u00A74" + "+ extinguish the fire");
		tooltip.add("\u00A74" + "+ Speed II");
	}

	@Override
	public void onArmorTick(World world, EntityPlayer player, ItemStack item) {
		if (player.getItemStackFromSlot(EntityEquipmentSlot.FEET).getItem() == ItemInit.ROSE_BOOTS
				&& player.getItemStackFromSlot(EntityEquipmentSlot.LEGS).getItem() == ItemInit.ROSE_LEGGINGS
				&& player.getItemStackFromSlot(EntityEquipmentSlot.CHEST).getItem() == ItemInit.ROSE_CHESTPLATE
				&& player.getItemStackFromSlot(EntityEquipmentSlot.HEAD).getItem() == ItemInit.ROSE_HELMET) {

			((EntityLivingBase) player).addPotionEffect(new PotionEffect(MobEffects.SPEED, 20, 1, false, false));
			((EntityLivingBase) player).extinguish();
		}
	}


	@Override
	public void registerModels() {
		Main.proxy.registerItemRenderer(this, 0, "inventory");
	}
}

