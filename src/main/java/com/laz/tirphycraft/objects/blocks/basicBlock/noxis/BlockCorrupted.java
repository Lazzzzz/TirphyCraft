package com.laz.tirphycraft.objects.blocks.basicBlock.noxis;

import com.laz.tirphycraft.Main;
import com.laz.tirphycraft.init.BlockInit;
import com.laz.tirphycraft.init.ItemInit;
import com.laz.tirphycraft.objects.blocks.item.ItemBlockVariants;
import com.laz.tirphycraft.util.interfaces.IHasModel;
import com.laz.tirphycraft.util.interfaces.IMetaName;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
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

public class BlockCorrupted extends Block implements IHasModel, IMetaName{

	public static final PropertyEnum<enumCorrupted.EnumType> VARIANT = PropertyEnum.<enumCorrupted.EnumType>create(
			"variant", enumCorrupted.EnumType.class);
	
	public BlockCorrupted() {
		super(Material.ROCK);
		setUnlocalizedName("corrupted");
		setRegistryName("corrupted");
		setCreativeTab(Main.tirphycrafttab);
		
		
		this.setHardness(1.5f);
		this.setResistance(30f);	
		this.setHarvestLevel("pickaxe", 0);
		this.setSoundType(SoundType.STONE);
		
		setDefaultState(this.blockState.getBaseState().withProperty(VARIANT, enumCorrupted.EnumType.VARIANT_0));
		
		BlockInit.BLOCKS.add(this);
		ItemInit.ITEMS.add(new ItemBlockVariants(this).setRegistryName(this.getRegistryName()));

	}

	@Override
	public int damageDropped(IBlockState state) {
		return ((enumCorrupted.EnumType) state.getValue(VARIANT)).getMeta();
	}

	@Override
	public int getMetaFromState(IBlockState state) {
		return ((enumCorrupted.EnumType) state.getValue(VARIANT)).getMeta();
	}

	@Override
	public IBlockState getStateFromMeta(int meta) {
		return this.getDefaultState().withProperty(VARIANT, enumCorrupted.EnumType.byMetadata(meta));
	}

	@Override
	public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World world, BlockPos pos,
			EntityPlayer player) {
		return new ItemStack(Item.getItemFromBlock(this), 1, getMetaFromState(world.getBlockState(pos)));
	}

	@Override
	public void getSubBlocks(CreativeTabs itemIn, NonNullList<ItemStack> items) {
		for (enumCorrupted.EnumType variant : enumCorrupted.EnumType.values()) {
			items.add(new ItemStack(this, 1, variant.getMeta()));

		}
	}

	@Override
	protected BlockStateContainer createBlockState() {

		return new BlockStateContainer(this, new IProperty[] { VARIANT });
	}

	@Override
	public String getSpecialName(ItemStack stack) {
		return enumCorrupted.EnumType.values()[stack.getItemDamage()].getName();

	}

	@Override
	public void registerModels() {
		for (int i = 0; i < enumCorrupted.EnumType.values().length; i++) {

			Main.proxy.registerVariantRenderer(Item.getItemFromBlock(this), i,
					"corrupted_" + i, "inventory");
		}

	}
}
