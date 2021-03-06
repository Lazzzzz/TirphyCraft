package com.laz.tirphycraft.gosyn.common.event;

import java.util.Random;

import com.laz.tirphycraft.Main;
import com.laz.tirphycraft.gosyn.common.items.armor.ArmorGosyn;
import com.laz.tirphycraft.gosyn.common.items.tools.base.ToolsGosynAxe;
import com.laz.tirphycraft.gosyn.common.items.tools.base.ToolsGosynPickaxe;
import com.laz.tirphycraft.gosyn.common.items.tools.base.ToolsGosynShovel;
import com.laz.tirphycraft.gosyn.common.items.tools.base.ToolsGosynSword;
import com.laz.tirphycraft.util.handlers.ConfigHandler;
import com.laz.tirphycraft.util.interfaces.ParticleTypes;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.item.ItemTool;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.PlayerTickEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@EventBusSubscriber
public class EventItemDurability {

	private static Random rand = new Random();
	private static boolean isDamage = false;
	private static boolean send = false;

	@SubscribeEvent
	public static void eventDurability(PlayerTickEvent event) {
		EntityPlayer player = event.player;
		isDamage = false;
		if (!player.world.isRemote) {
			if (player.dimension == ConfigHandler.DIMENSION_GOSYN_ID && player.ticksExisted % 160 == 0) {

				toolsDurabilityOffHand(player);

				for (int i = 0; i < 36; i++) {
					ItemStack item = player.inventory.getStackInSlot(i);
					// SWORD
					if (item.getItem() instanceof ItemSword && !(item.getItem() instanceof ToolsGosynSword)) {
						if (rand.nextBoolean()) {
							item.damageItem(rand.nextInt(ConfigHandler.MAX_DAMAGE_TOOLS), player);
							isDamage = true;
						}
					}

					// PICKAXE
					else if (item.getItem() instanceof ItemPickaxe && !(item.getItem() instanceof ToolsGosynPickaxe)) {
						if (rand.nextBoolean()) {
							item.damageItem(rand.nextInt(ConfigHandler.MAX_DAMAGE_TOOLS), player);
							isDamage = true;
						}
					}

					// SHOVEL
					else if (item.getItem() instanceof ItemSpade && !(item.getItem() instanceof ToolsGosynShovel)) {
						if (rand.nextBoolean()) {
							item.damageItem(rand.nextInt(ConfigHandler.MAX_DAMAGE_TOOLS), player);
							isDamage = true;
						}
					}

					else if (item.getItem() instanceof ItemTool && !(item.getItem() instanceof ToolsGosynAxe)
							&& !(item.getItem() instanceof ToolsGosynSword)
							&& !(item.getItem() instanceof ToolsGosynShovel)
							&& !(item.getItem() instanceof ToolsGosynPickaxe)) {
						if (rand.nextBoolean()) {
							item.damageItem(rand.nextInt(ConfigHandler.MAX_DAMAGE_TOOLS), player);
							isDamage = true;
						}
					}

				}
				// ARMOR
				ItemStack item = player.getItemStackFromSlot(EntityEquipmentSlot.HEAD);

				if (item.getItem() instanceof ItemArmor && !(item.getItem() instanceof ArmorGosyn)) {
					if (rand.nextBoolean()) {
						item.damageItem(rand.nextInt(ConfigHandler.MAX_DAMAGE_TOOLS), player);
						isDamage = true;
					}
				}

				item = player.getItemStackFromSlot(EntityEquipmentSlot.CHEST);

				if (item.getItem() instanceof ItemArmor && !(item.getItem() instanceof ArmorGosyn)) {
					if (rand.nextBoolean()) {
						item.damageItem(rand.nextInt(ConfigHandler.MAX_DAMAGE_TOOLS), player);
						isDamage = true;
					}
				}

				item = player.getItemStackFromSlot(EntityEquipmentSlot.LEGS);

				if (item.getItem() instanceof ItemArmor && !(item.getItem() instanceof ArmorGosyn)) {
					if (rand.nextBoolean()) {
						item.damageItem(rand.nextInt(ConfigHandler.MAX_DAMAGE_TOOLS), player);
						isDamage = true;
					}
				}

				item = player.getItemStackFromSlot(EntityEquipmentSlot.FEET);

				if (item.getItem() instanceof ItemArmor && !(item.getItem() instanceof ArmorGosyn)) {
					if (rand.nextBoolean()) {
						item.damageItem(rand.nextInt(ConfigHandler.MAX_DAMAGE_TOOLS), player);
						isDamage = true;
					}
				}

			}

		}
	}

	private static void toolsDurabilityOffHand(EntityPlayer player) {
		ItemStack item = player.getItemStackFromSlot(EntityEquipmentSlot.OFFHAND);
		// SWORD
		if (item.getItem() instanceof ItemSword && !(item.getItem() instanceof ToolsGosynSword)) {
			if (rand.nextBoolean()) {
				item.damageItem(rand.nextInt(ConfigHandler.MAX_DAMAGE_TOOLS), player);
				isDamage = true;
			}
		}

		// PICKAXE
		else if (item.getItem() instanceof ItemPickaxe && !(item.getItem() instanceof ToolsGosynPickaxe)) {
			// System.out.println("done");
			if (rand.nextBoolean()) {
				item.damageItem(rand.nextInt(ConfigHandler.MAX_DAMAGE_TOOLS), player);
				isDamage = true;
			}
		}

		// SHOVEL
		else if (item.getItem() instanceof ItemSpade && !(item.getItem() instanceof ToolsGosynShovel)) {
			if (rand.nextBoolean()) {
				item.damageItem(rand.nextInt(ConfigHandler.MAX_DAMAGE_TOOLS), player);
				isDamage = true;
			}
		}

		else if (item.getItem() instanceof ItemTool && !(item.getItem() instanceof ToolsGosynAxe)
				&& !(item.getItem() instanceof ToolsGosynSword) && !(item.getItem() instanceof ToolsGosynShovel)
				&& !(item.getItem() instanceof ToolsGosynPickaxe)) {
			if (rand.nextBoolean()) {
				item.damageItem(rand.nextInt(ConfigHandler.MAX_DAMAGE_TOOLS), player);
				isDamage = true;
			}
		}
	}

	@SideOnly(value = Side.CLIENT)
	@SubscribeEvent
	public static void eventParticles(PlayerTickEvent event) {
		EntityPlayer player = event.player;
		if (isDamage) {
			if (send == false) {
				player.sendMessage(new TextComponentString("\u00A75" + "Magic in this world is damaging your tools and armor !"));
				send = true;
			} else {
				send = false;
			}
			for (int i = 0; i < 15; i++) {
				double vy = rand.nextDouble();
				Main.proxy.spawnParticle(player.world, ParticleTypes.GLINT_PURPLE, player.posX + (rand.nextDouble() - 0.5) * 2, player.posY + 1,
						player.posZ + (rand.nextDouble() - 0.5) * 2, 0, vy / 7, 0);
			}
		}
	}

}
