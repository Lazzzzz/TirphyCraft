package com.laz.tirphycraft.init;

import com.laz.tirphycraft.Main;
import com.laz.tirphycraft.entity.entityClass.aggressive.EntityAngrySnowGolemRange;
import com.laz.tirphycraft.entity.entityClass.aggressive.EntityAngrySnowGolemSoldier;
import com.laz.tirphycraft.entity.entityClass.aggressive.EntityBreaker;
import com.laz.tirphycraft.entity.entityClass.aggressive.EntityCerbere;
import com.laz.tirphycraft.entity.entityClass.aggressive.EntityCloudy;
import com.laz.tirphycraft.entity.entityClass.aggressive.EntityDeadPlayer;
import com.laz.tirphycraft.entity.entityClass.aggressive.EntityDemon;
import com.laz.tirphycraft.entity.entityClass.aggressive.EntityFailedGolem;
import com.laz.tirphycraft.entity.entityClass.aggressive.EntityGiantSpider;
import com.laz.tirphycraft.entity.entityClass.aggressive.EntityGiril;
import com.laz.tirphycraft.entity.entityClass.aggressive.EntityGrindlyBoth;
import com.laz.tirphycraft.entity.entityClass.aggressive.EntityGrindlyFront;
import com.laz.tirphycraft.entity.entityClass.aggressive.EntityGrindlyUp;
import com.laz.tirphycraft.entity.entityClass.aggressive.EntityGuardianGolem;
import com.laz.tirphycraft.entity.entityClass.aggressive.EntityHeadLess;
import com.laz.tirphycraft.entity.entityClass.aggressive.EntityMummy;
import com.laz.tirphycraft.entity.entityClass.aggressive.EntityPhorus;
import com.laz.tirphycraft.entity.entityClass.aggressive.EntityPlyton;
import com.laz.tirphycraft.entity.entityClass.aggressive.EntitySkull;
import com.laz.tirphycraft.entity.entityClass.aggressive.EntityTotam;
import com.laz.tirphycraft.entity.entityClass.boss.EntityArtikon;
import com.laz.tirphycraft.entity.entityClass.boss.EntityHellKing;
import com.laz.tirphycraft.entity.entityClass.boss.EntityPharaoh;
import com.laz.tirphycraft.entity.entityClass.boss.EntityPoseidon;
import com.laz.tirphycraft.entity.entityClass.boss.EntityPrimaryAttack;
import com.laz.tirphycraft.entity.entityClass.boss.EntityPrimaryHeal;
import com.laz.tirphycraft.entity.entityClass.boss.EntityPrimaryStrength;
import com.laz.tirphycraft.entity.entityClass.boss.EntityQueenCreeper;
import com.laz.tirphycraft.entity.entityClass.neutral.EntityMothmoth;
import com.laz.tirphycraft.entity.entityClass.neutral.EntityStellar;
import com.laz.tirphycraft.entity.entityClass.neutral.EntityVelociraptor;
import com.laz.tirphycraft.entity.entityClass.passif.EntityBuffalo;
import com.laz.tirphycraft.entity.entityClass.passif.EntityColosse;
import com.laz.tirphycraft.entity.entityClass.passif.EntityCrystim;
import com.laz.tirphycraft.entity.entityClass.passif.EntityDragonFly;
import com.laz.tirphycraft.entity.entityClass.passif.EntityFrozenBoar;
import com.laz.tirphycraft.entity.entityClass.passif.EntityFrozenBuffalo;
import com.laz.tirphycraft.entity.entityClass.passif.EntityKiwi;
import com.laz.tirphycraft.entity.entityClass.passif.EntityLayTurtle;
import com.laz.tirphycraft.entity.entityClass.passif.EntityMontauk;
import com.laz.tirphycraft.entity.entityClass.passif.EntityToxisCow;
import com.laz.tirphycraft.entity.entityClass.passif.EntityVidargavia;
import com.laz.tirphycraft.entity.entityClass.projectile.EntityIceBall;
import com.laz.tirphycraft.entity.entityClass.projectile.EntityMeteorite;
import com.laz.tirphycraft.util.Reference;
import com.laz.tirphycraft.util.handlers.ConfigHandler;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.init.Biomes;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.EntityRegistry;

public class EntityInit {
	
