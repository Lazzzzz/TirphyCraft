package com.laz.tirphycraft.entity.render.projectile;

import com.laz.tirphycraft.entity.entityClass.projectile.EntityMeteorite;
import com.laz.tirphycraft.entity.model.projectile.ModelMeteorite;
import com.laz.tirphycraft.util.Reference;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderMeteorite extends RenderLiving<EntityMeteorite>{
	public static final ResourceLocation TEXTURES = new ResourceLocation(Reference.MOD_ID + ":textures/entity/meteorite.png");
	
	public RenderMeteorite(RenderManager manager) {
		super(manager, new ModelMeteorite(), 7F);
	}
	
	@Override
	protected ResourceLocation getEntityTexture(EntityMeteorite entity) {
		return TEXTURES;
	}
	
}
