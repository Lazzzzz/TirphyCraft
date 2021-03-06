package com.laz.tirphycraft.world.gen.generators.trees.froz;

import java.util.Random;

import com.laz.tirphycraft.init.BlockInit;

import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;

public class WorldGenFrozMiniBushTree extends WorldGenAbstractTree {

	public static final IBlockState LOG = BlockInit.LOG_FROZ.getDefaultState();
	public static final IBlockState LEAVES = BlockInit.LEAVES_FROZ.getDefaultState();
	public static int size;

	public WorldGenFrozMiniBushTree() {
		super(false);
	}
	
	@Override
	public boolean generate(World world, Random rand, BlockPos pos) {
		if (!(world.getBlockState(pos.down()) == Blocks.GRASS.getDefaultState())) return false;
		
		int r1 = rand.nextInt(9) + 1;
		for (int i = 0; i < r1; i++) {
			world.setBlockState(pos.add(0,i,0), LOG);
		}
		
		return true;
	}
}
