package com.laz.tirphycraft.potion;

import com.laz.tirphycraft.init.PotionInit;

import net.minecraft.util.DamageSource;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.PlayerTickEvent;

@EventBusSubscriber
public class FreezePotionEvent {

	@SubscribeEvent
	public static void potionActive(PlayerTickEvent event) {
		boolean isActive = false;
		if (event.player.isPotionActive(PotionInit.FREEZE))
			isActive = true;

		if (isActive) {

			if (event.player.getHealth() > 1.0F)
				event.player.attackEntityFrom(DamageSource.MAGIC, 0.2F);

		}
	}

}
