package com.laz.tirphycraft.gosyn.common.blocks.ground;

import com.laz.tirphycraft.Main;
import com.laz.tirphycraft.init.BlockInit;
import com.laz.tirphycraft.init.ItemInit;
import com.laz.tirphycraft.util.interfaces.IHasModel;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockMud extends Block implements IHasModel{

	public BlockMud() {
		super(Material.GROUND);
		setUnlocalizedName("gosyn_mud");
		setRegistryName("gosyn_mud");
		setCreativeTab(Main.tirphycrafttab);
		
		
		
		this.setHardness(0.5f);
		this.setResistance(2.5f);	
		this.setHarvestLevel("shovel", 0);
		this.setSoundType(SoundType.GROUND);
		
		BlockInit.BLOCKS.add(this);
		ItemInit.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));

	}

	@Override
	public void onEntityWalk(World worldIn, BlockPos pos, Entity entityIn) {
        entityIn.motionX *= 0.6D;
        entityIn.motionZ *= 0.6D;
        super.onEntityWalk(worldIn, pos, entityIn);
	}
	

	@Override
	public void registerModels() {
		Main.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
		
	}
	

}
