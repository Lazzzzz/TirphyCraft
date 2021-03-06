package com.laz.tirphycraft.world.gen.generators.trees.froz;

import java.util.Random;

import com.laz.tirphycraft.init.BlockInit;

import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;

public class WorldGenFrozNormalTree extends WorldGenAbstractTree {

	public static IBlockState LOG;
	public static IBlockState LEAVES;
	public static int size;
	
	public WorldGenFrozNormalTree(int size, IBlockState leaves, IBlockState log) {
		super(false);
		this.size = size;
		LOG = log;
		LEAVES = leaves;
	}

	@Override
	public boolean generate(World world, Random rand, BlockPos pos) {
		int x = pos.getX();
		int y = pos.getY();
		int z = pos.getZ();

		int height = rand.nextInt(2) + this.size;
		// check for space
		if (y <= 0 || y + height > 255)
			return false;

		for (int testY = y + 1; testY <= y + height + 1; ++testY)
			for (int testX = x - 2; testX <= x + 2; ++testX)
				for (int testZ = z - 2; testZ <= z + 2; ++testZ)
					if (!world.isAirBlock(new BlockPos(testX, testY, testZ)))
						return false;
		if (world.getBlockState(pos.down()) != Blocks.DIRT.getDefaultState() && world.getBlockState(pos.down()) != Blocks.GRASS.getDefaultState() && world.getBlockState(pos.down()) != BlockInit.POWDER_SNOW.getDefaultState() && world.getBlockState(pos.down()) != Blocks.SNOW.getDefaultState())
			return false;
		
		world.setBlockState(new BlockPos(pos.getX(), pos.getY()-1, pos.getZ()), LOG);

		// generate tree
		for (int yy = 0; yy < height; yy++) {
			world.setBlockState(new BlockPos(x, y + yy, z), LOG, 2);

			if (yy == height - 1)
				continue;

			for (int extraWood = 0, extraWoodAttempt = 0; extraWoodAttempt < 5 && extraWood < 3; extraWoodAttempt++) {
				int dir = rand.nextInt(4);

				if (yy > 0 && !world.isAirBlock(new BlockPos(x, y + yy - 1, z)))
					continue;

				world.setBlockState(new BlockPos(x, y + yy, z), LOG, 3);
				if (yy > 0 && rand.nextBoolean())
					world.setBlockState(new BlockPos(x * 2, y + yy, z * 2), LEAVES, 2);
				++extraWood;
			}
		}

		double centerY = 2D + (height - 2D) * 0.5D;
		for (int yy = 1; yy < height; yy++)
			for (int xx = -1; xx <= 1; xx++)
				for (int zz = -1; zz <= 1; zz++) {
					if (xx == 0 && zz == 0)
						continue;

					double dist = Math.sqrt(xx * xx + Math.pow(centerY - yy, 2) + zz * zz);
					if ((dist <= 1.5D || rand.nextDouble() > dist - 1.5D) && world.isAirBlock(new BlockPos(x + xx, y + yy, z + zz)))
						world.setBlockState(new BlockPos(x + xx, y + yy, z + zz), LEAVES, 2);
				}

		for (int a = 0; a < 4; a++)
			world.setBlockState(new BlockPos(x, y + height,z), LEAVES, 2);
		world.setBlockState(new BlockPos(x, y + height, z), LEAVES, 2);

		return true;
	}

}
