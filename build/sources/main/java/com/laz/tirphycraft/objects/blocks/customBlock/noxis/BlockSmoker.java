package com.laz.tirphycraft.objects.blocks.customBlock.noxis;

import java.util.List;
import java.util.Random;

import com.laz.tirphycraft.objects.base.BlockBase;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockSmoker extends BlockBase {

	public BlockSmoker() {
		super("smoker", Material.GRASS, 1, 0.5F, "shovel", 0, SoundType.PLANT);
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
		AxisAlignedBB box = new AxisAlignedBB(pos.getX() - 2, pos.getY(), pos.getZ() - 2, pos.getX() + 3,
				pos.getY() + 4, pos.getZ() + 3);

		List list = worldIn.getEntitiesWithinAABB(EntityPlayer.class, box);
		if (!list.isEmpty()) {

			for (int o = 0; o <= list.size() - 1; o++) {
				((EntityLivingBase) list.get(o)).attackEntityFrom(DamageSource.GENERIC, 3);
				((EntityLivingBase) list.get(o)).setFire(2);
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
		for (int l = 0; l < 20; ++l) {
			double d0 = (double) ((float) i + (random.nextInt(6) - 2) * random.nextFloat());
			double d2 = (double) ((float) k + (random.nextInt(6) - 2) * random.nextFloat());
			worldIn.spawnParticle(EnumParticleTypes.CLOUD, d0, j+1, d2, 0D, 0.2D, 0D, 0);

		}
	}
}
