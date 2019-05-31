package com.laz.tirphycraft.entity.model.boss;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

/**
 * ModelPoseidon - Laz
 * Created using Tabula 7.0.0
 */
public class ModelPoseidon extends ModelBase {
    public ModelRenderer Body1;
    public ModelRenderer Body2;
    public ModelRenderer Body3;
    public ModelRenderer rotBu1;
    public ModelRenderer rotBu2;
    public ModelRenderer rotBu3;
    public ModelRenderer rotBu4;
    public ModelRenderer rotMid1;
    public ModelRenderer rotMid2;
    public ModelRenderer rotMid3;
    public ModelRenderer rotMid4;
    public ModelRenderer rotTop1;
    public ModelRenderer rotTop2;
    public ModelRenderer rotTop3;
    public ModelRenderer rotTop4;

    public ModelPoseidon() {
        this.textureWidth = 128;
        this.textureHeight = 128;
        this.rotTop2 = new ModelRenderer(this, 78, 55);
        this.rotTop2.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.rotTop2.addBox(-12.0F, -20.0F, -4.0F, 2, 10, 8, 0.0F);
        this.rotMid2 = new ModelRenderer(this, 78, 20);
        this.rotMid2.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.rotMid2.addBox(-16.0F, -4.0F, -4.0F, 2, 12, 8, 0.0F);
        this.rotBu4 = new ModelRenderer(this, 102, 14);
        this.rotBu4.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.rotBu4.addBox(-4.0F, 12.0F, 10.0F, 8, 10, 2, 0.0F);
        this.rotMid4 = new ModelRenderer(this, 102, 47);
        this.rotMid4.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.rotMid4.addBox(-4.0F, -4.0F, 14.0F, 8, 12, 2, 0.0F);
        this.rotBu1 = new ModelRenderer(this, 55, 0);
        this.rotBu1.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.rotBu1.addBox(10.0F, 12.0F, -4.0F, 2, 10, 8, 0.0F);
        this.rotBu2 = new ModelRenderer(this, 78, 0);
        this.rotBu2.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.rotBu2.addBox(-12.0F, 12.0F, -4.0F, 2, 10, 8, 0.0F);
        this.rotBu3 = new ModelRenderer(this, 102, 0);
        this.rotBu3.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.rotBu3.addBox(-4.0F, 12.0F, -12.0F, 8, 10, 2, 0.0F);
        this.rotMid1 = new ModelRenderer(this, 55, 20);
        this.rotMid1.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.rotMid1.addBox(14.0F, -4.0F, -4.0F, 2, 12, 8, 0.0F);
        this.rotTop1 = new ModelRenderer(this, 55, 55);
        this.rotTop1.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.rotTop1.addBox(10.0F, -20.0F, -4.0F, 2, 10, 8, 0.0F);
        this.Body3 = new ModelRenderer(this, 0, 60);
        this.Body3.setRotationPoint(-5.0F, -22.0F, -5.0F);
        this.Body3.addBox(0.0F, 0.0F, 0.0F, 10, 16, 10, 0.0F);
        this.rotTop3 = new ModelRenderer(this, 102, 66);
        this.rotTop3.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.rotTop3.addBox(-4.0F, -20.0F, -12.0F, 8, 10, 2, 0.0F);
        this.Body1 = new ModelRenderer(this, 0, 0);
        this.Body1.setRotationPoint(-5.0F, 8.0F, -5.0F);
        this.Body1.addBox(0.0F, 0.0F, 0.0F, 10, 16, 10, 0.0F);
        this.rotTop4 = new ModelRenderer(this, 102, 82);
        this.rotTop4.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.rotTop4.addBox(-4.0F, -20.0F, 10.0F, 8, 10, 2, 0.0F);
        this.Body2 = new ModelRenderer(this, 0, 29);
        this.Body2.setRotationPoint(-7.0F, -6.0F, -7.0F);
        this.Body2.addBox(0.0F, 0.0F, 0.0F, 14, 16, 14, 0.0F);
        this.rotMid3 = new ModelRenderer(this, 102, 30);
        this.rotMid3.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.rotMid3.addBox(-4.0F, -4.0F, -16.0F, 8, 12, 2, 0.0F);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
        this.rotTop2.render(f5);
        this.rotMid2.render(f5);
        this.rotBu4.render(f5);
        this.rotMid4.render(f5);
        this.rotBu1.render(f5);
        this.rotBu2.render(f5);
        this.rotBu3.render(f5);
        this.rotMid1.render(f5);
        this.rotTop1.render(f5);
        this.Body3.render(f5);
        this.rotTop3.render(f5);
        this.Body1.render(f5);
        this.rotTop4.render(f5);
        this.Body2.render(f5);
        this.rotMid3.render(f5);
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
public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
	this.rotTop1.rotateAngleY += MathHelper.cos(0.6662f) * 0.02f;
	this.rotTop2.rotateAngleY += MathHelper.cos(0.6662f) * 0.02f;
	this.rotTop3.rotateAngleY += MathHelper.cos(0.6662f) * 0.02f;
	this.rotTop4.rotateAngleY += MathHelper.cos(0.6662f) * 0.02f;
	
	this.rotBu1.rotateAngleY += MathHelper.cos(0.6662f) * 0.02f;
	this.rotBu2.rotateAngleY += MathHelper.cos(0.6662f) * 0.02f;
	this.rotBu3.rotateAngleY += MathHelper.cos(0.6662f) * 0.02f;
	this.rotBu4.rotateAngleY += MathHelper.cos(0.6662f) * 0.02f;
	
	this.rotMid1.rotateAngleY -= MathHelper.cos(0.6662f) * 0.02f;
	this.rotMid2.rotateAngleY -= MathHelper.cos(0.6662f) * 0.02f;
	this.rotMid3.rotateAngleY -= MathHelper.cos(0.6662f) * 0.02f;
	this.rotMid4.rotateAngleY -= MathHelper.cos(0.6662f) * 0.02f;
}
    
}
