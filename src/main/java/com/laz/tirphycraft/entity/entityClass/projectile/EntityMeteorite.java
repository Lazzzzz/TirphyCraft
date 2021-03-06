package com.laz.tirphycraft.entity.entityClass.projectile;

import com.laz.tirphycraft.world.gen.generators.laputa.WorldGenMeteorite;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class EntityMeteorite extends EntityMob {
	double smotionX;
	double smotionY;
	double smotionZ;
	
	public EntityMeteorite(World var1) {
		super(var1);
		this.setSize(7F, 7F);
		this.isImmuneToFire = true;
		this.smotionY = -5;
		this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(1.0D);

	}

	public void setVel(double x, double y, double z) {
		this.smotionX = x;
		this.smotionY = y;
		this.smotionZ = z;
	}

	public void onUpdate() {
		this.motionX = this.smotionX;
		this.motionY = this.smotionY;
		this.motionZ = this.smotionZ;
		if (this.posY < -100) this.setDead();
		if (this.collided) {
			this.world.createExplosion(this, this.posX, this.posY, this.posZ, 8f, true);

			
			new WorldGenMeteorite().generate(this.world, this.rand, new BlockPos(this.posX + this.width / 2, this.posY, this.posZ + this.width/2));
			this.setDead();
		}
		
		super.onUpdate();

	}

	@Override
	public boolean isAIDisabled() {
		return false;
	}

	@Override
	public boolean isEntityInvulnerable(DamageSource source) {
		return true;
	}
	
	@Override
	protected void despawnEntity() {
	}

}
