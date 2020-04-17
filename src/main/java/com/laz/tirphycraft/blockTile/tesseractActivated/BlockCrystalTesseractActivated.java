package com.laz.tirphycraft.blockTile.tesseractActivated;

import javax.annotation.Nullable;

import com.laz.tirphycraft.Main;
import com.laz.tirphycraft.gosyn.common.blocks.counter.BlockTileEntity;
import com.laz.tirphycraft.init.BlockInit;
import com.laz.tirphycraft.util.interfaces.IHasModel;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockCrystalTesseractActivated extends BlockTileEntity<TileEntityCrystalTesseractActivated> implements IHasModel {

	public BlockCrystalTesseractActivated() {
		super(Material.ROCK);
		setUnlocalizedName("tesseract_activated");
		setRegistryName("tesseract_ativated");
		setBlockUnbreakable();
		BlockInit.BLOCKS.add(this);
		
	}

	@Override
	public Class<TileEntityCrystalTesseractActivated> getTileEntityClass() {
		return TileEntityCrystalTesseractActivated.class;
	}

	@Deprecated
	public EnumBlockRenderType getRenderType(IBlockState state) {
		return EnumBlockRenderType.INVISIBLE;
	}

	@Override
	public boolean isFullCube(IBlockState state) {
		return false;
	}

	@Override
	public boolean isOpaqueCube(IBlockState state) {
		return false;
	}

	@Override
	public boolean hasTileEntity(IBlockState state) {
		return true;
	}

	@Nullable
	@Override
	public TileEntityCrystalTesseractActivated createTileEntity(World world, IBlockState state) {
		return new TileEntityCrystalTesseractActivated();
	}

	@Nullable
	public AxisAlignedBB getCollisionBoundingBox(IBlockState blockState, IBlockAccess worldIn, BlockPos pos) {
		return new AxisAlignedBB(-0.05D, 0D, -0.05D, 1.05D, 1.15D, 1.05D);
	}

	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
		return new AxisAlignedBB(-0.05D, 0D, -0.05D, 1.05D, 1.15D, 1.05D);
	}

	@Override
	public void registerModels() {
		Main.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");

	}

}
