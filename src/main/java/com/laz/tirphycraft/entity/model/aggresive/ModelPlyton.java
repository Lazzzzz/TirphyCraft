package com.laz.tirphycraft.entity.model.aggresive;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

/**
 * ModelPlyton - LaZz Created using Tabula 7.0.1
 */
public class ModelPlyton extends ModelBase {
	public ModelRenderer shape1;
	public ModelRenderer tail1;
	public ModelRenderer tail2;
	public ModelRenderer shape8;
	public ModelRenderer wings1;
	public ModelRenderer wings2;
	public ModelRenderer shape3;
	public ModelRenderer shape3_1;
	public ModelRenderer shape3_2;
	public ModelRenderer shape3_3;
	public ModelRenderer wings1_1;
	public ModelRenderer wings1_2;

	public ModelPlyton() {
		this.textureWidth = 256;
		this.textureHeight = 384;
		this.shape1 = new ModelRenderer(this, 0, 0);
		this.shape1.setRotationPoint(-32.0F, 16.0F, -40.0F);
		this.shape1.addBox(0.0F, 0.0F, 0.0F, 64, 8, 32, 0.0F);
		this.wings1 = new ModelRenderer(this, 118, 140);
		this.wings1.setRotationPoint(-32.0F, 19.0F, -36.0F);
		this.wings1.addBox(-26.0F, 0.0F, 0.0F, 30, 3, 26, 0.0F);
		this.wings2 = new ModelRenderer(this, 0, 140);
		this.wings2.setRotationPoint(32.0F, 19.0F, -36.0F);
		this.wings2.addBox(-4.0F, 0.0F, 0.0F, 30, 3, 26, 0.0F);
		this.wings1_1 = new ModelRenderer(this, 0, 229);
		this.wings1_1.setRotationPoint(-23.0F, 3.0F, -11.0F);
		this.wings1_1.addBox(-30.0F, -3.0F, 0.0F, 30, 3, 50, 0.0F);
		this.shape3_1 = new ModelRenderer(this, 0, 106);
		this.shape3_1.setRotationPoint(2.0F, 0.5F, 20.0F);
		this.shape3_1.addBox(0.0F, 0.0F, 0.0F, 8, 3, 26, 0.0F);
		this.tail2 = new ModelRenderer(this, 96, 42);
		this.tail2.setRotationPoint(10.0F, 17.0F, -8.0F);
		this.tail2.addBox(0.0F, 0.0F, 0.0F, 16, 5, 30, 0.0F);
		this.wings1_2 = new ModelRenderer(this, 0, 172);
		this.wings1_2.setRotationPoint(23.0F, 3.0F, -11.0F);
		this.wings1_2.addBox(0.0F, -3.0F, 0.0F, 30, 3, 50, 0.0F);
		this.shape3 = new ModelRenderer(this, 0, 80);
		this.shape3.setRotationPoint(2.0F, 0.5F, 30.0F);
		this.shape3.addBox(0.0F, 0.0F, 0.0F, 12, 4, 20, 0.0F);
		this.shape3_2 = new ModelRenderer(this, 68, 80);
		this.shape3_2.setRotationPoint(2.0F, 0.5F, 30.0F);
		this.shape3_2.addBox(0.0F, 0.0F, 0.0F, 12, 4, 20, 0.0F);
		this.shape8 = new ModelRenderer(this, 0, 295);
		this.shape8.setRotationPoint(0.0F, 17.0F, -40.0F);
		this.shape8.addBox(-10.0F, 0.0F, -10.0F, 20, 6, 10, 0.0F);
		this.tail1 = new ModelRenderer(this, 0, 42);
		this.tail1.setRotationPoint(-26.0F, 17.0F, -8.0F);
		this.tail1.addBox(0.0F, 0.0F, 0.0F, 16, 5, 30, 0.0F);
		this.shape3_3 = new ModelRenderer(this, 70, 106);
		this.shape3_3.setRotationPoint(2.0F, 0.5F, 20.0F);
		this.shape3_3.addBox(0.0F, 0.0F, 0.0F, 8, 3, 26, 0.0F);
		this.wings1.addChild(this.wings1_1);
		this.shape3.addChild(this.shape3_1);
		this.wings2.addChild(this.wings1_2);
		this.tail1.addChild(this.shape3);
		this.tail2.addChild(this.shape3_2);
		this.shape3_2.addChild(this.shape3_3);
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		this.shape1.render(f5);
		this.wings1.render(f5);
		this.wings2.render(f5);
		this.tail2.render(f5);
		this.shape8.render(f5);
		this.tail1.render(f5);
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
    	this.wings1.rotateAngleZ = MathHelper.cos(ageInTicks * 0.0662f); 
    	this.wings1_1.rotateAngleZ = -MathHelper.cos(ageInTicks * 0.0662f); 
    	
    	this.wings2.rotateAngleZ = -MathHelper.cos(ageInTicks * 0.0662f); 
    	this.wings1_2.rotateAngleZ = MathHelper.cos(ageInTicks * 0.0662f); 
    	
    	this.tail1.rotateAngleX = MathHelper.cos(ageInTicks * 0.2662f) * 0.1f; 
    	this.shape3.rotateAngleX = MathHelper.cos(ageInTicks * 0.2362f) * 0.1f; 
    	this.shape3_1.rotateAngleX = MathHelper.cos(ageInTicks * 0.2662f) * 0.1f; 
    	
    	this.tail2.rotateAngleX = -MathHelper.cos(ageInTicks * 0.2662f) * 0.1f; 
    	this.shape3_2.rotateAngleX = -MathHelper.cos(ageInTicks * 0.2362f) * 0.1f; 
    	this.shape3_3.rotateAngleX = -MathHelper.cos(ageInTicks * 0.2662f) * 0.1f;
    	
    	super.setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scaleFactor, entityIn);
    }

}
