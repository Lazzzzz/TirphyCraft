package com.laz.tirphycraft.world.biomes.noxis;

import java.util.Random;

import com.laz.tirphycraft.entity.aggressive.EntityPhorus;
import com.laz.tirphycraft.entity.aggressive.EntityTotam;
import com.laz.tirphycraft.entity.passif.EntityFrozenBoar;
import com.laz.tirphycraft.entity.passif.EntityFrozenBuffalo;
import com.laz.tirphycraft.entity.passif.EntityMontauk;
import com.laz.tirphycraft.init.BlockInit;
import com.laz.tirphycraft.world.gen.generators.deco.WorldGenNoxisSmoker;
import com.laz.tirphycraft.world.gen.generators.pick.WorldFrozenCrystal;
import com.laz.tirphycraft.world.gen.generators.structures.portal.WorldGenPortalFroz;
import com.laz.tirphycraft.world.gen.generators.structures.portal.WorldGenPortalLaputa;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;

public class BiomeFrozenNoxis extends Biome {

	public final WorldFrozenCrystal CRYSTAL_PICK = new WorldFrozenCrystal();
	public final WorldGenNoxisSmoker SMOKER = new WorldGenNoxisSmoker();

	public final WorldGenPortalFroz PORTAL_F = new WorldGenPortalFroz("portal_froz");

	public BiomeFrozenNoxis() {

		super(new BiomeProperties("Noxis ice").setBaseHeight(0.125F).setHeightVariation(0.25F).setRainfall(0.0F)
				.setRainDisabled().setWaterColor(1909616));

		topBlock = BlockInit.NOXIS_FROZEN_GRASS.getDefaultState();
		fillerBlock = BlockInit.NOXIS_FROZEN_DIRT.getDefaultState();

		this.spawnableMonsterList.clear();
		this.spawnableCreatureList.clear();
		this.spawnableWaterCreatureList.clear();

	}

	@Override
	public void decorate(World worldIn, Random rand, BlockPos pos) {
		int o = rand.nextInt(20);
		if (o == 1) this.PORTAL_F.generate(worldIn, rand, worldIn.getHeight(pos));

		o = rand.nextInt(5);

		if (o == 1) {
			int j = rand.nextInt(16) + 8;
			int k = rand.nextInt(16) + 8;
			this.SMOKER.generate(worldIn, rand, worldIn.getHeight(pos.add(j, 0, k)));
		}
		for (int i = 0; i < 1; ++i) {
			int j = rand.nextInt(16) + 8;
			int k = rand.nextInt(16) + 8;
			this.CRYSTAL_PICK.generate(worldIn, rand, worldIn.getHeight(pos.add(j, 0, k)));
		}

		super.decorate(worldIn, rand, pos);
	}

}
