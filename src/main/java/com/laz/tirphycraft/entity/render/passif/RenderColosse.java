package com.laz.tirphycraft.entity.render.passif;

import com.laz.tirphycraft.entity.entityClass.passif.EntityColosse;
import com.laz.tirphycraft.entity.model.passif.ModelColosse;
import com.laz.tirphycraft.util.Reference;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderColosse extends RenderLiving<EntityColosse>{
	public static final ResourceLocation TEXTURES = new ResourceLocation(Reference.MOD_ID + ":textures/entity/collosse.png");
	
	public RenderColosse(RenderManager manager) {
		super(manager, new ModelColosse(), 0.5F);
	}
	
	@Override
	protected ResourceLocation getEntityTexture(EntityColosse entity) {
		return TEXTURES;
	}
	
}
