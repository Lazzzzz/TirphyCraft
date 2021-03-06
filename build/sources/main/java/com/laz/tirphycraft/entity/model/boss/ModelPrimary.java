package com.laz.tirphycraft.entity.model.boss;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

/**
 * modelPrimary - LaZz_ Created using Tabula 7.0.1
 */
public class ModelPrimary extends ModelBase {
	public ModelRenderer shape1;
	public ModelRenderer shape2;
	public ModelRenderer shape3;
	public ModelRenderer shape4;
	public ModelRenderer shape5;
	public ModelRenderer shape7;
	public ModelRenderer shape9;
	public ModelRenderer shape10;
	public ModelRenderer shape13;
	public ModelRenderer shape15;
	public ModelRenderer head;
	public ModelRenderer shape23;
	public ModelRenderer shape17;
	public ModelRenderer shape18;
	public ModelRenderer shape6;
	public ModelRenderer shape8;
	public ModelRenderer shape11;
	public ModelRenderer shape12;
	public ModelRenderer shape14;
	public ModelRenderer shape16;
	public ModelRenderer shape28;
	public ModelRenderer shape29;
	public ModelRenderer shape24;
	public ModelRenderer shape25;
	public ModelRenderer shape26;
	public ModelRenderer shape27;

	public ModelPrimary() {
        this.textureWidth = 128;
        this.textureHeight = 128;
        this.shape24 = new ModelRenderer(this, 40, 115);
        this.shape24.setRotationPoint(-2.0F, 2.0F, 3.0F);
        this.shape24.addBox(-1.0F, -1.0F, -6.0F, 2, 2, 6, 0.0F);
        this.setRotateAngle(shape24, 0.7853981633974483F, 0.0F, 0.7853981633974483F);
        this.shape1 = new ModelRenderer(this, 0, 0);
        this.shape1.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.shape1.addBox(-8.0F, -8.0F, -8.0F, 16, 16, 16, 0.0F);
        this.setRotateAngle(shape1, 0.0F, 0.0F, 0.7853981633974483F);
        this.shape18 = new ModelRenderer(this, 86, 10);
        this.shape18.setRotationPoint(-13.0F, 1.0F, 1.0F);
        this.shape18.addBox(-14.0F, 0.0F, 0.0F, 14, 2, 2, 0.0F);
        this.setRotateAngle(shape18, 0.0F, 0.0F, -1.2217304763960306F);
        this.shape15 = new ModelRenderer(this, 96, 51);
        this.shape15.setRotationPoint(0.0F, -2.0F, 3.0F);
        this.shape15.addBox(0.0F, 0.0F, 0.0F, 4, 4, 8, 0.0F);
        this.setRotateAngle(shape15, 0.4363323129985824F, 0.3490658503988659F, 0.0F);
        this.shape8 = new ModelRenderer(this, 34, 73);
        this.shape8.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.shape8.addBox(-3.0F, 0.0F, -3.0F, 5, 16, 5, 0.0F);
        this.shape2 = new ModelRenderer(this, 0, 32);
        this.shape2.setRotationPoint(-8.0F, -15.0F, -6.0F);
        this.shape2.addBox(0.0F, 0.0F, 0.0F, 16, 12, 12, 0.0F);
        this.shape16 = new ModelRenderer(this, 96, 65);
        this.shape16.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.shape16.addBox(1.0F, 1.0F, 8.0F, 2, 2, 8, 0.0F);
        this.shape27 = new ModelRenderer(this, 40, 115);
        this.shape27.setRotationPoint(2.0F, 2.0F, 3.0F);
        this.shape27.addBox(-1.0F, -1.0F, -6.0F, 2, 2, 6, 0.0F);
        this.setRotateAngle(shape27, 0.7853981633974483F, 0.0F, -0.7853981633974483F);
        this.shape7 = new ModelRenderer(this, 34, 58);
        this.shape7.setRotationPoint(-17.0F, -10.0F, 0.0F);
        this.shape7.addBox(-4.0F, -2.5F, -4.0F, 8, 6, 8, 0.0F);
        this.shape17 = new ModelRenderer(this, 50, 10);
        this.shape17.setRotationPoint(13.0F, 1.0F, 1.0F);
        this.shape17.addBox(0.0F, 0.0F, 0.0F, 14, 2, 2, 0.0F);
        this.setRotateAngle(shape17, 0.0F, 0.0F, 1.2217304763960306F);
        this.shape10 = new ModelRenderer(this, 96, 20);
        this.shape10.setRotationPoint(-2.0F, -12.0F, 3.0F);
        this.shape10.addBox(-4.0F, 0.0F, 0.0F, 4, 4, 8, 0.0F);
        this.setRotateAngle(shape10, 0.6981317007977318F, -0.3490658503988659F, 0.0F);
        this.shape26 = new ModelRenderer(this, 40, 115);
        this.shape26.setRotationPoint(2.0F, -2.0F, 3.0F);
        this.shape26.addBox(-1.0F, -1.0F, -6.0F, 2, 2, 6, 0.0F);
        this.setRotateAngle(shape26, -0.7853981633974483F, 0.0F, 0.7853981633974483F);
        this.shape4 = new ModelRenderer(this, 86, 0);
        this.shape4.setRotationPoint(-5.0F, -12.0F, -2.0F);
        this.shape4.addBox(-13.0F, 0.0F, 0.0F, 13, 4, 4, 0.0F);
        this.setRotateAngle(shape4, 0.0F, -0.5235987755982988F, 0.7853981633974483F);
        this.shape13 = new ModelRenderer(this, 68, 51);
        this.shape13.setRotationPoint(0.0F, -2.0F, 3.0F);
        this.shape13.addBox(-4.0F, 0.0F, 0.0F, 4, 4, 8, 0.0F);
        this.setRotateAngle(shape13, 0.4363323129985824F, -0.3490658503988659F, 0.0F);
        this.shape6 = new ModelRenderer(this, 0, 73);
        this.shape6.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.shape6.addBox(-3.0F, 0.0F, -3.0F, 5, 16, 5, 0.0F);
        this.shape3 = new ModelRenderer(this, 50, 0);
        this.shape3.setRotationPoint(5.0F, -12.0F, -2.0F);
        this.shape3.addBox(0.0F, 0.0F, 0.0F, 13, 4, 4, 0.0F);
        this.setRotateAngle(shape3, 0.0F, 0.5235987755982988F, -0.7853981633974483F);
        this.shape23 = new ModelRenderer(this, 13, 115);
        this.shape23.setRotationPoint(0.0F, 0.0F, -10.0F);
        this.shape23.addBox(-3.0F, -3.0F, 0.0F, 6, 6, 2, 0.0F);
        this.shape5 = new ModelRenderer(this, 0, 58);
        this.shape5.setRotationPoint(16.0F, -10.0F, 0.0F);
        this.shape5.addBox(-4.0F, -2.5F, -4.0F, 8, 6, 8, 0.0F);
        this.shape14 = new ModelRenderer(this, 68, 65);
        this.shape14.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.shape14.addBox(-3.0F, 1.0F, 8.0F, 2, 2, 8, 0.0F);
        this.shape9 = new ModelRenderer(this, 68, 20);
        this.shape9.setRotationPoint(2.0F, -12.0F, 3.0F);
        this.shape9.addBox(0.0F, 0.0F, 0.0F, 4, 4, 8, 0.0F);
        this.setRotateAngle(shape9, 0.6981317007977318F, 0.3490658503988659F, 0.0F);
        this.shape25 = new ModelRenderer(this, 40, 115);
        this.shape25.setRotationPoint(-2.0F, -2.0F, 3.0F);
        this.shape25.addBox(-1.0F, -1.0F, -6.0F, 2, 2, 6, 0.0F);
        this.setRotateAngle(shape25, -0.7853981633974483F, 0.0F, -0.7853981633974483F);
        this.shape11 = new ModelRenderer(this, 64, 33);
        this.shape11.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.shape11.addBox(1.0F, 1.0F, 8.0F, 2, 2, 12, 0.0F);
        this.shape29 = new ModelRenderer(this, 0, 115);
        this.shape29.setRotationPoint(0.0F, -6.0F, 3.0F);
        this.shape29.addBox(-2.0F, -11.0F, 0.0F, 2, 11, 2, 0.0F);
        this.setRotateAngle(shape29, 0.3490658503988659F, 0.0F, -0.7853981633974483F);
        this.head = new ModelRenderer(this, 1, 97);
        this.head.setRotationPoint(0.0F, -16.0F, -4.0F);
        this.head.addBox(-4.0F, -8.0F, 0.0F, 8, 8, 8, 0.0F);
        this.shape12 = new ModelRenderer(this, 94, 33);
        this.shape12.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.shape12.addBox(-3.0F, 1.0F, 8.0F, 2, 2, 12, 0.0F);
        this.shape28 = new ModelRenderer(this, 0, 115);
        this.shape28.setRotationPoint(0.0F, -6.0F, 3.0F);
        this.shape28.addBox(0.0F, -11.0F, 0.0F, 2, 11, 2, 0.0F);
        this.setRotateAngle(shape28, 0.3490658503988659F, 0.0F, 0.7853981633974483F);
        this.shape23.addChild(this.shape24);
        this.shape4.addChild(this.shape18);
        this.shape7.addChild(this.shape8);
        this.shape15.addChild(this.shape16);
        this.shape23.addChild(this.shape27);
        this.shape3.addChild(this.shape17);
        this.shape23.addChild(this.shape26);
        this.shape5.addChild(this.shape6);
        this.shape13.addChild(this.shape14);
        this.shape23.addChild(this.shape25);
        this.shape9.addChild(this.shape11);
        this.head.addChild(this.shape29);
        this.shape10.addChild(this.shape12);
        this.head.addChild(this.shape28);
    }

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		this.shape1.render(f5);
		this.shape15.render(f5);
		this.shape2.render(f5);
		this.shape7.render(f5);
		this.shape10.render(f5);
		this.shape4.render(f5);
		this.shape13.render(f5);
		this.shape3.render(f5);
		this.shape23.render(f5);
		this.shape5.render(f5);
		this.shape9.render(f5);
		this.head.render(f5);
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

		this.shape23.rotateAngleZ += MathHelper.cos(0.6662f) * 0.08f;
		
    	this.shape5.rotateAngleX = MathHelper.cos(limbSwing * 0.6662f + (float)Math.PI) * 1.4f * limbSwingAmount /2;
    	this.shape7.rotateAngleX = MathHelper.cos(limbSwing * 0.6662f) * 1.4f * limbSwingAmount /2;
   	
		
		super.setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scaleFactor, entityIn);
	}
}
