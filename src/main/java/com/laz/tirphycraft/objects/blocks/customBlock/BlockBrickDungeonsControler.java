package com.laz.tirphycraft.objects.blocks.customBlock;

import java.util.List;
import java.util.Random;

import com.laz.tirphycraft.entity.boss.EntityPrimaryAttack;
import com.laz.tirphycraft.entity.boss.EntityPrimaryHeal;
import com.laz.tirphycraft.entity.boss.EntityPrimaryStrength;
import com.laz.tirphycraft.init.BlockInit;
import com.laz.tirphycraft.init.ItemInit;
import com.laz.tirphycraft.objects.base.BlockBase;
import com.laz.tirphycraft.util.Reference;
import com.laz.tirphycraft.util.interfaces.ParticleTypes;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class BlockBrickDungeonsControler extends BlockBase {

	private boolean spawn = false;

	public BlockBrickDungeonsControler() {
		super("brick_dungeon_controler", Material.ROCK, 3, 15, "pickaxe", 3, SoundType.STONE);
		this.setBlockUnbreakable();
	}

	@Override
	public void onBlockAdded(World world, BlockPos pos, IBlockState state) {
		world.scheduleUpdate(pos, this, this.tickRate(world));

	}

	@Override
	public void onBlockDestroyedByPlayer(World worldIn, BlockPos pos, IBlockState state) {
		this.spawn = false;
		super.onBlockDestroyedByPlayer(worldIn, pos, state);
	}

	@Override
	public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand) {
		AxisAlignedBB box = new AxisAlignedBB(pos.getX() - 20, pos.getY(), pos.getZ() - 20, pos.getX() + 21,
				pos.getY() + 6, pos.getZ() + 21);

		List list = worldIn.getEntitiesWithinAABB(EntityPlayer.class, box);
		if (!list.isEmpty()) {

			if (this.spawn == false) {
				spawnBoss(worldIn, pos, rand);
				this.spawn = true;
			}

		} else {

			this.killBoss(worldIn, pos);
			this.spawn = false;

		}
		killOtherMob(worldIn, pos);

		worldIn.scheduleUpdate(pos, this, this.tickRate(worldIn));
	}

	private void killOtherMob(World worldIn, BlockPos pos) {
		AxisAlignedBB box = new AxisAlignedBB(pos.getX() - 20, pos.getY(), pos.getZ() - 20, pos.getX() + 21,
				pos.getY() + 6, pos.getZ() + 21);

		List list = worldIn.getEntitiesWithinAABB(EntityLiving.class, box);
		for (int i = 0; i <= list.size() - 1; i++) {

			if (list.get(i) instanceof EntityPlayerMP || (list.get(i) instanceof EntityPrimaryAttack)
					|| (list.get(i) instanceof EntityPrimaryHeal) || (list.get(i) instanceof EntityPrimaryStrength)) {

			} else {
				((EntityLiving) list.get(i)).isDead = true;
			}
		}
	}

	private void killBoss(World worldIn, BlockPos pos) {
		AxisAlignedBB box = new AxisAlignedBB(pos.getX() - 20, pos.getY(), pos.getZ() - 20, pos.getX() + 21,
				pos.getY() + 6, pos.getZ() + 21);
		List list = worldIn.getEntitiesWithinAABB(EntityPrimaryAttack.class, box);
		for (int i = 0; i <= list.size() - 1; i++) {
			EntityPrimaryAttack entity = (EntityPrimaryAttack) list.get(i);
			entity.isDead = true;
		}

		list = worldIn.getEntitiesWithinAABB(EntityPrimaryHeal.class, box);
		for (int i = 0; i <= list.size() - 1; i++) {
			EntityPrimaryHeal entity = (EntityPrimaryHeal) list.get(i);
			entity.isDead = true;
		}

		list = worldIn.getEntitiesWithinAABB(EntityPrimaryStrength.class, box);
		for (int i = 0; i <= list.size() - 1; i++) {
			EntityPrimaryStrength entity = (EntityPrimaryStrength) list.get(i);
			entity.isDead = true;
		}

	}

	@Override
	public int tickRate(World world) {
		return 1;
	}

	private void spawnBoss(World worldIn, BlockPos pos, Random rand) {

		for (int i = 0; i < 360; i++) {
			double x = rand.nextDouble() - .5;
			double z = rand.nextDouble() - .5;
			Reference.PROXY.spawnParticle(worldIn, ParticleTypes.GLINT_WHITE, pos.getX() + .5, pos.getY() + 2,
					pos.getZ() + .5, x, 0, z);

		}
		EntityPrimaryAttack e1 = new EntityPrimaryAttack(worldIn);
		e1.setPosition(pos.getX() + 6, pos.getY() + 1, pos.getZ());
		EntityPrimaryHeal e2 = new EntityPrimaryHeal(worldIn);
		e2.setPosition(pos.getX() - 5, pos.getY() + 1, pos.getZ() - 5);
		EntityPrimaryStrength e3 = new EntityPrimaryStrength(worldIn);
		e3.setPosition(pos.getX() - 5, pos.getY() + 1, pos.getZ() + 5);

		worldIn.spawnEntity(e1);
		worldIn.spawnEntity(e2);
		worldIn.spawnEntity(e3);
		
		for (int i = 0; i < 150; i++) {
			double x = rand.nextDouble() - .5;
			double y = rand.nextDouble();
			double z = rand.nextDouble() - .5;
			Reference.PROXY.spawnParticle(worldIn, ParticleTypes.GLINT_BLUE, e1.posX, e1.posY,
					e1.posZ, x, y, z);

		}
		for (int i = 0; i < 150; i++) {
			double x = rand.nextDouble() - .5;
			double y = rand.nextDouble();
			double z = rand.nextDouble() - .5;
			Reference.PROXY.spawnParticle(worldIn, ParticleTypes.GLINT_PURPLE, e2.posX, e2.posY,
					e2.posZ, x, y, z);

		}
		for (int i = 0; i < 150; i++) {
			double x = rand.nextDouble() - .5;
			double y = rand.nextDouble();
			double z = rand.nextDouble() - .5;
			Reference.PROXY.spawnParticle(worldIn, ParticleTypes.GLINT_GREEN, e3.posX, e3.posY,
					e3.posZ, x, y, z);

		}
	}
}