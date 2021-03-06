package com.laz.tirphycraft.world.gen.generators.trees.laputa;

import java.util.Random;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;

public class WorldGenStem extends WorldGenAbstractTree {
	
	IBlockState TRUNK;
	int SIZE;

	public WorldGenStem(IBlockState block, int nb) {
		super(false);
		TRUNK = block;
		SIZE  = nb;
	}

	public boolean generate(World worldIn, Random rand, BlockPos position) {
		
		if (position.getY() >= 1 && position.getY() + 1 <= 240) {
			if (worldIn.getBlockState(position.down()).getMaterial() == Material.GROUND) {
				int r = rand.nextInt(SIZE)+2;
				generateStem(worldIn, rand, position, r, true, true, true, true);
				return true;
			}
		}

		return false;
	}
	
	public void generateStem(World worldIn, Random rand, BlockPos position, int nb, boolean l1, boolean l2, boolean l3, boolean l4) {
		int h = rand.nextInt(3) + 3 + nb;
		int x = position.getX();
		int y = position.getY();
		int z = position.getZ();
		
		for (int i = 0; i < h; i++) {
			y = position.getY() + i;
			worldIn.setBlockState(new BlockPos(x, y, z), TRUNK);
		}
		
	
		if (nb > 0) {
			if (l1 && rand.nextInt(2) == 0)	generateStem(worldIn, rand, new BlockPos(x-1, y, z+1), nb-1, true, true, false, true);
			if (l2 && rand.nextInt(2) == 0) generateStem(worldIn, rand, new BlockPos(x+1, y, z+1), nb-1, true, true, true , false);
			if (l3 && rand.nextInt(2) == 0) generateStem(worldIn, rand, new BlockPos(x+1, y, z-1), nb-1, false, true, true, true);
			if (l4 && rand.nextInt(2) == 0) generateStem(worldIn, rand, new BlockPos(x-1, y, z-1), nb-1, true, false, true, true);
		}
		
	}
}