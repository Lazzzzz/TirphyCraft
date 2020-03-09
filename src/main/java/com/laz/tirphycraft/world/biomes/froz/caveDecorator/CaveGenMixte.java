package com.laz.tirphycraft.world.biomes.froz.caveDecorator;

import java.util.Random;

import com.laz.tirphycraft.entity.entityClass.aggressive.EntityAngrySnowGolemSoldier;
import com.laz.tirphycraft.init.BlockInit;

import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityList;
import net.minecraft.init.Blocks;
import net.minecraft.tileentity.TileEntityMobSpawner;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;

public class CaveGenMixte extends WorldGenAbstractTree {
	public static final IBlockState GRASS = BlockInit.NOXIS_GRASS.getDefaultState();
	public static final IBlockState PLANT = BlockInit.FROZ_PLANT_BLUE_ROSE.getDefaultState();

	public CaveGenMixte() {
		super(false);
	}

	@Override
	public boolean generate(World worldIn, Random rand, BlockPos pos) {
		for (int i = 0; i < 20; i++) {
			int x = rand.nextInt(16) - 8;
			int y = rand.nextInt(16) - 8;
			int z = rand.nextInt(16) - 8;
			if (worldIn.getBlockState(pos.add(x, y, z)) == BlockInit.FROZ_STONE.getDefaultState()) {

				if (worldIn.getBlockState(pos.add(x, y, z).up()) == Blocks.AIR.getDefaultState()
						|| worldIn.getBlockState(pos.add(x, y, z).down()) == Blocks.AIR.getDefaultState()
						|| worldIn.getBlockState(pos.add(x, y, z).north()) == Blocks.AIR.getDefaultState()
						|| worldIn.getBlockState(pos.add(x, y, z).south()) == Blocks.AIR.getDefaultState()
						|| worldIn.getBlockState(pos.add(x, y, z).west()) == Blocks.AIR.getDefaultState()
						|| worldIn.getBlockState(pos.add(x, y, z).east()) == Blocks.AIR.getDefaultState()) {

					if (rand.nextBoolean())
						worldIn.setBlockState(pos.add(x, y, z), BlockInit.FROZ_COBBLESTONE.getDefaultState());
					else {
						if (pos.add(x, y, z).getY() > rand.nextInt(20) + 20)
							worldIn.setBlockState(pos.add(x, y, z), Blocks.ICE.getDefaultState());
						else
							worldIn.setBlockState(pos.add(x, y, z), Blocks.PACKED_ICE.getDefaultState());
					}

					if (rand.nextInt(60) == 0) {
						worldIn.setBlockState(pos.add(x, y, z), Blocks.MOB_SPAWNER.getDefaultState());
						TileEntityMobSpawner spawner = (TileEntityMobSpawner) worldIn.getTileEntity(pos.add(x, y, z));
						spawner.getSpawnerBaseLogic().setEntityId(EntityList.getKey(EntityAngrySnowGolemSoldier.class));
					}

				}

			}
			if (worldIn.getBlockState(pos.add(x, y, z)).isOpaqueCube()) {
				if (worldIn.getBlockState(pos.add(x, y, z).down()) == Blocks.AIR.getDefaultState()) {
					int r = rand.nextInt(3);
					if (r == 0)
						worldIn.setBlockState(pos.add(x, y, z).down(), BlockInit.FROZ_CAVE_MOSS.getDefaultState());
					else if (r == 1)
						worldIn.setBlockState(pos.add(x, y, z).down(), BlockInit.FROZ_CAVE_ROOT.getDefaultState());
					else
						worldIn.setBlockState(pos.add(x, y, z).down(), BlockInit.STALACTITE.getDefaultState());

				}
			}

			if (worldIn.getBlockState(pos.add(x, y, z)).isOpaqueCube() && rand.nextInt(2) == 0) {
				if (worldIn.getBlockState(pos.add(x, y, z).up()) == Blocks.AIR.getDefaultState()) {
					if (rand.nextInt(150) == 0 && worldIn.getBlockState(pos.add(x, y, z).up().up()) == Blocks.AIR.getDefaultState()) {
						worldIn.setBlockState(pos.add(x, y, z).up(), Blocks.CHEST.getDefaultState());
					} else {
						worldIn.setBlockState(pos.add(x, y, z).up(), BlockInit.STALAGMITE.getDefaultState());
					}
				}
			}
		}
		return true;

	}
}
