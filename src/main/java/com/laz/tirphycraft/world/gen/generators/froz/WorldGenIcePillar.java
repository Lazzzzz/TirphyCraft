package com.laz.tirphycraft.world.gen.generators.froz;

import java.util.Random;

import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenIcePillar extends WorldGenerator {
	public boolean generate(World worldIn, Random rand, BlockPos position) {

		int size = rand.nextInt(5) + 2;

		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				base(worldIn, rand, position.add(i, 0, j));
			}
		}

		return true;
	}

	public void base(World worldIn, Random rand, BlockPos pos) {
		int floor = 0;
		int r     = 0;		
		for (int i = pos.getY(); i > 30; i--) {
			if (worldIn.getBlockState(new BlockPos(pos.getX(), i, pos.getZ())) == Blocks.GRASS.getDefaultState()) {
				floor = i;
			}
		}

		for (int i = floor - 1; i < pos.getY() + rand.nextInt(25); i++) {
			r = rand.nextInt(10);
			if (r == 0)
			worldIn.setBlockState(new BlockPos(pos.getX(), i, pos.getZ()), Blocks.OBSIDIAN.getDefaultState());
			else if (r > 5) worldIn.setBlockState(new BlockPos(pos.getX(), i, pos.getZ()), Blocks.PACKED_ICE.getDefaultState());
			else worldIn.setBlockState(new BlockPos(pos.getX(), i, pos.getZ()), Blocks.ICE.getDefaultState());
		}
		
		
	}

}