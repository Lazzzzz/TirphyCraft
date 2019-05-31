package com.laz.tirphycraft.objects.blocks.customBlock.laputa.plant;

import java.util.Random;

import com.laz.tirphycraft.Main;
import com.laz.tirphycraft.init.BlockInit;
import com.laz.tirphycraft.init.ItemInit;
import com.laz.tirphycraft.util.interfaces.IHasModel;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.common.IPlantable;

public class BlockLaputaGrass extends Block implements IHasModel {
	public BlockLaputaGrass(String name, Material material, float hard, float resist, SoundType sound) {
		super(material);
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(Main.tirphycrafttab);
		
		this.setHardness(hard);
		this.setHarvestLevel("shovel", 0);
		this.setResistance(resist);
		this.setSoundType(sound);
		
		BlockInit.BLOCKS.add(this);
		ItemInit.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
		
	}

	
	@Override
	public boolean canSustainPlant(IBlockState state, IBlockAccess world, BlockPos pos, EnumFacing direction,IPlantable plantable) {
		return true;
	}
	
	public Item getItemDropped(IBlockState state, Random rand, int fortune)
    {
        return BlockInit.LAPUTA_DIRT.getItemDropped(BlockInit.LAPUTA_DIRT.getDefaultState(), rand, fortune);
    }
	
	@Override
	public void registerModels() {
		Main.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
		
	}
	
	
}
