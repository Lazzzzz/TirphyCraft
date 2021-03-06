package com.laz.tirphycraft.world.biomes.laputa;

import java.util.Random;

import com.laz.tirphycraft.init.BlockInit;
import com.laz.tirphycraft.world.gen.generators.trees.noxis.normal.worldGenBlueTree;
import com.laz.tirphycraft.world.gen.generators.trees.noxis.normal.worldGenGreenTree;
import com.laz.tirphycraft.world.gen.generators.trees.noxis.normal.worldGenPurpleTree;
import com.laz.tirphycraft.world.gen.generators.trees.noxis.normal.worldGenWhiteTree;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;

public class BiomeLaputaRainbow extends Biome {

	public final BiomeLaputaDecorator DECORATEUR = new BiomeLaputaDecorator();

	public BiomeLaputaRainbow() {

		super(new BiomeProperties("Laputa rainbow").setBaseHeight(4F).setHeightVariation(0.25F).setTemperature(0.5F)
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

		for (int i = 0; i < 3; i++) {
			int j = rand.nextInt(16) + 8;
			int k = rand.nextInt(16) + 8;
			switch (rand.nextInt(4)) {
			case 0:
				new worldGenPurpleTree().generate(worldIn, rand, worldIn.getHeight(pos.add(j, 0, k)));
				break;
			case 1:
				new worldGenBlueTree().generate(worldIn, rand, worldIn.getHeight(pos.add(j, 0, k)));
				break;
			case 2:
				new worldGenGreenTree().generate(worldIn, rand, worldIn.getHeight(pos.add(j, 0, k)));
				break;
			case 3:
				new worldGenWhiteTree().generate(worldIn, rand, worldIn.getHeight(pos.add(j, 0, k)));
				break;
			}
		}
		DECORATEUR.genDecorator(worldIn, rand, pos, 0, 0, 3 , -64, -64, 0, -2, 0);

	}
}
