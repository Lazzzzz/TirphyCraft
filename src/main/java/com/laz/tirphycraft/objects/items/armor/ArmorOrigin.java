package com.laz.tirphycraft.objects.items.armor;

import java.util.List;

import com.laz.tirphycraft.Main;
import com.laz.tirphycraft.dimension.Laputa.DimensionLibraryLaputa;
import com.laz.tirphycraft.init.BlockInit;
import com.laz.tirphycraft.init.ItemInit;
import com.laz.tirphycraft.util.handlers.ConfigHandler;
import com.laz.tirphycraft.util.interfaces.IHasModel;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;

public class ArmorOrigin extends ItemArmor implements IHasModel {

	private ArmorMaterial material;
	private float toughness;
	private float damageReduceAmount;

	public ArmorOrigin(String name, ArmorMaterial materialIn, int renderIndexIn, EntityEquipmentSlot equipmentSlotIn) {
		super(materialIn, renderIndexIn, equipmentSlotIn);
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(Main.tirphycrafttab);
		this.material = materialIn;
		this.toughness = this.material.getToughness();
		this.damageReduceAmount = this.material.getDamageReductionAmount(this.armorType);
		ItemInit.ITEMS.add(this);
	}

	@Override
	public void onArmorTick(World world, EntityPlayer player, ItemStack itemStack) {
		if (!world.isRemote) {
			List<ItemStack> armor = (List<ItemStack>) player.getArmorInventoryList();
			NBTTagCompound nbt_0 = armor.get(0).getTagCompound();	
			NBTTagCompound nbt_1 = armor.get(1).getTagCompound();	
			NBTTagCompound nbt_2 = armor.get(2).getTagCompound();	
			NBTTagCompound nbt_3 = armor.get(3).getTagCompound();	
			
			if  (player.isCreative() == false) {
				player.capabilities.allowFlying = false;
			}
			player.capabilities.setFlySpeed(0.05f);
			
			// check for full original set
			if (armor.get(0).getItem() == ItemInit.ORIGIN_BOOTS      && 
				armor.get(1).getItem() == ItemInit.ORIGIN_LEGGINGS   && 
				armor.get(2).getItem() == ItemInit.ORIGIN_CHESTPLATE && 
				armor.get(3).getItem() == ItemInit.ORIGIN_HELMET) {
				
				// check if he is on the altar
				if (player.dimension == ConfigHandler.DIMENSION_LAPUTA_ID 
						&& player.posX > 7 && player.posX < 9
						&& player.posZ > 7 && player.posZ < 9
						&& player.posY > 90 && player.posY < 130) {

					// check if ALL pillar are activated
					DimensionLibraryLaputa lib = (DimensionLibraryLaputa) world.provider;
					boolean flag = true;					
					for (int i = 0; i < 5; i++) {
						BlockPos crystalPos = new BlockPos(lib.posX[i]*16 + 7,100,lib.posY[i]*16 + 7);
						if (world.getBlockState(crystalPos) != BlockInit.TESSERACT_ACTIVATE.getDefaultState()) flag = false;
					}
					if (flag) setPower(itemStack, player);	
				}
				
				if (nbt_0 != null && nbt_1 != null && nbt_2 != null && nbt_3 != null) {
					if (nbt_0.getBoolean("powered") == true && nbt_1.getBoolean("powered") == true && nbt_2.getBoolean("powered") == true && nbt_3.getBoolean("powered") == true) {
						player.capabilities.allowFlying = true;
						player.capabilities.setFlySpeed(0.2f);
						player.addPotionEffect(new PotionEffect(MobEffects.SPEED, 20, 0, false, false));
					
					} else player.capabilities.isFlying = false;
				} else 	player.capabilities.isFlying = false;
			} else player.capabilities.isFlying = false;
		
			player.sendPlayerAbilities();
			
		}

		super.onArmorTick(world, player, itemStack);
	}

	@Override
	public void addInformation(ItemStack stack, World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
		NBTTagCompound nbt = stack.getTagCompound();
		if (nbt == null) {
			tooltip.add("\u00A75" + "Full set :");
			tooltip.add("\u00A74" + "nothing ...");
		} else {
			tooltip.add("\u00A76" + "Full set :");
			tooltip.add("\u00A76" + "§kGOD POWER");
		}
	}

	public void setPower(ItemStack stack, EntityPlayer player) {

		NBTTagCompound nbt = stack.getTagCompound();
		if (nbt == null) {
			nbt = new NBTTagCompound();
			nbt.setBoolean("powered", true);
			stack.setTagCompound(nbt);
			if (stack.getItem() == ItemInit.ORIGIN_CHESTPLATE) player.sendMessage(new TextComponentString("\u00A76" + "Something append to your armor... Something godly !"));
		}
	}
	

	@Override
	public ArmorMaterial getArmorMaterial() {
		return this.material;
	}

	@Override
	public void registerModels() {
		Main.proxy.registerItemRenderer(this, 0, "inventory");
	}
}