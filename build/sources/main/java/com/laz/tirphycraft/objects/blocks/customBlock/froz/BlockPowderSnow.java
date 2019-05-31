package com.laz.tirphycraft.objects.blocks.customBlock.froz;

import java.util.Random;

import javax.annotation.Nullable;

import com.laz.tirphycraft.entity.neutral.EntityMothmoth;
import com.laz.tirphycraft.init.ItemInit;
import com.laz.tirphycraft.objects.base.BlockBase;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.init.MobEffects;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockPowderSnow extends BlockBase {

	public BlockPowderSnow() {
		super("powder_snow", Material.SNOW, 0.2F, 1F, "shovel", 0, SoundType.SNOW);
	}

	@Nullable
	public AxisAlignedBB getCollisionBoundingBox(IBlockState blockState, IBlockAccess worldIn, BlockPos pos) {
		return NULL_AABB;
	}

	@Override
	public void onEntityCollidedWithBlock(World worldIn, BlockPos pos, IBlockState state, Entity entityIn) {
		if (entityIn instanceof EntityLivingBase) {
			if (((EntityLivingBase) entityIn).getItemStackFromSlot(EntityEquipmentSlot.HEAD).getItem() != ItemInit.ROSE_HELMET || (((EntityLivingBase) entityIn).getItemStackFromSlot(EntityEquipmentSlot.FEET).getItem() != ItemInit.ROSE_BOOTS || (((EntityLivingBase) entityIn).getItemStackFromSlot(EntityEquipmentSlot.LEGS).getItem() != ItemInit.ROSE_LEGGINGS || (((EntityLivingBase) entityIn).getItemStackFromSlot(EntityEquipmentSlot.CHEST).getItem() != ItemInit.ROSE_CHESTPLATE)))) {
				if (entityIn.motionY < 0) {
					entityIn.motionY = -0.005;
					entityIn.fallDistance = 0;

				}
				if (entityIn instanceof EntityMothmoth) {
				}else {
					((EntityLivingBase) entityIn)
					.addPotionEffect(new PotionEffect(MobEffects.SLOWNESS, 10, 1, false, false));	
				}
				
			}else {
				worldIn.destroyBlock(pos, false);
			}
		}
	}


	public Item getItemDropped(IBlockState state, Random rand, int fortune) {
		return Items.SNOWBALL;
	}

	@Override
	public boolean canSilkHarvest(World world, BlockPos pos, IBlockState state, EntityPlayer player) {
		return true;
	}

	@Override
	public int quantityDropped(IBlockState state, int fortune, Random random) {
		return random.nextInt(4) + fortune + 1;
	}

}
