package com.laz.tirphycraft.gosyn.common.items.tools.aiguite;

import com.laz.tirphycraft.Main;
import com.laz.tirphycraft.gosyn.common.items.tools.base.ToolsGosynShovel;
import com.laz.tirphycraft.init.ItemInit;
import com.laz.tirphycraft.init.ToolsInit;
import com.laz.tirphycraft.util.interfaces.IHasModel;

public class ToolsAiguiteShovel extends ToolsGosynShovel implements IHasModel
{
	public ToolsAiguiteShovel() 
	{
		super(ToolsInit.AIGUITE_TOOL);
		setUnlocalizedName("aiguite_shovel");
		setRegistryName("aiguite_shovel");
		setCreativeTab(Main.tirphycrafttab);
		
		ItemInit.ITEMS.add(this);
	}

	@Override
	public void registerModels() 
	{
		Main.proxy.registerItemRenderer(this, 0, "inventory");
	}
}