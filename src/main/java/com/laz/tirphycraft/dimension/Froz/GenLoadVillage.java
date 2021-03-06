package com.laz.tirphycraft.dimension.Froz;

import com.laz.tirphycraft.util.Reference;
import com.laz.tirphycraft.util.interfaces.IStructure;

import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraft.world.gen.structure.template.Template;
import net.minecraft.world.gen.structure.template.TemplateManager;

public class GenLoadVillage implements IStructure {

	public static ResourceLocation village_littlehouse1 = new ResourceLocation(Reference.MOD_ID, "froz/village/little_house_1");
	public static ResourceLocation village_littlehouse2 = new ResourceLocation(Reference.MOD_ID, "froz/village/little_house_2");
	public static ResourceLocation village_house1 = new ResourceLocation(Reference.MOD_ID, "froz/village/house_1");
	public static ResourceLocation village_tower = new ResourceLocation(Reference.MOD_ID, "froz/village/tower");
	public static ResourceLocation village_camp = new ResourceLocation(Reference.MOD_ID, "froz/village/camp");
	public static ResourceLocation village_plantation = new ResourceLocation(Reference.MOD_ID, "froz/village/plantation");

	public static Template[] structures;

	public GenLoadVillage(World worldIn) {
		MinecraftServer mcServer = worldIn.getMinecraftServer();
		TemplateManager manager = worldServer.getStructureTemplateManager();

		structures = new Template[] { 
				manager.get(mcServer, village_littlehouse1),
				manager.get(mcServer, village_littlehouse2), 
				manager.get(mcServer, village_house1),
				manager.get(mcServer, village_tower), 
				manager.get(mcServer, village_plantation),
				manager.get(mcServer, village_camp)
		};
		
	}
	
	public Template getStructures(int index) {
		return this.structures[index];
	}
}
