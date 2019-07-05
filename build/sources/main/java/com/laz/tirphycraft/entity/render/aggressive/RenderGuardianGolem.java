package com.laz.tirphycraft.entity.render.aggressive;

import com.laz.tirphycraft.entity.entityClass.aggressive.EntityGuardianGolem;
import com.laz.tirphycraft.entity.model.aggresive.ModelGuardianGolem;
import com.laz.tirphycraft.util.Reference;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderGuardianGolem extends RenderLiving<EntityGuardianGolem>{
	public static final ResourceLocation TEXTURES = new ResourceLocation(Reference.MOD_ID + ":textures/entity/gardian_golem.png");
	
	public RenderGuardianGolem(RenderManager manager) {
		super(manager, new ModelGuardianGolem(), 0.5F);
	}
	
	@Override
	protected ResourceLocation getEntityTexture(EntityGuardianGolem entity) {
		return TEXTURES;
	}
	
}
