package com.laz.tirphycraft.world.gen.generators.laputa;

import java.util.Random;

import com.laz.tirphycraft.init.BlockInit;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;

public class WorldGenLaputaCloud extends WorldGenAbstractTree {
	public WorldGenLaputaCloud() {
		super(false);
	}

	@Override
	public boolean generate(World world, Random rand, BlockPos pos) {
		for (int i = -1; i < 2; i ++) {
			for (int j = -1; j < 2; j ++) {
				world.setBlockState(new BlockPos(pos.getX()+i, pos.getY(), pos.getZ()+j), BlockInit.CLOUD.getDefaultState());
			}		
		}
		
		world.setBlockState(new BlockPos(pos.getX(), pos.getY()+1, pos.getZ()), BlockInit.CLOUD.getDefaultState());
		
		if (rand.nextInt(2) == 0) world.setBlockToAir(new BlockPos(pos.getX()+1, pos.getY(), pos.getZ()+1));
		if (rand.nextInt(2) == 0) world.setBlockToAir(new BlockPos(pos.getX()-1, pos.getY(), pos.getZ()+1));
		if (rand.nextInt(2) == 0) world.setBlockToAir(new BlockPos(pos.getX()-1, pos.getY(), pos.getZ()-1));
		if (rand.nextInt(2) == 0) world.setBlockToAir(new BlockPos(pos.getX()+1, pos.getY(), pos.getZ()-1));

		return true;

	}
}
