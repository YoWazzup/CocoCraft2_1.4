package ferrokev.cococraft2.client.machine;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;

import org.lwjgl.opengl.GL11;

import ferrokev.cococraft2.common.Reference;
import ferrokev.cococraft2.common.machine.ContainerBlastFurnace;
import ferrokev.cococraft2.common.machine.TileEntityBlastFurnace;

public class GuiBlastFurnace extends GuiContainer {

	private TileEntityBlastFurnace tile;

	public GuiBlastFurnace(InventoryPlayer inv, TileEntityBlastFurnace tile) {
		super(new ContainerBlastFurnace(inv, tile));
		this.tile = tile;
	}

	protected void drawGuiContainerForegroundLayer(int i, int j) {
		fontRenderer.drawString("Blast Furnace", 60, 6, 0x404040);
		fontRenderer.drawString("Inventory", 8, (ySize - 96) + 2, 0x404040);
	}

	protected void drawGuiContainerBackgroundLayer(float f, int i, int j) {
		int tex = mc.renderEngine.getTexture((Reference.GUI_TEXTURE_LOCATION + "BlastFurnace.png"));
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		mc.renderEngine.bindTexture(tex);
		int l = (width - xSize) / 2;
		int i1 = (height - ySize) / 2;
		drawTexturedModalRect(l, i1, 0, 0, xSize, ySize);

		if (tile.isBurning())
        {
            int j1 = tile.getBurnTimeRemainingScaled(12);
            drawTexturedModalRect(l + 46, (i1 + 36 + 12) - j1, 176, 12 - j1, 14, j1 + 2);
        }
        int k1 = tile.getCookProgressScaled(24);
        drawTexturedModalRect(l + 79, i1 + 34, 176, 14, k1 + 1, 16);
    }

}
