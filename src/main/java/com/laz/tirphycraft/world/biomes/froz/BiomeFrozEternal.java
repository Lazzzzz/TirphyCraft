package com.laz.tirphycraft.world.biomes.froz;

import java.util.Random;

import com.laz.tirphycraft.init.BlockInit;
import com.laz.tirphycraft.world.biomes.froz.caveDecorator.BiomeFrozCaveDecorator;
import com.laz.tirphycraft.world.biomes.froz.groundDecorator.genFrozEternalGround;
import com.laz.tirphycraft.world.gen.generators.froz.WorldGenIceCrystal;
import com.laz.tirphycraft.world.gen.generators.trees.froz.WorldGenFrozBigTree;
import com.laz.tirphycraft.world.gen.generators.trees.froz.WorldGenFrozNormalTree;
import com.laz.tirphycraft.world.gen.generators.trees.froz.WorldGenFrozSlick;

import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.Chunk;

public class BiomeFrozEternal extends Biome {
	
	public static BiomeFrozCaveDecorator CAVE = new BiomeFrozCaveDecorator();
	public static genFrozEternalGround GROUND = new genFrozEternalGround();
	
	public BiomeFrozEternal() {

		super(new BiomeProperties("Froz Eternal").setBaseHeight(-1.0F).setHeightVariation(0.5F).setTemperature(-10F)
				.setRainfall(100F).setWaterColor(4092311));

		topBlock = Blocks.GRASS.getDefaultState();
		fillerBlock = Blocks.DIRT.getDefaultState();

		this.decorator.treesPerChunk = 8;
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
				GROUND.generate(worldIn, rand, worldIn.getHeight(new BlockPos(x, 0, z)));
				CAVE.genDecorator(worldIn, rand, new BlockPos(x, 0, z));
			}
		}
		
		
		int j = rand.nextInt(16) + 8;
		int k = rand.nextInt(16) + 8;
		new WorldGenIceCrystal().generate(worldIn, rand, worldIn.getHeight(pos.add(j, rand.nextInt(5), k)));
		
		j = rand.nextInt(16) + 8;
		k = rand.nextInt(16) + 8;
		
		if (rand.nextInt(70) == 0) {
			new WorldGenFrozBigTree().generate(worldIn, rand, worldIn.getHeight(pos.add(j, rand.nextInt(5), k)));
		}
		if (rand.nextBoolean())	{
			new WorldGenFrozNormalTree(rand.nextInt(4) + 2, BlockInit.LEAVES_FROZ.getDefaultState(), BlockInit.LOG_FROZ.getDefaultState()).generate(worldIn, rand, worldIn.getHeight(pos.add(j, rand.nextInt(5), k)));
		}
		else {
			new WorldGenFrozSlick().generate(worldIn, rand, worldIn.getHeight(pos.add(j, rand.nextInt(5), k)));
		}
	
	}
	

	@Override
	public int getGrassColorAtPos(BlockPos pos) {
		return 2908825;
	}

}
