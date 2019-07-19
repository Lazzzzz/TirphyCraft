package com.laz.tirphycraft.entity.model.aggresive;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

/**
 * ModelBreaker - LaZz_ Created using Tabula 7.0.1
 */
public class ModelBreaker extends ModelBase {
	public ModelRenderer shape1;
	public ModelRenderer shape2;
	public ModelRenderer shape3;
	public ModelRenderer shape4;
	public ModelRenderer shape5;
	public ModelRenderer shape7;
	public ModelRenderer shape5_1;
	public ModelRenderer shape7_1;

	public ModelBreaker() {
		this.textureWidth = 64;
		this.textureHeight = 64;
		this.shape7 = new ModelRenderer(this, 36, 33);
		this.shape7.setRotationPoint(-1.5F, 10.0F, -1.5F);
		this.shape7.addBox(0.0F, 0.0F, 0.0F, 3, 3, 3, 0.0F);
		this.shape3 = new ModelRenderer(this, 0, 40);
		this.shape3.setRotationPoint(11.0F, 7.0F, 0.0F);
		this.shape3.addBox(-4.0F, -4.0F, -4.0F, 8, 8, 8, 0.0F);
		this.shape1 = new ModelRenderer(this, 0, 0);
		this.shape1.setRotationPoint(0.0F, 7.0F, 0.0F);
		this.shape1.addBox(-6.0F, -6.0F, -6.0F, 12, 12, 12, 0.0F);
		this.shape5_1 = new ModelRenderer(this, 56, 0);
		this.shape5_1.setRotationPoint(0.0F, 4.0F, 0.0F);
		this.shape5_1.addBox(-1.0F, -1.0F, -1.0F, 2, 12, 2, 0.0F);
		this.setRotateAngle(shape5_1, -0.31869712141416456F, 0.0F, 0.0F);
		this.shape7_1 = new ModelRenderer(this, 36, 25);
		this.shape7_1.setRotationPoint(-1.5F, 10.0F, -1.5F);
		this.shape7_1.addBox(0.0F, 0.0F, 0.0F, 3, 3, 3, 0.0F);
		this.shape4 = new ModelRenderer(this, 32, 40);
		this.shape4.setRotationPoint(-11.0F, 7.0F, 0.0F);
		this.shape4.addBox(-4.0F, -4.0F, -4.0F, 8, 8, 8, 0.0F);
		this.shape2 = new ModelRenderer(this, 0, 24);
		this.shape2.setRotationPoint(0.0F, 19.0F, 0.0F);
		this.shape2.addBox(-4.0F, -4.0F, -4.0F, 8, 8, 8, 0.0F);
		this.shape5 = new ModelRenderer(this, 48, 0);
		this.shape5.setRotationPoint(0.0F, 4.0F, 0.0F);
		this.shape5.addBox(-1.0F, -1.0F, -1.0F, 2, 12, 2, 0.0F);
		this.setRotateAngle(shape5, -0.31869712141416456F, 0.0F, 0.0F);
		this.shape5.addChild(this.shape7);
		this.shape4.addChild(this.shape5_1);
		this.shape5_1.addChild(this.shape7_1);
		this.shape3.addChild(this.shape5);
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		this.shape3.render(f5);
		this.shape1.render(f5);
		this.shape4.render(f5);
		this.shape2.render(f5);
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
		this.shape1.rotateAngleY = netHeadYaw * 0.017453292F;
		this.shape1.rotateAngleX = headPitch * 0.017453292F;

		this.shape3.rotateAngleX = MathHelper.cos(limbSwing * 0.6662f + (float) Math.PI) * 1.4f * limbSwingAmount;
		this.shape4.rotateAngleX = MathHelper.cos(limbSwing * 0.6662f) * 1.4f * limbSwingAmount;

		super.setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scaleFactor, entityIn);
	}
}
