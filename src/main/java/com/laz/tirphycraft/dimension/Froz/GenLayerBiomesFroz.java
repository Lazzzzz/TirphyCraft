package com.laz.tirphycraft.dimension.Froz;

import com.laz.tirphycraft.init.BiomeInit;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.IntCache;

public class GenLayerBiomesFroz extends GenLayer {

	private Biome[] allowedBiomes = { 
			BiomeInit.FROZ_DENSE, 
			BiomeInit.FROZ_MONTAIN, 
			BiomeInit.FROZ_ETERNAL, 
			BiomeInit.FROZ_FOREST,
			BiomeInit.FROZ_ICE_MONTAIN, 
			BiomeInit.FROZ_DEAD, 
			BiomeInit.FROZ_PLATE, 
			BiomeInit.FROZ_SLAWOMIR,
			BiomeInit.FROZ_GEANT 
	};
	
	//BiomeInit.FROZ_DENSE, 
	//BiomeInit.FROZ_MONTAIN, 
	//BiomeInit.FROZ_ETERNAL, 
	//BiomeInit.FROZ_FOREST,
	//BiomeInit.FROZ_ICE_MONTAIN, 
	//BiomeInit.FROZ_DEAD, 
	//BiomeInit.FROZ_PLATE, 
	//BiomeInit.FROZ_SLAWOMIR,
	//BiomeInit.FROZ_GEANT 

	public GenLayerBiomesFroz(long seed) {
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
