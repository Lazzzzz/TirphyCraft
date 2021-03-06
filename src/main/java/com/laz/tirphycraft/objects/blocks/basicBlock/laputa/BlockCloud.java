package com.laz.tirphycraft.objects.blocks.basicBlock.laputa;

import java.util.Random;

import com.laz.tirphycraft.objects.base.BlockBase;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockCloud extends BlockBase {

	public BlockCloud() {
		super("cloud", Material.WEB, 0F, 0F, "pickaxe", 0, SoundType.SNOW);
		this.setLightLevel(0.3f);
	}


	@Override
	public void onEntityCollidedWithBlock(World worldIn, BlockPos pos, IBlockState state, Entity entityIn) {
	}

	public int quantityDropped(Random random) {
		return 0;
	}

	@Override
	public boolean isOpaqueCube(IBlockState state) {
		return true;
	}

	public boolean isFullCube(IBlockState state) {
		return false;
	}

	protected boolean canSilkHarvest() {
		return true;
	}

}
