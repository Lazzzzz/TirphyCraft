package com.laz.tirphycraft.entity.render.aggressive;

import com.laz.tirphycraft.entity.entityClass.aggressive.EntityDeadPlayer;
import com.laz.tirphycraft.entity.model.aggresive.ModelDeadPlayer;
import com.laz.tirphycraft.util.Reference;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderDeadPlayer extends RenderLiving<EntityDeadPlayer>{
	public static final ResourceLocation TEXTURES = new ResourceLocation(Reference.MOD_ID + ":textures/entity/deadplayer.png");
	
	public RenderDeadPlayer(RenderManager manager) {
		super(manager, new ModelDeadPlayer(), 0.5F);
	}
	
	@Override
	protected ResourceLocation getEntityTexture(EntityDeadPlayer entity) {
		return TEXTURES;
	}
	
}
