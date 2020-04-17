package com.laz.tirphycraft.world.biomes.froz;

import java.util.Random;

import com.laz.tirphycraft.world.biomes.froz.caveDecorator.BiomeFrozCaveDecorator;
import com.laz.tirphycraft.world.biomes.froz.groundDecorator.genFrozEternalGround;
import com.laz.tirphycraft.world.gen.generators.froz.WorldGenIcePillar;
import com.laz.tirphycraft.world.gen.generators.froz.WorldGenIceVines;

import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.Chunk;

public class BiomeFrozSlawomirBurrows extends Biome {

	BiomeFrozCaveDecorator CAVE = new BiomeFrozCaveDecorator();
	
	public BiomeFrozSlawomirBurrows() {

		super(new BiomeProperties("Forz Slawomir Burrows").setBaseHeight(0.7F).setHeightVariation(0.05F).setTemperature(-10F)
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
		
		for (int i = 0; i < 3; i++) {
			int j = rand.nextInt(16) + 8;
			int k = rand.nextInt(16) + 8;
			new WorldGenIcePillar().generate(worldIn, rand, worldIn.getHeight(pos.add(j, 0, k)));
		}
		
		for (int i = 0; i < 10; i++) {
			int j = rand.nextInt(16) + 8;
			int k = rand.nextInt(16) + 8;
			new WorldGenIceVines().generate(worldIn, rand, worldIn.getHeight(pos.add(j, 0, k)));
		}
	}

	@Override
	public int getGrassColorAtPos(BlockPos pos) {
		return 2908825;
	}

}
