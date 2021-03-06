package com.laz.tirphycraft.entity.model.projectile;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

/**
 * ModelIceBall - LaZz_
 * Created using Tabula 7.0.1
 */
public class ModelIceBall extends ModelBase {
    public ModelRenderer shape1;
    public ModelRenderer shape2;
    public ModelRenderer shape3;

    public ModelIceBall() {
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.shape1 = new ModelRenderer(this, 0, 0);
        this.shape1.setRotationPoint(0.0F, 20.0F, 0.0F);
        this.shape1.addBox(-4.0F, -4.0F, -4.0F, 8, 8, 8, 0.0F);
        this.setRotateAngle(shape1, 0.7853981633974483F, 0.0F, 0.0F);
        this.shape2 = new ModelRenderer(this, 0, 0);
        this.shape2.setRotationPoint(0.0F, 20.0F, 0.0F);
        this.shape2.addBox(-4.0F, -4.0F, -4.0F, 8, 8, 8, 0.0F);
        this.setRotateAngle(shape2, 0.0F, 0.7853981633974483F, 0.0F);
        this.shape3 = new ModelRenderer(this, 0, 0);
        this.shape3.setRotationPoint(0.0F, 20.0F, 0.0F);
        this.shape3.addBox(-4.0F, -4.0F, -4.0F, 8, 8, 8, 0.0F);
        this.setRotateAngle(shape3, 0.0F, 0.0F, 0.7853981633974483F);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
        this.shape1.render(f5);
        this.shape2.render(f5);
        this.shape3.render(f5);
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
    	  this.shape1.rotateAngleX += (MathHelper.cos(0.0662f) * 0.1f) + 0.7853981633974483F;
    	  this.shape2.rotateAngleY += (MathHelper.cos(0.0662f) * 0.1f) + 0.7853981633974483F;
    	  this.shape3.rotateAngleZ += (MathHelper.cos(0.0662f) * 0.1f) + 0.7853981633974483F;

    	super.setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scaleFactor, entityIn);
    }
}
