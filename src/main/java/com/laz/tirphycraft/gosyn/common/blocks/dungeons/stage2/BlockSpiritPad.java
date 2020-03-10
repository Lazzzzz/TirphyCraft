package com.laz.tirphycraft.gosyn.common.blocks.dungeons.stage2;

import com.laz.tirphycraft.Main;
import com.laz.tirphycraft.init.BlockInit;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class BlockSpiritPad extends Block{
	public BlockSpiritPad() {
		super(Material.ROCK);
		setUnlocalizedName("spirit_pad");
		setRegistryName("spirit_pad");
		setCreativeTab(Main.tirphycrafttab);
		
		
		this.setBlockUnbreakable();
		this.setSoundType(SoundType.STONE);
		
		BlockInit.BLOCKS.add(this);
	}
	
}