	public static void registerEntitites() {
		
		//AUTRES
		registerEntity("vidargavia", EntityVidargavia.class, ConfigHandler.ENTITY_VIDARGAVIA, 50, 000000, 000000);
		registerEntity("guardian_golem", EntityGuardianGolem.class, ConfigHandler.ENTITY_GUARDIAN_GOLEM, 50, 000000, 000000);
		registerEntity("dragonfly", EntityDragonFly.class, ConfigHandler.ENTITY_DRAGON_FLY, 50, 000000, 000000);
	
		//MECHANT
		registerEntity("phorus", EntityPhorus.class, ConfigHandler.ENTITY_PHORUS, 50, 000000, 000000);			
		registerEntity("totam", EntityTotam.class, ConfigHandler.ENTITY_TOTAM, 50, 000000, 000000);	
		registerEntity("grindlyUp", EntityGrindlyUp.class, ConfigHandler.GRINDLY_UP, 50, 000000, 000000);	
		registerEntity("grindlyFront", EntityGrindlyFront.class, ConfigHandler.GRINDLY_FRONT, 50, 000000, 000000);	
		registerEntity("grindlyBoth", EntityGrindlyBoth.class, ConfigHandler.GRINDLY_BOTH, 50, 000000, 000000);
		registerEntity("cloudy", EntityCloudy.class, ConfigHandler.CLOUDY, 50, 000000, 000000);
		registerEntity("cerbere", EntityCerbere.class, ConfigHandler.CERBERE, 50, 000000, 000000);
		registerEntity("demon", EntityDemon.class, ConfigHandler.DEMON, 50, 000000, 000000);
		registerEntity("dead_Player", EntityDeadPlayer.class, ConfigHandler.DEAD_PLAYER, 50, 000000, 000000);
		registerEntity("mummy", EntityMummy.class, ConfigHandler.MUMMY, 50, 000000, 000000);
		registerEntity("giant_spider", EntityGiantSpider.class, ConfigHandler.GIANT_SPIDER, 50, 000000, 000000);
		registerEntity("failed_golem", EntityFailedGolem.class, ConfigHandler.FAILED_GOLEM, 50, 000000, 000000);
		registerEntity("head_less", EntityHeadLess.class, ConfigHandler.HEAD_LESS, 50, 000000, 000000);
		registerEntity("giril", EntityGiril.class, ConfigHandler.GIRIL, 50, 000000, 000000);
		registerEntity("skull", EntitySkull.class, ConfigHandler.SKULL, 50, 000000, 000000);
		registerEntity("plyton", EntityPlyton.class, ConfigHandler.ENTITY_PLYTON, 500, 000000, 000000);
		registerEntity("Soldier Snow Golem", EntityAngrySnowGolemSoldier.class, ConfigHandler.ENTITY_SOLDIER_SNOWGOLEM, 500, 000000, 000000);
		registerEntity("Range Snow Golem", EntityAngrySnowGolemRange.class, ConfigHandler.ENTITY_RANGE_SNOWGOLEM, 500, 000000, 000000);
		registerEntity("Breaker", EntityBreaker.class, ConfigHandler.ENTITY_BREAKER, 500, 000000, 000000);
		
		//NEUTRAL
		registerEntity("mothmoth", EntityMothmoth.class, ConfigHandler.ENTITY_MOTHMOTH, 50, 3690832, 3690832);	
		registerEntity("velociraptor", EntityVelociraptor.class, ConfigHandler.ENTITY_VELOCIRAPTOR, 50, 3690832, 3690832);	
		
		//PASSIF
		registerEntity("montauk", EntityMontauk.class, ConfigHandler.ENTITY_MONTAUK, 50, 16777215, 16777215);		
		registerEntity("frozen_buffalo", EntityFrozenBuffalo.class, ConfigHandler.ENTITY_FROZEN_BUFFALO, 50, 16777215, 16777215);			
		registerEntity("frozen_boar", EntityFrozenBoar.class, ConfigHandler.ENTITY_FROZEN_BOAR, 50, 16777215, 16777215);	
		registerEntity("buffalo", EntityBuffalo.class, ConfigHandler.ENTITY_BUFFALO, 50, 16777215, 16777215);
		registerEntity("layturtle", EntityLayTurtle.class, ConfigHandler.ENTITY_LAYTURTLE, 50, 16777215, 16777215);
		registerEntity("crystim", EntityCrystim.class, ConfigHandler.ENTITY_CRYSTIM, 50, 16777215, 16777215);
		registerEntity("colosse", EntityColosse.class, ConfigHandler.ENTITY_COLOSSE, 50, 16777215, 16777215);
		
		//registerEntity("boar", EntityFrozenPig.class, ConfigHandler.ENTITY_BOAR, 50, 16777215, 16777215);	
		registerEntity("kiwi", EntityKiwi.class, ConfigHandler.KIWI, 50, 16777215, 16777215);	
		registerEntity("toxic_cow", EntityToxisCow.class, ConfigHandler.TOXIC_COW, 50, 16777215, 16777215);	
		
		//BOSS
		registerEntity("queen_creeper", EntityQueenCreeper.class, ConfigHandler.QUEEN_CREEPER, 50, 16711680, 16711680);	
		registerEntity("pharaoh", EntityPharaoh.class, ConfigHandler.PHARAOH, 50, 16711680, 16711680);	
		registerEntity("hell_king", EntityHellKing.class, ConfigHandler.HELL_KING, 50, 16711680, 16711680);	
		registerEntity("poseidon", EntityPoseidon.class, ConfigHandler.POSEIDON, 50, 16711680, 16711680);
		registerEntity("artikon", EntityArtikon.class, ConfigHandler.ARTIKON, 50, 16711680, 16711680);
		registerEntity("primary_attack", EntityPrimaryAttack.class, ConfigHandler.PRIMARY_ATTACK, 50, 16711680, 16711680);
		registerEntity("primary_heal", EntityPrimaryHeal.class, ConfigHandler.PRIMARY_HEAL, 50, 16711680, 16711680);
		registerEntity("primary_strength", EntityPrimaryStrength.class, ConfigHandler.PRIMARY_STRENGTH, 50, 16711680, 16711680);
		
		//OTHER
		registerEntity("stellar", EntityStellar.class, ConfigHandler.ENTITY_STELLAR, 50, 3092992, 3092992);
		registerEntity("ice_ball", EntityIceBall.class, ConfigHandler.ENTITY_ICE_BALL, 50, 3092992, 3092992);
		registerEntity("meteorite", EntityMeteorite.class, ConfigHandler.ENTITY_METEORITE, 500, 3092992, 3092992);
		
		addSpawn();
		
	}

	
	
