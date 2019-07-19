package com.laz.tirphycraft.objects.blocks.basicBlock.froz.dungeon;

import java.util.Random;

import com.laz.tirphycraft.init.ItemInit;
import com.laz.tirphycraft.objects.base.BlockBase;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;

public class BlockBossDoor extends BlockBase {

	public BlockBossDoor() {
		super("froz_boss_door", Material.ROCK, 1, 1, "pickaxe", 0, SoundType.STONE);
		this.setBlockUnbreakable();
	}

	@Override
	public void onBlockAdded(World world, BlockPos pos, IBlockState state) {
		world.scheduleUpdate(pos, this, this.tickRate(world));
	}

	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn,
			EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
		if (!worldIn.isRemote) {
			if (playerIn.inventory.getCurrentItem() != null) {
				if (playerIn.inventory.getCurrentItem().getItem() == ItemInit.FROZ_KEY) {
					worldIn.destroyBlock(pos, false);
					if (!playerIn.isCreative())	playerIn.inventory.clearMatchingItems(ItemInit.FROZ_KEY, -1, 1, null);
					return true;
				} else {
					playerIn.sendMessage(new TextComponentString("\u00A79" + "Need FROZ KEY"));
				}

			}
		}
		return false;

	}

	@Override
	public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand) {
		if (worldIn.getBlockState(pos.add(0, 0, 1)) == Blocks.AIR.getDefaultState()
				|| worldIn.getBlockState(pos.add(0, 0, -1)) == Blocks.AIR.getDefaultState()
				|| worldIn.getBlockState(pos.add(0, 1, 0)) == Blocks.AIR.getDefaultState()
				|| worldIn.getBlockState(pos.add(0, -1, 0)) == Blocks.AIR.getDefaultState()) {
			worldIn.destroyBlock(pos, false);

		}
		worldIn.scheduleUpdate(pos, this, this.tickRate(worldIn));
	}

	@Override
	public int tickRate(World world) {
		return 1;
	}

}
