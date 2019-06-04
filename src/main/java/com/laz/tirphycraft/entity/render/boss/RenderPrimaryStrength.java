package com.laz.tirphycraft.entity.render.boss;

import com.laz.tirphycraft.entity.entityClass.boss.EntityPrimaryStrength;
import com.laz.tirphycraft.entity.model.boss.ModelPrimary;
import com.laz.tirphycraft.util.Reference;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderPrimaryStrength extends RenderLiving<EntityPrimaryStrength>{
	public static final ResourceLocation TEXTURES = new ResourceLocation(Reference.MOD_ID + ":textures/entity/primary_strength.png");
	
	public RenderPrimaryStrength(RenderManager manager) {
		super(manager, new ModelPrimary(), 1F);
	}
	
	@Override
	protected ResourceLocation getEntityTexture(EntityPrimaryStrength entity) {
		return TEXTURES;
	}
	
}
