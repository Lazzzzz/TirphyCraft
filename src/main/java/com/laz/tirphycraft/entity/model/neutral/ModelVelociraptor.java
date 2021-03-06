package com.laz.tirphycraft.entity.model.neutral;


import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

/**
 * ModelVelociraptor  - LaZz_
 * Created using Tabula 7.0.1
 */
public class ModelVelociraptor extends ModelBase {
    public ModelRenderer shape1;
    public ModelRenderer tail_1;
    public ModelRenderer shape3;
    public ModelRenderer head;
    public ModelRenderer shape9;
    public ModelRenderer shape15;
    public ModelRenderer shape28;
    public ModelRenderer shape28_1;
    public ModelRenderer shape28_2;
    public ModelRenderer shape28_3;
    public ModelRenderer shape15_1;
    public ModelRenderer shape9_1;
    public ModelRenderer tail_2;
    public ModelRenderer tail_3;
    public ModelRenderer shape7;
    public ModelRenderer shape7_1;
    public ModelRenderer shape9_1_1;
    public ModelRenderer shape9_2;
    public ModelRenderer shape15_2;
    public ModelRenderer shape16;
    public ModelRenderer shape18;
    public ModelRenderer shape15_3;
    public ModelRenderer shape16_1;
    public ModelRenderer shape18_1;
    public ModelRenderer shape9_1_2;
    public ModelRenderer shape9_2_1;

