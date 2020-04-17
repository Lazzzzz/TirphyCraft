package com.laz.tirphycraft.init;

import java.util.ArrayList;
import java.util.List;

import com.laz.tirphycraft.Main;
import com.laz.tirphycraft.gosyn.common.items.ItemAiguiteGem;
import com.laz.tirphycraft.gosyn.common.items.ItemCreseolEmptyTablet;
import com.laz.tirphycraft.gosyn.common.items.ItemCreseolTablet;
import com.laz.tirphycraft.gosyn.common.items.ItemMelynchStick;
import com.laz.tirphycraft.gosyn.common.items.tools.aiguite.ToolsAiguiteAxe;
import com.laz.tirphycraft.gosyn.common.items.tools.aiguite.ToolsAiguitePickaxe;
import com.laz.tirphycraft.gosyn.common.items.tools.aiguite.ToolsAiguiteShovel;
import com.laz.tirphycraft.gosyn.common.items.tools.aiguite.ToolsAiguiteSword;
import com.laz.tirphycraft.gosyn.common.items.tools.melynch.ToolsMelynchAxe;
import com.laz.tirphycraft.gosyn.common.items.tools.melynch.ToolsMelynchPickaxe;
import com.laz.tirphycraft.gosyn.common.items.tools.melynch.ToolsMelynchShovel;
import com.laz.tirphycraft.gosyn.common.items.tools.melynch.ToolsMelynchSword;
import com.laz.tirphycraft.objects.artefact.ArtefactFeatherOfLight;
import com.laz.tirphycraft.objects.artefact.ArtefactSunTear;
import com.laz.tirphycraft.objects.base.ItemBase;
import com.laz.tirphycraft.objects.items.debugStickySticky;
import com.laz.tirphycraft.objects.items.amulets.Amulet_1_attack;
import com.laz.tirphycraft.objects.items.amulets.Amulet_1_health;
import com.laz.tirphycraft.objects.items.amulets.Amulet_1_speed;
import com.laz.tirphycraft.objects.items.amulets.Amulet_2_attack;
import com.laz.tirphycraft.objects.items.amulets.Amulet_2_health;
import com.laz.tirphycraft.objects.items.amulets.Amulet_2_speed;
import com.laz.tirphycraft.objects.items.amulets.Amulet_3_attack;
import com.laz.tirphycraft.objects.items.amulets.Amulet_3_health;
import com.laz.tirphycraft.objects.items.amulets.Amulet_3_speed;
import com.laz.tirphycraft.objects.items.amulets.AntiAmulet;
import com.laz.tirphycraft.objects.items.armor.ArmorGasMask;
import com.laz.tirphycraft.objects.items.armor.ArmorHeavy;
import com.laz.tirphycraft.objects.items.armor.ArmorNixium;
import com.laz.tirphycraft.objects.items.armor.ArmorOrigin;
import com.laz.tirphycraft.objects.items.armor.ArmorParachute;
import com.laz.tirphycraft.objects.items.armor.ArmorPyrodes;
import com.laz.tirphycraft.objects.items.armor.ArmorRose;
import com.laz.tirphycraft.objects.items.armor.ArmorTenium;
import com.laz.tirphycraft.objects.items.bow.BowPyrodes;
import com.laz.tirphycraft.objects.items.clock.ItemClock;
import com.laz.tirphycraft.objects.items.food.ItemCustomFood;
import com.laz.tirphycraft.objects.items.legendary.TotemLevitation;
import com.laz.tirphycraft.objects.items.legendary.TotemThunder;
import com.laz.tirphycraft.objects.items.other.ItemAnkh;
import com.laz.tirphycraft.objects.items.other.ItemCoins;
import com.laz.tirphycraft.objects.items.other.ItemMixedDust;
import com.laz.tirphycraft.objects.items.other.ItemPoseidonEye;
import com.laz.tirphycraft.objects.items.other.ItemQueenHeart;
import com.laz.tirphycraft.objects.items.other.ItemRoseFinder;
import com.laz.tirphycraft.objects.items.other.ItemTeniumIngot;
import com.laz.tirphycraft.objects.items.staff.StaffExplosion1;
import com.laz.tirphycraft.objects.items.staff.StaffExplosion2;
import com.laz.tirphycraft.objects.items.staff.StaffExplosion3;
import com.laz.tirphycraft.objects.items.staff.StaffFireBall1;
import com.laz.tirphycraft.objects.items.staff.StaffFireBall2;
import com.laz.tirphycraft.objects.items.staff.StaffFireBall3;
import com.laz.tirphycraft.objects.items.staff.StaffHeal1;
import com.laz.tirphycraft.objects.items.staff.StaffHeal2;
import com.laz.tirphycraft.objects.items.staff.StaffHeal3;
import com.laz.tirphycraft.objects.items.staff.StaffTeleportation1;
import com.laz.tirphycraft.objects.items.staff.StaffTeleportation2;
import com.laz.tirphycraft.objects.items.staff.StaffTeleportation3;
import com.laz.tirphycraft.objects.items.tools.ToolAxeBase;
import com.laz.tirphycraft.objects.items.tools.ToolHoeBase;
import com.laz.tirphycraft.objects.items.tools.ToolPickaxeBase;
import com.laz.tirphycraft.objects.items.tools.ToolShovelBase;
import com.laz.tirphycraft.objects.items.tools.ToolSwordBase;
import com.laz.tirphycraft.objects.items.tools.ToolSwordLarge;
import com.laz.tirphycraft.objects.items.tools.custom.ToolSwordExplosion;
import com.laz.tirphycraft.objects.items.tools.custom.ToolThunderHarp;
import com.laz.tirphycraft.util.handlers.ConfigHandler;

