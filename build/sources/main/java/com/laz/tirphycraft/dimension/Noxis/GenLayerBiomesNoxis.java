package com.laz.tirphycraft.dimension.Noxis;

import com.laz.tirphycraft.init.BiomeInit;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.IntCache;

public class GenLayerBiomesNoxis extends GenLayer {

	private Biome[] allowedBiomes = { BiomeInit.NOXIS_LAC, BiomeInit.NOXIS_HILLS, BiomeInit.NOXIS_BIG_FOREST,
			BiomeInit.NOXIS_BIG_FOREST, BiomeInit.NOXIS, BiomeInit.NOXIS_ICE, BiomeInit.NOXIS_S_HILLS,
			BiomeInit.NOXIS_S_HILLS, BiomeInit.NOXIS_MUSHROOM, BiomeInit.NOXIS_ROCK };

	public GenLayerBiomesNoxis(long seed) {
		super(seed);
	}

	@Override
	public int[] getInts(int x, int z, int width, int depth) {
		int[] dest = IntCache.getIntCache(width * depth);
		for (int dz = 0; dz < depth; dz++) {
			for (int dx = 0; dx < width; dx++) {
				this.initChunkSeed(dx + x, dz + z);
				dest[(dx + dz * width)] = Biome.getIdForBiome(this.allowedBiomes[nextInt(this.allowedBiomes.length)]);
			}
		}
		return dest;
	}
}
