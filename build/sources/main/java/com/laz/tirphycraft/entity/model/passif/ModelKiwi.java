package com.laz.tirphycraft.entity.model.passif;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

/**
 * ModelCow - Either Mojang or a mod author
 * Created using Tabula 7.0.0
 */
public class ModelKiwi extends ModelBase {
    public ModelRenderer body;
    public ModelRenderer LegBR;
    public ModelRenderer LegTR;
    public ModelRenderer LegBL;
    public ModelRenderer LegTL;
    public ModelRenderer coup1;
    public ModelRenderer coup2;
    public ModelRenderer corn;
    public ModelRenderer head;
    public ModelRenderer corn2;
    public ModelRenderer corn3;
    public ModelRenderer shape18;
    public ModelRenderer shape17;
    public ModelRenderer shape19;
    public ModelRenderer shape20;

    public ModelKiwi() {
        this.textureWidth = 64;
        this.textureHeight = 64;
        this.corn2 = new ModelRenderer(this, 47, 37);
        this.corn2.setRotationPoint(0.0F, -4.0F, -13.0F);
        this.corn2.addBox(-6.0F, -5.0F, -7.0F, 2, 1, 6, 0.0F);
        this.shape19 = new ModelRenderer(this, 54, 0);
        this.shape19.setRotationPoint(0.0F, 3.0F, 7.0F);
        this.shape19.addBox(-1.0F, -4.0F, -2.0F, 2, 5, 2, 0.0F);
        this.setRotateAngle(shape19, -0.7853981633974483F, 0.0F, 0.0F);
        this.coup2 = new ModelRenderer(this, 0, 48);
        this.coup2.setRotationPoint(0.0F, 8.0F, -6.0F);
        this.coup2.addBox(-2.0F, -15.0F, 2.0F, 4, 8, 4, 0.0F);
        this.setRotateAngle(coup2, 0.8196066167365371F, 0.0F, 0.0F);
        this.corn = new ModelRenderer(this, 29, 32);
        this.corn.setRotationPoint(0.0F, -4.0F, -13.0F);
        this.corn.addBox(-6.0F, -5.0F, -3.0F, 12, 1, 2, 0.0F);
        this.LegTL = new ModelRenderer(this, 0, 16);
        this.LegTL.setRotationPoint(-4.0F, 12.0F, -6.0F);
        this.LegTL.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F);
        this.corn3 = new ModelRenderer(this, 47, 37);
        this.corn3.setRotationPoint(0.0F, -4.0F, -13.0F);
        this.corn3.addBox(4.0F, -5.0F, -7.0F, 2, 1, 6, 0.0F);
        this.LegBR = new ModelRenderer(this, 0, 16);
        this.LegBR.setRotationPoint(4.0F, 12.0F, 6.0F);
        this.LegBR.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F);
        this.coup1 = new ModelRenderer(this, 0, 33);
        this.coup1.setRotationPoint(0.0F, 5.0F, -8.0F);
        this.coup1.addBox(-3.0F, -6.0F, -3.0F, 6, 6, 6, 0.0F);
        this.shape17 = new ModelRenderer(this, 54, 0);
        this.shape17.setRotationPoint(0.0F, 3.0F, 3.0F);
        this.shape17.addBox(-1.0F, -4.0F, -2.0F, 2, 5, 2, 0.0F);
        this.setRotateAngle(shape17, -0.7853981633974483F, 0.0F, 0.0F);
        this.head = new ModelRenderer(this, 0, 0);
        this.head.setRotationPoint(0.0F, -4.0F, -13.0F);
        this.head.addBox(-3.0F, -6.0F, -6.0F, 6, 6, 6, 0.0F);
        this.LegBL = new ModelRenderer(this, 0, 16);
        this.LegBL.setRotationPoint(-4.0F, 12.0F, 6.0F);
        this.LegBL.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F);
        this.body = new ModelRenderer(this, 18, 4);
        this.body.setRotationPoint(0.0F, 5.0F, 2.0F);
        this.body.addBox(-6.0F, -10.0F, -7.0F, 12, 16, 10, 0.0F);
        this.setRotateAngle(body, 1.5707963267948966F, 0.0F, 0.0F);
        this.shape18 = new ModelRenderer(this, 54, 0);
        this.shape18.setRotationPoint(0.0F, 3.0F, -1.0F);
        this.shape18.addBox(-1.0F, -4.0F, -2.0F, 2, 5, 2, 0.0F);
        this.setRotateAngle(shape18, -0.7853981633974483F, 0.0F, 0.0F);
        this.shape20 = new ModelRenderer(this, 31, 39);
        this.shape20.setRotationPoint(-1.0F, 5.0F, 7.0F);
        this.shape20.addBox(0.0F, 0.0F, 0.0F, 2, 4, 1, 0.0F);
        this.setRotateAngle(shape20, 0.5235987755982988F, 0.0F, 0.0F);
        this.LegTR = new ModelRenderer(this, 0, 16);
        this.LegTR.setRotationPoint(4.0F, 12.0F, -6.0F);
        this.LegTR.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
        this.corn2.render(f5);
        this.shape19.render(f5);
        this.coup2.render(f5);
        this.corn.render(f5);
        this.LegTL.render(f5);
        this.corn3.render(f5);
        this.LegBR.render(f5);
        this.coup1.render(f5);
        this.shape17.render(f5);
        this.head.render(f5);
        this.LegBL.render(f5);
        this.body.render(f5);
        this.shape18.render(f5);
        this.shape20.render(f5);
        this.LegTR.render(f5);
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
    	
    	this.LegTR.rotateAngleX = MathHelper.cos(limbSwing * 0.6662f + (float)Math.PI) * 1.4f * limbSwingAmount / 2;
    	this.LegTL.rotateAngleX = MathHelper.cos(limbSwing * 0.6662f) * 1.4f * limbSwingAmount / 2; 

    	this.LegBL.rotateAngleX = MathHelper.cos(limbSwing * 0.6662f + (float)Math.PI) * 1.4f * limbSwingAmount / 2;
    	this.LegBR.rotateAngleX = MathHelper.cos(limbSwing * 0.6662f) * 1.4f * limbSwingAmount / 2;
    	
    	this.head.rotateAngleY = netHeadYaw * 0.017453292F;
    	this.head.rotateAngleX = headPitch * 0.017453292F;
    	
    	this.corn.rotateAngleY = netHeadYaw * 0.017453292F;
    	this.corn.rotateAngleX = headPitch * 0.017453292F;
    	
    	this.corn2.rotateAngleY = netHeadYaw * 0.017453292F;
    	this.corn2.rotateAngleX = headPitch * 0.017453292F;
    	
    	this.corn3.rotateAngleY = netHeadYaw * 0.017453292F;
    	this.corn3.rotateAngleX = headPitch * 0.017453292F;
    }
}
