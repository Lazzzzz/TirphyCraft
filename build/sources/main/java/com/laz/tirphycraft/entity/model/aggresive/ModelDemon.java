package com.laz.tirphycraft.entity.model.aggresive;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

/**
 * ModelDemon - Laz
 * Created using Tabula 7.0.0
 */
public class ModelDemon extends ModelBase {
    public ModelRenderer armLeft;
    public ModelRenderer legLeft;
    public ModelRenderer head;
    public ModelRenderer body;
    public ModelRenderer armRight;
    public ModelRenderer legRight;
    public ModelRenderer shape8;
    public ModelRenderer shape9;
    public ModelRenderer corn1;
    public ModelRenderer corn2;

    public ModelDemon() {
        this.textureWidth = 64;
        this.textureHeight = 64;
        this.armRight = new ModelRenderer(this, 40, 0);
        this.armRight.mirror = true;
        this.armRight.setRotationPoint(5.0F, -13.0F, 0.0F);
        this.armRight.addBox(-1.0F, -2.0F, -2.0F, 4, 12, 4, 0.0F);
        this.corn2 = new ModelRenderer(this, 50, 48);
        this.corn2.setRotationPoint(0.0F, -16.0F, 0.0F);
        this.corn2.addBox(4.0F, -11.0F, 0.0F, 1, 6, 1, 0.0F);
        this.armLeft = new ModelRenderer(this, 40, 0);
        this.armLeft.setRotationPoint(-5.0F, -13.0F, 0.0F);
        this.armLeft.addBox(-3.0F, -2.0F, -2.0F, 4, 12, 4, 0.0F);
        this.legLeft = new ModelRenderer(this, 0, 28);
        this.legLeft.setRotationPoint(-2.0F, -8.0F, 0.1F);
        this.legLeft.addBox(-2.0F, 0.0F, -2.0F, 4, 32, 4, 0.0F);
        this.body = new ModelRenderer(this, 25, 19);
        this.body.setRotationPoint(-1.0F, -16.0F, 0.0F);
        this.body.addBox(-4.0F, 0.0F, -2.0F, 10, 8, 6, 0.0F);
        this.legRight = new ModelRenderer(this, 0, 28);
        this.legRight.mirror = true;
        this.legRight.setRotationPoint(1.9F, -8.0F, 0.1F);
        this.legRight.addBox(-2.0F, 0.0F, -2.0F, 4, 32, 4, 0.0F);
        this.shape8 = new ModelRenderer(this, 20, 35);
        this.shape8.setRotationPoint(0.0F, -14.0F, 4.0F);
        this.shape8.addBox(0.0F, 0.0F, 0.0F, 13, 13, 0, 0.0F);
        this.corn1 = new ModelRenderer(this, 50, 37);
        this.corn1.setRotationPoint(0.0F, -16.0F, 0.0F);
        this.corn1.addBox(-5.0F, -11.0F, 0.0F, 1, 6, 1, 0.0F);
        this.shape9 = new ModelRenderer(this, 20, 49);
        this.shape9.setRotationPoint(0.0F, -14.0F, 4.0F);
        this.shape9.addBox(-13.0F, 0.0F, 0.0F, 13, 13, 0, 0.0F);
        this.head = new ModelRenderer(this, 0, 0);
        this.head.setRotationPoint(0.0F, -16.0F, 0.0F);
        this.head.addBox(-4.0F, -8.0F, -4.0F, 8, 8, 8, 0.0F);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
        this.armRight.render(f5);
        this.corn2.render(f5);
        this.armLeft.render(f5);
        this.legLeft.render(f5);
        this.body.render(f5);
        this.legRight.render(f5);
        this.shape8.render(f5);
        this.corn1.render(f5);
        this.shape9.render(f5);
        this.head.render(f5);
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
    	this.legLeft.rotateAngleX = MathHelper.cos(limbSwing * 0.6662f + (float)Math.PI) * 1.4f * limbSwingAmount;
    	this.legRight.rotateAngleX = MathHelper.cos(limbSwing * 0.6662f) * 1.4f * limbSwingAmount; 
    	this.armRight.rotateAngleX = MathHelper.cos(limbSwing * 0.6662f + (float)Math.PI) * 1.4f * limbSwingAmount;
    	this.armLeft.rotateAngleX = MathHelper.cos(limbSwing * 0.6662f) * 1.4f * limbSwingAmount;
    	
    	this.head.rotateAngleY = netHeadYaw * 0.017453292F;
    	this.head.rotateAngleX = headPitch * 0.017453292F;
    	
    	this.corn1.rotateAngleY = netHeadYaw * 0.017453292F;
    	this.corn1.rotateAngleX = headPitch * 0.017453292F;
    	
    	this.corn2.rotateAngleY = netHeadYaw * 0.017453292F;
    	this.corn2.rotateAngleX = headPitch * 0.017453292F;
   
    }
}
