package com.laz.tirphycraft.entity.model.boss;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

/**
 * CreeperQueen - Laz Created using Tabula 7.0.0
 */
public class ModelQueenCreeper extends ModelBase {
	public ModelRenderer shape1;
	public ModelRenderer body;
	public ModelRenderer head;
	public ModelRenderer bottomLeft;
	public ModelRenderer topright;
	public ModelRenderer topLeft;
	public ModelRenderer bottomright;
	public ModelRenderer topleftParent;
	public ModelRenderer bottomLeftParent;
	public ModelRenderer toprightParent;
	public ModelRenderer bottomrightParent;

	public ModelQueenCreeper() {
		this.textureWidth = 128;
		this.textureHeight = 128;
		this.body = new ModelRenderer(this, 50, 40);
		this.body.setRotationPoint(0.0F, -5.0F, -3.0F);
		this.body.addBox(-4.0F, -13.0F, 0.0F, 8, 13, 4, 0.0F);
		this.setRotateAngle(body, -0.4363323129985824F, 0.0F, 0.0F);
		this.topLeft = new ModelRenderer(this, 0, 60);
		this.topLeft.setRotationPoint(-5.0F, 7.0F, -4.0F);
		this.topLeft.addBox(-16.0F, -2.0F, -2.0F, 16, 4, 4, 0.0F);
		this.setRotateAngle(topLeft, 0.0F, -0.4363323129985824F, 0.4363323129985824F);
		this.bottomrightParent = new ModelRenderer(this, 110, 80);
		this.bottomrightParent.setRotationPoint(6.0F, 7.0F, 5.0F);
		this.bottomrightParent.addBox(13.0F, -1.0F, -1.0F, 2, 25, 2, 0.0F);
		this.setRotateAngle(bottomrightParent, 0.0F, -0.4363323129985824F, -0.4363323129985824F);
		this.bottomLeft = new ModelRenderer(this, 0, 100);
		this.bottomLeft.setRotationPoint(-6.0F, 7.0F, 4.0F);
		this.bottomLeft.addBox(-16.0F, -2.0F, -2.0F, 16, 4, 4, 0.0F);
		this.setRotateAngle(bottomLeft, 0.0F, 0.4363323129985824F, 0.4363323129985824F);
		this.shape1 = new ModelRenderer(this, 50, 0);
		this.shape1.setRotationPoint(-8.0F, -5.0F, -8.0F);
		this.shape1.addBox(0.0F, 0.0F, 0.0F, 16, 16, 16, 0.0F);
		this.bottomright = new ModelRenderer(this, 0, 40);
		this.bottomright.setRotationPoint(6.0F, 7.0F, 5.0F);
		this.bottomright.addBox(0.0F, -2.0F, -2.0F, 16, 4, 4, 0.0F);
		this.setRotateAngle(bottomright, 0.0F, -0.4363323129985824F, -0.4363323129985824F);
		this.bottomLeftParent = new ModelRenderer(this, 90, 80);
		this.bottomLeftParent.setRotationPoint(-6.0F, 7.0F, 4.0F);
		this.bottomLeftParent.addBox(-15.0F, -1.0F, -1.0F, 2, 25, 2, 0.0F);
		this.setRotateAngle(bottomLeftParent, 0.0F, 0.4363323129985824F, 0.4363323129985824F);
		this.head = new ModelRenderer(this, 0, 0);
		this.head.setRotationPoint(0.0F, -19.0F, 3.0F);
		this.head.addBox(-4.0F, -4.0F, -4.0F, 8, 8, 8, 0.0F);
		this.topright = new ModelRenderer(this, 0, 80);
		this.topright.setRotationPoint(6.0F, 7.0F, -4.0F);
		this.topright.addBox(0.0F, -2.0F, -2.0F, 16, 4, 4, 0.0F);
		this.setRotateAngle(topright, 0.0F, 0.4363323129985824F, -0.4363323129985824F);
		this.toprightParent = new ModelRenderer(this, 100, 80);
		this.toprightParent.setRotationPoint(6.0F, 7.0F, -4.0F);
		this.toprightParent.addBox(13.0F, -1.0F, -1.0F, 2, 25, 2, 0.0F);
		this.setRotateAngle(toprightParent, 0.0F, 0.4363323129985824F, -0.4363323129985824F);
		this.topleftParent = new ModelRenderer(this, 80, 80);
		this.topleftParent.setRotationPoint(-5.0F, 7.0F, -4.0F);
		this.topleftParent.addBox(-15.0F, -1.0F, -1.0F, 2, 25, 2, 0.0F);
		this.setRotateAngle(topleftParent, 0.0F, -0.4363323129985824F, 0.4363323129985824F);

		//this.topLeft.addChild(topleftParent);
		//this.bottomLeft.addChild(bottomLeftParent);
		//this.topright.addChild(toprightParent);
		//this.bottomright.addChild(bottomrightParent);
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		this.body.render(f5);
		this.topLeft.render(f5);
		this.bottomrightParent.render(f5);
		this.bottomLeft.render(f5);
		this.shape1.render(f5);
		this.bottomright.render(f5);
		this.bottomLeftParent.render(f5);
		this.head.render(f5);
		this.topright.render(f5);
		this.toprightParent.render(f5);
		this.topleftParent.render(f5);
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
    	this.topLeft.rotateAngleY = (MathHelper.cos(limbSwing * 0.6662f + (float)Math.PI) * 1.4f * limbSwingAmount / 2) -0.4363323129985824F ;
    	this.bottomright.rotateAngleY = (MathHelper.cos(limbSwing * 0.6662f + (float)Math.PI) * 1.4f * limbSwingAmount / 2) -0.4363323129985824F; 
 
    	this.topleftParent.rotateAngleY = (MathHelper.cos(limbSwing * 0.6662f + (float)Math.PI) * 1.4f * limbSwingAmount / 2) -0.4363323129985824F;
    	this.bottomrightParent.rotateAngleY = (MathHelper.cos(limbSwing * 0.6662f + (float)Math.PI) * 1.4f * limbSwingAmount / 2) -0.4363323129985824F;     	
    	
    	this.bottomLeft.rotateAngleY = (MathHelper.cos(limbSwing * 0.6662f) * 1.4f * limbSwingAmount / 2) +  0.4363323129985824F;
    	this.topright.rotateAngleY = (MathHelper.cos(limbSwing * 0.6662f) * 1.4f * limbSwingAmount / 2) +  0.4363323129985824F;     	
 
    	this.bottomLeftParent.rotateAngleY = (MathHelper.cos(limbSwing * 0.6662f) * 1.4f * limbSwingAmount / 2) +  0.4363323129985824F;
    	this.toprightParent.rotateAngleY = (MathHelper.cos(limbSwing * 0.6662f) * 1.4f * limbSwingAmount / 2) +  0.4363323129985824F;   
    	
    	this.head.rotateAngleY = netHeadYaw * 0.017453292F;
    	this.head.rotateAngleX = headPitch * 0.017453292F;   
	}

}
