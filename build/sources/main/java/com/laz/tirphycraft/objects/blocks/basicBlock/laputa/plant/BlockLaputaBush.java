package com.laz.tirphycraft.objects.blocks.basicBlock.laputa.plant;

import java.util.Random;

import com.laz.tirphycraft.init.ItemInit;
import com.laz.tirphycraft.objects.base.GrassBase;

import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockLaputaBush extends GrassBase {
	public BlockLaputaBush() {
		super("laputa_bush");

	}
	
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
		int r = new Random().nextInt(3) + 1;
			if (!worldIn.isRemote) {
				worldIn.spawnEntity(new EntityItem(worldIn, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(ItemInit.DONANGOBLU_FRUIT, r)));
				worldIn.setBlockToAir(pos);
			}
		return super.onBlockActivated(worldIn, pos, state, playerIn, hand, facing, hitX, hitY, hitZ);
	}

	
}
