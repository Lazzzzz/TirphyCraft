package com.laz.tirphycraft.objects.items.tools;

import com.laz.tirphycraft.Main;
import com.laz.tirphycraft.init.ItemInit;
import com.laz.tirphycraft.util.interfaces.IHasModel;

import net.minecraft.item.ItemSword;

public class ToolSwordBase extends ItemSword implements IHasModel 
{
	public ToolSwordBase(String name, ToolMaterial material) 
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