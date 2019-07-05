package com.laz.tirphycraft.entity.render.boss;

import com.laz.tirphycraft.entity.entityClass.boss.EntityArtikon;
import com.laz.tirphycraft.entity.model.boss.ModelArtikon;
import com.laz.tirphycraft.util.Reference;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderArtikon extends RenderLiving<EntityArtikon>{
	public static final ResourceLocation TEXTURES = new ResourceLocation(Reference.MOD_ID + ":textures/entity/artikon.png");
	
	public RenderArtikon(RenderManager manager) {
		super(manager, new ModelArtikon(), 1F);
	}
	
	@Override
	protected ResourceLocation getEntityTexture(EntityArtikon entity) {
		return TEXTURES;
	}
	
}
