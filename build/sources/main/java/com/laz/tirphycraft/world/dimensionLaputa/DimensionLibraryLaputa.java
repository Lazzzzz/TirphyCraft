package com.laz.tirphycraft.world.dimensionLaputa;

import com.laz.tirphycraft.init.DimensionInit;
import com.laz.tirphycraft.world.chunk.LaputaTemplate;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.DimensionType;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.gen.IChunkGenerator;

public class DimensionLibraryLaputa extends WorldProvider {
    
	@Override
	public void init() {
		this.hasSkyLight = true;
		this.biomeProvider = new BiomeProviderLaputa(this.world.getSeed());
	}

	public DimensionType getDimensionType() {
		return DimensionInit.LAPUTA;
	}


	@Override
	public IChunkGenerator createChunkGenerator() {
		return new LaputaTemplate(this.world, this.world.getSeed());
	}

	
	@Override
	public WorldSleepResult canSleepAt(EntityPlayer player, BlockPos pos) {
		return WorldSleepResult.ALLOW;
	}
	
	@Override
	public boolean canRespawnHere() {
		return false;
	}

}
