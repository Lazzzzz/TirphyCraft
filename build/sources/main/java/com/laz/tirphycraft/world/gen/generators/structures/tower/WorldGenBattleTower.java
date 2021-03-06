package com.laz.tirphycraft.world.gen.generators.structures.tower;

import java.util.Random;

import com.laz.tirphycraft.init.BlockInit;
import com.laz.tirphycraft.util.Reference;
import com.laz.tirphycraft.util.handlers.LootTableHandler;
import com.laz.tirphycraft.util.interfaces.IStructure;

import net.minecraft.block.Block;
import net.minecraft.server.MinecraftServer;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraft.world.gen.structure.template.Template;
import net.minecraft.world.gen.structure.template.TemplateManager;

public class WorldGenBattleTower extends WorldGenerator implements IStructure {

	ResourceLocation tower11 = new ResourceLocation(Reference.MOD_ID, "tower/tower_1_1");
	ResourceLocation tower12 = new ResourceLocation(Reference.MOD_ID, "tower/tower_1_2");
	ResourceLocation tower13 = new ResourceLocation(Reference.MOD_ID, "tower/tower_1_3");
	ResourceLocation tower14 = new ResourceLocation(Reference.MOD_ID, "tower/tower_1_4");
	ResourceLocation tower15 = new ResourceLocation(Reference.MOD_ID, "tower/tower_1_5");
	ResourceLocation tower16 = new ResourceLocation(Reference.MOD_ID, "tower/tower_1_6");
	ResourceLocation tower2 = new ResourceLocation(Reference.MOD_ID, "tower/tower_2");
	ResourceLocation towerB = new ResourceLocation(Reference.MOD_ID, "tower/tower_b");
	ResourceLocation towerC = new ResourceLocation(Reference.MOD_ID, "tower/tower_c");
	ResourceLocation towerCNB = new ResourceLocation(Reference.MOD_ID, "tower/tower_cnb");
	ResourceLocation towerCSB = new ResourceLocation(Reference.MOD_ID, "tower/tower_csb");
	ResourceLocation towerCEB = new ResourceLocation(Reference.MOD_ID, "tower/tower_ceb");
	ResourceLocation towerCWB = new ResourceLocation(Reference.MOD_ID, "tower/tower_cwb");

	ResourceLocation towerBOSS = new ResourceLocation(Reference.MOD_ID, "tower/tower_boss");
	ResourceLocation towerTS = new ResourceLocation(Reference.MOD_ID, "tower/tower_ts");

	Template templateTower11;
	Template templateTower12;
	Template templateTower13;
	Template templateTower14;
	Template templateTower15;
	Template templateTower16;
	Template templateTower2;
	Template templateTowerB;
	Template templateTowerC;
	Template templateTowerCNB;
	Template templateTowerCSB;
	Template templateTowerCEB;
	Template templateTowerCWB;
	Template templateTowerBOSS;
	Template templateTowerTS;

	private void LoadStructure(World world) {

		TemplateManager manager = worldServer.getStructureTemplateManager();
		MinecraftServer mcServer = world.getMinecraftServer();

		templateTower11 = manager.get(mcServer, tower11);
		templateTower12 = manager.get(mcServer, tower12);
		templateTower13 = manager.get(mcServer, tower13);
		templateTower14 = manager.get(mcServer, tower14);
		templateTower15 = manager.get(mcServer, tower15);
		templateTower16 = manager.get(mcServer, tower16);
		templateTower2 = manager.get(mcServer, tower2);
		templateTowerB = manager.get(mcServer, towerB);
		templateTowerC = manager.get(mcServer, towerC);
		templateTowerCNB = manager.get(mcServer, towerCNB);
		templateTowerCSB = manager.get(mcServer, towerCSB);
		templateTowerCEB = manager.get(mcServer, towerCEB);
		templateTowerCWB = manager.get(mcServer, towerCWB);
		templateTowerBOSS = manager.get(mcServer, towerBOSS);
		templateTowerTS = manager.get(mcServer, towerTS);
	}

	private BlockPos GetNextPosY(BlockPos pos, Template template, int i) {
		int x = pos.getX();
		int y = pos.getY() + i * template.getSize().getY();
		int z = pos.getZ();

		return new BlockPos(x, y, z);

	}

	private void generateLittleTower(World world, BlockPos pos, Random rand) {
		int x, y, z;

		int r = rand.nextInt(5) + 1;
		pos = new BlockPos(pos.getX(), pos.getY() + templateTowerCNB.getSize().getY(), pos.getZ());

		for (int i = 0; i < r; i++) {
			x = pos.getX();
			y = pos.getY() + i * templateTower2.getSize().getY();
			z = pos.getZ();
			templateTower2.addBlocksToWorldChunk(world, new BlockPos(x, y, z), settings.setRotation(Rotation.NONE));

		}
		x = pos.getX() - 1;
		y = pos.getY() + r * templateTower2.getSize().getY();
		z = pos.getZ() - 1;
		templateTowerTS.addBlocksToWorldChunk(world, new BlockPos(x, y, z), settings.setRotation(Rotation.NONE));

	}

