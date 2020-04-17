package com.laz.tirphycraft.gosyn.common.blocks.ground;

import javax.annotation.Nullable;

import com.laz.tirphycraft.Main;
import com.laz.tirphycraft.init.BlockInit;
import com.laz.tirphycraft.init.ItemInit;
import com.laz.tirphycraft.util.interfaces.IHasModel;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.MobEffects;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockThorns extends Block implements IHasModel {

    protected static final AxisAlignedBB AABB = new AxisAlignedBB(0.01D, 0.01D, 0.01D, 1.0D-0.01D, 1D-0.01D, 1.0D-0.01D);
	
	public BlockThorns() {
		super(Material.GROUND);
		setUnlocalizedName("gosyn_thorns");
		setRegistryName("gosyn_thorns");
		setCreativeTab(Main.tirphycrafttab);
		
		
		this.setHardness(0.5f);
		this.setResistance(2.5f);	
		this.setHarvestLevel("axe", 0);
		this.setSoundType(SoundType.WOOD);
		
		BlockInit.BLOCKS.add(this);
		ItemInit.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));

	}
	
    @Nullable
    public AxisAlignedBB getCollisionBoundingBox(IBlockState blockState, IBlockAccess worldIn, BlockPos pos)
    {
        return AABB;
    }
	
	@Override
	public void onEntityCollidedWithBlock(World worldIn, BlockPos pos, IBlockState state, Entity entityIn) {
		if (entityIn instanceof EntityLivingBase) {
			entityIn.attackEntityFrom(DamageSource.CACTUS, 4);
			((EntityLivingBase) entityIn).addPotionEffect(new PotionEffect(MobEffects.POISON, 20 * 2, 0, false, false));
		}
		//super.onEntityCollidedWithBlock(worldIn, pos, state, entityIn);
	}
	
	
	
	@Override
	public void registerModels() {
		Main.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");

	}

}
