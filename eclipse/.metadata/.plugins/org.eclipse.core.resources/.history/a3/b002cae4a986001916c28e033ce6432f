package com.laz.tirphycraft.entity.boss;

import java.util.Random;

import com.laz.tirphycraft.init.ItemInit;
import com.laz.tirphycraft.util.handlers.LootTableHandler;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAreaEffectCloud;
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
import net.minecraft.world.BossInfo;
import net.minecraft.world.BossInfoServer;
import net.minecraft.world.World;

public class EntityQueenCreeper extends EntityMob {
	public EntityQueenCreeper(World worldIn) {

		super(worldIn);
		this.setSize(1.2F, 2F);
		this.stepHeight = 2f;
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
			BossInfo.Color.GREEN, BossInfo.Overlay.PROGRESS));

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
	protected boolean canDespawn() {
		return false;
	}

	@Override
	public void onUpdate() {
		super.onUpdate();
		this.bossInfo.setPercent(this.getHealth() / this.getMaxHealth());

	}

	@Override
	protected ResourceLocation getLootTable() {
		return LootTableHandler.QUEEN_CREEPER_LOOT;
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
		if (!this.getEntityWorld().isRemote) {
			int rand = new Random().nextInt(4);
			if (rand == 1) {
				double x = entityIn.posX;
				double y = entityIn.posY;
				double z = entityIn.posZ;

				EntityAreaEffectCloud cloud = new EntityAreaEffectCloud(this.getEntityWorld(), x, y, z);
				cloud.setOwner(this);
				cloud.setRadius(1.0F);
				cloud.setDuration(3 * 20);
				cloud.setRadiusPerTick((1.0F - cloud.getRadius()) / (float) cloud.getDuration());
				cloud.setColor(0x15680a);
				cloud.addEffect(new PotionEffect(MobEffects.POISON, 200, 1));
				cloud.addEffect(new PotionEffect(MobEffects.INSTANT_DAMAGE, 200, 0));

				this.getEntityWorld().spawnEntity(cloud);

			}
		}
		return super.hitByEntity(entityIn);
	}

	@Override
	public boolean attackEntityAsMob(Entity entityIn) {
		double x = ((EntityLivingBase) entityIn).posX;
		double y = ((EntityLivingBase) entityIn).posY;
		double z = ((EntityLivingBase) entityIn).posZ;
		this.getEntityWorld().createExplosion(this, x, y + 2, z, 1F, false);
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
					new ItemStack(ItemInit.QUEEN_HEART, 1)));
			this.world.spawnEntity(new EntityItem(this.world, this.posX, this.posY, this.posZ,
					new ItemStack(ItemInit.EXPLOSION_SWORD, 1)));
			this.world.spawnEntity(new EntityItem(this.world, this.posX, this.posY, this.posZ,
					new ItemStack(ItemInit.FRAGMENT_GREEN, 1)));
		}
		super.onDeath(cause);
	}

	@Override
	public boolean canBeHitWithPotion() {
		return false;
	}

}
