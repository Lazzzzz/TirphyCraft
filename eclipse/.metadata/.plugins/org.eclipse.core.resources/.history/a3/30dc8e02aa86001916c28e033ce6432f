package com.laz.tirphycraft.entity.render.passif;

import com.laz.tirphycraft.entity.model.passif.ModelCrystim;
import com.laz.tirphycraft.entity.passif.EntityCrystim;
import com.laz.tirphycraft.util.Reference;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderCrystim extends RenderLiving<EntityCrystim>{
	public static final ResourceLocation TEXTURES = new ResourceLocation(Reference.MOD_ID + ":textures/entity/crystim.png");
	
	public RenderCrystim(RenderManager manager) {
		super(manager, new ModelCrystim(), 0.5F);
	}
	
	@Override
	protected ResourceLocation getEntityTexture(EntityCrystim entity) {
		return TEXTURES;
	}
	
}
