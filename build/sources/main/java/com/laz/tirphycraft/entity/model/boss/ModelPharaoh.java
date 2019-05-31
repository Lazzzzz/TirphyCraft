package com.laz.tirphycraft.entity.model.boss;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

/**
 * ModelPharaoh - Laz
 * Created using Tabula 7.0.0
 */
public class ModelPharaoh extends ModelBase {
    public ModelRenderer body;
    public ModelRenderer under;
    public ModelRenderer legLeft;
    public ModelRenderer legLeft2;
    public ModelRenderer legRight2;
    public ModelRenderer legRight2_1;
    public ModelRenderer head;
    public ModelRenderer armLeft1;
    public ModelRenderer armLeft2;
    public ModelRenderer armRight1;
    public ModelRenderer armLeft2_1;
    public ModelRenderer spear1;
    public ModelRenderer spear2;
    public ModelRenderer spear3;
    public ModelRenderer spear4;
    public ModelRenderer head2;

    public ModelPharaoh() {
        this.textureWidth = 128;
        this.textureHeight = 64;
        this.legRight2_1 = new ModelRenderer(this, 69, 0);
        this.legRight2_1.setRotationPoint(7.0F, 7.0F, 0.0F);
        this.legRight2_1.addBox(-3.0F, 6.0F, -2.0F, 4, 11, 4, 0.0F);
        this.spear3 = new ModelRenderer(this, 2, 8);
        this.spear3.setRotationPoint(-11.0F, -9.0F, 0.0F);
        this.spear3.addBox(-3.0F, 13.0F, -17.0F, 4, 4, 1, 0.0F);
        this.under = new ModelRenderer(this, 0, 33);
        this.under.setRotationPoint(0.0F, -6.0F, 0.0F);
        this.under.addBox(-8.0F, 5.0F, -5.0F, 16, 8, 10, 0.0F);
        this.legLeft = new ModelRenderer(this, 52, 0);
        this.legLeft.setRotationPoint(-5.0F, 7.0F, 0.0F);
        this.legLeft.addBox(-3.0F, 6.0F, -2.0F, 4, 11, 4, 0.0F);
        this.armRight1 = new ModelRenderer(this, 103, 0);
        this.armRight1.setRotationPoint(10.0F, -9.0F, 0.0F);
        this.armRight1.addBox(0.0F, 5.0F, -2.0F, 4, 12, 4, 0.0F);
        this.spear1 = new ModelRenderer(this, 84, 22);
        this.spear1.setRotationPoint(-11.0F, -9.0F, 0.0F);
        this.spear1.addBox(-2.0F, 14.0F, -16.0F, 2, 2, 20, 0.0F);
        this.armLeft2_1 = new ModelRenderer(this, 27, 52);
        this.armLeft2_1.setRotationPoint(10.0F, -9.0F, 0.0F);
        this.armLeft2_1.addBox(-2.0F, -1.0F, -3.0F, 7, 6, 6, 0.0F);
        this.legRight2 = new ModelRenderer(this, 80, 45);
        this.legRight2.setRotationPoint(7.0F, 7.0F, 0.0F);
        this.legRight2.addBox(-4.0F, -6.0F, -3.0F, 6, 12, 6, 0.0F);
        this.armLeft1 = new ModelRenderer(this, 86, 0);
        this.armLeft1.setRotationPoint(-11.0F, -9.0F, 0.0F);
        this.armLeft1.addBox(-3.0F, 5.0F, -2.0F, 4, 12, 4, 0.0F);
        this.spear4 = new ModelRenderer(this, 110, 31);
        this.spear4.setRotationPoint(-11.0F, -9.0F, 0.0F);
        this.spear4.addBox(-1.5F, 14.5F, -24.0F, 1, 1, 7, 0.0F);
        this.armLeft2 = new ModelRenderer(this, 0, 52);
        this.armLeft2.setRotationPoint(-11.0F, -9.0F, 0.0F);
        this.armLeft2.addBox(-4.0F, -1.0F, -3.0F, 7, 6, 6, 0.0F);
        this.head2 = new ModelRenderer(this, 3, 0);
        this.head2.setRotationPoint(0.0F, -10.0F, -3.0F);
        this.head2.addBox(-1.0F, -1.0F, -8.0F, 2, 3, 1, 0.0F);
        this.body = new ModelRenderer(this, 0, 0);
        this.body.setRotationPoint(0.0F, -7.0F, 0.0F);
        this.body.addBox(-8.0F, -8.0F, -8.0F, 16, 16, 16, 0.0F);
        this.setRotateAngle(body, 0.7853981633974483F, 0.0F, 0.0F);
        this.head = new ModelRenderer(this, 67, 17);
        this.head.setRotationPoint(0.0F, -10.0F, -3.0F);
        this.head.addBox(-5.0F, -9.0F, -7.0F, 10, 9, 7, 0.0F);
        this.spear2 = new ModelRenderer(this, 111, 55);
        this.spear2.setRotationPoint(-11.0F, -9.0F, 0.0F);
        this.spear2.addBox(-3.0F, 13.0F, 4.0F, 4, 4, 4, 0.0F);
        this.legLeft2 = new ModelRenderer(this, 55, 45);
        this.legLeft2.setRotationPoint(-5.0F, 7.0F, 0.0F);
        this.legLeft2.addBox(-4.0F, -6.0F, -3.0F, 6, 12, 6, 0.0F);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
        this.legRight2_1.render(f5);
        this.spear3.render(f5);
        this.under.render(f5);
        this.legLeft.render(f5);
        this.armRight1.render(f5);
        this.spear1.render(f5);
        this.armLeft2_1.render(f5);
        this.legRight2.render(f5);
        this.armLeft1.render(f5);
        this.spear4.render(f5);
        this.armLeft2.render(f5);
        this.head2.render(f5);
        this.body.render(f5);
        this.head.render(f5);
        this.spear2.render(f5);
        this.legLeft2.render(f5);
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

    	this.armRight1.rotateAngleX = MathHelper.cos(limbSwing * 0.6662f + (float)Math.PI) * 1.4f * limbSwingAmount /2;
    	this.armLeft1.rotateAngleX = MathHelper.cos(limbSwing * 0.6662f) * 1.4f * limbSwingAmount /2;

    	this.armLeft2_1.rotateAngleX = MathHelper.cos(limbSwing * 0.6662f + (float)Math.PI) * 1.4f * limbSwingAmount /2;
    	this.armLeft2.rotateAngleX = MathHelper.cos(limbSwing * 0.6662f) * 1.4f * limbSwingAmount /2;    	

    	this.legRight2_1.rotateAngleX = MathHelper.cos(limbSwing * 0.6662f + (float)Math.PI) * 1.4f * limbSwingAmount /2;
    	this.legLeft.rotateAngleX = MathHelper.cos(limbSwing * 0.6662f) * 1.4f * limbSwingAmount /2; 
    	
    	this.legRight2.rotateAngleX = MathHelper.cos(limbSwing * 0.6662f + (float)Math.PI) * 1.4f * limbSwingAmount /2;
    	this.legLeft2.rotateAngleX = MathHelper.cos(limbSwing * 0.6662f) * 1.4f * limbSwingAmount /2; 
    	
    	this.spear1.rotateAngleX = MathHelper.cos(limbSwing * 0.6662f) * 1.4f * limbSwingAmount /2;
    	this.spear2.rotateAngleX = MathHelper.cos(limbSwing * 0.6662f) * 1.4f * limbSwingAmount /2;
    	this.spear3.rotateAngleX = MathHelper.cos(limbSwing * 0.6662f) * 1.4f * limbSwingAmount /2;
    	this.spear4.rotateAngleX = MathHelper.cos(limbSwing * 0.6662f) * 1.4f * limbSwingAmount /2;
    	
    	this.head.rotateAngleY = netHeadYaw * 0.017453292F;
    	this.head.rotateAngleX = headPitch * 0.017453292F;
    	
    	this.head2.rotateAngleY = netHeadYaw * 0.017453292F;
    	this.head2.rotateAngleX = headPitch * 0.017453292F;
    	
    }
}
