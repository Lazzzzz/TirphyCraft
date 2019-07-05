package com.laz.tirphycraft.entity.render.neutral;

import com.laz.tirphycraft.entity.entityClass.neutral.EntityMothmoth;
import com.laz.tirphycraft.entity.model.neutral.ModelMothmoth;
import com.laz.tirphycraft.util.Reference;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderMothmoth extends RenderLiving<EntityMothmoth>{
	public static final ResourceLocation TEXTURES = new ResourceLocation(Reference.MOD_ID + ":textures/entity/mothmoth.png");
	
	public RenderMothmoth(RenderManager manager) {
		super(manager, new ModelMothmoth(), 0.5F);
	}
	
	@Override
	protected ResourceLocation getEntityTexture(EntityMothmoth entity) {
		return TEXTURES;
	}
	
}
