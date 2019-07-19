package com.laz.tirphycraft.objects.blocks.basicBlock.froz;

import java.util.Random;

import com.laz.tirphycraft.init.ItemInit;
import com.laz.tirphycraft.objects.base.BlockBase;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockHistoireIce extends BlockBase{

	public BlockHistoireIce(String name, Material material, float hard, float resist, String type, int i,
			SoundType sound) {
		super(name, material, hard, resist, type, i, sound);
	}
    
	public Item getItemDropped(IBlockState state, Random rand, int fortune)
    {
        return ItemInit.ORIGIN_MATTER;
    }

	@Override
	public boolean canSilkHarvest(World world, BlockPos pos, IBlockState state, EntityPlayer player) {
		// TODO Auto-generated method stub
		return true;
	}
	
}
