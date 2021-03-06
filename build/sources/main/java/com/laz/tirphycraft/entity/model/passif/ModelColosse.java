package com.laz.tirphycraft.entity.model.passif;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

/**
 * ModelColosse - LaZz_
 * Created using Tabula 7.0.1
 */
public class ModelColosse extends ModelBase {
    public ModelRenderer shape1;
    public ModelRenderer shape3;
    public ModelRenderer shape4;
    public ModelRenderer shape5;
    public ModelRenderer shape8;
    public ModelRenderer shape9;
    public ModelRenderer shape10;
    public ModelRenderer shape11;
    public ModelRenderer shape12;
    public ModelRenderer shape14;
    public ModelRenderer shape16;
    public ModelRenderer shape17;
    public ModelRenderer shape2;
    public ModelRenderer shape6;
    public ModelRenderer shape7;
    public ModelRenderer shape13;
    public ModelRenderer shape15;

    public ModelColosse() {
        this.textureWidth = 128;
        this.textureHeight = 192;
        this.shape11 = new ModelRenderer(this, 95, 28);
        this.shape11.setRotationPoint(-16.0F, -41.0F, -8.0F);
        this.shape11.addBox(0.0F, 0.0F, 0.0F, 8, 8, 8, 0.0F);
        this.shape2 = new ModelRenderer(this, 49, 43);
        this.shape2.setRotationPoint(2.0F, -16.0F, 1.0F);
        this.shape2.addBox(0.0F, 0.0F, 0.0F, 12, 12, 12, 0.0F);
        this.shape6 = new ModelRenderer(this, 0, 108);
        this.shape6.setRotationPoint(-2.0F, 23.0F, -2.0F);
        this.shape6.addBox(0.0F, 0.0F, 0.0F, 12, 8, 12, 0.0F);
        this.shape8 = new ModelRenderer(this, 65, 0);
        this.shape8.setRotationPoint(0.0F, -22.0F, 10.0F);
        this.shape8.addBox(-4.0F, -4.0F, -4.0F, 8, 8, 8, 0.0F);
        this.setRotateAngle(shape8, 0.7853981633974483F, 0.7853981633974483F, 0.0F);
        this.shape10 = new ModelRenderer(this, 95, 10);
        this.shape10.setRotationPoint(8.0F, -41.0F, -8.0F);
        this.shape10.addBox(0.0F, 0.0F, 0.0F, 8, 8, 8, 0.0F);
        this.shape5 = new ModelRenderer(this, 47, 68);
        this.shape5.setRotationPoint(4.0F, -7.0F, 3.0F);
        this.shape5.addBox(0.0F, 0.0F, 0.0F, 8, 23, 8, 0.0F);
        this.shape12 = new ModelRenderer(this, 87, 68);
        this.shape12.setRotationPoint(-15.0F, -35.0F, -6.0F);
        this.shape12.addBox(0.0F, 0.0F, 0.0F, 4, 40, 4, 0.0F);
        this.shape15 = new ModelRenderer(this, 39, 130);
        this.shape15.setRotationPoint(-1.0F, 40.0F, -7.0F);
        this.shape15.addBox(0.0F, 0.0F, 2.0F, 6, 4, 12, 0.0F);
        this.shape1 = new ModelRenderer(this, 0, 0);
        this.shape1.setRotationPoint(-10.0F, -37.0F, -10.0F);
        this.shape1.addBox(0.0F, 0.0F, 0.0F, 20, 30, 12, 0.0F);
        this.setRotateAngle(shape1, 0.45378560551852565F, 0.0F, 0.0F);
        this.shape4 = new ModelRenderer(this, 0, 68);
        this.shape4.setRotationPoint(-12.0F, -7.0F, 3.0F);
        this.shape4.addBox(0.0F, 0.0F, 0.0F, 8, 23, 8, 0.0F);
        this.shape16 = new ModelRenderer(this, 0, 149);
        this.shape16.setRotationPoint(0.0F, -42.0F, -12.0F);
        this.shape16.addBox(-5.0F, -10.0F, 0.0F, 10, 10, 10, 0.0F);
        this.shape14 = new ModelRenderer(this, 105, 68);
        this.shape14.setRotationPoint(11.0F, -35.0F, -6.0F);
        this.shape14.addBox(0.0F, 0.0F, 0.0F, 4, 40, 4, 0.0F);
        this.shape9 = new ModelRenderer(this, 65, 19);
        this.shape9.setRotationPoint(0.0F, -36.0F, 4.0F);
        this.shape9.addBox(-4.0F, -4.0F, -4.0F, 8, 8, 8, 0.0F);
        this.setRotateAngle(shape9, -0.7853981633974483F, -0.7853981633974483F, 0.0F);
        this.shape17 = new ModelRenderer(this, 50, 154);
        this.shape17.setRotationPoint(-2.5F, -43.0F, -9.0F);
        this.shape17.addBox(0.0F, 0.0F, 0.0F, 5, 6, 5, 0.0F);
        this.setRotateAngle(shape17, 0.33161255787892263F, 0.0F, 0.0F);
        this.shape7 = new ModelRenderer(this, 49, 108);
        this.shape7.setRotationPoint(-2.0F, 23.0F, -2.0F);
        this.shape7.addBox(0.0F, 0.0F, 0.0F, 12, 8, 12, 0.0F);
        this.shape3 = new ModelRenderer(this, 0, 43);
        this.shape3.setRotationPoint(-14.0F, -16.0F, 1.0F);
        this.shape3.addBox(0.0F, 0.0F, 0.0F, 12, 12, 12, 0.0F);
        this.shape13 = new ModelRenderer(this, 1, 130);
        this.shape13.setRotationPoint(-1.0F, 40.0F, -7.0F);
        this.shape13.addBox(0.0F, 0.0F, 2.0F, 6, 4, 12, 0.0F);
        this.shape4.addChild(this.shape6);
        this.shape14.addChild(this.shape15);
        this.shape5.addChild(this.shape7);
        this.shape12.addChild(this.shape13);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
        this.shape11.render(f5);
        this.shape2.render(f5);
        this.shape8.render(f5);
        this.shape10.render(f5);
        this.shape5.render(f5);
        this.shape12.render(f5);
        this.shape1.render(f5);
        this.shape4.render(f5);
        this.shape16.render(f5);
        this.shape14.render(f5);
        this.shape9.render(f5);
        this.shape17.render(f5);
        this.shape3.render(f5);
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
