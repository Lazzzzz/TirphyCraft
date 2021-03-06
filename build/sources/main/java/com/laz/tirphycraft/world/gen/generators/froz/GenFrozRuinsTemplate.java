package com.laz.tirphycraft.world.gen.generators.froz;

import java.util.Random;

import com.laz.tirphycraft.init.BlockInit;
import com.laz.tirphycraft.util.Reference;
import com.laz.tirphycraft.util.StructureUtil;
import com.laz.tirphycraft.util.interfaces.IStructure;

import net.minecraft.block.state.IBlockState;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraft.world.gen.structure.template.Template;
import net.minecraft.world.gen.structure.template.TemplateManager;

public class GenFrozRuinsTemplate extends WorldGenerator implements IStructure {
	public String structureName;
	StructureUtil util = new StructureUtil();

	public GenFrozRuinsTemplate(String name) {
		this.structureName = name;
	}

	private boolean checkForSawn(Template template, World world, BlockPos pos) {
		for (int x = 0; x < template.getSize().getX(); x++) {
			for (int z = 0; z < template.getSize().getZ(); z++) {
				for (int y = 0; y < template.getSize().getY(); y++) {
					if (!world.getBlockState(pos.add(x, -1, z)).isFullBlock()
							|| world.getBlockState(pos.add(x, y, z)).isFullBlock()) {
						return false;
					}
				}
			}
		}

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

	public void generateStructure(World world, BlockPos pos, Random rand) {
		MinecraftServer mcServer = world.getMinecraftServer();
		TemplateManager manager = worldServer.getStructureTemplateManager();
		ResourceLocation location = new ResourceLocation(Reference.MOD_ID, "froz/ruins/" + structureName);
		Template template = manager.get(mcServer, location);

		boolean canPlace = checkForSawn(template, world, pos);

		if (canPlace) {
			IBlockState state = world.getBlockState(pos);
			world.notifyBlockUpdate(pos, state, state, 3);
			util.placeGood(location, world, settings, pos, rand, mcServer, manager);
			replaceToIce(template, world, pos, rand);

		}
	}

	@Override
	public boolean generate(World worldIn, Random rand, BlockPos position) {
		generateStructure(worldIn, position, rand);
		return true;
	}
}