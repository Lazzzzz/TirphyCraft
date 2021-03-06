package com.laz.tirphycraft.entity.entityClass.aggressive;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackMelee;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAIWanderAvoidWater;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class EntityBreaker extends EntityMob {

	private EntityLivingBase attackTarget;
	private int cooldown = 80;
	public boolean doingBreak = false;

	public EntityBreaker(World worldIn) {

		super(worldIn);
		this.setSize(1F, 1.5F);
		this.doingBreak = false;

	}

	protected void initEntityAI() {
		this.tasks.addTask(2, new EntityAIWanderAvoidWater(this, 1.0D, 1.0000001E-5F));
		this.tasks.addTask(3, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0F));
		this.tasks.addTask(4, new EntityAILookIdle(this));
		this.tasks.addTask(2, new EntityAIAttackMelee(this, 1.2D, true));
		this.targetTasks.addTask(8, new EntityAINearestAttackableTarget(this, EntityPlayer.class, true));
	}

	@Override
	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(20.0D);
		this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.20000000298023224D);
		this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(10);
	}

	@Override
	public float getEyeHeight() {
		return 0.9F;
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
	public void onUpdate() {
		breakAi();

		super.onUpdate();

	}

	private void breakAi() {

		if (this.motionX == 0 && this.motionZ == 0) {
			BlockPos pos = this.getPosition();

			for (int i = -2; i < 3; i++) {
				for (int j = -2; j < 3; j++) {
					for (int k = 0; k < 2; k++) {

						if (this.rand.nextInt(30) == 0) {
							if (this.world.getBlockState(pos.add(i, k, j)) != Blocks.AIR.getDefaultState()
									&& this.world.getBlockState(pos.add(i, k, j)).getBlockHardness(this.world,
											pos.add(i, k, j)) > 0) {
								this.world.destroyBlock(pos.add(i, k, j), true);
								this.performHurtAnimation();

							}
						}
					}

				}
			}
		}

	}

	@Override
	public boolean processInteract(EntityPlayer player, EnumHand hand) {
		return false;
	}

	@Override
	public boolean attackEntityAsMob(Entity entityIn) {
		return super.attackEntityAsMob(entityIn);
	}

	protected boolean isValidLightLevel() {
		return true;
	}

}
