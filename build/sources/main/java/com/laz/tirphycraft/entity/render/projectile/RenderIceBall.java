package com.laz.tirphycraft.entity.render.projectile;

import com.laz.tirphycraft.entity.entityClass.projectile.EntityIceBall;
import com.laz.tirphycraft.entity.model.projectile.ModelIceBall;
import com.laz.tirphycraft.util.Reference;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderIceBall extends RenderLiving<EntityIceBall>{
	public static final ResourceLocation TEXTURES = new ResourceLocation(Reference.MOD_ID + ":textures/entity/ice_ball.png");
	
	public RenderIceBall(RenderManager manager) {
		super(manager, new ModelIceBall(), 0.5F);
	}
	
	@Override
	protected ResourceLocation getEntityTexture(EntityIceBall entity) {
		return TEXTURES;
	}
	
}
