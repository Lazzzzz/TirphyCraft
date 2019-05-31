package com.laz.tirphycraft.entity.render.aggressive;

import com.laz.tirphycraft.entity.aggressive.EntityGiril;
import com.laz.tirphycraft.entity.model.aggresive.ModelGiril;
import com.laz.tirphycraft.util.Reference;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderGiril extends RenderLiving<EntityGiril>{
	public static final ResourceLocation TEXTURES = new ResourceLocation(Reference.MOD_ID + ":textures/entity/giril.png");
	
	public RenderGiril(RenderManager manager) {
		super(manager, new ModelGiril(), 0.5F);
	}
	
	@Override
	protected ResourceLocation getEntityTexture(EntityGiril entity) {
		return TEXTURES;
	}
	
}
