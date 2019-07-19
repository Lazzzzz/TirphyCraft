package com.laz.tirphycraft.objects.blocks.basicBlock.laputa;

import java.util.Random;

import javax.annotation.Nullable;

import com.laz.tirphycraft.entity.entityClass.projectile.EntityMeteorite;
import com.laz.tirphycraft.objects.base.BlockBase;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockCloud extends BlockBase {
	
	public BlockCloud() { 
	super("cloud", Material.WEB, 0F, 0F, "pickaxe", 0, SoundType.SNOW);
	this.translucent = true;
	}

    @Nullable
    public AxisAlignedBB getCollisionBoundingBox(IBlockState blockState, IBlockAccess worldIn, BlockPos pos)
    {
        return NULL_AABB;
    }
    @Override
    public void onEntityCollidedWithBlock(World worldIn, BlockPos pos, IBlockState state, Entity entityIn) {
    	if  (entityIn instanceof EntityMeteorite) {
    		worldIn.setBlockToAir(pos);
    	}
    	
    	if (entityIn.motionY < 0) {
    		entityIn.motionY = -0.01;
	    	entityIn.fallDistance = 0;
	    	entityIn.onGround = true;

    }}
    public int quantityDropped(Random random)
    {
        return 0;
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
        return BlockRenderLayer.CUTOUT_MIPPED;
    }
  

    public boolean isFullCube(IBlockState state)
    {
        return false;
    }

    protected boolean canSilkHarvest()
    {
        return true;
    }
	
}


