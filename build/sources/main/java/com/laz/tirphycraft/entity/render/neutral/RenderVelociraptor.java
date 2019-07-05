package com.laz.tirphycraft.entity.render.neutral;

import com.laz.tirphycraft.entity.entityClass.neutral.EntityVelociraptor;
import com.laz.tirphycraft.entity.model.neutral.ModelMothmoth;
import com.laz.tirphycraft.entity.model.neutral.ModelVelociraptor;
import com.laz.tirphycraft.util.Reference;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderVelociraptor extends RenderLiving<EntityVelociraptor> {

	public static final ResourceLocation[] VELOCIRAPTOR_TEXTURES = new ResourceLocation[] {
			new ResourceLocation(Reference.MOD_ID + ":textures/entity/velociraptor/velociraptor_basic.png"),
			new ResourceLocation(Reference.MOD_ID + ":textures/entity/velociraptor/velociraptor_cool.png"),
			new ResourceLocation(Reference.MOD_ID + ":textures/entity/velociraptor/velociraptor_saddle.png")};

	public RenderVelociraptor(RenderManager renderManagerIn)

	{

		super(renderManagerIn, new ModelVelociraptor(), 0.5F);

	}

	protected ResourceLocation getEntityTexture(EntityVelociraptor entity) {
		return VELOCIRAPTOR_TEXTURES[entity.getVariant()];
	}

}
