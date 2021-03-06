package com.laz.tirphycraft.world.biomes.laputa;

import java.util.Random;

import com.laz.tirphycraft.init.BlockInit;
import com.laz.tirphycraft.world.gen.generators.laputa.WorldBlackCrystal;
import com.laz.tirphycraft.world.gen.generators.laputa.WorldGenLaputaBigCloud;
import com.laz.tirphycraft.world.gen.generators.laputa.WorldGenLaputaFlower;
import com.laz.tirphycraft.world.gen.generators.laputa.WorldGenLaputaMagicPlant;
import com.laz.tirphycraft.world.gen.generators.laputa.WorldGenLaputaPlant;
import com.laz.tirphycraft.world.gen.generators.laputa.WorldGenLightPad;
import com.laz.tirphycraft.world.gen.generators.trees.laputa.WorldGenGeantTree;
import com.laz.tirphycraft.world.gen.generators.trees.laputa.WorldGenNormalTree;
import com.laz.tirphycraft.world.gen.generators.trees.laputa.WorldGenStem;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BiomeLaputaDecorator {

	public final WorldBlackCrystal CRYSTAL_PICK = new WorldBlackCrystal();
	public final WorldGenLightPad LIGHT_PAD = new WorldGenLightPad(3);
	public final WorldGenLaputaPlant LAPUTA_PLANT = new WorldGenLaputaPlant();
	public final WorldGenLaputaFlower LAPUTA_FLOWER = new WorldGenLaputaFlower();
	public final WorldGenGeantTree BIG_TREE = new WorldGenGeantTree();
	public final WorldGenNormalTree NORMAL_TREE = new WorldGenNormalTree();
	public final WorldGenLaputaMagicPlant MAGIC_PLANT = new WorldGenLaputaMagicPlant();
	WorldGenStem STEM = new WorldGenStem(BlockInit.STEM.getDefaultState(), 2);

	public void genDecorator(World worldIn, Random rand, BlockPos pos, int tree, int big_tree, int light_pad, int grass,
			int flower, int crystal, int magic, int stem) {

		genTree(worldIn, rand, pos, tree);
		genBigTree(worldIn, rand, pos, big_tree);
		genCrystalPick(worldIn, rand, pos, crystal);
		genLightPad(worldIn, rand, pos, light_pad);
		genGrass(worldIn, rand, pos, grass);
		genFlower(worldIn, rand, pos, flower);
		genMagic(worldIn, rand, pos, magic);
		genStem(worldIn, rand, pos, stem);
		//genCloud(worldIn, rand, pos);
	}

	public void genTree(World worldIn, Random rand, BlockPos pos, int tree) {
		int o;
		int j = rand.nextInt(16) + 8;
		int k = rand.nextInt(16) + 8;
		
		if (tree < 0) {
			for (int i = 0; i < -(tree); i++) {
				j = rand.nextInt(16) + 8;
				k = rand.nextInt(16) + 8;
				NORMAL_TREE.generate(worldIn, rand, worldIn.getHeight(pos.add(j, 0, k)));
			}

		} else if (tree != 0) {
			o = rand.nextInt(tree);
			if (o == 0)
				NORMAL_TREE.generate(worldIn, rand, worldIn.getHeight(pos.add(j, 0, k)));
		}
	}

	public void genBigTree(World worldIn, Random rand, BlockPos pos, int tree) {
		int o;
		int j = rand.nextInt(16) + 8;
		int k = rand.nextInt(16) + 8;

		if (tree < 0) {
			for (int i = 0; i < -(tree); i++) {
				j = rand.nextInt(16) + 8;
				k = rand.nextInt(16) + 8;
				BIG_TREE.generate(worldIn, rand, worldIn.getHeight(pos.add(j, 0, k)));
			}

		} else if (tree != 0) {
			o = rand.nextInt(tree);
			if (o == 0)
				BIG_TREE.generate(worldIn, rand, worldIn.getHeight(pos.add(j, 0, k)));
		}
	}

	public void genCrystalPick(World worldIn, Random rand, BlockPos pos, int pick) {
		int o;
		if (pick < 0) {
			for (int i = 0; i < -(pick); i++) {
				CRYSTAL_PICK.generate(worldIn, rand, worldIn.getHeight(pos.add(pos.getX(), 0, pos.getZ())));
			}

		} else if (pick != 0) {
			o = rand.nextInt(pick);
			if (o == 0)
				CRYSTAL_PICK.generate(worldIn, rand, worldIn.getHeight(pos.add(pos.getX(), 0, pos.getZ())));
		}
	}

	public void genLightPad(World worldIn, Random rand, BlockPos pos, int pad) {
		int o;
		int j = rand.nextInt(16) + 8;
		int k = rand.nextInt(16) + 8;
		if (pad < 0) {
			for (int i = 0; i < -(pad); i++) {
				j = rand.nextInt(16) + 8;
				k = rand.nextInt(16) + 8;
				LIGHT_PAD.generate(worldIn, rand, worldIn.getHeight(pos.add(j, 0, k)));
			}

		} else if (pad != 0) {
			o = rand.nextInt(pad);
			if (o == 0)
				LIGHT_PAD.generate(worldIn, rand, worldIn.getHeight(pos.add(j, 0, k)));
		}
	}

	public void genGrass(World worldIn, Random rand, BlockPos pos, int grass) {
		int o;
		int j = rand.nextInt(16) + 8;
		int k = rand.nextInt(16) + 8;

		if (grass < 0) {
			for (int i = 0; i < -(grass); i++) {
				j = rand.nextInt(16) + 8;
				k = rand.nextInt(16) + 8;

				LAPUTA_PLANT.generate(worldIn, rand, worldIn.getHeight(pos.add(j, 0, k)));
			}

		} else if (grass != 0) {
			o = rand.nextInt(grass);
			if (o == 0)
				LAPUTA_PLANT.generate(worldIn, rand, worldIn.getHeight(pos.add(j, 0, k)));
		}
	}

	public void genFlower(World worldIn, Random rand, BlockPos pos, int grass) {
		int o;
		int j = rand.nextInt(16) + 8;
		int k = rand.nextInt(16) + 8;
		if (grass < 0) {
			for (int i = 0; i < -(grass); i++) {
				j = rand.nextInt(16) + 8;
				k = rand.nextInt(16) + 8;
				LAPUTA_FLOWER.generate(worldIn, rand, worldIn.getHeight(pos.add(j, 0, k)));
			}

		} else if (grass != 0) {
			o = rand.nextInt(grass);
			if (o == 0)
				LAPUTA_FLOWER.generate(worldIn, rand, worldIn.getHeight(pos.add(j, 0, k)));
		}
	}

	public void genMagic(World worldIn, Random rand, BlockPos pos, int grass) {
		int o;
		int j = rand.nextInt(16) + 8;
		int k = rand.nextInt(16) + 8;
		
		if (grass < 0) {
			for (int i = 0; i < -(grass); i++) {
				j = rand.nextInt(16) + 8;
				k = rand.nextInt(16) + 8;
				MAGIC_PLANT.generate(worldIn, rand, worldIn.getHeight(pos.add(j, 0, k)));
			}

		} else if (grass != 0) {
			o = rand.nextInt(grass);
			if (o == 0)
				MAGIC_PLANT.generate(worldIn, rand, worldIn.getHeight(pos.add(j, 0, k)));
		}
	}
	
	public void genStem(World worldIn, Random rand, BlockPos pos, int tree) {
		int o;
		int j = rand.nextInt(16) + 8;
		int k = rand.nextInt(16) + 8;

		if (tree < 0) {
			for (int i = 0; i < -(tree); i++) {
				j = rand.nextInt(16) + 8;
				k = rand.nextInt(16) + 8;
				STEM.generate(worldIn, rand, worldIn.getHeight(pos.add(j, 0, k)));
			}

		} else if (tree != 0) {
			o = rand.nextInt(tree);
			if (o == 0)
				STEM.generate(worldIn, rand, worldIn.getHeight(pos.add(j, 0, k)));
		}
	}

	public void genCloud(World worldIn, Random rand, BlockPos pos) {
		
		int o = rand.nextInt(20);
		if (o == 0) {
			int j = rand.nextInt(16) + 8;
			int k = rand.nextInt(16) + 8;
			WorldGenLaputaBigCloud BIG_CLOUD = new WorldGenLaputaBigCloud();
			BIG_CLOUD.setAmount(8);
			BIG_CLOUD.generate(worldIn, rand, new BlockPos(pos.getX() + j, rand.nextInt(150) + 35, pos.getZ() + k));
		}
	}
}
