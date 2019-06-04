package com.laz.tirphycraft.proxy;

import com.laz.tirphycraft.util.Reference;

import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.TextureStitchEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@net.minecraftforge.fml.common.Mod.EventBusSubscriber(modid = Reference.MOD_ID, value = {
		net.minecraftforge.fml.relauncher.Side.CLIENT })
public class ClientEvent {

	public ClientEvent() {
	}

	@SubscribeEvent
	public static void texStitch(TextureStitchEvent.Pre event) {
		TextureMap map = event.getMap();

		map.registerSprite(new ResourceLocation(Reference.MOD_ID, "particle/glint_white"));
		map.registerSprite(new ResourceLocation(Reference.MOD_ID, "particle/glint_blue"));
		map.registerSprite(new ResourceLocation(Reference.MOD_ID, "particle/glint_pink"));
		map.registerSprite(new ResourceLocation(Reference.MOD_ID, "particle/glint_green"));
		map.registerSprite(new ResourceLocation(Reference.MOD_ID, "particle/glint_yellow"));
		map.registerSprite(new ResourceLocation(Reference.MOD_ID, "particle/glint_purple"));
	}
}
