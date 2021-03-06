package com.laz.tirphycraft.entity.entityClass.aggressive;

import java.util.Random;

import com.laz.tirphycraft.init.ItemInit;
import com.laz.tirphycraft.util.handlers.LootTableHandler;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackRanged;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.ai.EntityMoveHelper;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityLargeFireball;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class EntityCloudy extends EntityMob implements IRangedAttackMob{

	public EntityCloudy(World worldIn) {

		super(worldIn);
		this.setSize(2F, 2F);
		this.isImmuneToFire = true;
		this.moveHelper = new EntityCloudy.CloudyFlyMoveHelper(this);

	}

	@Override
	protected void initEntityAI() {
		this.tasks.addTask(2, new EntityCloudy.AIRandomFly(this));

		this.tasks.addTask(1, new EntityAISwimming(this));
		this.tasks.addTask(2, new EntityAIAttackRanged(this, 0D, 80, 40.0F));
		this.tasks.addTask(2, new EntityAIWander(this, 1.0D));
		this.tasks.addTask(11, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
		this.tasks.addTask(3, new EntityAILookIdle(this));
		this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, false));
		this.targetTasks.addTask(9, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 0, true, false, null));
	}
	
	@Override
	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(40.0D);
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
		return LootTableHandler.CLOUDY_LOOT;
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
        double d0 = target.posX - this.posX;
        double d1 = target.posY - this.posY;
        double d2 = target.posZ - this.posZ;
		EntityLargeFireball entityarrow = this.getArrow(distanceFactor, d0, d1, d2);
        double d3 = (double)MathHelper.sqrt(d0 * d0 + d2 * d2);
        this.playSound(SoundEvents.ENTITY_SKELETON_SHOOT, 1.0F, 1.0F / (this.getRNG().nextFloat() * 0.4F + 0.8F));
        this.world.spawnEntity(entityarrow);

	}
	
    protected EntityLargeFireball getArrow(float p_190726_1_, double ax, double ay, double az)
    {
    	Vec3d view = this.getLookVec();
        EntityLargeFireball entitytippedarrow = new EntityLargeFireball(this.getEntityWorld(), this, ax * 10, ay * 10, az * 10);
        entitytippedarrow.setPosition(this.posX, this.posY, this.posZ);
        return entitytippedarrow;
    }
	
	static class AIRandomFly extends EntityAIBase {
		private final EntityCloudy parentEntity;

		public AIRandomFly(EntityCloudy cloudy) {
			this.parentEntity = cloudy;
			this.setMutexBits(1);
		}

		/**
		 * Returns whether the EntityAIBase should begin execution.
		 */
		public boolean shouldExecute() {
			EntityMoveHelper entitymovehelper = this.parentEntity.getMoveHelper();
			
			if (!entitymovehelper.isUpdating()) {
				return true;
			} else {
				double d0 = entitymovehelper.getX() - this.parentEntity.posX;
				double d1 = entitymovehelper.getY() - this.parentEntity.posY;
				double d2 = entitymovehelper.getZ() - this.parentEntity.posZ;
				double d3 = d0 * d0 + d1 * d1 + d2 * d2;
				return d3 < 1.0D || d3 > 3600.0D;
			}
		}

		/**
		 * Returns whether an in-progress EntityAIBase should continue executing
		 */
		public boolean shouldContinueExecuting() {
			return false;
		}

		/**
		 * Execute a one shot task or start executing a continuous task
		 */
		public void startExecuting() {
			Random random = this.parentEntity.getRNG();
			double d0 = this.parentEntity.posX + (double) ((random.nextFloat() * 2.0F - 1.0F) * 16.0F);
			double d1 = this.parentEntity.posY + (double) ((random.nextFloat() * 2.0F - 1.0F) * 16.0F);
			double d2 = this.parentEntity.posZ + (double) ((random.nextFloat() * 2.0F - 1.0F) * 16.0F);
			this.parentEntity.getMoveHelper().setMoveTo(d0, d1, d2, 1.0D);
		}
	}

	static class AILookAround extends EntityAIBase {
		private final EntityCloudy parentEntity;

		public AILookAround(EntityCloudy cloudy) {
			this.parentEntity = cloudy;
			this.setMutexBits(2);
		}

		/**
		 * Returns whether the EntityAIBase should begin execution.
		 */
		public boolean shouldExecute() {
			return true;
		}

		/**
		 * Keep ticking a continuous task that has already been started
		 */
		public void updateTask() {
			if (this.parentEntity.getAttackTarget() == null) {
				this.parentEntity.rotationYaw = -((float) MathHelper.atan2(this.parentEntity.motionX,
						this.parentEntity.motionZ)) * (180F / (float) Math.PI);
				this.parentEntity.renderYawOffset = this.parentEntity.rotationYaw;
			} else {
				EntityLivingBase entitylivingbase = this.parentEntity.getAttackTarget();
				double d0 = 64.0D;

				if (entitylivingbase.getDistanceSq(this.parentEntity) < 4096.0D) {
					double d1 = entitylivingbase.posX - this.parentEntity.posX;
					double d2 = entitylivingbase.posZ - this.parentEntity.posZ;
					this.parentEntity.rotationYaw = -((float) MathHelper.atan2(d1, d2)) * (180F / (float) Math.PI);
					this.parentEntity.renderYawOffset = this.parentEntity.rotationYaw;
				}
			}
		}
	}

	static class CloudyFlyMoveHelper extends EntityMoveHelper {
		private final EntityCloudy parentEntity;
		private int courseChangeCooldown;

		public CloudyFlyMoveHelper(EntityCloudy cloudy) {
			super(cloudy);
			this.parentEntity = cloudy;
			this.parentEntity.setNoGravity(true);
		}

		public void onUpdateMoveHelper() {
			this.parentEntity.onGround = false;
			this.parentEntity.fallDistance = 0;
			this.parentEntity.setNoGravity(true);
			if (this.action == EntityMoveHelper.Action.MOVE_TO) {
				double d0 = this.posX - this.parentEntity.posX;
				double d1 = this.posY - this.parentEntity.posY;
				double d2 = this.posZ - this.parentEntity.posZ;
				double d3 = d0 * d0 + d1 * d1 + d2 * d2;

				if (this.courseChangeCooldown-- <= 0) {
					this.courseChangeCooldown += this.parentEntity.getRNG().nextInt(5) + 2;
					d3 = (double) MathHelper.sqrt(d3);

					if (this.isNotColliding(this.posX, this.posY, this.posZ, d3)) {
						this.parentEntity.motionX += d0 / d3 * 0.1D;
						this.parentEntity.motionY += d1 / d3 * 0.1D;
						this.parentEntity.motionZ += d2 / d3 * 0.1D;
					} else {
						this.action = EntityMoveHelper.Action.WAIT;
					}
				}
			}
		}

		/**
		 * Checks if entity bounding box is not colliding with terrain
		 */
		private boolean isNotColliding(double x, double y, double z, double p_179926_7_) {
			double d0 = (x - this.parentEntity.posX) / p_179926_7_;
			double d1 = (y - this.parentEntity.posY) / p_179926_7_;
			double d2 = (z - this.parentEntity.posZ) / p_179926_7_;
			AxisAlignedBB axisalignedbb = this.parentEntity.getEntityBoundingBox();

			for (int i = 1; (double) i < p_179926_7_; ++i) {
				axisalignedbb = axisalignedbb.offset(d0, d1, d2);

				if (!this.parentEntity.world.getCollisionBoxes(this.parentEntity, axisalignedbb).isEmpty()) {
					return false;
				}
			}

			return true;
		}
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
