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

	public static boolean SPAWN_BIOMES_OVERWORLD = ConfigHandler.SPAWN_BIOMES_OVERWORLD;
}
