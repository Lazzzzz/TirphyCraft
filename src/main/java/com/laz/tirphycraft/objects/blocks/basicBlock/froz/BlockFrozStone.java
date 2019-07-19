package com.laz.tirphycraft.objects.blocks.basicBlock.froz;

import java.util.Random;

import com.laz.tirphycraft.init.BlockInit;
import com.laz.tirphycraft.objects.base.BlockBase;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockFrozStone extends BlockBase{

	public BlockFrozStone(String name, Material material, float hard, float resist, String type, int i,
			SoundType sound) {
		super(name, material, hard, resist, type, i, sound);
	}
    
	public Item getItemDropped(IBlockState state, Random rand, int fortune)
    {
        return BlockInit.FROZ_COBBLESTONE.getItemDropped(BlockInit.FROZ_COBBLESTONE.getDefaultState(), rand, fortune);
    }

	@Override
	public boolean canSilkHarvest(World world, BlockPos pos, IBlockState state, EntityPlayer player) {
		return true;
	}
	
}
