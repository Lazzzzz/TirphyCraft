package com.laz.tirphycraft.world.gen.generators.structures.laputa;

import java.util.Random;

import com.laz.tirphycraft.init.BlockInit;
import com.laz.tirphycraft.util.Reference;
import com.laz.tirphycraft.util.handlers.LootTableHandler;
import com.laz.tirphycraft.util.interfaces.IStructure;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.server.MinecraftServer;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraft.world.gen.structure.template.Template;
import net.minecraft.world.gen.structure.template.TemplateManager;

public class WorldGenDungeonGroundTier2 extends WorldGenerator implements IStructure {
	public String structureName;

	public WorldGenDungeonGroundTier2(String name) {
		this.structureName = name;
	}

	@Override
	public boolean generate(World worldIn, Random rand, BlockPos position) {
		this.generateStructure(worldIn, position);
		return true;
	}

	private boolean checkForSawn(Template template, World world, BlockPos pos) {
		boolean flag = true;

		for (int i = 0; i < template.getSize().getX(); i++) {
			for (int j = 0; j < template.getSize().getZ(); j++) {
				BlockPos down = pos.add(i, -1, j);
				Block b = world.getBlockState(down).getBlock();
				if (!b.equals(BlockInit.LAPUTA_DIRT)) {
					flag = false;
				}

			}
		}

		for (int i2 = 0; i2 < template.getSize().getX(); i2++) {
			for (int k = 2; k < template.getSize().getY(); k++) {
				for (int j2 = 0; j2 < template.getSize().getZ(); j2++) {
					BlockPos down = pos.add(i2, k, j2);
					Block b = world.getBlockState(down).getBlock();
					if (!b.equals(Blocks.AIR)) {
						flag = false;

					}
				}
			}
		}
		return flag;
	}

	public void generateStructure(World world, BlockPos pos) {
		MinecraftServer mcServer = world.getMinecraftServer();
		TemplateManager manager = worldServer.getStructureTemplateManager();
		ResourceLocation location = new ResourceLocation(Reference.MOD_ID, structureName);
		Template template = manager.get(mcServer, location);

		int x2 = (template.getSize().getX());
		int y2 = (template.getSize().getY());
		int z2 = (template.getSize().getZ());

		boolean canPlace = checkForSawn(template, world, pos);
		
		if (canPlace) {
			IBlockState state = world.getBlockState(pos);
			world.notifyBlockUpdate(pos, state, state, 3);
			template.addBlocksToWorldChunk(world, pos, settings.setRotation(Rotation.NONE));

			for (int x = 0; x <= template.getSize().getX(); x++) {

				for (int y = 0; y <= template.getSize().getY(); y++) {

					for (int z = 0; z <= template.getSize().getZ(); z++) {

						BlockPos tmp = new BlockPos(pos.getX() + x, pos.getY() + y, pos.getZ() + z);

						if (world.getTileEntity(tmp) != null) {

							if (world.getTileEntity(tmp) instanceof TileEntityChest) {
								TileEntityChest chest = (TileEntityChest) world.getTileEntity(tmp);
								chest.setLootTable(LootTableHandler.CHEST_DUNGEONS_TIER_1,
										new Random().nextLong());
							}
						}
					}
				}
			}
		}
	}
}
