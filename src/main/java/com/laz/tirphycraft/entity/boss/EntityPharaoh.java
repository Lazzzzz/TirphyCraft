package com.laz.tirphycraft.entity.boss;

import java.util.Random;

import com.laz.tirphycraft.entity.aggressive.EntityMummy;
import com.laz.tirphycraft.init.ItemInit;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
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
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.BossInfo;
import net.minecraft.world.BossInfoServer;
import net.minecraft.world.World;

public class EntityPharaoh extends EntityMob {

	boolean spawning = false;
	int timeSpawn = 20;
	int timer = this.timeSpawn;
	int mobCounter = 5;

	public EntityPharaoh(World worldIn) {

		super(worldIn);
		this.setSize(1.1F, 2.6F);
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
			BossInfo.Color.YELLOW, BossInfo.Overlay.PROGRESS));

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
		if (!this.world.isRemote)
			this.spawnMummy();

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
	public boolean hitByEntity(Entity entityIn) {
		Random random = new Random();
		int r = random.nextInt(((int) this.getHealth() / 10) + 1);
		if (r == 1) {
			this.spawning = true;
		}
		if (this.world.isRemote) {
			int r2 = random.nextInt(((int) this.getHealth() / 20) + 5);
			if (r2 == 2) {
				this.expulse(entityIn);
			}
		}

		return super.hitByEntity(entityIn);
	}

	@Override
	public boolean attackEntityAsMob(Entity entityIn) {
		((EntityLivingBase) entityIn).addPotionEffect(new PotionEffect(MobEffects.BLINDNESS, 20 * 2, 1, false, false));
		return super.attackEntityAsMob(entityIn);
	}

	protected boolean isValidLightLevel() {
		return true; // don't care about the light level to spawn
	}

	private void spawnMummy() {
		if (this.spawning) {
			this.motionX = 0;
			this.motionY = 0;
			this.motionZ = 0;

			this.timer -= 1;
			if (this.timer == 0) {
				this.setHealth(this.getHealth() + 10);
				this.timer = this.timeSpawn;
				this.mobCounter -= 1;
				if (this.mobCounter > 0) {
					Vec3d view = this.getLookVec();
					EntityMummy m = new EntityMummy(this.world);
					m.setPosition(this.posX, this.posY, this.posZ);
					m.motionX = view.x;
					m.motionY = view.y;
					m.motionZ = view.z;

					m.setAttackTarget(this.getAttackTarget());
					this.world.spawnEntity(m);
				} else {
					this.mobCounter = 5;
					this.spawning = false;
				}
			}
		}
	}

	private void expulse(Entity entityIn) {
		Vec3d view = this.getLookVec();
		entityIn.onGround = false;
		entityIn.motionX = view.x * 2;
		entityIn.motionY = 0.5;
		entityIn.motionZ = view.z * 2;

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
