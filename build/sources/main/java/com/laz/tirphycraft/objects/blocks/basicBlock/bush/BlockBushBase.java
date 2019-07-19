package com.laz.tirphycraft.objects.blocks.basicBlock.bush;

import java.util.Random;

import com.laz.tirphycraft.init.BlockInit;
import com.laz.tirphycraft.objects.base.BlockBase;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockBushBase extends BlockBase{

	public BlockBushBase(String name, Material material, float hard, float resist, String type, int i, SoundType sound) {
		super(name, material, hard, resist, type, i, sound);
	
		this.setLightOpacity(1);
		this.setTickRandomly(true);
		this.translucent = true;
	
	}
	

	@Override
	public void onBlockAdded(World world, BlockPos pos, IBlockState state) {
		world.scheduleUpdate(pos, this, this.tickRate(world));

	}
	
	
	
	@Override
	public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand) {
		int age = rand.nextInt(20);
		
		if (age == 1) {
			int o = rand.nextInt(4);
			if (o == 0)	worldIn.setBlockState(pos, BlockInit.BUSH_BLUE.getDefaultState());
			if (o == 1)	worldIn.setBlockState(pos, BlockInit.BUSH_RED.getDefaultState());
			if (o == 2)	worldIn.setBlockState(pos, BlockInit.BUSH_GREEN.getDefaultState());
		}
		
		worldIn.scheduleUpdate(pos, this, this.tickRate(worldIn));
	}
	
	@Override
	public int tickRate(World world) {
		return 1000;
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
