package com.laz.tirphycraft.objects.blocks.customBlock.laputa.crystal;

import java.util.Random;

import javax.annotation.Nullable;

import com.laz.tirphycraft.objects.base.BlockBase;
import com.laz.tirphycraft.objects.base.BlockCrystalBase;
import com.laz.tirphycraft.proxy.ClientProxy;
import com.laz.tirphycraft.proxy.CommonProxy;
import com.laz.tirphycraft.tabs.TirphycraftTab;
import com.laz.tirphycraft.util.Reference;
import com.laz.tirphycraft.util.interfaces.ParticleTypes;

import ca.weblite.objc.Proxy;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.AxisAlignedBB;
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
			Reference.PROXY.spawnParticle(worldIn, ParticleTypes.GLINT_BLUE, d0, d1, d2, 0.0D, 0.1D, 0.0D);
		}
	}

}
