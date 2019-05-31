package com.laz.tirphycraft.world.dimensionFroz;

import com.laz.tirphycraft.init.DimensionInit;
import com.laz.tirphycraft.world.chunk.FrozTemplate;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.DimensionType;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.gen.IChunkGenerator;

public class DimensionLibraryFroz extends WorldProvider {

	@Override
	public void init() {
		this.hasSkyLight = true;
		this.biomeProvider = new BiomeProviderFroz(this.world.getSeed());
	}

	public DimensionType getDimensionType() {
		return DimensionInit.FROZ;
	}

	@Override
	public IChunkGenerator createChunkGenerator() {
		return new FrozTemplate(this.world, this.world.getSeed());
	}

	@Override
	public WorldSleepResult canSleepAt(EntityPlayer player, BlockPos pos) {
		return WorldSleepResult.ALLOW;
	}

	@Override
	public boolean canRespawnHere() {
		return false;
	}
	
    public boolean isSurfaceWorld()
    {
    	return true;
    }

    
    
    
}
