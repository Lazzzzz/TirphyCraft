package com.laz.tirphycraft.gosyn.common.world.biomes.stage3;

import java.util.Random;

import com.laz.tirphycraft.gosyn.common.world.biomes.base.BiomeStage3Base;
import com.laz.tirphycraft.gosyn.common.world.gen.stage3.featur.worldGenTorns;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class BiomeDarkForest extends BiomeStage3Base{
	
	private final WorldGenerator TORNS = new worldGenTorns();

	public BiomeDarkForest() {
		super("Dark Forest", 0.05F, 1F);
	}

	@Override
	public void decorate(World worldIn, Random rand, BlockPos pos) {
		for (int i = 0; i < 128; i++) {
			int rx = pos.getX() + rand.nextInt(16) + 8;
			int rz = pos.getZ() + rand.nextInt(16) + 8;
			BlockPos poss = worldIn.getHeight(pos.add(rx, 0, rz));

			this.TORNS.generate(worldIn, rand, poss);
		}
	}
	
}
