package com.laz.tirphycraft.world.biomes.laputa;

import java.util.Random;

import com.laz.tirphycraft.init.BlockInit;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;

public class BiomeLaputaMagic extends Biome {

	public final BiomeLaputaDecorator DECORATEUR = new BiomeLaputaDecorator();
	
	public BiomeLaputaMagic() {

		super(new BiomeProperties("Laputa magic").setBaseHeight(0.125F).setHeightVariation(0.05F).setTemperature(0.5F)
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
		DECORATEUR.genDecorator(worldIn, rand, pos, -2, 8, 1, -64, -64, 0, -6, 0);
	
	}

}
