package com.laz.tirphycraft.entity.render.passif;

import com.laz.tirphycraft.entity.model.passif.ModelDragonFly;
import com.laz.tirphycraft.entity.passif.EntityDragonFly;
import com.laz.tirphycraft.util.Reference;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderDragonFly extends RenderLiving<EntityDragonFly>{
	public static final ResourceLocation TEXTURES = new ResourceLocation(Reference.MOD_ID + ":textures/entity/dragonfly.png");
	
	public RenderDragonFly(RenderManager manager) {
		super(manager, new ModelDragonFly(), 0.5F);
	}
	
	@Override
	protected ResourceLocation getEntityTexture(EntityDragonFly entity) {
		return TEXTURES;
	}
	
}
