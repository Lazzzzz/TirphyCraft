package com.laz.tirphycraft.entity.render.aggressive;

import com.laz.tirphycraft.entity.entityClass.aggressive.EntityBreaker;
import com.laz.tirphycraft.entity.model.aggresive.ModelBreaker;
import com.laz.tirphycraft.util.Reference;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderBreaker extends RenderLiving<EntityBreaker>{
	public static final ResourceLocation TEXTURES = new ResourceLocation(Reference.MOD_ID + ":textures/entity/breaker.png");
	
	public RenderBreaker(RenderManager manager) {
		super(manager, new ModelBreaker(), 0.5F);
	}
	
	@Override
	protected ResourceLocation getEntityTexture(EntityBreaker entity) {
		return TEXTURES;
	}
	
}
