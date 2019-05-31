package com.laz.tirphycraft.world.biomes.noxis;

import java.util.Random;

import com.laz.tirphycraft.init.BlockInit;
import com.laz.tirphycraft.world.gen.generators.trees.noxis.normal.worldGenBlueTree;
import com.laz.tirphycraft.world.gen.generators.trees.noxis.normal.worldGenGreenTree;
import com.laz.tirphycraft.world.gen.generators.trees.noxis.normal.worldGenPurpleTree;
import com.laz.tirphycraft.world.gen.generators.trees.noxis.normal.worldGenWhiteTree;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;

public class BiomeLacNoxis extends Biome {

	public BiomeLacNoxis() {

		super(new BiomeProperties("Noxis Lac").setBaseHeight(-1.0F).setHeightVariation(1.0F).setRainfall(0.0F)
				.setRainDisabled().setWaterColor(1909616));

		topBlock = BlockInit.NOXIS_GRASS.getDefaultState();
		fillerBlock = BlockInit.NOXIS_DIRT.getDefaultState();

		this.decorator.treesPerChunk = 10;

		this.spawnableMonsterList.clear();
		this.spawnableCaveCreatureList.clear();
		this.spawnableCreatureList.clear();
		this.spawnableWaterCreatureList.clear();

	}

	@Override
	public WorldGenAbstractTree getRandomTreeFeature(Random rand) {

		int o = rand.nextInt(8);
		if (o == 0)
			return new worldGenBlueTree();
		else if (o == 1)
			return new worldGenGreenTree();
		else if (o == 2)
			return new worldGenWhiteTree();
		else if (o == 3)
			return new worldGenPurpleTree();

		return new worldGenBlueTree();

	}

}
