package com.laz.tirphycraft.world.biomes.froz;

import java.util.Random;

import com.laz.tirphycraft.init.BlockInit;
import com.laz.tirphycraft.world.biomes.froz.caveDecorator.BiomeFrozCaveDecorator;
import com.laz.tirphycraft.world.gen.generators.froz.city.WorldGenBuilding;
import com.laz.tirphycraft.world.gen.generators.froz.city.WorldGenGravel;
import com.laz.tirphycraft.world.gen.generators.trees.froz.WorldGenFrozNormalTree;

import net.minecraft.block.BlockLeaves;
import net.minecraft.block.BlockOldLeaf;
import net.minecraft.block.BlockOldLog;
import net.minecraft.block.BlockPlanks;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.Chunk;

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
		Chunk chunk = worldIn.getChunkFromBlockCoords(pos);
		for (int i = 0; i < 16; i++) {
			for (int j = 0; j < 16; j++) {
				int x = chunk.x * 16 + i + 8;
				int z = chunk.z * 16 + j + 8;
				CAVE.genDecorator(worldIn, rand, new BlockPos(x, 0, z));
				BlockPos p = worldIn.getHeight(new BlockPos(x, 0, z)).down();
				if (rand.nextBoolean() && p.getY() > 125) {
					if (rand.nextInt(4) == 0) worldIn.setBlockState(p, Blocks.CONCRETE.getStateFromMeta(15));
					else worldIn.setBlockState(worldIn.getHeight(new BlockPos(x, 0, z)).down(), Blocks.CONCRETE_POWDER.getStateFromMeta(15));
					if (rand.nextInt(100) == 0) worldIn.setBlockState(p, Blocks.GLOWSTONE.getDefaultState());
				}
			}
		}
		
		//generate city
		if (rand.nextInt(2) == 0) {
			int j = chunk.x * 16 + 8;
			int k = chunk.z * 16 + 8;
			new WorldGenBuilding(rand.nextInt(5) +15 , rand.nextInt(5) +5, rand.nextInt(10) +2).generate(worldIn, rand, new BlockPos(j, worldIn.getHeight(pos).getY(), k));
		}else {
			
		}
		for (int i = 0; i < 4; i ++) {
			int j = rand.nextInt(16) + 8;
			int k = rand.nextInt(16) + 8;
			new WorldGenGravel().generate(worldIn, rand, worldIn.getHeight(pos.add(j, 0, k)));
		}
		
		for (int i = 0; i < 5 ; i++) {
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