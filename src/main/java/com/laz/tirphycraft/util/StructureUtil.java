package com.laz.tirphycraft.util;

import java.util.Random;

import com.laz.tirphycraft.util.interfaces.IStructure;

import net.minecraft.server.MinecraftServer;
import net.minecraft.util.Mirror;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.structure.template.PlacementSettings;
import net.minecraft.world.gen.structure.template.Template;
import net.minecraft.world.gen.structure.template.TemplateManager;

public class StructureUtil implements IStructure {

	Template temp;
	
	public void placeGood(ResourceLocation template, World worldIn, PlacementSettings settings, BlockPos pos, Random rand,
			MinecraftServer mcServer, TemplateManager manager) {
	
		temp = manager.get(mcServer, template);
		
		int sizeX = (int) temp.getSize().getX() / 2;
		int sizeZ = (int) temp.getSize().getZ() / 2;

		BlockPos newPos = pos.add(-sizeX, -1, -sizeZ);
		Rotation r = pickRotion(rand);
		temp.addBlocksToWorldChunk(worldIn, temp.getZeroPositionWithTransform(newPos, Mirror.NONE, r), settings.setRotation(r));
	}

	public Rotation pickRotion(Random rand) {
		int i = rand.nextInt(4);
		if (i == 0)
			return Rotation.CLOCKWISE_180;
		if (i == 1)
			return Rotation.CLOCKWISE_90;
		if (i == 2)
			return Rotation.COUNTERCLOCKWISE_90;
		else
			return Rotation.NONE;
	}

	public void fillUnder(World worldIn) {

	}
	
}
