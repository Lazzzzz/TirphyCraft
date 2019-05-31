package com.laz.tirphycraft.entity.render.boss;

import com.laz.tirphycraft.entity.boss.EntityPoseidon;
import com.laz.tirphycraft.entity.model.boss.ModelPoseidon;
import com.laz.tirphycraft.util.Reference;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderPoseidon extends RenderLiving<EntityPoseidon>{
	public static final ResourceLocation TEXTURES = new ResourceLocation(Reference.MOD_ID + ":textures/entity/poseidon.png");
	
	public RenderPoseidon(RenderManager manager) {
		super(manager, new ModelPoseidon(), 1F);
	}
	
	@Override
	protected ResourceLocation getEntityTexture(EntityPoseidon entity) {
		return TEXTURES;
	}
	
}