	private void generateConnec(World world, BlockPos pos, Random rand, int i) {
		BlockPos p1 = new BlockPos(pos.getX() - 2, pos.getY(), pos.getZ() - 2);
		BlockPos p2 = new BlockPos(pos.getX() + 19, pos.getY(), pos.getZ() + 3);
		BlockPos p3 = new BlockPos(pos.getX() - 15, pos.getY(), pos.getZ() + 3);
		BlockPos p4 = new BlockPos(pos.getX() + 3, pos.getY(), pos.getZ() + 19);
		BlockPos p5 = new BlockPos(pos.getX() + 3, pos.getY(), pos.getZ() - 15);

		templateTowerC.addBlocksToWorldChunk(world, p1, settings.setRotation(Rotation.NONE));
		templateTowerCEB.addBlocksToWorldChunk(world, p2, settings.setRotation(Rotation.NONE));
		templateTowerCWB.addBlocksToWorldChunk(world, p3, settings.setRotation(Rotation.NONE));
		templateTowerCSB.addBlocksToWorldChunk(world, p4, settings.setRotation(Rotation.NONE));
		templateTowerCNB.addBlocksToWorldChunk(world, p5, settings.setRotation(Rotation.NONE));

		generateLittleTower(world, new BlockPos(p2.getX() + 2, p2.getY(), p2.getZ()), rand);
		generateLittleTower(world, new BlockPos(p3.getX(), p3.getY(), p3.getZ()), rand);
		generateLittleTower(world, new BlockPos(p4.getX(), p4.getY(), p4.getZ() + 2), rand);
		generateLittleTower(world, new BlockPos(p5.getX(), p5.getY(), p5.getZ()), rand);

	}

	public boolean generate(World world, Random rand, BlockPos pos) {
		boolean canPlace = checkForSawn(worldServer.getStructureTemplateManager().get(world.getMinecraftServer(), towerB), world, pos);
		if (canPlace) {
			System.out.println(pos);
			LoadStructure(world);
			BlockPos newPos = pos;
			int n;			
			int r = rand.nextInt(10) + 5;
			int connec = rand.nextInt((int) r - 4) + 2;
			if (connec >= r)
				connec = r - 2;

			for (int i = 0; i < r; i++) {

				if (i == 0) {
					templateTowerB.addBlocksToWorldChunk(world, pos, settings.setRotation(Rotation.NONE));
					newPos = GetNextPosY(pos, templateTowerB, i + 1);
				}

				if (i == connec) {
					generateConnec(world, newPos, rand, i);
					newPos = GetNextPosY(pos, templateTowerC, i + 1);

				} else if (i != 0 && i != connec) {
					n = rand.nextInt(6);
					if (n == 0) {
						templateTower11.addBlocksToWorldChunk(world, newPos, settings.setRotation(Rotation.NONE));
						fillChest(world, templateTower11, newPos);
					}
					if (n == 1) {
						templateTower12.addBlocksToWorldChunk(world, newPos, settings.setRotation(Rotation.NONE));
						fillChest(world, templateTower12, newPos);
					}
					if (n == 2) {
						templateTower13.addBlocksToWorldChunk(world, newPos, settings.setRotation(Rotation.NONE));
						fillChest(world, templateTower13, newPos);
					}
					if (n == 3) {
						templateTower14.addBlocksToWorldChunk(world, newPos, settings.setRotation(Rotation.NONE));
						fillChest(world, templateTower14, newPos);
					}
					if (n == 4) {
						templateTower15.addBlocksToWorldChunk(world, newPos, settings.setRotation(Rotation.NONE));
						fillChest(world, templateTower15, newPos);
					}
					if (n == 5) {
						templateTower16.addBlocksToWorldChunk(world, newPos, settings.setRotation(Rotation.NONE));
						fillChest(world, templateTower16, newPos);
					}
					newPos = GetNextPosY(pos, templateTower11, i + 1);
				}

			}

			int x = newPos.getX() - 1;
			int y = newPos.getY();
			int z = newPos.getZ() - 1;

			templateTowerBOSS.addBlocksToWorldChunk(world, new BlockPos(x, y, z), settings.setRotation(Rotation.NONE));
		}

		return true;

	}

	private boolean checkForSawn(Template template, World world, BlockPos pos) {
		boolean flag = true;
		for (int i = 0; i < template.getSize().getX(); i++) {
			for (int j = 0; j < template.getSize().getZ(); j++) {
				BlockPos down = pos.add(i, -1, j);
				Block b = world.getBlockState(down).getBlock();
				if (!b.equals(BlockInit.NOXIS_DIRT)) {
					flag = false;
				}

			}
		}
		return true;

		//return flag;
	}

	private void fillChest(World world, Template template, BlockPos pos) {
		for (int x = 0; x <= template.getSize().getX(); x++) {

			for (int y = 0; y <= template.getSize().getY(); y++) {

				for (int z = 0; z <= template.getSize().getZ(); z++) {

					BlockPos tmp = new BlockPos(pos.getX() + x, pos.getY() + y, pos.getZ() + z);

					if (world.getTileEntity(tmp) != null) {

						if (world.getTileEntity(tmp) instanceof TileEntityChest) {
							TileEntityChest chest = (TileEntityChest) world.getTileEntity(tmp);
							chest.setLootTable(LootTableHandler.TOWER_DUNGEONS, new Random().nextLong());
						}

					}
				}
			}
		}
	}

}
