package com.laz.tirphycraft.world.biomes.froz;

import java.util.Random;

import com.laz.tirphycraft.init.BlockInit;
import com.laz.tirphycraft.world.gen.generators.plants.WorldGenFrozBlueRose;
import com.laz.tirphycraft.world.gen.generators.trees.froz.WorldGenFrozBigTree;
import com.laz.tirphycraft.world.gen.generators.trees.froz.WorldGenFrozNormalTree;

import net.minecraft.client.Minecraft;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraft.world.gen.feature.WorldGenTaiga1;
import net.minecraft.world.gen.feature.WorldGenTrees;

public class BiomeFrozDense extends Biome {

	public final WorldGenFrozBlueRose PLANT_ROSE = new WorldGenFrozBlueRose();
	public BiomeFrozDense() {

		super(new BiomeProperties("Forz Dense").setBaseHeight(0.15F).setHeightVariation(0.125F).setTemperature(-10F)
				.setRainfall(100F).setWaterColor(4092311));

		topBlock = BlockInit.POWDER_SNOW.getDefaultState();
		fillerBlock = Blocks.SNOW.getDefaultState();

		this.decorator.treesPerChunk = 10;
		this.spawnableMonsterList.clear();
		this.spawnableCreatureList.clear();
		this.spawnableWaterCreatureList.clear();
		this.spawnableCaveCreatureList.clear();

	}
	
	@Override
	public void decorate(World worldIn, Random rand, BlockPos pos) {
		int o = rand.nextInt(70);
		if (o==1) {
			int j = rand.nextInt(16) + 8;
			int k = rand.nextInt(16) + 8;
			PLANT_ROSE.generate(worldIn, rand, worldIn.getHeight(pos.add(j, 0, k)));
		}
		super.decorate(worldIn, rand, pos);
	}
	
	@Override
	public WorldGenAbstractTree getRandomTreeFeature(Random rand) {
		int o = rand.nextInt(20);
		if (o==1) return new WorldGenFrozBigTree();
		else return new WorldGenFrozNormalTree(rand.nextInt(8)+2);

	}


}
