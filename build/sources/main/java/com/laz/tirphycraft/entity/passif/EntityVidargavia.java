package com.laz.tirphycraft.entity.passif;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;

public class EntityVidargavia extends EntityVillager {

	private boolean click = false;
	private int i = 0;

	public EntityVidargavia(World worldIn) {

		super(worldIn);
		this.setSize(1F, 2F);
		this.setCustomNameTag("\u00A75" + "Vidargavia the CREATOR");
	}

	@Override
	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(400000.0D);
		this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.0D);
	}

	@Override
	public float getEyeHeight() {
		return 1.8F;
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
		player.sendMessage(new TextComponentString("I am the" + "\u00A75" + " CREATOR !"));
		return false;
	}
	
}
