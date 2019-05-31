package com.laz.tirphycraft.objects.blocks.machine.pyrodes;

import java.util.Map;
import java.util.Map.Entry;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Maps;
import com.google.common.collect.Table;
import com.laz.tirphycraft.init.BlockInit;
import com.laz.tirphycraft.init.ItemInit;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class PyrodesFurnaceRecipes {
	
	private static final PyrodesFurnaceRecipes INSTANCE = new PyrodesFurnaceRecipes();
	private final Table<ItemStack, ItemStack, ItemStack> smeltingList = HashBasedTable.<ItemStack, ItemStack, ItemStack>create();
	private final Map<ItemStack, Float> experienceList = Maps.<ItemStack, Float>newHashMap();
	
	public static PyrodesFurnaceRecipes getInstance()
	{
		return INSTANCE;
	}
	
	private PyrodesFurnaceRecipes() 
	{
		addPyrodesRecipe(new ItemStack(ItemInit.CRYSTAL_PURODES), new ItemStack(Items.DIAMOND), new ItemStack(ItemInit.POLY_CRYSTAL_PYRODES), 5.0F);
		addPyrodesRecipe(new ItemStack(ItemInit.CRYSTAL), new ItemStack(Items.IRON_INGOT), new ItemStack(ItemInit.STICK_CRYSTAL, 4), 1.0F);
		
		addPyrodesRecipe(new ItemStack(BlockInit.LOG_COPPIR), new ItemStack(Items.IRON_INGOT), new ItemStack(ItemInit.STICK_COPPIR, 4), 1.0F);	
		addPyrodesRecipe(new ItemStack(BlockInit.LOG_SILVIR), new ItemStack(Items.IRON_INGOT), new ItemStack(ItemInit.STICK_SILVIR, 4), 1.0F);
		addPyrodesRecipe(new ItemStack(BlockInit.LOG_GOLDIR), new ItemStack(Items.IRON_INGOT), new ItemStack(ItemInit.STICK_GOLDIR, 4), 1.0F);
		
		addPyrodesRecipe(new ItemStack(BlockInit.ORE_OVERWORLD, 1, 0), new ItemStack(BlockInit.ORE_OVERWORLD, 1, 0), new ItemStack(ItemInit.CRYSTAL_PURODES, 4), 0.1F);
		addPyrodesRecipe(new ItemStack(BlockInit.ORE_OVERWORLD, 1, 1), new ItemStack(BlockInit.ORE_OVERWORLD, 1, 1), new ItemStack(ItemInit.CRYSTAL, 4), 0.1F);
		addPyrodesRecipe(new ItemStack(BlockInit.ORE_OVERWORLD, 1, 2), new ItemStack(BlockInit.ORE_OVERWORLD, 1, 2), new ItemStack(ItemInit.TENIUM_INGOT, 3), 0.1F);
		addPyrodesRecipe(new ItemStack(BlockInit.ORE_OVERWORLD, 1, 3), new ItemStack(BlockInit.ORE_OVERWORLD, 1, 3), new ItemStack(ItemInit.COAL_ON_COKE, 4), 0.1F);
		
		addPyrodesRecipe(new ItemStack(BlockInit.ORE_NOXIS, 1, 0), new ItemStack(BlockInit.ORE_NOXIS, 1, 0), new ItemStack(ItemInit.CRYSTAL_PURODES, 4), 0.1F);
		addPyrodesRecipe(new ItemStack(BlockInit.ORE_NOXIS, 1, 1), new ItemStack(BlockInit.ORE_NOXIS, 1, 1), new ItemStack(ItemInit.CRYSTAL, 4), 0.1F);
		addPyrodesRecipe(new ItemStack(BlockInit.ORE_NOXIS, 1, 2), new ItemStack(BlockInit.ORE_NOXIS, 1, 2), new ItemStack(ItemInit.TENIUM_INGOT, 3), 0.1F);
		addPyrodesRecipe(new ItemStack(BlockInit.ORE_NOXIS, 1, 3), new ItemStack(BlockInit.ORE_NOXIS, 1, 3), new ItemStack(ItemInit.COAL_ON_COKE, 4), 0.1F);

		
		addPyrodesRecipe(new ItemStack(BlockInit.ORE_LAPUTA, 1, 0), new ItemStack(BlockInit.ORE_LAPUTA, 1, 0), new ItemStack(ItemInit.CRYSTAL_PURODES, 4), 0.1F);
		addPyrodesRecipe(new ItemStack(BlockInit.ORE_LAPUTA, 1, 1), new ItemStack(BlockInit.ORE_LAPUTA, 1, 1), new ItemStack(ItemInit.CRYSTAL, 4), 0.1F);
		addPyrodesRecipe(new ItemStack(BlockInit.ORE_LAPUTA, 1, 2), new ItemStack(BlockInit.ORE_LAPUTA, 1, 2), new ItemStack(ItemInit.TENIUM_INGOT, 3), 0.1F);
		addPyrodesRecipe(new ItemStack(BlockInit.ORE_LAPUTA, 1, 3), new ItemStack(BlockInit.ORE_LAPUTA, 1, 3), new ItemStack(ItemInit.COAL_ON_COKE, 4), 0.1F);
	}

	
	public void addPyrodesRecipe(ItemStack input1, ItemStack input2, ItemStack result, float experience) 
	{
		if(getPyrodesResult(input1, input2) != ItemStack.EMPTY) return;
		this.smeltingList.put(input1, input2, result);
		this.experienceList.put(result, Float.valueOf(experience));
	}
	
	public ItemStack getPyrodesResult(ItemStack input1, ItemStack input2) 
	{
		for(Entry<ItemStack, Map<ItemStack, ItemStack>> entry : this.smeltingList.columnMap().entrySet()) 
		{
			if(this.compareItemStacks(input1, (ItemStack)entry.getKey())) 
			{
				for(Entry<ItemStack, ItemStack> ent : entry.getValue().entrySet()) 
				{
					if(this.compareItemStacks(input2, (ItemStack)ent.getKey())) 
					{
						return (ItemStack)ent.getValue();
					}
				}
			}
		}
		return ItemStack.EMPTY;
	}
	
	private boolean compareItemStacks(ItemStack stack1, ItemStack stack2)
	{
		return stack2.getItem() == stack1.getItem() && (stack2.getMetadata() == 32767 || stack2.getMetadata() == stack1.getMetadata());
	}
	
	public Table<ItemStack, ItemStack, ItemStack> getDualSmeltingList() 
	{
		return this.smeltingList;
	}
	
	public float getPyrodesExperience(ItemStack stack)
	{
		for (Entry<ItemStack, Float> entry : this.experienceList.entrySet()) 
		{
			if(this.compareItemStacks(stack, (ItemStack)entry.getKey())) 
			{
				return ((Float)entry.getValue()).floatValue();
			}
		}
		return 0.0F;
	}
}
