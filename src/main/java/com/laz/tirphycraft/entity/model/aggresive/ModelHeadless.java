package com.laz.tirphycraft.entity.model.aggresive;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

/**
 * ModelHeadless - Undefined
 * Created using Tabula 7.0.0
 */
public class ModelHeadless extends ModelBase {
    public ModelRenderer leg1;
    public ModelRenderer leg2;
    public ModelRenderer body;
    public ModelRenderer arm1;
    public ModelRenderer arm2;
    public ModelRenderer head;

    public ModelHeadless() {
        this.textureWidth = 128;
        this.textureHeight = 64;
        this.body = new ModelRenderer(this, 0, 0);
        this.body.setRotationPoint(-8.0F, -20.0F, -4.0F);
        this.body.addBox(0.0F, 0.0F, 0.0F, 16, 20, 8, 0.0F);
        this.arm2 = new ModelRenderer(this, 30, 40);
        this.arm2.setRotationPoint(-8.0F, -18.0F, -2.0F);
        this.arm2.addBox(-4.0F, 0.0F, 0.0F, 4, 20, 4, 0.0F);
        this.setRotateAngle(arm2, -0.6981317007977318F, -0.6981317007977318F, 0.0F);
        this.head = new ModelRenderer(this, 49, 1);
        this.head.setRotationPoint(0.0F, -3.0F, -11.0F);
        this.head.addBox(-4.0F, -4.0F, -4.0F, 8, 8, 8, 0.0F);
        this.leg1 = new ModelRenderer(this, 0, 34);
        this.leg1.setRotationPoint(2.0F, 0.0F, -3.0F);
        this.leg1.addBox(0.0F, 0.0F, 0.0F, 6, 24, 6, 0.0F);
        this.leg2 = new ModelRenderer(this, 0, 34);
        this.leg2.setRotationPoint(-8.0F, 0.0F, -3.0F);
        this.leg2.addBox(0.0F, 0.0F, 0.0F, 6, 24, 6, 0.0F);
        this.arm1 = new ModelRenderer(this, 30, 40);
        this.arm1.setRotationPoint(8.0F, -18.0F, -2.0F);
        this.arm1.addBox(0.0F, 0.0F, 0.0F, 4, 20, 4, 0.0F);
        this.setRotateAngle(arm1, -0.6981317007977318F, 0.6981317007977318F, 0.0F);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
        this.body.render(f5);
        this.arm2.render(f5);
        this.head.render(f5);
        this.leg1.render(f5);
        this.leg2.render(f5);
        this.arm1.render(f5);
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
    	this.leg1.rotateAngleX = MathHelper.cos(limbSwing * 0.6662f + (float)Math.PI) * 1.4f * limbSwingAmount / 2;
    	this.leg2.rotateAngleX = MathHelper.cos(limbSwing * 0.6662f) * 1.4f * limbSwingAmount / 2; 
    	this.head.rotateAngleY = netHeadYaw * 0.017453292F;
    	this.head.rotateAngleX = headPitch * 0.017453292F;
    	
    }
}
