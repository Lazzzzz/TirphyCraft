package com.laz.tirphycraft.init;

import com.laz.tirphycraft.dimension.Froz.DimensionLibraryFroz;
import com.laz.tirphycraft.dimension.Gosyn.DimensionLibraryGosyn;
import com.laz.tirphycraft.dimension.Laputa.DimensionLibraryLaputa;
import com.laz.tirphycraft.dimension.Noxis.DimensionLibraryNoxis;
import com.laz.tirphycraft.util.handlers.ConfigHandler;

import net.minecraft.world.DimensionType;
import net.minecraftforge.common.DimensionManager;

public class DimensionInit {
	public static final DimensionType NOXIS  = DimensionType.register("Noxis", "_noxis", ConfigHandler.DIMENSION_NOXIS_ID, DimensionLibraryNoxis.class, false);
	public static final DimensionType LAPUTA = DimensionType.register("Laputa", "_laputa", ConfigHandler.DIMENSION_LAPUTA_ID, DimensionLibraryLaputa.class, false);
	public static final DimensionType GOSYN  = DimensionType.register("Gosyn", "_gosyn", ConfigHandler.DIMENSION_GOSYN_ID, DimensionLibraryGosyn.class, false);
	public static final DimensionType FROZ   = DimensionType.register("Froz", "_froz", ConfigHandler.DIMENSION_FROZ_ID, DimensionLibraryFroz.class, false);

	public static void registerDimensions()
	{
		DimensionManager.registerDimension(ConfigHandler.DIMENSION_NOXIS_ID, NOXIS);
		DimensionManager.registerDimension(ConfigHandler.DIMENSION_LAPUTA_ID, LAPUTA);
		DimensionManager.registerDimension(ConfigHandler.DIMENSION_FROZ_ID, FROZ);
		DimensionManager.registerDimension(ConfigHandler.DIMENSION_GOSYN_ID, GOSYN);
	}
}