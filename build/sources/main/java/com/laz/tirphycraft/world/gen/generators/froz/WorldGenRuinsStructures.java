package com.laz.tirphycraft.world.gen.generators.froz;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import com.laz.tirphycraft.init.BlockInit;
import com.laz.tirphycraft.world.biomes.laputa.BiomeLaputaCrystal;
import com.laz.tirphycraft.world.biomes.laputa.BiomeLaputaForest;
import com.laz.tirphycraft.world.biomes.laputa.BiomeLaputaNoManLand;
import com.laz.tirphycraft.world.biomes.noxis.BiomeBigForestNoxis;
import com.laz.tirphycraft.world.biomes.noxis.BiomeForestNoxis;
import com.laz.tirphycraft.world.biomes.noxis.BiomeHillsNoxis;
import com.laz.tirphycraft.world.biomes.noxis.BiomeLacNoxis;
import com.laz.tirphycraft.world.gen.generators.structures.laputa.WorldGenDungeonGroundTier2;
import com.laz.tirphycraft.world.gen.generators.structures.laputa.WorldGenLaputaBossRoom;
import com.laz.tirphycraft.world.gen.generators.structures.noxis.WorldGenNoxisBasicHouse;
import com.laz.tirphycraft.world.gen.generators.structures.tower.WorldGenBattleTower;
import com.laz.tirphycraft.world.gen.generators.structures.vanilla.WorldGenDungeonDesert;
import com.laz.tirphycraft.world.gen.generators.structures.vanilla.WorldGenDungeonOcean;
import com.laz.tirphycraft.world.gen.generators.structures.vanilla.WorldGenDungeonTier1;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeDesert;
import net.minecraft.world.biome.BiomeOcean;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.fml.common.IWorldGenerator;

public class WorldGenRuinsStructures implements IWorldGenerator {

	public static final GenFrozRuinsTemplate RUIN_01 = new GenFrozRuinsTemplate("ruin_01");

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator,
			IChunkProvider chunkProvider) {
		switch (world.provider.getDimension()) {
		case 123:
			generateStructure(RUIN_01, world, random, chunkX, chunkZ, 60);
			break;

		}
	}

	private void generateStructure(WorldGenerator generator, World world, Random random, int chunkX, int chunkZ,
			int chance) {

		int x = (chunkX * 16) + random.nextInt(15);
		int z = (chunkZ * 16) + random.nextInt(15);
		int y = calculateGenerationHeight(world, x, z, Blocks.GRASS);
		BlockPos pos = new BlockPos(x, y, z);

		Class<?> biome = world.provider.getBiomeForCoords(pos).getClass();

		if (random.nextInt(chance) == 0) {
			if (y < 210 && y > 10) {
				generator.generate(world, random, pos);

			}
		}
	}

	private static int calculateGenerationHeight(World world, int x, int z, Block topBlock) {
		int y = world.getHeight();
		boolean foundGround = false;

		while (!foundGround && y-- >= 0) {
			Block block = world.getBlockState(new BlockPos(x, y, z)).getBlock();
			foundGround = block == topBlock;
		}

		return y + 1;
	}
}
