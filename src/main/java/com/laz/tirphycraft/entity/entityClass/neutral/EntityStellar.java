package com.laz.tirphycraft.entity.entityClass.neutral;

import com.laz.tirphycraft.init.BlockInit;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class EntityStellar extends EntityAnimal {

	public EntityStellar(World worldIn) {

		super(worldIn);
		this.setSize(1F, 4F);

	}

	@Override
	public void onLivingUpdate() {
	}

	@Override
	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(20.0D);
		this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0D);
		this.getEntityAttribute(SharedMonsterAttributes.KNOCKBACK_RESISTANCE).setBaseValue(1D);
	}

	@Override
	public boolean hitByEntity(Entity entityIn) {
		if (entityIn instanceof EntityPlayerMP) {
			if (((EntityPlayerMP) entityIn).isCreative()) {
				this.isDead = true;
			}
		}
		return true;
	}

	@Override
	public boolean isEntityInvulnerable(DamageSource source) {
		return true;
	}

	public boolean processInteract(EntityPlayer player, EnumHand hand) {
		BlockPos pos = getPos();
		player.setPosition(pos.getX() + 0.5, pos.getY() + 1, pos.getZ() + 0.5);
		return true;
	}

	@Override
	public EntityAgeable createChild(EntityAgeable ageable) {
		return null;
	}

	private BlockPos getPos() {
		for (int x = -1; x < 2; x++) {
			for (int z = -1; z < 2; z++) {
				for (int i = 0; i < 255; i++) {
					BlockPos pos = new BlockPos(this.posX + x, i, this.posZ + z);
					if (this.world.getBlockState(pos) == BlockInit.BRICK_DUNGEON_CONTROLER.getDefaultState())
						return pos;

				}
			}
		}
		return new BlockPos(this.posX, this.posY, this.posZ);
	}

}
