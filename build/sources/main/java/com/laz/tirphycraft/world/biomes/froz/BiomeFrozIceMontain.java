package com.laz.tirphycraft.world.biomes.froz;

import java.util.Random;

import com.laz.tirphycraft.world.biomes.froz.caveDecorator.BiomeFrozCaveDecorator;
import com.laz.tirphycraft.world.biomes.froz.groundDecorator.genFrozEternalGround;
import com.laz.tirphycraft.world.gen.generators.froz.WorldGenGiantPick;

import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.ChunkPrimer;

public class BiomeFrozIceMontain extends Biome {

	BiomeFrozCaveDecorator CAVE = new BiomeFrozCaveDecorator();
	
	public BiomeFrozIceMontain() {

		super(new BiomeProperties("Forz Ice Montain").setBaseHeight(1.0F).setHeightVariation(0.9F).setTemperature(-10F)
				.setRainfall(100F).setWaterColor(4092311));

		topBlock = Blocks.ICE.getDefaultState();
		fillerBlock = Blocks.PACKED_ICE.getDefaultState();

		this.decorator.treesPerChunk = 0;
		this.spawnableMonsterList.clear();
		this.spawnableCreatureList.clear();
		this.spawnableWaterCreatureList.clear();
		this.spawnableCaveCreatureList.clear();

	}

	@Override
	public int getGrassColorAtPos(BlockPos pos) {
		return 2908825;
	}
 
	
	@Override
	public void decorate(World worldIn, Random rand, BlockPos pos) {
		
		Chunk chunk = worldIn.getChunkFromBlockCoords(pos);
		for (int i = 0; i < 16; i++) {
			for (int j = 0; j < 16; j++) {
				int x = chunk.x * 16 + i + 8;
				int z = chunk.z * 16 + j + 8;
				new genFrozEternalGround().generate(worldIn, rand, worldIn.getHeight(new BlockPos(x, 0, z)));
				CAVE.genDecorator(worldIn, rand, new BlockPos(x, 0, z));
			}
		}
		
		if (rand.nextInt(7) == 0) {
			int j = rand.nextInt(16) + 16;
			int k = rand.nextInt(16) + 16;
			new WorldGenGiantPick(rand.nextInt(20) + 10).generate(worldIn, rand, worldIn.getHeight(pos.add(j, 0, k)));
		}
	}

    public void genTerrainBlocks(World worldIn, Random rand, ChunkPrimer chunkPrimerIn, int x, int z, double noiseVal)
    {
		topBlock = Blocks.ICE.getDefaultState();
		fillerBlock = Blocks.PACKED_ICE.getDefaultState();

        if ((noiseVal < -1.0D || noiseVal > 2.0D))
        {
            this.topBlock = Blocks.GRASS.getDefaultState();
            this.fillerBlock = Blocks.DIRT.getDefaultState();
        }
        else if (noiseVal > 1.0D)
        {
            this.topBlock = Blocks.GRASS.getDefaultState();
            this.fillerBlock = Blocks.DIRT.getDefaultState();
        }

        this.generateBiomeTerrain(worldIn, rand, chunkPrimerIn, x, z, noiseVal);
    }
	

}
