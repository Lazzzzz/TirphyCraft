package com.laz.tirphycraft.gosyn.common.blocks.dungeons.stage1;

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

public class BlockFortnestBrick extends Block implements IHasModel, IMetaName{

	public static final PropertyEnum<enumFortnestBrick.EnumType> VARIANT = PropertyEnum.<enumFortnestBrick.EnumType>create(
			"variant", enumFortnestBrick.EnumType.class);
	
	public BlockFortnestBrick() {
		super(Material.ROCK);
		setUnlocalizedName("fortnest_brick");
		setRegistryName("fortnest_brick");
		setCreativeTab(Main.tirphycrafttab);
		
		
		this.setHardness(1.5f);
		this.setResistance(30f);	
		this.setHarvestLevel("pickaxe", 0);
		this.setSoundType(SoundType.STONE);
		
		setDefaultState(this.blockState.getBaseState().withProperty(VARIANT, enumFortnestBrick.EnumType.VARIANT_0));
		
		BlockInit.BLOCKS.add(this);
		ItemInit.ITEMS.add(new ItemBlockVariants(this).setRegistryName(this.getRegistryName()));

	}

	@Override
	public int damageDropped(IBlockState state) {
		return ((enumFortnestBrick.EnumType) state.getValue(VARIANT)).getMeta();
	}

	@Override
	public int getMetaFromState(IBlockState state) {
		return ((enumFortnestBrick.EnumType) state.getValue(VARIANT)).getMeta();
	}

	@Override
	public IBlockState getStateFromMeta(int meta) {
		return this.getDefaultState().withProperty(VARIANT, enumFortnestBrick.EnumType.byMetadata(meta));
	}

	@Override
	public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World world, BlockPos pos,
			EntityPlayer player) {
		return new ItemStack(Item.getItemFromBlock(this), 1, getMetaFromState(world.getBlockState(pos)));
	}

	@Override
	public void getSubBlocks(CreativeTabs itemIn, NonNullList<ItemStack> items) {
		for (enumFortnestBrick.EnumType variant : enumFortnestBrick.EnumType.values()) {
			items.add(new ItemStack(this, 1, variant.getMeta()));

		}
	}

	@Override
	protected BlockStateContainer createBlockState() {

		return new BlockStateContainer(this, new IProperty[] { VARIANT });
	}

	@Override
	public String getSpecialName(ItemStack stack) {
		return enumFortnestBrick.EnumType.values()[stack.getItemDamage()].getName();

	}

	@Override
	public void registerModels() {
		for (int i = 0; i < enumFortnestBrick.EnumType.values().length; i++) {

			Main.proxy.registerVariantRenderer(Item.getItemFromBlock(this), i,
					"fortnest_brick_" + i, "inventory");
		}

	}
}
