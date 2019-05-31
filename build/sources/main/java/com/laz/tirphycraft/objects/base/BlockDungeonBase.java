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

public class BlockDungeonBase extends Block implements IHasModel {

	public BlockDungeonBase(String name, SoundType sound) {
		super(Material.ROCK);
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(Main.tirphycrafttab);
		
		this.setSoundType(sound);
		this.setBlockUnbreakable();
		BlockInit.BLOCKS.add(this);
		ItemInit.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
		System.out.println("initialization " + name);

			
	}

	@Override
	public void registerModels() {
		Main.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");

	}
}