import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;

public class ItemInit {
	public static final List<Item> ITEMS = new ArrayList<Item>();

	//TRESOR
	public static final Item PARACHUTE 				= new ArmorParachute("parachute", Main.tirphycrafttab, ArmorInit.PARACHUTE_ARMOR, EntityEquipmentSlot.HEAD);
	public static final Item GAS_MASK	            = new ArmorGasMask("gas_mask", ArmorInit.GAS_MASK_ARMOR, 1, EntityEquipmentSlot.HEAD);
	
	//AMULETS
	public static final Item ANTI_AMULET 			= new AntiAmulet(); 
	
	public static final Item AMULET_1_HEART			= new Amulet_1_health(); 	
	public static final Item AMULET_2_HEART			= new Amulet_2_health(); 	
	public static final Item AMULET_3_HEART			= new Amulet_3_health(); 		

	public static final Item AMULET_1_ATTACK		= new Amulet_1_attack(); 	
	public static final Item AMULET_2_ATTACK	 	= new Amulet_2_attack(); 	
	public static final Item AMULET_3_ATTACK		= new Amulet_3_attack(); 

	public static final Item AMULET_1_LUCK			= new Amulet_1_speed();
	public static final Item AMULET_2_LUCK			= new Amulet_2_speed(); 
	public static final Item AMULET_3_LUCK			= new Amulet_3_speed();
	
	//TOTEM
	public static final Item TOTEM_LEVITATION       = new TotemLevitation();
	public static final Item TOTEM_THUNDER 	        = new TotemThunder();
	
	//FRAGMENT
	public static final Item FRAGMENT_BLUE   	   = new ItemBase("fragment_blue", 16);
	public static final Item FRAGMENT_GREEN   	   = new ItemBase("fragment_green", 16);
	public static final Item FRAGMENT_RED     	   = new ItemBase("fragment_red", 16);
	public static final Item FRAGMENT_WHITE   	   = new ItemBase("fragment_white", 16);
	public static final Item FRAGMENT_YELLOW 	   = new ItemBase("fragment_yellow", 16);

