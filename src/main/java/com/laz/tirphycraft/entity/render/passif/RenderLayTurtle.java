package com.laz.tirphycraft.entity.render.passif;

import com.laz.tirphycraft.entity.entityClass.passif.EntityLayTurtle;
import com.laz.tirphycraft.entity.model.passif.ModelLayTurtle;
import com.laz.tirphycraft.util.Reference;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderLayTurtle extends RenderLiving<EntityLayTurtle>{
	public static final ResourceLocation TEXTURES = new ResourceLocation(Reference.MOD_ID + ":textures/entity/layturtle.png");
	
	public RenderLayTurtle(RenderManager manager) {
		super(manager, new ModelLayTurtle(), 0.5F);
	}
	
	@Override
	protected ResourceLocation getEntityTexture(EntityLayTurtle entity) {
		return TEXTURES;
	}
	
}
