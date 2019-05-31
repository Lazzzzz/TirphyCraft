package com.laz.tirphycraft.util.handlers;

import com.laz.tirphycraft.objects.blocks.machine.alloy.TileEntityAlloyFurnace;
import com.laz.tirphycraft.objects.blocks.machine.pyrodes.TileEntityPyrodesFurnace;
import com.laz.tirphycraft.util.Reference;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class TileEntityHandler {
	
	public static void registerTileEntities() {
		GameRegistry.registerTileEntity(TileEntityPyrodesFurnace.class,  new ResourceLocation(Reference.MOD_ID + ":pyrodes_furnace"));
		GameRegistry.registerTileEntity(TileEntityAlloyFurnace.class,  new ResourceLocation(Reference.MOD_ID + ":alloy_furnace"));
		
	}

}
