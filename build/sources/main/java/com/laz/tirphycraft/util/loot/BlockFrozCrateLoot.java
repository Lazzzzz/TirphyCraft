package com.laz.tirphycraft.util.loot;

import java.util.Random;

import com.laz.tirphycraft.init.ItemInit;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockFrozCrateLoot {
	private final SetLoot [] list = {
			
		new SetLoot(Items.SNOWBALL, 40, 5),
		new SetLoot(Blocks.ICE, 40, 5),
		new SetLoot(Blocks.SNOW, 40, 5),
		new SetLoot(Items.IRON_INGOT, 30, 5),	
		new SetLoot(Items.GOLD_INGOT, 20, 5),
		new SetLoot(Items.DIAMOND, 10, 5),
		new SetLoot(ItemInit.BLUE_ROSE_PETAL, 15, 2),
		new SetLoot(ItemInit.ROSE_CHESTPLATE, 1, 1),
		new SetLoot(ItemInit.ROSE_HELMET, 1, 1),
		new SetLoot(ItemInit.ROSE_BOOTS, 1, 1),
		new SetLoot(ItemInit.ROSE_LEGGINGS, 1, 1)
	
	};

	public void spawnLoot(World worldIn, Random rand, BlockPos pos) {
		for (int i = 0; i < this.list.length; i ++) {
			list[i].isPick(worldIn, rand, pos);
				
		}
	}

}
