package com.laz.tirphycraft.entity.entityClass.aggressive;

import com.laz.tirphycraft.init.PotionInit;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackMelee;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAIWanderAvoidWater;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;

public class EntityAngrySnowGolemSoldier extends EntityMob {
	public EntityAngrySnowGolemSoldier(World worldIn) {

		super(worldIn);
		this.setSize(1F, 1F);

	}
	
    protected void initEntityAI()
    {
        this.tasks.addTask(2, new EntityAIWanderAvoidWater(this, 1.0D, 1.0000001E-5F));
        this.tasks.addTask(3, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0F));
        this.tasks.addTask(4, new EntityAILookIdle(this));
        this.tasks.addTask(2, new EntityAIAttackMelee(this, 1.2D, false));
        this.targetTasks.addTask(8, new EntityAINearestAttackableTarget(this, EntityPlayer.class, true));
    }

	@Override
	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(40.0D);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.10000000298023224D);
        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(10);
	}

	@Override
	public float getEyeHeight() {
		return 1.7F;
	}

	@Override
	protected ResourceLocation getLootTable() {
		return null;
	}

	@Override
	protected SoundEvent getAmbientSound() {
		return null;
	}

	@Override
	protected SoundEvent getHurtSound(DamageSource source) {
		return null;
	}

	@Override
	protected SoundEvent getDeathSound() {
		return null;
	}
	
	@Override
	public void onUpdate() {
		super.onUpdate();
	}

	@Override
	public boolean processInteract(EntityPlayer player, EnumHand hand) {
		return false;
	}

	@Override
	public boolean attackEntityAsMob(Entity entityIn) {
		((EntityLivingBase) entityIn).addPotionEffect(new PotionEffect(PotionInit.FREEZE, 20 * 5, 1, false, false));
		return super.attackEntityAsMob(entityIn);
	}

	protected boolean isValidLightLevel() {
		return true;
	}


}
