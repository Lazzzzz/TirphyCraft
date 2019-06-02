package com.laz.tirphycraft.world.gen.generators.structures.portal;

import java.util.Random;

import com.laz.tirphycraft.init.BlockInit;
import com.laz.tirphycraft.util.Reference;
import com.laz.tirphycraft.util.interfaces.IStructure;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraft.world.gen.structure.template.Template;
import net.minecraft.world.gen.structure.template.TemplateManager;

public class WorldGenPortalFroz extends WorldGenerator implements IStructure {
	public String structureName;

	public WorldGenPortalFroz(String name) {
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
				if (!b.equals(BlockInit.NOXIS_FROZEN_GRASS)) {
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

		boolean canPlace = checkForSawn(template, world, pos);
		if (canPlace) {
			System.out.println(pos);
			BlockPos pos2 = new BlockPos(pos.add(0,-1,0));
			IBlockState state = world.getBlockState(pos2);
			world.notifyBlockUpdate(pos2, state, state, 3);
			template.addBlocksToWorldChunk(world, pos2, settings.setRotation(Rotation.NONE));

		}
	}
}
