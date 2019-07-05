package com.laz.tirphycraft.entity.render.passif;

import com.laz.tirphycraft.entity.entityClass.passif.EntityMontauk;
import com.laz.tirphycraft.entity.model.aggresive.ModelMontauk;
import com.laz.tirphycraft.util.Reference;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderMontauk extends RenderLiving<EntityMontauk>{
	public static final ResourceLocation TEXTURES = new ResourceLocation(Reference.MOD_ID + ":textures/entity/montauk.png");
	
	public RenderMontauk(RenderManager manager) {
		super(manager, new ModelMontauk(), 0.5F);
	}
	
	@Override
	protected ResourceLocation getEntityTexture(EntityMontauk entity) {
		return TEXTURES;
	}
	
}
