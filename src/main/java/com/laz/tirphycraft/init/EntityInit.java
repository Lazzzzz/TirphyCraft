package com.laz.tirphycraft.init;

import com.laz.tirphycraft.Main;
import com.laz.tirphycraft.entity.aggressive.EntityCerbere;
import com.laz.tirphycraft.entity.aggressive.EntityCloudy;
import com.laz.tirphycraft.entity.aggressive.EntityDeadPlayer;
import com.laz.tirphycraft.entity.aggressive.EntityDemon;
import com.laz.tirphycraft.entity.aggressive.EntityFailedGolem;
import com.laz.tirphycraft.entity.aggressive.EntityGiantSpider;
import com.laz.tirphycraft.entity.aggressive.EntityGiril;
import com.laz.tirphycraft.entity.aggressive.EntityGrindlyBoth;
import com.laz.tirphycraft.entity.aggressive.EntityGrindlyFront;
import com.laz.tirphycraft.entity.aggressive.EntityGrindlyUp;
import com.laz.tirphycraft.entity.aggressive.EntityGuardianGolem;
import com.laz.tirphycraft.entity.aggressive.EntityHeadLess;
import com.laz.tirphycraft.entity.aggressive.EntityMummy;
import com.laz.tirphycraft.entity.aggressive.EntityPhorus;
import com.laz.tirphycraft.entity.aggressive.EntitySkull;
import com.laz.tirphycraft.entity.aggressive.EntityTotam;
import com.laz.tirphycraft.entity.boss.EntityArtikon;
import com.laz.tirphycraft.entity.boss.EntityHellKing;
import com.laz.tirphycraft.entity.boss.EntityPharaoh;
import com.laz.tirphycraft.entity.boss.EntityPoseidon;
import com.laz.tirphycraft.entity.boss.EntityPrimaryAttack;
import com.laz.tirphycraft.entity.boss.EntityPrimaryHeal;
import com.laz.tirphycraft.entity.boss.EntityPrimaryStrength;
import com.laz.tirphycraft.entity.boss.EntityQueenCreeper;
import com.laz.tirphycraft.entity.neutral.EntityMothmoth;
import com.laz.tirphycraft.entity.passif.EntityBuffalo;
import com.laz.tirphycraft.entity.passif.EntityCrystim;
import com.laz.tirphycraft.entity.passif.EntityDragonFly;
import com.laz.tirphycraft.entity.passif.EntityFrozenBoar;
import com.laz.tirphycraft.entity.passif.EntityFrozenBuffalo;
import com.laz.tirphycraft.entity.passif.EntityKiwi;
import com.laz.tirphycraft.entity.passif.EntityLayTurtle;
import com.laz.tirphycraft.entity.passif.EntityMontauk;
import com.laz.tirphycraft.entity.passif.EntityToxisCow;
import com.laz.tirphycraft.entity.passif.EntityVidargavia;
import com.laz.tirphycraft.util.Reference;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.init.Biomes;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.EntityRegistry;

public class EntityInit {
	
