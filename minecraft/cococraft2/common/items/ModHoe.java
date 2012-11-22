package cococraft2.common.items;

import net.minecraft.src.CreativeTabs;
import net.minecraft.src.EnumToolMaterial;
import net.minecraft.src.ItemHoe;
import cococraft2.client.ClientProxy;
import cpw.mods.fml.common.Side;
import cpw.mods.fml.common.asm.SideOnly;

public class ModHoe extends ItemHoe
{
	public ModHoe(int i, EnumToolMaterial tool) 
	{
		super(i, tool);
		setCreativeTab(CreativeTabs.tabTools);
	}
	@SideOnly(Side.CLIENT)
	public String getTextureFile()
	{
		return ClientProxy.ItemTex;
	}
}
