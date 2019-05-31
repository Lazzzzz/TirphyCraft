package com.laz.tirphycraft.objects.items.clock;

import java.util.List;

import com.laz.tirphycraft.objects.base.ItemBase;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.FMLCommonHandler;


public class ItemClock extends ItemBase {
	private final int dim;
	private final String info;

	public ItemClock(String name, int dim, String info) {
		super(name, 1);
		this.dim  = dim;
		this.info = info;
		
	}

	@Override
	public void addInformation(ItemStack stack, World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
		tooltip.add("\u00A75" + this.info);
	}

	@Override
	public ActionResult<net.minecraft.item.ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn,EnumHand handIn) {
		ItemStack item = playerIn.getHeldItem(handIn);
		if (playerIn instanceof EntityPlayerMP) {
			MinecraftServer minecraftserver = FMLCommonHandler.instance().getMinecraftServerInstance();
			if (minecraftserver != null) {
				minecraftserver.getCommandManager().executeCommand((EntityPlayerMP) playerIn, "tpdim " + this.dim);
			}
		}

		return new ActionResult<ItemStack>(EnumActionResult.PASS, item);
	}
}