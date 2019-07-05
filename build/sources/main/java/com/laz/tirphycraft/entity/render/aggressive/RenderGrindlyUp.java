package com.laz.tirphycraft.entity.render.aggressive;

import com.laz.tirphycraft.entity.entityClass.aggressive.EntityGrindlyUp;
import com.laz.tirphycraft.entity.model.aggresive.ModelGrindlyUp;
import com.laz.tirphycraft.util.Reference;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderGrindlyUp extends RenderLiving<EntityGrindlyUp>{
	public static final ResourceLocation TEXTURES = new ResourceLocation(Reference.MOD_ID + ":textures/entity/grindlyup.png");
	
	public RenderGrindlyUp(RenderManager manager) {
		super(manager, new ModelGrindlyUp(), 0.5F);
	}
	
	@Override
	protected ResourceLocation getEntityTexture(EntityGrindlyUp entity) {
		return TEXTURES;
	}
	
}
