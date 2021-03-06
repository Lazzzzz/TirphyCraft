package com.laz.tirphycraft.entity.render.neutral;

import com.laz.tirphycraft.entity.entityClass.neutral.EntityStellar;
import com.laz.tirphycraft.entity.model.neutral.ModelStellar;
import com.laz.tirphycraft.util.Reference;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderStellar extends RenderLiving<EntityStellar>{
	public static final ResourceLocation TEXTURES = new ResourceLocation(Reference.MOD_ID + ":textures/entity/stellar.png");
	
	public RenderStellar(RenderManager manager) {
		super(manager, new ModelStellar(), 0.5F);
	}
	
	@Override
	protected ResourceLocation getEntityTexture(EntityStellar entity) {
		return TEXTURES;
	}
	
}
