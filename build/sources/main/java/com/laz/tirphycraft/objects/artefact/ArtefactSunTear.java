package com.laz.tirphycraft.objects.artefact;

import java.util.List;
import java.util.Random;

import com.laz.tirphycraft.objects.base.ItemBase;

import net.minecraft.block.BlockLiquid;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

public class ArtefactSunTear extends ItemBase {

	public ArtefactSunTear() {
		super("sun_tear", 1);

	}
	
	@Override
	public void addInformation(ItemStack stack, World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
		tooltip.add("\u00A75" + "When in inventory :");
		tooltip.add("\u00A74" + "it's like frost walker");
		tooltip.add("\u00A74" + "but with lava...");

	}

	@Override
	public void onUpdate(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
		BlockPos pos = entityIn.getPosition();

		if (entityIn.onGround) {
			float f = 5;
			BlockPos.MutableBlockPos blockpos$mutableblockpos = new BlockPos.MutableBlockPos(0, 0, 0);

			for (BlockPos.MutableBlockPos blockpos$mutableblockpos1 : BlockPos.getAllInBoxMutable(
					pos.add((double) (-f), -1.0D, (double) (-f)), pos.add((double) f, -1.0D, (double) f))) {
				if (blockpos$mutableblockpos1.distanceSqToCenter(entityIn.posX, entityIn.posY,
						entityIn.posZ) <= (double) (f * f)) {
					blockpos$mutableblockpos.setPos(blockpos$mutableblockpos1.getX(),
							blockpos$mutableblockpos1.getY() + 1, blockpos$mutableblockpos1.getZ());
					IBlockState iblockstate = worldIn.getBlockState(blockpos$mutableblockpos);

					if (iblockstate.getMaterial() == Material.AIR) {
						IBlockState iblockstate1 = worldIn.getBlockState(blockpos$mutableblockpos1);

						if (iblockstate1.getMaterial() == Material.LAVA
								&& (iblockstate1.getBlock() == net.minecraft.init.Blocks.LAVA
										|| iblockstate1.getBlock() == net.minecraft.init.Blocks.FLOWING_LAVA)
								&& ((Integer) iblockstate1.getValue(BlockLiquid.LEVEL)).intValue() == 0
								&& worldIn.mayPlace(Blocks.NETHERRACK, blockpos$mutableblockpos1, false,
										EnumFacing.DOWN, (Entity) null)) {
							worldIn.setBlockState(blockpos$mutableblockpos1, Blocks.NETHERRACK.getDefaultState());
							worldIn.scheduleUpdate(blockpos$mutableblockpos1.toImmutable(), Blocks.NETHERRACK,
									MathHelper.getInt(new Random(), 60, 120));
						}
					}
				}
			}
		}
	}

}
