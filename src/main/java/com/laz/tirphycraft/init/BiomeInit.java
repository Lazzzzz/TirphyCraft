package com.laz.tirphycraft.init;

import com.laz.tirphycraft.util.Reference;
import com.laz.tirphycraft.util.handlers.ConfigHandler;
import com.laz.tirphycraft.world.biomes.froz.BiomeFrozDense;
import com.laz.tirphycraft.world.biomes.froz.BiomeFrozMontain;
import com.laz.tirphycraft.world.biomes.froz.BiomeFrozPlaine;
import com.laz.tirphycraft.world.biomes.laputa.BiomeLaputaCrystal;
import com.laz.tirphycraft.world.biomes.laputa.BiomeLaputaForest;
import com.laz.tirphycraft.world.biomes.laputa.BiomeLaputaMagic;
import com.laz.tirphycraft.world.biomes.laputa.BiomeLaputaNoManLand;
import com.laz.tirphycraft.world.biomes.noxis.BiomeBigForestNoxis;
import com.laz.tirphycraft.world.biomes.noxis.BiomeForestNoxis;
import com.laz.tirphycraft.world.biomes.noxis.BiomeFrozenNoxis;
import com.laz.tirphycraft.world.biomes.noxis.BiomeHillsNoxis;
import com.laz.tirphycraft.world.biomes.noxis.BiomeLacNoxis;
import com.laz.tirphycraft.world.biomes.noxis.BiomeMushroomNoxis;
import com.laz.tirphycraft.world.biomes.noxis.BiomeRockNoxis;
import com.laz.tirphycraft.world.biomes.noxis.BiomeSmallHillsNoxis;

import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.common.BiomeManager.BiomeEntry;
import net.minecraftforge.common.BiomeManager.BiomeType;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

public class BiomeInit 
{
	public static final Biome NOXIS 			= new BiomeForestNoxis();
	public static final Biome NOXIS_HILLS		= new BiomeHillsNoxis();
	public static final Biome NOXIS_LAC			= new BiomeLacNoxis();
	public static final Biome NOXIS_ICE			= new BiomeFrozenNoxis();
	public static final Biome NOXIS_S_HILLS		= new BiomeSmallHillsNoxis();
	public static final Biome NOXIS_BIG_FOREST	= new BiomeBigForestNoxis();
	public static final Biome NOXIS_MUSHROOM    = new BiomeMushroomNoxis();
	public static final Biome NOXIS_ROCK		= new BiomeRockNoxis();
	
	
	public static final Biome LAPUTA			= new BiomeLaputaForest();	
	public static final Biome LAPUTANML			= new BiomeLaputaNoManLand();
	public static final Biome LAPUTA_MAGIC		= new BiomeLaputaMagic();
	public static final Biome LAPUTA_CRYSTAL	= new BiomeLaputaCrystal();
	
	
	public static final Biome FROZ_PLAINE		= new BiomeFrozPlaine();
	public static final Biome FROZ_DENSE 		= new BiomeFrozDense();
	public static final Biome FROZ_MONTAIN		= new BiomeFrozMontain();
	
	public static void registerBiomes()
	{
		initBiomeNoOverworld(NOXIS, "Noxis Forest",BiomeType.WARM, Type.PLAINS, Type.DRY);
		initBiomeNoOverworld(NOXIS_HILLS, "Noxis Hills", BiomeType.WARM, Type.HILLS, Type.MOUNTAIN, Type.DRY);		
		initBiomeNoOverworld(NOXIS_LAC, "Noxis Lac", BiomeType.COOL, Type.OCEAN, Type.DRY);	
		initBiomeNoOverworld(NOXIS_ICE, "Noxis Ice", BiomeType.COOL, Type.PLAINS);
		initBiomeNoOverworld(NOXIS_S_HILLS, "Noxis Small Hills", BiomeType.WARM, Type.HILLS, Type.MOUNTAIN, Type.DRY);
		initBiomeNoOverworld(NOXIS_BIG_FOREST, "Noxis Big Forest" ,BiomeType.WARM, Type.PLAINS, Type.DRY);
		initBiomeNoOverworld(NOXIS_MUSHROOM, "Noxis Mushroom" ,BiomeType.WARM, Type.PLAINS, Type.DRY);
		initBiomeNoOverworld(NOXIS_ROCK, "Noxis Rock", BiomeType.DESERT, Type.DRY);
		
		initBiomeNoOverworld(LAPUTA, "Laputa forest", BiomeType.COOL, Type.DENSE, Type.PLAINS);
		initBiomeNoOverworld(LAPUTANML, "Laputa no man land", BiomeType.COOL, Type.DENSE, Type.PLAINS);
		initBiomeNoOverworld(LAPUTA_MAGIC, "Laputa magic", BiomeType.COOL, Type.DENSE, Type.PLAINS);
		initBiomeNoOverworld(LAPUTA_CRYSTAL, "laputa crystal",  BiomeType.COOL, Type.DENSE, Type.PLAINS);
		
		initBiomeNoOverworld(FROZ_PLAINE, "froz plaine", BiomeType.ICY, Type.COLD, Type.PLAINS);
		initBiomeNoOverworld(FROZ_DENSE, "froz dense", BiomeType.ICY, Type.COLD, Type.DENSE);
		initBiomeNoOverworld(FROZ_MONTAIN, "froz montain", BiomeType.ICY, Type.COLD, Type.DENSE);
		
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