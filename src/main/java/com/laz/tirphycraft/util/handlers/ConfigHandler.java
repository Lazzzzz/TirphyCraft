package com.laz.tirphycraft.util.handlers;

import java.io.File;

import com.laz.tirphycraft.Main;
import com.laz.tirphycraft.util.Reference;

import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ConfigHandler {

	public static Configuration config;

	// TILE ENTITY
	public static int GUI_PYRODES_FURNACE = 0;
	public static int GUI_ALLOY_FURNACE = 1;

	// ENTITY
	public static int ENTITY_GUARDIAN_GOLEM = 120;
	public static int ENTITY_VIDARGAVIA = 121;
	public static int ENTITY_DRAGON_FLY = 122;
	public static int ENTITY_MONTAUK = 123;
	public static int ENTITY_FROZEN_BUFFALO = 124;
	public static int ENTITY_FROZEN_BOAR = 125;
	public static int ENTITY_BUFFALO = 126;
	public static int ENTITY_BOAR = 127;
	public static int ENTITY_PHORUS = 128;
	public static int ENTITY_TOTAM = 129;
	public static int QUEEN_CREEPER = 130;
	public static int GRINDLY_UP = 131;
	public static int GRINDLY_FRONT = 132;
	public static int GRINDLY_BOTH = 133;
	public static int CLOUDY = 134;
	public static int CERBERE = 135;
	public static int DEMON = 136;
	public static int DEAD_PLAYER = 137;
	public static int KIWI = 138;
	public static int PHARAOH = 139;
	public static int MUMMY = 140;
	public static int HELL_KING = 141;
	public static int GIANT_SPIDER = 142;
	public static int FAILED_GOLEM = 143;
	public static int HEAD_LESS = 144;
	public static int GIRIL = 145;
	public static int POSEIDON = 146;
	public static int ARTIKON = 147;
	public static int TOXIC_COW = 148;
	public static int SKULL = 149;
	public static int ENTITY_MOTHMOTH = 150;
	public static int ENTITY_LAYTURTLE = 151;
	public static int ENTITY_CRYSTIM = 152;
	public static int PRIMARY_ATTACK = 153;
	public static int PRIMARY_HEAL = 154;
	public static int PRIMARY_STRENGTH = 155;
	public static int ENTITY_STELLAR = 156;
	public static int ENTITY_COLOSSE = 157;
	public static int ENTITY_ICE_BALL = 158;
	public static int ENTITY_PLYTON = 159;
	public static int ENTITY_VELOCIRAPTOR = 160;
	public static int ENTITY_SOLDIER_SNOWGOLEM = 161;
	public static int ENTITY_RANGE_SNOWGOLEM = 162;
	public static int ENTITY_BREAKER = 163;
	public static int ENTITY_METEORITE = 164;
	
	// WORLD
	public static int DIMENSION_NOXIS_ID = 120;
	public static int DIMENSION_LAPUTA_ID = 121;
	public static int DIMENSION_GOSYN_ID = 122;
	public static int DIMENSION_FROZ_ID = 123;

	public static int MAX_PASSIF_CREATURE = 50;
	public static int MAX_SIZE_CLOUD = 10;

	public static boolean SPAWN_BIOMES_OVERWORLD = false;
	
	public static int MAX_DAMAGE_TOOLS = 60;

	public static void init(File file) {
		config = new Configuration(file);

		String category;

		category = "IDs Entity";

		config.addCustomCategoryComment(category, "Set ID's for ENTITY");

		ENTITY_GUARDIAN_GOLEM = config.getInt("ENTITY_GUARDIAN_GOLEM", category, ENTITY_GUARDIAN_GOLEM,
				ENTITY_GUARDIAN_GOLEM, 1000, "");
		ENTITY_VIDARGAVIA = config.getInt("ENTITY_VIDARGAVIA", category, ENTITY_VIDARGAVIA,
				ENTITY_VIDARGAVIA, 1000, "");
		ENTITY_DRAGON_FLY = config.getInt("ENTITY_DRAGON_FLY", category, ENTITY_DRAGON_FLY,
				ENTITY_DRAGON_FLY, 1000, "");
		ENTITY_MONTAUK = config.getInt("ENTITY_MONTAUK", category, ENTITY_MONTAUK, ENTITY_MONTAUK,
				1000, "");
		ENTITY_FROZEN_BUFFALO = config.getInt("ENTITY_FROZEN_BUFFALO", category, ENTITY_FROZEN_BUFFALO,
				ENTITY_FROZEN_BUFFALO, 1000, "");
		ENTITY_FROZEN_BOAR = config.getInt("ENTITY_FROZEN_BOAR", category, ENTITY_FROZEN_BOAR,
				ENTITY_FROZEN_BOAR, 1000, "");
		ENTITY_BUFFALO = config.getInt("ENTITY_BUFFALO", category, ENTITY_BUFFALO, ENTITY_BUFFALO,
				1000, "");
		ENTITY_BOAR = config.getInt("ENTITY_BOAR", category, ENTITY_BOAR, ENTITY_BOAR, 1000, "");
		ENTITY_PHORUS = config.getInt("ENTITY_PHORUS", category, ENTITY_PHORUS, ENTITY_PHORUS, 1000,
				"");
		ENTITY_TOTAM = config.getInt("ENTITY_TOTAM", category, ENTITY_TOTAM, ENTITY_TOTAM, 1000,
				"");
		QUEEN_CREEPER = config.getInt("QUEEN_CREEPER", category, QUEEN_CREEPER, QUEEN_CREEPER, 1000,
				"");
		GRINDLY_UP = config.getInt("GRINDLY_UP", category, GRINDLY_UP, GRINDLY_UP, 1000, "");
		GRINDLY_FRONT = config.getInt("ENTITY_MONTAUK", category, GRINDLY_FRONT, GRINDLY_FRONT,
				1000, "");
		GRINDLY_BOTH = config.getInt("GRINDLY_BOTH", category, GRINDLY_BOTH, GRINDLY_BOTH, 1000,
				"");
		CLOUDY = config.getInt("CLOUDY", category, CLOUDY, CLOUDY, 1000, "");
		CERBERE = config.getInt("CERBERE", category, CERBERE, CERBERE, 1000, "");
		DEMON = config.getInt("DEMON", category, DEMON, DEMON, 1000, "");
		DEAD_PLAYER = config.getInt("DEAD_PLAYER", category, DEAD_PLAYER, DEAD_PLAYER, 1000, "");
		KIWI = config.getInt("KIWI", category, KIWI, KIWI, 1000, "");
		PHARAOH = config.getInt("PHARAOH", category, PHARAOH, PHARAOH, 1000, "");
		MUMMY = config.getInt("MUMMY", category, MUMMY, MUMMY, 1000, "");
		HELL_KING = config.getInt("HELL_KING", category, HELL_KING, HELL_KING, 1000, "");
		GIANT_SPIDER = config.getInt("GIANT_SPIDER", category, GIANT_SPIDER, GIANT_SPIDER, 1000,
				"");
		FAILED_GOLEM = config.getInt("FAILED_GOLEM", category, FAILED_GOLEM, FAILED_GOLEM, 1000,
				"");
		HEAD_LESS = config.getInt("HEAD_LESS", category, HEAD_LESS, HEAD_LESS, 1000, "");
		GIRIL = config.getInt("GIRIL", category, GIRIL, GIRIL, 1000, "");
		POSEIDON = config.getInt("POSEIDON", category, POSEIDON, POSEIDON, 1000, "");
		ARTIKON = config.getInt("ARTIKON", category, ARTIKON, ARTIKON, 1000, "");
		TOXIC_COW = config.getInt("TOXIC_COW", category, TOXIC_COW, TOXIC_COW, 1000, "");
		SKULL = config.getInt("SKULL", category, SKULL, SKULL, 1000, "");
		ENTITY_MOTHMOTH = config.getInt("ENTITY_MOTHMOTH", category, ENTITY_MOTHMOTH,
				ENTITY_MOTHMOTH, 1000, "");
		ENTITY_LAYTURTLE = config.getInt("ENTITY_LAYTURTLE", category, ENTITY_LAYTURTLE,
				ENTITY_LAYTURTLE, 1000, "");
		ENTITY_CRYSTIM = config.getInt("ENTITY_CRYSTIM", category, ENTITY_CRYSTIM, ENTITY_CRYSTIM,
				1000, "");
		PRIMARY_ATTACK = config.getInt("PRIMARY_ATTACK", category, PRIMARY_ATTACK, PRIMARY_ATTACK,
				1000, "");
		PRIMARY_HEAL = config.getInt("PRIMARY_HEAL", category, PRIMARY_HEAL, PRIMARY_HEAL, 1000,
				"");
		PRIMARY_STRENGTH = config.getInt("PRIMARY_STRENGTH", category, PRIMARY_STRENGTH,
				PRIMARY_STRENGTH, 1000, "");
		ENTITY_STELLAR = config.getInt("ENTITY_STELLAR", category, ENTITY_STELLAR, ENTITY_STELLAR,
				1000, "");
		ENTITY_COLOSSE = config.getInt("ENTITY_COLOSSE", category, ENTITY_COLOSSE, ENTITY_COLOSSE,
				1000, "");
		ENTITY_PLYTON = config.getInt("ENTITY_PLYTON", category, ENTITY_PLYTON, ENTITY_PLYTON,
				1000, "");
		ENTITY_VELOCIRAPTOR= config.getInt("ENTITY_VELOCIRAPTOR", category, ENTITY_VELOCIRAPTOR, ENTITY_VELOCIRAPTOR,
				1000, "");

		ENTITY_SOLDIER_SNOWGOLEM = config.getInt("ENTITY_SOLDIER_SNOWGOLEM", category, ENTITY_SOLDIER_SNOWGOLEM, ENTITY_SOLDIER_SNOWGOLEM,
				1000, "");

		ENTITY_RANGE_SNOWGOLEM = config.getInt("ENTITY_RANGE_SNOWGOLEM", category, ENTITY_RANGE_SNOWGOLEM, ENTITY_RANGE_SNOWGOLEM,
				1000, "");
		
		ENTITY_BREAKER = config.getInt("ENTITY_BREAKER", category, ENTITY_BREAKER, ENTITY_BREAKER,
				1000, "");
	
		ENTITY_METEORITE = config.getInt("ENTITY_METEORITE", category, ENTITY_METEORITE, ENTITY_METEORITE,
				1000, "");

		category = "IDs GUI";

		config.addCustomCategoryComment(category, "Set ID's for GUI");

		GUI_PYRODES_FURNACE = config.getInt("GUI_PYRODES_FURNACE", category, GUI_PYRODES_FURNACE,
				0, 1000, "");
		GUI_ALLOY_FURNACE = config.getInt("GUI_ALLOY_FURNACE", category, GUI_ALLOY_FURNACE,
				0, 1000, "");

		category = "IDs Dimensions";

		config.addCustomCategoryComment(category, "Set ID's for Dimensions");

		DIMENSION_NOXIS_ID = config.getInt("DIMENSION_NOXIS_ID", category, DIMENSION_NOXIS_ID,
				2, 1000, "");
		DIMENSION_LAPUTA_ID = config.getInt("DIMENSION_LAPUTA_ID", category, DIMENSION_LAPUTA_ID,
				2, 1000, "");
		DIMENSION_GOSYN_ID = config.getInt("DIMENSION_MUSHROOM_ID", category, DIMENSION_GOSYN_ID,
				2, 1000, "");
		DIMENSION_FROZ_ID = config.getInt("DIMENSION_FROZ_ID", category, DIMENSION_FROZ_ID,
				2, 1000, "");

		category = "World Gen & max Entity";

		config.addCustomCategoryComment(category, "World Gen & max Entity");
		MAX_PASSIF_CREATURE = config.getInt("MAX_PASSIF_CREATURE", category, MAX_PASSIF_CREATURE,
				0, 1000, "Max passive creatures");

		MAX_SIZE_CLOUD = config.getInt("MAX_PASSIF_CREATURE", category, MAX_PASSIF_CREATURE,
			0, 1000, "Max cloud size");

		SPAWN_BIOMES_OVERWORLD = config.getBoolean("SPAWN_BIOMES_OVERWORLD", category, SPAWN_BIOMES_OVERWORLD, "block biome spawning in overworld");

		
		config.save();
	}

	public static void registerConfig(FMLPreInitializationEvent event) {
		Main.config = new File(event.getModConfigurationDirectory() + "/" +  Reference.MOD_ID);
		Main.config.mkdirs();
		init(new File(Main.config.getPath(), Reference.MOD_ID + ".cfg"));
	}

}
