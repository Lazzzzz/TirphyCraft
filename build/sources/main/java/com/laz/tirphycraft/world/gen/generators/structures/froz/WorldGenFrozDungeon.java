package com.laz.tirphycraft.world.gen.generators.structures.froz;

import java.util.Random;

import com.laz.tirphycraft.entity.entityClass.aggressive.EntityAngrySnowGolemRange;
import com.laz.tirphycraft.entity.entityClass.aggressive.EntityAngrySnowGolemSoldier;
import com.laz.tirphycraft.init.BlockInit;
import com.laz.tirphycraft.init.ItemInit;
import com.laz.tirphycraft.util.interfaces.IStructure;

import net.minecraft.entity.EntityList;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.tileentity.TileEntityMobSpawner;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenFrozDungeon extends WorldGenerator implements IStructure {

	int size = new Random().nextInt(10) + 8;
	private BlockPos[] roomList = new BlockPos[size];
	private int[] lockList = new int[3];
	private int[][] roomSize = new int[size][2];

	@Override
	public boolean generate(World worldIn, Random rand, BlockPos position) {

		int posY = rand.nextInt(20) + 20;
		System.out.println(position);
		int minSize = 4;
		int maxSize = 10;
		int rayon = size * 10;
		int sizeX = 0;
		int sizeZ = 0;

		BlockPos p = position;

		boolean flag = checkSpace(worldIn, new BlockPos(position.getX() - rayon /2 - 10, position.getY() - 40, position.getZ()- rayon / 2 - 10), rayon / 2 - 10, rayon / 2 - 10);
		if (flag == false) return flag;
		
		for (int i = 0; i < roomList.length; i++) {
			boolean done = false;
			int o = 0;
			
			while (done == false) {
				o ++;
				if (o == 100) {
					return false;
				}
				p = new BlockPos(position.getX() + rand.nextInt(rayon / 2) - rayon / 4, 30,
						position.getZ() + rand.nextInt(rayon / 2) - rayon / 4);

				sizeX = (rand.nextInt(maxSize - minSize) + minSize) * 2;
				sizeZ = (rand.nextInt(maxSize - minSize) + minSize) * 2;

				done = checkSpace(worldIn, p, sizeX, sizeZ);
			}

			generateRoom(worldIn, rand, p, sizeX, sizeZ, 6, false);

			if (i == 0) { // Generate event for first Room
				generateEnter(worldIn, rand, p, sizeX, sizeZ);
			}

			roomList[i] = p;
			roomSize[i][0] = sizeX;
			roomSize[i][1] = sizeZ;

		}

		for (int i = 0; i < roomList.length - 1; i++) {
			BlockPos room1 = roomList[i];
			BlockPos room2 = roomList[i + 1];
			
			connectRoom(worldIn, rand, room1, room2, 4);
		}

		generateEnd(worldIn, rand, position, rayon);
		genChest(worldIn, rand);

		for (int i = 1; i < roomList.length; i++) {
			fillRoom(worldIn, roomList[i], roomSize[i][0] - 2, roomSize[i][1] - 2, rand, 6);
		}

		return true;
	}

	private boolean checkSpace(World worldIn, BlockPos center, int sizeX, int sizeZ) {
		int halfX = (int) sizeX / 2;
		int halfZ = (int) sizeZ / 2;
		int height = 6;

		for (int i = -halfX - 2; i < halfX + 2; i++) {
			for (int j = 0; j < height; j++) {
				for (int k = -halfZ - 2; k < halfZ + 2; k++) {

					if (worldIn.getBlockState(getPos(center, i, j, k)) == Blocks.AIR.getDefaultState())
						return false;
				}
			}
		}

		return true;
	}

	private void generateRoom(World worldIn, Random rand, BlockPos center, int sizeX, int sizeZ, int height,
			boolean boss) {

		int halfX = (int) sizeX / 2;
		int halfZ = (int) sizeZ / 2;

		BlockPos corner = getPos(center, -halfX + 1, 0, -halfZ + 1);

		for (int i = -halfX; i < halfX; i++) {
			for (int j = 0; j < height; j++) {
				for (int k = -halfZ; k < halfZ; k++) {

					worldIn.setBlockToAir(getPos(center, i, j, k));
				}
			}
		}
		if (boss)
			generateWallBoss(worldIn, rand, corner, halfX * 2 - 2, halfZ * 2 - 2, height - 2);
		else
			generateWall(worldIn, rand, corner, halfX * 2 - 2, halfZ * 2 - 2, height - 2);

	}

	private void connectRoom(World worldIn, Random rand, BlockPos room1, BlockPos room2, int height) {
		int difX = room1.getX() - room2.getX();
		int difZ = room1.getZ() - room2.getZ();

		if (difX > 0) {
			for (int i = 0; i < difX + 1; i++) {
				wallCorridorXaxis(worldIn, i, height, room2, rand);
			}
		} else if (difX < 0) {
			for (int i = 0; i > difX - 2; i--) {
				wallCorridorXaxis(worldIn, i, height, room2, rand);
			}
		}

		if (difZ > 0) {
			for (int i = 0; i < difZ; i++) {
				wallCorridorZaxis(worldIn, i, difX, height, room2, rand);
			}

		} else if (difZ < 0) {
			for (int i = 1; i > difZ; i--) {
				wallCorridorZaxis(worldIn, i, difX, height, room2, rand);
			}
		}

	}

	private void generateEnter(World worldIn, Random rand, BlockPos center, int sizeX, int sizeZ) {
		for (int y = 0; y < 256; y++) {
			for (int x = -2; x < 2; x++) {
				for (int z = -2; z < 2; z++) {
					worldIn.setBlockToAir(getPos(center, x, y, z));
				}
			}
		}

		for (int y = 0; y < 256; y++) {
			for (int x = -3; x < 3; x++) {
				for (int z = -3; z < 3; z++) {
					if (worldIn.getBlockState(getPos(center, x, y, z)) != Blocks.AIR.getDefaultState())
						worldIn.setBlockState(getPos(center, x, y, z), BlockInit.BRICK_FROZ.getDefaultState());
				}
			}
		}
	}

	private void generateEnd(World worldIn, Random rand, BlockPos position, int rayon) {
		boolean done = false;
		BlockPos p = position;
		BlockPos p2;

		while (!done) {
			p = new BlockPos(position.getX() + rand.nextInt(rayon) - rayon / 4, 30,
					position.getZ() + rand.nextInt(rayon) - rayon / 4);
			done = checkSpace(worldIn, p, 60, 40);

		}
		p.add(10, 0, 10);
		p2 = new BlockPos(p.getX() - 20, p.getY(), p.getZ());

		generateRoom(worldIn, rand, p, 20, 20, 8, true);
		generateRoom(worldIn, rand, p2, 8, 8, 6, false);
		connectRoom(worldIn, rand, p2, roomList[roomList.length - 1], 4);

		generateCorridorBoss(worldIn, p2);

	}

	private void generateCorridorBoss(World worldIn, BlockPos pos) {
		for (int i = 1; i < 7; i++) {

			for (int j = 0; j < 4; j++) {
				for (int k = 0; k < 4; k++) {
					worldIn.setBlockToAir(getPos(pos, i + 3, j, k - 2));
				}
			}
			if (i == 2)
				generateDoor(worldIn, getPos(pos, i + 3, 0, -2));
			else if (i == 4)
				generateDoor(worldIn, getPos(pos, i + 3, 0, -2));
			else if (i == 6)
				generateDoor(worldIn, getPos(pos, i + 3, 0, -2));
		}

		for (int i = 1; i < 7; i++) {

			for (int j = -1; j < 5; j++) {
				for (int k = -1; k < 5; k++) {
					if (worldIn.getBlockState(getPos(pos, i + 3, j, k - 2)) == BlockInit.FROZ_STONE.getDefaultState()) {
						worldIn.setBlockState(getPos(pos, i + 3, j, k - 2), BlockInit.FROZ_BOSS_WALL.getDefaultState());
					}
				}
			}
		}

	}

	private void generateDoor(World worldIn, BlockPos pos) {
		for (int j = 0; j < 4; j++) {
			for (int k = 0; k < 4; k++) {
				worldIn.setBlockState(getPos(pos, 0, j, k), BlockInit.FROZ_BOSS_DOOR.getDefaultState());
			}
		}
	}

	private void generateWall(World worldIn, Random rand, BlockPos corner, int sizeX, int sizeZ, int height) {

		// WALL X AXIS

		for (int i = 0; i < sizeX; i++) {
			for (int j = 1; j < height + 1; j++) {

				placeStoneBrick(worldIn, getPos(corner, i, j, -2), rand);
				placeStoneBrick(worldIn, getPos(corner, i, j, sizeZ + 1), rand);
			}

		}
		for (int i = -2; i < sizeX + 2; i++) {
			for (int j = -1; j < height + 3; j++) {
				if (worldIn.getBlockState(getPos(corner, i, j, -2)) == BlockInit.FROZ_STONE.getDefaultState()
						|| worldIn.getBlockState(getPos(corner, i, j, -2)) == Blocks.AIR.getDefaultState()) {

					worldIn.setBlockState(getPos(corner, i, j, -2), BlockInit.BRICK_FROZ.getDefaultState());
					worldIn.setBlockState(getPos(corner, i, j, sizeZ + 1), BlockInit.BRICK_FROZ.getDefaultState());
				}
			}
		}

		// WALL Z AXIS

		for (int i = 0; i < sizeZ; i++) {
			for (int j = 1; j < height + 1; j++) {

				placeStoneBrick(worldIn, getPos(corner, -2, j, i), rand);
				placeStoneBrick(worldIn, getPos(corner, sizeX + 1, j, i), rand);
			}
		}

		for (int i = -2; i < sizeZ + 2; i++) {
			for (int j = -1; j < height + 2; j++) {
				if (worldIn.getBlockState(getPos(corner, -2, j, i)) == BlockInit.FROZ_STONE.getDefaultState()
						|| worldIn.getBlockState(getPos(corner, -2, j, i)) == Blocks.AIR.getDefaultState()) {

					worldIn.setBlockState(getPos(corner, -2, j, i), BlockInit.BRICK_FROZ.getDefaultState());
					worldIn.setBlockState(getPos(corner, sizeX + 1, j, i), BlockInit.BRICK_FROZ.getDefaultState());
				}
			}
		}

		// WALL Y AXIS

		for (int i = 0; i < sizeX; i++) {
			for (int j = 0; j < sizeZ; j++) {

				placeStoneBrick(worldIn, getPos(corner, i, height + 2, j), rand);
				placeStoneBrick(worldIn, getPos(corner, i, -1, j), rand);

			}
		}

		for (int i = -2; i < sizeX + 2; i++) {
			for (int j = -2; j < sizeZ + 2; j++) {
				if (worldIn.getBlockState(getPos(corner, i, height + 2, j)) == BlockInit.FROZ_STONE.getDefaultState()
						|| worldIn.getBlockState(getPos(corner, i, height + 2, j)) == Blocks.AIR.getDefaultState()) {

					worldIn.setBlockState(getPos(corner, i, height + 2, j), BlockInit.BRICK_FROZ.getDefaultState());
					worldIn.setBlockState(getPos(corner, i, -1, j), BlockInit.BRICK_FROZ.getDefaultState());
				}
			}
		}
	}

	private void generateWallBoss(World worldIn, Random rand, BlockPos corner, int sizeX, int sizeZ, int height) {

		for (int i = -2; i < sizeX + 2; i++) {
			for (int j = -1; j < height + 3; j++) {

				worldIn.setBlockState(getPos(corner, i, j, -2), BlockInit.FROZ_BOSS_WALL.getDefaultState());
				worldIn.setBlockState(getPos(corner, i, j, sizeZ + 1), BlockInit.FROZ_BOSS_WALL.getDefaultState());

			}
		}

		for (int i = -2; i < sizeZ + 2; i++) {
			for (int j = -1; j < height + 2; j++) {

				worldIn.setBlockState(getPos(corner, -2, j, i), BlockInit.FROZ_BOSS_WALL.getDefaultState());
				worldIn.setBlockState(getPos(corner, sizeX + 1, j, i), BlockInit.FROZ_BOSS_WALL.getDefaultState());

			}
		}

		for (int i = -2; i < sizeX + 2; i++) {
			for (int j = -2; j < sizeZ + 2; j++) {

				worldIn.setBlockState(getPos(corner, i, height + 2, j), BlockInit.FROZ_BOSS_WALL.getDefaultState());
				worldIn.setBlockState(getPos(corner, i, -1, j), BlockInit.FROZ_BOSS_WALL.getDefaultState());

			}
		}
	}

	private void placeStoneBrick(World worldIn, BlockPos pos, Random rand) {
		int i = rand.nextInt(11);
		if (i == 4 || i == 5  || i == 6) i = 0;
		worldIn.setBlockState(pos, BlockInit.FROZ_BLUE_BRICK.getStateFromMeta(i));
	}

	private void wallCorridorZaxis(World worldIn, int i, int difX, int height, BlockPos room2, Random rand) {

		if (worldIn.getBlockState(getPos(room2, difX - 1, height, i)) == BlockInit.FROZ_STONE.getDefaultState()) {
			worldIn.setBlockState(getPos(room2, difX - 1, height, i), BlockInit.BRICK_FROZ.getDefaultState());
		}
		if (worldIn.getBlockState(getPos(room2, difX, height, i)) == BlockInit.FROZ_STONE.getDefaultState()) {
			worldIn.setBlockState(getPos(room2, difX, height, i), BlockInit.BRICK_FROZ.getDefaultState());
		}
		if (worldIn.getBlockState(getPos(room2, difX - 1, -1, i)) == BlockInit.FROZ_STONE.getDefaultState()) {
			worldIn.setBlockState(getPos(room2, difX - 1, -1, i), BlockInit.BRICK_FROZ.getDefaultState());
		}
		if (worldIn.getBlockState(getPos(room2, difX, -1, i)) == BlockInit.FROZ_STONE.getDefaultState()) {
			worldIn.setBlockState(getPos(room2, difX, -1, i), BlockInit.BRICK_FROZ.getDefaultState());
		}

		for (int j = 0; j < height; j++) {

			worldIn.setBlockToAir(getPos(room2, difX - 1, j, i));
			worldIn.setBlockToAir(getPos(room2, difX, j, i));

			if (j >= 1 && j <= height - 2) {
				if (worldIn.getBlockState(getPos(room2, difX - 2, j, i)) == BlockInit.FROZ_STONE.getDefaultState()
						|| worldIn.getBlockState(getPos(room2, difX - 2, j, i)) == BlockInit.BRICK_FROZ
								.getDefaultState())
					placeStoneBrick(worldIn, getPos(room2, difX - 2, j, i), rand);

				if (worldIn.getBlockState(getPos(room2, difX + 1, j, i)) == BlockInit.FROZ_STONE.getDefaultState()
						|| worldIn.getBlockState(getPos(room2, difX + 1, j, i)) == BlockInit.BRICK_FROZ
								.getDefaultState()) {
					placeStoneBrick(worldIn, getPos(room2, difX + 1, j, i), rand);
				}
			} else {
				if (worldIn.getBlockState(getPos(room2, difX - 2, j, i)) == BlockInit.FROZ_STONE.getDefaultState()) {
					worldIn.setBlockState(getPos(room2, difX - 2, j, i), BlockInit.BRICK_FROZ.getDefaultState());
				}
				if (worldIn.getBlockState(getPos(room2, difX + 1, j, i)) == BlockInit.FROZ_STONE.getDefaultState()) {
					worldIn.setBlockState(getPos(room2, difX + 1, j, i), BlockInit.BRICK_FROZ.getDefaultState());
				}
			}
		}
	}

	private void wallCorridorXaxis(World worldIn, int i, int height, BlockPos room2, Random rand) {
		if (worldIn.getBlockState(getPos(room2, i, height, 0)) == BlockInit.FROZ_STONE.getDefaultState()) {
			worldIn.setBlockState((getPos(room2, i, height, 0)), BlockInit.BRICK_FROZ.getDefaultState());
		}
		if (worldIn.getBlockState(getPos(room2, i, height, 1)) == BlockInit.FROZ_STONE.getDefaultState()) {
			worldIn.setBlockState((getPos(room2, i, height, 1)), BlockInit.BRICK_FROZ.getDefaultState());
		}
		if (worldIn.getBlockState(getPos(room2, i, -1, 0)) == BlockInit.FROZ_STONE.getDefaultState()) {
			worldIn.setBlockState((getPos(room2, i, -1, 0)), BlockInit.BRICK_FROZ.getDefaultState());
		}
		if (worldIn.getBlockState(getPos(room2, i, -1, 1)) == BlockInit.FROZ_STONE.getDefaultState()) {
			worldIn.setBlockState((getPos(room2, i, -1, 1)), BlockInit.BRICK_FROZ.getDefaultState());
		}

		for (int j = 0; j < height; j++) {

			worldIn.setBlockToAir(getPos(room2, i, j, 0));
			worldIn.setBlockToAir(getPos(room2, i, j, 1));

			if (j >= 1 && j <= height - 2) {
				if (worldIn.getBlockState(getPos(room2, i, j, -1)) == BlockInit.FROZ_STONE.getDefaultState()
						|| worldIn.getBlockState(getPos(room2, i, j, -1)) == BlockInit.BRICK_FROZ.getDefaultState()) {
					placeStoneBrick(worldIn, getPos(room2, i, j, -1), rand);
				}
				if (worldIn.getBlockState(getPos(room2, i, j, 2)) == BlockInit.FROZ_STONE.getDefaultState()
						|| worldIn.getBlockState(getPos(room2, i, j, 2)) == BlockInit.BRICK_FROZ.getDefaultState()) {
					placeStoneBrick(worldIn, getPos(room2, i, j, 2), rand);
				}
			} else {
				if (worldIn.getBlockState(getPos(room2, i, j, -1)) == BlockInit.FROZ_STONE.getDefaultState()) {
					worldIn.setBlockState(getPos(room2, i, j, -1), BlockInit.BRICK_FROZ.getDefaultState());
				}
				if (worldIn.getBlockState(getPos(room2, i, j, 2)) == BlockInit.FROZ_STONE.getDefaultState()) {
					worldIn.setBlockState(getPos(room2, i, j, 2), BlockInit.BRICK_FROZ.getDefaultState());
				}
			}
		}
	}

	private BlockPos getPos(BlockPos pos, int x, int y, int z) {
		return new BlockPos(pos.getX() + x, pos.getY() + y, pos.getZ() + z);
	}

	private void fillRoom(World worldIn, BlockPos room, int sizeX, int sizeZ, Random rand, int height) {
		for (int i = -sizeX / 2; i < sizeX / 2; i++) {
			for (int j = -sizeZ / 2; j < sizeZ / 2; j++) {
				if (rand.nextBoolean()) {
					makePillar(worldIn, room.add(i, 0, j), rand, height);
				}
			}
		}
		for (int i = -sizeX / 2; i < sizeX / 2; i++) {
			for (int j = -sizeZ / 2; j < sizeZ / 2; j++) {
				if (rand.nextBoolean()) {
					makePillar(worldIn, room.add(i, 0, j), rand, height);

					if (rand.nextInt(20) == 0)
						makeCrate(worldIn, room.add(i, 0, j), rand);
				}
			}
		}
	}

	private void makePillar(World worldIn, BlockPos pos, Random rand, int height) {
		boolean can = true;
		for (int i = -3; i < 5; i++) {
			for (int j = -3; j < 5; j++) {
				for (int k = 0; k < height; k++) {
					if (worldIn.getBlockState(pos.add(i, k, j)) != Blocks.AIR.getDefaultState()) {
						can = false;
					}
				}
			}
		}
		if (can) {
			for (int i = 0; i < 2; i++) {
				for (int j = 0; j < 2; j++) {
					for (int k = 0; k < height; k++) {
						if (k == 2 || k == 3) {
							if (rand.nextInt(10) == 0) {
								worldIn.setBlockState(pos.add(i, k, j), Blocks.MOB_SPAWNER.getDefaultState());
								TileEntityMobSpawner spawner = (TileEntityMobSpawner) worldIn
										.getTileEntity(pos.add(i, k, j));
								if (rand.nextBoolean())
									spawner.getSpawnerBaseLogic()
											.setEntityId(EntityList.getKey(EntityAngrySnowGolemRange.class));
								else
									spawner.getSpawnerBaseLogic()
											.setEntityId(EntityList.getKey(EntityAngrySnowGolemSoldier.class));
							} else {
								placeStoneBrick(worldIn, pos.add(i, k, j), rand);
							}
						} else {

							placeStoneBrick(worldIn, pos.add(i, k, j), rand);
						}

					}
				}
			}
		}
	}

	private void makeCrate(World worldIn, BlockPos pos, Random rand) {
		boolean can = true;
		for (int x = -1; x < 2; x++) {
			for (int z = -1; z < 2; z++) {
				for (int y = 0; y < 2; y++) {

					if (worldIn.getBlockState(pos.add(x, y, z)) != Blocks.AIR.getDefaultState()) {
						can = false;
					}
				}
			}
		}
		if (can) {
			int size = rand.nextInt(2) + 1;
			for (int i = 0; i < size; i++) {
				worldIn.setBlockState(pos.add(0, i, 0), BlockInit.FROZ_CRATE.getDefaultState());
			}
			if (rand.nextInt(3) == 0)
				worldIn.setBlockState(pos.add(1, 0, 0), BlockInit.FROZ_CRATE.getDefaultState());
			if (rand.nextInt(3) == 0)
				worldIn.setBlockState(pos.add(-1, 0, 0), BlockInit.FROZ_CRATE.getDefaultState());
			if (rand.nextInt(3) == 0)
				worldIn.setBlockState(pos.add(0, 0, 1), BlockInit.FROZ_CRATE.getDefaultState());
			if (rand.nextInt(3) == 0)
				worldIn.setBlockState(pos.add(0, 0, -1), BlockInit.FROZ_CRATE.getDefaultState());
		}
	}

	private void placeChest(World worldIn, BlockPos pos, Random rand) {

		for (int i = -1; i < 2; i++) {
			for (int j = -1; j < 2; j++) {
				for (int k = 0; k < 6; k++) {
					if (i != 0 || j != 0)
						worldIn.setBlockState(pos.add(i, k, j), Blocks.STAINED_GLASS_PANE.getStateFromMeta(11));
				}
			}
		}

		worldIn.setBlockState(pos.down(), Blocks.LAPIS_BLOCK.getDefaultState());
		worldIn.setBlockState(pos, Blocks.CHEST.getDefaultState());
		worldIn.setBlockState(pos.up(6), Blocks.GLOWSTONE.getDefaultState());
		TileEntityChest chest = (TileEntityChest) worldIn.getTileEntity(pos);
		chest.setInventorySlotContents(4, new ItemStack(Items.EMERALD, 1));
		chest.setInventorySlotContents(10, new ItemStack(Items.DIAMOND, 1));
		chest.setInventorySlotContents(11, new ItemStack(Items.DIAMOND, 1));
		chest.setInventorySlotContents(12, new ItemStack(Items.EMERALD, 1));
		chest.setInventorySlotContents(13, new ItemStack(ItemInit.FROZ_KEY, 1));
		chest.setInventorySlotContents(14, new ItemStack(Items.EMERALD, 1));
		chest.setInventorySlotContents(15, new ItemStack(Items.DIAMOND, 1));
		chest.setInventorySlotContents(16, new ItemStack(Items.DIAMOND, 1));
		chest.setInventorySlotContents(22, new ItemStack(Items.EMERALD, 1));

	}

	private void genChest(World worldIn, Random rand) {
		int nb = 0;
		int ra = 0;
		while (nb < 3) {
			ra = rand.nextInt(size - 1) + 1;
			if (worldIn.getBlockState(roomList[ra].down()) != Blocks.LAPIS_BLOCK.getDefaultState()) {
				placeChest(worldIn, roomList[ra], rand);
				nb += 1;

			}
		}
	}
}
