package com.laz.tirphycraft.util.handlers;

import com.laz.tirphycraft.blockTile.tesseractActivated.RenderCrystalTesseractActivated;
import com.laz.tirphycraft.blockTile.tesseractActivated.TileEntityCrystalTesseractActivated;

import net.minecraftforge.fml.client.registry.ClientRegistry;

public class TileRenderHandler {

	public static void register() {
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityCrystalTesseractActivated.class, new RenderCrystalTesseractActivated());
	}
}
