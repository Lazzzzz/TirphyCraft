package com.laz.tirphycraft.util.handlers;

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
import com.laz.tirphycraft.entity.render.aggressive.RenderCerbere;
import com.laz.tirphycraft.entity.render.aggressive.RenderCloudy;
import com.laz.tirphycraft.entity.render.aggressive.RenderDeadPlayer;
import com.laz.tirphycraft.entity.render.aggressive.RenderDemon;
import com.laz.tirphycraft.entity.render.aggressive.RenderFailedGolem;
import com.laz.tirphycraft.entity.render.aggressive.RenderGiantSpider;
import com.laz.tirphycraft.entity.render.aggressive.RenderGiril;
import com.laz.tirphycraft.entity.render.aggressive.RenderGrindlyBoth;
import com.laz.tirphycraft.entity.render.aggressive.RenderGrindlyFront;
import com.laz.tirphycraft.entity.render.aggressive.RenderGrindlyUp;
import com.laz.tirphycraft.entity.render.aggressive.RenderGuardianGolem;
import com.laz.tirphycraft.entity.render.aggressive.RenderHeadLess;
import com.laz.tirphycraft.entity.render.aggressive.RenderMummy;
import com.laz.tirphycraft.entity.render.aggressive.RenderPhorus;
import com.laz.tirphycraft.entity.render.aggressive.RenderSkull;
import com.laz.tirphycraft.entity.render.aggressive.RenderTotam;
import com.laz.tirphycraft.entity.render.boss.RenderArtikon;
import com.laz.tirphycraft.entity.render.boss.RenderHellKing;
import com.laz.tirphycraft.entity.render.boss.RenderPharaoh;
import com.laz.tirphycraft.entity.render.boss.RenderPoseidon;
import com.laz.tirphycraft.entity.render.boss.RenderQueenCreeper;
import com.laz.tirphycraft.entity.render.neutral.RenderMothmoth;
import com.laz.tirphycraft.entity.render.passif.RenderBuffalo;
import com.laz.tirphycraft.entity.render.passif.RenderCrystim;
import com.laz.tirphycraft.entity.render.passif.RenderDragonFly;
import com.laz.tirphycraft.entity.render.passif.RenderFrozenBoar;
import com.laz.tirphycraft.entity.render.passif.RenderFrozenBuffalo;
import com.laz.tirphycraft.entity.render.passif.RenderKiwi;
import com.laz.tirphycraft.entity.render.passif.RenderLayTurtle;
import com.laz.tirphycraft.entity.render.passif.RenderMontauk;
import com.laz.tirphycraft.entity.render.passif.RenderToxicCow;
import com.laz.tirphycraft.entity.render.passif.RenderVidargavia;

import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

