package com.laz.tirphycraft.objects.blocks.basicBlock;

import com.laz.tirphycraft.objects.base.BlockBase;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class BlockBrickDungeon extends BlockBase {

	public BlockBrickDungeon() {
		super("brick_dungeon", Material.ROCK, 3, 15, "pickaxe", 3, SoundType.STONE);
		this.setBlockUnbreakable();
	}

}