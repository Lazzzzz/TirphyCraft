package com.laz.tirphycraft.entity.entityClass.boss;

import java.util.List;

import com.laz.tirphycraft.init.ItemInit;
import com.laz.tirphycraft.util.Reference;
import com.laz.tirphycraft.util.interfaces.ParticleTypes;

import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackMelee;
import net.minecraft.entity.ai.EntityAIAvoidEntity;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMoveTowardsRestriction;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWanderAvoidWater;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.BossInfo;
import net.minecraft.world.BossInfoServer;
import net.minecraft.world.World;

public class EntityPrimaryStrength extends EntityMob {

	private int range = 30;
	EntityPrimaryAttack entityTarget;
	int cooldown = 0;

	public EntityPrimaryStrength(World worldIn) {

		super(worldIn);
		this.setSize(1.2F, 3F);
		this.isImmuneToFire = true;

	}

	protected void initEntityAI() {
		this.tasks.addTask(0, new EntityAISwimming(this));
		this.tasks.addTask(2, new EntityAIAttackMelee(this, 1.2D, false));
		this.tasks.addTask(5, new EntityAIMoveTowardsRestriction(this, 1.0D));
		this.tasks.addTask(7, new EntityAIWanderAvoidWater(this, 1.0D));
		this.tasks.addTask(20, new EntityAIWatchClosest(this, EntityPrimaryAttack.class, 30.0F));
		this.tasks.addTask(8, new EntityAILookIdle(this));
		this.tasks.addTask(15,
				new EntityAIAvoidEntity(this, EntityPlayer.class, 20, 2.25000000298023224D, 2.25000000298023224D));
		this.applyEntityAI();
	}

	protected void applyEntityAI() {
	}

	@Override
	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(500.0D);
		this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.20000000298023224D);
		this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(30.0D);
		this.getEntityAttribute(SharedMonsterAttributes.ARMOR_TOUGHNESS).setBaseValue(20.0D);
		this.getEntityAttribute(SharedMonsterAttributes.KNOCKBACK_RESISTANCE).setBaseValue(0.9D);
	}

	@Override
	public float getEyeHeight() {
		return 2.8F;
	}

	@Override
	public boolean isNonBoss() {
		return false;
	}

	private final BossInfoServer bossInfo = (BossInfoServer) (new BossInfoServer(this.getDisplayName(),
			BossInfo.Color.GREEN, BossInfo.Overlay.PROGRESS));

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
		if (this.cooldown > 0)
			this.cooldown -= 1;
		this.getAndHealTarget();
		this.beam();
		super.onLivingUpdate();
	}

	@Override
	public boolean isImmuneToExplosions() {
		return true;
	}

	@Override
	public boolean hitByEntity(Entity entityIn) {
		if (this.entityTarget != null) {
			this.entityTarget.strength_is_attack = true;

		}

		this.cooldown = 10 * 20;

		return super.hitByEntity(entityIn);
	}

	@Override
	public boolean attackEntityAsMob(Entity entityIn) {
		return super.attackEntityAsMob(entityIn);
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

	public void getAndHealTarget() {
		AxisAlignedBB box = new AxisAlignedBB(this.posX - this.range, this.posY - this.range, this.posZ - this.range,
				this.posX + this.range, this.posY + this.range, this.posZ + this.range);

		List list = this.world.getEntitiesWithinAABB(EntityPrimaryAttack.class, box);
		if (this.entityTarget != null)
			entityTarget.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(30.0D);
		this.entityTarget = null;
		if (!list.isEmpty()) {

			for (int i = 0; i <= list.size() - 1; i++) {
				EntityPrimaryAttack target = (EntityPrimaryAttack) list.get(i);
				target.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(40.0D);
				this.entityTarget = target;

			}

		}
	}

	public void beam() {
		if (this.entityTarget != null) {

			Vec3d dir = new Vec3d((this.posX - this.entityTarget.posX) / 10,
					(((this.posY + (this.height / 2)) - (this.entityTarget.posY + (this.entityTarget.height / 2)))
							/ 10),
					((this.posZ - this.entityTarget.posZ)) / 10);

			double x = this.posX + ((this.rand.nextDouble() - 0.5D) * this.width) / 2;
			double y = this.posY + ((this.rand.nextDouble() + 2D) * this.width) / 2;
			double z = this.posZ + ((this.rand.nextDouble() - 0.5D) * this.width) / 2;

			Reference.PROXY.spawnParticle(this.world, ParticleTypes.GLINT_BOSS_GREEN, x, y, z, -dir.x, -dir.y, -dir.z);

		}

	}

}
