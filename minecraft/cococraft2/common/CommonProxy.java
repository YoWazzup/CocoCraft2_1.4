package cococraft2.common;

import net.minecraft.src.EntityPlayer;
import net.minecraft.src.TileEntity;
import net.minecraft.src.World;
import net.minecraftforge.client.MinecraftForgeClient;
import cococraft2.client.machine.GuiBlastFurnace;
import cococraft2.client.machine.GuiCompressor;
import cococraft2.client.machine.GuiCrusher;
import cococraft2.common.machine.ContainerBlastFurnace;
import cococraft2.common.machine.ContainerCompressor;
import cococraft2.common.machine.ContainerCrusher;
import cococraft2.common.machine.TileEntityBlastFurnace;
import cococraft2.common.machine.TileEntityCompressor;
import cococraft2.common.machine.TileEntityCrusher;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.network.IGuiHandler;

public class CommonProxy implements IGuiHandler
{

	public void registerRenderThings() {

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
			case 7: return new ContainerBlastFurnace(player.inventory, ((TileEntityBlastFurnace)tileEntity));

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
			case 7: return new GuiBlastFurnace(player.inventory, ((TileEntityBlastFurnace)tileEntity));

			}

		}
		return null;
	}



}
