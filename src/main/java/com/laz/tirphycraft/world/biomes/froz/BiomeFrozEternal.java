package com.laz.tirphycraft.world.biomes.froz;

import java.util.Random;

import com.laz.tirphycraft.world.gen.generators.froz.WorldIceCrystal;
import com.laz.tirphycraft.world.gen.generators.trees.froz.WorldGenFrozBigTree;
import com.laz.tirphycraft.world.gen.generators.trees.froz.WorldGenFrozNormalTree;
import com.laz.tirphycraft.world.gen.generators.trees.froz.WorldGenFrozSlick;

import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraft.world.gen.feature.WorldGenIcePath;
import net.minecraft.world.gen.feature.WorldGenTaiga2;

public class BiomeFrozEternal extends Biome {

	public BiomeFrozEternal() {

		super(new BiomeProperties("Froz Eternal").setBaseHeight(-1.0F).setHeightVariation(1.0F).setTemperature(-10F)
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
		int j = rand.nextInt(16) + 8;
		int k = rand.nextInt(16) + 8;
		new WorldIceCrystal().generate(worldIn, rand, worldIn.getHeight(pos.add(j, rand.nextInt(5), k)));
		
		j = rand.nextInt(16) + 8;
		k = rand.nextInt(16) + 8;
		
		if (rand.nextInt(70) == 0) new WorldGenFrozBigTree().generate(worldIn, rand, worldIn.getHeight(pos.add(j, rand.nextInt(5), k)));
		if (rand.nextBoolean())	new WorldGenFrozNormalTree(rand.nextInt(4) + 2).generate(worldIn, rand, worldIn.getHeight(pos.add(j, rand.nextInt(5), k)));
		else new WorldGenFrozSlick().generate(worldIn, rand, worldIn.getHeight(pos.add(j, rand.nextInt(5), k)));
	
	}
	

	@Override
	public int getGrassColorAtPos(BlockPos pos) {
		return 2908825;
	}

}
