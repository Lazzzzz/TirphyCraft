package com.laz.tirphycraft.world.gen.generators.froz;

import java.util.Random;

import com.laz.tirphycraft.init.BlockInit;

import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenIceVines extends WorldGenerator {
	public boolean generate(World worldIn, Random rand, BlockPos pos) {

		int floor = 0;
		for (int i = pos.getY(); i > 30; i--) {
			if (worldIn.getBlockState(new BlockPos(pos.getX(), i, pos.getZ())) == Blocks.GRASS.getDefaultState()) {
				floor = i;
			}
		}

		for (int i = floor - 1; i < pos.getY(); i++) {
			if (worldIn.getBlockState(new BlockPos(pos.getX(), i, pos.getZ())) == Blocks.AIR.getDefaultState())
				worldIn.setBlockState(new BlockPos(pos.getX(), i, pos.getZ()), BlockInit.FROZ_VINES.getDefaultState());

		}

		return true;
	}

}