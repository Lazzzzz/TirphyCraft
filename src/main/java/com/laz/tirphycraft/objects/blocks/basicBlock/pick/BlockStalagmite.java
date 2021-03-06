package com.laz.tirphycraft.objects.blocks.basicBlock.pick;

import java.util.Random;

import com.laz.tirphycraft.Main;
import com.laz.tirphycraft.objects.base.BlockBase;
import com.laz.tirphycraft.util.interfaces.IHasModel;
import com.laz.tirphycraft.util.interfaces.IMetaName;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockStalagmite extends BlockBase implements IHasModel, IMetaName {

	public static final PropertyEnum<enumStalagmite.EnumType> VARIANT = PropertyEnum.<enumStalagmite.EnumType>create(
			"variant", enumStalagmite.EnumType.class);

	public BlockStalagmite() {
		super("stalagmite", Material.ROCK, 1.5F, 15, "pickaxe", 0, SoundType.STONE);

		setDefaultState(this.blockState.getBaseState().withProperty(VARIANT, enumStalagmite.EnumType.VARIANT_0));
	}

	@SideOnly(Side.CLIENT)
	public BlockRenderLayer getBlockLayer() {
		return BlockRenderLayer.CUTOUT;
	}

	@Override
	public void onBlockAdded(World world, BlockPos pos, IBlockState state) {
		world.scheduleUpdate(pos, this, this.tickRate(world));

	}
	
	@Override
	public BlockFaceShape getBlockFaceShape(IBlockAccess worldIn, IBlockState state, BlockPos pos, EnumFacing face) {
		return BlockFaceShape.UNDEFINED;
	}

	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
		return new AxisAlignedBB(0.09999999403953552D, 0.0D, 0.09999999403953552D, 0.8999999761581421D,
				0.9, 0.8999999761581421D);
	}

	@Override
	public AxisAlignedBB getCollisionBoundingBox(IBlockState blockState, IBlockAccess worldIn, BlockPos pos) {
		return NULL_AABB;
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
	public boolean canPlaceBlockAt(World worldIn, BlockPos pos) {
		return worldIn.getBlockState(pos.down()).isOpaqueCube();
	}

	@Override
	public boolean canSustainPlant(IBlockState state, IBlockAccess world, BlockPos pos, EnumFacing direction,
			IPlantable plantable) {
		// TODO Auto-generated method stub
		return super.canSustainPlant(state, world, pos, direction, plantable);
	}

	@Override
	public int tickRate(World worldIn) {
		return 20;
	}

	@Override
	public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand) {
		if (!worldIn.getBlockState(pos.down()).isOpaqueCube()) {
			worldIn.destroyBlock(pos, true);
		}

		worldIn.scheduleUpdate(pos, this, this.tickRate(worldIn));
	}

	@Override
	public int damageDropped(IBlockState state) {
		return ((enumStalagmite.EnumType) state.getValue(VARIANT)).getMeta();
	}

	@Override
	public int getMetaFromState(IBlockState state) {
		return ((enumStalagmite.EnumType) state.getValue(VARIANT)).getMeta();
	}

	@Override
	public IBlockState getStateFromMeta(int meta) {
		return this.getDefaultState().withProperty(VARIANT, enumStalagmite.EnumType.byMetadata(meta));
	}

	@Override
	public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World world, BlockPos pos,
			EntityPlayer player) {
		return new ItemStack(Item.getItemFromBlock(this), 1, getMetaFromState(world.getBlockState(pos)));
	}

	@Override
	public void getSubBlocks(CreativeTabs itemIn, NonNullList<ItemStack> items) {
		for (enumStalagmite.EnumType variant : enumStalagmite.EnumType.values()) {
			items.add(new ItemStack(this, 1, variant.getMeta()));

		}
	}

	@Override
	protected BlockStateContainer createBlockState() {

		return new BlockStateContainer(this, new IProperty[] { VARIANT });
	}

	@Override
	public String getSpecialName(ItemStack stack) {
		return enumStalagmite.EnumType.values()[stack.getItemDamage()].getName();

	}

	@Override
	public void registerModels() {
		for (int i = 0; i < enumStalagmite.EnumType.values().length; i++) {

			Main.proxy.registerVariantRenderer(Item.getItemFromBlock(this), i,
					"stalactite_" + enumStalagmite.EnumType.values()[i].getName(), "inventory");
		}

	}

}
