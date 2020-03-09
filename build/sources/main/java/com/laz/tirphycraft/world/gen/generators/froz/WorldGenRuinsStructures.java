package com.laz.tirphycraft.world.gen.generators.froz;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
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
