package com.laz.tirphycraft.objects.blocks.basicBlock.froz.dungeon;

import com.laz.tirphycraft.Main;
import com.laz.tirphycraft.init.BlockInit;
import com.laz.tirphycraft.init.ItemInit;
import com.laz.tirphycraft.objects.blocks.item.ItemBlockVariants;
import com.laz.tirphycraft.util.interfaces.IHasModel;
import com.laz.tirphycraft.util.interfaces.IMetaName;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class BlockBlueBrick extends Block implements IHasModel, IMetaName {

	public static final PropertyEnum<enumHandlerBlueBrick.EnumType> VARIANT = PropertyEnum.<enumHandlerBlueBrick.EnumType>create(
			"variant", enumHandlerBlueBrick.EnumType.class);

	public BlockBlueBrick() {
		super(Material.ROCK);
		setUnlocalizedName("blue_brick");
		setRegistryName("blue_brick");
		setCreativeTab(Main.tirphycrafttab);
		setDefaultState(this.blockState.getBaseState().withProperty(VARIANT, enumHandlerBlueBrick.EnumType.VARIANT_0));

		this.setHardness(3.0F);
		this.setResistance(15.0F);
		this.setHarvestLevel("pickaxe", 2);

		BlockInit.BLOCKS.add(this);
		ItemInit.ITEMS.add(new ItemBlockVariants(this).setRegistryName(this.getRegistryName()));

	}

	@Override
	public int damageDropped(IBlockState state) {
		return ((enumHandlerBlueBrick.EnumType) state.getValue(VARIANT)).getMeta();
	}

	@Override
	public int getMetaFromState(IBlockState state) {
		return ((enumHandlerBlueBrick.EnumType) state.getValue(VARIANT)).getMeta();
	}

	@Override
	public IBlockState getStateFromMeta(int meta) {
		return this.getDefaultState().withProperty(VARIANT, enumHandlerBlueBrick.EnumType.byMetadata(meta));
	}

	@Override
	public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World world, BlockPos pos,
			EntityPlayer player) {
		return new ItemStack(Item.getItemFromBlock(this), 1, getMetaFromState(world.getBlockState(pos)));
	}

	@Override
	public void getSubBlocks(CreativeTabs itemIn, NonNullList<ItemStack> items) {
		for (enumHandlerBlueBrick.EnumType variant : enumHandlerBlueBrick.EnumType.values()) {
			items.add(new ItemStack(this, 1, variant.getMeta()));

		}
	}

	@Override
	protected BlockStateContainer createBlockState() {

		return new BlockStateContainer(this, new IProperty[] { VARIANT });
	}

	@Override
	public String getSpecialName(ItemStack stack) {
		return enumHandlerBlueBrick.EnumType.values()[stack.getItemDamage()].getName();

	}

	@Override
	public void registerModels() {
		for (int i = 0; i < enumHandlerBlueBrick.EnumType.values().length; i++) {

			Main.proxy.registerVariantRenderer(Item.getItemFromBlock(this), i,
					"blue_brick_" + enumHandlerBlueBrick.EnumType.values()[i].getName(), "inventory");
		}

	}

}
