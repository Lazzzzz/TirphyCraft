package com.laz.tirphycraft.world.biomes.froz;

import java.util.Random;

import com.laz.tirphycraft.world.biomes.froz.caveDecorator.BiomeFrozCaveDecorator;
import com.laz.tirphycraft.world.gen.generators.structures.froz.WorldGenFrozSmallDungeon;
import com.laz.tirphycraft.world.gen.generators.trees.froz.WorldGenFrozBushTree;
import com.laz.tirphycraft.world.gen.generators.trees.froz.WorldGenFrozMiniBushDownTree;
import com.laz.tirphycraft.world.gen.generators.trees.froz.WorldGenFrozMiniBushTree;

import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;

public class BiomeFrozDead extends Biome {

	BiomeFrozCaveDecorator CAVE = new BiomeFrozCaveDecorator();

	public BiomeFrozDead() {

		super(new BiomeProperties("Forz dead").setBaseHeight(0.25F).setHeightVariation(0.225F).setTemperature(-10F)
				.setRainfall(100F).setWaterColor(4092311));

		topBlock = Blocks.GRASS.getDefaultState();
		fillerBlock = Blocks.DIRT.getDefaultState();

		this.decorator.treesPerChunk = 3;
		this.spawnableMonsterList.clear();
		this.spawnableCreatureList.clear();
		this.spawnableWaterCreatureList.clear();
		this.spawnableCaveCreatureList.clear();

	}

	@Override
	public void decorate(World worldIn, Random rand, BlockPos pos) {
		int o = rand.nextInt(3);
		if (o == 1) {
			int j = rand.nextInt(16) + 8;
			int k = rand.nextInt(16) + 8;
			new WorldGenFrozBushTree().generate(worldIn, rand, worldIn.getHeight(pos.add(j, 0, k)));
		}
		for (int i = 0; i < 2; i++) {
			int j = rand.nextInt(16) + 8;
			int k = rand.nextInt(16) + 8;
			new WorldGenFrozMiniBushTree().generate(worldIn, rand, worldIn.getHeight(pos.add(j, 0, k)));

			j = rand.nextInt(16) + 8;
			k = rand.nextInt(16) + 8;
			new WorldGenFrozMiniBushDownTree().generate(worldIn, rand, worldIn.getHeight(pos.add(j, 0, k)));
		}
		for (int i = 0; i < 20; i++) {
			int j = rand.nextInt(16) + 8;
			int k = rand.nextInt(16) + 8;
			CAVE.genDecorator(worldIn, rand, pos.add(j, 0, k), 80);
		}
		if (rand.nextInt(25) == 0) {
			int j = rand.nextInt(16) + 8;
			int k = rand.nextInt(16) + 8;
			new WorldGenFrozSmallDungeon().generate(worldIn, rand, worldIn.getHeight(pos.add(j, 0, k)));
		}
	}

	@Override
	public int getGrassColorAtPos(BlockPos pos) {
		return 2908825;
	}

}
