package com.laz.tirphycraft.init;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class FurnaceRecipeInit {
	
	public static void init() {
		GameRegistry.addSmelting(new ItemStack(BlockInit.ORE_OVERWORLD, 1, 1), new ItemStack(ItemInit.CRYSTAL, 1), 0.1F);
		GameRegistry.addSmelting(new ItemStack(BlockInit.ORE_OVERWORLD, 1, 0), new ItemStack(ItemInit.CRYSTAL_PURODES, 1), 0.1F);
		GameRegistry.addSmelting(new ItemStack(BlockInit.ORE_OVERWORLD, 1, 2), new ItemStack(ItemInit.TENIUM_INGOT, 1), 0.1F);
		GameRegistry.addSmelting(new ItemStack(BlockInit.ORE_OVERWORLD, 1, 3), new ItemStack(ItemInit.COAL_ON_COKE, 1), 0.1F);
		
		GameRegistry.addSmelting(new ItemStack(BlockInit.ORE_NOXIS, 1, 1), new ItemStack(ItemInit.CRYSTAL, 1), 0.1F);
		GameRegistry.addSmelting(new ItemStack(BlockInit.ORE_NOXIS, 1, 0), new ItemStack(ItemInit.CRYSTAL_PURODES, 1), 0.1F);
		GameRegistry.addSmelting(new ItemStack(BlockInit.ORE_NOXIS, 1, 2), new ItemStack(ItemInit.TENIUM_INGOT, 1), 0.1F);
		GameRegistry.addSmelting(new ItemStack(BlockInit.ORE_NOXIS, 1, 3), new ItemStack(ItemInit.COAL_ON_COKE, 1), 0.1F);
		
		GameRegistry.addSmelting(new ItemStack(BlockInit.ORE_LAPUTA, 1, 1), new ItemStack(ItemInit.CRYSTAL, 1), 0.1F);
		GameRegistry.addSmelting(new ItemStack(BlockInit.ORE_LAPUTA, 1, 0), new ItemStack(ItemInit.CRYSTAL_PURODES, 1), 0.1F);
		GameRegistry.addSmelting(new ItemStack(BlockInit.ORE_LAPUTA, 1, 2), new ItemStack(ItemInit.TENIUM_INGOT, 1), 0.1F);
		GameRegistry.addSmelting(new ItemStack(BlockInit.ORE_LAPUTA, 1, 3), new ItemStack(ItemInit.COAL_ON_COKE, 1), 0.1F);
	
		GameRegistry.addSmelting(BlockInit.NOXIS_COBBLESTONE, new ItemStack(BlockInit.NOXIS_STONE, 1), 0.1F);
		GameRegistry.addSmelting(BlockInit.LAPUTA_COBBLESTONE, new ItemStack(BlockInit.LAPUTA_STONE, 1), 0.1F);
		GameRegistry.addSmelting(BlockInit.FROZ_COBBLESTONE, new ItemStack(BlockInit.FROZ_STONE, 1), 0.1F);
	}
}
