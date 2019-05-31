package com.laz.tirphycraft.entity.model.boss;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

/**
 * ModelArtikon - Lazz
 * Created using Tabula 7.0.0
 */
public class ModelArtikon extends ModelBase {
    public ModelRenderer shape1;
    public ModelRenderer shape2;
    public ModelRenderer shape3;
    public ModelRenderer shape4;
    public ModelRenderer shape5;
    public ModelRenderer shape6;
    public ModelRenderer shape7;
    public ModelRenderer shape9;
    public ModelRenderer shape10;
    public ModelRenderer shape11;
    public ModelRenderer shape12;
    public ModelRenderer shape13;
    public ModelRenderer shape14;
    public ModelRenderer shape15;
    public ModelRenderer shape16;
    public ModelRenderer shape17;
    public ModelRenderer shape18;
    public ModelRenderer shape19;
    public ModelRenderer s20;
    public ModelRenderer s22;
    public ModelRenderer s21;
    public ModelRenderer s221;
    public ModelRenderer shape141;
    public ModelRenderer shape142;
    public ModelRenderer shape143;
    public ModelRenderer s222;
    public ModelRenderer s223;
    public ModelRenderer s224;
    public ModelRenderer s225;
    public ModelRenderer s226;
    public ModelRenderer s227;
    public ModelRenderer HEAD1;
    public ModelRenderer rot1;
    public ModelRenderer rot2;
    public ModelRenderer rot3;
    public ModelRenderer rot4;
    public ModelRenderer rot5;

