package com.laz.tirphycraft.event;

import com.laz.tirphycraft.entity.entityClass.boss.EntityQueenCreeper;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@EventBusSubscriber
public class CreeperQueenSpawn {

	@SubscribeEvent
	public static void getItem(PlayerInteractEvent event) {
		if (!event.getWorld().isRemote) {
			EntityPlayer player = event.getEntityPlayer();
			BlockPos pos = event.getPos();
			Block block = event.getWorld().getBlockState(pos).getBlock();

			if (block == Blocks.REDSTONE_BLOCK) {
				if (event.getWorld().getBlockState(pos.up()).getBlock() == Blocks.EMERALD_BLOCK) {
					if (event.getWorld().getBlockState(pos.add(-1, -1, 0)).getBlock() == Blocks.OBSIDIAN) {
						if (event.getWorld().getBlockState(pos.add(1, -1, 0)).getBlock() == Blocks.OBSIDIAN) {
							if (event.getWorld().getBlockState(pos.add(0, -1, -1)).getBlock() == Blocks.OBSIDIAN) {
								if (event.getWorld().getBlockState(pos.add(0, -1, 1)).getBlock() == Blocks.OBSIDIAN) {
									event.getWorld().setBlockToAir(pos);
									event.getWorld().setBlockToAir(pos.up());
									event.getWorld().setBlockToAir(pos.add(-1, -1, 0));
									event.getWorld().setBlockToAir(pos.add(1, -1, 0));
									event.getWorld().setBlockToAir(pos.add(0, -1, -1));
									event.getWorld().setBlockToAir(pos.add(0, -1, 1));
									EntityQueenCreeper e = new EntityQueenCreeper(event.getWorld());
									e.setPosition(pos.getX(),  pos.getY(), pos.getZ());
									event.getWorld().spawnEntity(e);
								}
							}
						}
					}
				}
			}

		}
	}
}