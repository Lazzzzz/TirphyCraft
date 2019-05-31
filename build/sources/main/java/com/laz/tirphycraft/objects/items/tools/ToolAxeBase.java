package com.laz.tirphycraft.objects.items.tools;

import java.util.Set;

import com.google.common.collect.Sets;
import com.laz.tirphycraft.Main;
import com.laz.tirphycraft.init.BlockInit;
import com.laz.tirphycraft.init.ItemInit;
import com.laz.tirphycraft.util.interfaces.IHasModel;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;

public class ToolAxeBase extends ItemTool implements IHasModel {
	private static final Set<Block> EFFECTIVE_ON = Sets.newHashSet(Blocks.PLANKS, Blocks.BOOKSHELF, Blocks.LOG,
			Blocks.LOG2, Blocks.CHEST, Blocks.PUMPKIN, Blocks.LIT_PUMPKIN, Blocks.MELON_BLOCK, Blocks.LADDER,
			Blocks.WOODEN_BUTTON, Blocks.WOODEN_PRESSURE_PLATE, BlockInit.LOG_COPPIR, BlockInit.LOG_GOLDIR,
			BlockInit.LOG_SILVIR, BlockInit.PLANKS_COPPIR, BlockInit.PLANKS_GOLDIR, BlockInit.PLANKS_SILVIR);

	public ToolAxeBase(String name, ToolMaterial material) {
		super(material, EFFECTIVE_ON);
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(Main.tirphycrafttab);
		this.attackSpeed = -3.1F;

		ItemInit.ITEMS.add(this);
		System.out.println("initialization" + name);
	}

	public float getStrVsBlock(ItemStack stack, IBlockState state) {
		Material material = state.getMaterial();
		return material != Material.WOOD && material != Material.PLANTS && material != Material.VINE ? 1
				: this.toolMaterial.getEfficiency();
	}
	
	@Override
    public float getDestroySpeed(ItemStack stack, IBlockState state)
    {
        Material material = state.getMaterial();
        return material != Material.WOOD && material != Material.PLANTS && material != Material.VINE ? super.getDestroySpeed(stack, state) : this.efficiency;
    }
	

	@Override
	public void registerModels() {
		Main.proxy.registerItemRenderer(this, 0, "inventory");
	}
}