package cococraft2.common.items;

import net.minecraft.src.CreativeTabs;
import net.minecraft.src.EnumToolMaterial;
import net.minecraft.src.ItemPickaxe;
import cococraft2.client.ClientProxy;
import cpw.mods.fml.common.Side;
import cpw.mods.fml.common.asm.SideOnly;

public class ModPickaxe extends ItemPickaxe
{
	public ModPickaxe(int i, EnumToolMaterial tool) 
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
