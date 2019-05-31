package com.laz.tirphycraft.entity.render.boss;

import com.laz.tirphycraft.entity.boss.EntityPharaoh;
import com.laz.tirphycraft.entity.model.boss.ModelPharaoh;
import com.laz.tirphycraft.util.Reference;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderPharaoh extends RenderLiving<EntityPharaoh>{
	public static final ResourceLocation TEXTURES = new ResourceLocation(Reference.MOD_ID + ":textures/entity/pharaoh.png");
	
	public RenderPharaoh(RenderManager manager) {
		super(manager, new ModelPharaoh(), 1F);
	}
	
	@Override
	protected ResourceLocation getEntityTexture(EntityPharaoh entity) {
		return TEXTURES;
	}
	
}
