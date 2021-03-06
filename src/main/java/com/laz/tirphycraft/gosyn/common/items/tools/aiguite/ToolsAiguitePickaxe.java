package com.laz.tirphycraft.gosyn.common.items.tools.aiguite;

import com.laz.tirphycraft.Main;
import com.laz.tirphycraft.gosyn.common.items.tools.base.ToolsGosynPickaxe;
import com.laz.tirphycraft.init.ItemInit;
import com.laz.tirphycraft.init.ToolsInit;
import com.laz.tirphycraft.util.interfaces.IHasModel;

public class ToolsAiguitePickaxe extends ToolsGosynPickaxe implements IHasModel
{
	public ToolsAiguitePickaxe() 
	{
		super(ToolsInit.AIGUITE_TOOL);
		setUnlocalizedName("aiguite_pickaxe");
		setRegistryName("aiguite_pickaxe");
		setCreativeTab(Main.tirphycrafttab);
		
		ItemInit.ITEMS.add(this);
	}

	@Override
	public void registerModels() 
	{
		Main.proxy.registerItemRenderer(this, 0, "inventory");
	}
}