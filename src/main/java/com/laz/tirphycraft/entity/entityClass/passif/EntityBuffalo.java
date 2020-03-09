package com.laz.tirphycraft.entity.entityClass.passif;

import com.laz.tirphycraft.util.handlers.ConfigHandler;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.monster.EntitySpider;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;

public class EntityBuffalo extends EntitySpider {
	public EntityBuffalo(World worldIn) {
		
		super(worldIn);
		this.setSize(0.9F, 1.4F);

	}

	
	@Override
	protected void applyEntityAttributes() 
	{
		super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(20.0D);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.20000000298023224D);
	}
	
	@Override
	protected ResourceLocation getLootTable() 
	{
		return null;}
	
	@Override
	protected SoundEvent getAmbientSound() 
	{
		return null;
	}
	
	@Override
	protected SoundEvent getHurtSound(DamageSource source) 
	{
		return null;
	}
	
	@Override
	protected SoundEvent getDeathSound() 
	{
		return null;
	}

	@Override
	public boolean processInteract(EntityPlayer player, EnumHand hand) {
		return false;
	}
	
	protected boolean isValidLightLevel() {
		return true; // don't care about the light level to spawn
	}
	@Override
	public boolean getCanSpawnHere() {
		return this.world.loadedEntityList.size() < ConfigHandler.MAX_PASSIF_CREATURE;

	}

}	

