package com.laz.tirphycraft.entity.boss;

import java.util.List;
import java.util.Random;

import com.laz.tirphycraft.entity.aggressive.EntitySkull;
import com.laz.tirphycraft.init.ItemInit;
import com.laz.tirphycraft.util.Reference;
import com.laz.tirphycraft.util.interfaces.ParticleTypes;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackMelee;
import net.minecraft.entity.ai.EntityAIFollow;
import net.minecraft.entity.ai.EntityAIFollowParent;
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
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.BossInfo;
import net.minecraft.world.BossInfoServer;
import net.minecraft.world.World;

public class EntityPrimaryHeal extends EntityMob {

	private int range = 30;
	EntityPrimaryAttack entityTarget;

	public EntityPrimaryHeal(World worldIn) {

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
			BossInfo.Color.PURPLE, BossInfo.Overlay.PROGRESS));

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
		this.entityTarget = null;
		if (!list.isEmpty()) {

			for (int i = 0; i <= list.size() - 1; i++) {
				EntityPrimaryAttack target = (EntityPrimaryAttack) list.get(i);
				
				this.entityTarget = target;

			}

		}
	}

	public void beam() {
		if (this.entityTarget != null) {

			Vec3d dir = new Vec3d((this.posX - this.entityTarget.posX) / 120,
					(((this.posY + (this.height / 2)) - (this.entityTarget.posY + (this.entityTarget.height / 2))))
							/ 120,
					((this.posZ - this.entityTarget.posZ)) / 120);

			if (this.rand.nextBoolean()) {

				double x = this.posX + ((this.rand.nextDouble() - 0.5D) * this.width) / 2;
				double y = this.posY + ((this.rand.nextDouble() + 2D) * this.width) / 2;
				double z = this.posZ + ((this.rand.nextDouble() - 0.5D) * this.width) / 2;

				Reference.PROXY.spawnParticle(this.world, ParticleTypes.GLINT_PURPLE, x, y, z, -dir.x, -dir.y, -dir.z);
			}
		}

	}

}