    public ModelArtikon() {
        this.textureWidth = 128;
        this.textureHeight = 128;
        this.shape141 = new ModelRenderer(this, 0, 0);
        this.shape141.setRotationPoint(-10.4F, -19.0F, 10.0F);
        this.shape141.addBox(-7.0F, 0.0F, -1.0F, 8, 2, 2, 0.0F);
        this.setRotateAngle(shape141, 0.0F, -0.6108652381980153F, 0.0F);
        this.shape2 = new ModelRenderer(this, 64, 0);
        this.shape2.setRotationPoint(0.0F, -9.0F, 0.0F);
        this.shape2.addBox(-1.0F, 0.0F, -15.0F, 2, 2, 30, 0.0F);
        this.setRotateAngle(shape2, 0.0F, 0.7853981633974483F, 0.0F);
        this.shape12 = new ModelRenderer(this, 0, 0);
        this.shape12.setRotationPoint(9.6F, -9.0F, 10.0F);
        this.shape12.addBox(0.0F, 0.0F, 0.0F, 8, 2, 2, 0.0F);
        this.setRotateAngle(shape12, 0.0F, 0.6108652381980153F, 0.0F);
        this.s225 = new ModelRenderer(this, 42, 0);
        this.s225.setRotationPoint(10.0F, -9.0F, -10.0F);
        this.s225.addBox(-1.0F, 0.0F, -8.0F, 2, 2, 8, 0.0F);
        this.setRotateAngle(s225, 0.0F, 0.6108652381980153F, 0.0F);
        this.s221 = new ModelRenderer(this, 42, 0);
        this.s221.setRotationPoint(-10.6F, -14.0F, 10.0F);
        this.s221.addBox(-1.0F, 0.0F, 0.0F, 2, 2, 8, 0.0F);
        this.setRotateAngle(s221, 0.0F, 0.6108652381980153F, 0.0F);
        this.shape18 = new ModelRenderer(this, 0, 0);
        this.shape18.setRotationPoint(9.9F, -14.0F, -11.2F);
        this.shape18.addBox(0.0F, 0.0F, 0.0F, 8, 2, 2, 0.0F);
        this.setRotateAngle(shape18, 0.0F, -0.6108652381980153F, 0.0F);
        this.shape143 = new ModelRenderer(this, 0, 0);
        this.shape143.setRotationPoint(-11.0F, -14.0F, -11.4F);
        this.shape143.addBox(-7.0F, 0.0F, 0.0F, 8, 2, 2, 0.0F);
        this.setRotateAngle(shape143, 0.0F, 0.6108652381980153F, 0.0F);
        this.s21 = new ModelRenderer(this, 42, 0);
        this.s21.setRotationPoint(10.4F, -19.0F, 10.0F);
        this.s21.addBox(-1.0F, 0.0F, 0.0F, 2, 2, 8, 0.0F);
        this.setRotateAngle(s21, 0.0F, -0.6108652381980153F, 0.0F);
        this.s226 = new ModelRenderer(this, 42, 0);
        this.s226.setRotationPoint(10.0F, -19.0F, -10.0F);
        this.s226.addBox(-1.0F, 0.0F, -8.0F, 2, 2, 8, 0.0F);
        this.setRotateAngle(s226, 0.0F, 0.6108652381980153F, 0.0F);
        this.shape10 = new ModelRenderer(this, 42, 0);
        this.shape10.setRotationPoint(-10.4F, -9.0F, 10.0F);
        this.shape10.addBox(-1.0F, 0.0F, 0.0F, 2, 2, 8, 0.0F);
        this.setRotateAngle(shape10, 0.0F, 0.6108652381980153F, 0.0F);
        this.s227 = new ModelRenderer(this, 42, 0);
        this.s227.setRotationPoint(10.0F, -14.0F, -10.0F);
        this.s227.addBox(-1.0F, 0.0F, -8.0F, 2, 2, 8, 0.0F);
        this.setRotateAngle(s227, 0.0F, 0.6108652381980153F, 0.0F);
        this.HEAD1 = new ModelRenderer(this, 3, 10);
        this.HEAD1.setRotationPoint(0.0F, -21.0F, 0.0F);
        this.HEAD1.addBox(-4.0F, -9.0F, -4.0F, 8, 8, 8, 0.0F);
        this.rot4 = new ModelRenderer(this, 20, 32);
        this.rot4.setRotationPoint(0.0F, -14.0F, 12.0F);
        this.rot4.addBox(-3.0F, -3.0F, -3.0F, 6, 6, 6, 0.0F);
        this.s224 = new ModelRenderer(this, 42, 0);
        this.s224.setRotationPoint(-10.0F, -14.0F, -11.0F);
        this.s224.addBox(-1.0F, 0.0F, -8.0F, 2, 2, 8, 0.0F);
        this.setRotateAngle(s224, 0.0F, -0.6108652381980153F, 0.0F);
        this.shape4 = new ModelRenderer(this, 64, 0);
        this.shape4.setRotationPoint(0.0F, -14.0F, 0.0F);
        this.shape4.addBox(-1.0F, 0.0F, -15.0F, 2, 2, 30, 0.0F);
        this.setRotateAngle(shape4, 0.0F, -0.7853981633974483F, 0.0F);
        this.shape142 = new ModelRenderer(this, 0, 0);
        this.shape142.setRotationPoint(-11.0F, -9.0F, -11.4F);
        this.shape142.addBox(-7.0F, 0.0F, 0.0F, 8, 2, 2, 0.0F);
        this.setRotateAngle(shape142, 0.0F, 0.6108652381980153F, 0.0F);
        this.shape1 = new ModelRenderer(this, 0, 33);
        this.shape1.setRotationPoint(-2.0F, -25.0F, -2.0F);
        this.shape1.addBox(0.0F, 0.0F, 0.0F, 4, 32, 4, 0.0F);
        this.s22 = new ModelRenderer(this, 42, 0);
        this.s22.setRotationPoint(-10.6F, -19.0F, 10.0F);
        this.s22.addBox(-1.0F, 0.0F, 0.0F, 2, 2, 8, 0.0F);
        this.setRotateAngle(s22, 0.0F, 0.6108652381980153F, 0.0F);
        this.shape15 = new ModelRenderer(this, 0, 0);
        this.shape15.setRotationPoint(9.6F, -14.0F, 10.0F);
        this.shape15.addBox(0.0F, 0.0F, 0.0F, 8, 2, 2, 0.0F);
        this.setRotateAngle(shape15, 0.0F, 0.6108652381980153F, 0.0F);
        this.shape19 = new ModelRenderer(this, 0, 0);
        this.shape19.setRotationPoint(9.9F, -9.0F, -11.2F);
        this.shape19.addBox(0.0F, 0.0F, 0.0F, 8, 2, 2, 0.0F);
        this.setRotateAngle(shape19, 0.0F, -0.6108652381980153F, 0.0F);
        this.rot5 = new ModelRenderer(this, 61, 36);
        this.rot5.setRotationPoint(0.0F, 16.0F, 0.0F);
        this.rot5.addBox(-4.0F, -4.0F, -4.0F, 8, 8, 8, 0.0F);
        this.shape3 = new ModelRenderer(this, 64, 0);
        this.shape3.setRotationPoint(0.0F, -9.0F, 0.0F);
        this.shape3.addBox(-1.0F, 0.0F, -15.0F, 2, 2, 30, 0.0F);
        this.setRotateAngle(shape3, 0.0F, -0.7853981633974483F, 0.0F);
        this.shape13 = new ModelRenderer(this, 0, 0);
        this.shape13.setRotationPoint(-10.4F, -14.0F, 10.0F);
        this.shape13.addBox(-7.0F, 0.0F, -1.0F, 8, 2, 2, 0.0F);
        this.setRotateAngle(shape13, 0.0F, -0.6108652381980153F, 0.0F);
        this.s223 = new ModelRenderer(this, 42, 0);
        this.s223.setRotationPoint(-10.0F, -9.0F, -11.0F);
        this.s223.addBox(-1.0F, 0.0F, -8.0F, 2, 2, 8, 0.0F);
        this.setRotateAngle(s223, 0.0F, -0.6108652381980153F, 0.0F);
        this.rot2 = new ModelRenderer(this, 20, 32);
        this.rot2.setRotationPoint(11.0F, -14.0F, 0.0F);
        this.rot2.addBox(-3.0F, -3.0F, -3.0F, 6, 6, 6, 0.0F);
        this.shape14 = new ModelRenderer(this, 0, 0);
        this.shape14.setRotationPoint(-11.0F, -19.0F, -11.4F);
        this.shape14.addBox(-7.0F, 0.0F, 0.0F, 8, 2, 2, 0.0F);
        this.setRotateAngle(shape14, 0.0F, 0.6108652381980153F, 0.0F);
        this.shape5 = new ModelRenderer(this, 64, 0);
        this.shape5.setRotationPoint(0.0F, -9.0F, 0.0F);
        this.shape5.addBox(-1.0F, -10.0F, -15.0F, 2, 2, 30, 0.0F);
        this.setRotateAngle(shape5, 0.0F, -0.7853981633974483F, 0.0F);
        this.rot1 = new ModelRenderer(this, 20, 32);
        this.rot1.setRotationPoint(-11.0F, -14.0F, 0.0F);
        this.rot1.addBox(-3.0F, -3.0F, -3.0F, 6, 6, 6, 0.0F);
        this.shape11 = new ModelRenderer(this, 0, 0);
        this.shape11.setRotationPoint(-10.4F, -9.0F, 10.0F);
        this.shape11.addBox(-7.0F, 0.0F, -1.0F, 8, 2, 2, 0.0F);
        this.setRotateAngle(shape11, 0.0F, -0.6108652381980153F, 0.0F);
        this.shape9 = new ModelRenderer(this, 42, 0);
        this.shape9.setRotationPoint(10.4F, -9.0F, 10.0F);
        this.shape9.addBox(-1.0F, 0.0F, 0.0F, 2, 2, 8, 0.0F);
        this.setRotateAngle(shape9, 0.0F, -0.6108652381980153F, 0.0F);
        this.s222 = new ModelRenderer(this, 42, 0);
        this.s222.setRotationPoint(-10.0F, -19.0F, -11.0F);
        this.s222.addBox(-1.0F, 0.0F, -8.0F, 2, 2, 8, 0.0F);
        this.setRotateAngle(s222, 0.0F, -0.6108652381980153F, 0.0F);
        this.s20 = new ModelRenderer(this, 42, 0);
        this.s20.setRotationPoint(10.4F, -14.0F, 10.0F);
        this.s20.addBox(-1.0F, 0.0F, 0.0F, 2, 2, 8, 0.0F);
        this.setRotateAngle(s20, 0.0F, -0.6108652381980153F, 0.0F);
        this.rot3 = new ModelRenderer(this, 20, 32);
        this.rot3.setRotationPoint(0.0F, -14.0F, -11.0F);
        this.rot3.addBox(-3.0F, -3.0F, -3.0F, 6, 6, 6, 0.0F);
        this.shape7 = new ModelRenderer(this, 64, 0);
        this.shape7.setRotationPoint(0.0F, -14.0F, 0.0F);
        this.shape7.addBox(-1.0F, -5.0F, -15.0F, 2, 2, 30, 0.0F);
        this.setRotateAngle(shape7, 0.0F, 0.7853981633974483F, 0.0F);
        this.shape17 = new ModelRenderer(this, 0, 0);
        this.shape17.setRotationPoint(9.9F, -19.0F, -11.2F);
        this.shape17.addBox(0.0F, 0.0F, 0.0F, 8, 2, 2, 0.0F);
        this.setRotateAngle(shape17, 0.0F, -0.6108652381980153F, 0.0F);
        this.shape6 = new ModelRenderer(this, 64, 0);
        this.shape6.setRotationPoint(0.0F, -14.0F, 0.0F);
        this.shape6.addBox(-1.0F, 0.0F, -15.0F, 2, 2, 30, 0.0F);
        this.setRotateAngle(shape6, 0.0F, 0.7853981633974483F, 0.0F);
        this.shape16 = new ModelRenderer(this, 0, 0);
        this.shape16.setRotationPoint(9.6F, -19.0F, 10.0F);
        this.shape16.addBox(0.0F, 0.0F, 0.0F, 8, 2, 2, 0.0F);
        this.setRotateAngle(shape16, 0.0F, 0.6108652381980153F, 0.0F);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
        this.shape141.render(f5);
        this.shape2.render(f5);
        this.shape12.render(f5);
        this.s225.render(f5);
        this.s221.render(f5);
        this.shape18.render(f5);
        this.shape143.render(f5);
        this.s21.render(f5);
        this.s226.render(f5);
        this.shape10.render(f5);
        this.s227.render(f5);
        this.HEAD1.render(f5);
        this.rot4.render(f5);
        this.s224.render(f5);
        this.shape4.render(f5);
        this.shape142.render(f5);
        this.shape1.render(f5);
        this.s22.render(f5);
        this.shape15.render(f5);
        this.shape19.render(f5);
        this.rot5.render(f5);
        this.shape3.render(f5);
        this.shape13.render(f5);
        this.s223.render(f5);
        this.rot2.render(f5);
        this.shape14.render(f5);
        this.shape5.render(f5);
        this.rot1.render(f5);
        this.shape11.render(f5);
        this.shape9.render(f5);
        this.s222.render(f5);
        this.s20.render(f5);
        this.rot3.render(f5);
        this.shape7.render(f5);
        this.shape17.render(f5);
        this.shape6.render(f5);
        this.shape16.render(f5);
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
    		
    	this.rot1.rotateAngleY += MathHelper.cos(0.6662f) * 0.2f;
    	this.rot2.rotateAngleY += MathHelper.cos(0.6662f) * 0.2f;
    	this.rot3.rotateAngleY += MathHelper.cos(0.6662f) * 0.2f;
    	this.rot4.rotateAngleY += MathHelper.cos(0.6662f) * 0.2f;
    	this.rot1.rotateAngleX += MathHelper.cos(0.6662f) * 0.2f;
    	this.rot2.rotateAngleX += MathHelper.cos(0.6662f) * 0.2f;
    	this.rot3.rotateAngleX += MathHelper.cos(0.6662f) * 0.2f;
    	this.rot4.rotateAngleX += MathHelper.cos(0.6662f) * 0.2f;
    	this.rot1.rotateAngleZ += MathHelper.cos(0.6662f) * 0.2f;
    	this.rot2.rotateAngleZ += MathHelper.cos(0.6662f) * 0.2f;
    	this.rot3.rotateAngleZ += MathHelper.cos(0.6662f) * 0.2f;
    	this.rot4.rotateAngleZ += MathHelper.cos(0.6662f) * 0.2f;
    	
    	this.HEAD1.rotateAngleY = netHeadYaw * 0.017453292F;
    	this.HEAD1.rotateAngleX = headPitch * 0.017453292F;
    	
    }
}
