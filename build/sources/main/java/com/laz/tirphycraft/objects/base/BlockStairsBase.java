package com.laz.tirphycraft.objects.base;

import com.laz.tirphycraft.Main;
import com.laz.tirphycraft.init.BlockInit;
import com.laz.tirphycraft.init.ItemInit;
import com.laz.tirphycraft.util.interfaces.IHasModel;

import net.minecraft.block.BlockStairs;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;

public class BlockStairsBase extends BlockStairs implements IHasModel{

	public BlockStairsBase(String name, Material material, float hard, float resist, String type, int i, SoundType sound, IBlockState modelState, boolean fire) {
		super(modelState);
			setUnlocalizedName(name);
			setRegistryName(name);
			setCreativeTab(Main.tirphycrafttab);
			
			this.setHardness(hard);
			this.setResistance(resist);	
			this.setHarvestLevel(type, i);
			this.useNeighborBrightness = true;
			this.setSoundType(sound);
			BlockInit.BLOCKS.add(this);
			ItemInit.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
			System.out.println("initialization " + name);
			if (fire) Blocks.FIRE.setFireInfo(this, 5, 5);
				
		}

	@Override
	public void registerModels() {
		Main.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
		
	}
		

}
