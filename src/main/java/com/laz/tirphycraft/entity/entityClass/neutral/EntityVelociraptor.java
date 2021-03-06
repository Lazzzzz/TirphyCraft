package com.laz.tirphycraft.entity.entityClass.neutral;

import javax.annotation.Nullable;

import com.laz.tirphycraft.init.ItemInit;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackMelee;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMoveTowardsRestriction;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAITempt;
import net.minecraft.entity.ai.EntityAIWanderAvoidWater;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

public class EntityVelociraptor extends EntityMob {

	private static final DataParameter<Integer> VELOCIRAPTOR_VARIANT = EntityDataManager
			.<Integer>createKey(EntityVelociraptor.class, DataSerializers.VARINT);
	public boolean tameable;
	public boolean haveSaddle;
	private EntityAINearestAttackableTarget taskss;

	public EntityVelociraptor(World worldIn) {

		super(worldIn);
		this.setSize(1.8F, 2F);
		this.tameable = false;
		this.haveSaddle = false;
	}

	public int getVariant() {

		return MathHelper.clamp(((Integer) this.dataManager.get(VELOCIRAPTOR_VARIANT)).intValue(), 0, 4);
	}

	public void setVariant(int p_191997_1_) {
		this.dataManager.set(VELOCIRAPTOR_VARIANT, Integer.valueOf(p_191997_1_));
	}

	protected void entityInit() {
		super.entityInit();
		this.dataManager.register(VELOCIRAPTOR_VARIANT, Integer.valueOf(0));
	}

	protected void initEntityAI() {
		this.tasks.addTask(0, new EntityAISwimming(this));
		this.tasks.addTask(2, new EntityAIAttackMelee(this, 1.2D, false));
		this.tasks.addTask(5, new EntityAIMoveTowardsRestriction(this, 1.0D));
		this.tasks.addTask(7, new EntityAIWanderAvoidWater(this, 1.0D));
		this.tasks.addTask(8, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
		this.tasks.addTask(13, new EntityAITempt(this, 1.25D, Items.BEEF, false));
		this.tasks.addTask(8, new EntityAILookIdle(this));
		this.applyEntityAI();
	}

	protected void applyEntityAI() {
		this.taskss = new EntityAINearestAttackableTarget(this, EntityPlayer.class, true);
		this.targetTasks.addTask(2, this.taskss);
		this.targetTasks.addTask(3, new EntityAINearestAttackableTarget(this, EntityAnimal.class, true));
	}

	@Override
	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(100.0D);
		this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.28D);
		this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(9.0D);
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
	public void onLivingUpdate() {
		super.onLivingUpdate();
	}

	@Override
	public boolean processInteract(EntityPlayer player, EnumHand hand) {
		if (!this.world.isRemote) {
			this.feed(player);
			this.saddleIt(player);
			this.rideIt(player);

		}
		return true;

	}

	protected boolean isValidLightLevel() {
		return true;
	}

	protected boolean shouldBurnInDay() {
		return false;
	}

	@Override
	public boolean getCanSpawnHere() {
		return true;
	}

	public void writeEntityToNBT(NBTTagCompound compound) {
		super.writeEntityToNBT(compound);
		compound.setBoolean("Tameable", this.tameable);
		compound.setBoolean("HaveSaddle", this.haveSaddle);
	}

	public void readEntityFromNBT(NBTTagCompound compound) {
		super.readEntityFromNBT(compound);
		this.tameable = compound.getBoolean("Tameable");
		this.haveSaddle = compound.getBoolean("HaveSaddle");
		if (this.tameable) {
			this.targetTasks.removeTask(this.taskss);
		}
		if (this.haveSaddle) {
			this.setVariant(1);
		}

	}

	public boolean canBeSteered() {
		Entity entity = this.getControllingPassenger();
		return entity instanceof EntityLivingBase;
	}

