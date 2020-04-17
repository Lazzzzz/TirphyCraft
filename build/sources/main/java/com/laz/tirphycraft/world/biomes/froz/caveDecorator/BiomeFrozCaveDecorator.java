package com.laz.tirphycraft.world.biomes.froz.caveDecorator;

import java.util.Random;

import com.laz.tirphycraft.entity.entityClass.aggressive.EntityAngrySnowGolemSoldier;
import com.laz.tirphycraft.init.BlockInit;

import net.minecraft.entity.EntityList;
import net.minecraft.init.Blocks;
import net.minecraft.tileentity.TileEntityMobSpawner;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BiomeFrozCaveDecorator {
	CaveGenWoodPillar WOOD_PILLAR = new CaveGenWoodPillar();
	CaveGenVines VINES = new CaveGenVines();

	public void genDecorator(World worldIn, Random rand, BlockPos pos) {
		int maxSize = 0;
		
		for (int j = worldIn.getHeight(pos).getY(); j > 0; j--) {
			if (worldIn.getBlockState(pos.up(j)) == BlockInit.FROZ_STONE.getDefaultState()) {
				maxSize = j;
				j = 0; 
			}
		}
		
		for (int i = 0; i < maxSize; i++) {
			if (checkForSpace(worldIn, pos.up(i))) {
				whatDeco(worldIn, rand, pos.up(i));
				
			}
		}

	}

	public boolean checkForSpace(World worldIn, BlockPos pos) {
		if (worldIn.getBlockState(pos) ==  BlockInit.FROZ_STONE.getDefaultState()) {
			if (worldIn.getBlockState(pos.up()) == Blocks.AIR.getDefaultState()
					|| worldIn.getBlockState(pos.down()) == Blocks.AIR.getDefaultState()
					|| worldIn.getBlockState(pos.north()) == Blocks.AIR.getDefaultState()
					|| worldIn.getBlockState(pos.south()) == Blocks.AIR.getDefaultState()
					|| worldIn.getBlockState(pos.west()) == Blocks.AIR.getDefaultState()
					|| worldIn.getBlockState(pos.east()) == Blocks.AIR.getDefaultState()) {
				return true;
			}
		}
		return false;
	}
	
	public void whatDeco(World worldIn, Random rand, BlockPos pos) {
		generateWall(worldIn, rand, pos);
		
		if (rand.nextInt(250) == 0) {
			worldIn.setBlockState(pos, Blocks.MOB_SPAWNER.getDefaultState());
			TileEntityMobSpawner spawner = (TileEntityMobSpawner) worldIn.getTileEntity(pos);
			spawner.getSpawnerBaseLogic().setEntityId(EntityList.getKey(EntityAngrySnowGolemSoldier.class));
		}
		
		if (worldIn.getBlockState(pos.down()) == Blocks.AIR.getDefaultState()) {
				generateTop(worldIn, rand, pos);
			}
		
		if (worldIn.getBlockState(pos.up()) == Blocks.AIR.getDefaultState()) {
			generateRandomDeco(worldIn, rand, pos.up());
		
		}
				
	}
	
	public void generateWall(World worldIn, Random rand, BlockPos pos) {
		switch (rand.nextInt(10)) {
		case 0:
			worldIn.setBlockState(pos, BlockInit.FROZ_COBBLESTONE.getDefaultState());
		case 1:
			worldIn.setBlockState(pos, Blocks.ICE.getDefaultState());
		case 2:
			worldIn.setBlockState(pos, Blocks.PACKED_ICE.getDefaultState());
		}
	}
	
	public void generateTop(World worldIn, Random rand, BlockPos pos) {
		int i = rand.nextInt(20);
		if (i == 0)	worldIn.setBlockState(pos.down(), BlockInit.FROZ_CAVE_MOSS.getDefaultState());
		if (i == 1)	worldIn.setBlockState(pos.down(), BlockInit.FROZ_CAVE_ROOT.getDefaultState());
		if (i == 2)	worldIn.setBlockState(pos.down(), BlockInit.STALACTITE.getDefaultState());
	}

	public void generateRandomDeco(World worldIn, Random rand, BlockPos pos) {
		// COMMON DECO
		if (rand.nextInt(10) == 0) {
			int i = rand.nextInt(2);

			if (i == 0)
				VINES.generate(worldIn, rand, pos);
			else if (i == 1)
				WOOD_PILLAR.generate(worldIn, rand, pos);

		}
		/*
		 * rare if (rand.nextInt(20) == 0) {
		 * 
		 * }
		 */
	}

}
