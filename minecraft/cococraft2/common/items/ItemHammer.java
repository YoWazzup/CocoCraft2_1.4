package cococraft2.common.items;

import net.minecraft.src.CreativeTabs;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
import cococraft2.client.ClientProxy;
import cpw.mods.fml.common.Side;
import cpw.mods.fml.common.asm.SideOnly;

public class ItemHammer extends Item
{
	public ItemHammer(int id)
	{
		super(id);
		this.setMaxDamage(32);
		maxStackSize = 1;
		setCreativeTab(CreativeTabs.tabTools);
	}
	@SideOnly(Side.CLIENT)
	public String getTextureFile()
	{
		return ClientProxy.ItemTex;
	}
	@Override
	public boolean doesContainerItemLeaveCraftingGrid(ItemStack item)
	{
		return false;
	}
}
