package com.laz.tirphycraft.objects.items.canon.noxis;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityTippedArrow;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

public class NixiumArrow extends EntityTippedArrow {
	public NixiumArrow(World a) {
		super(a);
	}

	public NixiumArrow(World worldIn, double x, double y, double z) {
		super(worldIn, x, y, z);
	}

	public NixiumArrow(World worldIn, EntityLivingBase shooter) {
		super(worldIn, shooter);
	}

	@Override
	public void onUpdate() {
		super.onUpdate();
		int x = MathHelper.floor(this.getEntityBoundingBox().minX);
		int y = MathHelper.floor(this.getEntityBoundingBox().minY);
		int z = MathHelper.floor(this.getEntityBoundingBox().minZ);
		World world = this.world;
		Entity entity = (Entity) shootingEntity;
		if (this.inGround) {
			this.world.removeEntity(this);
		}
	}
}

