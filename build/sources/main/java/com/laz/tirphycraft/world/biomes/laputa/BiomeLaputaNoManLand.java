package com.laz.tirphycraft.world.biomes.laputa;

import java.util.Random;

import com.laz.tirphycraft.init.BlockInit;

import net.minecraft.block.Block;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.feature.WorldGenLakes;

public class BiomeLaputaNoManLand extends Biome {

	public final BiomeLaputaDecorator DECORATEUR = new BiomeLaputaDecorator();

	public BiomeLaputaNoManLand() {

		super(new BiomeProperties("Laputa no man land").setBaseHeight(0.125F).setHeightVariation(0.05F)
				.setTemperature(0.5F).setRainfall(0.0F).setRainDisabled().setWaterColor(5691638));

		topBlock = BlockInit.LAPUTA_GRASS.getDefaultState();
		fillerBlock = BlockInit.LAPUTA_DIRT.getDefaultState();

		this.spawnableMonsterList.clear();
		this.spawnableCreatureList.clear();
		this.spawnableWaterCreatureList.clear();
		this.spawnableCaveCreatureList.clear();

	}

	@Override
	public void decorate(World worldIn, Random rand, BlockPos pos) {

		int o = rand.nextInt(16);
		if (o == 1) {
			WorldGenLakes lakes = new WorldGenLakes(Block.getBlockFromName("water"));
			int j = rand.nextInt(16) + 8;
			int k = rand.nextInt(16) + 8;
			lakes.generate(worldIn, rand, worldIn.getHeight(pos.add(j, 0, k)));
		}

		DECORATEUR.genDecorator(worldIn, rand, pos, 4, -2, 4, -8, 8, 2, 0, 2);

	}
}
