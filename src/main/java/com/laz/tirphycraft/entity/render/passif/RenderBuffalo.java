package com.laz.tirphycraft.entity.render.passif;

import com.laz.tirphycraft.entity.entityClass.passif.EntityBuffalo;
import com.laz.tirphycraft.entity.model.passif.ModelBuffalo;
import com.laz.tirphycraft.util.Reference;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderBuffalo extends RenderLiving<EntityBuffalo>{
	public static final ResourceLocation TEXTURES = new ResourceLocation(Reference.MOD_ID + ":textures/entity/buffalo.png");
	
	public RenderBuffalo(RenderManager manager) {
		super(manager, new ModelBuffalo(), 0.5F);
	}
	
	@Override
	protected ResourceLocation getEntityTexture(EntityBuffalo entity) {
		return TEXTURES;
	}
	
}
