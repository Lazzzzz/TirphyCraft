package com.laz.tirphycraft.world.gen.generators.structures.laputa;

import java.util.Random;

import com.laz.tirphycraft.init.BlockInit;
import com.laz.tirphycraft.util.interfaces.IStructure;

import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenLaputaBossRoom extends WorldGenerator implements IStructure {

	public WorldGenLaputaBossRoom() {
	}

	@Override
	public boolean generate(World worldIn, Random rand, BlockPos pos) {
		if (!checkSpace(worldIn, pos))
			return false;
		makeWall(worldIn, pos, rand);
		makeSpace(worldIn, pos);
		placeLamp(worldIn, pos);

		System.out.println(pos);
		return true;
	}

	public boolean checkSpace(World worldIn, BlockPos pos) {
		double x = pos.getX();
		double y = pos.getY();
		double z = pos.getZ();

		if (y < 10)
			return false;

		for (int i = 0; i < 21; i++) {
			for (int j = 0; j < 21; j++) {
				for (int k = 0; k < 6; k++) {
					if (worldIn.getBlockState(new BlockPos(x + i, y - k, z + j)) == Blocks.AIR.getDefaultState()) {
						return false;
					}

				}
			}
		}

		return true;
	}

	public void makeSpace(World worldIn, BlockPos pos) {
		double x = pos.getX();
		double y = pos.getY();
		double z = pos.getZ();

		for (int i = 0; i < 21; i++) {
			for (int j = 0; j < 21; j++) {
				for (int k = 0; k < 6; k++) {
					worldIn.setBlockState(new BlockPos(x + i, y - k, z + j), Blocks.AIR.getDefaultState());
				}
			}
		}
	}

	public void makeWall(World worldIn, BlockPos pos, Random rand) {
		double x = pos.getX();
		double y = pos.getY();
		double z = pos.getZ();

		for (int i = -1; i < 22; i++) {
			for (int j = -1; j < 22; j++) {
				for (int k = -1; k < 7; k++) {
					worldIn.setBlockState(new BlockPos(x + i, y - k, z + j), BlockInit.BRICK_DUNGEON.getDefaultState());
				}
			}
		}
	}

	public IBlockState pickBlock(Random rand) {
		IBlockState block;
		if (rand.nextInt(25) == 0)
			block = BlockInit.BRICK_DUNGEON_SUN.getDefaultState();
		else
			block = BlockInit.BRICK_DUNGEON.getDefaultState();

		return block;

	}

	public void placeLamp(World worldIn, BlockPos pos) {
		double x = pos.getX();
		double y = pos.getY() - 6;
		double z = pos.getZ();

		for (int i = 4; i < 17; i += 2) {
			worldIn.setBlockState(new BlockPos(x + i, y, z + 3), BlockInit.BRICK_DUNGEON_SUN.getDefaultState());
			worldIn.setBlockState(new BlockPos(x + i, y, z + 17), BlockInit.BRICK_DUNGEON_SUN.getDefaultState());
			worldIn.setBlockState(new BlockPos(x + 3, y, z + i), BlockInit.BRICK_DUNGEON_SUN.getDefaultState());
			worldIn.setBlockState(new BlockPos(x + 17, y, z + i), BlockInit.BRICK_DUNGEON_SUN.getDefaultState());
		}

		for (int i = 9; i < 13; i += 2) {
			worldIn.setBlockState(new BlockPos(x + i, y, z + 8), BlockInit.BRICK_DUNGEON_SUN.getDefaultState());
			worldIn.setBlockState(new BlockPos(x + i, y, z + 12), BlockInit.BRICK_DUNGEON_SUN.getDefaultState());
			worldIn.setBlockState(new BlockPos(x + 8, y, z + i), BlockInit.BRICK_DUNGEON_SUN.getDefaultState());
			worldIn.setBlockState(new BlockPos(x + 12, y, z + i), BlockInit.BRICK_DUNGEON_SUN.getDefaultState());
		}
		worldIn.setBlockState(new BlockPos(x + 10, y, z + 10), BlockInit.BRICK_DUNGEON_CONTROLER.getDefaultState());

	}

}
