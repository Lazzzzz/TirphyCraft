package com.laz.tirphycraft.objects.base;

import com.laz.tirphycraft.util.interfaces.IHasModel;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;

public class BlockPlanksBase extends BlockBase implements IHasModel
{
	public BlockPlanksBase(String name)
	{
		super(name, Material.WOOD, 2, 2, "axe", 1, SoundType.WOOD);
		setSoundType(SoundType.WOOD);
		Blocks.FIRE.setFireInfo(this, 5, 5);
		this.setHarvestLevel("axe", 1);
				
	}
	
}