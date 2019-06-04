package com.laz.tirphycraft.entity.render.boss;

import com.laz.tirphycraft.entity.entityClass.boss.EntityHellKing;
import com.laz.tirphycraft.entity.model.boss.ModelHellKing;
import com.laz.tirphycraft.util.Reference;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderHellKing extends RenderLiving<EntityHellKing>{
	public static final ResourceLocation TEXTURES = new ResourceLocation(Reference.MOD_ID + ":textures/entity/hell_king.png");
	
	public RenderHellKing(RenderManager manager) {
		super(manager, new ModelHellKing(), 1F);
	}
	
	@Override
	protected ResourceLocation getEntityTexture(EntityHellKing entity) {
		return TEXTURES;
	}
	
}
