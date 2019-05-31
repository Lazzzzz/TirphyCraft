package com.laz.tirphycraft.entity.model.aggresive;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

/**
 * ModelDeadPlayer - Either Mojang or a mod author
 * Created using Tabula 7.0.0
 */
public class ModelDeadPlayer extends ModelBase {
    public ModelRenderer leftArm;
    public ModelRenderer leftLeg;
    public ModelRenderer head;
    public ModelRenderer body;
    public ModelRenderer rightArm;
    public ModelRenderer rightLeg;
    public ModelRenderer t1;
    public ModelRenderer t2;
    public ModelRenderer t3;
    public ModelRenderer t4;

    public ModelDeadPlayer() {
        this.textureWidth = 64;
        this.textureHeight = 64;
        this.t1 = new ModelRenderer(this, 22, 34);
        this.t1.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.t1.addBox(-4.0F, -11.0F, -4.0F, 1, 1, 8, 0.0F);
        this.t4 = new ModelRenderer(this, 39, 0);
        this.t4.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.t4.addBox(-3.0F, -11.0F, 3.0F, 6, 1, 1, 0.0F);
        this.leftLeg = new ModelRenderer(this, 0, 16);
        this.leftLeg.setRotationPoint(-1.9F, 12.0F, 0.1F);
        this.leftLeg.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F);
        this.head = new ModelRenderer(this, 0, 0);
        this.head.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.head.addBox(-4.0F, -8.0F, -4.0F, 8, 8, 8, 0.0F);
        this.body = new ModelRenderer(this, 16, 16);
        this.body.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.body.addBox(-4.0F, 0.0F, -2.0F, 8, 12, 4, 0.0F);
        this.rightArm = new ModelRenderer(this, 40, 16);
        this.rightArm.mirror = true;
        this.rightArm.setRotationPoint(5.0F, 2.0F, 0.0F);
        this.rightArm.addBox(-1.0F, -2.0F, -2.0F, 4, 12, 4, 0.0F);
        this.t2 = new ModelRenderer(this, 0, 34);
        this.t2.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.t2.addBox(3.0F, -11.0F, -4.0F, 1, 1, 8, 0.0F);
        this.rightLeg = new ModelRenderer(this, 0, 16);
        this.rightLeg.mirror = true;
        this.rightLeg.setRotationPoint(1.9F, 12.0F, 0.1F);
        this.rightLeg.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F);
        this.t3 = new ModelRenderer(this, 39, 4);
        this.t3.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.t3.addBox(-3.0F, -11.0F, -4.0F, 6, 1, 1, 0.0F);
        this.leftArm = new ModelRenderer(this, 40, 16);
        this.leftArm.setRotationPoint(-5.0F, 2.0F, 0.0F);
        this.leftArm.addBox(-3.0F, -2.0F, -2.0F, 4, 12, 4, 0.0F);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
        this.t1.render(f5);
        this.t4.render(f5);
        this.leftLeg.render(f5);
        this.head.render(f5);
        this.body.render(f5);
        this.rightArm.render(f5);
        this.t2.render(f5);
        this.rightLeg.render(f5);
        this.t3.render(f5);
        this.leftArm.render(f5);
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
    	
    	this.leftLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662f + (float)Math.PI) * 1.4f * limbSwingAmount;
    	this.rightLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662f) * 1.4f * limbSwingAmount; 
    	this.rightArm.rotateAngleX = MathHelper.cos(limbSwing * 0.6662f + (float)Math.PI) * 1.4f * limbSwingAmount;
    	this.leftArm.rotateAngleX = MathHelper.cos(limbSwing * 0.6662f) * 1.4f * limbSwingAmount;
    	
    	this.head.rotateAngleY = netHeadYaw * 0.017453292F;
    	this.head.rotateAngleX = headPitch * 0.017453292F;   
    }
}
