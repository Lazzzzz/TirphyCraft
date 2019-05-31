package com.laz.tirphycraft.entity.neutral;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackMelee;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMoveTowardsRestriction;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWanderAvoidWater;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;

public class EntityMothmoth extends EntityZombie {
	
    private int angerLevel;
    /** A random delay until this PigZombie next makes a sound. */
    private int randomSoundDelay;
	
	public EntityMothmoth(World worldIn) {

		super(worldIn);
		this.setSize(1.8F, 2.5F);

	}

	protected void initEntityAI() {
		this.tasks.addTask(0, new EntityAISwimming(this));
		this.tasks.addTask(2, new EntityAIAttackMelee(this, 1.2D, false));
		this.tasks.addTask(5, new EntityAIMoveTowardsRestriction(this, 1.0D));
		this.tasks.addTask(7, new EntityAIWanderAvoidWater(this, 1.0D));
		this.tasks.addTask(8, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
		this.tasks.addTask(8, new EntityAILookIdle(this));
		this.applyEntityAI();
	}

	protected void applyEntityAI() {
		this.targetTasks.addTask(1, new EntityMothmoth.AIHurtByAggressor(this));
		this.targetTasks.addTask(2, new EntityMothmoth.AITargetAggressor(this));
	}

	@Override
	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(80.0D);
		this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.35D);
		this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(7.0D);
	}

	@Override
	public float getEyeHeight() {
		return 1.6F;
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
	public boolean processInteract(EntityPlayer player, EnumHand hand) {
		return false;
	}

	protected boolean isValidLightLevel() {
		return true; // don't care about the light level to spawn
	}
	
    public boolean isAngry()
    {
        return this.angerLevel > 0;
    }
    
	protected boolean shouldBurnInDay() {
		return false;
	}
    
	@Override
	public boolean getCanSpawnHere() {
		return true;
	}
	
	@Override
	public boolean canBeHitWithPotion() {
		if (this.getActivePotionEffect(MobEffects.SLOWNESS) != null) return false;
		else return true;
	}

	private void becomeAngryAt(Entity p_70835_1_) {
		this.angerLevel = 400 + this.rand.nextInt(400);
		this.randomSoundDelay = this.rand.nextInt(40);

		if (p_70835_1_ instanceof EntityLivingBase) {
			this.setRevengeTarget((EntityLivingBase) p_70835_1_);
		}
	}

	static class AIHurtByAggressor extends EntityAIHurtByTarget {
		public AIHurtByAggressor(EntityMothmoth p_i45828_1_) {
			super(p_i45828_1_, true);
		}

		protected void setEntityAttackTarget(EntityCreature creatureIn, EntityLivingBase entityLivingBaseIn) {
			super.setEntityAttackTarget(creatureIn, entityLivingBaseIn);

			if (creatureIn instanceof EntityMothmoth) {
				((EntityMothmoth) creatureIn).becomeAngryAt(entityLivingBaseIn);
			}
		}
	}

	static class AITargetAggressor extends EntityAINearestAttackableTarget<EntityPlayer> {
		public AITargetAggressor(EntityMothmoth p_i45829_1_) {
			super(p_i45829_1_, EntityPlayer.class, true);
		}

		/**
		 * Returns whether the EntityAIBase should begin execution.
		 */
		public boolean shouldExecute() {
			return ((EntityMothmoth) this.taskOwner).isAngry() && super.shouldExecute();
		}

	}
}
