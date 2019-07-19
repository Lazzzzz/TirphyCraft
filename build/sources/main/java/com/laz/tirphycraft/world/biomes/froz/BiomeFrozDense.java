package com.laz.tirphycraft.world.biomes.froz;

import java.util.Random;

import com.laz.tirphycraft.init.BlockInit;
import com.laz.tirphycraft.world.biomes.froz.caveDecorator.BiomeFrozCaveDecorator;
import com.laz.tirphycraft.world.gen.generators.froz.WorldGenFrozBlueRose;
import com.laz.tirphycraft.world.gen.generators.trees.froz.WorldGenFrozBigTree;
import com.laz.tirphycraft.world.gen.generators.trees.froz.WorldGenFrozNormalTree;

import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraft.world.gen.feature.WorldGenTaiga2;

public class BiomeFrozDense extends Biome {

	public final WorldGenFrozBlueRose PLANT_ROSE = new WorldGenFrozBlueRose();
	public BiomeFrozDense() {

		super(new BiomeProperties("Forz Dense").setBaseHeight(1F).setHeightVariation(0.125F).setTemperature(-10F)
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
		int o = rand.nextInt(70);
		if (o==1) {
			int j = rand.nextInt(16) + 8;
			int k = rand.nextInt(16) + 8;
			PLANT_ROSE.generate(worldIn, rand, worldIn.getHeight(pos.add(j, 0, k)));
		}
		for (int i = 0; i < 20; i++) {
			int j = rand.nextInt(16) + 8;
			int k = rand.nextInt(16) + 8;
			new BiomeFrozCaveDecorator().genDecorator(worldIn, rand, pos.add(j,0,k), 80);
		}
		
		super.decorate(worldIn, rand, pos);
	}
	
	@Override
	public WorldGenAbstractTree getRandomTreeFeature(Random rand) {
		int o = rand.nextInt(50);
		if (o==1) return new WorldGenFrozBigTree();
		else if (rand.nextInt(5) == 0)  return new WorldGenTaiga2(true);
		else return new WorldGenFrozNormalTree(rand.nextInt(8)+2, BlockInit.LEAVES_FROZ.getDefaultState(), BlockInit.LOG_FROZ.getDefaultState());

	}
	
	@Override
	public int getGrassColorAtPos(BlockPos pos) {
		return 2908825;
	}


}
