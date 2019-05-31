package com.laz.tirphycraft.entity.model.passif;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

/**
 * modelLayturtle - Undefined
 * Created using Tabula 7.0.1
 */
public class ModelLayTurtle extends ModelBase {
    public ModelRenderer shape1;
    public ModelRenderer shape2;
    public ModelRenderer head;
    public ModelRenderer shape4;
    public ModelRenderer shape5;
    public ModelRenderer shape6;
    public ModelRenderer shape7;
    public ModelRenderer shape9;
    public ModelRenderer shape10;
    public ModelRenderer shape11;
    public ModelRenderer shape12;
    public ModelRenderer shape13;

    public ModelLayTurtle() {
        this.textureWidth = 128;
        this.textureHeight = 64;
        this.shape1 = new ModelRenderer(this, 0, 0);
        this.shape1.setRotationPoint(-8.0F, 9.0F, -12.0F);
        this.shape1.addBox(0.0F, 0.0F, 0.0F, 16, 6, 24, 0.0F);
        this.shape13 = new ModelRenderer(this, 0, 0);
        this.shape13.setRotationPoint(-1.0F, 12.0F, 11.0F);
        this.shape13.addBox(0.0F, 0.0F, 0.0F, 2, 4, 1, 0.0F);
        this.setRotateAngle(shape13, 0.6829473363053812F, 0.0F, 0.0F);
        this.shape6 = new ModelRenderer(this, 90, 30);
        this.shape6.setRotationPoint(3.0F, 15.0F, -10.0F);
        this.shape6.addBox(0.0F, 0.0F, 0.0F, 4, 9, 4, 0.0F);
        this.shape10 = new ModelRenderer(this, 14, 0);
        this.shape10.setRotationPoint(-2.0F, 7.0F, -3.0F);
        this.shape10.addBox(0.0F, -8.0F, 0.0F, 1, 8, 1, 0.0F);
        this.setRotateAngle(shape10, 0.4553564018453205F, -0.136659280431156F, -0.27314402793711257F);
        this.shape7 = new ModelRenderer(this, 90, 45);
        this.shape7.setRotationPoint(-6.0F, 15.0F, -10.0F);
        this.shape7.addBox(0.0F, 0.0F, 0.0F, 4, 9, 4, 0.0F);
        this.shape9 = new ModelRenderer(this, 8, 0);
        this.shape9.setRotationPoint(0.0F, 9.0F, 0.0F);
        this.shape9.addBox(0.0F, -8.0F, 0.0F, 1, 6, 1, 0.0F);
        this.setRotateAngle(shape9, -0.5009094953223726F, 0.40980330836826856F, 0.0F);
        this.head = new ModelRenderer(this, 58, 0);
        this.head.setRotationPoint(0.0F, 13.0F, -12.0F);
        this.head.addBox(-4.0F, -6.0F, -6.0F, 6, 6, 6, 0.0F);
        this.shape5 = new ModelRenderer(this, 90, 15);
        this.shape5.setRotationPoint(-6.0F, 15.0F, 6.0F);
        this.shape5.addBox(0.0F, 0.0F, 0.0F, 4, 9, 4, 0.0F);
        this.shape12 = new ModelRenderer(this, 0, 8);
        this.shape12.setRotationPoint(1.0F, 10.0F, -2.0F);
        this.shape12.addBox(0.0F, -8.0F, 0.0F, 1, 5, 1, 0.0F);
        this.setRotateAngle(shape12, 0.7740535232594852F, -0.9105382707654417F, -0.136659280431156F);
        this.shape11 = new ModelRenderer(this, 8, 9);
        this.shape11.setRotationPoint(-3.0F, 7.0F, 3.0F);
        this.shape11.addBox(0.0F, -8.0F, 0.0F, 1, 8, 1, 0.0F);
        this.setRotateAngle(shape11, -0.31869712141416456F, -0.9105382707654417F, -0.36425021489121656F);
        this.shape2 = new ModelRenderer(this, 0, 32);
        this.shape2.setRotationPoint(-6.0F, 6.0F, -8.0F);
        this.shape2.addBox(0.0F, 0.0F, 0.0F, 12, 3, 16, 0.0F);
        this.shape4 = new ModelRenderer(this, 90, 0);
        this.shape4.setRotationPoint(2.0F, 15.0F, 6.0F);
        this.shape4.addBox(0.0F, 0.0F, 0.0F, 4, 9, 4, 0.0F);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
        this.shape1.render(f5);
        this.shape13.render(f5);
        this.shape6.render(f5);
        this.shape10.render(f5);
        this.shape7.render(f5);
        this.shape9.render(f5);
        this.head.render(f5);
        this.shape5.render(f5);
        this.shape12.render(f5);
        this.shape11.render(f5);
        this.shape2.render(f5);
        this.shape4.render(f5);
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
    	this.shape4.rotateAngleX = MathHelper.cos(limbSwing * 0.6662f + (float)Math.PI) * 1.4f * limbSwingAmount / 2;
    	this.shape5.rotateAngleX = MathHelper.cos(limbSwing * 0.6662f) * 1.4f * limbSwingAmount / 2; 

    	this.shape6.rotateAngleX = MathHelper.cos(limbSwing * 0.6662f + (float)Math.PI) * 1.4f * limbSwingAmount / 2;
    	this.shape7.rotateAngleX = MathHelper.cos(limbSwing * 0.6662f) * 1.4f * limbSwingAmount / 2;
    	
    	this.head.rotateAngleY = netHeadYaw * 0.017453292F;
    	this.head.rotateAngleX = headPitch * 0.017453292F;
    }
}
