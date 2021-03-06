package com.laz.tirphycraft.world.biomes.froz;

import java.util.Random;

import com.laz.tirphycraft.init.BlockInit;
import com.laz.tirphycraft.world.biomes.froz.caveDecorator.BiomeFrozCaveDecorator;
import com.laz.tirphycraft.world.gen.generators.trees.froz.WorldGenFrozMiniBushDownTree;
import com.laz.tirphycraft.world.gen.generators.trees.froz.WorldGenFrozNormalTree;
import com.laz.tirphycraft.world.gen.generators.trees.froz.WorldGenGeantTreeFroz;

import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.Chunk;

public class BiomeFrozGiantForest extends Biome {

	BiomeFrozCaveDecorator CAVE = new BiomeFrozCaveDecorator();

	public BiomeFrozGiantForest() {

		super(new BiomeProperties("Forz giant forest").setBaseHeight(0.25F).setHeightVariation(0.225F)
				.setTemperature(-10F).setRainfall(100F).setWaterColor(4092311));

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
		Chunk chunk = worldIn.getChunkFromBlockCoords(pos);
		for (int i = 0; i < 16; i++) {
			for (int j = 0; j < 16; j++) {
				int x = chunk.x * 16 + i + 8;
				int z = chunk.z * 16 + j + 8;
				CAVE.genDecorator(worldIn, rand, new BlockPos(x, 0, z));
			}
		}
		
		int j = rand.nextInt(16) + 8;
		int k = rand.nextInt(16) + 8;
		new WorldGenGeantTreeFroz().generate(worldIn, rand, worldIn.getHeight(pos.add(j, 0, k)));

		int o = rand.nextInt(3);
		if (o == 1) {
			j = rand.nextInt(16) + 8;
			k = rand.nextInt(16) + 8;
			new WorldGenFrozNormalTree(5, BlockInit.LEAVES_FROZ.getDefaultState(), BlockInit.LOG_FROZ.getDefaultState()).generate(worldIn, rand, worldIn.getHeight(pos.add(j, 0, k)));
		}

		o = rand.nextInt(10);
		if (o == 1) {
			j = rand.nextInt(16) + 8;
			k = rand.nextInt(16) + 8;
			new WorldGenFrozMiniBushDownTree().generate(worldIn, rand, worldIn.getHeight(pos.add(j, 0, k)));
		}

	}

	@Override
	public int getGrassColorAtPos(BlockPos pos) {
		return 2908825;
	}

}
