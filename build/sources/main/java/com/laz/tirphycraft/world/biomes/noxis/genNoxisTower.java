package com.laz.tirphycraft.world.biomes.noxis;

import com.laz.tirphycraft.util.Reference;
import com.laz.tirphycraft.util.interfaces.IStructure;

import net.minecraft.block.state.IBlockState;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.structure.template.Template;
import net.minecraft.world.gen.structure.template.TemplateManager;

public class genNoxisTower implements IStructure{

	ResourceLocation tower_down =  new ResourceLocation(Reference.MOD_ID, "tower_down");
	ResourceLocation tower_up   =  new ResourceLocation(Reference.MOD_ID, "tower_up");
	
	
	public void generator(World world, BlockPos pos) {
		MinecraftServer mcServer = world.getMinecraftServer();
		TemplateManager manager = worldServer.getStructureTemplateManager();
		Template template = manager.get(mcServer, tower_down);
		
		IBlockState state = world.getBlockState(pos);
		world.notifyBlockUpdate(pos, state, state, 3);
		template.addBlocksToWorldChunk(world, pos, settings.setRotation(Rotation.NONE));
		
		template = manager.get(mcServer, tower_up);
		
		state = world.getBlockState(pos.up(32));
		world.notifyBlockUpdate(pos.up(32), state, state, 3);
		template.addBlocksToWorldChunk(world, pos.up(32), settings.setRotation(Rotation.NONE));
	}
}