	//ITEMS
	public static final Item CRYSTAL  			   = new ItemBase("crystal", 64);		
	public static final Item CRYSTAL_PURODES       = new ItemBase("crystal_purodes", 64);
	public static final Item POLY_CRYSTAL_PYRODES  = new ItemBase("poly_crystal_pyrodes", 64);
	public static final Item COAL_ON_COKE    	   = new ItemBase("coal_on_coke", 64);
	public static final Item HEAVY_INGOT		   = new ItemBase("heavy_ingot", 64);
	public static final Item NIXIUM_INGOT		   = new ItemBase("nixium_ingot", 64);
	public static final Item TENIUM_INGOT 	       = new ItemTeniumIngot("tenium_ingot", 64);
	public static final Item BLUE_ROSE_SHARD	   = new ItemBase("blue_rose_shard", 64);
	public static final Item DIAMOND_NUGGET		   = new ItemBase("diamond_nugget", 64);
	public static final Item MUMMY_WRAPS		   = new ItemBase("mummy_wraps", 16);
	public static final Item EMPTY_SYRINGE		   = new ItemBase("empty_syringe", 64);
	public static final Item BLUE_ROSE_PETAL	   = new ItemBase("blue_rose_petal", 64);
	public static final Item COINS				   = new ItemCoins();
	public static final Item ROSE_FINDER           = new ItemRoseFinder("rose_finder", 1);
	public static final Item FROZ_KEY			   = new ItemBase("froz_key", 3);
	public static final Item MIXED_DUST			   = new ItemMixedDust("mixed_dust", 4);
	public static final Item ORIGIN_MATTER		   = new ItemBase("origin_matter", 64);	
	public static final Item ORIGIN_INGOT		   = new ItemBase("origin_ingot", 64);	
	
	//BOSSDROP
	public static final Item QUEEN_HEART 		  = new ItemQueenHeart();
	public static final Item ANKH				  = new ItemAnkh();
	public static final Item POSEIDON_EYE		  = new ItemPoseidonEye();
	
	//CORE
	public static final Item EXPLOSION_CORE 	  = new ItemBase("explosion_core", 64);
	public static final Item SEA_CORE 			  = new ItemBase("sea_core", 64);
	public static final Item LIFE_CORE 			  = new ItemBase("life_core", 64);
	
	//BOSS WEAPON
	public static final Item EXPLOSION_SWORD     = new ToolSwordExplosion("explosion_sword", ToolsInit.PYRODES_TOOL);
	public static final Item THUNDER_HARP		 = new ToolThunderHarp("thunder_harp");
	
	//PYRODES
	public static final Item PYRODES_BOOTS 		 = new ArmorPyrodes("pyrodes_boots", ArmorInit.PYRODES_ARMOR, 1, EntityEquipmentSlot.FEET);
	public static final Item PYRODES_LEGGINGS 	 = new ArmorPyrodes("pyrodes_leggings", ArmorInit.PYRODES_ARMOR, 2, EntityEquipmentSlot.LEGS);
	public static final Item PYRODES_CHESTPLATE	 = new ArmorPyrodes("pyrodes_chestplate", ArmorInit.PYRODES_ARMOR, 1, EntityEquipmentSlot.CHEST);
	public static final Item PYRODES_HELMET		 = new ArmorPyrodes("pyrodes_helmet", ArmorInit.PYRODES_ARMOR, 1, EntityEquipmentSlot.HEAD);
	public static final Item PYRODES_SHOVEL 	 = new ToolShovelBase("pyrodes_shovel", ToolsInit.PYRODES_TOOL);
	public static final Item PYRODES_SWORD   	 = new ToolSwordBase("pyrodes_sword", ToolsInit.PYRODES_TOOL);
	public static final Item PYRODES_PICKAXE 	 = new ToolPickaxeBase("pyrodes_pickaxe", ToolsInit.PYRODES_TOOL);		
	public static final Item PYRODES_AXE	 	 = new ToolAxeBase("pyrodes_axe", ToolsInit.PYRODES_TOOL);
	public static final Item PYRODES_HOE 		 = new ToolHoeBase("pyrodes_hoe", ToolsInit.PYRODES_TOOL);	
	public static final Item PYRODES_LARGE_SWORD = new ToolSwordLarge("pyrodes_large", ToolsInit.PYRODES_LARGE_SWORD);
	
	
	//HEAVY INGOT
	public static final Item HEAVY_BOOTS		= new ArmorHeavy("heavy_boots",  ArmorInit.HEAVY_ARMOR, 1, EntityEquipmentSlot.FEET);	
	public static final Item HEAVY_LEGGINGS		= new ArmorHeavy("heavy_leggings", ArmorInit.HEAVY_ARMOR, 2, EntityEquipmentSlot.LEGS);	
	public static final Item HEAVY_CHESTPLATE	= new ArmorHeavy("heavy_chestplate", ArmorInit.HEAVY_ARMOR, 1, EntityEquipmentSlot.CHEST);	
	public static final Item HEAVY_HELMET		= new ArmorHeavy("heavy_helmet", ArmorInit.HEAVY_ARMOR, 1, EntityEquipmentSlot.HEAD);
	public static final Item HEAVY_SHOVEL 		= new ToolShovelBase("heavy_shovel", ToolsInit.HEAVY_TOOL);
	public static final Item HEAVY_SWORD   	 	= new ToolSwordBase("heavy_sword", ToolsInit.HEAVY_TOOL);
	public static final Item HEAVY_PICKAXE 	 	= new ToolPickaxeBase("heavy_pickaxe", ToolsInit.HEAVY_TOOL);		
	public static final Item HEAVY_AXE	 	 	= new ToolAxeBase("heavy_axe", ToolsInit.HEAVY_TOOL);
	public static final Item HEAVY_HOE 		 	= new ToolHoeBase("heavy_hoe", ToolsInit.HEAVY_TOOL);
	public static final Item HEAVY_LARGE_SWORD  = new ToolSwordLarge("heavy_large", ToolsInit.HEAVY_LARGE_SWORD);
	
