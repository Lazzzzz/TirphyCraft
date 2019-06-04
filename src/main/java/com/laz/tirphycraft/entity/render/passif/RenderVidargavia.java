package com.laz.tirphycraft.entity.render.passif;

import com.laz.tirphycraft.entity.entityClass.passif.EntityVidargavia;
import com.laz.tirphycraft.entity.model.passif.ModelVidargavia;
import com.laz.tirphycraft.util.Reference;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderVidargavia extends RenderLiving<EntityVidargavia>{
	public static final ResourceLocation TEXTURES = new ResourceLocation(Reference.MOD_ID + ":textures/entity/vidargavia.png");
	
	public RenderVidargavia(RenderManager manager) {
		super(manager, new ModelVidargavia(), 0.5F);
	}
	
	@Override
	protected ResourceLocation getEntityTexture(EntityVidargavia entity) {
		return TEXTURES;
	}
	
}