    public ModelVelociraptor() {
        this.textureWidth = 128;
        this.textureHeight = 128;
        this.shape18_1 = new ModelRenderer(this, 72, 85);
        this.shape18_1.setRotationPoint(-1.0F, 10.5F, 0.0F);
        this.shape18_1.addBox(0.0F, 1.0F, -4.0F, 4, 2, 6, 0.0F);
        this.setRotateAngle(shape18_1, 0.5759586531581287F, 0.0F, 0.0F);
        this.shape9_1_1 = new ModelRenderer(this, 55, 44);
        this.shape9_1_1.setRotationPoint(0.5F, 5.0F, 2.0F);
        this.shape9_1_1.addBox(0.0F, 0.0F, -7.0F, 2, 2, 7, 0.0F);
        this.setRotateAngle(shape9_1_1, -0.2792526803190927F, 0.0F, 0.0F);
        this.shape15 = new ModelRenderer(this, 100, 40);
        this.shape15.setRotationPoint(5.0F, -1.0F, 4.0F);
        this.shape15.addBox(0.0F, 0.0F, 0.0F, 4, 8, 6, 0.0F);
        this.setRotateAngle(shape15, -0.5742133239061343F, 0.0F, 0.0F);
        this.shape9_1 = new ModelRenderer(this, 42, 60);
        this.shape9_1.setRotationPoint(-9.0F, 3.0F, -13.0F);
        this.shape9_1.addBox(0.0F, 0.0F, 0.0F, 3, 7, 3, 0.0F);
        this.setRotateAngle(shape9_1, 0.6108652381980153F, 0.0F, 0.0F);
        this.shape28 = new ModelRenderer(this, 0, 0);
        this.shape28.setRotationPoint(2.0F, -2.0F, 4.0F);
        this.shape28.addBox(0.0F, -6.0F, 0.0F, 2, 6, 2, 0.0F);
        this.setRotateAngle(shape28, -0.36425021489121656F, 0.0F, 0.36425021489121656F);
        this.shape16 = new ModelRenderer(this, 100, 70);
        this.shape16.setRotationPoint(1.0F, 9.0F, 10.0F);
        this.shape16.addBox(0.0F, 0.0F, 0.0F, 2, 12, 2, 0.0F);
        this.tail_1 = new ModelRenderer(this, 0, 37);
        this.tail_1.setRotationPoint(0.0F, 2.0F, 11.0F);
        this.tail_1.addBox(-4.0F, -3.0F, -1.0F, 8, 6, 11, 0.0F);
        this.shape18 = new ModelRenderer(this, 94, 85);
        this.shape18.setRotationPoint(-1.0F, 10.5F, 0.0F);
        this.shape18.addBox(0.0F, 1.0F, -4.0F, 4, 2, 6, 0.0F);
        this.setRotateAngle(shape18, 0.5759586531581287F, 0.0F, 0.0F);
        this.shape9 = new ModelRenderer(this, 42, 44);
        this.shape9.setRotationPoint(6.0F, 3.0F, -13.0F);
        this.shape9.addBox(0.0F, 0.0F, 0.0F, 3, 7, 3, 0.0F);
        this.setRotateAngle(shape9, 0.6108652381980153F, 0.0F, 0.0F);
        this.head = new ModelRenderer(this, 95, 0);
        this.head.setRotationPoint(0.0F, -10.0F, -19.0F);
        this.head.addBox(-4.0F, -4.0F, -8.0F, 8, 8, 8, 0.0F);
        this.shape9_1_2 = new ModelRenderer(this, 55, 60);
        this.shape9_1_2.setRotationPoint(0.5F, 5.0F, 2.0F);
        this.shape9_1_2.addBox(0.0F, 0.0F, -7.0F, 2, 2, 7, 0.0F);
        this.setRotateAngle(shape9_1_2, -0.2792526803190927F, 0.0F, 0.0F);
        this.shape7 = new ModelRenderer(this, 96, 18);
        this.shape7.setRotationPoint(-4.0F, -3.4F, -15.0F);
        this.shape7.addBox(0.0F, 0.0F, 0.0F, 8, 5, 7, 0.0F);
        this.shape9_2_1 = new ModelRenderer(this, 56, 60);
        this.shape9_2_1.setRotationPoint(0.5F, 2.0F, -6.5F);
        this.shape9_2_1.addBox(0.0F, 0.0F, 0.0F, 1, 1, 1, 0.0F);
        this.shape15_2 = new ModelRenderer(this, 100, 55);
        this.shape15_2.setRotationPoint(0.5F, 8.0F, 2.0F);
        this.shape15_2.addBox(0.0F, 0.0F, 0.0F, 3, 10, 4, 0.0F);
        this.setRotateAngle(shape15_2, 1.0471975511965976F, 0.0F, 0.0F);
        this.shape28_3 = new ModelRenderer(this, 9, 9);
        this.shape28_3.setRotationPoint(2.0F, -2.0F, -10.0F);
        this.shape28_3.addBox(0.0F, -6.0F, 0.0F, 2, 6, 2, 0.0F);
        this.setRotateAngle(shape28_3, 0.5918411493512771F, 0.0F, 0.31869712141416456F);
        this.shape16_1 = new ModelRenderer(this, 78, 70);
        this.shape16_1.setRotationPoint(1.0F, 9.0F, 10.0F);
        this.shape16_1.addBox(0.0F, 0.0F, 0.0F, 2, 12, 2, 0.0F);
        this.shape28_1 = new ModelRenderer(this, 9, 0);
        this.shape28_1.setRotationPoint(-3.0F, -2.0F, 2.0F);
        this.shape28_1.addBox(0.0F, -6.0F, 0.0F, 2, 6, 2, 0.0F);
        this.setRotateAngle(shape28_1, -0.136659280431156F, 0.0F, -0.40980330836826856F);
        this.shape15_1 = new ModelRenderer(this, 78, 40);
        this.shape15_1.setRotationPoint(-9.0F, -1.0F, 4.0F);
        this.shape15_1.addBox(0.0F, 0.0F, 0.0F, 4, 8, 6, 0.0F);
        this.setRotateAngle(shape15_1, -0.5742133239061343F, 0.0F, 0.0F);
        this.shape3 = new ModelRenderer(this, 55, 0);
        this.shape3.setRotationPoint(-3.0F, 1.0F, -15.0F);
        this.shape3.addBox(0.0F, 0.0F, 0.0F, 6, 5, 13, 0.0F);
        this.setRotateAngle(shape3, 2.2165681500327987F, 0.0F, 0.0F);
        this.tail_2 = new ModelRenderer(this, 0, 55);
        this.tail_2.setRotationPoint(0.0F, 0.0F, 10.0F);
        this.tail_2.addBox(-3.0F, -2.0F, -1.0F, 6, 4, 14, 0.0F);
        this.shape15_3 = new ModelRenderer(this, 78, 55);
        this.shape15_3.setRotationPoint(0.5F, 8.0F, 2.0F);
        this.shape15_3.addBox(0.0F, 0.0F, 0.0F, 3, 10, 4, 0.0F);
        this.setRotateAngle(shape15_3, 1.0471975511965976F, 0.0F, 0.0F);
        this.shape28_2 = new ModelRenderer(this, 0, 9);
        this.shape28_2.setRotationPoint(-3.0F, -1.1F, -10.0F);
        this.shape28_2.addBox(0.0F, -6.0F, 0.0F, 2, 6, 2, 0.0F);
        this.setRotateAngle(shape28_2, 0.5009094953223726F, 0.0F, -0.5009094953223726F);
        this.tail_3 = new ModelRenderer(this, 0, 74);
        this.tail_3.setRotationPoint(0.0F, 0.5F, 13.0F);
        this.tail_3.addBox(-2.5F, -2.0F, -1.0F, 5, 3, 21, 0.0F);
        this.shape7_1 = new ModelRenderer(this, 96, 31);
        this.shape7_1.setRotationPoint(-4.0F, 1.5F, -8.0F);
        this.shape7_1.addBox(0.0F, 0.0F, -7.0F, 8, 1, 7, 0.0F);
        this.setRotateAngle(shape7_1, -0.091106186954104F, 0.0F, 0.0F);
        this.shape1 = new ModelRenderer(this, 0, 0);
        this.shape1.setRotationPoint(-6.0F, -3.0F, -15.0F);
        this.shape1.addBox(0.0F, 0.0F, 0.0F, 12, 10, 26, 0.0F);
        this.shape9_2 = new ModelRenderer(this, 56, 44);
        this.shape9_2.setRotationPoint(0.5F, 2.0F, -6.5F);
        this.shape9_2.addBox(0.0F, 0.0F, 0.0F, 1, 1, 1, 0.0F);
        this.shape16_1.addChild(this.shape18_1);
        this.shape9.addChild(this.shape9_1_1);
        this.shape15.addChild(this.shape16);
        this.shape16.addChild(this.shape18);
        this.shape9_1.addChild(this.shape9_1_2);
        this.head.addChild(this.shape7);
        this.shape9_1_2.addChild(this.shape9_2_1);
        this.shape15.addChild(this.shape15_2);
        this.shape15_1.addChild(this.shape16_1);
        this.tail_1.addChild(this.tail_2);
        this.shape15_1.addChild(this.shape15_3);
        this.tail_2.addChild(this.tail_3);
        this.head.addChild(this.shape7_1);
        this.shape9_1_1.addChild(this.shape9_2);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
        this.shape15.render(f5);
        this.shape9_1.render(f5);
        this.shape28.render(f5);
        this.tail_1.render(f5);
        this.shape9.render(f5);
        this.head.render(f5);
        this.shape28_3.render(f5);
        this.shape28_1.render(f5);
        this.shape15_1.render(f5);
        this.shape3.render(f5);
        this.shape28_2.render(f5);
        this.shape1.render(f5);
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
		this.tail_1.rotateAngleY = MathHelper.cos(ageInTicks * 20f / (limbSwing + 0.1f)) * (limbSwingAmount + 0.1F) / 3F;
		this.tail_2.rotateAngleY = MathHelper.cos(ageInTicks * 20f / (limbSwing + 0.1f)) * (limbSwingAmount + 0.15F) / 3F;
		this.tail_3.rotateAngleY = MathHelper.cos(ageInTicks * 20f / (limbSwing + 0.1f)) * (limbSwingAmount + 0.1F) / 3F;
    	this.head.rotateAngleY = netHeadYaw * 0.017453292F;
    	this.head.rotateAngleX = headPitch * 0.017453292F;   
    	this.shape15.rotateAngleX = MathHelper.cos(limbSwing * 0.6662f + (float)Math.PI) * 1.4f * limbSwingAmount / 2 -0.5742133239061343F ;
    	this.shape15_1.rotateAngleX = MathHelper.cos(limbSwing * 0.6662f) * 1.4f * limbSwingAmount / 2 -0.5742133239061343F; 
    	
		super.setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scaleFactor, entityIn);
	}
}
