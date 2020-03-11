package com.laz.tirphycraft.init;

import java.util.ArrayList;
import java.util.List;

import com.laz.tirphycraft.gosyn.common.world.biomes.stage1.biomeFlory.BiomeFlory;
import com.laz.tirphycraft.gosyn.common.world.biomes.stage1.biomeMelynchForest.BiomeMelynchForest;
import com.laz.tirphycraft.gosyn.common.world.biomes.stage1.biomeWetLands.BiomeWetlands;
import com.laz.tirphycraft.gosyn.common.world.biomes.stage2.MagicForest.BiomeMagicForest;
import com.laz.tirphycraft.gosyn.common.world.biomes.stage2.Mushrooom.BiomeMushrooom;
import com.laz.tirphycraft.gosyn.common.world.biomes.stage2.RootForest.BiomeRootForest;
import com.laz.tirphycraft.gosyn.common.world.biomes.stage3.BiomeDarkForest;
import com.laz.tirphycraft.util.handlers.ConfigHandler;
import com.laz.tirphycraft.world.biomes.froz.BiomeFrozDead;
import com.laz.tirphycraft.world.biomes.froz.BiomeFrozDense;
import com.laz.tirphycraft.world.biomes.froz.BiomeFrozEternal;
import com.laz.tirphycraft.world.biomes.froz.BiomeFrozForest;
import com.laz.tirphycraft.world.biomes.froz.BiomeFrozGiantForest;
import com.laz.tirphycraft.world.biomes.froz.BiomeFrozIceMontain;
import com.laz.tirphycraft.world.biomes.froz.BiomeFrozMontain;
import com.laz.tirphycraft.world.biomes.froz.BiomeFrozPlaine;
import com.laz.tirphycraft.world.biomes.froz.BiomeFrozPlate;
import com.laz.tirphycraft.world.biomes.froz.BiomeFrozSlawomirBurrows;
import com.laz.tirphycraft.world.biomes.laputa.BiomeLaputaCrystal;
import com.laz.tirphycraft.world.biomes.laputa.BiomeLaputaForest;
import com.laz.tirphycraft.world.biomes.laputa.BiomeLaputaMagic;
import com.laz.tirphycraft.world.biomes.laputa.BiomeLaputaMeteorite;
import com.laz.tirphycraft.world.biomes.laputa.BiomeLaputaNoManLand;
import com.laz.tirphycraft.world.biomes.laputa.BiomeLaputaRainbow;
import com.laz.tirphycraft.world.biomes.noxis.BiomeNoxis;

import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.common.BiomeManager.BiomeEntry;
import net.minecraftforge.common.BiomeManager.BiomeType;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

public class BiomeInit 
{
	public static final Biome NOXIS				= new BiomeNoxis();
	
	public static final Biome LAPUTA			= new BiomeLaputaForest();	
	public static final Biome LAPUTANML			= new BiomeLaputaNoManLand();
	public static final Biome LAPUTA_MAGIC		= new BiomeLaputaMagic();
	public static final Biome LAPUTA_METEORITE	= new BiomeLaputaMeteorite();
	public static final Biome LAPUTA_CRYSTAL	= new BiomeLaputaCrystal();
	public static final Biome LAPUTA_RAINBOW	= new BiomeLaputaRainbow();
	
	
	public static final Biome FROZ_PLAINE		= new BiomeFrozPlaine();
	public static final Biome FROZ_DENSE 		= new BiomeFrozDense();
	public static final Biome FROZ_MONTAIN		= new BiomeFrozMontain();
	public static final Biome FROZ_ICE_MONTAIN	= new BiomeFrozIceMontain();
	public static final Biome FROZ_ETERNAL		= new BiomeFrozEternal();
	public static final Biome FROZ_FOREST		= new BiomeFrozForest();
	public static final Biome FROZ_DEAD			= new BiomeFrozDead();
	public static final Biome FROZ_PLATE 		= new BiomeFrozPlate();
	public static final Biome FROZ_SLAWOMIR     = new BiomeFrozSlawomirBurrows();
	public static final Biome FROZ_GEANT		= new BiomeFrozGiantForest();
	
	public static final Biome FLORY 		 = new BiomeFlory();
	public static final Biome WET_LANDS 	 = new BiomeWetlands();
	public static final Biome MELYNCH_FOREST = new BiomeMelynchForest();
	
	public static final Biome MAGIC_FOREST = new BiomeMagicForest();
	public static final Biome MUSHROOOM    = new BiomeMushrooom();
	public static final Biome ROOT_FOREST  = new BiomeRootForest();
	
	public static final Biome DARK_FOREST = new BiomeDarkForest();

	public static final List<Biome> biomesSpawn = new ArrayList<>();
	
