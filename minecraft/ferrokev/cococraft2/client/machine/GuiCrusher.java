package ferrokev.cococraft2.client.machine;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.StatCollector;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import ferrokev.cococraft2.common.Reference;
import ferrokev.cococraft2.common.machine.ContainerCrusher;
import ferrokev.cococraft2.common.machine.TileEntityCrusher;

@SideOnly(Side.CLIENT)
public class GuiCrusher extends GuiContainer
{
    private TileEntityCrusher crusherInventory;

    public GuiCrusher(InventoryPlayer inv, TileEntityCrusher tile)
    {
        super(new ContainerCrusher(inv, tile));
        crusherInventory = tile;
    }

    /**
     * Draw the foreground layer for the GuiContainer (everything in front of the items)
     */
    protected void drawGuiContainerForegroundLayer(int i, int j)
    {
        fontRenderer.drawString(StatCollector.translateToLocal("Crusher"), 60, 6, 4210752);
        fontRenderer.drawString(StatCollector.translateToLocal("container.inventory"), 8, ySize - 96 + 2, 4210752);
    }

    /**
     * Draw the background layer for the GuiContainer (everything behind the items)
     */
    protected void drawGuiContainerBackgroundLayer(float f, int i, int j)
    {
        int getTexture = mc.renderEngine.getTexture(Reference.GUI_TEXTURE_LOCATION + "Crusher.png");
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        mc.renderEngine.bindTexture(getTexture);
        int widthGui = (width - xSize) / 2;
        int heightGui = (height - ySize) / 2;
        drawTexturedModalRect(widthGui, heightGui, 0, 0, xSize, ySize);
        int var7;

        if (crusherInventory.isBurning())
        {
            var7 = crusherInventory.getBurnTimeRemainingScaled(12);
            drawTexturedModalRect(widthGui + 56, heightGui + 36 + 12 - var7, 176, 12 - var7, 14, var7 + 2);
        }

        var7 = crusherInventory.getCookProgressScaled(24);
        drawTexturedModalRect(widthGui + 79, heightGui + 34, 176, 14, var7 + 1, 16);
    }
}
