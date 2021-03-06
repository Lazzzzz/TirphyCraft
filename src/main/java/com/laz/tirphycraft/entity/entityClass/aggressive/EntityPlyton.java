package com.laz.tirphycraft.entity.entityClass.aggressive;

import java.util.List;

import com.laz.tirphycraft.entity.entityClass.projectile.EntityIceBall;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class EntityPlyton extends EntityMob {

	private final int maxInterval;
	private final int minInterval;
	private final double speedFly;
	private EntityPlayer target = null;

	public EntityPlyton(World worldIn) {

		super(worldIn);
		this.setSize(5F, 1F);
		this.isImmuneToFire = true;
		this.maxInterval = this.rand.nextInt(30) + 180;
		this.minInterval = this.rand.nextInt(30) + 150;
		this.speedFly = this.rand.nextDouble();

	}

	@Override
	protected void initEntityAI() {
		this.tasks.addTask(1, new EntityAISwimming(this));
		this.tasks.addTask(2, new EntityAIWander(this, 1.0D));
		this.tasks.addTask(5, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
		this.tasks.addTask(9, new EntityAILookIdle(this));
		this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, false));
		this.targetTasks.addTask(20,
				new EntityAINearestAttackableTarget(this, EntityPlayer.class, 0, true, false, null));
	}

	@Override
	public boolean hasNoGravity() {
		return true;
	}

	@Override
	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(80.0D);
		this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0D);
		this.getEntityAttribute(SharedMonsterAttributes.KNOCKBACK_RESISTANCE).setBaseValue(1.0D);
		this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(4.0D);
	}

	@Override
	public void onLivingUpdate() {
		this.snipePlayer();
		this.moveHelper();
		this.shootThis();
		super.onLivingUpdate();
	}

	@Override
	public boolean getCanSpawnHere() {
		if (this.posY < 100)
			return false;
		int i = this.world.countEntities(EntityPlyton.class);
		return i < 5;
	}

	@Override
	protected boolean canDespawn() {
		return true;
	}

	private void moveHelper() {

		this.motionX = this.getLookVec().x * this.speedFly;
		this.motionZ = this.getLookVec().z * this.speedFly;

		this.rotationPitch += this.rand.nextFloat();
		this.rotationYaw += this.rand.nextFloat();

		if (this.world.getWorldTime() % 500 == 0) {

			this.motionY = (this.rand.nextDouble() * 2) - 1;

			if (this.posY > this.maxInterval)
				this.motionY = -0.5f;
			else if (this.posY < this.minInterval)
				this.motionY = 0.5f;

		}
	}

	private void snipePlayer() {
		AxisAlignedBB box = new AxisAlignedBB(this.posX - 75, this.posY - 75, this.posZ - 75, this.posX + 75,
				this.posY + 75, this.posZ + 75);

		List list = this.world.getEntitiesWithinAABB(EntityPlayer.class, box);
		if (list.size() != 0)
			this.target = ((EntityPlayer) list.get(0));
		else
			this.target = null;
	}

	private void shootThis() {
		if (this.target != null) {
			if (!this.world.isRemote) {
				if (this.rand.nextInt(150) == 0) {
					Vec3d dir = new Vec3d((this.target.posX - this.posX) / 50, (this.target.posY - this.posY) / 50,
							(this.target.posZ - this.posZ) / 50);
					
					EntityIceBall e = new EntityIceBall(this.world);
					e.setLife(600);
					e.setPosition(this.posX + dir.x * 4, this.posY + dir.y * 4,	this.posZ + dir.z * 4);
					e.setVel(dir.x / 2,dir.y / 2,dir.z / 2);
					this.world.spawnEntity(e);
				}
			}
		}
	}

}
