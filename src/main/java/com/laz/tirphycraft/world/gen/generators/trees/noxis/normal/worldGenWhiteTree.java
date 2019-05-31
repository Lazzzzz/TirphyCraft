package com.laz.tirphycraft.world.gen.generators.trees.noxis.normal;

import com.laz.tirphycraft.init.BlockInit;

import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.world.gen.feature.WorldGenTrees;

public class worldGenWhiteTree extends WorldGenTrees {

	public static final IBlockState LOG = Blocks.LOG.getDefaultState();
	public static final IBlockState LEAF = BlockInit.LEAVES_WHITE.getDefaultState();
	
	public worldGenWhiteTree() {
		super(false, 6, LOG, LEAF, false);
	
	}
	

}
