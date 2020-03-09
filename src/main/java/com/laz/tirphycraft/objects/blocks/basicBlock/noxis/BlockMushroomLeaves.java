package com.laz.tirphycraft.objects.blocks.basicBlock.noxis;

import java.util.List;
import java.util.Random;

import com.laz.tirphycraft.init.ItemInit;
import com.laz.tirphycraft.objects.base.BlockLightBase;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockMushroomLeaves extends BlockLightBase {

	public BlockMushroomLeaves() {
		super("leaves_mushroom", Material.WOOD, 1, 0.5F, "axe", 0, SoundType.WOOD, 0.4f);
	}

	@Override
	public void onBlockAdded(World world, BlockPos pos, IBlockState state) {
		world.scheduleUpdate(pos, this, this.tickRate(world));

	}

	@Override
	public boolean isOpaqueCube(IBlockState state) {
		return false;
	}

	@Override
	public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand) {
		AxisAlignedBB box = new AxisAlignedBB(pos.getX() - 5, pos.getY() - 5, pos.getZ() - 5, pos.getX() + 5,
				pos.getY() + 5, pos.getZ() + 5);

		List list = worldIn.getEntitiesWithinAABB(EntityPlayer.class, box);
		if (!list.isEmpty()) {

			for (int i = 0; i <= list.size() - 1; i++) {
				if (((EntityLivingBase) list.get(i)).getItemStackFromSlot(EntityEquipmentSlot.HEAD)
						.getItem() != ItemInit.GAS_MASK) {
					((EntityLivingBase) list.get(i))
							.addPotionEffect(new PotionEffect(MobEffects.POISON, 100, 3, false, false));
				}

			}
		}
		worldIn.scheduleUpdate(pos, this, this.tickRate(worldIn));
	}

	@Override
	public int tickRate(World world) {
		return 10;
	}

	@SideOnly(Side.CLIENT)
	public void randomDisplayTick(IBlockState stateIn, World worldIn, BlockPos pos, Random rand) {
		this.spawnParticles(worldIn, pos);
	}

	private void spawnParticles(World worldIn, BlockPos pos) {
		int i = pos.getX();
		int j = pos.getY();
		int k = pos.getZ();

		Random random = worldIn.rand;
		for (int l = 0; l < 5; ++l) {
			double d0 = (double) ((float) i + (random.nextInt(10)-5)*random.nextFloat());
			double d1 = (double) ((float) j + (random.nextInt(10)-5)*random.nextFloat());
			double d2 = (double) ((float) k + (random.nextInt(10)-5)*random.nextFloat());
			worldIn.spawnParticle(EnumParticleTypes.REDSTONE, d0, d1, d2, 0.9D, 0.7D, 1D, 0);

		}
	}
	
	
}
