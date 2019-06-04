package com.laz.tirphycraft.objects.blocks.customModel.egg;

import com.laz.tirphycraft.entity.entityClass.boss.EntityHellKing;
import com.laz.tirphycraft.objects.base.BlockBase;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class EggHellKing extends BlockBase {

	public EggHellKing(String name) {
		super(name, Material.GROUND, 0, 0, "pickaxe", 0, SoundType.STONE);
		this.setBlockUnbreakable();

	}

	@Override
	public boolean isOpaqueCube(IBlockState state) {
		return false;
	}

	@Override
	public boolean isFullCube(IBlockState state) {
		return false;
	}
	
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn,
			EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {

		int x = pos.getX();
		int y = pos.getY();
		int z = pos.getZ();

		if (playerIn.isSneaking()) {
			Vec3d view = playerIn.getLookVec();
			playerIn.motionY  = 1;
			playerIn.onGround = false;
			
			playerIn.motionX = -view.x * 2;
			playerIn.motionZ = -view.z * 2;
			if (!worldIn.isRemote) {
				EntityHellKing entity = new EntityHellKing(worldIn);
				entity.setPosition(pos.getX(), pos.getY(), pos.getZ());
								
				worldIn.spawnEntity(entity);
				worldIn.setBlockToAir(pos);
			}
		}
		return true;
	}
}
