package com.laz.tirphycraft.entity.render.aggressive;

import com.laz.tirphycraft.entity.entityClass.aggressive.EntityAngrySnowGolemSoldier;
import com.laz.tirphycraft.util.Reference;

import net.minecraft.client.model.ModelSnowMan;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderAngrySnowGolemSoldier extends RenderLiving<EntityAngrySnowGolemSoldier>{
	public static final ResourceLocation TEXTURES = new ResourceLocation(Reference.MOD_ID + ":textures/entity/angry_snowgolem_soldier.png");
	
	public RenderAngrySnowGolemSoldier(RenderManager manager) {
		super(manager, new ModelSnowMan(), 0.5F);
	}
	
	@Override
	protected ResourceLocation getEntityTexture(EntityAngrySnowGolemSoldier entity) {
		return TEXTURES;
	}
	
}
