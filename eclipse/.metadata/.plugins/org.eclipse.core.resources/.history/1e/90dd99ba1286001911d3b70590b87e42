package com.laz.tirphycraft.init;

import com.laz.tirphycraft.entity.trade.customTrade;
import com.laz.tirphycraft.util.Reference;

import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;
import net.minecraftforge.fml.common.registry.VillagerRegistry.VillagerCareer;
import net.minecraftforge.fml.common.registry.VillagerRegistry.VillagerProfession;
import net.minecraftforge.registries.IForgeRegistry;

@ObjectHolder(Reference.MOD_ID)
public class ProfessionsInit {
	public final static VillagerProfession seller = null;

	public static VillagerCareer core_seller;

	@Mod.EventBusSubscriber(modid = Reference.MOD_ID)
	public static class RegistrationHandler {
		@SubscribeEvent
		public static void onEvent(final RegistryEvent.Register<VillagerProfession> event) {
			final IForgeRegistry<VillagerProfession> registry = event.getRegistry();

			registry.register(new VillagerProfession(Reference.MOD_ID + ":seller",
					Reference.MOD_ID + ":textures/entity/seller.png",
					Reference.MOD_ID + ":textures/entity/seller.png"));
		}
	}

	public static void associateCareersAndTrades() {
		core_seller = (new VillagerCareer(seller, "core_seller"))
				.addTrade(1, new customTrade.TradeQueenHeartExplosionCore())
				.addTrade(1, new customTrade.TradeAnkhLifeCore());
	}

}
