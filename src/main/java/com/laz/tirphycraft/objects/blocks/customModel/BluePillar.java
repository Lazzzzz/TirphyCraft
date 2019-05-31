package com.laz.tirphycraft.objects.blocks.customModel;

import javax.annotation.Nullable;

import com.laz.tirphycraft.Main;
import com.laz.tirphycraft.init.BlockInit;
import com.laz.tirphycraft.init.ItemInit;
import com.laz.tirphycraft.util.interfaces.IHasModel;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BluePillar extends Block implements IHasModel{
	
	public static final AxisAlignedBB NEUTRAL_PILLAR = new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 2.0D, 1.0D);
	
	public BluePillar(String name) {
		super(Material.ROCK);
		setUnlocalizedName(name);
		setRegistryName(name);		
		this.setBlockUnbreakable();

		BlockInit.BLOCKS.add(this);
		ItemInit.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
		
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
    public AxisAlignedBB getCollisionBoundingBox(IBlockState blockState, IBlockAccess worldIn, BlockPos pos)
    {
        return NEUTRAL_PILLAR;
    }
    
    @Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
    	if (!worldIn.isRemote) {
     	worldIn.spawnEntity(new EntityItem(worldIn, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(ItemInit.FRAGMENT_BLUE, 1)));
     	worldIn.setBlockState(pos, BlockInit.NEUTRAL_PILLAR.getDefaultState());
    	}
     	return true;
    }
    
    @Override
	public void registerModels() {
		Main.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
		
	}    
    
}
