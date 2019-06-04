package com.laz.tirphycraft.world.dimensionFroz;

import com.laz.tirphycraft.init.ItemInit;
import com.laz.tirphycraft.init.PotionInit;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.potion.PotionEffect;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.PlayerTickEvent;

@EventBusSubscriber
public class FrozEvent {

	@SubscribeEvent
	public static void freez(PlayerTickEvent event) {
		if (event.player.dimension == 123) {
			if (!asProtection(event.player)) {
				event.player.addPotionEffect(new PotionEffect(PotionInit.FREEZE, 20*1, 0, false, false));
			}
		}
	}

	public static boolean asProtection(EntityPlayer player) {
		if ((
				player.getItemStackFromSlot(EntityEquipmentSlot.HEAD).getItem() == ItemInit.ROSE_HELMET
				&& player.getItemStackFromSlot(EntityEquipmentSlot.FEET).getItem() == ItemInit.ROSE_BOOTS
				&& player.getItemStackFromSlot(EntityEquipmentSlot.LEGS).getItem() == ItemInit.ROSE_LEGGINGS
				&& player.getItemStackFromSlot(EntityEquipmentSlot.CHEST).getItem() == ItemInit.ROSE_CHESTPLATE)
				|| 
				(player.getItemStackFromSlot(EntityEquipmentSlot.HEAD).getItem() == Items.LEATHER_HELMET
				&& player.getItemStackFromSlot(EntityEquipmentSlot.FEET).getItem() == Items.LEATHER_BOOTS
				&& player.getItemStackFromSlot(EntityEquipmentSlot.LEGS).getItem() == Items.LEATHER_LEGGINGS
				&& player.getItemStackFromSlot(EntityEquipmentSlot.CHEST).getItem() == Items.LEATHER_CHESTPLATE)) {
			return true;
		}
		return false;
	}

}
