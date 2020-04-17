package com.laz.tirphycraft.objects.portal.laputa;

import javax.annotation.Nullable;

import com.laz.tirphycraft.init.BiomeInit;
import com.laz.tirphycraft.init.BlockInit;
import com.laz.tirphycraft.util.handlers.ConfigHandler;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.FMLCommonHandler;

public class BlockLaputaPortalNull extends Block {

	public BlockLaputaPortalNull() {
		super(Material.AIR);
		this.setBlockUnbreakable();
		setRegistryName("laputa_portalnull");
		BlockInit.BLOCKS.add(this);
	}

	@Override
	public EnumBlockRenderType getRenderType(IBlockState state) {
		return EnumBlockRenderType.INVISIBLE;
	}

	@Override
	public BlockFaceShape getBlockFaceShape(IBlockAccess worldIn, IBlockState state, BlockPos pos, EnumFacing face) {
		return BlockFaceShape.UNDEFINED;
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
	public void onEntityCollidedWithBlock(World worldIn, BlockPos pos, IBlockState state, Entity entityIn) {

		if (entityIn instanceof EntityPlayerMP && entityIn.dimension != ConfigHandler.DIMENSION_LAPUTA_ID) {
			MinecraftServer minecraftserver = FMLCommonHandler.instance().getMinecraftServerInstance();
			if (minecraftserver != null) {
				minecraftserver.getCommandManager().executeCommand((EntityPlayerMP) entityIn, "TP " + ConfigHandler.DIMENSION_LAPUTA_ID);
				int x = (int) entityIn.posX;
				int z = (int) entityIn.posZ;
				int y = 0;
				BlockPos b = entityIn.getPosition();
				for (int i = 0; i < 30; i++) {
					b = entityIn.world.getBiomeProvider().findBiomePosition(x, z, 256, BiomeInit.biomesSpawn, entityIn.world.rand);
					y = entityIn.world.getChunkFromBlockCoords(b).getHeight(b);
				}
				
				((EntityLivingBase) entityIn).setPositionAndUpdate(b.getX(), y, b.getZ());

			}
		}

	}
	
	@Nullable
	public AxisAlignedBB getCollisionBoundingBox(IBlockState blockState, IBlockAccess worldIn, BlockPos pos) {
		return NULL_AABB;
	}
}
