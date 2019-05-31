package com.laz.tirphycraft.objects.blocks.customModel;

import javax.annotation.Nullable;

import com.laz.tirphycraft.init.BlockInit;
import com.laz.tirphycraft.init.ItemInit;
import com.laz.tirphycraft.objects.base.BlockBase;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class NeutralPillar extends BlockBase {

	public static final AxisAlignedBB NEUTRAL_PILLAR = new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 2.0D, 1.0D);

	public NeutralPillar(String name) {
		super(name, Material.GROUND, 0, 0, "pickaxe", 0, SoundType.STONE);
		this.setBlockUnbreakable();

	}

	@Override
	public boolean isOpaqueCube(IBlockState state) {
		return false;
	}

	@Override
	public boolean isFullCube(IBlockState state) {
		return false;
	}

	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
		return NEUTRAL_PILLAR;
	}

	@Nullable
	public AxisAlignedBB getCollisionBoundingBox(IBlockState blockState, IBlockAccess worldIn, BlockPos pos) {
		return NEUTRAL_PILLAR;
	}

	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn,
			EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
		if (!worldIn.isRemote) {
			if (playerIn.inventory.getCurrentItem() != null) {
				if (playerIn.inventory.getCurrentItem().getItem() == ItemInit.FRAGMENT_BLUE) {
					worldIn.setBlockState(pos, BlockInit.BLUE_PILLAR.getDefaultState());
					playerIn.inventory.clearMatchingItems(ItemInit.FRAGMENT_BLUE, -1, 1, null);
					playerIn.sendMessage(new TextComponentString("\u00a71" + "fragment added"));
					
				}else if (playerIn.inventory.getCurrentItem().getItem() == ItemInit.FRAGMENT_GREEN) {
					worldIn.setBlockState(pos, BlockInit.GREEN_PILLAR.getDefaultState());
					playerIn.inventory.clearMatchingItems(ItemInit.FRAGMENT_GREEN, -1, 1, null);
					playerIn.sendMessage(new TextComponentString("\u00a72" + "fragment added"));
					
				}else if (playerIn.inventory.getCurrentItem().getItem() == ItemInit.FRAGMENT_YELLOW) {
					worldIn.setBlockState(pos, BlockInit.YELLOW_PILLAR.getDefaultState());
					playerIn.inventory.clearMatchingItems(ItemInit.FRAGMENT_YELLOW, -1, 1, null);
					playerIn.sendMessage(new TextComponentString("\u00a7e" + "fragment added"));
					
				}else if (playerIn.inventory.getCurrentItem().getItem() == ItemInit.FRAGMENT_WHITE) {
					worldIn.setBlockState(pos, BlockInit.WHITE_PILLAR.getDefaultState());
					playerIn.inventory.clearMatchingItems(ItemInit.FRAGMENT_WHITE, -1, 1, null);
					playerIn.sendMessage(new TextComponentString("\u00a7f" + "fragment added"));
				
				}else if (playerIn.inventory.getCurrentItem().getItem() == ItemInit.FRAGMENT_RED) {
					worldIn.setBlockState(pos, BlockInit.RED_PILLAR.getDefaultState());
					playerIn.inventory.clearMatchingItems(ItemInit.FRAGMENT_RED, -1, 1, null);
					playerIn.sendMessage(new TextComponentString("\u00a74" + "fragment added"));
					
				}
			}
		}
		return true;
	}

}
