package com.laz.tirphycraft.objects.items.armor.models;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

/**
 * ModelPlayer - Either Mojang or a mod author
 * Created using Tabula 7.0.0
 */
public class ModelParachute extends ModelBiped {
    public ModelRenderer shape15;
    public ModelRenderer shape16;
    public ModelRenderer shape17;
    public ModelRenderer shape18;
    public ModelRenderer shape19;
    public ModelRenderer shape20;
    public ModelRenderer shape21;
    public ModelRenderer shape22;

    public ModelParachute() {
        this.textureWidth = 128;
        this.textureHeight = 128;
        this.shape20 = new ModelRenderer(this, 19, 42);
        this.shape20.setRotationPoint(-10.0F, -17.0F, -10.0F);
        this.shape20.addBox(0.0F, 0.0F, 0.0F, 20, 1, 20, 0.0F);
        this.shape15 = new ModelRenderer(this, 0, 22);
        this.shape15.setRotationPoint(-5.0F, -9.0F, -5.0F);
        this.shape15.addBox(0.0F, 0.0F, 0.0F, 10, 2, 10, 0.0F);
        this.shape19 = new ModelRenderer(this, 0, 0);
        this.shape19.setRotationPoint(-4.0F, -9.0F, 3.0F);
        this.shape19.addBox(0.0F, -8.0F, 0.0F, 1, 9, 1, 0.0F);
        this.setRotateAngle(shape19, -0.3490658503988659F, 0.0F, -0.3490658503988659F);
        this.shape21 = new ModelRenderer(this, 0, 70);
        this.shape21.setRotationPoint(-10.0F, -17.0F, -10.0F);
        this.shape21.addBox(-10.0F, 0.0F, 0.0F, 10, 1, 20, 0.0F);
        this.setRotateAngle(shape21, 0.0F, 0.0F, -0.4363323129985824F);
        this.shape16 = new ModelRenderer(this, 0, 0);
        this.shape16.setRotationPoint(3.0F, -9.0F, -4.0F);
        this.shape16.addBox(0.0F, -8.0F, 0.0F, 1, 9, 1, 0.0F);
        this.setRotateAngle(shape16, 0.3490658503988659F, 0.0F, 0.3490658503988659F);
        this.shape22 = new ModelRenderer(this, 0, 99);
        this.shape22.setRotationPoint(10.0F, -17.0F, -10.0F);
        this.shape22.addBox(0.0F, 0.0F, 0.0F, 10, 1, 20, 0.0F);
        this.setRotateAngle(shape22, 0.0F, 0.0F, 0.4363323129985824F);
        this.shape17 = new ModelRenderer(this, 0, 0);
        this.shape17.setRotationPoint(-4.0F, -9.0F, -4.0F);
        this.shape17.addBox(0.0F, -8.0F, 0.0F, 1, 10, 1, 0.0F);
        this.setRotateAngle(shape17, 0.3490658503988659F, 0.0F, -0.3490658503988659F);
        this.shape18 = new ModelRenderer(this, 0, 0);
        this.shape18.setRotationPoint(3.0F, -9.0F, 3.0F);
        this.shape18.addBox(0.0F, -9.1F, 0.0F, 1, 10, 1, 0.0F);
        this.setRotateAngle(shape18, -0.3490658503988659F, 0.0F, 0.3490658503988659F);
        
        this.bipedHead.addChild(shape15);
        this.bipedHead.addChild(shape16);
        this.bipedHead.addChild(shape17);
        this.bipedHead.addChild(shape18);
        this.bipedHead.addChild(shape19);
        this.bipedHead.addChild(shape20);
        this.bipedHead.addChild(shape21);
        this.bipedHead.addChild(shape22);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
    	super.render(entity, f, f1, f2, f3, f4, f5);
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
