package com.laz.tirphycraft.world.biomes.froz;

import java.util.Random;

import com.laz.tirphycraft.init.BlockInit;
import com.laz.tirphycraft.world.biomes.froz.caveDecorator.BiomeFrozCaveDecorator;
import com.laz.tirphycraft.world.gen.generators.froz.WorldGenIceVillage;
import com.laz.tirphycraft.world.gen.generators.trees.froz.WorldGenFrozNormalTree;

import net.minecraft.block.BlockLeaves;
import net.minecraft.block.BlockOldLeaf;
import net.minecraft.block.BlockOldLog;
import net.minecraft.block.BlockPlanks;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;

public class BiomeFrozPlate extends Biome {
	BiomeFrozCaveDecorator CAVE = new BiomeFrozCaveDecorator();
	
	public BiomeFrozPlate() {
		super(new BiomeProperties("Plate").setBaseHeight(4F).setHeightVariation(0.01F).setTemperature(-10F)
				.setRainfall(100F).setWaterColor(4092311));

		this.topBlock = Blocks.GRASS.getDefaultState();
		this.fillerBlock = Blocks.DIRT.getDefaultState();

		this.spawnableMonsterList.clear();
		this.spawnableCreatureList.clear();
		this.spawnableWaterCreatureList.clear();
		this.spawnableCaveCreatureList.clear();
	}

	@Override
	public void decorate(World worldIn, Random rand, BlockPos pos) {
		if (rand.nextInt(50) == 0) {
			int j = rand.nextInt(16) + 8;
			int k = rand.nextInt(16) + 8;
			new WorldGenIceVillage().generate(worldIn, rand, worldIn.getHeight(pos.add(j, 0, k)));
		}
		for (int i = 0; i < 20; i++) {
			int j = rand.nextInt(16) + 8;
			int k = rand.nextInt(16) + 8;
			CAVE.genDecorator(worldIn, rand, pos.add(j,0,k), 130);
		}

		if (rand.nextInt(2) == 0) {
			int j = rand.nextInt(16) + 8;
			int k = rand.nextInt(16) + 8;
			if (rand.nextBoolean()) {
				new WorldGenFrozNormalTree(rand.nextInt(6) + 3,
						Blocks.LEAVES.getDefaultState().withProperty(BlockOldLeaf.VARIANT, BlockPlanks.EnumType.SPRUCE)
								.withProperty(BlockLeaves.CHECK_DECAY, Boolean.valueOf(false)),
						Blocks.LOG.getDefaultState().withProperty(BlockOldLog.VARIANT, BlockPlanks.EnumType.SPRUCE))
								.generate(worldIn, rand, worldIn.getHeight(pos.add(j, 0, k)));
			} else {
				new WorldGenFrozNormalTree(rand.nextInt(6) + 3, BlockInit.LEAVES_FROZ.getDefaultState(),
						BlockInit.LOG_FROZ.getDefaultState()).generate(worldIn, rand,
								worldIn.getHeight(pos.add(j, 0, k)));
			}
		}

	}

	@Override
	public int getGrassColorAtPos(BlockPos pos) {
		return 2908825;
	}
	
}