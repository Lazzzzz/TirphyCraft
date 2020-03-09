package com.laz.tirphycraft.world.gen.generators.structures.froz;

import java.util.Random;

import com.laz.tirphycraft.init.BlockInit;
import com.laz.tirphycraft.util.Reference;
import com.laz.tirphycraft.util.interfaces.IStructure;

import net.minecraft.block.state.IBlockState;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraft.world.gen.structure.template.Template;
import net.minecraft.world.gen.structure.template.TemplateManager;

public class WorldGenFrozSmallDungeon extends WorldGenerator implements IStructure {

	ResourceLocation data_main = new ResourceLocation(Reference.MOD_ID, "froz/ruins/data_main");
	ResourceLocation data_00 = new ResourceLocation(Reference.MOD_ID, "froz/ruins/data_00");
	ResourceLocation data_01 = new ResourceLocation(Reference.MOD_ID, "froz/ruins/data_01");
	ResourceLocation data_02 = new ResourceLocation(Reference.MOD_ID, "froz/ruins/data_02");
	ResourceLocation data_03 = new ResourceLocation(Reference.MOD_ID, "froz/ruins/data_03");

	private boolean checkForSawn(World world, BlockPos pos) {
		for (int i = 0; i < 16; i++) {
			for (int j = 0; j < 16; j++) {
				if (!world.getBlockState(pos.add(i, -1, j)).isFullBlock()) {
					System.out.println(pos.add(i, -1, j));
					return false;
				}
			}
		}
		for (int i = -100; i < 100; i++) {
			for (int j = -100; j < 100; j++) {
				for (int k = -10; k < 10; k++) {
					if (world.getBlockState(pos.add(i, k, j)).getBlock() == BlockInit.FROZ_BLUE_BRICK) {
						return false;
					}
				}
			}
		}
		return true;
	}

	public void generateStructure(World world, BlockPos pos, Random rand) {
		MinecraftServer mcServer = world.getMinecraftServer();
		TemplateManager manager = worldServer.getStructureTemplateManager();

		Template main = manager.get(mcServer, data_main);
		Template d00 = manager.get(mcServer, data_00);
		Template d01 = manager.get(mcServer, data_01);
		Template d02 = manager.get(mcServer, data_02);
		Template d03 = manager.get(mcServer, data_03);

		boolean canPlace = checkForSawn(world, pos);

		if (canPlace) {
			IBlockState state = world.getBlockState(pos);
			world.notifyBlockUpdate(pos.add(0, -5, 0), state, state, 3);
			world.notifyBlockUpdate(pos.add(-16, -5, 0), state, state, 3);
			world.notifyBlockUpdate(pos.add(7, -5, 16), state, state, 3);
			world.notifyBlockUpdate(pos.add(16, -5, 0), state, state, 3);
			world.notifyBlockUpdate(pos.add(0, -5, -16), state, state, 3);
			main.addBlocksToWorldChunk(world, pos.add(0, -5, 0), settings.setRotation(Rotation.NONE));
			d00.addBlocksToWorldChunk(world, pos.add(-16, -5, 0), settings.setRotation(Rotation.NONE));
			d01.addBlocksToWorldChunk(world, pos.add(-7, -5, 16), settings.setRotation(Rotation.NONE));
			d02.addBlocksToWorldChunk(world, pos.add(16, -5, 0), settings.setRotation(Rotation.NONE));
			d03.addBlocksToWorldChunk(world, pos.add(0, -5, -16), settings.setRotation(Rotation.NONE));

		}
	}

	@Override
	public boolean generate(World worldIn, Random rand, BlockPos position) {
		generateStructure(worldIn, position, rand);
		return true;
	}

	private void replaceToIce(Template template, World world, BlockPos pos, Random rand) {
		int sizeX = (int) template.getSize().getX() / 2;
		int sizeZ = (int) template.getSize().getZ() / 2;

		BlockPos newPos = pos.add(-sizeX, -1, -sizeZ);

		for (int x = 0; x < template.getSize().getX(); x++) {
			for (int z = 0; z < template.getSize().getZ(); z++) {
				for (int y = 0; y < template.getSize().getY(); y++) {
					if (rand.nextInt(3) == 0
							&& world.getBlockState(newPos.add(x, y, z)).getBlock() == BlockInit.FROZ_BLUE_BRICK) {
						world.setBlockState(newPos.add(x, y, z),
								BlockInit.FROZ_BLUE_BRICK.getStateFromMeta(rand.nextInt(4) + 7));
					}

				}
			}
		}
	}
}
