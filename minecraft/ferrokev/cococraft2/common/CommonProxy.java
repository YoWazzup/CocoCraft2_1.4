package ferrokev.cococraft2.common;
/**
 * @author Ferrokev
 */
import cpw.mods.fml.common.network.IGuiHandler;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.World;

public class CommonProxy implements IGuiHandler {

	public void renderStuffs()
	{

	}

	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
	{
		return null;
	}

	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
	{
		return null;
	}
}