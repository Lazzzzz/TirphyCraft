package com.laz.tirphycraft.world.biomes.laputa;

import java.util.Random;

import com.laz.tirphycraft.init.BlockInit;
import com.laz.tirphycraft.world.gen.generators.laputa.WorldGenLaputaCave;
import com.laz.tirphycraft.world.gen.generators.laputa.WorldGenLaputaPick;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;

public class BiomeLaputaCrystal extends Biome {

	public final BiomeLaputaDecorator DECORATEUR = new BiomeLaputaDecorator();
	public final WorldGenLaputaCave CAVE = new WorldGenLaputaCave(20);
	public final WorldGenLaputaPick PICK = new WorldGenLaputaPick();

	public BiomeLaputaCrystal() {

		super(new BiomeProperties("Laputa crystal").setBaseHeight(4F).setHeightVariation(0.25F).setTemperature(0.5F)
				.setRainfall(0.0F).setRainDisabled().setWaterColor(5691638));

		topBlock = BlockInit.LAPUTA_GRASS.getDefaultState();
		fillerBlock = BlockInit.LAPUTA_DIRT.getDefaultState();

		this.spawnableMonsterList.clear();
		this.spawnableCreatureList.clear();
		this.spawnableWaterCreatureList.clear();
		this.spawnableCaveCreatureList.clear();

	}

	@Override
	public void decorate(World worldIn, Random rand, BlockPos pos) {

		DECORATEUR.genDecorator(worldIn, rand, pos, 2, 5, 3 ,-64, -64, 4, 0, 0);

		int o = rand.nextInt(5);
		if (o == 0) {
			int j = rand.nextInt(16) + 8;
			int k = rand.nextInt(16) + 8;
			CAVE.generate(worldIn, rand, worldIn.getHeight(pos.add(j, 0, k)));
		}

		int j = rand.nextInt(16) + 8;
		int k = rand.nextInt(16) + 8;
		PICK.generate(worldIn, rand, worldIn.getHeight(pos.add(j, 0, k)));

	}
}
