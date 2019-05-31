package com.laz.tirphycraft.objects.blocks.machine.alloy;

import com.laz.tirphycraft.util.Reference;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;

public class GuiAlloyFurnace extends GuiContainer{

	private static final ResourceLocation TEXTURES = new ResourceLocation(Reference.MOD_ID + ":textures/gui/alloy_furnace.png");
	private final InventoryPlayer player;
	private final TileEntityAlloyFurnace tileentity;
	
	public GuiAlloyFurnace(InventoryPlayer player, TileEntityAlloyFurnace tileentity) {
		
		super(new ContainerAlloyFurnace(player, tileentity));
		this.player = player;
		this.tileentity = tileentity;
		
	}
	
	@Override
	protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
		String tilename = this.tileentity.getDisplayName().getUnformattedComponentText();
		this.fontRenderer.drawString(tilename, (this.xSize / 2 - this.fontRenderer.getStringWidth(tilename) / 2) + 3, 8, 4210752);
		this.fontRenderer.drawString(this.player.getDisplayName().getUnformattedComponentText(),122, this.ySize - 96 +2, 4210752);
		
	}
	
	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
		GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
		this.mc.getTextureManager().bindTexture(TEXTURES);
		this.drawTexturedModalRect(this.guiLeft, this.guiTop, 0, 0, this.xSize, this.ySize);
		
		if (TileEntityAlloyFurnace.isBurning(tileentity)) {
			int k = this.getBurnLeftScaled(13);
			this.drawTexturedModalRect(this.guiLeft + 61, this.guiTop + 61 + 12 - k, 176, 12 - k , 14, k + 1);
			this.drawTexturedModalRect(this.guiLeft + 101, this.guiTop + 61 + 12 - k, 176, 12 - k , 14, k + 1);			
		}
		
	}
	
	private int getBurnLeftScaled(int pixels)
	{
		int i = this.tileentity.getField(1);
		if(i == 0) i = 1200;
		return this.tileentity.getField(0) * pixels / i;
	}
	
	private int getCookProgressScaled(int pixels)
	{
		int i = this.tileentity.getField(2);
		int j = this.tileentity.getField(3);
		return j != 0 && i != 0 ? i * pixels / j : 0;
	}
}
