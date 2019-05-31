package com.laz.tirphycraft.entity.model.passif;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

/**
 * ModelCow - Either Mojang or a mod author Created using Tabula 7.0.0
 */
public class ModelToxisCow extends ModelBase {
	public ModelRenderer field_78148_b0;
	public ModelRenderer field_78148_b1;
	public ModelRenderer field_78146_d;
	public ModelRenderer field_78144_f;
	public ModelRenderer field_78149_c;
	public ModelRenderer field_78147_e;
	public ModelRenderer field_78150_a0;
	public ModelRenderer field_78150_a1;
	public ModelRenderer field_78150_a2;
	public ModelRenderer shape10;
	public ModelRenderer shape11;

	public ModelToxisCow() {
		this.textureWidth = 64;
		this.textureHeight = 64;
		this.field_78148_b0 = new ModelRenderer(this, 18, 4);
		this.field_78148_b0.setRotationPoint(0.0F, 5.0F, 2.0F);
		this.field_78148_b0.addBox(-6.0F, -10.0F, -7.0F, 12, 18, 10, 0.0F);
		this.setRotateAngle(field_78148_b0, 1.5707963705062866F, 0.0F, 0.0F);
		this.field_78146_d = new ModelRenderer(this, 0, 16);
		this.field_78146_d.setRotationPoint(4.0F, 12.0F, 7.0F);
		this.field_78146_d.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F);
		this.field_78150_a2 = new ModelRenderer(this, 22, 0);
		this.field_78150_a2.setRotationPoint(0.0F, 4.0F, -8.0F);
		this.field_78150_a2.addBox(4.0F, -5.0F, -4.0F, 1, 3, 1, 0.0F);
		this.field_78149_c = new ModelRenderer(this, 0, 16);
		this.field_78149_c.setRotationPoint(-4.0F, 12.0F, 7.0F);
		this.field_78149_c.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F);
		this.shape11 = new ModelRenderer(this, 25, 40);
		this.shape11.setRotationPoint(0.0F, -10.0F, 2.0F);
		this.shape11.addBox(-6.0F, 0.0F, 0.0F, 12, 12, 0, 0.0F);
		this.setRotateAngle(shape11, 0.0F, -0.7853981633974483F, 0.0F);
		this.field_78150_a1 = new ModelRenderer(this, 22, 0);
		this.field_78150_a1.setRotationPoint(0.0F, 4.0F, -8.0F);
		this.field_78150_a1.addBox(-5.0F, -5.0F, -4.0F, 1, 3, 1, 0.0F);
		this.field_78150_a0 = new ModelRenderer(this, 0, 0);
		this.field_78150_a0.setRotationPoint(0.0F, 4.0F, -8.0F);
		this.field_78150_a0.addBox(-4.0F, -4.0F, -6.0F, 8, 8, 6, 0.0F);
		this.shape10 = new ModelRenderer(this, 0, 40);
		this.shape10.setRotationPoint(0.0F, -10.0F, 2.0F);
		this.shape10.addBox(-6.0F, 0.0F, 0.0F, 12, 12, 0, 0.0F);
		this.setRotateAngle(shape10, 0.0F, 0.7853981633974483F, 0.0F);
		this.field_78148_b1 = new ModelRenderer(this, 52, 0);
		this.field_78148_b1.setRotationPoint(0.0F, 5.0F, 2.0F);
		this.field_78148_b1.addBox(-2.0F, 2.0F, -8.0F, 4, 6, 1, 0.0F);
		this.setRotateAngle(field_78148_b1, 1.5707963705062866F, 0.0F, 0.0F);
		this.field_78144_f = new ModelRenderer(this, 0, 16);
		this.field_78144_f.setRotationPoint(4.0F, 12.0F, -6.0F);
		this.field_78144_f.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F);
		this.field_78147_e = new ModelRenderer(this, 0, 16);
		this.field_78147_e.setRotationPoint(-4.0F, 12.0F, -6.0F);
		this.field_78147_e.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F);
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		this.field_78148_b0.render(f5);
		this.field_78146_d.render(f5);
		this.field_78150_a2.render(f5);
		this.field_78149_c.render(f5);
		this.shape11.render(f5);
		this.field_78150_a1.render(f5);
		this.field_78150_a0.render(f5);
		this.shape10.render(f5);
		this.field_78148_b1.render(f5);
		this.field_78144_f.render(f5);
		this.field_78147_e.render(f5);
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
		this.field_78149_c.rotateAngleX = MathHelper.cos(limbSwing * 0.6662f + (float) Math.PI) * 1.4f
				* limbSwingAmount;
		this.field_78144_f.rotateAngleX = MathHelper.cos(limbSwing * 0.6662f + (float) Math.PI) * 1.4f
				* limbSwingAmount;
		this.field_78147_e.rotateAngleX = MathHelper.cos(limbSwing * 0.6662f) * 1.4f * limbSwingAmount;
		this.field_78146_d.rotateAngleX = MathHelper.cos(limbSwing * 0.6662f) * 1.4f * limbSwingAmount;
	}
}
