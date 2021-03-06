package com.laz.tirphycraft.objects.base;

import java.util.Random;

import javax.annotation.Nullable;

import com.laz.tirphycraft.Main;
import com.laz.tirphycraft.init.BlockInit;
import com.laz.tirphycraft.init.ItemInit;
import com.laz.tirphycraft.util.interfaces.IHasModel;

import net.minecraft.block.BlockLog;
import net.minecraft.block.SoundType;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockCrystalBase extends BlockLog implements IHasModel {

	protected static final AxisAlignedBB SAPLING_AABB = new AxisAlignedBB(0.09999999403953552D, 0.0D,
			0.09999999403953552D, 0.8999999761581421D, 0.800000011920929D, 0.8999999761581421D);

	public BlockCrystalBase(String name) {
		setUnlocalizedName(name);
		setRegistryName(name);
		setSoundType(SoundType.GLASS);
		setLightLevel((float) 0.3);
		setHarvestLevel("pickaxe", 0);
		setDefaultState(this.blockState.getBaseState().withProperty(LOG_AXIS, EnumAxis.Y));
		setCreativeTab(Main.tirphycrafttab);

		BlockInit.BLOCKS.add(this);
		ItemInit.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));

	}
	
	@Override
	public void onEntityCollidedWithBlock(World worldIn, BlockPos pos, IBlockState state, Entity entityIn) {
		entityIn.attackEntityFrom(DamageSource.GENERIC, 2.0F);
		super.onEntityCollidedWithBlock(worldIn, pos, state, entityIn);
	}

	@Override
	public void onBlockAdded(World world, BlockPos pos, IBlockState state) {
		world.scheduleUpdate(pos, this, this.tickRate(world));

	}

	@Override
	public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand) {
		this.checkFix(worldIn, pos, state, rand);
		worldIn.scheduleUpdate(pos, this, this.tickRate(worldIn));
	}

	@Override
	public int tickRate(World world) {
		return 10;
	}

	@Nullable
	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
		return SAPLING_AABB;
	}

	@Nullable
	@Override
	public AxisAlignedBB getCollisionBoundingBox(IBlockState blockState, IBlockAccess worldIn, BlockPos pos) {
		return NULL_AABB;
	}

	@Override
	public IBlockState getStateFromMeta(int meta) {
		IBlockState state = this.getDefaultState();

		switch (meta & 6) {
		case 0:
			state = state.withProperty(LOG_AXIS, EnumAxis.Y);
			break;

		case 2:
			state = state.withProperty(LOG_AXIS, EnumAxis.X);
			break;

		case 4:
			state = state.withProperty(LOG_AXIS, EnumAxis.Z);
			break;

		default:
			state = state.withProperty(LOG_AXIS, EnumAxis.NONE);
		}

		return state;
	}

	@SuppressWarnings("incomplete-switch")
	@Override
	public int getMetaFromState(IBlockState state) {
		int i = 0;

		switch ((BlockLog.EnumAxis) state.getValue(LOG_AXIS)) {
		case X:
			i |= 2;
			break;

		case Y:
			i |= 4;
			break;

		case Z:
			i |= 6;
		}

		return i;
	}

	@Override
	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, new IProperty[] { LOG_AXIS });
	}

	@Override
	protected ItemStack getSilkTouchDrop(IBlockState state) {
		return new ItemStack(this);
	}

    @Override
    public boolean isOpaqueCube(IBlockState state)
    {
        return false;
    }    
    
    @Override
    @SideOnly(Side.CLIENT)
    public BlockRenderLayer getBlockLayer()
    {
        return BlockRenderLayer.CUTOUT_MIPPED;
    }
  
    public boolean isFullCube(IBlockState state)
    {
        return false;
    }

	@Override
	public void registerModels() {
		Main.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
	}

	public void checkFix(World worldIn, BlockPos pos, IBlockState state, Random rand) {
		if (state == state.withProperty(LOG_AXIS, EnumAxis.Y)) {
			if (!worldIn.getBlockState(pos.add(0, -1, 0)).isFullBlock()
					&& (!worldIn.getBlockState(pos.add(0, +1, 0)).isFullBlock())) {
				worldIn.destroyBlock(pos, false);
			}
		}

		else if (state == state.withProperty(LOG_AXIS, EnumAxis.X)) {
			if (!worldIn.getBlockState(pos.add(-1, 0, 0)).isFullBlock()
					&& (!worldIn.getBlockState(pos.add(1, 0, 0)).isFullBlock())) {
				worldIn.destroyBlock(pos, false);
			}
		}

		else if (state == state.withProperty(LOG_AXIS, EnumAxis.Z)) {
			if (!worldIn.getBlockState(pos.add(0, 0, -1)).isFullBlock()
					&& (!worldIn.getBlockState(pos.add(0, 0, 1)).isFullBlock())) {
				worldIn.destroyBlock(pos, false);
			}
		}
	}
}