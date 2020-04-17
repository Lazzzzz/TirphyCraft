package com.laz.tirphycraft.world.biomes.froz;

import java.util.Random;

import com.laz.tirphycraft.init.BlockInit;
import com.laz.tirphycraft.world.biomes.froz.caveDecorator.BiomeFrozCaveDecorator;
import com.laz.tirphycraft.world.biomes.froz.groundDecorator.genFrozEternalGround;
import com.laz.tirphycraft.world.gen.generators.froz.WorldGenSmallRockPick;

import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.Chunk;

public class BiomeFrozMontain extends Biome {
	public final WorldGenSmallRockPick S_ROCK_PICK = new WorldGenSmallRockPick();
	BiomeFrozCaveDecorator CAVE = new BiomeFrozCaveDecorator();

	public BiomeFrozMontain() {

		super(new BiomeProperties("Forz Montain").setBaseHeight(1.0F).setHeightVariation(0.9F).setTemperature(-10F)
				.setRainfall(100F).setWaterColor(4092311));

		topBlock = Blocks.GRASS.getDefaultState();
		fillerBlock = Blocks.DIRT.getDefaultState();
		
		topBlock = BlockInit.POWDER_SNOW.getDefaultState();
		fillerBlock = Blocks.SNOW.getDefaultState();

		this.decorator.treesPerChunk = 0;
		this.spawnableMonsterList.clear();
		this.spawnableCreatureList.clear();
		this.spawnableWaterCreatureList.clear();
		this.spawnableCaveCreatureList.clear();

	}

	@Override
	public int getGrassColorAtPos(BlockPos pos) {
		return 2908825;
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
		
		if (rand.nextInt(3) == 0) {
			int j = rand.nextInt(16) + 8;
			int k = rand.nextInt(16) + 8;
			S_ROCK_PICK.generate(worldIn, rand, worldIn.getHeight(pos.add(j, 0, k)));
		}
	}

}