	//NIXIUM INGOT
	public static final Item NIXIUM_BOOTS		 = new ArmorNixium("nixium_boots", ArmorInit.NIXIUM_ARMOR, 1, EntityEquipmentSlot.FEET);	
	public static final Item NIXIUM_LEGGINGS	 = new ArmorNixium("nixium_leggings", ArmorInit.NIXIUM_ARMOR, 2, EntityEquipmentSlot.LEGS);	
	public static final Item NIXIUM_CHESTPLATE	 = new ArmorNixium("nixium_chestplate", ArmorInit.NIXIUM_ARMOR, 1, EntityEquipmentSlot.CHEST);	
	public static final Item NIXIUM_HELMET		 = new ArmorNixium("nixium_helmet", ArmorInit.NIXIUM_ARMOR, 1, EntityEquipmentSlot.HEAD);
	public static final Item NIXIUM_SHOVEL 		 = new ToolShovelBase("nixium_shovel", ToolsInit.NIXIUM_TOOL);
	public static final Item NIXIUM_SWORD   	 = new ToolSwordBase("nixium_sword", ToolsInit.NIXIUM_TOOL);
	public static final Item NIXIUM_PICKAXE 	 = new ToolPickaxeBase("nixium_pickaxe", ToolsInit.NIXIUM_TOOL);		
	public static final Item NIXIUM_AXE	 	 	 = new ToolAxeBase("nixium_axe", ToolsInit.NIXIUM_TOOL);
	public static final Item NIXIUM_HOE 		 = new ToolHoeBase("nixium_hoe", ToolsInit.NIXIUM_TOOL);
	public static final Item NIXIUM_LARGE_SWORD  = new ToolSwordLarge("nixium_large", ToolsInit.NIXIUM_LARGE_SWORD);	
	
	//ROSE
	public static final Item ROSE_BOOTS 		 = new ArmorRose("rose_boots", ArmorInit.ROSE_ARMOR, 1, EntityEquipmentSlot.FEET);
	public static final Item ROSE_LEGGINGS 	     = new ArmorRose("rose_leggings", ArmorInit.ROSE_ARMOR, 2, EntityEquipmentSlot.LEGS);
	public static final Item ROSE_CHESTPLATE	 = new ArmorRose("rose_chestplate", ArmorInit.ROSE_ARMOR, 1, EntityEquipmentSlot.CHEST);
	public static final Item ROSE_HELMET		 = new ArmorRose("rose_helmet", ArmorInit.ROSE_ARMOR, 1, EntityEquipmentSlot.HEAD);
		
