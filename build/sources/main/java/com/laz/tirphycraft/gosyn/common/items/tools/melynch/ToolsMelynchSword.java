package com.laz.tirphycraft.gosyn.common.items.tools.melynch;

import com.laz.tirphycraft.Main;
import com.laz.tirphycraft.gosyn.common.items.tools.base.ToolsGosynSword;
import com.laz.tirphycraft.init.ItemInit;
import com.laz.tirphycraft.util.interfaces.IHasModel;

public class ToolsMelynchSword extends ToolsGosynSword implements IHasModel {
	public ToolsMelynchSword() {
		super(ToolMaterial.WOOD);
		setUnlocalizedName("melynch_sword");
		setRegistryName("melynch_sword");
		setCreativeTab(Main.tirphycrafttab);

		ItemInit.ITEMS.add(this);
	}

	@Override
	public void registerModels() {
		Main.proxy.registerItemRenderer(this, 0, "inventory");
	}
}