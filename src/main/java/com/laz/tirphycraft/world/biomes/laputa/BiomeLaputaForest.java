package com.laz.tirphycraft.world.biomes.laputa;

import java.util.Random;

import com.laz.tirphycraft.init.BlockInit;
import com.laz.tirphycraft.world.gen.generators.deco.laputa.WorldGenLaputaBigCloud;
import com.laz.tirphycraft.world.gen.generators.deco.laputa.WorldGenLaputaCloud;
import com.laz.tirphycraft.world.gen.generators.pad.WorldGenLightPad;
import com.laz.tirphycraft.world.gen.generators.pick.WorldBlackCrystal;
import com.laz.tirphycraft.world.gen.generators.plants.WorldGenLaputaPlant;
import com.laz.tirphycraft.world.gen.generators.trees.laputa.WorldGenGeantTree;
import com.laz.tirphycraft.world.gen.generators.trees.laputa.WorldGenNormalTree;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.feature.WorldGenLakes;

public class BiomeLaputaForest extends Biome {

	public final BiomeLaputaDecorator DECORATEUR = new BiomeLaputaDecorator();
	
	public BiomeLaputaForest() {

		super(new BiomeProperties("Laputa forest").setBaseHeight(0.125F).setHeightVariation(0.05F).setTemperature(0.5F)
				.setRainfall(0.0F).setRainDisabled().setWaterColor(5691638));

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
		if (o==1) {
			WorldGenLakes lakes = new WorldGenLakes(Block.getBlockFromName("water"));
			int j = rand.nextInt(16) + 8;
			int k = rand.nextInt(16) + 8;
			lakes.generate(worldIn, rand, worldIn.getHeight(pos.add(j, 0, k)));
		}
		
		DECORATEUR.genDecorator(worldIn, rand, pos, -2, 4, 4, -64, -4, 4, 0, 0);
	}
}
