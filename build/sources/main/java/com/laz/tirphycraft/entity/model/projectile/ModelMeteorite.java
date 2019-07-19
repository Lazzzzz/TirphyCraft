package com.laz.tirphycraft.entity.model.projectile;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

/**
 * modelMeteorite - LaZz_
 * Created using Tabula 7.0.1
 */
public class ModelMeteorite extends ModelBase {
    public ModelRenderer shape1;

    public ModelMeteorite() {
        this.textureWidth = 448;
        this.textureHeight = 224;
        this.shape1 = new ModelRenderer(this, 0, 0);
        this.shape1.setRotationPoint(0.0F, -32.0F, 0.0F);
        this.shape1.addBox(-56.0F, -56.0F, -56.0F, 112, 112, 112, 0.0F);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
        this.shape1.render(f5);
    }

    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}
