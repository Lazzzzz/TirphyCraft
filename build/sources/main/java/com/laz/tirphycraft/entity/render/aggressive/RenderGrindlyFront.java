package com.laz.tirphycraft.entity.render.aggressive;

import com.laz.tirphycraft.entity.aggressive.EntityGrindlyFront;
import com.laz.tirphycraft.entity.model.aggresive.ModelGrindlyFront;
import com.laz.tirphycraft.util.Reference;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderGrindlyFront extends RenderLiving<EntityGrindlyFront>{
	public static final ResourceLocation TEXTURES = new ResourceLocation(Reference.MOD_ID + ":textures/entity/grindlyfront.png");
	
	public RenderGrindlyFront(RenderManager manager) {
		super(manager, new ModelGrindlyFront(), 0.5F);
	}
	
	@Override
	protected ResourceLocation getEntityTexture(EntityGrindlyFront entity) {
		return TEXTURES;
	}
	
}
