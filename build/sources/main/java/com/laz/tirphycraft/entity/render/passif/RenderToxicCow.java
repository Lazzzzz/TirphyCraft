package com.laz.tirphycraft.entity.render.passif;

import com.laz.tirphycraft.entity.entityClass.passif.EntityToxisCow;
import com.laz.tirphycraft.entity.model.passif.ModelToxisCow;
import com.laz.tirphycraft.util.Reference;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderToxicCow extends RenderLiving<EntityToxisCow>{
	public static final ResourceLocation TEXTURES = new ResourceLocation(Reference.MOD_ID + ":textures/entity/toxic_cow.png");
	
	public RenderToxicCow(RenderManager manager) {
		super(manager, new ModelToxisCow(), 0.5F);
	}
	
	@Override
	protected ResourceLocation getEntityTexture(EntityToxisCow entity) {
		return TEXTURES;
	}
	
}
