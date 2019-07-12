package com.laz.tirphycraft.world.gen.generators.noxis;

import java.util.Random;

import com.laz.tirphycraft.init.BlockInit;

import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;

public class WorldGenNoxisLamp extends WorldGenAbstractTree {
	public WorldGenNoxisLamp() {
		super(false);
	}

	@Override
	public boolean generate(World world, Random rand, BlockPos pos) {
		int x = pos.getX();
		int y = pos.getY() - 1;
		int z = pos.getZ();

		if (world.getBlockState(new BlockPos(x, y, z)) == BlockInit.NOXIS_GRASS.getDefaultState()
				|| world.getBlockState(new BlockPos(x, y, z)) == BlockInit.NOXIS_FROZEN_GRASS.getDefaultState()) {
			int o = rand.nextInt(3) + 1;
			for (int i = o; i >= 0; i--) {
				x = pos.getX();
				y = pos.getY() + i ;
				z = pos.getZ();
				world.setBlockState(new BlockPos(x,y,z), Blocks.OAK_FENCE.getDefaultState());
				
			}
			world.setBlockState(new BlockPos(pos.getX(),pos.getY()+o,pos.getZ()), Blocks.GLOWSTONE.getDefaultState());
		}

		return true;

	}
}
