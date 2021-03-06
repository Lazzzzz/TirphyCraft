package com.laz.tirphycraft.world.biomes.laputa;

import java.util.Random;

import com.laz.tirphycraft.entity.entityClass.aggressive.EntityGrindlyFront;
import com.laz.tirphycraft.init.BlockInit;
import com.laz.tirphycraft.world.gen.generators.laputa.WorldGenLaputaCave;
import com.laz.tirphycraft.world.gen.generators.laputa.WorldGenLaputaPick;

import net.minecraft.entity.monster.EntitySlime;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;

public class BiomeLaputaMeteorite extends Biome {

	public final BiomeLaputaDecorator DECORATEUR = new BiomeLaputaDecorator();
	public final WorldGenLaputaCave CAVE = new WorldGenLaputaCave(20);
	public final WorldGenLaputaPick PICK = new WorldGenLaputaPick();

	public BiomeLaputaMeteorite() {

		super(new BiomeProperties("Laputa meteorite").setBaseHeight(0.125F).setHeightVariation(0.05F).setTemperature(2F)
				.setRainfall(0.0F).setRainDisabled().setWaterColor(5691638));

		topBlock = BlockInit.LAPUTA_GRASS.getDefaultState();
		fillerBlock = BlockInit.LAPUTA_DIRT.getDefaultState();

		this.spawnableMonsterList.clear();
		this.spawnableCreatureList.clear();
		this.spawnableWaterCreatureList.clear();
		this.spawnableCaveCreatureList.clear();
		
		this.spawnableCreatureList.add(new SpawnListEntry(EntitySlime.class, 100, 10, 20));

		this.spawnableCreatureList.add(new SpawnListEntry(EntityGrindlyFront.class, 100, 10, 20));

	}

	@Override
	public void decorate(World worldIn, Random rand, BlockPos pos) {

	}
}
