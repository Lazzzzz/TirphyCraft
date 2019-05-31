package com.laz.tirphycraft.entity.model.aggresive;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

/**
 * Totam - Laz
 * Created using Tabula 7.0.0
 */
public class ModelTotam extends ModelBase {
    public ModelRenderer body;
    public ModelRenderer bas;
    public ModelRenderer rotate1;
    public ModelRenderer rotate2;

    public ModelTotam() {
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.rotate1 = new ModelRenderer(this, 26, 0);
        this.rotate1.setRotationPoint(0.0F, 3.0F, 0.0F);
        this.rotate1.addBox(6.0F, 0.0F, -4.0F, 1, 13, 8, 0.0F);
        this.rotate2 = new ModelRenderer(this, 45, 0);
        this.rotate2.setRotationPoint(0.0F, 3.0F, 0.0F);
        this.rotate2.addBox(-7.0F, 0.0F, -4.0F, 1, 13, 8, 0.0F);
        this.bas = new ModelRenderer(this, 43, 0);
        this.bas.setRotationPoint(-0.5F, 19.0F, -0.5F);
        this.bas.addBox(0.0F, 0.0F, 0.0F, 1, 5, 1, 0.0F);
        this.body = new ModelRenderer(this, 0, 0);
        this.body.setRotationPoint(-3.0F, 0.0F, -3.0F);
        this.body.addBox(0.0F, 0.0F, 0.0F, 6, 19, 6, 0.0F);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
        this.rotate1.render(f5);
        this.rotate2.render(f5);
        this.bas.render(f5);
        this.body.render(f5);
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
    	this.rotate1.rotateAngleY += MathHelper.cos(0.6662f) * 0.02f;
    	this.rotate2.rotateAngleY += MathHelper.cos(0.6662f) * 0.02f;
    }
}
