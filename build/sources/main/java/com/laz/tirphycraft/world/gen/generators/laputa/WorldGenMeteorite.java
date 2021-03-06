package com.laz.tirphycraft.world.gen.generators.laputa;

import java.util.Random;

import com.laz.tirphycraft.init.BiomeInit;
import com.laz.tirphycraft.init.BlockInit;

import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenMeteorite extends WorldGenerator {

	public boolean generate(World worldIn, Random rand, BlockPos pos) {
		for (int i = -11; i < 8; i++) {
			for (int j = -11; j < 8; j++) {

				if (rand.nextBoolean())
					worldIn.setBlockState(worldIn.getHeight(pos.add(i, 0, j)).down(),
							BlockInit.BLOCK_METEORITE.getDefaultState());
				
					if (rand.nextInt(20) == 0) {
						worldIn.setBlockState(worldIn.getHeight(pos.add(i, 0, j)).down(),
								Blocks.MAGMA.getDefaultState());
					}

				if (rand.nextInt(4) == 0)
					worldIn.setBlockState(worldIn.getHeight(pos.add(i, 0, j)), Blocks.FIRE.getDefaultState());

				byte[] biome = worldIn.getChunkFromBlockCoords(worldIn.getHeight(pos.add(i, 0, j)).down())
						.getBiomeArray();
				for (int k = 0; k < biome.length; k++) {
					biome[k] = (byte) BiomeInit.LAPUTA_METEORITE.getIdForBiome(BiomeInit.LAPUTA_METEORITE);

				}

				worldIn.getChunkFromBlockCoords(worldIn.getHeight(pos.add(i, 0, j)).down()).setBiomeArray(biome);
			}
		}
		return true;
	}

}
