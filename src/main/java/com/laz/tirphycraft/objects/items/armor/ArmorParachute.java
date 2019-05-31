package com.laz.tirphycraft.objects.items.armor;

import javax.annotation.Nullable;

import com.laz.tirphycraft.Main;
import com.laz.tirphycraft.init.ItemInit;
import com.laz.tirphycraft.objects.items.armor.models.ModelParachute;
import com.laz.tirphycraft.util.interfaces.IHasModel;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ArmorParachute extends ItemArmor implements IHasModel {

	public ArmorParachute(String name, CreativeTabs tab, ArmorMaterial materialIn,
			EntityEquipmentSlot equipmentSlotIn) {
		super(materialIn, 1, equipmentSlotIn);
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(Main.tirphycrafttab);
		setMaxStackSize(1);

		ItemInit.ITEMS.add(this);

	}

	@Override
	public void registerModels() {
		Main.proxy.registerItemRenderer(this, 0, "inventory");
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	@Nullable
	public ModelBiped getArmorModel(EntityLivingBase entityLiving, ItemStack itemStack, EntityEquipmentSlot armorSlot,
			ModelBiped _default) {
		if (itemStack != ItemStack.EMPTY) {
			if (itemStack.getItem() instanceof ItemArmor) {
				ModelParachute model = new ModelParachute();
				model.bipedHead.showModel = armorSlot == EntityEquipmentSlot.HEAD;

				model.isChild = _default.isChild;
				model.isRiding = _default.isRiding;
				model.isSneak = _default.isSneak;
				model.rightArmPose = _default.rightArmPose;
				model.leftArmPose = _default.leftArmPose;

				return model;
			}
		}
		return null;
	}

	@Override
	public void onArmorTick(World world, EntityPlayer player, ItemStack item) {
		if (item.getItem() == ItemInit.PARACHUTE) {
			if (player.isInWater() == false) {
				if (player.motionY < 0) {
					player.motionY = -0.1;
					player.fallDistance = 0;

				}

			}
		}
	}
}
