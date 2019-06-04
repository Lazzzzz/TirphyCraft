package com.laz.tirphycraft.entity.render.aggressive;

import com.laz.tirphycraft.entity.entityClass.aggressive.EntityGrindlyBoth;
import com.laz.tirphycraft.entity.model.aggresive.ModelGrindlyBoth;
import com.laz.tirphycraft.util.Reference;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderGrindlyBoth extends RenderLiving<EntityGrindlyBoth>{
	public static final ResourceLocation TEXTURES = new ResourceLocation(Reference.MOD_ID + ":textures/entity/grindlyboth.png");
	
	public RenderGrindlyBoth(RenderManager manager) {
		super(manager, new ModelGrindlyBoth(), 0.5F);
	}
	
	@Override
	protected ResourceLocation getEntityTexture(EntityGrindlyBoth entity) {
		return TEXTURES;
	}
	
}
