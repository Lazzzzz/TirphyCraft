package com.laz.tirphycraft.world.biomes.froz;

import java.util.Random;

import com.laz.tirphycraft.init.BlockInit;
import com.laz.tirphycraft.world.gen.generators.structures.froz.WorldGenFrozDungeon;
import com.laz.tirphycraft.world.gen.generators.trees.froz.WorldGenFrozNormalTree;

import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;

public class BiomeFrozPlaine extends Biome {

	public BiomeFrozPlaine() {

		super(new BiomeProperties("Forz plaine").setBaseHeight(0.125F).setHeightVariation(0.05F).setTemperature(-10F)
				.setRainfall(100F).setWaterColor(4092311));

		topBlock = BlockInit.POWDER_SNOW.getDefaultState();
		fillerBlock = Blocks.SNOW.getDefaultState();

		this.decorator.treesPerChunk = 1;
		this.spawnableMonsterList.clear();
		this.spawnableCreatureList.clear();
		this.spawnableWaterCreatureList.clear();
		this.spawnableCaveCreatureList.clear();

	}

	@Override
	public void decorate(World worldIn, Random rand, BlockPos pos) {
		int o = rand.nextInt(1000);
		if (o == 0) {
			int j = rand.nextInt(16) + 8;
			int k = rand.nextInt(16) + 8;
			new WorldGenFrozDungeon().generate(worldIn, rand, worldIn.getHeight(pos.add(j, 0, k)));
		}
		super.decorate(worldIn, rand, pos);
	}

	@Override
	public WorldGenAbstractTree getRandomTreeFeature(Random rand) {
		return new WorldGenFrozNormalTree(rand.nextInt(4) + 2);

	}

}
