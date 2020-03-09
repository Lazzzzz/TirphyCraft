package com.laz.tirphycraft.objects.blocks.customModel;

import javax.annotation.Nullable;

import com.laz.tirphycraft.init.BlockInit;
import com.laz.tirphycraft.objects.base.BlockBase;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.FMLCommonHandler;

public class Altar extends BlockBase {

	public static final AxisAlignedBB NEUTRAL_PILLAR = new AxisAlignedBB(0.0D, -1.0D, 0.0D, 1.0D, 1.0D, 1.0D);

	public Altar(String name) {
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
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
		return NEUTRAL_PILLAR;
	}

	@Nullable
	public AxisAlignedBB getCollisionBoundingBox(IBlockState blockState, IBlockAccess worldIn, BlockPos pos) {
		return NEUTRAL_PILLAR;
	}

	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn,
			EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {

		int x = pos.getX();
		int y = pos.getY();
		int z = pos.getZ();
		if (!worldIn.isRemote) {
			if (!playerIn.isSneaking()) {
				playerIn.sendMessage(new TextComponentString(
						"\u00a7f" + "when the 5 fragments are gathered at the same place, it will happen..."));
	
				// white
			} else if (worldIn.getBlockState(new BlockPos(x - 3, y - 1, z + 2)).getBlock() == BlockInit.WHITE_PILLAR) {
				playerIn.sendMessage(new TextComponentString("\u00a72" + " --- White fragment active"));
				// yellow
				if (worldIn.getBlockState(new BlockPos(x - 2, y - 1, z + 4)).getBlock() == BlockInit.YELLOW_PILLAR) {
					playerIn.sendMessage(new TextComponentString("\u00a72" + " --- yellow fragment active"));
					// blue
					if (worldIn.getBlockState(new BlockPos(x, y - 1, z + 5)).getBlock() == BlockInit.BLUE_PILLAR) {
						playerIn.sendMessage(new TextComponentString("\u00a72" + " --- blue fragment active"));
						// red
						if (worldIn.getBlockState(new BlockPos(x + 2, y - 1, z + 4)).getBlock() == BlockInit.RED_PILLAR) {
							playerIn.sendMessage(new TextComponentString("\u00a72" + " --- red fragment active"));
							// green
							if (worldIn.getBlockState(new BlockPos(x + 3, y - 1, z + 2)).getBlock() == BlockInit.GREEN_PILLAR) {
								playerIn.sendMessage(new TextComponentString("\u00a72" + " --- green fragment active"));
								if (playerIn instanceof EntityPlayerMP) {
									MinecraftServer minecraftserver = FMLCommonHandler.instance().getMinecraftServerInstance();
									if (minecraftserver != null) {
										minecraftserver.getCommandManager().executeCommand((EntityPlayerMP) playerIn, "tpdim 120");
										return true;
									}
								}
							} else {
								playerIn.sendMessage(new TextComponentString("\u00a74" + " Missing fragment"));
							}
						} else {
							playerIn.sendMessage(new TextComponentString("\u00a74" + " Missing fragment"));
						}
					} else {
						playerIn.sendMessage(new TextComponentString("\u00a74" + " Missing fragment"));
					}
				} else {
					playerIn.sendMessage(new TextComponentString("\u00a74" + " Missing fragment"));
				}
			} else {
				playerIn.sendMessage(new TextComponentString("\u00a74" + " Missing fragment"));
			}
			return false;
		}
		return true;

	}
}
