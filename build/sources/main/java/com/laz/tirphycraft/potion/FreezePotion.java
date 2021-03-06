package com.laz.tirphycraft.potion;

import com.laz.tirphycraft.util.Reference;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.potion.Potion;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;

public class FreezePotion extends Potion {

	public FreezePotion() {
		super(true, 6856143);
		setPotionName("freeze");
		setIconIndex(0, 0);
		setRegistryName(new ResourceLocation(Reference.MOD_ID + ": freeze"));
		this.registerPotionAttributeModifier(SharedMonsterAttributes.MOVEMENT_SPEED, MathHelper.getRandomUUID().toString(), -0.15000000596046448D, 2);
	}
	@Override
	public boolean hasStatusIcon() {
		Minecraft.getMinecraft().getTextureManager().bindTexture(new ResourceLocation(Reference.MOD_ID + ":textures/gui/potion_effects.png"));
		return true;
	}

}
