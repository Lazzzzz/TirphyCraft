package com.laz.tirphycraft.entity.model.aggresive;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

/**
 * ModelGiantSpider - Laz Created using Tabula 7.0.0
 */
public class ModelGiantSpider extends ModelBase {
	public ModelRenderer body;
	public ModelRenderer bod2;
	public ModelRenderer head;
	public ModelRenderer legR1_1;
	public ModelRenderer legL1_1;
	public ModelRenderer legL1_2;
	public ModelRenderer legR1_2;
	public ModelRenderer legL1_3;
	public ModelRenderer legR1_3;
	public ModelRenderer legR2_1;
	public ModelRenderer legR2_2;
	public ModelRenderer legR2_3;
	public ModelRenderer legL2_2;
	public ModelRenderer legL2_1;
	public ModelRenderer legL2_3;

	public ModelGiantSpider() {
		this.textureWidth = 128;
		this.textureHeight = 64;
		this.head = new ModelRenderer(this, 70, 0);
		this.head.setRotationPoint(0.0F, 11.0F, -3.0F);
		this.head.addBox(-5.0F, -10.0F, -10.0F, 10, 10, 10, 0.0F);
		this.legR2_2 = new ModelRenderer(this, 0, 10);
		this.legR2_2.setRotationPoint(3.0F, 6.0F, 0.0F);
		this.legR2_2.addBox(14.0F, 2.0F, 1.0F, 1, 22, 1, 0.0F);
		this.setRotateAngle(legR2_2, 0.0F, 0.0F, -0.3490658503988659F);
		this.legL2_1 = new ModelRenderer(this, 0, 10);
		this.legL2_1.setRotationPoint(-4.0F, 5.0F, -3.0F);
		this.legL2_1.addBox(-13.0F, 3.0F, 0.0F, 1, 22, 1, 0.0F);
		this.setRotateAngle(legL2_1, 0.0F, -0.4363323129985824F, 0.3490658503988659F);
		this.legL1_2 = new ModelRenderer(this, 0, 0);
		this.legL1_2.setRotationPoint(-5.0F, 5.0F, 0.0F);
		this.legL1_2.addBox(-14.0F, 0.0F, 0.0F, 16, 3, 3, 0.0F);
		this.setRotateAngle(legL1_2, 0.0F, 0.0F, 0.3490658503988659F);
		this.legL1_3 = new ModelRenderer(this, 0, 0);
		this.legL1_3.setRotationPoint(-5.0F, 5.0F, 4.0F);
		this.legL1_3.addBox(-14.0F, 0.0F, 0.0F, 16, 3, 3, 0.0F);
		this.setRotateAngle(legL1_3, 0.0F, 0.4363323129985824F, 0.3490658503988659F);
		this.legL2_2 = new ModelRenderer(this, 0, 10);
		this.legL2_2.setRotationPoint(-5.0F, 5.0F, 0.0F);
		this.legL2_2.addBox(-13.0F, 2.0F, 1.0F, 1, 23, 1, 0.0F);
		this.setRotateAngle(legL2_2, 0.0F, 0.0F, 0.3490658503988659F);
		this.legR1_3 = new ModelRenderer(this, 0, 0);
		this.legR1_3.setRotationPoint(3.0F, 5.0F, 4.0F);
		this.legR1_3.addBox(0.0F, 0.0F, 0.0F, 16, 3, 3, 0.0F);
		this.setRotateAngle(legR1_3, 0.0F, -0.4363323129985824F, -0.3490658503988659F);
		this.legR1_1 = new ModelRenderer(this, 0, 0);
		this.legR1_1.setRotationPoint(5.0F, 5.0F, -3.0F);
		this.legR1_1.addBox(-3.0F, 0.0F, -1.0F, 16, 3, 3, 0.0F);
		this.setRotateAngle(legR1_1, 0.0F, 0.4363323129985824F, -0.3490658503988659F);
		this.body = new ModelRenderer(this, 0, 32);
		this.body.setRotationPoint(-6.0F, 0.0F, 7.0F);
		this.body.addBox(0.0F, 0.0F, -3.0F, 12, 12, 20, 0.0F);
		this.setRotateAngle(body, 0.3490658503988659F, 0.0F, 0.0F);
		this.bod2 = new ModelRenderer(this, 26, 11);
		this.bod2.setRotationPoint(-4.0F, 2.0F, -3.0F);
		this.bod2.addBox(0.0F, 0.0F, 0.0F, 8, 8, 11, 0.0F);
		this.legR2_1 = new ModelRenderer(this, 0, 10);
		this.legR2_1.setRotationPoint(5.0F, 5.0F, -3.0F);
		this.legR2_1.addBox(11.0F, 2.0F, 0.0F, 1, 22, 1, 0.0F);
		this.setRotateAngle(legR2_1, 0.0F, 0.4363323129985824F, -0.3490658503988659F);
		this.legL1_1 = new ModelRenderer(this, 0, 0);
		this.legL1_1.setRotationPoint(-4.0F, 5.0F, -3.0F);
		this.legL1_1.addBox(-14.0F, 0.0F, -1.0F, 16, 3, 3, 0.0F);
		this.setRotateAngle(legL1_1, 0.0F, -0.4363323129985824F, 0.3490658503988659F);
		this.legR2_3 = new ModelRenderer(this, 0, 10);
		this.legR2_3.setRotationPoint(3.0F, 5.0F, 4.0F);
		this.legR2_3.addBox(15.0F, 3.0F, 1.0F, 1, 22, 1, 0.0F);
		this.setRotateAngle(legR2_3, 0.0F, -0.4363323129985824F, -0.3490658503988659F);
		this.legL2_3 = new ModelRenderer(this, 0, 10);
		this.legL2_3.setRotationPoint(-5.0F, 5.0F, 4.0F);
		this.legL2_3.addBox(-14.0F, 3.0F, 1.0F, 1, 22, 1, 0.0F);
		this.setRotateAngle(legL2_3, 0.0F, 0.4363323129985824F, 0.3490658503988659F);
		this.legR1_2 = new ModelRenderer(this, 0, 0);
		this.legR1_2.setRotationPoint(3.0F, 6.0F, 0.0F);
		this.legR1_2.addBox(0.0F, 0.0F, 0.0F, 16, 3, 3, 0.0F);
		this.setRotateAngle(legR1_2, 0.0F, 0.0F, -0.3490658503988659F);
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		this.head.render(f5);
		this.legR2_2.render(f5);
		this.legL2_1.render(f5);
		this.legL1_2.render(f5);
		this.legL1_3.render(f5);
		this.legL2_2.render(f5);
		this.legR1_3.render(f5);
		this.legR1_1.render(f5);
		this.body.render(f5);
		this.bod2.render(f5);
		this.legR2_1.render(f5);
		this.legL1_1.render(f5);
		this.legR2_3.render(f5);
		this.legL2_3.render(f5);
		this.legR1_2.render(f5);
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
	public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {

    	this.head.rotateAngleY = netHeadYaw * 0.017453292F;
    	this.head.rotateAngleX = headPitch * 0.017453292F;
    	
    	this.legL1_1.rotateAngleY = (MathHelper.cos(limbSwing * 0.6662f + (float)Math.PI) * 1.4f * limbSwingAmount / 2)/2 - 0.4363323129985824F;
    	this.legL2_1.rotateAngleY = (MathHelper.cos(limbSwing * 0.6662f + (float)Math.PI) * 1.4f * limbSwingAmount / 2)/2 - 0.4363323129985824F;
    	this.legL1_2.rotateAngleY = -(MathHelper.cos(limbSwing * 0.6662f  + (float)Math.PI)* 1.4f * limbSwingAmount / 2)/2;
    	this.legL2_2.rotateAngleY = -(MathHelper.cos(limbSwing * 0.6662f  + (float)Math.PI) * 1.4f * limbSwingAmount / 2)/2;
    	this.legL1_3.rotateAngleY = (MathHelper.cos(limbSwing * 0.6662f + (float)Math.PI) * 1.4f * limbSwingAmount / 2)/2 + 0.4363323129985824F;
    	this.legL2_3.rotateAngleY = (MathHelper.cos(limbSwing * 0.6662f + (float)Math.PI) * 1.4f * limbSwingAmount / 2)/2 + 0.4363323129985824F;
    	
    	this.legR1_1.rotateAngleY = -(MathHelper.cos(limbSwing * 0.6662f + (float)Math.PI) * 1.4f * limbSwingAmount / 2)/2 + 0.4363323129985824F;
    	this.legR2_1.rotateAngleY = -(MathHelper.cos(limbSwing * 0.6662f + (float)Math.PI) * 1.4f * limbSwingAmount / 2)/2 + 0.4363323129985824F;
    	this.legR1_2.rotateAngleY = (MathHelper.cos(limbSwing * 0.6662f  + (float)Math.PI)* 1.4f * limbSwingAmount / 2)/2;
    	this.legR2_2.rotateAngleY = (MathHelper.cos(limbSwing * 0.6662f  + (float)Math.PI) * 1.4f * limbSwingAmount / 2)/2;
    	this.legR1_3.rotateAngleY = -(MathHelper.cos(limbSwing * 0.6662f + (float)Math.PI) * 1.4f * limbSwingAmount / 2)/2 - 0.4363323129985824F;
    	this.legR2_3.rotateAngleY = -(MathHelper.cos(limbSwing * 0.6662f + (float)Math.PI) * 1.4f * limbSwingAmount / 2)/2 - 0.4363323129985824F;
    	
	
	}
}
