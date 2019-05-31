package com.laz.tirphycraft.objects.blocks.customModel;

import javax.annotation.Nullable;

import com.laz.tirphycraft.objects.base.BlockBase;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class nixiumCrytsal extends BlockBase {

	public static final AxisAlignedBB AABB = new AxisAlignedBB(0.2D, .0D, 0.2D, 0.8D, 0.8D, 0.8D);

	public nixiumCrytsal(String name) {
		super(name, Material.GLASS, 3, 15, "pickaxe", 3, SoundType.GLASS);
		this.translucent = true;
	}

	@Override
	public boolean isOpaqueCube(IBlockState state) {
		return false;
	}
	
    @Override
    @SideOnly(Side.CLIENT)
    public BlockRenderLayer getBlockLayer()
    {
        return BlockRenderLayer.CUTOUT_MIPPED;
    }	

	@Override
	public boolean isFullCube(IBlockState state) {
		return false;
	}

	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
		return AABB;
	}

	@Nullable
	public AxisAlignedBB getCollisionBoundingBox(IBlockState blockState, IBlockAccess worldIn, BlockPos pos) {
		return AABB;
	}


}
