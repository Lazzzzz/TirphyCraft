package com.laz.tirphycraft.entity.entityClass.passif;

import javax.annotation.Nullable;

import com.laz.tirphycraft.util.handlers.ConfigHandler;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

public class EntityMontauk extends EntityCow {

	public EntityMontauk(World worldIn) {

		super(worldIn);
		this.setSize(0.8F, 1.5F);
	}

	@Override
	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(40.0D);
		this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.1D);
	}

	@Override
	public float getEyeHeight() {
		return 1F;
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
		if (!this.isBeingRidden()) {
			this.mountTo(player);
			Minecraft.getMinecraft().gameSettings.thirdPersonView = 1;
		}
		return true;
	}
	
	public boolean canBeSteered() {
		Entity entity = this.getControllingPassenger();
		return entity instanceof EntityLivingBase;
	}
	
	@Nullable
	public Entity getControllingPassenger() {
		return this.getPassengers().isEmpty() ? null : (Entity)this.getPassengers().get(0);
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
			
			EntityLivingBase entitylivingbase = (EntityLivingBase)this.getControllingPassenger();
			entitylivingbase.onGround = true;
			this.rotationYaw = entitylivingbase.rotationYaw;
			this.prevRotationYaw = this.rotationYaw;
			this.rotationPitch = entitylivingbase.rotationPitch * 0.5f;
			this.setRotation(this.rotationYaw, this.rotationPitch);
			this.renderYawOffset = this.rotationYaw;
			this.rotationYawHead = this.renderYawOffset;
			this.moveVertical = entitylivingbase.moveVertical;
			strafe = entitylivingbase.moveStrafing * 0.5f;
			forward = entitylivingbase.moveForward * 0.4f;
			vertical = entitylivingbase.moveVertical;
			this.stepHeight = 2f;
			this.fallDistance = 0;
			
			if (forward <= 0.0f) {
				forward *= 0.001f;
			}
			
			this.jumpMovementFactor = this.getAIMoveSpeed() * 0.4f;
			
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

	protected boolean isValidLightLevel()
	{
		 return true; //don't care about the light level to spawn
	}
	@Override
	public boolean getCanSpawnHere() {
		return this.world.loadedEntityList.size() < ConfigHandler.MAX_PASSIF_CREATURE;

	}

	
	
}
