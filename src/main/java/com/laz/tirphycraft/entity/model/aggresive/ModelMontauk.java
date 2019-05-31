package com.laz.tirphycraft.entity.model.aggresive;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

/**
 * ModelMontauk - Laz
 * Created using Tabula 7.0.0
 */
public class ModelMontauk extends ModelBase {
    public ModelRenderer shape1;
    public ModelRenderer left;
    public ModelRenderer right;

    public ModelMontauk() {
        this.textureWidth = 64;
        this.textureHeight = 64;
        this.shape1 = new ModelRenderer(this, 0, 0);
        this.shape1.setRotationPoint(0.0F, 8.0F, 0.0F);
        this.shape1.addBox(-6.0F, -6.0F, -6.0F, 12, 12, 12, 0.0F);
        this.left = new ModelRenderer(this, 0, 26);
        this.left.setRotationPoint(-8.0F, 8.0F, 0.0F);
        this.left.addBox(0.0F, -16.0F, -3.0F, 2, 32, 6, 0.0F);
        this.right = new ModelRenderer(this, 19, 26);
        this.right.setRotationPoint(-8.0F, 8.0F, 0.0F);
        this.right.addBox(14.0F, -16.0F, -3.0F, 2, 32, 6, 0.0F);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
        this.shape1.render(f5);
        this.left.render(f5);
        this.right.render(f5);
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
    	this.left.rotateAngleX = MathHelper.cos(limbSwing * 0.6662f + (float)Math.PI) * 1.4f * limbSwingAmount / 2;
    	this.right.rotateAngleX = MathHelper.cos(limbSwing * 0.6662f) * 1.4f * limbSwingAmount / 2; 
    }
}
