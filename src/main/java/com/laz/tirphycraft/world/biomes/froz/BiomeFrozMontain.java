package com.laz.tirphycraft.world.biomes.froz;

import java.util.Random;

import com.laz.tirphycraft.init.BlockInit;
import com.laz.tirphycraft.world.biomes.froz.caveDecorator.BiomeFrozCaveDecorator;
import com.laz.tirphycraft.world.gen.generators.froz.WorldGenSmallRockPick;

import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;

public class BiomeFrozMontain extends Biome {
	public final WorldGenSmallRockPick S_ROCK_PICK = new WorldGenSmallRockPick();

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
		if (rand.nextInt(3) == 0) {
			int j = rand.nextInt(16) + 8;
			int k = rand.nextInt(16) + 8;
			S_ROCK_PICK.generate(worldIn, rand, worldIn.getHeight(pos.add(j, 0, k)));
		}
		for (int i = 0; i < 20; i++) {
			int j = rand.nextInt(16) + 8;
			int k = rand.nextInt(16) + 8;
			new BiomeFrozCaveDecorator().genDecorator(worldIn, rand, pos.add(j,0,k), 80);
		}
	}

}
