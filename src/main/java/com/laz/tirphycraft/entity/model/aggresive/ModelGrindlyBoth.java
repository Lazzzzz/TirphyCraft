package com.laz.tirphycraft.entity.model.aggresive;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

/**
 * Grindly - Undefined
 * Created using Tabula 7.0.0
 */
public class ModelGrindlyBoth extends ModelBase {
    public ModelRenderer legLEFT;
    public ModelRenderer legRIGHT;
    public ModelRenderer shape3;
    public ModelRenderer BODY;
    public ModelRenderer shape9;
    public ModelRenderer shape10;
    public ModelRenderer HEAD;
    public ModelRenderer brasleft;
    public ModelRenderer brasRight;
    public ModelRenderer t3;
    public ModelRenderer t1;
    public ModelRenderer t2;
    public ModelRenderer t4;

    public ModelGrindlyBoth() {
        this.textureWidth = 128;
        this.textureHeight = 64;
        this.legRIGHT = new ModelRenderer(this, 40, 0);
        this.legRIGHT.setRotationPoint(1.0F, 16.0F, -2.0F);
        this.legRIGHT.addBox(0.0F, 0.0F, 0.0F, 4, 8, 4, 0.0F);
        this.shape9 = new ModelRenderer(this, 80, 0);
        this.shape9.setRotationPoint(-1.0F, 2.0F, 0.0F);
        this.shape9.addBox(0.0F, -6.0F, 0.0F, 2, 6, 2, 0.0F);
        this.setRotateAngle(shape9, -1.5707963267948966F, 0.0F, 0.0F);
        this.legLEFT = new ModelRenderer(this, 59, 0);
        this.legLEFT.setRotationPoint(-5.0F, 16.0F, -2.0F);
        this.legLEFT.addBox(0.0F, 0.0F, 0.0F, 4, 8, 4, 0.0F);
        this.HEAD = new ModelRenderer(this, 0, 0);
        this.HEAD.setRotationPoint(0.0F, 0.0F, -8.0F);
        this.HEAD.addBox(-4.0F, -4.0F, -2.0F, 8, 8, 8, 0.0F);
        this.t4 = new ModelRenderer(this, 0, 25);
        this.t4.setRotationPoint(0.0F, 0.0F, -8.0F);
        this.t4.addBox(-3.0F, -8.0F, 5.0F, 6, 1, 1, 0.0F);
        this.brasleft = new ModelRenderer(this, 50, 45);
        this.brasleft.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.brasleft.addBox(-10.0F, 7.0F, -15.0F, 4, 4, 14, 0.0F);
        this.shape10 = new ModelRenderer(this, 90, 0);
        this.shape10.setRotationPoint(-1.0F, 6.3F, 2.0F);
        this.shape10.addBox(0.0F, -6.0F, 0.0F, 2, 6, 2, 0.0F);
        this.setRotateAngle(shape10, -1.5707963267948966F, 0.0F, 0.0F);
        this.BODY = new ModelRenderer(this, 24, 19);
        this.BODY.setRotationPoint(-6.0F, 4.0F, -9.0F);
        this.BODY.addBox(0.0F, 0.0F, 0.0F, 12, 12, 9, 0.0F);
        this.setRotateAngle(BODY, 0.5009094953223726F, 0.0F, 0.0F);
        this.brasRight = new ModelRenderer(this, 0, 45);
        this.brasRight.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.brasRight.addBox(6.0F, 7.0F, -15.0F, 4, 4, 14, 0.0F);
        this.t3 = new ModelRenderer(this, 0, 35);
        this.t3.setRotationPoint(0.0F, 0.0F, -8.0F);
        this.t3.addBox(-3.0F, -8.0F, -2.0F, 6, 1, 1, 0.0F);
        this.t1 = new ModelRenderer(this, 70, 25);
        this.t1.setRotationPoint(0.0F, 0.0F, -8.0F);
        this.t1.addBox(-4.0F, -8.0F, -2.0F, 1, 1, 8, 0.0F);
        this.shape3 = new ModelRenderer(this, 80, 40);
        this.shape3.setRotationPoint(-6.0F, 10.0F, -3.0F);
        this.shape3.addBox(0.0F, 0.0F, 0.0F, 12, 6, 6, 0.0F);
        this.t2 = new ModelRenderer(this, 100, 25);
        this.t2.setRotationPoint(0.0F, 0.0F, -8.0F);
        this.t2.addBox(3.0F, -8.0F, -2.0F, 1, 1, 8, 0.0F);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
        this.legRIGHT.render(f5);
        this.shape9.render(f5);
        this.legLEFT.render(f5);
        this.HEAD.render(f5);
        this.t4.render(f5);
        this.brasleft.render(f5);
        this.shape10.render(f5);
        this.BODY.render(f5);
        this.brasRight.render(f5);
        this.t3.render(f5);
        this.t1.render(f5);
        this.shape3.render(f5);
        this.t2.render(f5);
    }

    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
    
    @Override
    public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
    		float headPitch, float scaleFactor, Entity entityIn) {
    	
    	this.legLEFT.rotateAngleX = MathHelper.cos(limbSwing * 0.6662f + (float)Math.PI) * 1.4f * limbSwingAmount / 2;
    	this.legRIGHT.rotateAngleX = MathHelper.cos(limbSwing * 0.6662f) * 1.4f * limbSwingAmount / 2; 
    	
    	this.t1.rotateAngleY = netHeadYaw * 0.017453292F;
    	this.t1.rotateAngleX = headPitch * 0.017453292F;      	
    	this.t2.rotateAngleY = netHeadYaw * 0.017453292F;
    	this.t2.rotateAngleX = headPitch * 0.017453292F;   
    	this.t3.rotateAngleY = netHeadYaw * 0.017453292F;
    	this.t3.rotateAngleX = headPitch * 0.017453292F;   
    	this.t4.rotateAngleY = netHeadYaw * 0.017453292F;
    	this.t4.rotateAngleX = headPitch * 0.017453292F;   
    	this.HEAD.rotateAngleY = netHeadYaw * 0.017453292F;
    	this.HEAD.rotateAngleX = headPitch * 0.017453292F;  

    }
}
