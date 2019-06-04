package com.laz.tirphycraft.entity.render.aggressive;

import com.laz.tirphycraft.entity.entityClass.aggressive.EntitySkull;
import com.laz.tirphycraft.entity.model.aggresive.modelSkull;
import com.laz.tirphycraft.util.Reference;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderSkull extends RenderLiving<EntitySkull>{
	public static final ResourceLocation TEXTURES = new ResourceLocation(Reference.MOD_ID + ":textures/entity/skull.png");
	
	public RenderSkull(RenderManager manager) {
		super(manager, new modelSkull(), 0.5F);
	}
	
	@Override
	protected ResourceLocation getEntityTexture(EntitySkull entity) {
		return TEXTURES;
	}
	
}
