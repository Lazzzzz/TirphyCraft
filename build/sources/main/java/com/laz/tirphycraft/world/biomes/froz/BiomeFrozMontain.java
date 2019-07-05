package com.laz.tirphycraft.world.biomes.froz;

import com.laz.tirphycraft.init.BlockInit;
import com.laz.tirphycraft.world.gen.generators.plants.WorldGenFrozBlueRose;

import net.minecraft.init.Blocks;
import net.minecraft.world.biome.Biome;

public class BiomeFrozMontain extends Biome {

	public final WorldGenFrozBlueRose PLANT_ROSE = new WorldGenFrozBlueRose();

	public BiomeFrozMontain() {

		super(new BiomeProperties("Forz Montain").setBaseHeight(0.8F).setHeightVariation(0.9F).setTemperature(-10F)
				.setRainfall(100F).setWaterColor(4092311));

		topBlock = BlockInit.POWDER_SNOW.getDefaultState();
		fillerBlock = Blocks.SNOW.getDefaultState();

		this.decorator.treesPerChunk = 0;
		this.spawnableMonsterList.clear();
		this.spawnableCreatureList.clear();
		this.spawnableWaterCreatureList.clear();
		this.spawnableCaveCreatureList.clear();

	}


}
