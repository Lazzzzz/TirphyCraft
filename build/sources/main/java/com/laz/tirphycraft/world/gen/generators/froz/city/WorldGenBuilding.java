package com.laz.tirphycraft.world.gen.generators.froz.city;

import java.util.Random;

import com.laz.tirphycraft.init.BlockInit;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenBuilding extends WorldGenerator {
	public int PROBA;
	public int PROBB;
	public int PROBC;

	public WorldGenBuilding(int proba, int probb, int probc) {
		PROBA = proba;
		PROBB = probb;
		PROBC = probc;
	}

	@Override
	public boolean generate(World worldIn, Random rand, BlockPos position) {

		int sizex = rand.nextInt(3);
		int sizey = (rand.nextInt(4) + 1) * 4;
		int sizez = rand.nextInt(3);

		buildWall(worldIn, rand, position, sizex, sizey, sizez);
		buildFloor(worldIn, rand, position, sizex, sizey, sizez);
		for (int i = 0; i < 5; i++) {
			BlockPos p = position.add(rand.nextInt(15 - sizex) + sizex, rand.nextInt(sizey) + 6,
					rand.nextInt(15 - sizez) + sizez);
			destroy(worldIn, rand, p, sizex, sizey, sizez);
		}

		for (int i = sizex; i < 16 - sizex; i++) {
			for (int j = sizez; j < 16 - sizez; j++) {
				for (int k = position.getY() + sizey; k > position.getY() - 3; k--) {
					
					BlockPos pos = new BlockPos(position.getX() + i, k, position.getZ() + j);
					
					if (worldIn.getBlockState(pos).getBlock() == Blocks.STONEBRICK || worldIn.getBlockState(pos).getBlock() == BlockInit.FROZ_BLUE_BRICK || worldIn.getBlockState(pos).getBlock() == Blocks.BRICK_BLOCK ) {
						if (worldIn.getBlockState(pos.up()).getBlock() != Blocks.STONEBRICK && worldIn.getBlockState(pos.up()).getBlock() != BlockInit.FROZ_BLUE_BRICK && worldIn.getBlockState(pos.up()).getBlock() != Blocks.BRICK_BLOCK) {
						if (worldIn.getBlockState(pos.down()).getBlock() != Blocks.STONEBRICK && worldIn.getBlockState(pos.down()).getBlock() != BlockInit.FROZ_BLUE_BRICK && worldIn.getBlockState(pos.down()).getBlock() != Blocks.BRICK_BLOCK) {
						if (worldIn.getBlockState(pos.south()).getBlock() != Blocks.STONEBRICK && worldIn.getBlockState(pos.south()).getBlock() != BlockInit.FROZ_BLUE_BRICK && worldIn.getBlockState(pos.south()).getBlock() != Blocks.BRICK_BLOCK) {
						if (worldIn.getBlockState(pos.north()).getBlock() != Blocks.STONEBRICK && worldIn.getBlockState(pos.north()).getBlock() != BlockInit.FROZ_BLUE_BRICK && worldIn.getBlockState(pos.north()).getBlock() != Blocks.BRICK_BLOCK) {
						if (worldIn.getBlockState(pos.east()).getBlock() != Blocks.STONEBRICK && worldIn.getBlockState(pos.east()).getBlock() != BlockInit.FROZ_BLUE_BRICK && worldIn.getBlockState(pos.east()).getBlock() != Blocks.BRICK_BLOCK) {
						if (worldIn.getBlockState(pos.west()).getBlock() != Blocks.STONEBRICK && worldIn.getBlockState(pos.west()).getBlock() != BlockInit.FROZ_BLUE_BRICK && worldIn.getBlockState(pos.west()).getBlock() != Blocks.BRICK_BLOCK) {
							worldIn.setBlockToAir(pos);
						}}}}}}
					}
				}
			}
		}

		return false;
	}

	public void buildWall(World worldIn, Random rand, BlockPos position, int sizex, int sizey, int sizez) {

		int wm_sizex = (16 - (sizex * 2)) / 4;
		int wm_sizez = (16 - (sizez * 2)) / 4;
		int w_x = 2;// rand.nextInt(2)+2;
		int w_z = 2;// rand.nextInt(2)+2;

		for (int i = sizex; i < 16 - sizex; i++) {
			for (int j = sizez; j < 16 - sizez; j++) {
				for (int k = position.getY() + sizey - rand.nextInt(3); k > 0; k--) {
					BlockPos pos = new BlockPos(position.getX() + i, k, position.getZ() + j);
					
					if (k == position.getY()) {					
						if (worldIn.getBlockState(pos) == Blocks.GRASS.getDefaultState()) {
						if (rand.nextBoolean())
							placeBlock(worldIn, pos, rand);
					
						}
					}
					if (i == sizex || j == sizez || i == 15 - sizex || j == 15 - sizez) {
						if (rand.nextInt(PROBA) > 1)
							placeBlock(worldIn, pos, rand);
					}
					if (worldIn.getBlockState(pos.down()).getMaterial() == Material.ROCK)
						break;
				}
			}
		}
	}

	public void buildFloor(World worldIn, Random rand, BlockPos position, int sizex, int sizey, int sizez) {

		for (int i = sizex + 1; i < 16 - sizex - 1; i++) {
			for (int j = sizez + 1; j < 16 - sizez - 1; j++) {
				for (int k = -4; k < sizey; k += 4) {
					for (int jj = 1; jj < 3; jj++) {
						worldIn.setBlockToAir(position.add(i, k + jj, j));
					}
					if (rand.nextInt(PROBB) > 1)
						placeBlock(worldIn, position.add(i, k, j), rand);
					
					if (rand.nextInt(40) == 0) 	new WorldGenGravel().generate(worldIn, rand,  position.add(i, k, j));
				}
			}
		}
	}

	public boolean destroy(World worldIn, Random rand, BlockPos position, int sizex, int sizey, int sizez) {
		Chunk chunk = worldIn.getChunkFromBlockCoords(position);

		int chunkx = chunk.x * 16;
		int chunkz = chunk.z * 16;

		{
			while (true) {
				if (position.getY() > 3) {
					Block block = worldIn.getBlockState(position.down()).getBlock();
				}

				if (position.getY() <= 3) {
					return false;
				}

				int i1 = 3;

				for (int i = 0; i1 >= 0 && i < 3; ++i) {
					int j = i1 + rand.nextInt(2);
					int k = i1 + rand.nextInt(2);
					int l = i1 + rand.nextInt(2);
					float f = (float) (j + k + l) * 0.333F + 0.5F;

					for (BlockPos blockpos : BlockPos.getAllInBox(position.add(-j, -k, -l), position.add(j, k, l))) {
						if (blockpos.distanceSq(position) <= (double) (f * f)) {
							if (blockpos.getX() >= chunkx && blockpos.getX() <= chunkx + 15) {
								if (blockpos.getZ() >= chunkz && blockpos.getZ() <= chunkz + 15) {
									if (worldIn.getBlockState(blockpos).getBlock() == Blocks.STONEBRICK
											|| worldIn.getBlockState(blockpos).getBlock() == BlockInit.FROZ_BLUE_BRICK || worldIn.getBlockState(blockpos).getBlock() == Blocks.BRICK_BLOCK)
										worldIn.setBlockState(blockpos, Blocks.AIR.getDefaultState());
								}
							}
						}
					}

					position = position.add(-(i1 + 1) + rand.nextInt(2 + i1 * 2), 0 - rand.nextInt(2),
							-(i1 + 1) + rand.nextInt(2 + i1 * 2));
				}

				return true;
			}
		}
	}

	public void placeBlock(World worldIn, BlockPos pos, Random rand) {
		IBlockState block;
		if (rand.nextInt(PROBC) == 0) {
			if (rand.nextInt(5) == 0) block = Blocks.BRICK_BLOCK.getDefaultState();
			else block = Blocks.STONEBRICK.getStateFromMeta(rand.nextInt(4));
		} else {
			block = BlockInit.FROZ_BLUE_BRICK.getStateFromMeta(rand.nextInt(10));
		}

		worldIn.setBlockState(pos, block);
	}
}