	public static void registerBiomes()
	{
		initBiomeNoOverworld(NOXIS, "Noxis Small Hills", BiomeType.WARM, Type.HILLS, Type.MOUNTAIN, Type.DRY);
		
		initBiomeNoOverworld(LAPUTA, "Laputa forest", BiomeType.COOL, Type.DENSE, Type.PLAINS);
		initBiomeNoOverworld(LAPUTANML, "Laputa no man land", BiomeType.COOL, Type.DENSE, Type.PLAINS);
		initBiomeNoOverworld(LAPUTA_MAGIC, "Laputa magic", BiomeType.COOL, Type.DENSE, Type.PLAINS);
		initBiomeNoOverworld(LAPUTA_METEORITE, "laputa meteorite",  BiomeType.DESERT, Type.DENSE, Type.HOT);
		initBiomeNoOverworld(LAPUTA_CRYSTAL, "laputa crystal",  BiomeType.COOL, Type.DENSE, Type.PLAINS);
		initBiomeNoOverworld(LAPUTA_RAINBOW, "laputa rainbow",  BiomeType.COOL, Type.DENSE, Type.PLAINS);
		
		initBiomeNoOverworld(FROZ_PLAINE, "froz plaine", BiomeType.ICY, Type.COLD, Type.PLAINS);
		initBiomeNoOverworld(FROZ_DENSE, "froz dense", BiomeType.ICY, Type.COLD, Type.DENSE);
		initBiomeNoOverworld(FROZ_MONTAIN, "froz montain", BiomeType.ICY, Type.COLD, Type.DENSE);
		initBiomeNoOverworld(FROZ_ICE_MONTAIN, "froz ice montain", BiomeType.ICY, Type.COLD, Type.DENSE);
		initBiomeNoOverworld(FROZ_ETERNAL, "froz eternal", BiomeType.ICY, Type.COLD, Type.DEAD);
		initBiomeNoOverworld(FROZ_FOREST, "froz forest",  BiomeType.ICY, Type.COLD, Type.DENSE);
		initBiomeNoOverworld(FROZ_DEAD, "froz dead",  BiomeType.ICY, Type.COLD, Type.DENSE);
		initBiomeNoOverworld(FROZ_PLATE, "froz plate",  BiomeType.ICY, Type.COLD, Type.DENSE);
		initBiomeNoOverworld(FROZ_SLAWOMIR, "froz Slawomir Burrows",  BiomeType.ICY, Type.COLD, Type.DENSE, Type.RARE);
		initBiomeNoOverworld(FROZ_GEANT, "froz geant forest",  BiomeType.ICY, Type.COLD, Type.DENSE, Type.RARE);
		
		initBiomeNoOverworld(FLORY, "Flory", BiomeType.COOL, Type.PLAINS, Type.RARE);
		initBiomeNoOverworld(WET_LANDS, "Wet Lands", BiomeType.WARM, Type.SWAMP, Type.RARE);
		initBiomeNoOverworld(MELYNCH_FOREST, "Melynch Forest", BiomeType.WARM, Type.FOREST, Type.RARE);
		
		initBiomeNoOverworld(MAGIC_FOREST, "Magic Forest", BiomeType.WARM, Type.FOREST, Type.RARE);
		initBiomeNoOverworld(MUSHROOOM, "Mushrooom", BiomeType.COOL, Type.FOREST, Type.RARE);
		initBiomeNoOverworld(ROOT_FOREST, "Root Forest", BiomeType.COOL, Type.PLAINS, Type.RARE);
	
		initBiomeNoOverworld(DARK_FOREST, "Dark Forest", BiomeType.WARM, Type.FOREST, Type.RARE);
		
		biomesSpawn.add(FLORY);
		biomesSpawn.add(WET_LANDS);
		biomesSpawn.add(MELYNCH_FOREST);
		
} 
	
	private static Biome initBiomeNoOverworld(Biome biome, String name, BiomeType biomeType, Type... types)
	{
		biome.setRegistryName(name);
		ForgeRegistries.BIOMES.register(biome);
		System.out.println("Biome Register " + name);
		BiomeDictionary.addTypes(biome, types);
		BiomeManager.addSpawnBiome(biome);	
		System.out.println("Biome added " + name);		
		return biome;
	}

	private static Biome initBiomeOverworld(Biome biome, String name, BiomeType biomeType, Type... types)
	{
		biome.setRegistryName(name);
		ForgeRegistries.BIOMES.register(biome);
		System.out.println("Biome Register " + name);
		BiomeDictionary.addTypes(biome, types);
		BiomeManager.addSpawnBiome(biome);	
		if (ConfigHandler.SPAWN_BIOMES_OVERWORLD) BiomeManager.addBiome(biomeType, new BiomeEntry(biome, 0));
			
		System.out.println("Biome added " + name);		
		return biome;
	}	
	
}