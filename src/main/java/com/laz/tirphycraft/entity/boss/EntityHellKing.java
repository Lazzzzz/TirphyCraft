package com.laz.tirphycraft.entity.boss;

import java.util.Random;

import com.laz.tirphycraft.init.ItemInit;

import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackMelee;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMoveThroughVillage;
import net.minecraft.entity.ai.EntityAIMoveTowardsRestriction;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWanderAvoidWater;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.monster.EntityPigZombie;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.entity.projectile.EntityLargeFireball;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.BossInfo;
import net.minecraft.world.BossInfoServer;
import net.minecraft.world.World;

public class EntityHellKing extends EntityMob {

	boolean spawning = false;
	int timeSpawn = 20 * 10;
	int timer = this.timeSpawn;
	int mobCounter = 5;
	boolean combo1 = false;

	public EntityHellKing(World worldIn) {

		super(worldIn);
		this.setSize(1F, 3.5F);
		this.isImmuneToFire = true;

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
		this.tasks.addTask(6, new EntityAIMoveThroughVillage(this, 1.0D, false));
		this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, true, new Class[] { EntityPigZombie.class }));
		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class, true));
	}

	@Override
	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(200.0D);
		this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.35D);
		this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(6.0D);
		this.getEntityAttribute(SharedMonsterAttributes.ARMOR_TOUGHNESS).setBaseValue(10.0D);
	}

	@Override
	public float getEyeHeight() {
		return 2F;
	}

	@Override
	public boolean isNonBoss() {
		return false;
	}

	private final BossInfoServer bossInfo = (BossInfoServer) (new BossInfoServer(this.getDisplayName(),
			BossInfo.Color.RED, BossInfo.Overlay.PROGRESS));

	@Override
	protected boolean canDespawn() {
		return false;
	}

	@Override
	public void addTrackingPlayer(EntityPlayerMP player) {
		super.addTrackingPlayer(player);
		this.bossInfo.addPlayer(player);
	}

	@Override
	public void removeTrackingPlayer(EntityPlayerMP player) {
		super.removeTrackingPlayer(player);
		this.bossInfo.removePlayer(player);
	}

	@Override
	public void onUpdate() {
		super.onUpdate();
		this.bossInfo.setPercent(this.getHealth() / this.getMaxHealth());

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

	@Override
	public boolean isImmuneToExplosions() {
		return true;
	}

	@Override
	public boolean hitByEntity(Entity entityIn) {
		Random random = new Random();
		int r = random.nextInt(((int) this.getHealth() / 10) + 1);
		if (r == 1) {
			this.shotFireball();
		}

		int r2 = random.nextInt(((int) this.getHealth() / 20) + 5);
		if (r2 == 2) {
			this.expulse(entityIn);

			int r3 = random.nextInt(3);
			if (r3 == 2)
				this.teleport(random);

		}
		return super.hitByEntity(entityIn);
	}

	@Override
	public boolean attackEntityAsMob(Entity entityIn) {

		return super.attackEntityAsMob(entityIn);
	}

	protected boolean isValidLightLevel() {
		return true; // don't care about the light level to spawn
	}

	private void expulse(Entity entityIn) {
		Vec3d view = this.getLookVec();
		entityIn.onGround = false;
		entityIn.motionX = view.x * 2;
		entityIn.motionY = 0.5;
		entityIn.motionZ = view.z * 2;

	}

	private void shotFireball() {
		this.setHealth(this.getHealth() + 30);
		EntityLargeFireball f1 = getFireBall(1, 0, 0);
		EntityLargeFireball f2 = getFireBall(0, 0, 1);
		EntityLargeFireball f3 = getFireBall(1, 0, 1);
		EntityLargeFireball f4 = getFireBall(-1, 0, 0);
		EntityLargeFireball f5 = getFireBall(0, 0, -1);
		EntityLargeFireball f6 = getFireBall(-1, 0, -1);
		EntityLargeFireball f7 = getFireBall(1, 0, -1);
		EntityLargeFireball f8 = getFireBall(-1, 0, 1);

		this.world.spawnEntity(f1);
		this.world.spawnEntity(f2);
		this.world.spawnEntity(f3);
		this.world.spawnEntity(f4);
		this.world.spawnEntity(f5);
		this.world.spawnEntity(f6);
		this.world.spawnEntity(f7);
		this.world.spawnEntity(f8);
	}

	protected EntityLargeFireball getFireBall(double ax, double ay, double az) {
		EntityLargeFireball entity = new EntityLargeFireball(this.world, this, 0, 0, 0);
		entity.motionX = 0;
		entity.motionY = 0;
		entity.motionZ = 0;

		entity.accelerationX = ax / 50;
		entity.accelerationY = 0;
		entity.accelerationZ = az / 50;
		entity.setPosition(this.posX + ax * 2, this.posY + 1.5, this.posZ + az * 2);
		return entity;

	}

	protected void teleport(Random rand) {
		if (!this.world.isRemote) {
			int x = rand.nextInt(20) - 10;
			int z = rand.nextInt(20) - 10;

			boolean canTeleport = true;

			for (int i = 0; i < 2; i++) {
				if (this.world.getBlockState(
						new BlockPos(this.posX + x, this.posY + i + 1, this.posZ + z)) != Blocks.AIR.getDefaultState())
					canTeleport = false;
			}
			System.out.println(canTeleport);

			if (canTeleport)
				this.setPosition(this.posX + x, this.posY, this.posZ + z);
		}
	}

	@Override
	public void onDeath(DamageSource cause) {
		if (!this.world.isRemote) {
				this.world.spawnEntity(
						new EntityItem(this.world, this.posX, this.posY, this.posZ, new ItemStack(ItemInit.COINS, 20)));
			}
		super.onDeath(cause);
	}
	@Override
	public boolean canBeHitWithPotion() {
		return false;
	}

}
