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
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.monster.EntityPigZombie;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.BossInfo;
import net.minecraft.world.BossInfoServer;
import net.minecraft.world.World;

public class EntityPoseidon extends EntityMob {

	boolean invincible = false;
	int thunderCounter = 0;
	int maxThunder = 10;
	int timer = 0;
	boolean thunderOn = false;
	Random ra = new Random();

	public EntityPoseidon(World worldIn) {

		super(worldIn);
		this.setSize(1F, 3F);
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
		this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.0D);
		this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(10.0D);
		this.getEntityAttribute(SharedMonsterAttributes.ARMOR_TOUGHNESS).setBaseValue(10.0D);
		this.getEntityAttribute(SharedMonsterAttributes.KNOCKBACK_RESISTANCE).setBaseValue(1.0D);
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
			BossInfo.Color.BLUE, BossInfo.Overlay.PROGRESS));

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
	public void onLivingUpdate() {
		if (this.getAttackTarget() != null) {
			if (this.thunderOn) {
				this.thunderRain(this.getAttackTarget());
			}
			int i = ra.nextInt(50);
			if (i <= 4)
				this.teleport(this.getAttackTarget());

			if (i == 5)
				this.thunderRain(this.getAttackTarget());
		}
		super.onLivingUpdate();
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
	public boolean isEntityInvulnerable(DamageSource source) {
		return this.invincible;
	}

	@Override
	public boolean hitByEntity(Entity entityIn) {
		int i = ra.nextInt(3);
		if (i == 0)
			this.thunderOn = true;

		return super.hitByEntity(entityIn);
	}

	@Override
	public boolean attackEntityAsMob(Entity entityIn) {
		return super.attackEntityAsMob(entityIn);
	}

	protected boolean isValidLightLevel() {
		return true; // don't care about the light level to spawn
	}

	@Override
	public void onDeath(DamageSource cause) {
		if (!this.world.isRemote) {
			this.world.spawnEntity(
					new EntityItem(this.world, this.posX, this.posY, this.posZ, new ItemStack(ItemInit.COINS, 20)));
			this.world.spawnEntity(new EntityItem(this.world, this.posX, this.posY, this.posZ,
					new ItemStack(ItemInit.POSEIDON_EYE, 1)));
			this.world.spawnEntity(new EntityItem(this.world, this.posX, this.posY, this.posZ,
					new ItemStack(ItemInit.FRAGMENT_BLUE, 1)));
		}
		super.onDeath(cause);
	}

	@Override
	public boolean canBeHitWithPotion() {
		return false;
	}

	public void teleport(Entity entityIn) {
		double x = entityIn.posX + ra.nextInt(4) - 2;
		double y = entityIn.posY;
		double z = entityIn.posZ + ra.nextInt(4) - 2;

		this.setPosition(x, y, z);
	}

	private void thunderRain(Entity entityIn) {
		this.expulse(entityIn);

		this.thunderCounter -= 1;
		if (this.thunderCounter > 0) {
			double x = entityIn.posX + entityIn.motionX + ra.nextInt(2) - 1;
			double y = entityIn.posY + entityIn.motionY;
			double z = entityIn.posZ + entityIn.motionZ + ra.nextInt(2) - 1;

			EntityLightningBolt m = new EntityLightningBolt(this.world, x, y, z, false);

			this.world.addWeatherEffect(m);

		} else {
			this.thunderCounter = this.maxThunder + ra.nextInt(10);
			this.thunderOn = false;
			this.setHealth(this.getHealth() + 1);
		}
	}

	private void expulse(Entity entityIn) {
		Vec3d view = entityIn.getLookVec();
		entityIn.onGround = false;
		entityIn.motionX = -view.x;
		entityIn.motionY = 0.5;
		entityIn.motionZ = -view.z;

	}

	@Override
	public void onStruckByLightning(EntityLightningBolt lightningBolt) {
	}

}
