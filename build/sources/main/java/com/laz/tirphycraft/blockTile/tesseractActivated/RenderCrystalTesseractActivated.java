package com.laz.tirphycraft.blockTile.tesseractActivated;

import org.lwjgl.opengl.GL11;

import com.laz.tirphycraft.blockTile.model.ModelCrystalTesseract;
import com.laz.tirphycraft.util.Reference;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderCrystalTesseractActivated extends TileEntitySpecialRenderer<TileEntityCrystalTesseractActivated> {
	private static final ResourceLocation TEXTURE        = new ResourceLocation(Reference.MOD_ID + ":textures/blocks/tesseractactivated.png");
	private static final ModelCrystalTesseract MODEL     = new ModelCrystalTesseract();
	public double counter = 0;
	
	@Override
	public void render(TileEntityCrystalTesseractActivated te, double x, double y, double z, float partialTicks,	int destroyStage, float alpha) {
		GL11.glPushMatrix();
		GL11.glTranslated(x + 0.5D, y + 1.5D, z + 0.5D);
		GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
		this.bindTexture(TEXTURE);
		counter += 0.1f;
		MODEL.shape1.rotationPointY += Math.cos(counter / 10) / 10 ;
		MODEL.shape1.rotateAngleX += 0.01f;
		MODEL.shape1.rotateAngleY += 0.01f;
		MODEL.shape1.rotateAngleZ += 0.01f;
		MODEL.renderAll();
		GL11.glPopMatrix();
	}
}
