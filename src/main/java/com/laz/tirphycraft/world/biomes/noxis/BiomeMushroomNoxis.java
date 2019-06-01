package com.laz.tirphycraft.world.biomes.noxis;

import java.util.Random;

import com.laz.tirphycraft.init.BlockInit;
import com.laz.tirphycraft.world.gen.generators.deco.WorldGenMushroomNoxis;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;

public class BiomeMushroomNoxis extends Biome {

	public BiomeMushroomNoxis() {

		super(new BiomeProperties("Noxis Mushroom").setBaseHeight(0.125F).setHeightVariation(0.05F).setTemperature(0.8F)
				.setRainfall(0.0F).setRainDisabled().setWaterColor(1909616));

		topBlock = BlockInit.NOXIS_GRASS.getDefaultState();
		fillerBlock = BlockInit.NOXIS_DIRT.getDefaultState();

        this.decorator.treesPerChunk = 3;
		this.spawnableMonsterList.clear();
		this.spawnableCaveCreatureList.clear();
		this.spawnableCreatureList.clear();
		this.spawnableWaterCreatureList.clear();


	}

	
	

	@Override
	public WorldGenAbstractTree getRandomTreeFeature(Random rand) {
		
		return new WorldGenMushroomNoxis();

	}
}
