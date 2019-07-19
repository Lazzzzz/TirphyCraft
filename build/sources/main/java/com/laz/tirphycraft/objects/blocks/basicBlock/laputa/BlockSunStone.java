package com.laz.tirphycraft.objects.blocks.basicBlock.laputa;

import com.laz.tirphycraft.objects.base.BlockLightBase;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockSunStone extends BlockLightBase {

	public BlockSunStone(String name, Material material, float hard, float resist, String type, int i, SoundType sound, float light) {
		super(name, material, hard, resist, type, i, sound, light);
			
	}
	
    public void onEntityWalk(World worldIn, BlockPos pos, Entity entityIn)
    {
        if (!entityIn.isImmuneToFire() && entityIn instanceof EntityLivingBase && !EnchantmentHelper.hasFrostWalkerEnchantment((EntityLivingBase)entityIn))
        {
            entityIn.attackEntityFrom(DamageSource.HOT_FLOOR, 1.0F);
        }

        super.onEntityWalk(worldIn, pos, entityIn);
    }

}
