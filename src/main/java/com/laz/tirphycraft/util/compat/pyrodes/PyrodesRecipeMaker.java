package com.laz.tirphycraft.util.compat.pyrodes;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.google.common.collect.Lists;
import com.google.common.collect.Table;
import com.laz.tirphycraft.objects.blocks.machine.pyrodes.PyrodesFurnaceRecipes;

import mezz.jei.api.IJeiHelpers;
import mezz.jei.api.recipe.IStackHelper;
import net.minecraft.item.ItemStack;

public class PyrodesRecipeMaker {
	
	public static List<PyrodesRecipe> getRecipes(IJeiHelpers helpers) {
	
		IStackHelper stackHelper = helpers.getStackHelper();
		PyrodesFurnaceRecipes instance = PyrodesFurnaceRecipes.getInstance();
		Table<ItemStack, ItemStack, ItemStack> recipes = instance.getDualSmeltingList();
		List<PyrodesRecipe> jeiRecipes = Lists.newArrayList();

		for (Entry<ItemStack, Map<ItemStack, ItemStack>> entry : recipes.columnMap().entrySet())
		{
			for (Entry<ItemStack, ItemStack> ent : entry.getValue().entrySet()) 
			{
				ItemStack input1 = entry.getKey();
				ItemStack input2 = ent.getKey();
				ItemStack output = ent.getValue();
				List<ItemStack> inputs = Lists.newArrayList(input1, input2);
				PyrodesRecipe recipe = new PyrodesRecipe(inputs, output);
				jeiRecipes.add(recipe);
			}
		}
		return jeiRecipes;
	}
}
