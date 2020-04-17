package com.laz.tirphycraft.objects.portal.laputa;

import javax.annotation.Nullable;

import com.laz.tirphycraft.init.BiomeInit;
import com.laz.tirphycraft.init.BlockInit;
import com.laz.tirphycraft.objects.portal.enumPortal;
import com.laz.tirphycraft.util.handlers.ConfigHandler;
import com.laz.tirphycraft.util.interfaces.IMetaName;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.FMLCommonHandler;

public class BlockLaputaPortal extends Block implements IMetaName {

	public static final PropertyEnum<enumPortal.EnumType> VARIANT = PropertyEnum.<enumPortal.EnumType>create("variant",
			enumPortal.EnumType.class);

	public BlockLaputaPortal() {
		super(Material.PORTAL);
		setUnlocalizedName("laputa_portal");
		setRegistryName("laputa_portal");

		setDefaultState(this.blockState.getBaseState().withProperty(VARIANT, enumPortal.EnumType.X));
		this.setSoundType(SoundType.GLASS);
		this.setBlockUnbreakable();
		BlockInit.BLOCKS.add(this);

	}

	@Override
	public BlockFaceShape getBlockFaceShape(IBlockAccess worldIn, IBlockState state, BlockPos pos, EnumFacing face) {
		return BlockFaceShape.UNDEFINED;
	}

	@Override
	public void onBlockAdded(World worldIn, BlockPos pos, IBlockState state) {
		if (state == BlockInit.LAPUTA_PORTAL.getDefaultState()) {
			for (int i = -1; i < 2; i++) {
				for (int j = -1; j < 2; j++) {
					if (!(i == 0 && j == 0))
						worldIn.setBlockState(pos.add(i, j, 0), BlockInit.LAPUTA_PORTALNULL.getDefaultState());

				}
			}
		} else {
			for (int i = -1; i < 2; i++) {
				for (int j = -1; j < 2; j++) {
					if (!(i == 0 && j == 0))
						worldIn.setBlockState(pos.add(0, j, i), BlockInit.LAPUTA_PORTALNULL.getDefaultState());

				}
			}

		}
		super.onBlockAdded(worldIn, pos, state);
	}

	@Override
	public void onEntityCollidedWithBlock(World worldIn, BlockPos pos, IBlockState state, Entity entityIn) {

		if (entityIn instanceof EntityPlayerMP && entityIn.dimension != ConfigHandler.DIMENSION_LAPUTA_ID) {
			MinecraftServer minecraftserver = FMLCommonHandler.instance().getMinecraftServerInstance();
			if (minecraftserver != null) {
				minecraftserver.getCommandManager().executeCommand((EntityPlayerMP) entityIn, "TP " + ConfigHandler.DIMENSION_LAPUTA_ID);
				int x = (int) entityIn.posX;
				int z = (int) entityIn.posZ;
				int y = 0;
				BlockPos b = entityIn.getPosition();
				for (int i = 0; i < 30; i++) {
					b = entityIn.world.getBiomeProvider().findBiomePosition(x, z, 256, BiomeInit.biomesSpawn, entityIn.world.rand);
					y = entityIn.world.getChunkFromBlockCoords(b).getHeight(b);
				}
				
				((EntityLivingBase) entityIn).setPositionAndUpdate(b.getX(), y, b.getZ());

			}
		}

	}

	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
		if (blockState != BlockInit.LAPUTA_PORTAL.getDefaultState())
			return new AxisAlignedBB(0D, 0.0D, 0.5D, 1D, 1D, 0.5D);
		return new AxisAlignedBB(0.5D, 0.0D, 0d, 0.5D, 1D, 1D);
	}

	@Nullable
	public AxisAlignedBB getCollisionBoundingBox(IBlockState blockState, IBlockAccess worldIn, BlockPos pos) {
		return NULL_AABB;
	}

	@Override
	public int getMetaFromState(IBlockState state) {
		return ((enumPortal.EnumType) state.getValue(VARIANT)).getMeta();
	}

	@Override
	public IBlockState getStateFromMeta(int meta) {
		return this.getDefaultState().withProperty(VARIANT, enumPortal.EnumType.byMetadata(meta));
	}

	@Override
	public void getSubBlocks(CreativeTabs itemIn, NonNullList<ItemStack> items) {
		for (enumPortal.EnumType variant : enumPortal.EnumType.values()) {
			items.add(new ItemStack(this, 1, variant.getMeta()));

		}
	}

	@Override
	protected BlockStateContainer createBlockState() {

		return new BlockStateContainer(this, new IProperty[] { VARIANT });
	}

	@Override
	public String getSpecialName(ItemStack stack) {
		return enumPortal.EnumType.values()[stack.getItemDamage()].getName();

	}

}
