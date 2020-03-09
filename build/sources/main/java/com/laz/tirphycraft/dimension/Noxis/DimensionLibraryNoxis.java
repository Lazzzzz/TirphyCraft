package com.laz.tirphycraft.dimension.Noxis;

import com.laz.tirphycraft.dimension.chunk.NoxisTemplate;
import com.laz.tirphycraft.init.DimensionInit;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.DimensionType;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraftforge.client.IRenderHandler;

public class DimensionLibraryNoxis extends WorldProvider {

	@Override
	public void init() {
		this.hasSkyLight = false;
		this.biomeProvider = new BiomeProviderNoxis(this.world.getSeed());
	}

	public DimensionType getDimensionType() {
		return DimensionInit.NOXIS;
	}

	@Override
	public float getCloudHeight() {
		return -100000;
	}

	@Override
	public IChunkGenerator createChunkGenerator() {
		return new NoxisTemplate(this.world, false, this.world.getSeed(), null);
	}

	@Override
	public WorldSleepResult canSleepAt(EntityPlayer player, BlockPos pos) {
		return WorldSleepResult.ALLOW;
	}

	@Override
	public boolean canRespawnHere() {
		return false;
	}

	@Override
	public Vec3d getSkyColor(Entity cameraEntity, float partialTicks) {
		return new Vec3d(0, 0, 0);
	}
	
	@Override
	public IRenderHandler getSkyRenderer() {
		return super.getSkyRenderer();
	}
	
}