	@Nullable
	public Entity getControllingPassenger() {
		return this.getPassengers().isEmpty() ? null : (Entity) this.getPassengers().get(0);
	}

	private void mountTo(EntityPlayer player) {
		player.rotationYaw = this.rotationYaw;
		player.rotationPitch = this.rotationPitch;

		if (!this.world.isRemote) {
			player.startRiding(this);
		}
	}

	@Override
	public void travel(float strafe, float vertical, float forward) {
		if (this.isBeingRidden() && this.canBeSteered()) {

			EntityLivingBase entitylivingbase = (EntityLivingBase) this.getControllingPassenger();
			entitylivingbase.onGround = true;
			this.rotationYaw = entitylivingbase.rotationYaw;
			this.prevRotationYaw = this.rotationYaw;
			this.rotationPitch = entitylivingbase.rotationPitch * 0.5f;
			this.setRotation(this.rotationYaw, this.rotationPitch);
			this.renderYawOffset = this.rotationYaw;
			this.rotationYawHead = this.renderYawOffset;
			this.moveVertical = entitylivingbase.moveVertical;
			strafe = entitylivingbase.moveStrafing * 0.5f;
			forward = entitylivingbase.moveForward * 0.9f;
			vertical = entitylivingbase.moveVertical;
			this.stepHeight = 2f;
			this.fallDistance = 0;

			if (forward <= 0.0f) {
				forward *= 0.001f;
			}

			this.jumpMovementFactor = this.getAIMoveSpeed() * 0.1f;

			if (this.canPassengerSteer()) {
				this.setAIMoveSpeed(0.5f);
				super.travel(strafe, vertical, forward);
			} else if (entitylivingbase instanceof EntityPlayer) {
				this.motionX = 0.0d;
				this.motionZ = 0.0d;
			}

			this.prevLimbSwingAmount = this.limbSwingAmount;
			double d1 = this.posX - this.prevPosX;
			double d2 = this.posZ - this.prevPosZ;
			float f2 = MathHelper.sqrt(d1 * d1 + d2 * d2) * 4.0f;

			if (f2 > 1.0f) {
				f2 = 1.0f;
			}

			this.limbSwingAmount += (f2 - this.limbSwingAmount) * 0.4f;
			this.limbSwing += this.limbSwingAmount;
		} else {
			this.jumpMovementFactor = 0.2f;
			super.travel(strafe, vertical, forward);

		}
	}

	public void feed(EntityPlayer player) {
		if (player.inventory.getCurrentItem() != null) {
			if (player.inventory.getCurrentItem().getItem() == ItemInit.FROZEN_BOARCHOP_RAW || player.inventory.getCurrentItem().getItem() == ItemInit.FROZEN_BUFFALO_RAW) {
				if (!this.tameable) {
					if (this.rand.nextInt(20) == 0) {
						this.tameable = true;
						this.targetTasks.removeTask(this.taskss);
						this.setVariant(1);

					}
				} else {
					this.heal(10);
				}

				player.inventory.getCurrentItem().shrink(1);
			}
		}
	}

	public void saddleIt(EntityPlayer player) {
		if (player.inventory.getCurrentItem().getItem() == Items.SADDLE) {
			if (this.tameable) {
				this.haveSaddle = true;
				this.setVariant(2);
				player.inventory.getCurrentItem().shrink(1);
			}
		}
	}

	public void rideIt(EntityPlayer player) {
		if (player.inventory.getCurrentItem().getItem() == Items.AIR) {
			if (player.isSneaking() && this.tameable && this.haveSaddle) {
				this.world.spawnEntity(
						new EntityItem(this.world, this.posX, this.posY, this.posZ, new ItemStack(Items.SADDLE, 1)));
				this.setVariant(1);
				this.haveSaddle = false;
			}

			else if (!this.isBeingRidden() && this.tameable && this.haveSaddle) {
				this.mountTo(player);
			}

		}
	}

}
