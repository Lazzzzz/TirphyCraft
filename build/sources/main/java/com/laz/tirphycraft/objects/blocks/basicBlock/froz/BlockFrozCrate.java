package com.laz.tirphycraft.objects.blocks.basicBlock.froz;

import java.util.Random;

import com.laz.tirphycraft.objects.base.BlockBase;
import com.laz.tirphycraft.util.loot.BlockFrozCrateLoot;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockFrozCrate extends BlockBase{

	public BlockFrozCrate() {
		super("froz_crate", Material.WOOD, 3, 3, "axe", 0, SoundType.WOOD);
	}
    
	@Override
	public void onBlockDestroyedByPlayer(World worldIn, BlockPos pos, IBlockState state) {
		new BlockFrozCrateLoot().spawnLoot(worldIn, new Random(), pos);
		super.onBlockDestroyedByPlayer(worldIn, pos, state);
	}
	
	public Item getItemDropped(IBlockState state, Random rand, int fortune)
    {
		return Blocks.AIR.getItemDropped(Blocks.AIR.getDefaultState(), rand, fortune);
    }
	
	@Override
	public boolean canSilkHarvest(World world, BlockPos pos, IBlockState state, EntityPlayer player) {
		return false;
	}
}
