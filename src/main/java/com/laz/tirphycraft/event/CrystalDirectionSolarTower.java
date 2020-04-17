package com.laz.tirphycraft.event;

import java.util.Random;

import com.laz.tirphycraft.Main;
import com.laz.tirphycraft.blockTile.tesseractActivated.TileEntityCrystalTesseractActivated;
import com.laz.tirphycraft.dimension.Laputa.DimensionLibraryLaputa;
import com.laz.tirphycraft.init.BlockInit;
import com.laz.tirphycraft.init.ItemInit;
import com.laz.tirphycraft.util.handlers.ConfigHandler;
import com.laz.tirphycraft.util.interfaces.ParticleTypes;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.PlayerTickEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@EventBusSubscriber
public class CrystalDirectionSolarTower {

	private static Random rand = new Random();

	static BlockPos posEvent;
	static int counter = 5 * 20;
	static int timer = 5 * 20; // 5s

	static int crystalType = 0;
	static DimensionLibraryLaputa gen;

	@SubscribeEvent
	public static void getItem(PlayerInteractEvent event) {
		if (!event.getWorld().isRemote && event.getEntityPlayer().dimension == ConfigHandler.DIMENSION_LAPUTA_ID) {
			EntityPlayer player = event.getEntityPlayer();
			BlockPos pos = event.getPos();
			Block block = event.getWorld().getBlockState(pos).getBlock();
			DimensionLibraryLaputa lib = (DimensionLibraryLaputa) player.world.provider;

			if (player.inventory.getCurrentItem().getItem() == ItemInit.AIGUITE_GEM) {
				if (block == BlockInit.LAPUTA_BLUE || block == BlockInit.LAPUTA_PINK || block == BlockInit.LAPUTA_PURPLE
						|| block == BlockInit.LAPUTA_YELLOW || block == BlockInit.LAPUTA_GREEN) {
					if (block == BlockInit.LAPUTA_BLUE)
						crystalType = 0;
					else if (block == BlockInit.LAPUTA_GREEN)
						crystalType = 1;
					else if (block == BlockInit.LAPUTA_PURPLE)
						crystalType = 2;
					else if (block == BlockInit.LAPUTA_PINK)
						crystalType = 3;
					else if (block == BlockInit.LAPUTA_YELLOW)
						crystalType = 4;

					gen = (DimensionLibraryLaputa) player.world.provider;
					posEvent = pos;
					counter = 0;
					if (rand.nextInt(3) == 0) {
						player.inventory.getCurrentItem().setCount(player.inventory.getCurrentItem().getCount() - 1);
					}
					player.world.destroyBlock(pos, false);

				}
				if (block == BlockInit.BRICK_LAPUTA) {
					for (int i = 0; i < 5; i++) {
						BlockPos posCrystal = new BlockPos(lib.posX[i] * 16 + 7, 100, lib.posY[i] * 16 + 7);
						if (posCrystal.getX() == pos.getX() && posCrystal.getY() == pos.getY()
								&& posCrystal.getZ() == pos.getZ()) {
							player.world.destroyBlock(posCrystal, false);
							player.world.setBlockState(posCrystal, BlockInit.TESSERACT_ACTIVATE.getDefaultState());
							player.world.setTileEntity(posCrystal, new TileEntityCrystalTesseractActivated());
							for (int j = 0; j < 100; j++) particlesExplosion(player.world, posCrystal);
						}
					}
					
				}

			}

		}
	}

