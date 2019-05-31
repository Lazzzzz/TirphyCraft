package com.laz.tirphycraft.objects.base;

import com.laz.tirphycraft.util.interfaces.IHasModel;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.FMLCommonHandler;

public class BlockPortalBase extends BlockBase implements IHasModel {

	private final int dim;

	public BlockPortalBase(String name, int dim) {
		super(name, Material.ROCK, 3, 15, "pickaxe", 3, SoundType.STONE);
		this.dim = dim;
	}


	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn,
			EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
		if (playerIn instanceof EntityPlayerMP) {
			MinecraftServer minecraftserver = FMLCommonHandler.instance().getMinecraftServerInstance();
			if (minecraftserver != null) {
				minecraftserver.getCommandManager().executeCommand((EntityPlayerMP) playerIn, "tpdim " + this.dim);
				return true;
			}
		}
		return false;
	}
}