	private static void registerEntity(String name, Class<? extends Entity> entity, int id, int range, int color1, int color2) {
		EntityRegistry.registerModEntity(new ResourceLocation(Reference.MOD_ID + ":" + name), entity, name, id, Main.instance, range, 1, true, color1, color2);
	
	}
	
	public static void addSpawn() {
		//PASSIF		
		
			//NOXIS
		//EntityRegistry.addSpawn(EntityBuffalo.class, 20, 3, 10, EnumCreatureType.AMBIENT, BiomeInit.NOXIS);
		//EntityRegistry.addSpawn(EntityToxisCow.class, 20, 1, 4, EnumCreatureType.AMBIENT, BiomeInit.NOXIS);
		
			//LAPUTA
		EntityRegistry.addSpawn(EntityDragonFly.class, 20, 1, 1, EnumCreatureType.AMBIENT, BiomeInit.LAPUTA, BiomeInit.LAPUTANML, BiomeInit.LAPUTA_MAGIC);
		EntityRegistry.addSpawn(EntityKiwi.class, 20, 1, 4, EnumCreatureType.AMBIENT, BiomeInit.LAPUTA, BiomeInit.LAPUTANML, BiomeInit.LAPUTA_MAGIC);
		EntityRegistry.addSpawn(EntityLayTurtle.class, 20, 1, 4, EnumCreatureType.AMBIENT, BiomeInit.LAPUTA, BiomeInit.LAPUTANML, BiomeInit.LAPUTA_MAGIC, BiomeInit.LAPUTA_CRYSTAL);
		EntityRegistry.addSpawn(EntityCrystim.class, 20, 1, 4, EnumCreatureType.AMBIENT, BiomeInit.LAPUTA_CRYSTAL);
		
			//FROZ
		EntityRegistry.addSpawn(EntityMontauk.class, 20, 3, 5, EnumCreatureType.AMBIENT, BiomeInit.FROZ_DENSE, BiomeInit.FROZ_PLAINE);
		EntityRegistry.addSpawn(EntityFrozenBuffalo.class, 20, 3, 5, EnumCreatureType.AMBIENT, BiomeInit.FROZ_DENSE, BiomeInit.FROZ_PLAINE);		
		EntityRegistry.addSpawn(EntityFrozenBoar.class, 20, 3, 5, EnumCreatureType.AMBIENT, BiomeInit.FROZ_DENSE, BiomeInit.FROZ_PLAINE);
		EntityRegistry.addSpawn(EntityColosse.class, 20, 3, 5, EnumCreatureType.AMBIENT, BiomeInit.FROZ_DENSE, BiomeInit.FROZ_PLAINE);
		
		//MECHANT
		
			//NETHER
		EntityRegistry.addSpawn(EntityDemon.class, 5, 1, 3, EnumCreatureType.MONSTER, Biomes.HELL);
		EntityRegistry.addSpawn(EntityCerbere.class, 5, 1, 3, EnumCreatureType.MONSTER, Biomes.HELL);
		
		//NOXIS 
		//EntityRegistry.addSpawn(EntityPhorus.class, 5, 1, 3, EnumCreatureType.MONSTER, BiomeInit.NOXIS, BiomeInit.NOXIS, BiomeInit.NOXIS);
		//EntityRegistry.addSpawn(EntityTotam.class, 2, 1, 1, EnumCreatureType.MONSTER, BiomeInit.NOXIS, BiomeInit.NOXIS, BiomeInit.NOXIS);
		//EntityRegistry.addSpawn(EntityGiantSpider.class, 2, 1, 1, EnumCreatureType.MONSTER, BiomeInit.NOXIS, BiomeInit.NOXIS);
		//EntityRegistry.addSpawn(EntityGiril.class, 2, 1, 1, EnumCreatureType.MONSTER, BiomeInit.NOXIS, BiomeInit.NOXIS);
		//EntityRegistry.addSpawn(EntityHeadLess.class, 2, 1, 1, EnumCreatureType.MONSTER, BiomeInit.NOXIS, BiomeInit.NOXIS, BiomeInit.NOXIS, BiomeInit.NOXIS);
		//EntityRegistry.addSpawn(EntitySkull.class, 2, 1, 1, EnumCreatureType.MONSTER, BiomeInit.NOXIS);
		//EntityRegistry.addSpawn(EntityFailedGolem.class, 2, 1, 1, EnumCreatureType.MONSTER, BiomeInit.NOXIS);
		
		//LAPUTA
		EntityRegistry.addSpawn(EntityGrindlyUp.class, 2, 1, 1, EnumCreatureType.MONSTER, BiomeInit.LAPUTANML, BiomeInit.LAPUTA, BiomeInit.LAPUTA_MAGIC, BiomeInit.LAPUTA_CRYSTAL);
		EntityRegistry.addSpawn(EntityGrindlyBoth.class, 2, 1, 1, EnumCreatureType.MONSTER, BiomeInit.LAPUTANML, BiomeInit.LAPUTA, BiomeInit.LAPUTA_MAGIC, BiomeInit.LAPUTA_CRYSTAL);
		EntityRegistry.addSpawn(EntityGrindlyFront.class, 2, 1, 1, EnumCreatureType.MONSTER, BiomeInit.LAPUTANML, BiomeInit.LAPUTA, BiomeInit.LAPUTA_MAGIC, BiomeInit.LAPUTA_CRYSTAL);
		EntityRegistry.addSpawn(EntityCloudy.class, 2, 1, 1, EnumCreatureType.MONSTER, BiomeInit.LAPUTANML, BiomeInit.LAPUTA, BiomeInit.LAPUTA_MAGIC, BiomeInit.LAPUTA_CRYSTAL);
		EntityRegistry.addSpawn(EntityDeadPlayer.class, 2, 1, 1, EnumCreatureType.MONSTER, BiomeInit.LAPUTANML, BiomeInit.LAPUTA, BiomeInit.LAPUTA_MAGIC, BiomeInit.LAPUTA_CRYSTAL);
			
			//FROZ
		EntityRegistry.addSpawn(EntityMothmoth.class, 2, 1, 1, EnumCreatureType.MONSTER, BiomeInit.FROZ_DENSE, BiomeInit.FROZ_PLAINE);
		EntityRegistry.addSpawn(EntityPlyton.class, 2, 1, 1, EnumCreatureType.MONSTER, BiomeInit.FROZ_MONTAIN);
	}
	
}
