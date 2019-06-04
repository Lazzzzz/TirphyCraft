package com.laz.tirphycraft.entity.render.aggressive;

import com.laz.tirphycraft.entity.entityClass.aggressive.EntityHeadLess;
import com.laz.tirphycraft.entity.model.aggresive.ModelHeadless;
import com.laz.tirphycraft.util.Reference;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderHeadLess extends RenderLiving<EntityHeadLess>{
	public static final ResourceLocation TEXTURES = new ResourceLocation(Reference.MOD_ID + ":textures/entity/head_less.png");
	
	public RenderHeadLess(RenderManager manager) {
		super(manager, new ModelHeadless(), 0.5F);
	}
	
	@Override
	protected ResourceLocation getEntityTexture(EntityHeadLess entity) {
		return TEXTURES;
	}
	
}
