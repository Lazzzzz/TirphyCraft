package com.laz.tirphycraft.world.biomes.laputa.groundDecorator;

import java.util.Random;

import com.laz.tirphycraft.init.BlockInit;

import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class genLaputaNMLGround extends WorldGenerator {

	@Override
	public boolean generate(World worldIn, Random rand, BlockPos position) {
		BlockPos pos = position.down();
		IBlockState ground = worldIn.getBlockState(pos);
		
		
		if (ground == BlockInit.LAPUTA_GRASS.getDefaultState()) {
			if (rand.nextInt(20) == 0) worldIn.setBlockState(pos, BlockInit.LAPUTA_COBBLESTONE.getDefaultState());
			else if (rand.nextInt(20) == 0) worldIn.setBlockState(pos, BlockInit.LAPUTA_STONE.getDefaultState());
			else if (rand.nextInt(20) == 0) worldIn.setBlockState(pos, BlockInit.LAPUTA_DIRT.getDefaultState());
			
		}
		return true;
	}

}
