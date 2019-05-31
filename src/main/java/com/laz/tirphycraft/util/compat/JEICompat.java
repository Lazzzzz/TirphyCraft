package com.laz.tirphycraft.util.compat;

import java.util.IllegalFormatException;

import com.laz.tirphycraft.objects.blocks.machine.pyrodes.ContainerPyrodesFurnace;
import com.laz.tirphycraft.objects.blocks.machine.pyrodes.GuiPyrodesFurnace;
import com.laz.tirphycraft.util.compat.pyrodes.PyrodesRecipeCategory;
import com.laz.tirphycraft.util.compat.pyrodes.PyrodesRecipeMaker;

import mezz.jei.api.IGuiHelper;
import mezz.jei.api.IJeiHelpers;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.IModRegistry;
import mezz.jei.api.JEIPlugin;
import mezz.jei.api.ingredients.IIngredientRegistry;
import mezz.jei.api.recipe.IRecipeCategoryRegistration;
import mezz.jei.api.recipe.transfer.IRecipeTransferRegistry;
import net.minecraft.util.text.translation.I18n;

@JEIPlugin
public class JEICompat implements IModPlugin {

	@Override
	public void registerCategories(IRecipeCategoryRegistration registry) {
		final IJeiHelpers helpers = registry.getJeiHelpers();
		final IGuiHelper gui = helpers.getGuiHelper();
		
		registry.addRecipeCategories(new PyrodesRecipeCategory(gui));
	}

	@Override
	public void register(IModRegistry registry) {
		final IIngredientRegistry ingredientRegistry = registry.getIngredientRegistry();
		final IJeiHelpers iJeiHelpers = registry.getJeiHelpers();
		IRecipeTransferRegistry recipeTransfer = registry.getRecipeTransferRegistry();
	
		registry.addRecipes(PyrodesRecipeMaker.getRecipes(iJeiHelpers), RecipeCategories.PYRODES);
		registry.addRecipeClickArea(GuiPyrodesFurnace.class, 80, 35, 24, 17, RecipeCategories.PYRODES);
		recipeTransfer.addRecipeTransferHandler(ContainerPyrodesFurnace.class, RecipeCategories.PYRODES, 0, 1, 3, 36);
	
		
	}

	public static String translateToLocal(String key) {
		if (I18n.canTranslate(key))
			return I18n.translateToLocal(key);
		else
			return I18n.translateToFallback(key);
	}

	public static String translateToLocalFormatted(String key, Object... format) {
		String s = translateToLocal(key);
		try {
			return String.format(s, format);
		}catch(IllegalFormatException e) {
			return "Format error: " + s;
		}
	}

}
