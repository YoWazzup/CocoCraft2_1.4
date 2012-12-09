package ferrokev.cococraft2.client.machine;

import net.minecraft.src.GuiContainer;
import net.minecraft.src.InventoryPlayer;
import net.minecraft.src.StatCollector;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.common.Side;
import cpw.mods.fml.common.asm.SideOnly;
import ferrokev.cococraft2.common.Reference;
import ferrokev.cococraft2.common.machine.ContainerCompressor;
import ferrokev.cococraft2.common.machine.TileEntityCompressor;

@SideOnly(Side.CLIENT)
public class GuiCompressor extends GuiContainer
{
    private TileEntityCompressor compressorInventory;

    public GuiCompressor(InventoryPlayer inv, TileEntityCompressor tile)
    {
        super(new ContainerCompressor(inv, tile));
        compressorInventory = tile;
    }

    /**
     * Draw the foreground layer for the GuiContainer (everything in front of the items)
     */
    protected void drawGuiContainerForegroundLayer(int i, int j)
    {
        fontRenderer.drawString(StatCollector.translateToLocal("Compressor"), 60, 6, 4210752);
        fontRenderer.drawString(StatCollector.translateToLocal("container.inventory"), 8, ySize - 96 + 2, 4210752);
    }

    /**
     * Draw the background layer for the GuiContainer (everything behind the items)
     */
    protected void drawGuiContainerBackgroundLayer(float f, int i, int j)
    {
        int getTexture = mc.renderEngine.getTexture(Reference.GUI_TEXTURE_LOCATION + "Compressor.png");
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        mc.renderEngine.bindTexture(getTexture);
        int widthGui = (width - xSize) / 2;
        int heightGui = (height - ySize) / 2;
        drawTexturedModalRect(widthGui, heightGui, 0, 0, xSize, ySize);
        int var7;

        if (compressorInventory.isBurning())
        {
            var7 = compressorInventory.getBurnTimeRemainingScaled(12);
            drawTexturedModalRect(widthGui + 56, heightGui + 36 + 12 - var7, 176, 12 - var7, 14, var7 + 2);
        }

        var7 = compressorInventory.getCookProgressScaled(24);
        drawTexturedModalRect(widthGui + 79, heightGui + 34, 176, 14, var7 + 1, 16);
    }
}
