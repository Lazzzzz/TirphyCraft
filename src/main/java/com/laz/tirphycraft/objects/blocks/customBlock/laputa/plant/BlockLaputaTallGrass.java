package com.laz.tirphycraft.objects.blocks.customBlock.laputa.plant;

import java.util.Random;

import com.laz.tirphycraft.init.BlockInit;
import com.laz.tirphycraft.objects.base.GrassBase;
import com.laz.tirphycraft.util.Reference;
import com.laz.tirphycraft.util.interfaces.ParticleTypes;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockLaputaTallGrass extends GrassBase {
	public BlockLaputaTallGrass() {
		super("laputa_tall_grass");

	}

	@Override
	public void onBlockAdded(World world, BlockPos pos, IBlockState state) {
		world.scheduleUpdate(pos, this, this.tickRate(world));

	}

	@Override
	public boolean canPlaceBlockAt(World worldIn, BlockPos pos) {
		IBlockState soil = worldIn.getBlockState(pos.down());
		return super.canPlaceBlockAt(worldIn, pos)
				&& soil.getBlock().canSustainPlant(soil, worldIn, pos.down(), net.minecraft.util.EnumFacing.UP, this)
				|| worldIn.getBlockState(pos.down()) == BlockInit.LAPUTA_TALL_GRASS.getDefaultState();
	}

	@Override
	protected boolean canSustainBush(IBlockState state) {
		return state.getMaterial() == Material.GROUND || state.getMaterial() == Material.GRASS
				|| state.getBlock().getDefaultState() == BlockInit.LAPUTA_TALL_GRASS.getDefaultState();
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
		for (int l = 0; l < 4; ++l) {
			double d0 = (double) ((float) i + (random.nextInt(20) - 10) * random.nextFloat());
			double d1 = (double) ((float) j + (random.nextInt(20) - 10) * random.nextFloat());
			double d2 = (double) ((float) k + (random.nextInt(20) - 10) * random.nextFloat());
			Reference.PROXY.spawnParticle(worldIn, ParticleTypes.GLINT_WHITE, d0, d1, d2, 0.0D, 0.01D, 0.0D);
			
		}
	}

}
