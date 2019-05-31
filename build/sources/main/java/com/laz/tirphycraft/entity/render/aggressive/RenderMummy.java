package com.laz.tirphycraft.entity.render.aggressive;

import com.laz.tirphycraft.entity.aggressive.EntityMummy;
import com.laz.tirphycraft.util.Reference;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderMummy extends RenderBiped<EntityMummy>{
	public static final ResourceLocation TEXTURES = new ResourceLocation(Reference.MOD_ID + ":textures/entity/mummy.png");
	
	public RenderMummy(RenderManager manager) {
		super(manager, new ModelBiped(), 0.5F);
	}
	
	@Override
	protected ResourceLocation getEntityTexture(EntityMummy entity) {
		return TEXTURES;
	}
	
}
