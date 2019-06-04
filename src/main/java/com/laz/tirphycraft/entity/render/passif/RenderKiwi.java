package com.laz.tirphycraft.entity.render.passif;

import com.laz.tirphycraft.entity.entityClass.passif.EntityKiwi;
import com.laz.tirphycraft.entity.model.passif.ModelKiwi;
import com.laz.tirphycraft.util.Reference;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderKiwi extends RenderLiving<EntityKiwi>{
	public static final ResourceLocation TEXTURES = new ResourceLocation(Reference.MOD_ID + ":textures/entity/kiwi.png");
	
	public RenderKiwi(RenderManager manager) {
		super(manager, new ModelKiwi(), 0.7F);
	}
	
	@Override
	protected ResourceLocation getEntityTexture(EntityKiwi entity) {
		return TEXTURES;
	}
	
}
