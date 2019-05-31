package com.laz.tirphycraft.objects.blocks.trees.sapling;

import java.util.Random;

import com.laz.tirphycraft.Main;
import com.laz.tirphycraft.init.BlockInit;
import com.laz.tirphycraft.init.ItemInit;
import com.laz.tirphycraft.util.interfaces.IHasModel;
import com.laz.tirphycraft.world.gen.generators.trees.noxis.WorldGenNormalGoldirTree;

import net.minecraft.block.BlockBush;
import net.minecraft.block.IGrowable;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenBigTree;
import net.minecraft.world.gen.feature.WorldGenTrees;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.event.terraingen.TerrainGen;

public class BlockSaplingGoldir extends BlockBush implements IGrowable, IHasModel {
	public static final PropertyInteger STAGE = PropertyInteger.create("stage", 0, 1);
	protected static final AxisAlignedBB SAPLING_AABB = new AxisAlignedBB(0.09999999403953552D, 0.0D,
			0.09999999403953552D, 0.8999999761581421D, 0.800000011920929D, 0.8999999761581421D);
	private static String type;

	public BlockSaplingGoldir(String name) {
		setUnlocalizedName(name);
		setRegistryName(name);
		this.setDefaultState(this.blockState.getBaseState().withProperty(STAGE, Integer.valueOf(0)));
		setCreativeTab(Main.tirphycrafttab);
		setSoundType(SoundType.PLANT);	
		type = "SELF";

		BlockInit.BLOCKS.add(this);
		ItemInit.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
	}

	// Sapling Shape
	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
		return SAPLING_AABB;
	}

	@Override
	public AxisAlignedBB getCollisionBoundingBox(IBlockState blockState, IBlockAccess worldIn, BlockPos pos) {
		return NULL_AABB;
	}

	@Override
	public boolean canPlaceBlockAt(World worldIn, BlockPos pos) {
		IBlockState soil = worldIn.getBlockState(pos.down());
		return super.canPlaceBlockAt(worldIn, pos)
				&& soil.getBlock().canSustainPlant(soil, worldIn, pos.down(), net.minecraft.util.EnumFacing.UP, this);
	}

	@Override
	public boolean isOpaqueCube(IBlockState state) {
		return false;
	}

	@Override
	public boolean isFullCube(IBlockState state) {
		return false;
	}

	// Variants
	@Override
	public IBlockState getStateFromMeta(int meta) {
		return this.getDefaultState().withProperty(STAGE, Integer.valueOf((meta & 8) >> 3));
	}

	@Override
	public int getMetaFromState(IBlockState state) {
		int i = 0;
		i = i | ((Integer) state.getValue(STAGE)).intValue() << 3;
		return i;
	}

	@Override
	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, new IProperty[] { STAGE });
	}

	@Override
	public void registerModels() {
		Main.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
	}

	// Tree Code

	@Override
	public void grow(World worldIn, Random rand, BlockPos pos, IBlockState state) {
		if (((Integer) state.getValue(STAGE)).intValue() == 0) {
			worldIn.setBlockState(pos, state.cycleProperty(STAGE), 4);
		} else {
			this.generateTree(worldIn, rand, pos, state);
		}
	}

	public void generateTree(World world, Random rand, BlockPos pos, IBlockState state) {
		if (!TerrainGen.saplingGrowTree(world, rand, pos))
			return;
		WorldGenerator gen = (WorldGenerator) (rand.nextInt(10) == 0 ? new WorldGenBigTree(false)
				: new WorldGenTrees(false));
		boolean flag = false;
		int i = 0, j = 0;

		switch (type) {
		case "SELF":
			gen = new WorldGenNormalGoldirTree();

			break;
		}

		IBlockState iblockstate = Blocks.AIR.getDefaultState();
		if (flag) {
			world.setBlockState(pos.add(i, 0, j), iblockstate, 4);
			world.setBlockState(pos.add(i + 1, 0, j), iblockstate, 4);
			world.setBlockState(pos.add(i, 0, j + 1), iblockstate, 4);
			world.setBlockState(pos.add(i + 1, 0, j + 1), iblockstate, 4);
		} else {
			world.setBlockState(pos, iblockstate, 4);
		}

		if (!gen.generate(world, rand, pos.add(i, 0, j))) {
			if (flag) {
				world.setBlockState(pos.add(i, 0, j), iblockstate, 4);
				world.setBlockState(pos.add(i + 1, 0, j), iblockstate, 4);
				world.setBlockState(pos.add(i, 0, j + 1), iblockstate, 4);
				world.setBlockState(pos.add(i + 1, 0, j + 1), iblockstate, 4);
			} else {
				world.setBlockState(pos, iblockstate, 4);
			}
		}
	}

	@Override
	public boolean canGrow(World worldIn, BlockPos pos, IBlockState state, boolean isClient) {
		return true;
	}

	@Override
	public boolean canUseBonemeal(World worldIn, Random rand, BlockPos pos, IBlockState state) {
		return (double) worldIn.rand.nextFloat() < 0.45D;
	}

	@Override
	public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand) {
		if (!worldIn.isRemote) {
			super.updateTick(worldIn, pos, state, rand); // Calls the BlockBush version

			if (worldIn.getLightFromNeighbors(pos.up()) >= 9 && rand.nextInt(7) == 0) {
				this.grow(worldIn, rand, pos, state);
			}
		}
	}

	@Override
	protected boolean canSustainBush(IBlockState state) {
		return state.getMaterial() == Material.GROUND || state.getMaterial() == Material.GRASS

		;
	}

}