	//TENIUM
	public static final Item TENIUM_BOOTS		 = new ArmorTenium("tenium_boots", ArmorInit.TENIUM_ARMOR, 1, EntityEquipmentSlot.FEET);	
	public static final Item TENIUM_LEGGINGS	 = new ArmorTenium("tenium_leggings", ArmorInit.TENIUM_ARMOR, 2, EntityEquipmentSlot.LEGS);	
	public static final Item TENIUM_CHESTPLATE	 = new ArmorTenium("tenium_chestplate", ArmorInit.TENIUM_ARMOR, 1, EntityEquipmentSlot.CHEST);	
	public static final Item TENIUM_HELMET		 = new ArmorTenium("tenium_helmet", ArmorInit.TENIUM_ARMOR, 1, EntityEquipmentSlot.HEAD);
	public static final Item TENIUM_SHOVEL 		 = new ToolShovelBase("tenium_shovel", ToolsInit.TENIUM_TOOL);
	public static final Item TENIUM_SWORD   	 = new ToolSwordBase("tenium_sword", ToolsInit.TENIUM_TOOL);
	public static final Item TENIUM_PICKAXE 	 = new ToolPickaxeBase("tenium_pickaxe", ToolsInit.TENIUM_TOOL);		
	public static final Item TENIUM_AXE	 	 	 = new ToolAxeBase("tenium_axe", ToolsInit.TENIUM_TOOL);
	public static final Item TENIUM_HOE 		 = new ToolHoeBase("tenium_hoe", ToolsInit.TENIUM_TOOL);
	public static final Item TENIUM_LARGE_SWORD  = new ToolSwordLarge("tenium_large", ToolsInit.TENIUM_LARGE_SWORD);	
	
	//ORIGIN
	public static final Item ORIGIN_BOOTS		 = new ArmorOrigin("origin_boots", ArmorInit.ORIGIN_ARMOR, 1, EntityEquipmentSlot.FEET);	
	public static final Item ORIGIN_LEGGINGS	 = new ArmorOrigin("origin_leggings", ArmorInit.ORIGIN_ARMOR, 2, EntityEquipmentSlot.LEGS);	
	public static final Item ORIGIN_CHESTPLATE	 = new ArmorOrigin("origin_chestplate", ArmorInit.ORIGIN_ARMOR, 1, EntityEquipmentSlot.CHEST);	
	public static final Item ORIGIN_HELMET		 = new ArmorOrigin("origin_helmet", ArmorInit.ORIGIN_ARMOR, 1, EntityEquipmentSlot.HEAD);
	
	//BOW
	public static final Item BOW_PYRODES		= new BowPyrodes("bow_pyrodes", 30F, true);
	public static final Item BOW_NOXIS  		= new BowPyrodes("bow_noxis", 20F, false);
	public static final Item BOW_LAPUTA  		= new BowPyrodes("bow_laputa", 15F, false);
	public static final Item BOW_FROZ	  		= new BowPyrodes("bow_froz", 20F, false);	
	
	//STICKS
	public static final Item STICK_CRYSTAL  = new ItemBase("stick_crystal", 64);
	public static final Item STICK_COPPIR 	= new ItemBase("stick_coppir", 64);
	public static final Item STICK_SILVIR 	= new ItemBase("stick_silvir", 64);
	public static final Item STICK_GOLDIR 	= new ItemBase("stick_goldir", 64);	
	
	//STAFFS
	public static final Item STAFF_1_HEAL 		   = new StaffHeal1("staff_1_heal");
	public static final Item STAFF_2_HEAL 		   = new StaffHeal2("staff_2_heal");
	public static final Item STAFF_3_HEAL 		   = new StaffHeal3("staff_3_heal");
	
	public static final Item STAFF_1_TELEPORTATION = new StaffTeleportation1("staff_1_teleportation");
	public static final Item STAFF_2_TELEPORTATION = new StaffTeleportation2("staff_2_teleportation");
	public static final Item STAFF_3_TELEPORTATION = new StaffTeleportation3("staff_3_teleportation");
	
