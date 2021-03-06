package com.laz.tirphycraft.init;

import com.laz.tirphycraft.potion.FreezePotion;

import net.minecraft.init.Items;
import net.minecraft.init.PotionTypes;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.potion.PotionHelper;
import net.minecraft.potion.PotionType;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

public class PotionInit {
	public static final Potion FREEZE = new FreezePotion();
		
	public static final PotionType FREEZE_NORMAL = new PotionType("freeze", new PotionEffect[] {new PotionEffect(FREEZE, 2400)}).setRegistryName("freeze");
	public static final PotionType FREEZE_LONG = new PotionType("freeze", new PotionEffect[] {new PotionEffect(FREEZE, 4800)}).setRegistryName("long_freeze");

	public static void registerPotions() {
		registerPotion(FREEZE_NORMAL, FREEZE_LONG, FREEZE);
		
		registerPotionMixes();
	}
	
	private static void registerPotion(PotionType defaultPotion, PotionType longPotion, Potion effect) {
		ForgeRegistries.POTIONS.register(effect);
		ForgeRegistries.POTION_TYPES.register(defaultPotion);
		ForgeRegistries.POTION_TYPES.register(longPotion);
	}
	
	private static void registerPotionMixes() {
		PotionHelper.addMix(FREEZE_NORMAL, Items.REDSTONE, FREEZE_LONG);
		PotionHelper.addMix(PotionTypes.SLOWNESS, Items.SNOWBALL, FREEZE_NORMAL);
	}
}
