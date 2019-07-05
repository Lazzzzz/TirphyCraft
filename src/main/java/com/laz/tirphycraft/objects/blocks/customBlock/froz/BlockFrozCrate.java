package com.laz.tirphycraft.objects.blocks.customBlock.froz;

import java.util.Random;

import com.laz.tirphycraft.init.BlockInit;
import com.laz.tirphycraft.objects.base.BlockBase;
import com.laz.tirphycraft.util.loot.BlockFrozCrateLoot;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
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
        return BlockInit.FROZ_COBBLESTONE.getItemDropped(Blocks.AIR.getDefaultState(), rand, fortune);
    }
	
}
