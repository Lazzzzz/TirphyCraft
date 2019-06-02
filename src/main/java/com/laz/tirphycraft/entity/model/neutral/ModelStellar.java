package com.laz.tirphycraft.entity.model.neutral;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

/**
 * ModelStellar - LaZz_ Created using Tabula 7.0.1
 */
public class ModelStellar extends ModelBase {
	public ModelRenderer shape1;
	public ModelRenderer shape2;
	public ModelRenderer shape3;

	public ModelStellar() {
		this.textureWidth = 128;
		this.textureHeight = 64;
		this.shape2 = new ModelRenderer(this, 69, 0);
		this.shape2.setRotationPoint(0.0F, -24.0F, 0.0F);
		this.shape2.addBox(-6.0F, 0.0F, -6.0F, 12, 32, 12, 0.0F);
		this.shape3 = new ModelRenderer(this, 0, 0);
		this.shape3.setRotationPoint(-8.0F, -40.0F, -8.0F);
		this.shape3.addBox(0.0F, 0.0F, 0.0F, 16, 16, 16, 0.0F);
		this.shape1 = new ModelRenderer(this, 0, 0);
		this.shape1.setRotationPoint(-8.0F, 8.0F, -8.0F);
		this.shape1.addBox(0.0F, 0.0F, 0.0F, 16, 16, 16, 0.0F);
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		this.shape2.render(f5);
		this.shape3.render(f5);
		this.shape1.render(f5);
	}

	/**
	 * This is a helper function from Tabula to set the rotation of model parts
	 */
	public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
	
	@Override
	public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
			float headPitch, float scaleFactor, Entity entityIn) {
		this.shape2.rotateAngleY += MathHelper.cos(0.6662f) * 0.02f;
	}
}
