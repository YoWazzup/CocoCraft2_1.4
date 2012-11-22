package cococraft2.common.items;

import net.minecraft.src.CreativeTabs;
import net.minecraft.src.Item;
import cococraft2.client.ClientProxy;
import cpw.mods.fml.common.Side;
import cpw.mods.fml.common.asm.SideOnly;


public class ModItem extends Item{

	protected ModItem(int par1) {
		super(par1);
		setCreativeTab(CreativeTabs.tabMaterials);
	}
	@SideOnly(Side.CLIENT)
	public String getTextureFile()
	{
		return ClientProxy.ItemTex;
	}

}
