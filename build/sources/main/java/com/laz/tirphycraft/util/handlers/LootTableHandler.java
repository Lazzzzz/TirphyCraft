package com.laz.tirphycraft.util.handlers;

import com.laz.tirphycraft.util.Reference;

import net.minecraft.util.ResourceLocation;
import net.minecraft.world.storage.loot.LootTableList;

public class LootTableHandler {
	public static final ResourceLocation CHEST_DUNGEONS_TIER_1 = LootTableList.register(new ResourceLocation(Reference.MOD_ID, "chest_dungeons_overworld"));
	public static final ResourceLocation TOWER_DUNGEONS        = LootTableList.register(new ResourceLocation(Reference.MOD_ID, "tower/tower"));
	
	public static final ResourceLocation QUEEN_CREEPER_LOOT		= LootTableList.register(new ResourceLocation(Reference.MOD_ID, "mob/creeper_queen_loot"));
	
	public static final ResourceLocation PHORUS_LOOT 			= LootTableList.register(new ResourceLocation(Reference.MOD_ID, "mob/phorus_loot"));
	public static final ResourceLocation TOTAM_LOOT 			= LootTableList.register(new ResourceLocation(Reference.MOD_ID, "mob/totam_loot"));
	public static final ResourceLocation CLOUDY_LOOT 			= LootTableList.register(new ResourceLocation(Reference.MOD_ID, "mob/cloudy_loot"));
	public static final ResourceLocation GRINDLYUP_LOOT			= LootTableList.register(new ResourceLocation(Reference.MOD_ID, "mob/grindly_up_loot"));
	public static final ResourceLocation GRINDLYFRONT_LOOT		= LootTableList.register(new ResourceLocation(Reference.MOD_ID, "mob/grindly_front_loot"));
	public static final ResourceLocation GRINDLYBOTH_LOOT		= LootTableList.register(new ResourceLocation(Reference.MOD_ID, "mob/grindly_both_loot"));

}