	public static void registerEntitites() {
		
		//AUTRES
		registerEntity("vidargavia", EntityVidargavia.class, Reference.ENTITY_VIDARGAVIA, 50, 000000, 000000);
		registerEntity("guardian_golem", EntityGuardianGolem.class, Reference.ENTITY_GUARDIAN_GOLEM, 50, 000000, 000000);
		registerEntity("dragonfly", EntityDragonFly.class, Reference.ENTITY_DRAGON_FLY, 50, 000000, 000000);
	
		//MECHANT
		registerEntity("phorus", EntityPhorus.class, Reference.ENTITY_PHORUS, 50, 000000, 000000);			
		registerEntity("totam", EntityTotam.class, Reference.ENTITY_TOTAM, 50, 000000, 000000);	
		registerEntity("grindlyUp", EntityGrindlyUp.class, Reference.GRINDLY_UP, 50, 000000, 000000);	
		registerEntity("grindlyFront", EntityGrindlyFront.class, Reference.GRINDLY_FRONT, 50, 000000, 000000);	
		registerEntity("grindlyBoth", EntityGrindlyBoth.class, Reference.GRINDLY_BOTH, 50, 000000, 000000);
		registerEntity("cloudy", EntityCloudy.class, Reference.CLOUDY, 50, 000000, 000000);
		registerEntity("cerbere", EntityCerbere.class, Reference.CERBERE, 50, 000000, 000000);
		registerEntity("demon", EntityDemon.class, Reference.DEMON, 50, 000000, 000000);
		registerEntity("dead_Player", EntityDeadPlayer.class, Reference.DEAD_PLAYER, 50, 000000, 000000);
		registerEntity("mummy", EntityMummy.class, Reference.MUMMY, 50, 000000, 000000);
		registerEntity("giant_spider", EntityGiantSpider.class, Reference.GIANT_SPIDER, 50, 000000, 000000);
		registerEntity("failed_golem", EntityFailedGolem.class, Reference.FAILED_GOLEM, 50, 000000, 000000);
		registerEntity("head_less", EntityHeadLess.class, Reference.HEAD_LESS, 50, 000000, 000000);
		registerEntity("giril", EntityGiril.class, Reference.GIRIL, 50, 000000, 000000);
		registerEntity("skull", EntitySkull.class, Reference.SKULL, 50, 000000, 000000);
		
		//NEUTRAL
		registerEntity("mothmoth", EntityMothmoth.class, Reference.ENTITY_MOTHMOTH, 50, 3690832, 3690832);	
		
		//PASSIF
		registerEntity("montauk", EntityMontauk.class, Reference.ENTITY_MONTAUK, 50, 16777215, 16777215);		
		registerEntity("frozen_buffalo", EntityFrozenBuffalo.class, Reference.ENTITY_FROZEN_BUFFALO, 50, 16777215, 16777215);			
		registerEntity("frozen_boar", EntityFrozenBoar.class, Reference.ENTITY_FROZEN_BOAR, 50, 16777215, 16777215);	
		registerEntity("buffalo", EntityBuffalo.class, Reference.ENTITY_BUFFALO, 50, 16777215, 16777215);
		registerEntity("layturtle", EntityLayTurtle.class, Reference.ENTITY_LAYTURTLE, 50, 16777215, 16777215);
		registerEntity("crystim", EntityCrystim.class, Reference.ENTITY_CRYSTIM, 50, 16777215, 16777215);
		
		//registerEntity("boar", EntityFrozenPig.class, Reference.ENTITY_BOAR, 50, 16777215, 16777215);	
		registerEntity("kiwi", EntityKiwi.class, Reference.KIWI, 50, 16777215, 16777215);	
		registerEntity("toxic_cow", EntityToxisCow.class, Reference.TOXIC_COW, 50, 16777215, 16777215);	
		
		//BOSS
		registerEntity("queen_creeper", EntityQueenCreeper.class, Reference.QUEEN_CREEPER, 50, 16711680, 16711680);	
		registerEntity("pharaoh", EntityPharaoh.class, Reference.PHARAOH, 50, 16711680, 16711680);	
		registerEntity("hell_king", EntityHellKing.class, Reference.HELL_KING, 50, 16711680, 16711680);	
		registerEntity("poseidon", EntityPoseidon.class, Reference.POSEIDON, 50, 16711680, 16711680);
		registerEntity("artikon", EntityArtikon.class, Reference.ARTIKON, 50, 16711680, 16711680);
		registerEntity("primary_attack", EntityPrimaryAttack.class, Reference.PRIMARY_ATTACK, 50, 16711680, 16711680);
		registerEntity("primary_heal", EntityPrimaryHeal.class, Reference.PRIMARY_HEAL, 50, 16711680, 16711680);
		registerEntity("primary_strength", EntityPrimaryStrength.class, Reference.PRIMARY_STRENGTH, 50, 16711680, 16711680);
		
		addSpawn();
		
	}

	
	
	private static void registerEntity(String name, Class<? extends Entity> entity, int id, int range, int color1, int color2) {
		EntityRegistry.registerModEntity(new ResourceLocation(Reference.MOD_ID + ":" + name), entity, name, id, Main.instance, range, 1, true, color1, color2);
	
	}
	
