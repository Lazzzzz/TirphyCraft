package com.laz.tirphycraft.world.gen.generators.trees.froz;

import java.util.Random;

import com.laz.tirphycraft.init.BlockInit;

import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;

public class WorldGenFrozBushTree extends WorldGenAbstractTree {

	public static final IBlockState LOG = BlockInit.LOG_FROZ.getDefaultState();
	public static final IBlockState LEAVES = BlockInit.LEAVES_FROZ.getDefaultState();
	public static int size;

	public WorldGenFrozBushTree() {
		super(false);
	}

	@Override
	public boolean generate(World world, Random rand, BlockPos pos) {
		int x = pos.getX();
		int y = pos.getY();
		int z = pos.getZ();

		int height = rand.nextInt(2) + this.size;
		boolean can = true;
		for (int i = -1; i < 3; i++) {
			for (int j = -1; j < 3; j++) {
				if (!(world.getBlockState(pos.down()) == Blocks.GRASS.getDefaultState())) can = false;
				
			}		

		}
		if (!can) return false;
		
		int r;
		int r1 = rand.nextInt(5) + 7;
		for (int i = 0; i < r1; i++) {
			set2X2(world, rand, pos.add(0,i,0), LOG);
		}
		
		for (int i = 0; i < 2; i++) {
			r = rand.nextInt(3) + 2;
			for (int j = 0; j < r; j++) {
				world.setBlockState(pos.add(-1, j, i), LOG);
				if (j == 0) world.setBlockState(pos.add(-1, j, i).down(), Blocks.GRASS.getDefaultState());
			}
			r = rand.nextInt(3) + 2;
			for (int j = 0; j < r; j++) {
				world.setBlockState(pos.add(2, j, i), LOG);
				if (j == 0) world.setBlockState(pos.add(2, j, i).down(), Blocks.GRASS.getDefaultState());
			}
			r = rand.nextInt(4);
			for (int j = 0; j < r; j++) {
				world.setBlockState(pos.add(-1, j + r1, i), LOG);
			}
			r = rand.nextInt(4);
			for (int j = 0; j < r; j++) {
				world.setBlockState(pos.add(2, j + r1, i), LOG);
			}
		}
		
		for (int i = 0; i < 2; i++) {
			r = rand.nextInt(3) + 2;
			for (int j = 0; j < r; j++) {
				world.setBlockState(pos.add(i, j, -1), LOG);
				if (j == 0) world.setBlockState(pos.add(i, j, -1).down(), Blocks.GRASS.getDefaultState());
			}
			r = rand.nextInt(3) + 2;
			for (int j = 0; j < r; j++) {
				world.setBlockState(pos.add(i, j, 2), LOG);
				if (j == 0) world.setBlockState(pos.add(i, j, 2).down(), Blocks.GRASS.getDefaultState());
			}
			r = rand.nextInt(4);
			for (int j = 0; j < r; j++) {
				world.setBlockState(pos.add(i, j + r1, -1), LOG);
			}
			r = rand.nextInt(4);
			for (int j = 0; j < r; j++) {
				world.setBlockState(pos.add(i, j + r1, 2), LOG);
			}
		}
		return true;

	}
	
	public void set2X2(World world, Random rand, BlockPos pos, IBlockState block) {
		world.setBlockState(pos, block);
		world.setBlockState(pos.add(1, 0, 0), block);
		world.setBlockState(pos.add(0, 0, 1), block);
		world.setBlockState(pos.add(1, 0, 1), block);
	}

}
