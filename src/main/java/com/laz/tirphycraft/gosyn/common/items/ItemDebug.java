package com.laz.tirphycraft.gosyn.common.items;

import com.laz.tirphycraft.Main;
import com.laz.tirphycraft.gosyn.common.world.gen.stage1.structures.FortnestMazePlacer;
import com.laz.tirphycraft.init.ItemInit;
import com.laz.tirphycraft.util.interfaces.IHasModel;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

public class ItemDebug extends Item implements IHasModel {
	public ItemDebug() {
		setUnlocalizedName("debug");
		setRegistryName("debug");
		setCreativeTab(Main.tirphycrafttab);
		setMaxStackSize(1);

		ItemInit.ITEMS.add(this);

	}

	@Override
	public void registerModels() {
		Main.proxy.registerItemRenderer(this, 0, "inventory");

	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {

		if (!worldIn.isRemote) {
			
			new FortnestMazePlacer().generateMaze(worldIn, playerIn.getPosition());
		}

		return super.onItemRightClick(worldIn, playerIn, handIn);
	}

}
