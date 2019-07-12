package com.laz.tirphycraft.world.gen.generators.trees.froz;

import java.util.Random;

import com.laz.tirphycraft.init.BlockInit;

import net.minecraft.block.BlockLog;
import net.minecraft.block.BlockLog.EnumAxis;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;

public class WorldGenFrozMiniBushDownTree extends WorldGenAbstractTree {

	public static final IBlockState LOG = BlockInit.LOG_FROZ.getDefaultState();
	public static final IBlockState LEAVES = BlockInit.LEAVES_FROZ.getDefaultState();
	public static int size;

	public WorldGenFrozMiniBushDownTree() {
		super(false);
	}
	
	@Override
	public boolean generate(World world, Random rand, BlockPos pos) {
		if (!(world.getBlockState(pos.down()) == Blocks.GRASS.getDefaultState())) return false;
		EnumAxis axe = pickRotation(world, pos, rand);
		int r1 = rand.nextInt(9) + 1;
		for (int i = 0; i < r1; i++) {
			if (axe == EnumAxis.X) {
				if (world.getBlockState(pos.add(i,0,0)) == Blocks.AIR.getDefaultState() && world.getBlockState(pos.add(i,0,0).down()) == Blocks.GRASS.getDefaultState()) {
					world.setBlockState(pos.add(i,0,0), LOG.withProperty(BlockLog.LOG_AXIS, axe));
				}
			}
			if (axe == EnumAxis.Z) {
				if (world.getBlockState(pos.add(0,0,i)) == Blocks.AIR.getDefaultState() && world.getBlockState(pos.add(0,0,i).down()) == Blocks.GRASS.getDefaultState()) {
					world.setBlockState(pos.add(0,0,i), LOG.withProperty(BlockLog.LOG_AXIS, axe));
				}
			}
		}
		
		return true;
	}

	public EnumAxis pickRotation(World worldIn, BlockPos pos, Random rand) {

		int r = rand.nextInt(3);
		if (r == 1)
			return EnumAxis.X;
		else
			return EnumAxis.Z;
	}

}
