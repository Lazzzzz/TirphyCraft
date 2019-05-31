package com.laz.tirphycraft.util.compat.pyrodes;

import com.laz.tirphycraft.util.Reference;
import com.laz.tirphycraft.util.compat.RecipeCategories;

import mezz.jei.api.IGuiHelper;
import mezz.jei.api.gui.IDrawable;
import mezz.jei.api.gui.IGuiItemStackGroup;
import mezz.jei.api.gui.IRecipeLayout;
import mezz.jei.api.ingredients.IIngredients;
import net.minecraft.client.Minecraft;

public class PyrodesRecipeCategory extends AbstractPyrodesRecipeCategory<PyrodesRecipe>{
	
	private final IDrawable background;
	private final String name;
	
	public PyrodesRecipeCategory(IGuiHelper helper) {
		super(helper);
		background = helper.createDrawable(TEXTURES, 4, 12, 150, 60);
		name = "Pyrodes Furnace";
		
	}

	@Override
	public String getUid() {
		return RecipeCategories.PYRODES;
	}

	@Override
	public String getTitle() {
		return name;
	}

	@Override
	public String getModName() {
		return Reference.NAME;
	}

	@Override
	public IDrawable getBackground() {
		return background;
	}

	@Override
	public void setRecipe(IRecipeLayout recipeLayout, PyrodesRecipe recipeWrapper, IIngredients ingredients) {
		IGuiItemStackGroup stacks = recipeLayout.getItemStacks();
		stacks.init(input1, true, 16, 10);
		stacks.init(input2, true, 20, 10);
		stacks.init(output, false, 111, 22);
		stacks.set(ingredients);
		
	}
	
	public void drawExtras(Minecraft minecraft) {
		animatedFlame.draw(minecraft, 33, 27);
		animatedArrow.draw(minecraft, 75,23);
	}
}
