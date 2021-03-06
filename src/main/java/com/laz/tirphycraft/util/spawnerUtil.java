package com.laz.tirphycraft.util;

import com.laz.tirphycraft.entity.entityClass.aggressive.EntityPlyton;

import net.minecraft.entity.EntityList;
import net.minecraft.entity.EntityLiving;
import net.minecraft.tileentity.TileEntityMobSpawner;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.structure.template.Template;

public class spawnerUtil {
	public void placeSpawner(World world, BlockPos pos, int id, Template template, EntityLiving entity) {
		for (int x = 0; x <= template.getSize().getX(); x++) {

			for (int y = 0; y <= template.getSize().getY(); y++) {

				for (int z = 0; z <= template.getSize().getZ(); z++) {

					BlockPos tmp = new BlockPos(pos.getX() + x, pos.getY() + y, pos.getZ() + z);

					if (world.getTileEntity(tmp) != null) {

						if (world.getTileEntity(tmp) instanceof TileEntityMobSpawner) {
							TileEntityMobSpawner spawner = (TileEntityMobSpawner) world.getTileEntity(tmp);
							spawner.getSpawnerBaseLogic().setEntityId(EntityList.getKey(EntityPlyton.class));
						}
					}
				}
			}
		}

	}
}
