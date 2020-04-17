package com.laz.tirphycraft.event;

import com.laz.tirphycraft.Main;
import com.laz.tirphycraft.entity.entityClass.projectile.EntityMeteorite;
import com.laz.tirphycraft.util.handlers.ConfigHandler;
import com.laz.tirphycraft.util.interfaces.ParticleTypes;

import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraftforge.event.world.WorldEvent;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.PlayerTickEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@EventBusSubscriber
public class LaputaEvent {

	@SubscribeEvent
	public static void fall(PlayerTickEvent event) {
		if (event.player.dimension == ConfigHandler.DIMENSION_LAPUTA_ID) {
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

		if (world.getWorldTime() % 2400 == 0 && event.player.dimension == ConfigHandler.DIMENSION_LAPUTA_ID
				&& !world.isRemote && world.rand.nextInt(50) == 0) {
			EntityMeteorite e = new EntityMeteorite(world);
			e.setPosition(event.player.posX + 50 * -vec.x, event.player.posY + 100, event.player.posZ + 50 * -vec.z);

			e.setVel(5 * vec.x, -5, 5 * vec.z);

			if (!world.isRemote) {
				world.spawnEntity(e);
			}

		}

	}
	

	@SideOnly(value = Side.CLIENT)
	@SubscribeEvent
	public static void centerWorld(WorldEvent event) {
		World world = event.getWorld();
		if (world.provider.getDimension() == ConfigHandler.DIMENSION_LAPUTA_ID && world.rand.nextInt(1000) == 0) {
			switch (world.rand.nextInt(5)) {
			case 0:
				Main.proxy.spawnParticle(world, ParticleTypes.GLINT_BLUE, 8, 100 + world.rand.nextDouble() * 5, 8,
						world.rand.nextDouble() / 4 - 0.125, 0, world.rand.nextDouble() / 4 - 0.125);
				break;

			case 1:
				Main.proxy.spawnParticle(world, ParticleTypes.GLINT_GREEN, 8, 100 + world.rand.nextDouble() * 5, 8,
						world.rand.nextDouble() / 4 - 0.125, 0, world.rand.nextDouble() / 4 - 0.125);
				break;
			case 2:
				Main.proxy.spawnParticle(world, ParticleTypes.GLINT_PINK, 8, 100 + world.rand.nextDouble() * 5, 8,
						world.rand.nextDouble() / 4 - 0.125, 0, world.rand.nextDouble() / 4 - 0.125);
				break;
			case 3:
				Main.proxy.spawnParticle(world, ParticleTypes.GLINT_PURPLE, 8, 100 + world.rand.nextDouble() * 5, 8,
						world.rand.nextDouble() / 4 - 0.125, 0, world.rand.nextDouble() / 4 - 0.125);
				break;
			case 4:
				Main.proxy.spawnParticle(world, ParticleTypes.GLINT_YELLOW, 8, 100 + world.rand.nextDouble() * 5, 8,
						world.rand.nextDouble() / 4 - 0.125, 0, world.rand.nextDouble() / 4 - 0.125);
				break;

			}
		}
	}

}
