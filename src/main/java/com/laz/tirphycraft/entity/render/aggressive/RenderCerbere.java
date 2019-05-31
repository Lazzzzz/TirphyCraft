package com.laz.tirphycraft.entity.render.aggressive;

import com.laz.tirphycraft.entity.aggressive.EntityCerbere;
import com.laz.tirphycraft.entity.model.aggresive.ModelCerbere;
import com.laz.tirphycraft.util.Reference;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderCerbere extends RenderLiving<EntityCerbere>{
	public static final ResourceLocation TEXTURES = new ResourceLocation(Reference.MOD_ID + ":textures/entity/cerbere.png");
	
	public RenderCerbere(RenderManager manager) {
		super(manager, new ModelCerbere(), 0.5F);
	}
	
	@Override
	protected ResourceLocation getEntityTexture(EntityCerbere entity) {
		return TEXTURES;
	}
	
}
