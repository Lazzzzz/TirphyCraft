package com.laz.tirphycraft.gosyn.common.world.biomes.base;

import com.laz.tirphycraft.init.BlockInit;

import net.minecraft.world.biome.Biome;

public class BiomeStage3Base extends Biome {

	public BiomeStage3Base(String name, float setHeightVariation, float setTemperature) {

		super(new BiomeProperties(name).setBaseHeight(-1.9F).setHeightVariation(setHeightVariation)
				.setTemperature(setTemperature).setRainDisabled().setWaterColor(5691638));

		topBlock = BlockInit.GRASS.getDefaultState();
		fillerBlock = BlockInit.DIRT.getDefaultState();

		this.spawnableMonsterList.clear();
		this.spawnableCreatureList.clear();
		this.spawnableWaterCreatureList.clear();
		this.spawnableCaveCreatureList.clear();

	}

}
