package com.laz.tirphycraft.gosyn.common.items.tools.aiguite;

import com.laz.tirphycraft.Main;
import com.laz.tirphycraft.gosyn.common.items.tools.base.ToolsGosynSword;
import com.laz.tirphycraft.init.ItemInit;
import com.laz.tirphycraft.init.ToolsInit;
import com.laz.tirphycraft.util.interfaces.IHasModel;

public class ToolsAiguiteSword extends ToolsGosynSword implements IHasModel {
	public ToolsAiguiteSword() {
		super(ToolsInit.AIGUITE_TOOL);
		setUnlocalizedName("aiguite_sword");
		setRegistryName("aiguite_sword");
		setCreativeTab(Main.tirphycrafttab);

		ItemInit.ITEMS.add(this);
	}

	@Override
	public void registerModels() {
		Main.proxy.registerItemRenderer(this, 0, "inventory");
	}
}