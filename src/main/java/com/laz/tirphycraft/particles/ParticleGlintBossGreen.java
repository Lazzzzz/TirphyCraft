package com.laz.tirphycraft.particles;

import com.laz.tirphycraft.util.Reference;

import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class ParticleGlintBossGreen extends Particle {

	private int i;
	private int i2;

	public ParticleGlintBossGreen(World world, double x, double y, double z, double f, double f1, double f2) {
		this(world, x, y, z, 1.0F, f, f1, f2);
	}

	public ParticleGlintBossGreen(World world, double x, double y, double z, float f, double f1, double f2, double f3) {
		super(world, x, y, z, 0.0D, 0.0D, 0.0D);
		motionX = f1;
		motionY = f2;
		motionZ = f3;
		particleRed = 1.0F;
		particleGreen = 1.0F;
		particleBlue = 1.0F;
		particleScale = 1.0f + (rand.nextFloat() * 0.6f) + (rand.nextFloat() * 0.6f);
		particleScale *= f;
		i = particleMaxAge = 10;
		particleMaxAge *= f;
		i2 = i / 2;
		canCollide = false;

		this.setParticleTexture(Minecraft.getMinecraft().getTextureMapBlocks()
				.getAtlasSprite(new ResourceLocation(Reference.MOD_ID, "particle/glint_green").toString()));
	}

	@Override
	public void renderParticle(BufferBuilder buffer, Entity entity, float partialTicks, float rotationX,
			float rotationZ, float rotationYZ, float rotationXY, float rotationXZ) {

		particleAlpha = getGlowBrightness();
		super.renderParticle(buffer, entity, partialTicks, rotationX, rotationZ, rotationYZ, rotationXY, rotationXZ);
	}

	@Override
	public void onUpdate() {
        this.prevPosX = this.posX;
        this.prevPosY = this.posY;
        this.prevPosZ = this.posZ;
		if (i <= 1) {
			setExpired();
		} else {
			this.posX += this.motionX;
			this.posY += this.motionY;
			this.posZ += this.motionZ;
			i--;
		}
	}

	public float getGlowBrightness() {
		if (i <= i2) {
			return (float) i / (float) i2;
		} else {
			return Math.max(1.0f - (((float) i - i2) / i2), 0);
		}
	}

	@Override
	public int getBrightnessForRender(float partialTicks) {
        int i = super.getBrightnessForRender(partialTicks);
        int j = 240;
        int k = i >> 16 & 255;
        return 240 | k << 16;
	}

	@Override
	public int getFXLayer() {
		return 1;
	}
}