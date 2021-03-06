package com.laz.tirphycraft.world.gen.generators.trees.froz;

import java.util.Random;

import com.laz.tirphycraft.init.BlockInit;

import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;

public class WorldGenFrozSlick extends WorldGenAbstractTree {
	public static final IBlockState LOG = BlockInit.LOG_FROZ.getDefaultState();
	public static final IBlockState LEAF = BlockInit.LEAVES_FROZ.getDefaultState();

	private final int minHeight;

	public WorldGenFrozSlick() {
		super(false);
		this.minHeight = 6;
	}

	@Override
	public boolean generate(World world, Random rand, BlockPos pos) {
		int height = this.minHeight + rand.nextInt(3);
		boolean flag = true;

		int x = pos.getX();
		int y = pos.getY();
		int z = pos.getZ();

		if (world.getBlockState(pos.down()) != Blocks.DIRT.getDefaultState()
				&& world.getBlockState(pos.down()) != Blocks.GRASS.getDefaultState()
				&& world.getBlockState(pos.down()) != BlockInit.POWDER_SNOW.getDefaultState()
				&& world.getBlockState(pos.down()) != Blocks.SNOW.getDefaultState())
			return false;

		for (int yPos = y; yPos <= y + 1 + height; yPos++) {
			int b0 = 2;
			if (yPos == y)
				b0 = 1;
			if (yPos >= y + 1 + height - 2)
				b0 = 2;
		}

		for (int yPos = y - 3 + height; yPos <= y + height; yPos++) {
			int b1 = yPos - (y + height);
			int b2 = 1 - b1 / 2;

			for (int xPos = x - b2; xPos <= x + b2; xPos++) {
				int b3 = xPos - x;
				for (int zPos = z - b2; zPos <= z + b2; zPos++) {
					int b4 = zPos - z;
					if (Math.abs(b3) != b2 || Math.abs(b4) != b2 || rand.nextInt(2) != 0 && b1 != 0) {
						BlockPos treePos = new BlockPos(xPos, yPos, zPos);
						IBlockState treeState = world.getBlockState(treePos);
						if (treeState.getBlock().isAir(treeState, world, treePos)
								|| treeState.getBlock().isAir(treeState, world, treePos)) {
							this.setBlockAndNotifyAdequately(world, treePos, LEAF);
						}
					}
				}
			}
		}

		for (int logHeight = 0; logHeight < height; logHeight++) {
			BlockPos up = pos.up(logHeight);
			IBlockState logState = world.getBlockState(up);

			if (logState.getBlock().isAir(logState, world, up) || logState.getBlock().isLeaves(logState, world, up)) {
				this.setBlockAndNotifyAdequately(world, pos.up(logHeight), LOG);
			}
		}

		return true;

	}

}
