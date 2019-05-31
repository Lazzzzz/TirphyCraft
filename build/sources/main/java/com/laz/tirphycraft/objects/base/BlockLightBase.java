package com.laz.tirphycraft.objects.base;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class BlockLightBase extends BlockBase {
	
	public BlockLightBase(String name, Material material, float hard, float resist, String type, int i, SoundType sound, float light) {
		super(name, material, hard, resist, type, i , sound);
			this.setLightLevel(light);

			
	}
}
