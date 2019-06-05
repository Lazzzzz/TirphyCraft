package com.laz.tirphycraft.init;

import java.util.ArrayList;
import java.util.List;

import com.laz.tirphycraft.objects.base.BlockBase;
import com.laz.tirphycraft.objects.base.BlockDungeonBase;
import com.laz.tirphycraft.objects.base.BlockLogBase;
import com.laz.tirphycraft.objects.base.BlockOre;
import com.laz.tirphycraft.objects.base.BlockPlanksBase;
import com.laz.tirphycraft.objects.base.BlockPortalBase;
import com.laz.tirphycraft.objects.base.BlockStairsBase;
import com.laz.tirphycraft.objects.base.GrassBase;
import com.laz.tirphycraft.objects.blocks.customBlock.BlockBrickDungeon;
import com.laz.tirphycraft.objects.blocks.customBlock.BlockBrickDungeonSun;
import com.laz.tirphycraft.objects.blocks.customBlock.BlockBrickDungeonsControler;
import com.laz.tirphycraft.objects.blocks.customBlock.bush.BlockBushBase;
import com.laz.tirphycraft.objects.blocks.customBlock.bush.BlockBushBlue;
import com.laz.tirphycraft.objects.blocks.customBlock.bush.BlockBushGreen;
import com.laz.tirphycraft.objects.blocks.customBlock.bush.BlockBushRed;
import com.laz.tirphycraft.objects.blocks.customBlock.froz.BlockFrozCrate;
import com.laz.tirphycraft.objects.blocks.customBlock.froz.BlockFrozStone;
import com.laz.tirphycraft.objects.blocks.customBlock.froz.BlockPlantBlueRose;
import com.laz.tirphycraft.objects.blocks.customBlock.froz.BlockPowderSnow;
import com.laz.tirphycraft.objects.blocks.customBlock.froz.dungeon.BlockBossDoor;
import com.laz.tirphycraft.objects.blocks.customBlock.laputa.BlockCloud;
import com.laz.tirphycraft.objects.blocks.customBlock.laputa.BlockLaputaStone;
import com.laz.tirphycraft.objects.blocks.customBlock.laputa.BlockSunStone;
import com.laz.tirphycraft.objects.blocks.customBlock.laputa.crystal.BlockBlueCrystal;
import com.laz.tirphycraft.objects.blocks.customBlock.laputa.crystal.BlockBlueCrystalFull;
import com.laz.tirphycraft.objects.blocks.customBlock.laputa.crystal.BlockGreenCrystal;
import com.laz.tirphycraft.objects.blocks.customBlock.laputa.crystal.BlockGreenCrystalFull;
import com.laz.tirphycraft.objects.blocks.customBlock.laputa.crystal.BlockPinkCrystal;
import com.laz.tirphycraft.objects.blocks.customBlock.laputa.crystal.BlockPinkCrystalFull;
import com.laz.tirphycraft.objects.blocks.customBlock.laputa.crystal.BlockPurpleCrystal;
import com.laz.tirphycraft.objects.blocks.customBlock.laputa.crystal.BlockPurpleCrystalFull;
import com.laz.tirphycraft.objects.blocks.customBlock.laputa.crystal.BlockYellowCrystal;
import com.laz.tirphycraft.objects.blocks.customBlock.laputa.crystal.BlockYellowCrystalFull;
import com.laz.tirphycraft.objects.blocks.customBlock.laputa.plant.BlockLaputaBush;
import com.laz.tirphycraft.objects.blocks.customBlock.laputa.plant.BlockLaputaGrass;
import com.laz.tirphycraft.objects.blocks.customBlock.laputa.plant.BlockLaputaTallGrass;
import com.laz.tirphycraft.objects.blocks.customBlock.noxis.BlockMushroomLeaves;
import com.laz.tirphycraft.objects.blocks.customBlock.noxis.BlockNoxisFrozenGrass;
import com.laz.tirphycraft.objects.blocks.customBlock.noxis.BlockNoxisGrass;
import com.laz.tirphycraft.objects.blocks.customBlock.noxis.BlockNoxisStone;
import com.laz.tirphycraft.objects.blocks.customBlock.noxis.BlockSmoker;
import com.laz.tirphycraft.objects.blocks.customModel.Altar;
import com.laz.tirphycraft.objects.blocks.customModel.BluePillar;
import com.laz.tirphycraft.objects.blocks.customModel.GreenPillar;
import com.laz.tirphycraft.objects.blocks.customModel.NeutralPillar;
import com.laz.tirphycraft.objects.blocks.customModel.RedPillar;
import com.laz.tirphycraft.objects.blocks.customModel.WhitePillar;
import com.laz.tirphycraft.objects.blocks.customModel.YellowPillar;
import com.laz.tirphycraft.objects.blocks.customModel.nixiumCrytsal;
import com.laz.tirphycraft.objects.blocks.customModel.egg.EggArtikon;
import com.laz.tirphycraft.objects.blocks.customModel.egg.EggCreeperQueen;
import com.laz.tirphycraft.objects.blocks.customModel.egg.EggHellKing;
import com.laz.tirphycraft.objects.blocks.customModel.egg.EggPharaon;
import com.laz.tirphycraft.objects.blocks.customModel.egg.EggPoseidon;
import com.laz.tirphycraft.objects.blocks.machine.alloy.BlockAlloyFurnace;
import com.laz.tirphycraft.objects.blocks.machine.pyrodes.BlockPyrodesFurnace;
import com.laz.tirphycraft.objects.blocks.trees.leaves.BlockLeavesCoppir;
import com.laz.tirphycraft.objects.blocks.trees.leaves.BlockLeavesFroz;
import com.laz.tirphycraft.objects.blocks.trees.leaves.BlockLeavesGoldir;
import com.laz.tirphycraft.objects.blocks.trees.leaves.BlockLeavesSilvir;
import com.laz.tirphycraft.objects.blocks.trees.leaves.BlockNormalLeavesBlue;
import com.laz.tirphycraft.objects.blocks.trees.leaves.BlockNormalLeavesGreen;
import com.laz.tirphycraft.objects.blocks.trees.leaves.BlockNormalLeavesPurple;
import com.laz.tirphycraft.objects.blocks.trees.leaves.BlockNormalLeavesWhite;
import com.laz.tirphycraft.objects.blocks.trees.leaves.BlockNormalLeavesYellow;
import com.laz.tirphycraft.objects.blocks.trees.sapling.BlockSaplingCoppir;
import com.laz.tirphycraft.objects.blocks.trees.sapling.BlockSaplingFroz;
import com.laz.tirphycraft.objects.blocks.trees.sapling.BlockSaplingGoldir;
import com.laz.tirphycraft.objects.blocks.trees.sapling.BlockSaplingNormal;
import com.laz.tirphycraft.objects.blocks.trees.sapling.BlockSaplingSilvir;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class BlockInit {

	public static final List<Block> BLOCKS = new ArrayList<Block>();
	
	//BLOCKS
	public static final Block BLOCK_PYRODES 			= new BlockBase("block_pyrodes", Material.ROCK, 3, 15, "pickaxe", 0, SoundType.METAL);
	public static final Block BLOCK_HEAVY   			= new BlockBase("block_heavy", Material.ROCK, 3, 15, "pickaxe", 0, SoundType.METAL);
	public static final Block BLOCK_NIXIUM  			= new BlockBase("block_nixium", Material.ROCK, 3, 15, "pickaxe", 0, SoundType.METAL);
	public static final Block BLOCK_COAL	  			= new BlockBase("block_coal_on_coke", Material.ROCK, 3, 15, "pickaxe", 0, SoundType.METAL);
	public static final Block CLOUD						= new BlockCloud();
	public static final Block FROZEN_CRYSTAL			= new BlockBase("frozen_crystal", Material.GLASS, 3, 15, "pickaxe", 1, SoundType.GLASS);
	public static final Block BLACK_CRYSTAL				= new BlockBase("black_crystal", Material.GLASS, 3, 15, "pickaxe", 1, SoundType.GLASS);
	public static final Block SUN_STONE					= new BlockSunStone("sun_stone", Material.ROCK, 1, 10, "pickaxe", 0, SoundType.STONE, 1F);
	public static final Block PORTAL_BASE				= new BlockBase("portal_base", Material.ROCK, 3, 15, "pickaxe", 3, SoundType.STONE);
	public static final Block LAPUTA_BLUE				= new BlockBlueCrystalFull();
	public static final Block LAPUTA_PINK				= new BlockPinkCrystalFull();
	public static final Block LAPUTA_PURPLE				= new BlockPurpleCrystalFull();
	public static final Block LAPUTA_GREEN				= new BlockGreenCrystalFull();
	public static final Block LAPUTA_YELLOW				= new BlockYellowCrystalFull();
	
	//LOGS
	public static final Block LOG_COPPIR 		= new BlockLogBase("log_coppir");
	public static final Block LOG_SILVIR		= new BlockLogBase("log_silvir");
	public static final Block LOG_GOLDIR		= new BlockLogBase("log_goldir");
	public static final Block LOG_MYSTICAL		= new BlockLogBase("log_mystical");
	public static final Block LOG_MUSHROOM		= new BlockLogBase("log_mushroom");
	public static final Block LOG_FROZ			= new BlockLogBase("log_froz");
	public static final Block STEM				= new BlockLogBase("stem");
	
	//PLANKS
	public static final Block PLANKS_COPPIR 	= new BlockPlanksBase("planks_coppir");
	public static final Block PLANKS_SILVIR		= new BlockPlanksBase("planks_silvir");
	public static final Block PLANKS_GOLDIR		= new BlockPlanksBase("planks_goldir");
	public static final Block PLANKS_FROZ		= new BlockPlanksBase("planks_froz");
	
	//SAPLINGS
	public static final Block SAPLING_COPPIR 	= new BlockSaplingCoppir("sapling_coppir");
	public static final Block SAPLING_SILVIR 	= new BlockSaplingSilvir("sapling_silvir");
	public static final Block SAPLING_GOLDIR 	= new BlockSaplingGoldir("sapling_goldir");
	public static final Block SAPLING_NORMAL	= new BlockSaplingNormal("sapling_normal");
	public static final Block SAPLING_FROZ		= new BlockSaplingFroz("sapling_froz");
	
	//LEAVES
	public static final Block LEAVES_COPPIR     = new BlockLeavesCoppir("leaves_coppir");
	public static final Block LEAVES_SILVIR 	= new BlockLeavesSilvir("leaves_silvir");
	public static final Block LEAVES_GOLDIR 	= new BlockLeavesGoldir("leaves_goldir");
	public static final Block LEAVES_MUSHROOM   = new BlockMushroomLeaves();
	
	public static final Block LEAVES_BLUE 		= new BlockNormalLeavesBlue("leaves_blue");
	public static final Block LEAVES_GREEN 		= new BlockNormalLeavesGreen("leaves_green");
	public static final Block LEAVES_PURPLE 	= new BlockNormalLeavesPurple("leaves_purple");
	public static final Block LEAVES_YELLOW 	= new BlockNormalLeavesYellow("leaves_yellow");
	public static final Block LEAVES_WHITE	 	= new BlockNormalLeavesWhite("leaves_white");
	public static final Block LEAVES_FROZ	 	= new BlockLeavesFroz("leaves_froz");
	
	//ORE
	public static final Block ORE_NOXIS        	= new BlockOre("ore_noxis", "noxis");
	public static final Block ORE_OVERWORLD 	= new BlockOre("ore_overworld", "overworld");
	public static final Block ORE_LAPUTA     	= new BlockOre("ore_laputa", "laputa");
	
	//TILE ENTITY
	public static final Block PYRODES_FURNACE 	= new BlockPyrodesFurnace("pyrodes_furnace");
	public static final Block ALLOY_FURNACE 	= new BlockAlloyFurnace("alloy_furnace");	
	
	//FLOOR
	public static final Block NOXIS_STONE			= new BlockNoxisStone("noxis_stone", Material.ROCK, 1.5F, 15, "pickaxe", 0, SoundType.STONE);
	public static final Block NOXIS_COBBLESTONE     = new BlockBase("noxis_cobblestone", Material.ROCK, 1.6F, 15, "pickaxe", 0, SoundType.STONE);
	public static final Block NOXIS_DIRT 			= new BlockBase("noxis_dirt", Material.GROUND, 0.5F, 0, "shovel", 0, SoundType.GROUND);
	public static final Block NOXIS_FROZEN_DIRT		= new BlockBase("noxis_frozen_dirt", Material.ICE, 0.5F, 0, "shovel", 0, SoundType.GROUND);
	public static final Block NOXIS_GRASS 			= new BlockNoxisGrass("noxis_grass", Material.GRASS, 0.6F, 0, SoundType.PLANT);
	public static final Block NOXIS_FROZEN_GRASS	= new BlockNoxisFrozenGrass("noxis_frozen_grass", Material.GRASS, 0.6F, 0, SoundType.PLANT);
	public static final Block LAPUTA_DIRT			= new BlockBase("laputa_dirt", Material.GROUND, 0.5F, 0, "shovel", 0, SoundType.GROUND);
	public static final Block LAPUTA_GRASS			= new BlockLaputaGrass("laputa_grass", Material.GROUND, 0.6F, 0, SoundType.GROUND);
	public static final Block LAPUTA_STONE			= new BlockLaputaStone("laputa_stone", Material.ROCK, 1.5F, 15, "pickaxe", 0, SoundType.STONE);
	public static final Block LAPUTA_COBBLESTONE    = new BlockBase("laputa_cobblestone", Material.ROCK, 1.6F, 15, "pickaxe", 0, SoundType.STONE);
	public static final Block SMOKER      			= new BlockSmoker();
	public static final Block POWDER_SNOW			= new BlockPowderSnow();
	public static final Block FROZ_STONE			= new BlockFrozStone("froz_stone", Material.ROCK, 1.5F, 15, "pickaxe", 0, SoundType.STONE);
	public static final Block FROZ_COBBLESTONE      = new BlockBase("froz_cobblestone", Material.ROCK, 1.6F, 15, "pickaxe", 0, SoundType.STONE);
	
	//BRICK
	public static final Block BRICK_NOXIS            = new BlockBase("brick_noxis", Material.ROCK, 1.6F, 15, "pickaxe", 0, SoundType.STONE);	
	public static final Block BRICK_LAPUTA           = new BlockBase("brick_laputa", Material.ROCK, 1.6F, 15, "pickaxe", 0, SoundType.STONE);	
	public static final Block BRICK_FROZ             = new BlockBase("brick_froz", Material.ROCK, 1.6F, 15, "pickaxe", 0, SoundType.STONE);	

	//STAIRS
	public static final Block STAIRS_COPPIR 		= new BlockStairsBase("stairs_coppir", Material.WOOD, 2, 2, "axe", 0, SoundType.WOOD, PLANKS_COPPIR.getDefaultState(), true);
	public static final Block STAIRS_SILVIR			= new BlockStairsBase("stairs_silvir", Material.WOOD, 2, 2, "axe", 0, SoundType.WOOD, PLANKS_SILVIR.getDefaultState(), true);
	public static final Block STAIRS_GOLDIR			= new BlockStairsBase("stairs_goldir", Material.WOOD, 2, 2, "axe", 0, SoundType.WOOD, PLANKS_GOLDIR.getDefaultState(), true);
	public static final Block STAIRS_FROZ			= new BlockStairsBase("stairs_froz", Material.WOOD, 2, 2, "axe", 0, SoundType.WOOD, PLANKS_GOLDIR.getDefaultState(), true);
	public static final Block STAIRS_BRICK_NOXIS	= new BlockStairsBase("stairs_brick_noxis", Material.ROCK, 1.6F, 15, "pickaxe", 0, SoundType.WOOD, BRICK_NOXIS.getDefaultState(), false);
	public static final Block STAIRS_BRICK_LAPUTA	= new BlockStairsBase("stairs_brick_laputa", Material.ROCK, 1.6F, 15, "pickaxe", 0, SoundType.WOOD, BRICK_LAPUTA.getDefaultState(), false);
	public static final Block STAIRS_BRICK_FROZ		= new BlockStairsBase("stairs_brick_froz", Material.ROCK, 1.6F, 15, "pickaxe", 0, SoundType.WOOD, BRICK_FROZ.getDefaultState(), false);
	
	//MODEL 
	public static final Block NEUTRAL_PILLAR 		= new NeutralPillar("neutral_pillar");
	public static final Block BLUE_PILLAR 			= new BluePillar("blue_pillar");
	public static final Block YELLOW_PILLAR 		= new YellowPillar("yellow_pillar");
	public static final Block GREEN_PILLAR 			= new GreenPillar("green_pillar");
	public static final Block WHITE_PILLAR 			= new WhitePillar("white_pillar");
	public static final Block RED_PILLAR 			= new RedPillar("red_pillar");
	public static final Block ALTAR					= new Altar("altar");
	public static final Block NIXIUM_CRYSTAL		= new nixiumCrytsal("nixium_crytsal");
	public static final Block LAPUTA_BLUE_CRYSTAL	= new BlockBlueCrystal();
	public static final Block LAPUTA_PINK_CRYSTAL	= new BlockPinkCrystal();
	public static final Block LAPUTA_PURPLE_CRYSTAL	= new BlockPurpleCrystal();
	public static final Block LAPUTA_GREEN_CRYSTAL	= new BlockGreenCrystal();
	public static final Block LAPUTA_YELLOW_CRYSTAL	= new BlockYellowCrystal();
	
	//PLANT
	public static final Block LAPUTA_PLANT_GRASS 		= new GrassBase("laputa_plant_grass");
	public static final Block LAPUTA_PLANT_GRASS_DARK 	= new GrassBase("laputa_plant_grass_dark");
	public static final Block LAPUTA_FAIRY_FLOWER		= new GrassBase("laputa_fairy_flower");
	public static final Block LAPUTA_HYDRA_FLOWER		= new GrassBase("laputa_hydra_flower");
	public static final Block LAPUTA_BUSH				= new BlockLaputaBush();
	public static final Block LAPUTA_TALL_GRASS		 	= new BlockLaputaTallGrass();
	public static final Block FROZ_PLANT_BLUE_ROSE	 	= new BlockPlantBlueRose();
	public static final Block BUSH_BASE					= new BlockBushBase("bush_base", Material.LEAVES, 0.2f, 0, "all", 0, SoundType.PLANT);
	public static final Block BUSH_RED					= new BlockBushRed("bush_red", Material.LEAVES, 0.2f, 0, "all", 0, SoundType.PLANT);
	public static final Block BUSH_BLUE					= new BlockBushBlue("bush_blue", Material.LEAVES, 0.2f, 0, "all", 0, SoundType.PLANT);
	public static final Block BUSH_GREEN				= new BlockBushGreen("bush_green", Material.LEAVES, 0.2f, 0, "all", 0, SoundType.PLANT);
	
	
	//EGG
	public static final Block EGG_QUEEN_CREEPR			= new EggCreeperQueen("egg_queen_creeper");
	public static final Block EGG_PHARAON				= new EggPharaon("egg_pharaon");
	public static final Block EGG_HELL_KING				= new EggHellKing("egg_hell_king");
	public static final Block EGG_POSEIDON				= new EggPoseidon("egg_poseidon");
	public static final Block EGG_ARTIKON				= new EggArtikon("egg_artikon");
	
	//PORTAL
	public static final Block PORTAL_LAPUTA				= new BlockPortalBase("portal_laputa", 121);
	public static final Block PORTAL_FROZ				= new BlockPortalBase("portal_froz", 123);
	
	//DUNGEONS
	public static final Block BRICK_DUNGEON 			= new BlockBrickDungeon();
	public static final Block BRICK_DUNGEON_SUN 		= new BlockBrickDungeonSun();
	public static final Block BRICK_DUNGEON_CONTROLER 	= new BlockBrickDungeonsControler();
	public static final Block FROZ_BOSS_WALL			= new BlockDungeonBase("froz_boss_wall", SoundType.GROUND);
	public static final Block FROZ_BOSS_DOOR	        = new BlockBossDoor();
	public static final Block FRO_CREATE				= new BlockFrozCrate();
	
}
