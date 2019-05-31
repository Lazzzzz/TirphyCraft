package com.laz.tirphycraft.entity.model.aggresive;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

/**
 * Phorus - Laz
 * Created using Tabula 7.0.0
 */
public class ModelPhorus extends ModelBase {
    public ModelRenderer Head;
    public ModelRenderer body;
    public ModelRenderer tail;

    public ModelPhorus() {
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.body = new ModelRenderer(this, 36, 0);
        this.body.setRotationPoint(-3.5F, 17.0F, -7.0F);
        this.body.addBox(0.0F, 0.0F, 0.0F, 7, 7, 7, 0.0F);
        this.tail = new ModelRenderer(this, 11, 9);
        this.tail.setRotationPoint(0.0F, 23.0F, 0.0F);
        this.tail.addBox(-1.0F, -1.0F, 0.0F, 2, 2, 21, 0.0F);
        this.Head = new ModelRenderer(this, 0, 0);
        this.Head.setRotationPoint(0.0F, 20.0F, -11.0F);
        this.Head.addBox(-4.0F, -4.0F, -4.0F, 8, 8, 8, 0.0F);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
        this.body.render(f5);
        this.tail.render(f5);
        this.Head.render(f5);
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
    	this.tail.rotateAngleY = MathHelper.cos(limbSwing * 0.6662f + (float)Math.PI) * 1.4f * limbSwingAmount;
    	this.Head.rotateAngleY = netHeadYaw * 0.017453292F;
    	this.Head.rotateAngleX = headPitch * 0.017453292F;    	
    }
    
    
}
