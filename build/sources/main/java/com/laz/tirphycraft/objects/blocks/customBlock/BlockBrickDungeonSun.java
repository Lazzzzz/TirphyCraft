package com.laz.tirphycraft.objects.blocks.customBlock;

import com.laz.tirphycraft.objects.base.BlockBase;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class BlockBrickDungeonSun extends BlockBase {

	public BlockBrickDungeonSun() {
		super("brick_dungeon_sun", Material.ROCK, 3, 15, "pickaxe", 3, SoundType.STONE);
		this.setLightLevel(0.4F);
		this.setBlockUnbreakable();
	}

}