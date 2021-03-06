package com.laz.tirphycraft.gosyn.common.blocks.tree;

import com.laz.tirphycraft.Main;
import com.laz.tirphycraft.init.BlockInit;
import com.laz.tirphycraft.init.ItemInit;
import com.laz.tirphycraft.util.interfaces.IHasModel;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;

public class BlockMushrooomStem extends Block implements IHasModel{

	public BlockMushrooomStem() {
		super(Material.WOOD);
		setUnlocalizedName("mushrooom_stem");
		setRegistryName("mushrooom_stem");
		setCreativeTab(Main.tirphycrafttab);
		Blocks.FIRE.setFireInfo(this, 5, 5);
		
		
		this.setHardness(2f);
		this.setResistance(15f);	
		this.setHarvestLevel("axe", 0);
		this.setSoundType(SoundType.WOOD);
		
		BlockInit.BLOCKS.add(this);
		ItemInit.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
	}

	@Override
	public void registerModels() {
		Main.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
		
	}

}
