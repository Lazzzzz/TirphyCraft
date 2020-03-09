package com.laz.tirphycraft.objects.blocks.basicBlock.laputa.crystal;

import java.util.Random;

import com.laz.tirphycraft.objects.base.BlockCrystalBase;
import com.laz.tirphycraft.util.Reference;
import com.laz.tirphycraft.util.interfaces.ParticleTypes;

import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockBlueCrystal extends BlockCrystalBase {

	public BlockBlueCrystal() {
		super("laputa_blue_crystal");
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
		if (random.nextInt(3) == 0) {
			double d0 = (double) ((float) i + (random.nextInt(20) - 10) * random.nextFloat());
			double d1 = (double) ((float) j + (random.nextInt(20) - 10) * random.nextFloat());
			double d2 = (double) ((float) k + (random.nextInt(20) - 10) * random.nextFloat());
			Reference.PROXY.spawnParticle(worldIn, ParticleTypes.GLINT_BLUE, d0, d1, d2, 0.0D, 0.01D, 0.0D);
		}
	}
	@Override
	public BlockFaceShape getBlockFaceShape(IBlockAccess worldIn, IBlockState state, BlockPos pos, EnumFacing face) {
		return BlockFaceShape.UNDEFINED;
	}

}
