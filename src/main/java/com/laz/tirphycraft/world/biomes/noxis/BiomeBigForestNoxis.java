package com.laz.tirphycraft.world.biomes.noxis;

import java.util.Random;

import com.laz.tirphycraft.init.BlockInit;
import com.laz.tirphycraft.world.gen.generators.trees.geant.WorldGenGeantBlueTree;
import com.laz.tirphycraft.world.gen.generators.trees.geant.WorldGenGeantGreenTree;
import com.laz.tirphycraft.world.gen.generators.trees.geant.WorldGenGeantPurpleTree;
import com.laz.tirphycraft.world.gen.generators.trees.geant.WorldGenGeantWhiteTree;
import com.laz.tirphycraft.world.gen.generators.trees.noxis.WorldGenBush;
import com.laz.tirphycraft.world.gen.generators.trees.noxis.normal.worldGenBlueTree;
import com.laz.tirphycraft.world.gen.generators.trees.noxis.normal.worldGenGreenTree;
import com.laz.tirphycraft.world.gen.generators.trees.noxis.normal.worldGenPurpleTree;
import com.laz.tirphycraft.world.gen.generators.trees.noxis.normal.worldGenWhiteTree;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;

public class BiomeBigForestNoxis extends Biome {

	public static final WorldGenGeantBlueTree   TREE1 = new WorldGenGeantBlueTree();
	public static final WorldGenGeantPurpleTree TREE2 = new WorldGenGeantPurpleTree();
	public static final WorldGenGeantGreenTree  TREE3 = new WorldGenGeantGreenTree();
	public static final WorldGenGeantWhiteTree  TREE4 = new WorldGenGeantWhiteTree();

	public BiomeBigForestNoxis() {

		super(new BiomeProperties("Noxis Big Forest").setBaseHeight(0.1F).setHeightVariation(0.05F).setTemperature(0.8F)
				.setRainfall(0.0F).setRainDisabled().setWaterColor(1909616));

		topBlock = BlockInit.NOXIS_GRASS.getDefaultState();
		fillerBlock = BlockInit.NOXIS_DIRT.getDefaultState();

        this.decorator.treesPerChunk = 8;
		this.spawnableMonsterList.clear();
		this.spawnableCaveCreatureList.clear();
		this.spawnableCreatureList.clear();
		this.spawnableWaterCreatureList.clear();


	}

	@Override
	public WorldGenAbstractTree getRandomTreeFeature(Random rand) {
		
		int o = rand.nextInt(20);
		if (o == 1) {
			return new WorldGenBush();
		}
		
		o = rand.nextInt(12);
		if (o == 0 || o == 1) return TREE1;
		else if (o == 2 || o == 3) return TREE2;
		else if (o == 4 || o == 5) return TREE3;
		else if (o == 6 || o == 7) return TREE4;
		else if (o==8) return new worldGenBlueTree();
		else if (o==9) return new worldGenGreenTree();
		else if (o==10) return new worldGenWhiteTree();
		else if (o==11) return new worldGenPurpleTree();
				
		return TREE4;

	}
}
