package com.laz.tirphycraft.entity.render.boss;

import com.laz.tirphycraft.entity.entityClass.boss.EntityPrimaryAttack;
import com.laz.tirphycraft.entity.model.boss.ModelPrimary;
import com.laz.tirphycraft.util.Reference;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderPrimaryAttack extends RenderLiving<EntityPrimaryAttack>{
	public static final ResourceLocation TEXTURES = new ResourceLocation(Reference.MOD_ID + ":textures/entity/primary_attack.png");
	
	public RenderPrimaryAttack(RenderManager manager) {
		super(manager, new ModelPrimary(), 1F);
	}
	
	@Override
	protected ResourceLocation getEntityTexture(EntityPrimaryAttack entity) {
		return TEXTURES;
	}
	
}
