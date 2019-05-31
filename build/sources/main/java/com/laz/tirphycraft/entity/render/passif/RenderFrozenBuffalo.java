package com.laz.tirphycraft.entity.render.passif;

import com.laz.tirphycraft.entity.model.passif.ModelFrozenBuffalo;
import com.laz.tirphycraft.entity.passif.EntityFrozenBuffalo;
import com.laz.tirphycraft.util.Reference;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderFrozenBuffalo extends RenderLiving<EntityFrozenBuffalo>{
	public static final ResourceLocation TEXTURES = new ResourceLocation(Reference.MOD_ID + ":textures/entity/frozen_buffalo.png");
	
	public RenderFrozenBuffalo(RenderManager manager) {
		super(manager, new ModelFrozenBuffalo(), 0.5F);
	}
	
	@Override
	protected ResourceLocation getEntityTexture(EntityFrozenBuffalo entity) {
		return TEXTURES;
	}
	
}
