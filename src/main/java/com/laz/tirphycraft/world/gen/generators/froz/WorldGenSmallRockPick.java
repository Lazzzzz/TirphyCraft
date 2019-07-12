package com.laz.tirphycraft.world.gen.generators.froz;

import java.util.Random;

import com.laz.tirphycraft.init.BlockInit;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenSmallRockPick extends WorldGenerator {

	public boolean generate(World worldIn, Random rand, BlockPos position) {
		if (position.getY() > 80) return false;
		int r1 = rand.nextInt(6) + 4;
		generatePick(worldIn, position, r1);
		
		int r2 = rand.nextInt(5) + 1;
		int r3 = rand.nextInt(5) + 1;
		int r4 = rand.nextInt(5) + 1;
		int r5 = rand.nextInt(5) + 1;
		generatePick(worldIn, position.add(1,0,0), r2);
		generatePick(worldIn, position.add(-1,0,0), r3);
		generatePick(worldIn, position.add(0,0,-1), r4);
		generatePick(worldIn, position.add(0,0,1), r5);
		return true;
		
		
	}
	
	public void generatePick(World worldIn, BlockPos pos, int size) {
		for (int i = 0; i < size; i++) {
			worldIn.setBlockState(pos.add(0, i, 0), BlockInit.FROZ_STONE.getDefaultState());
		}
	}
}
