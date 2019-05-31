package com.laz.tirphycraft.entity.aggressive;

import com.laz.tirphycraft.init.ItemInit;
import com.laz.tirphycraft.util.handlers.LootTableHandler;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackRanged;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.entity.projectile.EntityTippedArrow;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

public class EntityTotam extends EntityMob implements IRangedAttackMob {
	public EntityTotam(World worldIn) {

		super(worldIn);
		this.setSize(0.4F, 1.5F);
		this.isImmuneToFire = true;

	}

	@Override
	protected void initEntityAI() {
		this.tasks.addTask(1, new EntityAISwimming(this));
		this.tasks.addTask(2, new EntityAIAttackRanged(this, 0D, 30, 15.0F));
		this.tasks.addTask(2, new EntityAIWander(this, 1.0D));
		this.tasks.addTask(3, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
		this.tasks.addTask(3, new EntityAILookIdle(this));
		this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, false));
		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 0, true, false, null));
	}

	@Override
	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(10.0D);
		this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0D);
		this.getEntityAttribute(SharedMonsterAttributes.KNOCKBACK_RESISTANCE).setBaseValue(1.0D);
		this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(4.0D);
	}

	@Override
	public float getEyeHeight() {
		return 1.3F;
	}

	@Override
	protected ResourceLocation getLootTable() {
		return LootTableHandler.TOTAM_LOOT;
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

	@Override
	public boolean attackEntityAsMob(Entity entityIn) {
		return super.attackEntityAsMob(entityIn);
	}

	protected boolean isValidLightLevel() {
		return true; // don't care about the light level to spawn
	}

	@Override
	public void setSwingingArms(boolean swingingArms) {
		// TODO Auto-generated method stub

	}

	@Override
	public void attackEntityWithRangedAttack(EntityLivingBase target, float distanceFactor) {
        EntityArrow entityarrow = this.getArrow(distanceFactor);
        double d0 = target.posX - this.posX;
        double d1 = target.getEntityBoundingBox().minY + (double)(target.height / 3.0F) - entityarrow.posY;
        double d2 = target.posZ - this.posZ;
        double d3 = (double)MathHelper.sqrt(d0 * d0 + d2 * d2);
        entityarrow.shoot(d0, d1 + d3 * 0.20000000298023224D, d2, 1.6F, (float)(14 - this.world.getDifficulty().getDifficultyId() * 4));
        this.playSound(SoundEvents.ENTITY_SKELETON_SHOOT, 1.0F, 1.0F / (this.getRNG().nextFloat() * 0.4F + 0.8F));
        this.world.spawnEntity(entityarrow);

	}
	
    protected EntityArrow getArrow(float p_190726_1_)
    {
        EntityTippedArrow entitytippedarrow = new EntityTippedArrow(this.world, this);
        entitytippedarrow.setEnchantmentEffectsFromEntity(this, p_190726_1_);
        return entitytippedarrow;
    }
	@Override
	public void onDeath(DamageSource cause) {
		if (!this.world.isRemote) {
				this.world.spawnEntity(
						new EntityItem(this.world, this.posX, this.posY, this.posZ, new ItemStack(ItemInit.COINS, 1)));
			}
		super.onDeath(cause);
	}

}
