package com.laz.tirphycraft.entity.render.aggressive;

import com.laz.tirphycraft.entity.entityClass.aggressive.EntityPhorus;
import com.laz.tirphycraft.entity.model.aggresive.ModelPhorus;
import com.laz.tirphycraft.util.Reference;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderPhorus extends RenderLiving<EntityPhorus>{
	public static final ResourceLocation TEXTURES = new ResourceLocation(Reference.MOD_ID + ":textures/entity/phorus.png");
	
	public RenderPhorus(RenderManager manager) {
		super(manager, new ModelPhorus(), 0.5F);
	}
	
	@Override
	protected ResourceLocation getEntityTexture(EntityPhorus entity) {
		return TEXTURES;
	}
	
}
