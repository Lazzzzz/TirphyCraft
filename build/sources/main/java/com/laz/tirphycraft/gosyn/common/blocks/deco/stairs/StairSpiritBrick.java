package com.laz.tirphycraft.gosyn.common.blocks.deco.stairs;

import com.laz.tirphycraft.Main;
import com.laz.tirphycraft.init.BlockInit;
import com.laz.tirphycraft.init.ItemInit;
import com.laz.tirphycraft.util.interfaces.IHasModel;

import net.minecraft.block.BlockStairs;
import net.minecraft.block.SoundType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;

public class StairSpiritBrick extends BlockStairs implements IHasModel{

	public StairSpiritBrick() {
		super(BlockInit.SPIRITBRICK.getDefaultState());
			setUnlocalizedName("spirit_brick_stair");
			setRegistryName("spirit_brick_stair");
			setCreativeTab(Main.tirphycrafttab);
			
			this.setHardness(1.5f);
			this.setResistance(30f);	
			this.setHarvestLevel("pickaxe", 0);
			this.setSoundType(SoundType.STONE);
			
			this.useNeighborBrightness = true;
			
			BlockInit.BLOCKS.add(this);
			ItemInit.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
			
				
		}

	@Override
	public void registerModels() {
		Main.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
		
	}
		

}
