package com.laz.tirphycraft.dimension.Laputa;

import com.laz.tirphycraft.dimension.chunk.LaputaTemplate;
import com.laz.tirphycraft.init.DimensionInit;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.DimensionType;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.gen.IChunkGenerator;

public class DimensionLibraryLaputa extends WorldProvider {
    
	public int posX[];
	public int posY[];
	
	@Override
	public void init() {
		this.hasSkyLight = true;
		this.biomeProvider = new BiomeProviderLaputa(this.world.getSeed());
		this.posX = new int [5];
		this.posY = new int [5];
	}

	public DimensionType getDimensionType() {
		return DimensionInit.LAPUTA;
	}


	@Override
	public IChunkGenerator createChunkGenerator() {
		LaputaTemplate chunk = new LaputaTemplate(this.world, this.world.getSeed());
		this.posX = chunk.getTowerPosX();
		this.posY = chunk.getTowerPosY();
		return chunk;
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
