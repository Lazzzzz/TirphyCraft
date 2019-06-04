package com.laz.tirphycraft.entity.render.aggressive;

import com.laz.tirphycraft.entity.entityClass.aggressive.EntityGiantSpider;
import com.laz.tirphycraft.entity.model.aggresive.ModelGiantSpider;
import com.laz.tirphycraft.util.Reference;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderGiantSpider extends RenderLiving<EntityGiantSpider>{
	public static final ResourceLocation TEXTURES = new ResourceLocation(Reference.MOD_ID + ":textures/entity/giant_spider.png");
	
	public RenderGiantSpider(RenderManager manager) {
		super(manager, new ModelGiantSpider(), 0.8F);
	}
	
	@Override
	protected ResourceLocation getEntityTexture(EntityGiantSpider entity) {
		return TEXTURES;
	}
	
}
