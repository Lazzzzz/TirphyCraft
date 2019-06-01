package com.laz.tirphycraft.objects.blocks.customBlock.laputa.crystal;

import java.util.Random;

import com.laz.tirphycraft.objects.base.BlockCrystalFullBase;
import com.laz.tirphycraft.util.Reference;
import com.laz.tirphycraft.util.interfaces.ParticleTypes;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockGreenCrystalFull extends BlockCrystalFullBase {

	public BlockGreenCrystalFull() {
		super("laputa_green", Material.GLASS, 2, 2, "pickaxe", 0, SoundType.GLASS, 0.3F);
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
			Reference.PROXY.spawnParticle(worldIn, ParticleTypes.GLINT_GREEN, d0, d1, d2, 0.0D, 0.01D, 0.0D);
		}
	}

}
