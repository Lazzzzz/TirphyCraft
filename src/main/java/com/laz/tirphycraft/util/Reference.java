package com.laz.tirphycraft.util;

import com.laz.tirphycraft.proxy.ClientProxy;
import com.laz.tirphycraft.proxy.CommonProxy;
import com.laz.tirphycraft.util.handlers.ConfigHandler;

public class Reference {
	public static final String MOD_ID = "tirphycraft";
	public static final String NAME = "Tirphy Craft";
	public static final String VERSION = "0.2";
	public static final String ACCEPTED_VERSION = "[1.12.2]";
	public static final String CLIENT_PROXY_CLASS = "com.laz.tirphycraft.proxy.ClientProxy";
	public static final String COMMOM_PROXY_CLASS = "com.laz.tirphycraft.proxy.CommonProxy";
	public static final CommonProxy PROXY = new ClientProxy();

	public static int MAX_PASSIF_CREATURE = ConfigHandler.MAX_PASSIF_CREATURE;
	public static int MAX_SIZE_CLOUD = ConfigHandler.MAX_SIZE_CLOUD;

	public static boolean SPAWN_BIOMES_OVERWORLD = ConfigHandler.SPAWN_BIOMES_OVERWORLD;
}
