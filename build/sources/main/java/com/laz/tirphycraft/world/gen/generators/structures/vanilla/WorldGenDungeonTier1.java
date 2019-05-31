package com.laz.tirphycraft.world.gen.generators.structures.vanilla;

import java.util.Random;

import com.laz.tirphycraft.util.Reference;
import com.laz.tirphycraft.util.handlers.LootTableHandler;
import com.laz.tirphycraft.util.interfaces.IStructure;

import net.minecraft.block.state.IBlockState;
import net.minecraft.server.MinecraftServer;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraft.world.gen.structure.template.Template;
import net.minecraft.world.gen.structure.template.TemplateManager;

public class WorldGenDungeonTier1 extends WorldGenerator implements IStructure {
	public String structureName;


	public WorldGenDungeonTier1(String name) {
		this.structureName = name;
	}

	@Override
	public boolean generate(World worldIn, Random rand, BlockPos position) {
		this.generateStructure(worldIn, position);
		return true;
	}

	public void generateStructure(World world, BlockPos pos1) {
		MinecraftServer mcServer = world.getMinecraftServer();
		TemplateManager manager = worldServer.getStructureTemplateManager();
		ResourceLocation location = new ResourceLocation(Reference.MOD_ID, structureName);
		Template template = manager.get(mcServer, location);

		int x2 = (template.getSize().getX()/2);
		int z2 = (template.getSize().getZ()/2);
		
		BlockPos pos = new BlockPos(pos1.getX() - x2, pos1.getY(), pos1.getZ() - z2);

		if (template != null) {
			IBlockState state = world.getBlockState(pos);
			world.notifyBlockUpdate(pos, state, state, 3);
			int i = 0;
			if (i == 0)
				template.addBlocksToWorldChunk(world, pos, settings.setRotation(Rotation.NONE));
			
			for (int x = 0; x <= template.getSize().getX(); x++) {

				for (int y = 0; y <= template.getSize().getY(); y++) {

					for (int z = 0; z <= template.getSize().getZ(); z++) {

						BlockPos tmp = new BlockPos(pos.getX() + x, pos.getY() + y, pos.getZ() + z);

						if (world.getTileEntity(tmp) != null) {

							if (world.getTileEntity(tmp) instanceof TileEntityChest) {
								TileEntityChest chest = (TileEntityChest) world.getTileEntity(tmp);
								chest.setLootTable(LootTableHandler.CHEST_DUNGEONS_TIER_1, new Random().nextLong());
							}
						}
					}
				}
			}
		}
	}
}
