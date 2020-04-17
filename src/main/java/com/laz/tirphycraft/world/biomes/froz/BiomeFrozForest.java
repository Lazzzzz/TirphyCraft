package com.laz.tirphycraft.world.biomes.froz;

import java.util.Random;

import com.laz.tirphycraft.init.BlockInit;
import com.laz.tirphycraft.world.biomes.froz.caveDecorator.BiomeFrozCaveDecorator;
import com.laz.tirphycraft.world.gen.generators.froz.WorldGenFrozBlueRose;
import com.laz.tirphycraft.world.gen.generators.trees.froz.WorldGenFrozBigTree;
import com.laz.tirphycraft.world.gen.generators.trees.froz.WorldGenFrozNormalTree;
import com.laz.tirphycraft.world.gen.generators.trees.froz.WorldGenFrozSlick;

import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.gen.feature.WorldGenTaiga2;

public class BiomeFrozForest extends Biome {

	public final WorldGenFrozBlueRose PLANT_ROSE = new WorldGenFrozBlueRose();
	BiomeFrozCaveDecorator CAVE = new BiomeFrozCaveDecorator();
	public BiomeFrozForest() {

		super(new BiomeProperties("Forz Forest").setBaseHeight(0.35F).setHeightVariation(0.175F).setTemperature(-10F)
				.setRainfall(100F).setWaterColor(4092311));

		topBlock = Blocks.GRASS.getDefaultState();
		fillerBlock = Blocks.DIRT.getDefaultState();

		this.decorator.treesPerChunk = 10;
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
		
		int o = rand.nextInt(70);
		if (o==1) {
			int j = rand.nextInt(16) + 8;
			int k = rand.nextInt(16) + 8;
			PLANT_ROSE.generate(worldIn, rand, worldIn.getHeight(pos.add(j, 0, k)));
		}
			
		if (rand.nextInt(100) == 1) {
			int j = rand.nextInt(16) + 8;
			int k = rand.nextInt(16) + 8;	
			new WorldGenFrozBigTree().generate(worldIn, rand, worldIn.getHeight(pos.add(j, 0, k)));
		}
		if (rand.nextInt(2) == 0) {
			int j = rand.nextInt(16) + 8;
			int k = rand.nextInt(16) + 8;	
			 new WorldGenFrozNormalTree(rand.nextInt(8)+2, BlockInit.LEAVES_FROZ.getDefaultState(), BlockInit.LOG_FROZ.getDefaultState()).generate(worldIn, rand, worldIn.getHeight(pos.add(j, 0, k)));;
		}
		else if (rand.nextInt(2) == 0) {
			int j = rand.nextInt(16) + 8;
			int k = rand.nextInt(16) + 8;	
			new WorldGenTaiga2(true).generate(worldIn, rand, worldIn.getHeight(pos.add(j, 0, k)));;
		}
		else {
			int j = rand.nextInt(16) + 8;
			int k = rand.nextInt(16) + 8;	
			new WorldGenFrozSlick().generate(worldIn, rand, worldIn.getHeight(pos.add(j, 0, k)));;
		}
		
		super.decorate(worldIn, rand, pos);
	}

	@Override
	public int getGrassColorAtPos(BlockPos pos) {
		return 2908825;
	}

}