	public static void addSpawn() {
		//PASSIF		
		
			//NOXIS
		EntityRegistry.addSpawn(EntityBuffalo.class, 20, 3, 10, EnumCreatureType.AMBIENT, BiomeInit.NOXIS, BiomeInit.NOXIS_HILLS);
		EntityRegistry.addSpawn(EntityToxisCow.class, 20, 1, 4, EnumCreatureType.AMBIENT, BiomeInit.NOXIS_MUSHROOM);
		
			//LAPUTA
		EntityRegistry.addSpawn(EntityDragonFly.class, 20, 1, 1, EnumCreatureType.AMBIENT, BiomeInit.LAPUTA, BiomeInit.LAPUTANML, BiomeInit.LAPUTA_MAGIC);
		EntityRegistry.addSpawn(EntityKiwi.class, 20, 1, 4, EnumCreatureType.AMBIENT, BiomeInit.LAPUTA, BiomeInit.LAPUTANML, BiomeInit.LAPUTA_MAGIC);
		EntityRegistry.addSpawn(EntityLayTurtle.class, 20, 1, 4, EnumCreatureType.AMBIENT, BiomeInit.LAPUTA, BiomeInit.LAPUTANML, BiomeInit.LAPUTA_MAGIC, BiomeInit.LAPUTA_CRYSTAL);
		EntityRegistry.addSpawn(EntityCrystim.class, 20, 1, 4, EnumCreatureType.AMBIENT, BiomeInit.LAPUTA_CRYSTAL);
		
			//FROZ
		EntityRegistry.addSpawn(EntityMontauk.class, 20, 3, 5, EnumCreatureType.AMBIENT, BiomeInit.NOXIS_ICE, BiomeInit.FROZ_DENSE, BiomeInit.FROZ_PLAINE);
		EntityRegistry.addSpawn(EntityFrozenBuffalo.class, 20, 3, 5, EnumCreatureType.AMBIENT, BiomeInit.NOXIS_ICE, BiomeInit.FROZ_DENSE, BiomeInit.FROZ_PLAINE);		
		EntityRegistry.addSpawn(EntityFrozenBoar.class, 20, 3, 5, EnumCreatureType.AMBIENT, BiomeInit.NOXIS_ICE, BiomeInit.FROZ_DENSE, BiomeInit.FROZ_PLAINE);
		
		//MECHANT
		
			//NETHER
		EntityRegistry.addSpawn(EntityDemon.class, 5, 1, 3, EnumCreatureType.MONSTER, Biomes.HELL);
		EntityRegistry.addSpawn(EntityCerbere.class, 5, 1, 3, EnumCreatureType.MONSTER, Biomes.HELL);
		
			//NOXIS
		EntityRegistry.addSpawn(EntityPhorus.class, 5, 1, 3, EnumCreatureType.MONSTER, BiomeInit.NOXIS, BiomeInit.NOXIS_HILLS, BiomeInit.NOXIS_ICE);
		EntityRegistry.addSpawn(EntityTotam.class, 2, 1, 1, EnumCreatureType.MONSTER, BiomeInit.NOXIS, BiomeInit.NOXIS_HILLS, BiomeInit.NOXIS_ICE);
		EntityRegistry.addSpawn(EntityGiantSpider.class, 2, 1, 1, EnumCreatureType.MONSTER, BiomeInit.NOXIS_BIG_FOREST, BiomeInit.NOXIS);
		EntityRegistry.addSpawn(EntityGiril.class, 2, 1, 1, EnumCreatureType.MONSTER, BiomeInit.NOXIS_BIG_FOREST, BiomeInit.NOXIS);
		EntityRegistry.addSpawn(EntityHeadLess.class, 2, 1, 1, EnumCreatureType.MONSTER, BiomeInit.NOXIS_BIG_FOREST, BiomeInit.NOXIS, BiomeInit.NOXIS_HILLS, BiomeInit.NOXIS_S_HILLS);
		EntityRegistry.addSpawn(EntitySkull.class, 2, 1, 1, EnumCreatureType.MONSTER, BiomeInit.NOXIS_ROCK);
		EntityRegistry.addSpawn(EntityFailedGolem.class, 2, 1, 1, EnumCreatureType.MONSTER, BiomeInit.NOXIS_ROCK);
		
			//LAPUTA
		EntityRegistry.addSpawn(EntityGrindlyUp.class, 2, 1, 1, EnumCreatureType.MONSTER, BiomeInit.LAPUTANML, BiomeInit.LAPUTA, BiomeInit.LAPUTA_MAGIC, BiomeInit.LAPUTA_CRYSTAL);
		EntityRegistry.addSpawn(EntityGrindlyBoth.class, 2, 1, 1, EnumCreatureType.MONSTER, BiomeInit.LAPUTANML, BiomeInit.LAPUTA, BiomeInit.LAPUTA_MAGIC, BiomeInit.LAPUTA_CRYSTAL);
		EntityRegistry.addSpawn(EntityGrindlyFront.class, 2, 1, 1, EnumCreatureType.MONSTER, BiomeInit.LAPUTANML, BiomeInit.LAPUTA, BiomeInit.LAPUTA_MAGIC, BiomeInit.LAPUTA_CRYSTAL);
		EntityRegistry.addSpawn(EntityCloudy.class, 2, 1, 1, EnumCreatureType.MONSTER, BiomeInit.LAPUTANML, BiomeInit.LAPUTA, BiomeInit.LAPUTA_MAGIC, BiomeInit.LAPUTA_CRYSTAL);
		EntityRegistry.addSpawn(EntityDeadPlayer.class, 2, 1, 1, EnumCreatureType.MONSTER, BiomeInit.LAPUTANML, BiomeInit.LAPUTA, BiomeInit.LAPUTA_MAGIC, BiomeInit.LAPUTA_CRYSTAL);
			
			//FROZ
		EntityRegistry.addSpawn(EntityMothmoth.class, 2, 1, 1, EnumCreatureType.MONSTER, BiomeInit.FROZ_DENSE, BiomeInit.FROZ_PLAINE);
	}
	
}
