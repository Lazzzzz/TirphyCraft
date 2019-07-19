package com.laz.tirphycraft.objects.blocks.basicBlock.bush;

import java.util.Random;

import com.laz.tirphycraft.init.BlockInit;
import com.laz.tirphycraft.init.ItemInit;
import com.laz.tirphycraft.objects.base.BlockBase;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockBushRed extends BlockBase {

	public BlockBushRed(String name, Material material, float hard, float resist, String type, int i, SoundType sound) {
		super(name, material, hard, resist, type, i, sound);

		this.setLightOpacity(1);
		this.translucent = true;

	}

	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn,
			EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {

		if (!worldIn.isRemote) {
			worldIn.spawnEntity(new EntityItem(worldIn, pos.getX(), pos.getY(), pos.getZ(),
					new ItemStack(ItemInit.FRUIT_BALL_RED, new Random().nextInt(2) + 1)));
			worldIn.setBlockState(pos, BlockInit.BUSH_BASE.getDefaultState());
		}
		return true;

	}
	public Item getItemDropped(IBlockState state, Random rand, int fortune)
    {
        return BlockInit.BUSH_BASE.getItemDropped(BlockInit.BUSH_BASE.getDefaultState(), rand, fortune);
    }
    @Override
    public boolean isOpaqueCube(IBlockState state)
    {
        return false;
    }    
    
    @Override
    @SideOnly(Side.CLIENT)
    public BlockRenderLayer getBlockLayer()
    {
        return BlockRenderLayer.TRANSLUCENT;
    }
  

    public boolean isFullCube(IBlockState state)
    {
        return false;
    }

}
