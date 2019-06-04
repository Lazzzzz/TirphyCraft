package com.laz.tirphycraft.init;

import com.laz.tirphycraft.util.Reference;
import com.laz.tirphycraft.util.handlers.ConfigHandler;
import com.laz.tirphycraft.world.dimensionFroz.DimensionLibraryFroz;
import com.laz.tirphycraft.world.dimensionLaputa.DimensionLibraryLaputa;
import com.laz.tirphycraft.world.dimensionsNoxis.DimensionLibraryNoxis;

import net.minecraft.world.DimensionType;
import net.minecraftforge.common.DimensionManager;

public class DimensionInit {
	public static final DimensionType NOXIS  = DimensionType.register("Noxis", "_noxis", ConfigHandler.DIMENSION_NOXIS_ID, DimensionLibraryNoxis.class, false);
	public static final DimensionType LAPUTA = DimensionType.register("Laputa", "_laputa", ConfigHandler.DIMENSION_LAPUTA_ID, DimensionLibraryLaputa.class, false);
	public static final DimensionType FROZ   = DimensionType.register("Froz", "_froz", ConfigHandler.DIMENSION_FROZ_ID, DimensionLibraryFroz.class, false);
	
	public static void registerDimensions()
	{
		DimensionManager.registerDimension(ConfigHandler.DIMENSION_NOXIS_ID, NOXIS);
		DimensionManager.registerDimension(ConfigHandler.DIMENSION_LAPUTA_ID, LAPUTA);
		DimensionManager.registerDimension(ConfigHandler.DIMENSION_FROZ_ID, FROZ);
	}
}