package com.laz.tirphycraft.world.biomes.froz.caveDecorator;

import java.util.Random;

import com.laz.tirphycraft.init.BlockInit;

import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;

public class CaveGenVines extends WorldGenAbstractTree {
	public static final IBlockState GRASS = BlockInit.NOXIS_GRASS.getDefaultState();
	public static final IBlockState PLANT = BlockInit.FROZ_PLANT_BLUE_ROSE.getDefaultState();

	public CaveGenVines() {
		super(false);
	}

	@Override
	public boolean generate(World worldIn, Random rand, BlockPos pos) {
		if (worldIn.canSeeSky(pos)) return false;
		
		worldIn.setBlockState(pos.down(), Blocks.GRASS.getDefaultState());
		
		for (int i = pos.getY(); i < 256; i++) {
			if (worldIn.getBlockState(new BlockPos(pos.getX(), i, pos.getZ())) != Blocks.AIR.getDefaultState()) {
				break;
			} else {
				worldIn.setBlockState(new BlockPos(pos.getX(), i, pos.getZ()), BlockInit.FROZ_VINES.getDefaultState());
			}
			
		}

		return true;

	}
}
