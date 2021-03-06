package com.laz.tirphycraft.world.gen.generators.laputa;

import java.util.Random;

import com.laz.tirphycraft.init.BlockInit;

import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;

public class WorldGenLaputaFlower extends WorldGenAbstractTree {
	public static final IBlockState FF = BlockInit.LAPUTA_FAIRY_FLOWER.getDefaultState();
	public static final IBlockState HF = BlockInit.LAPUTA_HYDRA_FLOWER.getDefaultState();
	public static final IBlockState LB = BlockInit.LAPUTA_BUSH.getDefaultState();


	public WorldGenLaputaFlower() {
		super(false);
	}

	@Override
	public boolean generate(World world, Random rand, BlockPos pos) {
		int x = pos.getX();
		int y = pos.getY() - 1;
		int z = pos.getZ();
		
		if (world.getBlockState(new BlockPos(x,y,z)) == BlockInit.LAPUTA_GRASS.getDefaultState()){
			int i = rand.nextInt(4);
			if (i == 1)	world.setBlockState(pos, FF);
			else if(i == 2) world.setBlockState(pos, HF);
			
			i = rand.nextInt(16); 
			if(i == 1) world.setBlockState(pos, LB);
		}
		
		return true;

	}
}
