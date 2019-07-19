package com.laz.tirphycraft.dimension.Laputa;

import com.laz.tirphycraft.entity.entityClass.projectile.EntityMeteorite;

import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.MobEffects;
import net.minecraft.init.PotionTypes;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.potion.PotionType;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.PlayerTickEvent;

@EventBusSubscriber
public class LaputaEvent {

	@SubscribeEvent
	public static void fall(PlayerTickEvent event) {
		if (event.player.dimension == 121) {
			if (event.player.posY < -20) {
				if (event.player instanceof EntityPlayerMP) {
					MinecraftServer minecraftserver = FMLCommonHandler.instance().getMinecraftServerInstance();
					if (minecraftserver != null) {
						minecraftserver.getCommandManager().executeCommand((EntityPlayerMP) event.player, "tpdim 0");
					}
				}
			}

		}

	}

	@SubscribeEvent
	public static void meteorite(PlayerTickEvent event) {
		World world = event.player.world;
		Vec3d vec = event.player.getLookVec();
		

		if (world.getWorldTime() % 1000 == 0 && event.player.dimension == 121 && !world.isRemote && world.rand.nextInt(10) == 0) {
			EntityMeteorite e = new EntityMeteorite(world);
			e.setPosition(event.player.posX + 50 * -vec.x, event.player.posY + 100, event.player.posZ + 50 * -vec.z);
			
			e.setVel(5 * vec.x, -5, 5 * vec.z);
			
			if (!world.isRemote) {
				world.spawnEntity(e);
			}

		}

	}
}
