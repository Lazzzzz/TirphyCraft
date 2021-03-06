package com.laz.tirphycraft.world.biomes.noxis;

import java.util.Random;

import com.laz.tirphycraft.init.BlockInit;
import com.laz.tirphycraft.world.gen.generators.noxis.WorldGenNoxisLakes;
import com.laz.tirphycraft.world.gen.generators.trees.laputa.WorldGenStem;

import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.Chunk;

public class BiomeNoxis extends Biome {

	private genNoxisGround GROUND = new genNoxisGround();
	public static WorldGenStem TREE = new WorldGenStem(BlockInit.LOG_MYSTICAL.getDefaultState(), 3);
	public genNoxisTower TOWER = new genNoxisTower();
	
	public BiomeNoxis() {

		super(new BiomeProperties("Noxis").setBaseHeight(0.5F).setHeightVariation(.4F).setTemperature(0.2F)
				.setRainfall(0.0F).setRainDisabled().setWaterColor(1909616));

		this.decorator.treesPerChunk = 4;
		this.modSpawnableLists.clear();
		this.spawnableMonsterList.clear();
		this.spawnableCaveCreatureList.clear();
		this.spawnableCreatureList.clear();
		this.spawnableWaterCreatureList.clear();
		

	}

	@Override
	public void decorate(World worldIn, Random rand, BlockPos pos) {
		Chunk chunk = worldIn.getChunkFromBlockCoords(pos);
		for (int i = 0; i < 16; i++) {
			for (int j = 0; j < 16; j++) {
				int x = chunk.x * 16 + i + 8;
				int z = chunk.z * 16 + j + 8;
				GROUND.generate(worldIn, rand, worldIn.getHeight(new BlockPos(x, 0, z)));
			}
		}
		
		if (chunk.x == -1 && chunk.z == -1) {
			TOWER.generator(worldIn, new BlockPos(chunk.x * 16, 60, chunk.z * 16));
		}

		if (rand.nextInt(6) == 0) {
			int j = rand.nextInt(16) + 8;
			int k = rand.nextInt(16) + 8;
			TREE.generate(worldIn, rand,
					worldIn.getHeight(pos.add(j, 0, k)));
		}
		
		if (rand.nextInt(4) == 0) {
			int j = rand.nextInt(16) + 8;
			int k = rand.nextInt(16) + 8;
			new WorldGenNoxisLakes(Blocks.LAVA).generate(worldIn, rand, worldIn.getHeight(pos.add(j, 0, k)));
		}

	}
}
