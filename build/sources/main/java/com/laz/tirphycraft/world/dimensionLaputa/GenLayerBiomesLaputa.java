package com.laz.tirphycraft.world.dimensionLaputa;

import com.laz.tirphycraft.init.BiomeInit;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.IntCache;

public class GenLayerBiomesLaputa extends GenLayer {

	private Biome[] allowedBiomes = { BiomeInit.LAPUTA_CRYSTAL, BiomeInit.LAPUTA, BiomeInit.LAPUTA_MAGIC,
			BiomeInit.LAPUTANML, BiomeInit.LAPUTANML, BiomeInit.LAPUTA };

	public GenLayerBiomesLaputa(long seed) {
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
