package com.laz.tirphycraft.world.biomes.froz.groundDecorator;

import java.util.Random;

import com.laz.tirphycraft.init.BlockInit;

import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class genFrozEternalGround extends WorldGenerator {

	@Override
	public boolean generate(World worldIn, Random rand, BlockPos position) {
		BlockPos pos = position.down();
		IBlockState ground = worldIn.getBlockState(pos);
		
		
		if (ground == Blocks.ICE.getDefaultState()) {
			if (rand.nextInt(10) == 0) worldIn.setBlockState(pos, Blocks.PACKED_ICE.getDefaultState());
			else if (rand.nextInt(30) == 0) worldIn.setBlockState(pos, BlockInit.FROZEN_CRYSTAL.getDefaultState());
			
		}
		return true;
	}

}
