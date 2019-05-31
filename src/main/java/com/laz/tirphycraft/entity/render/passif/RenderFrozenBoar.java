package com.laz.tirphycraft.entity.render.passif;

import com.laz.tirphycraft.entity.model.passif.ModelFrozenPig;
import com.laz.tirphycraft.entity.passif.EntityFrozenBoar;
import com.laz.tirphycraft.util.Reference;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderFrozenBoar extends RenderLiving<EntityFrozenBoar>{
	public static final ResourceLocation TEXTURES = new ResourceLocation(Reference.MOD_ID + ":textures/entity/frozen_boar.png");
	
	public RenderFrozenBoar(RenderManager manager) {
		super(manager, new ModelFrozenPig(), 0.5F);
	}
	
	@Override
	protected ResourceLocation getEntityTexture(EntityFrozenBoar entity) {
		return TEXTURES;
	}
	
}
