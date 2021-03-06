package com.laz.tirphycraft.objects.items.other;

import com.laz.tirphycraft.init.BiomeInit;
import com.laz.tirphycraft.init.ItemInit;
import com.laz.tirphycraft.objects.base.ItemBase;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;

public class ItemMixedDust extends ItemBase {

	public ItemMixedDust(String name, int stack) {
		super(name, stack);
		setMaxDamage(10);
	}
	
	@Override
	public void onUpdate(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
		if (!worldIn.isRemote && entityIn instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer) entityIn;
			
			if (worldIn.getBiome(player.getPosition()) == BiomeInit.LAPUTA_CRYSTAL && entityIn.ticksExisted % 100 == 0 && worldIn.rand.nextInt(3) == 0) {
				stack.damageItem(1, player);
				if (stack.getItemDamage() == this.getMaxDamage()) {
					player.replaceItemInInventory(itemSlot, new ItemStack(ItemInit.ORIGIN_MATTER, stack.getCount()));
					player.sendMessage(new TextComponentString("\u00A75" + "You just reach on the origin of the matter ..."));
					
				}
			}

			// super.onUpdate(stack, worldIn, entityIn, itemSlot, isSelected);
		}

	}
}
