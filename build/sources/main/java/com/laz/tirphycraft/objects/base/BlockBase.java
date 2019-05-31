package com.laz.tirphycraft.objects.base;

import com.laz.tirphycraft.Main;
import com.laz.tirphycraft.init.BlockInit;
import com.laz.tirphycraft.init.ItemInit;
import com.laz.tirphycraft.util.interfaces.IHasModel;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;

public class BlockBase extends Block implements IHasModel {
	
	public BlockBase(String name, Material material, float hard, float resist, String type, int i, SoundType sound) {
		super(material);
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(Main.tirphycrafttab);
		
		this.setHardness(hard);
		this.setResistance(resist);	
		this.setHarvestLevel(type, i);
		this.setSoundType(sound);
		BlockInit.BLOCKS.add(this);
		ItemInit.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
		System.out.println("initialization " + name);

			
	}
	
	
	@Override
	public void registerModels() {
		Main.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
		
	}

}
