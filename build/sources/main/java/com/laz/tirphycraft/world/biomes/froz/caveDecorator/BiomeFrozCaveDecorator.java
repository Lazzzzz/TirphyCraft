package com.laz.tirphycraft.world.biomes.froz.caveDecorator;

import java.util.Random;

import com.laz.tirphycraft.init.BlockInit;

import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BiomeFrozCaveDecorator {
	CaveGenMixte MIXTE = new CaveGenMixte();
	CaveGenStruc STRUCT = new CaveGenStruc();
	CaveGenWoodPillar WOOD_PILLAR = new CaveGenWoodPillar();
	CaveGenVines VINES = new CaveGenVines();

	public void genDecorator(World worldIn, Random rand, BlockPos pos, int maxHeight) {
		int y = 0;

		while (getBlock(worldIn, pos, y, maxHeight) != null) {
			BlockPos newPos = getBlock(worldIn, pos, y, maxHeight).up();
			y = newPos.getY() + 1;

			// DO STUFF
			STRUCT.generate(worldIn, newPos, rand);
			MIXTE.generate(worldIn, rand, newPos);
			generateRandomDeco(worldIn, rand, newPos);

		}

	}

	public BlockPos getBlock(World worldIn, BlockPos pos, int start, int maxHeight) {
		for (int i = start; i < maxHeight; i++) {
			BlockPos b = new BlockPos(pos.getX(), i, pos.getZ());
			if (worldIn.getBlockState(b) == BlockInit.FROZ_STONE.getDefaultState()
					&& worldIn.getBlockState(b.up()) == Blocks.AIR.getDefaultState()) {
				return b;
			}
		}
		return null;
	}

	public void generateRandomDeco(World worldIn, Random rand, BlockPos pos) {
		// COMMON DECO
		if (rand.nextInt(5) == 0) {
			int i = rand.nextInt(2);

			if (i == 0)
				VINES.generate(worldIn, rand, pos);
			else if (i == 1)
				WOOD_PILLAR.generate(worldIn, rand, pos);

		}
		/*
		 * rare if (rand.nextInt(20) == 0) {
		 * 
		 * }
		 */
	}

}
