package com.laz.tirphycraft.entity.render.boss;

import com.laz.tirphycraft.entity.boss.EntityQueenCreeper;
import com.laz.tirphycraft.entity.model.boss.ModelQueenCreeper;
import com.laz.tirphycraft.util.Reference;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderQueenCreeper extends RenderLiving<EntityQueenCreeper>{
	public static final ResourceLocation TEXTURES = new ResourceLocation(Reference.MOD_ID + ":textures/entity/queen_creeper.png");
	
	public RenderQueenCreeper(RenderManager manager) {
		super(manager, new ModelQueenCreeper(), 0.5F);
	}
	
	@Override
	protected ResourceLocation getEntityTexture(EntityQueenCreeper entity) {
		return TEXTURES;
	}
	
}
