package com.laz.tirphycraft.entity.render.aggressive;

import com.laz.tirphycraft.entity.aggressive.EntityCloudy;
import com.laz.tirphycraft.entity.model.aggresive.ModelCloudy;
import com.laz.tirphycraft.util.Reference;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderCloudy extends RenderLiving<EntityCloudy>{
	public static final ResourceLocation TEXTURES = new ResourceLocation(Reference.MOD_ID + ":textures/entity/cloudy.png");
	
	public RenderCloudy(RenderManager manager) {
		super(manager, new ModelCloudy(), 0.5F);
	}
	
	@Override
	protected ResourceLocation getEntityTexture(EntityCloudy entity) {
		return TEXTURES;
	}
	
}
