package com.laz.tirphycraft.world.biomes.froz;

import java.util.Random;

import com.laz.tirphycraft.init.BlockInit;
import com.laz.tirphycraft.world.biomes.froz.caveDecorator.BiomeFrozCaveDecorator;
import com.laz.tirphycraft.world.biomes.froz.groundDecorator.genFrozEternalGround;
import com.laz.tirphycraft.world.gen.generators.structures.froz.WorldGenFrozDungeon;
import com.laz.tirphycraft.world.gen.generators.trees.froz.WorldGenFrozNormalTree;
import com.laz.tirphycraft.world.gen.generators.trees.froz.WorldGenFrozSlick;

import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.Chunk;

public class BiomeFrozPlaine extends Biome {

	BiomeFrozCaveDecorator CAVE = new BiomeFrozCaveDecorator();
	
	public BiomeFrozPlaine() {

		super(new BiomeProperties("Forz plaine").setBaseHeight(0.125F).setHeightVariation(0.05F).setTemperature(-10F)
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
		Chunk chunk = worldIn.getChunkFromBlockCoords(pos);
		for (int i = 0; i < 16; i++) {
			for (int j = 0; j < 16; j++) {
				int x = chunk.x * 16 + i + 8;
				int z = chunk.z * 16 + j + 8;
				new genFrozEternalGround().generate(worldIn, rand, worldIn.getHeight(new BlockPos(x, 0, z)));
				CAVE.genDecorator(worldIn, rand, new BlockPos(x, 0, z));
			}
		}
		
		if (rand.nextInt(750) == 0) {
			int j = rand.nextInt(16) + 8;
			int k = rand.nextInt(16) + 8;
			new WorldGenFrozDungeon().generate(worldIn, rand, worldIn.getHeight(pos.add(j, 0, k)));
		}
		
		int j = rand.nextInt(16) + 8;
		int k = rand.nextInt(16) + 8;
		
		if (rand.nextBoolean())	{
			new WorldGenFrozNormalTree(rand.nextInt(4) + 2, BlockInit.LEAVES_FROZ.getDefaultState(), BlockInit.LOG_FROZ.getDefaultState()).generate(worldIn, rand, worldIn.getHeight(pos.add(j, 0, k)));;
		} else {
			new WorldGenFrozSlick().generate(worldIn, rand, worldIn.getHeight(pos.add(j, 0, k)));;
		}
		
		super.decorate(worldIn, rand, pos);
	}


	@Override
	public int getGrassColorAtPos(BlockPos pos) {
		return 2908825;
	}
	
}
