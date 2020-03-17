
package com.laz.tirphycraft.event;

import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@EventBusSubscriber
public class ToolsBoost {

	//WIP
	
	@SubscribeEvent
	public static void getItem(PlayerInteractEvent event) {
		if (!event.getWorld().isRemote) {
			
		}
	}
}
