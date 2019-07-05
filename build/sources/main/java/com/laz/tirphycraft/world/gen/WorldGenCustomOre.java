package com.laz.tirphycraft.world.gen;

import java.util.Random;

import com.laz.tirphycraft.init.BlockInit;
import com.laz.tirphycraft.objects.base.BlockOre;
import com.laz.tirphycraft.util.handlers.EnumHandler;

import net.minecraft.block.state.pattern.BlockMatcher;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.fml.common.IWorldGenerator;

public class WorldGenCustomOre implements IWorldGenerator {

	private WorldGenerator ore_laputa_purodes, ore_overworld_purodes, ore_noxis_purodes, ore_overworld_crystal,
			ore_noxis_crystal, ore_laputa_crystal, ore_laputa_tenium, ore_overworld_coal_on_coke,
			ore_noxis_coal_on_coke, ore_laputa_coal_on_coke, histoire_ice;

	public WorldGenCustomOre() {
		ore_overworld_purodes = new WorldGenMinable(
				BlockInit.ORE_OVERWORLD.getDefaultState().withProperty(BlockOre.VARIANT, EnumHandler.EnumType.PURODES),
				5, BlockMatcher.forBlock(Blocks.STONE));
		ore_noxis_purodes = new WorldGenMinable(
				BlockInit.ORE_NOXIS.getDefaultState().withProperty(BlockOre.VARIANT, EnumHandler.EnumType.PURODES), 5,
				BlockMatcher.forBlock(BlockInit.NOXIS_STONE));
		ore_laputa_purodes = new WorldGenMinable(
				BlockInit.ORE_LAPUTA.getDefaultState().withProperty(BlockOre.VARIANT, EnumHandler.EnumType.PURODES), 5,
				BlockMatcher.forBlock(BlockInit.LAPUTA_STONE));

		ore_overworld_coal_on_coke = new WorldGenMinable(BlockInit.ORE_OVERWORLD.getDefaultState().withProperty(
				BlockOre.VARIANT, EnumHandler.EnumType.COALONCOKE), 15, BlockMatcher.forBlock(Blocks.STONE));
		ore_noxis_coal_on_coke = new WorldGenMinable(
				BlockInit.ORE_NOXIS.getDefaultState().withProperty(BlockOre.VARIANT, EnumHandler.EnumType.COALONCOKE),
				15, BlockMatcher.forBlock(BlockInit.NOXIS_STONE));
		ore_laputa_coal_on_coke = new WorldGenMinable(
				BlockInit.ORE_LAPUTA.getDefaultState().withProperty(BlockOre.VARIANT, EnumHandler.EnumType.COALONCOKE),
				15, BlockMatcher.forBlock(BlockInit.LAPUTA_STONE));

		ore_overworld_crystal = new WorldGenMinable(
				BlockInit.ORE_OVERWORLD.getDefaultState().withProperty(BlockOre.VARIANT, EnumHandler.EnumType.CRYSTAL),
				10, BlockMatcher.forBlock(Blocks.STONE));
		ore_noxis_crystal = new WorldGenMinable(
				BlockInit.ORE_NOXIS.getDefaultState().withProperty(BlockOre.VARIANT, EnumHandler.EnumType.CRYSTAL), 10,
				BlockMatcher.forBlock(BlockInit.NOXIS_STONE));
		ore_laputa_crystal = new WorldGenMinable(
				BlockInit.ORE_LAPUTA.getDefaultState().withProperty(BlockOre.VARIANT, EnumHandler.EnumType.CRYSTAL), 10,
				BlockMatcher.forBlock(BlockInit.LAPUTA_STONE));

		ore_laputa_tenium = new WorldGenMinable(
				BlockInit.ORE_LAPUTA.getDefaultState().withProperty(BlockOre.VARIANT, EnumHandler.EnumType.TENIUM), 3,
				BlockMatcher.forBlock(BlockInit.LAPUTA_STONE));
		
		histoire_ice = new WorldGenMinable(BlockInit.HISOIRE_ICE.getDefaultState(), 4, BlockMatcher.forBlock(BlockInit.FROZ_STONE));
	}

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator,
			IChunkProvider chunkProvider) {

		switch (world.provider.getDimension()) {
		case 0:
			runGenerator(ore_overworld_purodes, world, random, chunkX, chunkZ, 10, 10, 40);
			runGenerator(ore_overworld_crystal, world, random, chunkX, chunkZ, 10, 10, 256);

		case 120:
			runGenerator(ore_noxis_purodes, world, random, chunkX, chunkZ, 20, 10, 80);
			runGenerator(ore_noxis_crystal, world, random, chunkX, chunkZ, 20, 10, 256);
			runGenerator(ore_noxis_coal_on_coke, world, random, chunkX, chunkZ, 20, 10, 256);

		case 121:
			runGenerator(ore_laputa_purodes, world, random, chunkX, chunkZ, 40, 10, 80);
			runGenerator(ore_laputa_crystal, world, random, chunkX, chunkZ, 40, 10, 256);
			runGenerator(ore_laputa_tenium, world, random, chunkX, chunkZ, 20, 0, 250);
			runGenerator(ore_laputa_coal_on_coke, world, random, chunkX, chunkZ, 40, 10, 256);
		
		case 123:
			runGenerator(histoire_ice, world, random, chunkX, chunkZ, 20, 70, 256);
		}

	}

	private void runGenerator(WorldGenerator gen, World world, Random rand, int chunkX, int chunkZ, int chance,
			int minHeight, int maxHeight) {

		if (minHeight > maxHeight || minHeight < 0 || maxHeight > 256)
			throw new IllegalArgumentException("Ore generate out of bound");

		int heightDiff = maxHeight - minHeight + 1;
		for (int i = 0; i < chance; i++) {
			int x = chunkX * 16 + rand.nextInt(16);
			int y = minHeight + rand.nextInt(heightDiff);
			int z = chunkZ * 16 + rand.nextInt(16);

			gen.generate(world, rand, new BlockPos(x, y, z));
		}

	}

}
