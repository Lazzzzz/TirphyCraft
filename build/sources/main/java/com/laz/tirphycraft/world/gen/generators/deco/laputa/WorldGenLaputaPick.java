package com.laz.tirphycraft.world.gen.generators.deco.laputa;

import java.util.Random;

import com.laz.tirphycraft.init.BlockInit;

import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenLaputaPick extends WorldGenerator {

	public WorldGenLaputaPick() {

	}

	@Override
	public boolean generate(World world, Random rand, BlockPos pos) {
				
		IBlockState BLOCK = randBlock(rand);
		
		int x = pos.getX();
		int y = pos.getY();
		int z = pos.getZ();

		if (world.getBlockState(new BlockPos(x, y - 1, z)).getMaterial().isLiquid()
				|| world.getBlockState(new BlockPos(x, y - 1, z)) != BlockInit.LAPUTA_GRASS.getDefaultState()) {
			return false;
		}

		int directionX = 0;
		int directionZ = 0;
		while (directionZ == 0 && directionX == 0) {
			directionX = 1 - rand.nextInt(3);
			directionZ = 1 - rand.nextInt(3);
		}

		int length = 5 + rand.nextInt(4);
		float radius = length / 2;

		for (int j = 0; j < length; j++) {
			for (int i = (int) -radius; i < radius; i++) {
				for (int k = (int) -radius; k < radius; k++) {
					if (i * i + k * k < radius) {
						IBlockState old = world
								.getBlockState(new BlockPos(x + i + directionX * j, y + j, z + k + directionZ * j));
						world.setBlockState(new BlockPos(x + i + directionX * j, y + j, z + k + directionZ * j),
								BLOCK);

						old = world.getBlockState(new BlockPos(x - i - directionX * j, y - j, z - k - directionZ * j));
						world.setBlockState(new BlockPos(x - i - directionX * j, y - j, z - k - directionZ * j),
								BLOCK);

					}
				}
			}
			radius -= 0.5F;
		}

		return true;
	}
	
	public IBlockState randBlock(Random rand) {
		int r = rand.nextInt(5);
		if (r==0) return BlockInit.LAPUTA_BLUE.getDefaultState();
		else if (r==1) return BlockInit.LAPUTA_GREEN.getDefaultState();
		else if (r==2) return BlockInit.LAPUTA_PURPLE.getDefaultState();
		else if (r==3) return BlockInit.LAPUTA_YELLOW.getDefaultState();
		else return BlockInit.LAPUTA_PINK.getDefaultState();
		
	}
}