	public static final Item STAFF_1_EXPLOSION	   = new StaffExplosion1("staff_1_explosion");
	public static final Item STAFF_2_EXPLOSION	   = new StaffExplosion2("staff_2_explosion");	
	public static final Item STAFF_3_EXPLOSION	   = new StaffExplosion3("staff_3_explosion");
	
	public static final Item STAFF_1_FIREBALL 	   = new StaffFireBall1("staff_1_fireball");
	public static final Item STAFF_2_FIREBALL 	   = new StaffFireBall2("staff_2_fireball");
	public static final Item STAFF_3_FIREBALL 	   = new StaffFireBall3("staff_3_fireball");
	
	//FOODS
	public static final Item FROZEN_BUFFALO_RAW	   = new ItemCustomFood("frozen_buffalo_raw", 2, false);
	public static final Item FROZEN_BUFFALO		   = new ItemCustomFood("frozen_buffalo", 9, false);	
	public static final Item FROZEN_BOARCHOP_RAW   = new ItemCustomFood("frozen_boarchop_raw", 2, false);
	public static final Item FROZEN_BOARCHOP	   = new ItemCustomFood("frozen_boarchop", 9, false);
	
	public static final Item FRUIT_BALL_RED 	   = new ItemCustomFood("fruit_ball_red", 1, false);
	public static final Item FRUIT_BALL_BLUE 	   = new ItemCustomFood("fruit_ball_blue", 1, false);
	public static final Item FRUIT_BALL_GREEN 	   = new ItemCustomFood("fruit_ball_green", 1, false);
	
	public static final Item DONANGOBLU_FRUIT      = new ItemCustomFood("donangoblu_fruit", 2, false);
	public static final Item KIWI 				   = new ItemCustomFood("kiwi", 1, false);
	
	//CLOCKS
	public static final Item RETURN_CLOCK		   = new ItemClock("return_clock", 0, "Return to overworld");
	public static final Item NOXIS_CLOCK		   = new ItemClock("noxis_clock", ConfigHandler.DIMENSION_NOXIS_ID, "Go to Noxis");
	public static final Item LAPUTA_CLOCK		   = new ItemClock("laputa_clock", ConfigHandler.DIMENSION_LAPUTA_ID, "Go to Laputa");
	public static final Item GOSYN_CLOCK		   = new ItemClock("gosyn_clock", ConfigHandler.DIMENSION_GOSYN_ID, "Go to Gosyn");
	public static final Item FROZ_CLOCK			   = new ItemClock("froz_clock", ConfigHandler.DIMENSION_FROZ_ID, "Go to Froz");
	
	public static final Item DEBUG				   = new debugStickySticky();

	//ARTEFACT
	public static final Item ARTEFACT_1 		   = new ArtefactFeatherOfLight();
	public static final Item ARTEFACT_2			   = new ArtefactSunTear();
	
	//GOSYN
	public static final Item MELYNCH_STICK 		  = new ItemMelynchStick();
	public static final Item AIGUITE_GEM 		  = new ItemAiguiteGem();
	public static final Item CRESEOL_TABLET_EMPTY = new ItemCreseolEmptyTablet();
	public static final Item CRESEOL_TABLET 	  = new ItemCreseolTablet();
	
	public static final Item MELYNCH_SWORD   = new ToolsMelynchSword();
	public static final Item MELYNCH_AXE 	 = new ToolsMelynchAxe();
	public static final Item MELYNCH_PICKAXE = new ToolsMelynchPickaxe();
	public static final Item MELYNCH_SHOVEL  = new ToolsMelynchShovel();
		
	public static final Item AIGUITE_SWORD   = new ToolsAiguiteSword();
	public static final Item AIGUITE_AXE 	 = new ToolsAiguiteAxe();
	public static final Item AIGUITE_PICKAXE = new ToolsAiguitePickaxe();
	public static final Item AIGUITE_SHOVEL  = new ToolsAiguiteShovel();
		
}
