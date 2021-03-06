package com.laz.tirphycraft.world.gen.generators.froz;

import java.util.Random;

import com.laz.tirphycraft.init.BlockInit;

import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;

public class WorldGenFrozBlueRose extends WorldGenAbstractTree {
	public static final IBlockState GRASS = BlockInit.NOXIS_GRASS.getDefaultState();
	public static final IBlockState PLANT = BlockInit.FROZ_PLANT_BLUE_ROSE.getDefaultState();

	public WorldGenFrozBlueRose() {
		super(false);
	}

	@Override
	public boolean generate(World world, Random rand, BlockPos pos) {
		int x = pos.getX();
		int y = pos.getY() - 1;
		int z = pos.getZ();
		
		if (world.getBlockState(new BlockPos(x,y,z)) == BlockInit.POWDER_SNOW.getDefaultState()){
			world.setBlockState(new BlockPos(x,y,z), GRASS);
			world.setBlockState(new BlockPos(x+1,y,z), GRASS);
			world.setBlockState(new BlockPos(x-1,y,z), GRASS);
			world.setBlockState(new BlockPos(x,y,z+1), GRASS);
			world.setBlockState(new BlockPos(x,y,z-1), GRASS);
			world.setBlockState(new BlockPos(x,y+1,z), PLANT);
		}
		
		return true;

	}
}