	@SideOnly(value = Side.CLIENT)
	public static void particlesExplosion(World world, BlockPos pos) {
		int i = rand.nextInt(5);
		switch (i) {
		case 0:
			Main.proxy.spawnParticle(world, ParticleTypes.GLINT_BLUE, pos.getX() + rand.nextDouble(),
					pos.getY() + rand.nextDouble(), pos.getZ() + rand.nextDouble(), (rand.nextDouble() - 0.5) / 10,
					(rand.nextDouble() - 0.5) / 10, (rand.nextDouble() - 0.5) / 10);
			break;
		case 1:
			Main.proxy.spawnParticle(world, ParticleTypes.GLINT_YELLOW, pos.getX() + rand.nextDouble(),
					pos.getY() + rand.nextDouble(), pos.getZ() + rand.nextDouble(), (rand.nextDouble() - 0.5) / 10,
					(rand.nextDouble() - 0.5) / 10, (rand.nextDouble() - 0.5) / 10);
			break;
		case 2:
			Main.proxy.spawnParticle(world, ParticleTypes.GLINT_PINK, pos.getX() + rand.nextDouble(),
					pos.getY() + rand.nextDouble(), pos.getZ() + rand.nextDouble(), (rand.nextDouble() - 0.5) / 10,
					(rand.nextDouble() - 0.5) / 10, (rand.nextDouble() - 0.5) / 10);
			break;
		case 3:
			Main.proxy.spawnParticle(world, ParticleTypes.GLINT_PURPLE, pos.getX() + rand.nextDouble(),
					pos.getY() + rand.nextDouble(), pos.getZ() + rand.nextDouble(), (rand.nextDouble() - 0.5) / 10,
					(rand.nextDouble() - 0.5) / 10, (rand.nextDouble() - 0.5) / 10);
			break;
		case 4:
			Main.proxy.spawnParticle(world, ParticleTypes.GLINT_GREEN, pos.getX() + rand.nextDouble(),
					pos.getY() + rand.nextDouble(), pos.getZ() + rand.nextDouble(), (rand.nextDouble() - 0.5) / 10,
					(rand.nextDouble() - 0.5) / 10, (rand.nextDouble() - 0.5) / 10);
			break;
		}

	}

	@SideOnly(value = Side.CLIENT)
	@SubscribeEvent
	public static void eventParticles(PlayerTickEvent event) {
		EntityPlayer player = event.player;
		if (counter < timer) {
			counter++;
			double dirX = ((gen.posX[crystalType] * 16 + 8) - posEvent.getX()) / 40;
			double dirY = (100 - posEvent.getY()) / 40;
			double dirZ = ((gen.posY[crystalType] * 16 + 8) - posEvent.getZ()) / 40;
			if (dirX > 10)
				dirX = 10;
			if (dirZ > 10)
				dirZ = 10;
			if (dirX < -10)
				dirX = -10;
			if (dirZ < -10)
				dirZ = -10;
			switch (crystalType) {
			case 0:
				Main.proxy.spawnParticle(player.world, ParticleTypes.GLINT_BLUE, posEvent.getX() + rand.nextDouble(),
						posEvent.getY() + rand.nextDouble(), posEvent.getZ() + rand.nextDouble(), dirX / 50, dirY / 50,
						dirZ / 50);
				break;
			case 1:
				Main.proxy.spawnParticle(player.world, ParticleTypes.GLINT_GREEN, posEvent.getX() + rand.nextDouble(),
						posEvent.getY() + rand.nextDouble(), posEvent.getZ() + rand.nextDouble(), dirX / 50, dirY / 50,
						dirZ / 50);
				break;
			case 2:
				Main.proxy.spawnParticle(player.world, ParticleTypes.GLINT_PURPLE, posEvent.getX() + rand.nextDouble(),
						posEvent.getY() + rand.nextDouble(), posEvent.getZ() + rand.nextDouble(), dirX / 50, dirY / 50,
						dirZ / 50);
				break;
			case 3:
				Main.proxy.spawnParticle(player.world, ParticleTypes.GLINT_PINK, posEvent.getX() + rand.nextDouble(),
						posEvent.getY() + rand.nextDouble(), posEvent.getZ() + rand.nextDouble(), dirX / 50, dirY / 50,
						dirZ / 50);
				break;
			case 4:
				Main.proxy.spawnParticle(player.world, ParticleTypes.GLINT_YELLOW, posEvent.getX() + rand.nextDouble(),
						posEvent.getY() + rand.nextDouble(), posEvent.getZ() + rand.nextDouble(), dirX / 50, dirY / 50,
						dirZ / 50);
				break;
			}
		} else {
			posEvent = null;
			gen = null;
		}

	}
}
