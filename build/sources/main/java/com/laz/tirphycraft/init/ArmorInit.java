package com.laz.tirphycraft.init;

import com.laz.tirphycraft.util.Reference;

import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraftforge.common.util.EnumHelper;

public class ArmorInit {
	public static final ArmorMaterial PYRODES_ARMOR   = EnumHelper.addArmorMaterial("pyrodes_armor", Reference.MOD_ID + ":pyrodes", 30, new int[] {4, 7, 8, 4}, 15, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 0.0f);
	public static final ArmorMaterial HEAVY_ARMOR     = EnumHelper.addArmorMaterial("heavy_armor", Reference.MOD_ID + ":heavy", 50, new int[] {2, 5, 6, 2}, 10, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 4.0f);
	public static final ArmorMaterial NIXIUM_ARMOR    = EnumHelper.addArmorMaterial("nixium_armor", Reference.MOD_ID + ":nixium", 40, new int[]{5, 8, 9, 5}, 10, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 2.0F);
	public static final ArmorMaterial TENIUM_ARMOR 	  = EnumHelper.addArmorMaterial("tenium_armor", Reference.MOD_ID + ":tenium", 60, new int[]{7, 10, 11, 7}, 30, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 6.0F);
	public static final ArmorMaterial ROSE_ARMOR      = EnumHelper.addArmorMaterial("rose_armor", Reference.MOD_ID + ":rose", 30, new int[] {4, 7, 8, 4}, 15, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 0.0f);
	
	public static final ArmorMaterial PARACHUTE_ARMOR = EnumHelper.addArmorMaterial("parachute", Reference.MOD_ID + ":parachute", 10, new int[] {0, 0, 0, 0}, 10, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 0.0f);
	public static final ArmorMaterial GAS_MASK_ARMOR = EnumHelper.addArmorMaterial("gas_mask", Reference.MOD_ID + ":gas_mask", 15, new int[]{2, 5, 6, 2}, 9, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F);	
}
