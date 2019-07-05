package com.laz.tirphycraft.util.handlers;


import com.laz.tirphycraft.objects.blocks.machine.alloy.ContainerAlloyFurnace;
import com.laz.tirphycraft.objects.blocks.machine.alloy.GuiAlloyFurnace;
import com.laz.tirphycraft.objects.blocks.machine.alloy.TileEntityAlloyFurnace;
import com.laz.tirphycraft.objects.blocks.machine.pyrodes.ContainerPyrodesFurnace;
import com.laz.tirphycraft.objects.blocks.machine.pyrodes.GuiPyrodesFurnace;
import com.laz.tirphycraft.objects.blocks.machine.pyrodes.TileEntityPyrodesFurnace;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler{
	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		
		if (ID == ConfigHandler.GUI_PYRODES_FURNACE) return new ContainerPyrodesFurnace(player.inventory, (TileEntityPyrodesFurnace)world.getTileEntity(new BlockPos(x,y,z)));
		if (ID == ConfigHandler.GUI_ALLOY_FURNACE) return new ContainerAlloyFurnace(player.inventory, (TileEntityAlloyFurnace)world.getTileEntity(new BlockPos(x,y,z)));	
		return null;
	}
	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		if (ID == ConfigHandler.GUI_PYRODES_FURNACE) return new GuiPyrodesFurnace(player.inventory, (TileEntityPyrodesFurnace)world.getTileEntity(new BlockPos(x,y,z)));
		if (ID == ConfigHandler.GUI_ALLOY_FURNACE) return new GuiAlloyFurnace(player.inventory, (TileEntityAlloyFurnace)world.getTileEntity(new BlockPos(x,y,z)));
		return null;
	}

	
}
