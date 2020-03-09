package com.laz.tirphycraft.entity.model.neutral;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

public class ModelMothmoth extends ModelBase {
    public ModelRenderer shape1;
    public ModelRenderer shape2;
    public ModelRenderer head;
    public ModelRenderer head2;
    public ModelRenderer leg_T_L;
    public ModelRenderer leg_T_R;
    public ModelRenderer leg_B_L;
    public ModelRenderer leg_B_R;

    public ModelMothmoth() {
        this.textureWidth = 128;
        this.textureHeight = 128;
        this.leg_T_L = new ModelRenderer(this, 93, 0);
        this.leg_T_L.setRotationPoint(-11.0F, 3.0F, -13.0F);
        this.leg_T_L.addBox(0.0F, 0.0F, 0.0F, 6, 21, 6, 0.0F);
        this.head = new ModelRenderer(this, 0, 80);
        this.head.setRotationPoint(0.0F, 1.0F, -14.0F);
        this.head.addBox(-8.0F, -17.0F, -10.0F, 16, 16, 10, 0.0F);
        this.leg_B_L = new ModelRenderer(this, 93, 60);
        this.leg_B_L.setRotationPoint(-11.0F, 3.0F, 8.0F);
        this.leg_B_L.addBox(0.0F, 0.0F, 0.0F, 6, 21, 6, 0.0F);
        this.shape1 = new ModelRenderer(this, 0, 0);
        this.shape1.setRotationPoint(-12.0F, -20.0F, -14.0F);
        this.shape1.addBox(0.0F, 0.0F, 0.0F, 24, 24, 19, 0.0F);
        this.head2 = new ModelRenderer(this, 0, 108);
        this.head2.setRotationPoint(0.0F, 1.0F, -14.0F);
        this.head2.addBox(-4.0F, -9.0F, -14.0F, 8, 10, 4, 0.0F);
        this.leg_T_R = new ModelRenderer(this, 93, 30);
        this.leg_T_R.setRotationPoint(5.0F, 3.0F, -13.0F);
        this.leg_T_R.addBox(0.0F, 0.0F, 0.0F, 6, 21, 6, 0.0F);
        this.shape2 = new ModelRenderer(this, 0, 45);
        this.shape2.setRotationPoint(-12.0F, -15.0F, 5.0F);
        this.shape2.addBox(0.0F, 0.0F, 0.0F, 24, 17, 17, 0.0F);
        this.setRotateAngle(shape2, -0.31869712141416456F, 0.0F, 0.0F);
        this.leg_B_R = new ModelRenderer(this, 93, 92);
        this.leg_B_R.setRotationPoint(5.0F, 3.0F, 8.0F);
        this.leg_B_R.addBox(0.0F, 0.0F, 0.0F, 6, 21, 6, 0.0F);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
        this.leg_T_L.render(f5);
        this.head.render(f5);
        this.leg_B_L.render(f5);
        this.shape1.render(f5);
        this.head2.render(f5);
        this.leg_T_R.render(f5);
        this.shape2.render(f5);
        this.leg_B_R.render(f5);
    }

    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
    
    @Override
    public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
    		float headPitch, float scaleFactor, Entity entityIn) {
    	this.leg_B_R.rotateAngleX = MathHelper.cos(limbSwing * 0.6662f + (float)Math.PI) * 1.4f * limbSwingAmount / 2;
    	this.leg_T_R.rotateAngleX = MathHelper.cos(limbSwing * 0.6662f) * 1.4f * limbSwingAmount / 2; 

    	this.leg_B_L.rotateAngleX = MathHelper.cos(limbSwing * 0.6662f) * 1.4f * limbSwingAmount / 2;
    	this.leg_T_L.rotateAngleX = MathHelper.cos(limbSwing * 0.6662f + (float)Math.PI) * 1.4f * limbSwingAmount / 2;
    	
    	this.head.rotateAngleY = netHeadYaw * 0.017453292F;
    	this.head.rotateAngleY = headPitch * 0.017453292F;
    	this.head2.rotateAngleY = netHeadYaw * 0.017453292F;
    	this.head2.rotateAngleY = headPitch * 0.017453292F;
    }
}