package com.laz.tirphycraft.world.gen.generators.laputa;

import java.util.Random;

import com.laz.tirphycraft.init.BlockInit;

import net.minecraft.block.BlockLog;
import net.minecraft.block.BlockLog.EnumAxis;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenLaputaCave extends WorldGenerator {
	private int numberOfBlocks;

	public WorldGenLaputaCave(int blocks) {
		numberOfBlocks = blocks;
	}

	@Override
	public boolean generate(World worldIn, Random rand, BlockPos position) {
		int x = position.getX();
		int y = position.getY() - (rand.nextInt(30) + 15);
		int z = position.getZ();
		int count = 0;

		while (y < position.getY()) {
			if (count < 10 + rand.nextInt(10)) {
				y += 1;
			} else {
				if (rand.nextInt(3) == 0) {
					x += (rand.nextInt(3) - 1) * 2;
				}

				if (rand.nextInt(9) == 0) {
					y += 1;
				}

				if (rand.nextInt(3) == 0) {
					z += (rand.nextInt(3) - 1) * 2;
				}
			}

			this.generateE(worldIn, rand, new BlockPos(x, y, z));
			++count;
		}

		int radius = 1;

		for (int i = -radius; i <= radius; ++i) {
			for (int j = -radius; j <= radius; ++j) {
				// generate crystal
			}
		}
		return true;
	}

	public boolean generateE(World world, Random random, BlockPos pos) {
		float f = random.nextFloat() * (float) Math.PI;
		double d0 = pos.getX() + random.nextInt(3) - 2;
		double d1 = pos.getX() + random.nextInt(3) - 2;
		double d2 = pos.getZ() + random.nextInt(3) - 2;
		double d3 = pos.getZ() + random.nextInt(3) - 2;
		double d4 = pos.getY() + random.nextInt(3) - 2;
		double d5 = pos.getY() + random.nextInt(3) - 2;

		for (int l = 0; l <= numberOfBlocks; ++l) {
			double d6 = d0 + (d1 - d0) * l / numberOfBlocks;
			double d7 = d4 + (d5 - d4) * l / numberOfBlocks;
			double d8 = d2 + (d3 - d2) * l / numberOfBlocks;
			double d9 = random.nextDouble() * numberOfBlocks / 16.0D;
			double d10 = (MathHelper.sin(l * (float) Math.PI / numberOfBlocks) + 1.0F) * d9 + 1.0D;
			double d11 = (MathHelper.sin(l * (float) Math.PI / numberOfBlocks) + 1.0F) * d9 + 1.0D;
			int i1 = MathHelper.floor(d6 - d10 / 2.0D);
			int j1 = MathHelper.floor(d7 - d11 / 2.0D);
			int k1 = MathHelper.floor(d8 - d10 / 2.0D);
			int l1 = MathHelper.floor(d6 + d10 / 2.0D);
			int i2 = MathHelper.floor(d7 + d11 / 2.0D);
			int j2 = MathHelper.floor(d8 + d10 / 2.0D);

			for (int k2 = i1; k2 <= l1; ++k2) {
				double d12 = (k2 + 0.5D - d6) / (d10 / 2.0D);

				if (d12 * d12 < 1.0D) {
					for (int l2 = j1; l2 <= i2; ++l2) {
						double d13 = (l2 + 0.5D - d7) / (d11 / 2.0D);

						if (d12 * d12 + d13 * d13 < 1.0D) {
							for (int i3 = k1; i3 <= j2; ++i3) {
								double d14 = (i3 + 0.5D - d8) / (d10 / 2.0D);
								IBlockState block1 = world.getBlockState(new BlockPos(k2, l2 + 1, i3));

								if (d12 * d12 + d13 * d13 + d14 * d14 < 1.0D
										&& world.getBlockState(new BlockPos(k2, l2, i3)) != Blocks.CHEST) {
									if (world.getBlockState(new BlockPos(k2 + 1, l2, i3)) != Blocks.AIR
											|| world.getBlockState(new BlockPos(k2 - 1, l2, i3)) != Blocks.AIR
											|| world.getBlockState(new BlockPos(k2, l2 + 1, i3)) != Blocks.AIR
											|| world.getBlockState(new BlockPos(k2, l2 - 1, i3)) != Blocks.AIR
											|| world.getBlockState(new BlockPos(k2, l2, i3 + 1)) != Blocks.AIR
											|| world.getBlockState(new BlockPos(k2, l2, i3 - 1)) != Blocks.AIR) {
										world.setBlockState(new BlockPos(k2, l2, i3), Blocks.AIR.getDefaultState());
									}

									createWalls(world, k2 + 1, l2, i3, random);
									createWalls(world, k2 - 1, l2, i3, random);
									createWalls(world, k2, l2 + 1, i3, random);
									createWalls(world, k2, l2 - 1, i3, random);
									createWalls(world, k2, l2, i3 + 1, random);
									createWalls(world, k2, l2, i3 - 1, random);
								}
							}
						}
					}
				}
			}
		}

		return true;
	}

	public void createWalls(World world, int x, int y, int z, Random rand) {
		IBlockState block = pickRandBlock(rand, new BlockPos(x, y, z), world);
		if (world.getBlockState(new BlockPos(x, y, z)).isSideSolid(world, new BlockPos(x, y, z), EnumFacing.UP)) {
			world.setBlockState(new BlockPos(x, y, z), block);
		}
	}

	public IBlockState pickRandBlock(Random rand, BlockPos pos, World worldIn) {
		int r = rand.nextInt(30);
		if (r < 28)
			return BlockInit.LAPUTA_STONE.getDefaultState();

		EnumAxis axe = pickRotation(worldIn, pos, rand);
		
		r = rand.nextInt(15);
		if (r == 0)
			return BlockInit.LAPUTA_BLUE_CRYSTAL.getDefaultState().withProperty(BlockLog.LOG_AXIS, axe);
		else if (r == 1)
			return BlockInit.LAPUTA_GREEN_CRYSTAL.getDefaultState().withProperty(BlockLog.LOG_AXIS, axe);
		else if (r == 2)
			return BlockInit.LAPUTA_PINK_CRYSTAL.getDefaultState().withProperty(BlockLog.LOG_AXIS, axe);
		else if (r == 3)
			return BlockInit.LAPUTA_YELLOW_CRYSTAL.getDefaultState().withProperty(BlockLog.LOG_AXIS, axe);
		else if (r == 4)
			return BlockInit.LAPUTA_PURPLE_CRYSTAL.getDefaultState().withProperty(BlockLog.LOG_AXIS, axe);
				
		r = rand.nextInt(5);
		
		if (r == 0)
			return BlockInit.LAPUTA_BLUE.getDefaultState();
		else if (r == 1)
			return BlockInit.LAPUTA_GREEN.getDefaultState();
		else if (r == 2)
			return BlockInit.LAPUTA_PINK.getDefaultState();
		else if (r == 3)
			return BlockInit.LAPUTA_YELLOW.getDefaultState();
		else return BlockInit.LAPUTA_PURPLE.getDefaultState();

	}

	public EnumAxis pickRotation(World worldIn, BlockPos pos, Random rand) {

		int r = rand.nextInt(3);
		if (r==0) return EnumAxis.Y;
		if (r==1) return EnumAxis.X;
		else return EnumAxis.Z;
	}

}