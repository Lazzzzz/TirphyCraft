package com.laz.tirphycraft.entity.model.passif;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

/**
 * modelCrystim - Undefined
 * Created using Tabula 7.0.1
 */
public class ModelCrystim extends ModelBase {
    public ModelRenderer shape1;
    public ModelRenderer shape2;
    public ModelRenderer shape6;
    public ModelRenderer shape8;
    public ModelRenderer shape8_1;
    public ModelRenderer shape10;
    public ModelRenderer shape7;
    public ModelRenderer shape9;
    public ModelRenderer shape9_1;
    public ModelRenderer shape11;

    public ModelCrystim() {
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.shape1 = new ModelRenderer(this, 0, 0);
        this.shape1.setRotationPoint(0.0F, 12.0F, 0.0F);
        this.shape1.addBox(-3.0F, 0.0F, -3.0F, 6, 8, 6, 0.0F);
        this.shape7 = new ModelRenderer(this, 0, 0);
        this.shape7.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.shape7.addBox(-0.5F, 2.5F, 7.0F, 1, 1, 1, 0.0F);
        this.shape9_1 = new ModelRenderer(this, 0, 0);
        this.shape9_1.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.shape9_1.addBox(-7.0F, 2.5F, -0.5F, 1, 1, 1, 0.0F);
        this.shape10 = new ModelRenderer(this, 24, 8);
        this.shape10.setRotationPoint(0.0F, 17.0F, 0.0F);
        this.shape10.addBox(5.0F, 0.0F, -3.0F, 1, 6, 6, 0.0F);
        this.shape11 = new ModelRenderer(this, 0, 0);
        this.shape11.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.shape11.addBox(6.0F, 2.5F, -0.5F, 1, 1, 1, 0.0F);
        this.shape8_1 = new ModelRenderer(this, 24, 8);
        this.shape8_1.setRotationPoint(0.0F, 17.0F, 0.0F);
        this.shape8_1.addBox(-6.0F, 0.0F, -3.0F, 1, 6, 6, 0.0F);
        this.shape8 = new ModelRenderer(this, 24, 0);
        this.shape8.setRotationPoint(0.0F, 17.0F, 0.0F);
        this.shape8.addBox(-3.0F, 0.0F, -6.0F, 6, 6, 1, 0.0F);
        this.shape2 = new ModelRenderer(this, 0, 15);
        this.shape2.setRotationPoint(0.0F, 9.0F, 0.0F);
        this.shape2.addBox(-2.0F, -2.0F, -2.0F, 4, 4, 4, 0.0F);
        this.shape6 = new ModelRenderer(this, 24, 0);
        this.shape6.setRotationPoint(0.0F, 17.0F, 0.0F);
        this.shape6.addBox(-3.0F, 0.0F, 6.0F, 6, 6, 1, 0.0F);
        this.shape9 = new ModelRenderer(this, 0, 0);
        this.shape9.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.shape9.addBox(-0.5F, 2.5F, -7.0F, 1, 1, 1, 0.0F);
        this.shape6.addChild(this.shape7);
        this.shape8_1.addChild(this.shape9_1);
        this.shape10.addChild(this.shape11);
        this.shape8.addChild(this.shape9);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
        this.shape1.render(f5);
        this.shape10.render(f5);
        this.shape8_1.render(f5);
        this.shape8.render(f5);
        this.shape2.render(f5);
        this.shape6.render(f5);
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
    	this.shape6.rotateAngleY += MathHelper.cos(0.6662f) * 0.9f;
    	this.shape8.rotateAngleY += MathHelper.cos(0.6662f) * 0.9f;
    	this.shape8_1.rotateAngleY += MathHelper.cos(0.6662f) * 0.9f;
    	this.shape10.rotateAngleY += MathHelper.cos(0.6662f) * 0.9f;
    	
    	this.shape2.rotateAngleY = netHeadYaw * 0.017453292F;
    	this.shape2.rotateAngleX = headPitch * 0.017453292F;
    }
}
