package com.laz.tirphycraft.world.biomes.noxis;

import java.util.Random;

import com.laz.tirphycraft.init.BlockInit;

import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class genNoxisGround extends WorldGenerator {

	@Override
	public boolean generate(World worldIn, Random rand, BlockPos position) {
		BlockPos pos = position.down();
		IBlockState ground = worldIn.getBlockState(pos);
		
		
		if (ground == BlockInit.NOXIS_STONE.getDefaultState()) {
			if (rand.nextInt(20) == 0) worldIn.setBlockState(pos, BlockInit.NOXIS_COBBLESTONE.getDefaultState());
			else if (rand.nextInt(5) == 0) worldIn.setBlockState(pos, BlockInit.NOXIS_ASH_LIT.getDefaultState());
			else if (rand.nextInt(10) == 0) worldIn.setBlockState(pos.up(), BlockInit.NOXIS_THORNS.getDefaultState());
			
		}
		return true;
	}

}
