package com.laz.tirphycraft.entity.render.aggressive;

import com.laz.tirphycraft.entity.aggressive.EntityFailedGolem;
import com.laz.tirphycraft.entity.model.aggresive.ModelFailedGolem;
import com.laz.tirphycraft.util.Reference;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderFailedGolem extends RenderLiving<EntityFailedGolem>{
	public static final ResourceLocation TEXTURES = new ResourceLocation(Reference.MOD_ID + ":textures/entity/failed_golem.png");
	
	public RenderFailedGolem(RenderManager manager) {
		super(manager, new ModelFailedGolem(), 0.5F);
	}
	
	@Override
	protected ResourceLocation getEntityTexture(EntityFailedGolem entity) {
		return TEXTURES;
	}
	
}
