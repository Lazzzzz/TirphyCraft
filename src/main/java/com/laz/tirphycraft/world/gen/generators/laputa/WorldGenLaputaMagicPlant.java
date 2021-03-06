package com.laz.tirphycraft.world.gen.generators.laputa;

import java.util.Random;

import com.laz.tirphycraft.init.BlockInit;

import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;

public class WorldGenLaputaMagicPlant extends WorldGenAbstractTree {
	public static final IBlockState GRASS = BlockInit.LAPUTA_TALL_GRASS.getDefaultState();

	public WorldGenLaputaMagicPlant() {
		super(false);
	}

	@Override
	public boolean generate(World world, Random rand, BlockPos pos) {
		int x = pos.getX();
		int y = pos.getY() - 1;
		int z = pos.getZ();
		int r = rand.nextInt(4) + 2;

		if (world.getBlockState(new BlockPos(x, y, z)) == BlockInit.LAPUTA_GRASS.getDefaultState()) {
			for (int i = 0; i < r; i++) {
				world.setBlockState(new BlockPos(pos.getX(), pos.getY() + i, pos.getZ()), GRASS);

			}

		}

		return true;
	}
}
