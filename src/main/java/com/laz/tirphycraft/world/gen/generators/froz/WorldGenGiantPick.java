package com.laz.tirphycraft.world.gen.generators.froz;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenGiantPick extends WorldGenerator {
	private final Block ICE = Blocks.ICE;
	private final int maxSize;
	
	public WorldGenGiantPick(int size) {
		maxSize = size;
	}

	public boolean generate(World worldIn, Random rand, BlockPos position) {
		if (worldIn.getBlockState(position.down()) != Blocks.ICE.getDefaultState() || position.getY() > 100)
			return false;

		int size = rand.nextInt(30) + maxSize;
		setPick(worldIn, rand, position, size);

		return true;
	}

	public void setPick(World worldIn, Random rand, BlockPos position, int size) {
		int q = 0;
		for (int i = position.getY() + size; i > q; i--) {
			if (worldIn.getBlockState(position.down()) != Blocks.ICE.getDefaultState())
				q = i;
			worldIn.setBlockState(new BlockPos(position.getX(), i, position.getZ()), ICE.getDefaultState());
		}

		if (size > 5) {
			for (int i = 0; i < 2; i++) {

				size = (int) (size * 0.8 + (rand.nextInt(6) - 3));
				setPick(worldIn, rand, position.add(Math.pow((-1), 2 + rand.nextInt(2)), 0, 0), size);

				size = (int) (size * 0.8 + (rand.nextInt(6) - 3));
				setPick(worldIn, rand, position.add(0, 0, Math.pow((-1), 2 + rand.nextInt(2))), size);
			}
		}
	}
}
