package com.laz.tirphycraft.entity.model.aggresive;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

/**
 * ModelCerbere - Laz
 * Created using Tabula 7.0.0
 */
public class ModelCerbere extends ModelBase {
    public ModelRenderer body;
    public ModelRenderer legTL;
    public ModelRenderer legBR;
    public ModelRenderer legTR;
    public ModelRenderer legBL;
    public ModelRenderer shape6;
    public ModelRenderer headMiddle;
    public ModelRenderer headMiddle4;
    public ModelRenderer headRight2;
    public ModelRenderer headMiddle3;
    public ModelRenderer tail2;
    public ModelRenderer tail;
    public ModelRenderer headRight;
    public ModelRenderer headMiddle2;
    public ModelRenderer headMiddle4_1;
    public ModelRenderer headRight3;
    public ModelRenderer headLeft;
    public ModelRenderer headLeft2;
    public ModelRenderer headLeft3;
    public ModelRenderer headLeft4;

    public ModelCerbere() {
        this.textureWidth = 128;
        this.textureHeight = 64;
        this.headMiddle3 = new ModelRenderer(this, 70, 13);
        this.headMiddle3.setRotationPoint(0.0F, 13.0F, -7.0F);
        this.headMiddle3.addBox(-3.0F, -8.0F, -2.0F, 2, 2, 1, 0.0F);
        this.headLeft3 = new ModelRenderer(this, 96, 13);
        this.headLeft3.setRotationPoint(-4.0F, 13.0F, -7.0F);
        this.headLeft3.addBox(-6.0F, -9.0F, -2.0F, 2, 2, 1, 0.0F);
        this.legBR = new ModelRenderer(this, 16, 23);
        this.legBR.setRotationPoint(1.0F, 14.0F, 9.0F);
        this.legBR.addBox(0.0F, 0.0F, 0.0F, 3, 10, 3, 0.0F);
        this.headRight2 = new ModelRenderer(this, 82, 22);
        this.headRight2.setRotationPoint(4.0F, 13.0F, -7.0F);
        this.headRight2.addBox(1.5F, -4.0F, -8.0F, 3, 3, 4, 0.0F);
        this.headRight = new ModelRenderer(this, 85, 0);
        this.headRight.setRotationPoint(4.0F, 13.0F, -7.0F);
        this.headRight.addBox(0.0F, -7.0F, -4.0F, 6, 6, 4, 0.0F);
        this.headLeft = new ModelRenderer(this, 107, 0);
        this.headLeft.setRotationPoint(-4.0F, 13.0F, -7.0F);
        this.headLeft.addBox(-6.0F, -7.0F, -4.0F, 6, 6, 4, 0.0F);
        this.headMiddle2 = new ModelRenderer(this, 64, 22);
        this.headMiddle2.setRotationPoint(0.0F, 13.0F, -7.0F);
        this.headMiddle2.addBox(-1.5F, -3.0F, -8.0F, 3, 3, 4, 0.0F);
        this.headMiddle = new ModelRenderer(this, 64, 0);
        this.headMiddle.setRotationPoint(0.0F, 13.0F, -7.0F);
        this.headMiddle.addBox(-3.0F, -6.0F, -4.0F, 6, 6, 4, 0.0F);
        this.headMiddle4_1 = new ModelRenderer(this, 79, 13);
        this.headMiddle4_1.setRotationPoint(4.0F, 13.0F, -7.0F);
        this.headMiddle4_1.addBox(4.0F, -9.0F, -2.0F, 2, 2, 1, 0.0F);
        this.headMiddle4 = new ModelRenderer(this, 62, 13);
        this.headMiddle4.setRotationPoint(0.0F, 13.0F, -7.0F);
        this.headMiddle4.addBox(1.0F, -8.0F, -2.0F, 2, 2, 1, 0.0F);
        this.body = new ModelRenderer(this, 0, 40);
        this.body.setRotationPoint(-4.0F, 6.0F, -4.0F);
        this.body.addBox(0.0F, 0.0F, 0.0F, 8, 8, 16, 0.0F);
        this.headLeft4 = new ModelRenderer(this, 105, 13);
        this.headLeft4.setRotationPoint(-4.0F, 13.0F, -7.0F);
        this.headLeft4.addBox(-2.0F, -9.0F, -2.0F, 2, 2, 1, 0.0F);
        this.legBL = new ModelRenderer(this, 48, 23);
        this.legBL.setRotationPoint(-4.0F, 14.0F, 9.0F);
        this.legBL.addBox(0.0F, 0.0F, 0.0F, 3, 10, 3, 0.0F);
        this.tail2 = new ModelRenderer(this, 0, 0);
        this.tail2.setRotationPoint(-1.0F, 9.0F, 12.0F);
        this.tail2.addBox(-0.5F, -0.5F, 7.0F, 3, 3, 3, 0.0F);
        this.setRotateAngle(tail2, -0.7853981633974483F, 0.0F, 0.0F);
        this.legTR = new ModelRenderer(this, 32, 23);
        this.legTR.setRotationPoint(1.0F, 14.0F, -4.0F);
        this.legTR.addBox(0.0F, 0.0F, 0.0F, 3, 10, 3, 0.0F);
        this.tail = new ModelRenderer(this, 0, 10);
        this.tail.setRotationPoint(-1.0F, 9.0F, 12.0F);
        this.tail.addBox(0.0F, 0.0F, 0.0F, 2, 2, 7, 0.0F);
        this.setRotateAngle(tail, -0.7853981633974483F, 0.0F, 0.0F);
        this.legTL = new ModelRenderer(this, 0, 23);
        this.legTL.setRotationPoint(-4.0F, 14.0F, -4.0F);
        this.legTL.addBox(0.0F, 0.0F, 0.0F, 3, 10, 3, 0.0F);
        this.shape6 = new ModelRenderer(this, 26, 0);
        this.shape6.setRotationPoint(-5.0F, 5.0F, -7.0F);
        this.shape6.addBox(0.0F, 0.0F, 0.0F, 10, 10, 3, 0.0F);
        this.headLeft2 = new ModelRenderer(this, 99, 22);
        this.headLeft2.setRotationPoint(-4.0F, 13.0F, -7.0F);
        this.headLeft2.addBox(-4.5F, -4.0F, -8.0F, 3, 3, 4, 0.0F);
        this.headRight3 = new ModelRenderer(this, 88, 13);
        this.headRight3.setRotationPoint(4.0F, 13.0F, -7.0F);
        this.headRight3.addBox(0.0F, -9.0F, -2.0F, 2, 2, 1, 0.0F);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
        this.headMiddle3.render(f5);
        this.headLeft3.render(f5);
        this.legBR.render(f5);
        this.headRight2.render(f5);
        this.headRight.render(f5);
        this.headLeft.render(f5);
        this.headMiddle2.render(f5);
        this.headMiddle.render(f5);
        this.headMiddle4_1.render(f5);
        this.headMiddle4.render(f5);
        this.body.render(f5);
        this.headLeft4.render(f5);
        this.legBL.render(f5);
        this.tail2.render(f5);
        this.legTR.render(f5);
        this.tail.render(f5);
        this.legTL.render(f5);
        this.shape6.render(f5);
        this.headLeft2.render(f5);
        this.headRight3.render(f5);
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
    	
    	this.legBR.rotateAngleX = MathHelper.cos(limbSwing * 0.6662f + (float)Math.PI) * 1.4f * limbSwingAmount / 2;
    	this.legTR.rotateAngleX = MathHelper.cos(limbSwing * 0.6662f) * 1.4f * limbSwingAmount / 2; 

    	this.legBL.rotateAngleX = MathHelper.cos(limbSwing * 0.6662f + (float)Math.PI) * 1.4f * limbSwingAmount / 2;
    	this.legTL.rotateAngleX = MathHelper.cos(limbSwing * 0.6662f) * 1.4f * limbSwingAmount / 2; 
  
    	this.headMiddle.rotateAngleY = netHeadYaw * 0.017453292F;
    	this.headMiddle2.rotateAngleY = netHeadYaw * 0.017453292F;
    	this.headMiddle3.rotateAngleY = netHeadYaw * 0.017453292F;
    	this.headMiddle4.rotateAngleY = netHeadYaw * 0.017453292F;
    	this.headMiddle.rotateAngleY = headPitch * 0.017453292F;
    	this.headMiddle2.rotateAngleY = headPitch * 0.017453292F;
    	this.headMiddle3.rotateAngleY = headPitch * 0.017453292F;
    	this.headMiddle4.rotateAngleY = headPitch * 0.017453292F;
    	
    	this.headRight.rotateAngleY = netHeadYaw * 0.017453292F;
    	this.headRight2.rotateAngleY = netHeadYaw * 0.017453292F;
    	this.headRight3.rotateAngleY = netHeadYaw * 0.017453292F;
    	this.headMiddle4_1.rotateAngleY = netHeadYaw * 0.017453292F;
    	this.headRight.rotateAngleY = headPitch * 0.017453292F;
    	this.headRight2.rotateAngleY = headPitch * 0.017453292F;
    	this.headRight3.rotateAngleY = headPitch * 0.017453292F;
    	this.headMiddle4_1.rotateAngleY = headPitch * 0.017453292F;
    	
    	this.headLeft.rotateAngleY = netHeadYaw * 0.017453292F;
    	this.headLeft2.rotateAngleY = netHeadYaw * 0.017453292F;
    	this.headLeft3.rotateAngleY = netHeadYaw * 0.017453292F;
    	this.headLeft4.rotateAngleY = netHeadYaw * 0.017453292F;
    	this.headLeft.rotateAngleY = headPitch * 0.017453292F;
    	this.headLeft2.rotateAngleY = headPitch * 0.017453292F;
    	this.headLeft3.rotateAngleY = headPitch * 0.017453292F;
    	this.headLeft4.rotateAngleY = headPitch * 0.017453292F;

    	
    }
}
