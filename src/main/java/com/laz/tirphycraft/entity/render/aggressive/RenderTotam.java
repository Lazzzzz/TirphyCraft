package com.laz.tirphycraft.entity.render.aggressive;

import com.laz.tirphycraft.entity.entityClass.aggressive.EntityTotam;
import com.laz.tirphycraft.entity.model.aggresive.ModelTotam;
import com.laz.tirphycraft.util.Reference;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderTotam extends RenderLiving<EntityTotam>{
	public static final ResourceLocation TEXTURES = new ResourceLocation(Reference.MOD_ID + ":textures/entity/totam.png");
	
	public RenderTotam(RenderManager manager) {
		super(manager, new ModelTotam(), 0.5F);
	}
	
	@Override
	protected ResourceLocation getEntityTexture(EntityTotam entity) {
		return TEXTURES;
	}
	
}
