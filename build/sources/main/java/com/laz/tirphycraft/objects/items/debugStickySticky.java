package com.laz.tirphycraft.objects.items;

import java.util.Random;

import com.laz.tirphycraft.objects.base.ItemBase;
import com.laz.tirphycraft.util.interfaces.IStructure;
import com.laz.tirphycraft.world.gen.generators.froz.GenFrozRuinsTemplate;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

public class debugStickySticky extends ItemBase implements IStructure {

	public debugStickySticky() {
		super("debug", 1);
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
		new GenFrozRuinsTemplate("ruin_01").generate(worldIn, new Random(), playerIn.getPosition());
		return super.onItemRightClick(worldIn, playerIn, handIn);

	}

}
