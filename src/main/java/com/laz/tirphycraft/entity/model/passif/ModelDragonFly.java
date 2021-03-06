package com.laz.tirphycraft.entity.model.passif;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

/**
 * ModelDragonFly - Laz
 * Created using Tabula 7.0.0
 */
public class ModelDragonFly extends ModelBase {
    public ModelRenderer HEAD;
    public ModelRenderer Body;
    public ModelRenderer tail;
    public ModelRenderer left_top;
    public ModelRenderer left_back;
    public ModelRenderer right_back;
    public ModelRenderer left_top_1;

    public ModelDragonFly() {
        this.textureWidth = 128;
        this.textureHeight = 64;
        this.HEAD = new ModelRenderer(this, 0, 0);
        this.HEAD.setRotationPoint(3.0F, 17.0F, -4.0F);
        this.HEAD.addBox(-6.0F, -5.0F, -5.0F, 6, 6, 6, 0.0F);
        this.setRotateAngle(HEAD, 0.6108652381980153F, 0.0F, 0.0F);
        this.right_back = new ModelRenderer(this, 80, 30);
        this.right_back.setRotationPoint(5.0F, 15.0F, 4.0F);
        this.right_back.addBox(0.0F, 0.0F, -4.0F, 20, 0, 5, 0.0F);
        this.Body = new ModelRenderer(this, 30, 0);
        this.Body.setRotationPoint(0.0F, 17.0F, -2.0F);
        this.Body.addBox(-5.0F, -4.0F, -4.0F, 10, 6, 9, 0.0F);
        this.left_top = new ModelRenderer(this, 80, 20);
        this.left_top.setRotationPoint(5.0F, 15.0F, -2.0F);
        this.left_top.addBox(0.0F, 0.0F, -4.0F, 20, 0, 5, 0.0F);
        this.left_back = new ModelRenderer(this, 80, 0);
        this.left_back.setRotationPoint(-5.0F, 15.0F, 4.0F);
        this.left_back.addBox(-20.0F, 0.0F, -4.0F, 20, 0, 5, 0.0F);
        this.left_top_1 = new ModelRenderer(this, 80, 10);
        this.left_top_1.setRotationPoint(-5.0F, 15.0F, -2.0F);
        this.left_top_1.addBox(-20.0F, 0.0F, -4.0F, 20, 0, 5, 0.0F);
        this.tail = new ModelRenderer(this, 0, 20);
        this.tail.setRotationPoint(0.0F, 18.0F, 2.0F);
        this.tail.addBox(-3.0F, -4.0F, 0.0F, 6, 3, 25, 0.0F);
        this.setRotateAngle(tail, -0.19198621771937624F, 0.0F, 0.0F);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
        this.HEAD.render(f5);
        this.right_back.render(f5);
        this.Body.render(f5);
        this.left_top.render(f5);
        this.left_back.render(f5);
        this.left_top_1.render(f5);
        this.tail.render(f5);
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
    	
    	this.right_back.rotateAngleZ = MathHelper.cos(limbSwing * 0.9662f + (float)Math.PI) * 0.5f * limbSwingAmount;
    	this.left_top_1.rotateAngleZ = MathHelper.cos(limbSwing * 0.9662f + (float)Math.PI) * 0.5f * limbSwingAmount;
    	this.left_top.rotateAngleZ = MathHelper.cos(limbSwing * 0.9662f) * 0.5f * limbSwingAmount;
    	this.left_back.rotateAngleZ = MathHelper.cos(limbSwing * 0.9662f) * 0.5f * limbSwingAmount;
    	

    }
}
