package ferrokev.cococraft2.common;
/**
 * @author Ferrokev
 */
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.TileEntity;
import net.minecraft.src.World;
import cpw.mods.fml.common.network.IGuiHandler;
import ferrokev.cococraft2.client.machine.GuiCompressor;
import ferrokev.cococraft2.client.machine.GuiCrusher;
import ferrokev.cococraft2.common.machine.ContainerCompressor;
import ferrokev.cococraft2.common.machine.ContainerCrusher;
import ferrokev.cococraft2.common.machine.TileEntityCompressor;
import ferrokev.cococraft2.common.machine.TileEntityCrusher;

public class CommonProxy implements IGuiHandler {

	public void renderStuffs()
	{

	}

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) 
	{

		TileEntity tileEntity = world.getBlockTileEntity(x, y, z);

		if (tileEntity != null)
		{
			switch(ID)
			{
			case 5: return new ContainerCrusher(player.inventory, ((TileEntityCrusher)tileEntity));
			case 6: return new ContainerCompressor(player.inventory, ((TileEntityCompressor)tileEntity));
			}			
		}

		return null;

	}
	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
	{
		TileEntity tileEntity = world.getBlockTileEntity(x, y, z);

		if (tileEntity != null)
		{
			switch(ID)
			{
			case 5: return new GuiCrusher(player.inventory, ((TileEntityCrusher)tileEntity));
			case 6: return new GuiCompressor(player.inventory, ((TileEntityCompressor)tileEntity));
			}

		}
		return null;
	}

}