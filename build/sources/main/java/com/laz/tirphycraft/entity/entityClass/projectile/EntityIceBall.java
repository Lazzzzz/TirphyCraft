package com.laz.tirphycraft.entity.entityClass.projectile;

import com.laz.tirphycraft.init.PotionInit;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityFlying;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.init.Blocks;
import net.minecraft.init.SoundEvents;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class EntityIceBall extends EntityFlying {

	public Entity shootingEntity;

	public double smotionX;
	public double smotionY;
	public double smotionZ;

	public int life;
	public int lifeSpan;
	public double speed;

	public boolean smacked;

	public EntityIceBall(World var1) {

		super(var1);
		this.lifeSpan = this.rand.nextInt(300) + 200;
		this.life = this.lifeSpan;
		this.setSize(0.5F, 0.5F);
		this.isImmuneToFire = true;
		this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(20.0D);
		this.speed = 0.3;

	}

	public void setLife(int life) {
		this.life = life;
	}

	public void setVel(double x, double y, double z) {
		this.smotionX = x;
		this.smotionY = y;
		this.smotionZ = z;
	}

	public void onUpdate() {
		super.onUpdate();

		--this.life;

		if (this.life <= 0) {
			this.splode();
			this.isDead = true;
		}

	}

	public void splode() {
		this.world.playSound(null, this.posX, this.posY, this.posZ, SoundEvents.ENTITY_GENERIC_EXPLODE,
				SoundCategory.HOSTILE, 2.0F, this.rand.nextFloat() - this.rand.nextFloat() * 0.2F + 1.2F);

		for (int var1 = 0; var1 < 40; ++var1) {
			double var2 = (double) ((this.rand.nextFloat() - 0.5F) * 0.5F);
			double var4 = (double) ((this.rand.nextFloat() - 0.5F) * 0.5F);
			double var6 = (double) ((this.rand.nextFloat() - 0.5F) * 0.5F);

			this.world.spawnParticle(EnumParticleTypes.CRIT_MAGIC, this.posX, this.posY, this.posZ, var2, var4, var6);
		}
	}

	public void updateAITasks() {
		super.updateAITasks();
		this.motionX = this.smotionX;
		this.motionY = this.smotionY;
		this.motionZ = this.smotionZ;

		if (this.collided) {
			int var1 = MathHelper.floor(this.posX);
			int var2 = MathHelper.floor(this.getEntityBoundingBox().minY);
			int var3 = MathHelper.floor(this.posZ);

			if (this.smotionX > 0.0D
					&& this.world.getBlockState(new BlockPos(var1 + 1, var2, var3)).getBlock() != Blocks.AIR) {
				this.motionX = this.smotionX = -this.smotionX;
			} else if (this.smotionX < 0.0D
					&& this.world.getBlockState(new BlockPos(var1 - 1, var2, var3)).getBlock() != Blocks.AIR) {
				this.motionX = this.smotionX = -this.smotionX;
			}

			if (this.smotionY > 0.0D
					&& this.world.getBlockState(new BlockPos(var1, var2 + 1, var3)).getBlock() != Blocks.AIR) {
				this.motionY = this.smotionY = -this.smotionY;
			} else if (this.smotionY < 0.0D
					&& this.world.getBlockState(new BlockPos(var1, var2 - 1, var3)).getBlock() != Blocks.AIR) {
				this.motionY = this.smotionY = -this.smotionY;
			}

			if (this.smotionZ > 0.0D
					&& this.world.getBlockState(new BlockPos(var1, var2, var3 + 1)).getBlock() != Blocks.AIR) {
				this.motionZ = this.smotionZ = -this.smotionZ;
			} else if (this.smotionZ < 0.0D
					&& this.world.getBlockState(new BlockPos(var1, var2, var3 - 1)).getBlock() != Blocks.AIR) {
				this.motionZ = this.smotionZ = -this.smotionZ;
			}
		}
	}

	@Override
	public void writeEntityToNBT(NBTTagCompound var1) {
		super.writeEntityToNBT(var1);
		var1.setShort("life", (short) this.life);
		var1.setTag("selfMotion", this.newDoubleNBTList(new double[] { this.smotionX, this.smotionY, this.smotionZ }));
		var1.setBoolean("smacked", this.smacked);
	}

	@Override
	public void readEntityFromNBT(NBTTagCompound var1) {
		super.readEntityFromNBT(var1);
		this.life = var1.getShort("life");
		this.smacked = var1.getBoolean("smacked");
		NBTTagList var2 = var1.getTagList("selfMotion", 10);
		this.smotionX = var2.getDoubleAt(0);
		this.smotionY = var2.getDoubleAt(1);
		this.smotionZ = var2.getDoubleAt(2);
	}

	@Override
	public void applyEntityCollision(Entity var1) {
		super.applyEntityCollision(var1);

		((EntityLivingBase) var1).addPotionEffect(new PotionEffect(PotionInit.FREEZE, 20 * 10, 0, false, false));
		this.splode();
		this.isDead = true;

	}

	@Override
	public boolean attackEntityFrom(DamageSource var1, float var2) {
		if (var1.getImmediateSource() != null) {
			Vec3d var3 = var1.getImmediateSource().getLookVec();

			if (var3 != null) {
				this.smotionX = var3.x * this.speed;
				this.smotionY = var3.y * this.speed;
				this.smotionZ = var3.z * this.speed;
			}

			this.shootingEntity = var1.getTrueSource();
			this.smacked = true;
			return true;
		} else {
			return false;
		}
	}

}
