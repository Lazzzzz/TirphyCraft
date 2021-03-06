package com.laz.tirphycraft.world.gen.generators.froz;

import java.util.Random;

import com.laz.tirphycraft.util.Reference;
import com.laz.tirphycraft.util.StructureUtil;
import com.laz.tirphycraft.util.interfaces.IStructure;

import net.minecraft.init.Blocks;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraft.world.gen.structure.template.TemplateManager;

public class WorldGenIceVillage extends WorldGenerator implements IStructure {

	ResourceLocation[] resource = new ResourceLocation[] {
			new ResourceLocation(Reference.MOD_ID, "froz/village/village_littlehouse_1"),
			new ResourceLocation(Reference.MOD_ID, "froz/village/village_littlehouse_2"),
			new ResourceLocation(Reference.MOD_ID, "froz/village/village_house_1"),
			new ResourceLocation(Reference.MOD_ID, "froz/village/village_tower"),
			new ResourceLocation(Reference.MOD_ID, "froz/village/village_plantation"),
			new ResourceLocation(Reference.MOD_ID, "froz/village/village_camp") };
	StructureUtil util = new StructureUtil();

	int nb_structure;

	public boolean generate(World worldIn, Random rand, BlockPos position) {

		if (!checkSpace(worldIn, rand, position, 20))
			return false;

		nb_structure = rand.nextInt(8) + 5;

		TemplateManager manager = worldServer.getStructureTemplateManager();
		MinecraftServer mcServer = worldIn.getMinecraftServer();

		util.placeGood(resource[5], worldIn, settings, position, rand, mcServer, manager);

		for (int i = 0; i < nb_structure; i++) {
			int x = rand.nextInt(20) - 20;
			int z = rand.nextInt(20) - 20;
			BlockPos pos = position.add(x, 0, z);

			if (checkSpaceForBuild(worldIn, rand, pos, 5)) {
				util.placeGood(resource[rand.nextInt(5)], worldIn, settings, worldIn.getHeight(pos), rand, mcServer,
						manager);

			}
		}

		return false;
	}

	public boolean checkSpace(World worldIn, Random rand, BlockPos position, int size) {
		for (int i = -size; i < size; i++) {
			for (int j = -size; j < size; j++) {
				if (worldIn.getBlockState(position.add(i, -3, j)) == Blocks.AIR.getDefaultState())
					return false;
			}
		}

		return true;
	}

	public boolean checkSpaceForBuild(World worldIn, Random rand, BlockPos position, int size) {
		for (int i = -size; i < size; i++) {
			for (int j = -size; j < size; j++) {
				if (worldIn.getBlockState(position.add(i, 2, j)) != Blocks.AIR.getDefaultState())
					return false;
			}
		}

		return true;
	}

}
