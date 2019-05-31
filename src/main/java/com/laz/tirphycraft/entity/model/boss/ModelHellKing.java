package com.laz.tirphycraft.entity.model.boss;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

/**
 * HellKing - Laz
 * Created using Tabula 7.0.0
 */
public class ModelHellKing extends ModelBase {
    public ModelRenderer LeftLeg;
    public ModelRenderer cap;
    public ModelRenderer cap2;
    public ModelRenderer cap3;
    public ModelRenderer cap4;
    public ModelRenderer RightLeg;
    public ModelRenderer body1;
    public ModelRenderer body2;
    public ModelRenderer body3;
    public ModelRenderer head;
    public ModelRenderer shield1;
    public ModelRenderer shield2;
    public ModelRenderer shield3;
    public ModelRenderer shield4;
    public ModelRenderer leftArmNone;
    public ModelRenderer rightArmNone;
    public ModelRenderer leftArm1;
    public ModelRenderer leftArm2;
    public ModelRenderer rightArm2;
    public ModelRenderer RightArm;

    public ModelHellKing() {
        this.textureWidth = 128;
        this.textureHeight = 128;
        this.cap2 = new ModelRenderer(this, 63, 41);
        this.cap2.setRotationPoint(-7.0F, -9.0F, 3.0F);
        this.cap2.addBox(0.0F, 0.0F, 0.0F, 14, 33, 1, 0.0F);
        this.setRotateAngle(cap2, 0.15707963267948966F, 0.0F, 0.0F);
        this.shield1 = new ModelRenderer(this, 0, 60);
        this.shield1.setRotationPoint(0.0F, -19.0F, 0.0F);
        this.shield1.addBox(8.0F, -2.0F, -2.0F, 1, 4, 4, 0.0F);
        this.RightArm = new ModelRenderer(this, 19, 0);
        this.RightArm.setRotationPoint(11.0F, -33.0F, -1.0F);
        this.RightArm.addBox(0.0F, 0.0F, 0.0F, 2, 24, 2, 0.0F);
        this.shield2 = new ModelRenderer(this, 14, 60);
        this.shield2.setRotationPoint(0.0F, -19.0F, 0.0F);
        this.shield2.addBox(-9.0F, -2.0F, -2.0F, 1, 4, 4, 0.0F);
        this.shield4 = new ModelRenderer(this, 14, 50);
        this.shield4.setRotationPoint(0.0F, -19.0F, 0.0F);
        this.shield4.addBox(-2.0F, -2.0F, 7.0F, 4, 4, 1, 0.0F);
        this.cap4 = new ModelRenderer(this, 37, 0);
        this.cap4.setRotationPoint(6.0F, -9.0F, -4.0F);
        this.cap4.addBox(0.0F, 0.0F, 0.0F, 1, 33, 8, 0.0F);
        this.setRotateAngle(cap4, 0.0F, 0.0F, -0.15707963267948966F);
        this.body3 = new ModelRenderer(this, 46, 114);
        this.body3.setRotationPoint(-6.0F, -29.0F, -5.0F);
        this.body3.addBox(0.0F, 0.0F, 0.0F, 12, 4, 10, 0.0F);
        this.body1 = new ModelRenderer(this, 0, 114);
        this.body1.setRotationPoint(-6.0F, -13.0F, -5.0F);
        this.body1.addBox(0.0F, 0.0F, 0.0F, 12, 4, 10, 0.0F);
        this.head = new ModelRenderer(this, 0, 73);
        this.head.setRotationPoint(0.0F, -29.0F, -4.0F);
        this.head.addBox(-4.0F, -8.0F, 0.0F, 8, 8, 8, 0.0F);
        this.rightArm2 = new ModelRenderer(this, 18, 31);
        this.rightArm2.setRotationPoint(11.0F, -33.0F, -1.0F);
        this.rightArm2.addBox(-1.0F, 24.0F, -1.0F, 4, 4, 4, 0.0F);
        this.body2 = new ModelRenderer(this, 0, 93);
        this.body2.setRotationPoint(-4.0F, -25.0F, -3.0F);
        this.body2.addBox(0.0F, 0.0F, 0.0F, 8, 12, 6, 0.0F);
        this.LeftLeg = new ModelRenderer(this, 103, 0);
        this.LeftLeg.setRotationPoint(-6.0F, -9.0F, -3.0F);
        this.LeftLeg.addBox(0.0F, 0.0F, 0.0F, 6, 33, 6, 0.0F);
        this.leftArm1 = new ModelRenderer(this, 0, 0);
        this.leftArm1.setRotationPoint(-13.0F, -33.0F, -1.0F);
        this.leftArm1.addBox(0.0F, 0.0F, 0.0F, 2, 24, 2, 0.0F);
        this.cap = new ModelRenderer(this, 96, 41);
        this.cap.setRotationPoint(-7.0F, -9.0F, -4.0F);
        this.cap.addBox(0.0F, 0.0F, 0.0F, 14, 33, 1, 0.0F);
        this.setRotateAngle(cap, -0.15707963267948966F, 0.0F, 0.0F);
        this.rightArmNone = new ModelRenderer(this, 40, 86);
        this.rightArmNone.setRotationPoint(3.0F, -28.0F, -3.0F);
        this.rightArmNone.addBox(0.0F, 0.0F, 0.0F, 12, 4, 6, 0.0F);
        this.setRotateAngle(rightArmNone, 0.0F, 0.0F, -0.7853981633974483F);
        this.leftArm2 = new ModelRenderer(this, 0, 31);
        this.leftArm2.setRotationPoint(-13.0F, -33.0F, -1.0F);
        this.leftArm2.addBox(-1.0F, 24.0F, -1.0F, 4, 4, 4, 0.0F);
        this.leftArmNone = new ModelRenderer(this, 40, 100);
        this.leftArmNone.setRotationPoint(-4.0F, -29.0F, -3.0F);
        this.leftArmNone.addBox(-11.0F, 0.0F, 0.0F, 12, 4, 6, 0.0F);
        this.setRotateAngle(leftArmNone, 0.0F, 0.0F, 0.7853981633974483F);
        this.RightLeg = new ModelRenderer(this, 78, 0);
        this.RightLeg.setRotationPoint(0.0F, -9.0F, -3.0F);
        this.RightLeg.addBox(0.0F, 0.0F, 0.0F, 6, 33, 6, 0.0F);
        this.shield3 = new ModelRenderer(this, 0, 50);
        this.shield3.setRotationPoint(0.0F, -19.0F, 0.0F);
        this.shield3.addBox(-2.0F, -2.0F, -8.0F, 4, 4, 1, 0.0F);
        this.cap3 = new ModelRenderer(this, 57, 0);
        this.cap3.setRotationPoint(-7.0F, -9.0F, -4.0F);
        this.cap3.addBox(0.0F, 0.0F, 0.0F, 1, 33, 8, 0.0F);
        this.setRotateAngle(cap3, 0.0F, 0.0F, 0.15707963267948966F);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
        this.cap2.render(f5);
        this.shield1.render(f5);
        this.RightArm.render(f5);
        this.shield2.render(f5);
        this.shield4.render(f5);
        this.cap4.render(f5);
        this.body3.render(f5);
        this.body1.render(f5);
        this.head.render(f5);
        this.rightArm2.render(f5);
        this.body2.render(f5);
        this.LeftLeg.render(f5);
        this.leftArm1.render(f5);
        this.cap.render(f5);
        this.rightArmNone.render(f5);
        this.leftArm2.render(f5);
        this.leftArmNone.render(f5);
        this.RightLeg.render(f5);
        this.shield3.render(f5);
        this.cap3.render(f5);
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
    	
    	this.LeftLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662f + (float)Math.PI) * 1.4f * limbSwingAmount / 6;
    	this.RightLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662f) * 1.4f * limbSwingAmount / 6;
    	
    	this.shield1.rotateAngleY += MathHelper.cos(0.6662f) * 0.03f;
    	this.shield2.rotateAngleY += MathHelper.cos(0.6662f) * 0.03f;
    	this.shield3.rotateAngleY += MathHelper.cos(0.6662f) * 0.03f;
    	this.shield4.rotateAngleY += MathHelper.cos(0.6662f) * 0.03f;
    	
    	this.RightArm.rotateAngleX = MathHelper.cos(limbSwing * 0.6662f + (float)Math.PI) * 1.4f * limbSwingAmount / 3;
    	this.leftArm1.rotateAngleX = MathHelper.cos(limbSwing * 0.6662f) * 1.4f * limbSwingAmount / 3;
    	this.rightArm2.rotateAngleX = MathHelper.cos(limbSwing * 0.6662f + (float)Math.PI) * 1.4f * limbSwingAmount / 3;
    	this.leftArm2.rotateAngleX = MathHelper.cos(limbSwing * 0.6662f) * 1.4f * limbSwingAmount / 3;
    	
    	this.head.rotateAngleY = netHeadYaw * 0.017453292F;
    	this.head.rotateAngleX = headPitch * 0.017453292F;
    }
}
