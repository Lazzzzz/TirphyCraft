package com.laz.tirphycraft.entity.render.aggressive;

import com.laz.tirphycraft.entity.aggressive.EntityDemon;
import com.laz.tirphycraft.entity.model.aggresive.ModelDemon;
import com.laz.tirphycraft.util.Reference;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderDemon extends RenderLiving<EntityDemon>{
	public static final ResourceLocation TEXTURES = new ResourceLocation(Reference.MOD_ID + ":textures/entity/demon.png");
	
	public RenderDemon(RenderManager manager) {
		super(manager, new ModelDemon(), 0.5F);
	}
	
	@Override
	protected ResourceLocation getEntityTexture(EntityDemon entity) {
		return TEXTURES;
	}
	
}
