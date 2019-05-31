package com.laz.tirphycraft.objects.items.tools;

import com.laz.tirphycraft.Main;
import com.laz.tirphycraft.init.ItemInit;
import com.laz.tirphycraft.util.interfaces.IHasModel;

import net.minecraft.item.ItemHoe;

public class ToolHoeBase extends ItemHoe implements IHasModel 
{
	public ToolHoeBase(String name, ToolMaterial material) 
	{
		super(material);
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(Main.tirphycrafttab);
		
		ItemInit.ITEMS.add(this);
		System.out.println("initialization" + name);
	}

	@Override
	public void registerModels() 
	{
		Main.proxy.registerItemRenderer(this, 0, "inventory");
	}
}
