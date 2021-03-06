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

public class ArmorPyrodes extends ItemArmor implements IHasModel {
	public ArmorPyrodes(String name, ArmorMaterial materialIn, int renderIndexIn, EntityEquipmentSlot equipmentSlotIn) {
		super(materialIn, renderIndexIn, equipmentSlotIn);
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(Main.tirphycrafttab);
		ItemInit.ITEMS.add(this);
	}

	@Override
	public void addInformation(ItemStack stack, World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
		tooltip.add("\u00A75" + "Full set :");
		tooltip.add("\u00A74" + "+ Resistance 1");
	}

	@Override
	public void onArmorTick(World world, EntityPlayer player, ItemStack item) {
		

		if (player.getItemStackFromSlot(EntityEquipmentSlot.FEET).getItem() == ItemInit.PYRODES_BOOTS
				&& player.getItemStackFromSlot(EntityEquipmentSlot.LEGS).getItem() == ItemInit.PYRODES_LEGGINGS
				&& player.getItemStackFromSlot(EntityEquipmentSlot.CHEST).getItem() == ItemInit.PYRODES_CHESTPLATE
				&& player.getItemStackFromSlot(EntityEquipmentSlot.HEAD).getItem() == ItemInit.PYRODES_HELMET) {
			
			((EntityLivingBase) player).addPotionEffect(new PotionEffect(MobEffects.RESISTANCE, 20, 0, false, false));
			
			}
		}

	
	private void onPlayerTick() {
		// TODO Auto-generated method stub

	}

	@Override
	public void registerModels() {
		Main.proxy.registerItemRenderer(this, 0, "inventory");
	}
}