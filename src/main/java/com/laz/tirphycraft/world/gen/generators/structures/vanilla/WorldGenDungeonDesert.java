package com.laz.tirphycraft.world.gen.generators.structures.vanilla;

import java.util.Random;

import com.laz.tirphycraft.util.Reference;
import com.laz.tirphycraft.util.interfaces.IStructure;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraft.world.gen.structure.template.Template;
import net.minecraft.world.gen.structure.template.TemplateManager;

public class WorldGenDungeonDesert extends WorldGenerator implements IStructure {
	public String structureName;

	public WorldGenDungeonDesert(String name) {
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
				BlockPos down = pos.add(i, -1+18, j);
				Block b = world.getBlockState(down).getBlock();
				if (!b.equals(Blocks.SAND)) {
					flag = false;
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

		}
	}
}
