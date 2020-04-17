package com.laz.tirphycraft.world.gen.generators.froz.city;

import java.util.Random;

import com.laz.tirphycraft.init.BlockInit;

import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenGravel extends WorldGenerator{

	@Override
	public boolean generate(World worldIn, Random rand, BlockPos position) {
		for (int i = 0; i < rand.nextInt(3) + 3; i++) {
			int x = rand.nextInt(6) - 3;
			int z = rand.nextInt(6) - 3;
			BlockPos p =  position.add(x, 0, z);
			generatePick(worldIn, rand, p);
		}
		
		return true;
	}
	
	public boolean generatePick(World worldIn, Random rand, BlockPos position) {
		int size = rand.nextInt(2);
		int counter = 0;
		for (int i = position.getY() + size; i > 0; i--) {
			BlockPos pos = new BlockPos(position.getX(), i, position.getZ());
			if (worldIn.getBlockState(pos).isFullBlock()) break;
			counter ++;
		}
		
		if (counter < 7) { 
			for (int i = position.getY() + size; i > 0; i--) {
				BlockPos pos = new BlockPos(position.getX(), i, position.getZ());
				placeBlock(worldIn, pos, rand);
			}
		}
		return true;
		
	}

	public void placeBlock(World worldIn, BlockPos pos, Random rand) {
		IBlockState block;
		if (rand.nextInt(10) == 0) {
			if (rand.nextInt(5) == 0) block = Blocks.BRICK_BLOCK.getDefaultState();
			else block = Blocks.STONEBRICK.getStateFromMeta(rand.nextInt(4));
		} else {
			block = BlockInit.FROZ_BLUE_BRICK.getStateFromMeta(rand.nextInt(10));
		}

		worldIn.setBlockState(pos, block);
	}
}