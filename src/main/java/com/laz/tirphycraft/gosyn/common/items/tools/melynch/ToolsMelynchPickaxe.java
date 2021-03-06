package com.laz.tirphycraft.gosyn.common.items.tools.melynch;

import com.laz.tirphycraft.Main;
import com.laz.tirphycraft.gosyn.common.items.tools.base.ToolsGosynPickaxe;
import com.laz.tirphycraft.init.ItemInit;
import com.laz.tirphycraft.util.interfaces.IHasModel;

public class ToolsMelynchPickaxe extends ToolsGosynPickaxe implements IHasModel
{
	public ToolsMelynchPickaxe() 
	{
		super(ToolMaterial.WOOD);
		setUnlocalizedName("melynch_pickaxe");
		setRegistryName("melynch_pickaxe");
		setCreativeTab(Main.tirphycrafttab);
		
		ItemInit.ITEMS.add(this);
	}

	@Override
	public void registerModels() 
	{
		Main.proxy.registerItemRenderer(this, 0, "inventory");
	}
}