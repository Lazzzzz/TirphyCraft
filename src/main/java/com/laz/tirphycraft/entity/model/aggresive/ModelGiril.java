package com.laz.tirphycraft.entity.model.aggresive;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

/**
 * ModelGiril - Laz
 * Created using Tabula 7.0.0
 */
public class ModelGiril extends ModelBase {
    public ModelRenderer leg1;
    public ModelRenderer leg2;
    public ModelRenderer body;
    public ModelRenderer leg3;
    public ModelRenderer leg4;
    public ModelRenderer head;
    public ModelRenderer body2;

    public ModelGiril() {
        this.textureWidth = 64;
        this.textureHeight = 64;
        this.body2 = new ModelRenderer(this, 27, 32);
        this.body2.setRotationPoint(-2.0F, 2.0F, -10.0F);
        this.body2.addBox(0.0F, 0.0F, 0.0F, 4, 4, 4, 0.0F);
        this.leg1 = new ModelRenderer(this, 0, 44);
        this.leg1.setRotationPoint(3.0F, 8.0F, -8.0F);
        this.leg1.addBox(0.0F, 0.0F, 0.0F, 4, 16, 4, 0.0F);
        this.setRotateAngle(leg1, 0.0F, -0.013788101090755204F, 0.0F);
        this.leg4 = new ModelRenderer(this, 0, 26);
        this.leg4.setRotationPoint(3.0F, 12.0F, 5.0F);
        this.leg4.addBox(0.0F, 0.0F, 0.0F, 4, 12, 4, 0.0F);
        this.leg3 = new ModelRenderer(this, 0, 26);
        this.leg3.setRotationPoint(-3.0F, 12.0F, 5.0F);
        this.leg3.addBox(-4.0F, 0.0F, 0.0F, 4, 12, 4, 0.0F);
        this.body = new ModelRenderer(this, 0, 0);
        this.body.setRotationPoint(-6.0F, 2.0F, -6.0F);
        this.body.addBox(0.0F, 0.0F, 0.0F, 12, 8, 17, 0.0F);
        this.setRotateAngle(body, -0.36425021489121656F, 0.0F, 0.0F);
        this.head = new ModelRenderer(this, 20, 48);
        this.head.setRotationPoint(0.0F, 8.0F, -10.0F);
        this.head.addBox(-4.0F, -8.0F, -8.0F, 8, 8, 8, 0.0F);
        this.leg2 = new ModelRenderer(this, 0, 44);
        this.leg2.setRotationPoint(-3.0F, 8.0F, -8.0F);
        this.leg2.addBox(-4.0F, 0.0F, 0.0F, 4, 16, 4, 0.0F);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
        this.body2.render(f5);
        this.leg1.render(f5);
        this.leg4.render(f5);
        this.leg3.render(f5);
        this.body.render(f5);
        this.head.render(f5);
        this.leg2.render(f5);
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
    	this.leg1.rotateAngleX = MathHelper.cos(limbSwing * 0.6662f + (float)Math.PI) * 1.4f * limbSwingAmount / 2;
    	this.leg2.rotateAngleX = MathHelper.cos(limbSwing * 0.6662f) * 1.4f * limbSwingAmount / 2;
    	this.leg3.rotateAngleX = MathHelper.cos(limbSwing * 0.6662f + (float)Math.PI) * 1.4f * limbSwingAmount / 2;
    	this.leg4.rotateAngleX = MathHelper.cos(limbSwing * 0.6662f) * 1.4f * limbSwingAmount / 2; 
    }
}
