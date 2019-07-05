package com.laz.tirphycraft.entity.render.aggressive;

import com.laz.tirphycraft.entity.entityClass.aggressive.EntityPlyton;
import com.laz.tirphycraft.entity.model.aggresive.ModelPlyton;
import com.laz.tirphycraft.util.Reference;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderPlyton extends RenderLiving<EntityPlyton>{
	public static final ResourceLocation TEXTURES = new ResourceLocation(Reference.MOD_ID + ":textures/entity/plyton.png");
	
	public RenderPlyton(RenderManager manager) {
		super(manager, new ModelPlyton(), 0.5F);
	}
	
	@Override
	protected ResourceLocation getEntityTexture(EntityPlyton entity) {
		return TEXTURES;
	}
	
}
