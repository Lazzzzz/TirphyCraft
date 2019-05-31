package com.laz.tirphycraft.entity.model.passif;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

/**
 * ModelPlayer - Either Mojang or a mod author
 * Created using Tabula 7.0.0
 */
public class ModelVidargavia extends ModelBase {
    public ModelRenderer head;
    public ModelRenderer body;
    public ModelRenderer left_leg;
    public ModelRenderer right_leg;
    public ModelRenderer right_arm;
    public ModelRenderer right_arm_1;

    public ModelVidargavia() {
        this.textureWidth = 64;
        this.textureHeight = 64;
        this.right_arm_1 = new ModelRenderer(this, 32, 48);
        this.right_arm_1.setRotationPoint(4.0F, 0.0F, -2.0F);
        this.right_arm_1.addBox(0.0F, 0.0F, 0.0F, 4, 12, 4, 0.0F);
        this.head = new ModelRenderer(this, 0, 0);
        this.head.setRotationPoint(-4.0F, -8.0F, -4.0F);
        this.head.addBox(0.0F, 0.0F, 0.0F, 8, 8, 8, 0.0F);
        this.right_arm = new ModelRenderer(this, 40, 16);
        this.right_arm.setRotationPoint(-8.0F, 0.0F, -2.0F);
        this.right_arm.addBox(0.0F, 0.0F, 0.0F, 4, 12, 4, 0.0F);
        this.right_leg = new ModelRenderer(this, 16, 48);
        this.right_leg.setRotationPoint(0.0F, 12.0F, -2.0F);
        this.right_leg.addBox(0.0F, 0.0F, 0.0F, 4, 12, 4, 0.0F);
        this.left_leg = new ModelRenderer(this, 0, 16);
        this.left_leg.setRotationPoint(-4.0F, 12.0F, -2.0F);
        this.left_leg.addBox(0.0F, 0.0F, 0.0F, 4, 12, 4, 0.0F);
        this.body = new ModelRenderer(this, 16, 16);
        this.body.setRotationPoint(-4.0F, 0.0F, -2.0F);
        this.body.addBox(0.0F, 0.0F, 0.0F, 8, 12, 4, 0.0F);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
        this.right_arm_1.render(f5);
        this.head.render(f5);
        this.right_arm.render(f5);
        this.right_leg.render(f5);
        this.left_leg.render(f5);
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
}
