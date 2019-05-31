package com.laz.tirphycraft.compat;

import com.laz.tirphycraft.init.BlockInit;

import net.minecraftforge.oredict.OreDictionary;

public class OreDictionnarCompat {
	
	public static void registerOres() {
		OreDictionary.registerOre("planks", BlockInit.PLANKS_COPPIR);
		OreDictionary.registerOre("planks", BlockInit.PLANKS_SILVIR);		
	}
}
