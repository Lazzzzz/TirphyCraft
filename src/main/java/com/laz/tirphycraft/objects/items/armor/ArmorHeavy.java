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

public class ArmorHeavy extends ItemArmor implements IHasModel {
	public ArmorHeavy(String name, ArmorMaterial materialIn, int renderIndexIn,
			EntityEquipmentSlot equipmentSlotIn) {
		super(materialIn, renderIndexIn, equipmentSlotIn);
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(Main.tirphycrafttab);

		ItemInit.ITEMS.add(this);
	}

	@Override
	public void addInformation(ItemStack stack, World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
		tooltip.add("\u00A75" + "When equipped :");
		tooltip.add("\u00A74" + "+ Resistance II");
		tooltip.add("\u00A74" + "+ Slowness II");
		tooltip.add("\u00A74" + "+ GRAVITY WANTS YOU !");
	}

	@Override
	public void onArmorTick(World world, EntityPlayer player, ItemStack item)
	{
		if (player.getItemStackFromSlot(EntityEquipmentSlot.FEET).getItem() == ItemInit.HEAVY_BOOTS
				&& player.getItemStackFromSlot(EntityEquipmentSlot.LEGS).getItem() == ItemInit.HEAVY_LEGGINGS
				&& player.getItemStackFromSlot(EntityEquipmentSlot.CHEST).getItem() == ItemInit.HEAVY_CHESTPLATE
				&& player.getItemStackFromSlot(EntityEquipmentSlot.HEAD).getItem() == ItemInit.HEAVY_HELMET) {
				
			if (player.isCreative() != true) {
					if (player.motionY < 0) {
						player.motionY -= 0.02;
					}
				}
			((EntityLivingBase) player).addPotionEffect(new PotionEffect(MobEffects.RESISTANCE, 20, 1, false, false));
				((EntityLivingBase) player).addPotionEffect(new PotionEffect(MobEffects.SLOWNESS, 20, 1, false, false));

			}
	}

	@Override
	public void registerModels() {
		Main.proxy.registerItemRenderer(this, 0, "inventory");
	}
}