package com.laz.tirphycraft.world.gen.generators.laputa;

import java.util.Random;

import com.laz.tirphycraft.init.BlockInit;

import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;

public class WorldGenLaputaPlant extends WorldGenAbstractTree {
	public static final IBlockState GRASSW = BlockInit.LAPUTA_PLANT_GRASS.getDefaultState();
	public static final IBlockState GRASSB = BlockInit.LAPUTA_PLANT_GRASS_DARK.getDefaultState();


	public WorldGenLaputaPlant() {
		super(false);
	}

	@Override
	public boolean generate(World world, Random rand, BlockPos pos) {
		int x = pos.getX();
		int y = pos.getY() - 1;
		int z = pos.getZ();
		
		if (world.getBlockState(new BlockPos(x,y,z)) == BlockInit.LAPUTA_GRASS.getDefaultState()){
			int i = rand.nextInt(4);
			if (i == 1)	world.setBlockState(pos, GRASSW);
			else if(i == 2) world.setBlockState(pos, GRASSB);
		}
		
		return true;

	}
}
