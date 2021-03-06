package com.laz.tirphycraft.proxy;

import com.laz.tirphycraft.particles.ParticleGlintBlue;
import com.laz.tirphycraft.particles.ParticleGlintBossGreen;
import com.laz.tirphycraft.particles.ParticleGlintBossPurple;
import com.laz.tirphycraft.particles.ParticleGlintGreen;
import com.laz.tirphycraft.particles.ParticleGlintPink;
import com.laz.tirphycraft.particles.ParticleGlintPurple;
import com.laz.tirphycraft.particles.ParticleGlintWhite;
import com.laz.tirphycraft.particles.ParticleGlintYellow;
import com.laz.tirphycraft.particles.ParticleLeaf;
import com.laz.tirphycraft.util.Reference;
import com.laz.tirphycraft.util.interfaces.ParticleTypes;

import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.client.FMLClientHandler;

public class ClientProxy extends CommonProxy {

	@Override
	public void registerItemRenderer(Item item, int meta, String id) {

		ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(item.getRegistryName(), id));
	}

	@Override
	public void registerVariantRenderer(Item item, int meta, String filename, String id) {
		ModelLoader.setCustomModelResourceLocation(item, meta,
				new ModelResourceLocation(new ResourceLocation(Reference.MOD_ID, filename), id));
	}

	public World getClientWorld() {
		return FMLClientHandler.instance().getClient().world;
	}

	@SuppressWarnings("incomplete-switch")
	@Override
	public void spawnParticle(World world, ParticleTypes particleType, double x, double y, double z, double velX,
			double velY, double velZ) {
		Minecraft mc = Minecraft.getMinecraft();
		Entity entity = mc.getRenderViewEntity();

		// ignore the passed-in world, since on SP we get the integrated server world,
		// which is not really what we want
		world = this.getClientWorld();

		if (entity != null && mc.effectRenderer != null) {
			int i = mc.gameSettings.particleSetting;

			if (i == 1 && world.rand.nextInt(3) == 0) {
				i = 2;
			}

			double d0 = entity.posX - x;
			double d1 = entity.posY - y;
			double d2 = entity.posZ - z;

			if (d0 * d0 + d1 * d1 + d2 * d2 <= 1024D && i <= 1) {
				Particle particle = null;

				switch (particleType) {
				case GLINT_WHITE:
					particle = new ParticleGlintWhite(world, x, y, z, velX, velY, velZ);
					break;
				case GLINT_BLUE:
					particle = new ParticleGlintBlue(world, x, y, z, velX, velY, velZ);
					break;
				case GLINT_PINK:
					particle = new ParticleGlintPink(world, x, y, z, velX, velY, velZ);
					break;
				case GLINT_PURPLE:
					particle = new ParticleGlintPurple(world, x, y, z, velX, velY, velZ);
					break;
				case GLINT_GREEN:
					particle = new ParticleGlintGreen(world, x, y, z, velX, velY, velZ);
					break;
				case GLINT_YELLOW:
					particle = new ParticleGlintYellow(world, x, y, z, velX, velY, velZ);
					break;
				case GLINT_BOSS_GREEN:
					particle = new ParticleGlintBossGreen(world, x, y, z, velX, velY, velZ);
					break;
				case GLINT_BOSS_PURPLE:
					particle = new ParticleGlintBossPurple(world, x, y, z, velX, velY, velZ);
					break;
				}

				if (particle != null) {
					mc.effectRenderer.addEffect(particle);
				}
			}
		}
	}

	@SuppressWarnings("incomplete-switch")
	@Override
	public void spawnParticle(World world, ParticleTypes particleType, double x, double y, double z, double velX,
			double velY, double velZ, float colorR, float colorG, float colorB) {
		Minecraft mc = Minecraft.getMinecraft();
		Entity entity = mc.getRenderViewEntity();

		// ignore the passed-in world, since on SP we get the integrated server world,
		// which is not really what we want
		world = this.getClientWorld();

		if (entity != null && mc.effectRenderer != null) {
			int i = mc.gameSettings.particleSetting;

			if (i == 1 && world.rand.nextInt(3) == 0) {
				i = 2;
			}

			double d0 = entity.posX - x;
			double d1 = entity.posY - y;
			double d2 = entity.posZ - z;

			if (d0 * d0 + d1 * d1 + d2 * d2 <= 1024D && i <= 1) {
				Particle particle = null;

				switch (particleType) {
				case FALLING_LEAF:
					particle = new ParticleLeaf(world, x, y, z, velX, velY, velZ, colorR, colorG, colorB);
					break;
				}

				if (particle != null) {
					mc.effectRenderer.addEffect(particle);
				}
			}
		}
	}
	
}