package com.laz.tirphycraft.objects.blocks.basicBlock.froz;

import com.laz.tirphycraft.init.BlockInit;
import com.laz.tirphycraft.objects.base.GrassBase;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockFrozIceVines extends GrassBase {
	public BlockFrozIceVines() {
		super("froz_ice_vines");

	}

	@Override
	public void onBlockAdded(World world, BlockPos pos, IBlockState state) {
		world.scheduleUpdate(pos, this, this.tickRate(world));

	}

	@Override
	public boolean canPlaceBlockAt(World worldIn, BlockPos pos) {
		IBlockState soil = worldIn.getBlockState(pos.down());
		return super.canPlaceBlockAt(worldIn, pos)
				&& soil.getBlock().canSustainPlant(soil, worldIn, pos.down(), net.minecraft.util.EnumFacing.UP, this)
				|| worldIn.getBlockState(pos.down()) == BlockInit.FROZ_VINES.getDefaultState();
	}

	@Override
	protected boolean canSustainBush(IBlockState state) {
		return state.getMaterial() == Material.GROUND || state.getMaterial() == Material.GRASS
				|| state.getBlock().getDefaultState() == BlockInit.FROZ_VINES.getDefaultState();
	}


}
