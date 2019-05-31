package com.laz.tirphycraft.world.biomes.noxis;

import java.util.Random;

import com.laz.tirphycraft.entity.aggressive.EntityPhorus;
import com.laz.tirphycraft.entity.aggressive.EntityTotam;
import com.laz.tirphycraft.entity.passif.EntityBuffalo;
import com.laz.tirphycraft.init.BlockInit;
import com.laz.tirphycraft.world.gen.generators.trees.noxis.WorldGenNormalCoppirTree;
import com.laz.tirphycraft.world.gen.generators.trees.noxis.WorldGenNormalGoldirTree;
import com.laz.tirphycraft.world.gen.generators.trees.noxis.WorldGenNormalSilvirTree;
import com.laz.tirphycraft.world.gen.generators.trees.noxis.normal.worldGenBlueTree;
import com.laz.tirphycraft.world.gen.generators.trees.noxis.normal.worldGenGreenTree;
import com.laz.tirphycraft.world.gen.generators.trees.noxis.normal.worldGenPurpleTree;
import com.laz.tirphycraft.world.gen.generators.trees.noxis.normal.worldGenWhiteTree;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;

public class BiomeSmallHillsNoxis extends Biome {
	public static final WorldGenAbstractTree TREE1 = new worldGenBlueTree();
	public static final WorldGenAbstractTree TREE2 = new WorldGenNormalCoppirTree();
	public static final WorldGenAbstractTree TREE3 = new WorldGenNormalSilvirTree();
	public static final WorldGenAbstractTree TREE4 = new WorldGenNormalGoldirTree();
	public BiomeSmallHillsNoxis() {

		super(new BiomeProperties("Noxis Small Hills").setBaseHeight(0.5F).setHeightVariation(.4F).setTemperature(0.2F).setRainfall(0.0F).setRainDisabled().setWaterColor(1909616));

		topBlock = BlockInit.NOXIS_GRASS.getDefaultState();
		fillerBlock = BlockInit.NOXIS_DIRT.getDefaultState();

        this.decorator.treesPerChunk = 4;
		this.spawnableCaveCreatureList.clear();
		this.spawnableMonsterList.clear();
		this.spawnableCaveCreatureList.clear();
		this.spawnableCreatureList.clear();
		this.spawnableWaterCreatureList.clear();
		
	}
	@Override
	public WorldGenAbstractTree getRandomTreeFeature(Random rand) {
		if ( rand.nextInt(5000) == 1) return TREE4;
		else if ( rand.nextInt(1000) == 1) return TREE3;
		else if ( rand.nextInt(200) == 1) return TREE2;
		
		int o = rand.nextInt(4);
		if (o==0) return new worldGenBlueTree();
		else if (o==1) return new worldGenGreenTree();
		else if (o==2) return new worldGenWhiteTree();
		else if (o==3) return new worldGenPurpleTree();
				
		return new worldGenBlueTree();

	}
}
