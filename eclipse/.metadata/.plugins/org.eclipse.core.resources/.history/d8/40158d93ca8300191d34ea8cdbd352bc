package com.laz.tirphycraft.world.biomes.noxis;

import java.util.Random;

import com.laz.tirphycraft.entity.aggressive.EntityPhorus;
import com.laz.tirphycraft.entity.aggressive.EntityTotam;
import com.laz.tirphycraft.entity.passif.EntityBuffalo;
import com.laz.tirphycraft.init.BlockInit;
import com.laz.tirphycraft.world.gen.generators.pad.WorldGenRockPad;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;

public class BiomeRockNoxis extends Biome {

	public final WorldGenRockPad ROCK_PAD = new WorldGenRockPad(3);
	
	public BiomeRockNoxis() {

		super(new BiomeProperties("Noxis Rock").setBaseHeight(0.125F).setHeightVariation(0.05F).setTemperature(0.8F)
				.setRainfall(0.0F).setRainDisabled().setWaterColor(1909616));

		topBlock = BlockInit.NOXIS_STONE.getDefaultState();
		fillerBlock = BlockInit.NOXIS_STONE.getDefaultState();

		this.spawnableMonsterList.clear();
		this.spawnableCaveCreatureList.clear();
		this.spawnableCreatureList.clear();
		this.spawnableWaterCreatureList.clear();
	}

	@Override
	public void decorate(World worldIn, Random rand, BlockPos pos) {
		int o = rand.nextInt(4);
		if (o <= 2) {
			int j = rand.nextInt(16) - 8;
			int k = rand.nextInt(16) - 8;
			this.ROCK_PAD.generate(worldIn, rand, worldIn.getHeight(pos.add(j, 0, k)));
		}
		
		
		
		super.decorate(worldIn, rand, pos);
	}
	
	
	
}
