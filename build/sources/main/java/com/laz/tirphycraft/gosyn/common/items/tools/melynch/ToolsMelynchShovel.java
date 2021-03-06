package com.laz.tirphycraft.gosyn.common.items.tools.melynch;

import com.laz.tirphycraft.Main;
import com.laz.tirphycraft.gosyn.common.items.tools.base.ToolsGosynShovel;
import com.laz.tirphycraft.init.ItemInit;
import com.laz.tirphycraft.util.interfaces.IHasModel;

public class ToolsMelynchShovel extends ToolsGosynShovel implements IHasModel
{
	public ToolsMelynchShovel() 
	{
		super(ToolMaterial.WOOD);
		setUnlocalizedName("melynch_shovel");
		setRegistryName("melynch_shovel");
		setCreativeTab(Main.tirphycrafttab);
		
		ItemInit.ITEMS.add(this);
	}

	@Override
	public void registerModels() 
	{
		Main.proxy.registerItemRenderer(this, 0, "inventory");
	}
}