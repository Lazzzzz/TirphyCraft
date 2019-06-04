package com.laz.tirphycraft.util.handlers;

import com.laz.tirphycraft.Main;
import com.laz.tirphycraft.commands.CommandTeleportDimension;
import com.laz.tirphycraft.compat.OreDictionnarCompat;
import com.laz.tirphycraft.init.BiomeInit;
import com.laz.tirphycraft.init.BlockInit;
import com.laz.tirphycraft.init.DimensionInit;
import com.laz.tirphycraft.init.EntityInit;
import com.laz.tirphycraft.init.FurnaceRecipeInit;
import com.laz.tirphycraft.init.ItemInit;
import com.laz.tirphycraft.init.PotionInit;
import com.laz.tirphycraft.init.ProfessionsInit;
import com.laz.tirphycraft.objects.items.bow.BowPyrodes;
import com.laz.tirphycraft.util.interfaces.IHasModel;
import com.laz.tirphycraft.world.gen.WorldGenCustomOre;
import com.laz.tirphycraft.world.gen.WorldGenCustomStructures;
import com.laz.tirphycraft.world.gen.WorldGenCustomTree;

import net.minecraft.block.Block;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.FOVUpdateEvent;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;

@EventBusSubscriber
public class RegistryHandler {

	@SubscribeEvent
	public static void registerItems(RegistryEvent.Register<Item> event) {
		event.getRegistry().registerAll(ItemInit.ITEMS.toArray(new Item[0]));
	}

	@SubscribeEvent
	public static void registerBlocks(RegistryEvent.Register<Block> event) {
		event.getRegistry().registerAll(BlockInit.BLOCKS.toArray(new Block[0]));
		TileEntityHandler.registerTileEntities();

	}

	@SubscribeEvent
	public static void registerEnchantment(RegistryEvent.Register<Enchantment> event) {
	}

	@SubscribeEvent
	public static void registerModels(ModelRegistryEvent event) {
		RenderHandler.registerEntityRenders();

		for (Item item : ItemInit.ITEMS) {
			if (item instanceof IHasModel) {
				((IHasModel) item).registerModels();
			}
		}
		for (Block block : BlockInit.BLOCKS) {
			if (block instanceof IHasModel) {
				((IHasModel) block).registerModels();
			}
		}
	}

	@SubscribeEvent
	public void zoom(FOVUpdateEvent event) {
		if (event.getEntity().getActiveItemStack() != null)
			if (event.getEntity().getActiveItemStack().getItem() == ItemInit.BOW_PYRODES) {
				event.setNewfov(event.getFov()
						* ((BowPyrodes) event.getEntity().getActiveItemStack().getItem()).getZoom(event.getEntity()));

			}
	}

	public static void preInitRegistries(FMLPreInitializationEvent event) {

		GameRegistry.registerWorldGenerator(new WorldGenCustomOre(), 0);
		GameRegistry.registerWorldGenerator(new WorldGenCustomStructures(), 0);
		GameRegistry.registerWorldGenerator(new WorldGenCustomTree(), 0);

		BiomeInit.registerBiomes();
		DimensionInit.registerDimensions();
		System.out.println("Init Entities");
		EntityInit.registerEntitites();
		System.out.println("done");
		PotionInit.registerPotions();

	}

	public static void initRegistries(FMLInitializationEvent event) {
		NetworkRegistry.INSTANCE.registerGuiHandler(Main.instance, new GuiHandler());
		OreDictionnarCompat.registerOres();
		FurnaceRecipeInit.init();

		ProfessionsInit.associateCareersAndTrades();
	}

	public static void postInitRegistries(FMLPostInitializationEvent event) {
	}

	public static void serverRegistries(FMLServerStartingEvent event) {
		event.registerServerCommand(new CommandTeleportDimension());
	}
}
