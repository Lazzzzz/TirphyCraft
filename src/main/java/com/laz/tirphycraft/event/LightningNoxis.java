package com.laz.tirphycraft.event;

import java.util.Random;

import com.laz.tirphycraft.util.handlers.ConfigHandler;

import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.PlayerTickEvent;

@EventBusSubscriber
public class LightningNoxis {

	public static Random rand = new Random();

	@SubscribeEvent
	public static void getItem(PlayerTickEvent event) {
		World world = event.player.world;
		BlockPos pos = event.player.getPosition();

		if (world.getWorldTime() % 75 == 0 && event.player.dimension == ConfigHandler.DIMENSION_NOXIS_ID
				&& !world.isRemote && world.rand.nextInt(4) == 0) {

			int x = rand.nextInt(100) - 50;
			int z = rand.nextInt(100) - 50;
			int y = world.getHeight(x + pos.getX(), z + pos.getZ());
			if (y != 0) {
				EntityLightningBolt m = new EntityLightningBolt(world, x + pos.getX(), y, z + pos.getZ(), false);
				world.addWeatherEffect(m);
			}
		}

	}

}