public class RenderHandler {
	public static void registerEntityRenders() {
		RenderingRegistry.registerEntityRenderingHandler(EntityGuardianGolem.class,
				new IRenderFactory<EntityGuardianGolem>() {

					@Override
					public Render<? super EntityGuardianGolem> createRenderFor(RenderManager manager) {
						return new RenderGuardianGolem(manager);

					}

				});
		RenderingRegistry.registerEntityRenderingHandler(EntityVidargavia.class,
				new IRenderFactory<EntityVidargavia>() {

					@Override
					public Render<? super EntityVidargavia> createRenderFor(RenderManager manager) {
						return new RenderVidargavia(manager);

					}

				});
		RenderingRegistry.registerEntityRenderingHandler(EntityDragonFly.class, new IRenderFactory<EntityDragonFly>() {

			@Override
			public Render<? super EntityDragonFly> createRenderFor(RenderManager manager) {
				return new RenderDragonFly(manager);

			}

		});
		RenderingRegistry.registerEntityRenderingHandler(EntityMontauk.class, new IRenderFactory<EntityMontauk>() {

			@Override
			public Render<? super EntityMontauk> createRenderFor(RenderManager manager) {
				return new RenderMontauk(manager);

			}

		});
		RenderingRegistry.registerEntityRenderingHandler(EntityFrozenBuffalo.class,
				new IRenderFactory<EntityFrozenBuffalo>() {

					@Override
					public Render<? super EntityFrozenBuffalo> createRenderFor(RenderManager manager) {
						return new RenderFrozenBuffalo(manager);

					}

				});
		RenderingRegistry.registerEntityRenderingHandler(EntityFrozenBoar.class,
				new IRenderFactory<EntityFrozenBoar>() {

					@Override
					public Render<? super EntityFrozenBoar> createRenderFor(RenderManager manager) {
						return new RenderFrozenBoar(manager);

					}

				});
		RenderingRegistry.registerEntityRenderingHandler(EntityBuffalo.class, new IRenderFactory<EntityBuffalo>() {

			@Override
			public Render<? super EntityBuffalo> createRenderFor(RenderManager manager) {
				return new RenderBuffalo(manager);

			}

		});
		RenderingRegistry.registerEntityRenderingHandler(EntityPhorus.class, new IRenderFactory<EntityPhorus>() {

			@Override
			public Render<? super EntityPhorus> createRenderFor(RenderManager manager) {
				return new RenderPhorus(manager);

			}

		});
		RenderingRegistry.registerEntityRenderingHandler(EntityTotam.class, new IRenderFactory<EntityTotam>() {

			@Override
			public Render<? super EntityTotam> createRenderFor(RenderManager manager) {
				return new RenderTotam(manager);

			}

		});
		RenderingRegistry.registerEntityRenderingHandler(EntityQueenCreeper.class,
				new IRenderFactory<EntityQueenCreeper>() {

					@Override
					public Render<? super EntityQueenCreeper> createRenderFor(RenderManager manager) {
						return new RenderQueenCreeper(manager);

					}

				});
		RenderingRegistry.registerEntityRenderingHandler(EntityGrindlyUp.class, new IRenderFactory<EntityGrindlyUp>() {

			@Override
			public Render<? super EntityGrindlyUp> createRenderFor(RenderManager manager) {
				return new RenderGrindlyUp(manager);

			}

		});
		RenderingRegistry.registerEntityRenderingHandler(EntityGrindlyFront.class,
				new IRenderFactory<EntityGrindlyFront>() {

					@Override
					public Render<? super EntityGrindlyFront> createRenderFor(RenderManager manager) {
						return new RenderGrindlyFront(manager);

					}

				});
		RenderingRegistry.registerEntityRenderingHandler(EntityGrindlyBoth.class,
				new IRenderFactory<EntityGrindlyBoth>() {

					@Override
					public Render<? super EntityGrindlyBoth> createRenderFor(RenderManager manager) {
						return new RenderGrindlyBoth(manager);

					}

				});
		RenderingRegistry.registerEntityRenderingHandler(EntityCloudy.class, new IRenderFactory<EntityCloudy>() {

			@Override
			public Render<? super EntityCloudy> createRenderFor(RenderManager manager) {
				return new RenderCloudy(manager);

			}

		});
		RenderingRegistry.registerEntityRenderingHandler(EntityCerbere.class, new IRenderFactory<EntityCerbere>() {

			@Override
			public Render<? super EntityCerbere> createRenderFor(RenderManager manager) {
				return new RenderCerbere(manager);

			}

		});
		RenderingRegistry.registerEntityRenderingHandler(EntityDemon.class, new IRenderFactory<EntityDemon>() {

			@Override
			public Render<? super EntityDemon> createRenderFor(RenderManager manager) {
				return new RenderDemon(manager);

			}

		});
		RenderingRegistry.registerEntityRenderingHandler(EntityDeadPlayer.class,
				new IRenderFactory<EntityDeadPlayer>() {

					@Override
					public Render<? super EntityDeadPlayer> createRenderFor(RenderManager manager) {
						return new RenderDeadPlayer(manager);

					}

				});
		RenderingRegistry.registerEntityRenderingHandler(EntityKiwi.class,
				new IRenderFactory<EntityKiwi>() {

					@Override
					public Render<? super EntityKiwi> createRenderFor(RenderManager manager) {
						return new RenderKiwi(manager);

					}

				});
		
		RenderingRegistry.registerEntityRenderingHandler(EntityPharaoh.class,
				new IRenderFactory<EntityPharaoh>() {

					@Override
					public Render<? super EntityPharaoh> createRenderFor(RenderManager manager) {
						return new RenderPharaoh(manager);

					}

				});	
		
		RenderingRegistry.registerEntityRenderingHandler(EntityMummy.class,
				new IRenderFactory<EntityMummy>() {

					@Override
					public Render<? super EntityMummy> createRenderFor(RenderManager manager) {
						return new RenderMummy(manager);

					}

				});			
		RenderingRegistry.registerEntityRenderingHandler(EntityHellKing.class,
				new IRenderFactory<EntityHellKing>() {

					@Override
					public Render<? super EntityHellKing> createRenderFor(RenderManager manager) {
						return new RenderHellKing(manager);

					}

				});	
		
		RenderingRegistry.registerEntityRenderingHandler(EntityGiantSpider.class,
				new IRenderFactory<EntityGiantSpider>() {

					@Override
					public Render<? super EntityGiantSpider> createRenderFor(RenderManager manager) {
						return new RenderGiantSpider(manager);

					}

				});	
		
		RenderingRegistry.registerEntityRenderingHandler(EntityFailedGolem.class,
				new IRenderFactory<EntityFailedGolem>() {

					@Override
					public Render<? super EntityFailedGolem> createRenderFor(RenderManager manager) {
						return new RenderFailedGolem(manager);

					}

				});	
		
		RenderingRegistry.registerEntityRenderingHandler(EntityHeadLess.class,
				new IRenderFactory<EntityHeadLess>() {

					@Override
					public Render<? super EntityHeadLess> createRenderFor(RenderManager manager) {
						return new RenderHeadLess(manager);

					}

				});	
		RenderingRegistry.registerEntityRenderingHandler(EntityGiril.class,
				new IRenderFactory<EntityGiril>() {

					@Override
					public Render<? super EntityGiril> createRenderFor(RenderManager manager) {
						return new RenderGiril(manager);

					}

				});		

		RenderingRegistry.registerEntityRenderingHandler(EntityPoseidon.class,
				new IRenderFactory<EntityPoseidon>() {

					@Override
					public Render<? super EntityPoseidon> createRenderFor(RenderManager manager) {
						return new RenderPoseidon(manager);

					}

				});		
		
		RenderingRegistry.registerEntityRenderingHandler(EntityArtikon.class,
				new IRenderFactory<EntityArtikon>() {

					@Override
					public Render<? super EntityArtikon> createRenderFor(RenderManager manager) {
						return new RenderArtikon(manager);

					}

				});	
		RenderingRegistry.registerEntityRenderingHandler(EntityToxisCow.class,
				new IRenderFactory<EntityToxisCow>() {

					@Override
					public Render<? super EntityToxisCow> createRenderFor(RenderManager manager) {
						return new RenderToxicCow(manager);

					}

				});

		RenderingRegistry.registerEntityRenderingHandler(EntitySkull.class,
				new IRenderFactory<EntitySkull>() {

					@Override
					public Render<? super EntitySkull> createRenderFor(RenderManager manager) {
						return new RenderSkull(manager);

					}

				});	
		RenderingRegistry.registerEntityRenderingHandler(EntityMothmoth.class,
				new IRenderFactory<EntityMothmoth>() {

					@Override
					public Render<? super EntityMothmoth> createRenderFor(RenderManager manager) {
						return new RenderMothmoth(manager);

					}

				});	
		RenderingRegistry.registerEntityRenderingHandler(EntityLayTurtle.class,
				new IRenderFactory<EntityLayTurtle>() {

					@Override
					public RenderLayTurtle createRenderFor(RenderManager manager) {
						return new RenderLayTurtle(manager);

					}

				});
		RenderingRegistry.registerEntityRenderingHandler(EntityCrystim.class,
				new IRenderFactory<EntityCrystim>() {

					@Override
					public RenderCrystim createRenderFor(RenderManager manager) {
						return new RenderCrystim(manager);

					}

				});	
				
	}

}
