package com.laz.tirphycraft.world.gen;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import com.laz.tirphycraft.init.BlockInit;
import com.laz.tirphycraft.world.biomes.laputa.BiomeLaputaNoManLand;
import com.laz.tirphycraft.world.biomes.noxis.BiomeBigForestNoxis;
import com.laz.tirphycraft.world.biomes.noxis.BiomeForestNoxis;
import com.laz.tirphycraft.world.biomes.noxis.BiomeFrozenNoxis;
import com.laz.tirphycraft.world.biomes.noxis.BiomeHillsNoxis;
import com.laz.tirphycraft.world.biomes.noxis.BiomeLacNoxis;
import com.laz.tirphycraft.world.gen.generators.structures.laputa.WorldGenDungeonGroundTier2;
import com.laz.tirphycraft.world.gen.generators.structures.noxis.WorldGenNoxisBasicHouse;
import com.laz.tirphycraft.world.gen.generators.structures.portal.WorldGenPortalFroz;
import com.laz.tirphycraft.world.gen.generators.structures.portal.WorldGenPortalLaputa;
import com.laz.tirphycraft.world.gen.generators.structures.tower.WorldGenBattleTower;
import com.laz.tirphycraft.world.gen.generators.structures.vanilla.WorldGenDungeonDesert;
import com.laz.tirphycraft.world.gen.generators.structures.vanilla.WorldGenDungeonTier1;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeDesert;
import net.minecraft.world.biome.BiomeOcean;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.fml.common.IWorldGenerator;

public class WorldGenCustomStructures implements IWorldGenerator {

	public static final WorldGenDungeonDesert DESERT = new WorldGenDungeonDesert("desert_dungeon");

	public static final WorldGenDungeonTier1 ALTAR = new WorldGenDungeonTier1("altar");
	public static final WorldGenDungeonTier1 ISLAND_CRYSTAL = new WorldGenDungeonTier1("island_crystal");
	public static final WorldGenNoxisBasicHouse N_B_H_1 = new WorldGenNoxisBasicHouse("small_house_noxis_1");

	public static final WorldGenDungeonGroundTier2 HOUSE_1 = new WorldGenDungeonGroundTier2("laputa_house_1_0");

	public static final WorldGenBattleTower TOWER = new WorldGenBattleTower();

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator,
			IChunkProvider chunkProvider) {
		switch (world.provider.getDimension()) {
		case 121:
			generateStructure(HOUSE_1, world, random, chunkX, chunkZ, 5, 0, BlockInit.LAPUTA_GRASS,
					BiomeLaputaNoManLand.class);
			break;
		case 120:
			int i = new Random().nextInt(50) + 50;
			generateStructure(ISLAND_CRYSTAL, world, random, chunkX, chunkZ, 500, i, BlockInit.NOXIS_GRASS,
					BiomeForestNoxis.class, BiomeHillsNoxis.class, BiomeLacNoxis.class);
			generateStructure(N_B_H_1, world, random, chunkX, chunkZ, 10, 0, BlockInit.NOXIS_GRASS,
					BiomeForestNoxis.class, BiomeHillsNoxis.class, BiomeLacNoxis.class);

			generateStructure(TOWER, world, random, chunkX, chunkZ, 100, 0, BlockInit.NOXIS_GRASS,
					BiomeForestNoxis.class, BiomeLacNoxis.class, BiomeBigForestNoxis.class);
			break;
		case 1:
			break;
		case 0:
			generateStructure(ALTAR, world, random, chunkX, chunkZ, 2000, 100, Blocks.WATER, BiomeOcean.class);
			generateStructure(DESERT, world, random, chunkX, chunkZ, 5, -17, Blocks.SAND, BiomeDesert.class);
			break;
		case -1:

		}
	}

	private void generateStructure(WorldGenerator generator, World world, Random random, int chunkX, int chunkZ,
			int chance, int offset, Block topBlock, Class<?>... classes) {
		ArrayList<Class<?>> classesList = new ArrayList<Class<?>>(Arrays.asList(classes));

		int x = (chunkX * 16) + random.nextInt(15);
		int z = (chunkZ * 16) + random.nextInt(15);
		int y = calculateGenerationHeight(world, x, z, topBlock) + offset;
		BlockPos pos = new BlockPos(x, y, z);

		Class<?> biome = world.provider.getBiomeForCoords(pos).getClass();

		if (classesList.contains(biome)) {
			if (random.nextInt(chance) == 0) {
				if (y < 210 && y > 10) {
					generator.generate(world, random, pos);
				}
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

		return y;
	}
}
