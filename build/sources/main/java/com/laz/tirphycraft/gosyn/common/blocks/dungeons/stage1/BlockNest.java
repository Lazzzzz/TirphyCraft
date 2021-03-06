package com.laz.tirphycraft.gosyn.common.blocks.dungeons.stage1;

import com.laz.tirphycraft.Main;
import com.laz.tirphycraft.init.BlockInit;
import com.laz.tirphycraft.init.ItemInit;
import com.laz.tirphycraft.util.interfaces.IHasModel;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;

public class BlockNest extends Block implements IHasModel {

	public BlockNest() {
		super(Material.ROCK);
		setUnlocalizedName("nest_block");
		setRegistryName("nest_block");
		setCreativeTab(Main.tirphycrafttab);

		this.setHardness(2f);
		this.setResistance(30f);
		this.setHarvestLevel("shovel", 0);
		this.setSoundType(SoundType.CLOTH);

		BlockInit.BLOCKS.add(this);
		ItemInit.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));

	}

	@Override
	public void registerModels() {
		Main.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");

	}

}
