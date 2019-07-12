package com.laz.tirphycraft.world.gen.generators.noxis;

import java.util.Random;

import com.laz.tirphycraft.init.BlockInit;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;

public class WorldGenNoxisSmoker extends WorldGenAbstractTree {
	public WorldGenNoxisSmoker() {
		super(false);
	}

	@Override
	public boolean generate(World world, Random rand, BlockPos pos) {
		int x = pos.getX();
		int y = pos.getY() - 1;
		int z = pos.getZ();

		if (world.getBlockState(new BlockPos(x, y, z)) == BlockInit.NOXIS_FROZEN_GRASS.getDefaultState()) {
			world.setBlockState(new BlockPos(x,y,z), BlockInit.SMOKER.getDefaultState());
		}

		return true;

	}
}
