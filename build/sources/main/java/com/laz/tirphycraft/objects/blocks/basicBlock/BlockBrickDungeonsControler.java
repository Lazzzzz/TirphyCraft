package com.laz.tirphycraft.objects.blocks.basicBlock;

import java.util.List;
import java.util.Random;

import com.laz.tirphycraft.entity.entityClass.boss.EntityPrimaryAttack;
import com.laz.tirphycraft.entity.entityClass.boss.EntityPrimaryHeal;
import com.laz.tirphycraft.entity.entityClass.boss.EntityPrimaryStrength;
import com.laz.tirphycraft.entity.entityClass.neutral.EntityStellar;
import com.laz.tirphycraft.init.BlockInit;
import com.laz.tirphycraft.objects.base.BlockBase;
import com.laz.tirphycraft.util.Reference;
import com.laz.tirphycraft.util.interfaces.ParticleTypes;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;

public class BlockBrickDungeonsControler extends BlockBase {

	private boolean spawn = false;

	public BlockBrickDungeonsControler() {
		super("brick_dungeon_controler", Material.ROCK, 3, 15, "pickaxe", 3, SoundType.STONE);
		this.setBlockUnbreakable();
	}

	@Override
	public void onBlockAdded(World world, BlockPos pos, IBlockState state) {
		BlockPos b = new BlockPos(world.getHeight(pos));
		EntityStellar e = new EntityStellar(world);

		e.setPosition(b.getX() + 0.5, b.getY(), b.getZ() + 0.5);

		world.spawnEntity(e);
		world.scheduleUpdate(pos, this, this.tickRate(world));

	}

	@Override
	public void onBlockDestroyedByPlayer(World worldIn, BlockPos pos, IBlockState state) {
		this.spawn = false;
		super.onBlockDestroyedByPlayer(worldIn, pos, state);
	}

	@Override
	public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand) {
		if (worldIn.getDifficulty() != EnumDifficulty.PEACEFUL) {
			if (this.spawn == true && this.checkBoss(worldIn, pos) == false) {
				worldIn.setBlockState(pos, BlockInit.BRICK_DUNGEON_SUN.getDefaultState());
				this.spawn = false;
			}
	
			if (this.checkPlayer(worldIn, pos) == true) {
				if (this.spawn == false) {
					if (this.checkBoss(worldIn, pos) == false) {
						if (worldIn.getBlockState(pos) == BlockInit.BRICK_DUNGEON_CONTROLER.getDefaultState()) {
							this.spawnBoss(worldIn, pos, rand);
							this.spawn = true;
						}
					}
				}
			} else {
				this.killBoss(worldIn, pos);
				this.spawn = false;
	
			}
	
			this.killAllMob(worldIn, pos);
		}
		worldIn.scheduleUpdate(pos, this, this.tickRate(worldIn));
	}

	@Override
	public int tickRate(World world) {
		return 20;
	}

	private boolean checkBoss(World worldIn, BlockPos pos) {
		AxisAlignedBB box = new AxisAlignedBB(pos.getX() - 10, pos.getY(), pos.getZ() - 10, pos.getX() + 11,
				pos.getY() + 6, pos.getZ() + 11);
		List l1 = worldIn.getEntitiesWithinAABB(EntityPrimaryAttack.class, box);
		List l2 = worldIn.getEntitiesWithinAABB(EntityPrimaryHeal.class, box);
		List l3 = worldIn.getEntitiesWithinAABB(EntityPrimaryStrength.class, box);

		if (l1.size() + l2.size() + l3.size() == 0)
			return false;
		return true;
	}

	private void spawnBoss(World worldIn, BlockPos pos, Random rand) {
		int x = pos.getX();
		int y = pos.getY() + 1;
		int z = pos.getZ();

		EntityPrimaryAttack e1 = new EntityPrimaryAttack(worldIn);
		e1.setPosition(x + 6, y, z);
		EntityPrimaryHeal e2 = new EntityPrimaryHeal(worldIn);
		e2.setPosition(x - 5, y, z - 5);
		EntityPrimaryStrength e3 = new EntityPrimaryStrength(worldIn);
		e3.setPosition(x - 5, y, z + 5);

		worldIn.spawnEntity(e1);
		worldIn.spawnEntity(e2);
		worldIn.spawnEntity(e3);

		spawnParticles(worldIn, pos, ParticleTypes.GLINT_WHITE, 100, 1, rand);
		spawnParticles(worldIn, new BlockPos(x + 6, y, z), ParticleTypes.GLINT_BLUE, 100, 0.5, rand);
		spawnParticles(worldIn, new BlockPos(x - 5, y, z - 5), ParticleTypes.GLINT_PURPLE, 100, 0.5, rand);
		spawnParticles(worldIn, new BlockPos(x - 5, y, z + 5), ParticleTypes.GLINT_GREEN, 100, 0.5, rand);
	}

	private boolean checkPlayer(World worldIn, BlockPos pos) {
		AxisAlignedBB box = new AxisAlignedBB(pos.getX() - 10, pos.getY(), pos.getZ() - 10, pos.getX() + 11,
				pos.getY() + 6, pos.getZ() + 11);
		List l1 = worldIn.getEntitiesWithinAABB(EntityPlayer.class, box);

		if (l1.size() == 0)
			return false;
		return true;
	}

	private void killBoss(World worldIn, BlockPos pos) {
		AxisAlignedBB box = new AxisAlignedBB(pos.getX() - 10, pos.getY(), pos.getZ() - 10, pos.getX() + 11,
				pos.getY() + 6, pos.getZ() + 11);
		List l1 = worldIn.getEntitiesWithinAABB(EntityPrimaryAttack.class, box);
		List l2 = worldIn.getEntitiesWithinAABB(EntityPrimaryHeal.class, box);
		List l3 = worldIn.getEntitiesWithinAABB(EntityPrimaryStrength.class, box);

		for (int i = 0; i < l1.size(); i++) {
			((EntityPrimaryAttack) l1.get(i)).isDead = true;
		}
		for (int i = 0; i < l2.size(); i++) {
			((EntityPrimaryHeal) l2.get(i)).isDead = true;
		}
		for (int i = 0; i < l3.size(); i++) {
			((EntityPrimaryStrength) l3.get(i)).isDead = true;
		}
	}

	private void spawnParticles(World worldIn, BlockPos pos, ParticleTypes type, int amount, double speed,
			Random rand) {
		int x = pos.getX();
		int y = pos.getY();
		int z = pos.getZ();

		for (int i = 0; i < amount; i++) {
			double vx = (rand.nextDouble() - 0.5) * speed;
			double vy = rand.nextDouble() * speed;
			double vz = (rand.nextDouble() - 0.5) * speed;

			Reference.PROXY.spawnParticle(worldIn, type, x, y, z, vx, vy, vz);
		}
	}

	private void killAllMob(World worldIn, BlockPos pos) {
		AxisAlignedBB box = new AxisAlignedBB(pos.getX() - 10, pos.getY(), pos.getZ() - 10, pos.getX() + 11,
				pos.getY() + 6, pos.getZ() + 11);
		List l1 = worldIn.getEntitiesWithinAABB(EntityLiving.class, box);

		for (int i = 0; i < l1.size(); i++) {
			if (l1.get(i) instanceof EntityPlayerMP || l1.get(i) instanceof EntityPrimaryAttack
					|| l1.get(i) instanceof EntityPrimaryHeal || l1.get(i) instanceof EntityPrimaryStrength) {

			} else {
				((EntityLiving) l1.get(i)).isDead = true;
			}

		}
	}

}