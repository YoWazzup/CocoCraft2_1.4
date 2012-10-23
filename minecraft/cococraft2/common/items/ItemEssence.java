package cococraft2.common.items;

import java.util.List;

import cococraft2.common.CommonProxy;
import net.minecraft.src.CreativeTabs;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
import cpw.mods.fml.common.Side;
import cpw.mods.fml.common.asm.SideOnly;

public class ItemEssence extends Item
{
	public ItemEssence(int i) 
	{
		super(i);
		setCreativeTab(CreativeTabs.tabTools);
		setHasSubtypes(true);
	}
	public String getTextureFile()
	{
		return CommonProxy.ItemTex;
	}
	@SideOnly(Side.CLIENT)
	public int getIconFromDamage(int i)
	{
		switch(i)
		{
			case 0 : return 82;
			case 1 : return 83;
			case 2 : return 84;
			case 3 : return 81;
			default : return 82;
		}
	}
	public int getMetadata(int i)
	{
		return i;
	}

	public String getItemNameIS(ItemStack i)
	{
		switch(i.getItemDamage()){
		case 0: return "FireEssence";
		case 1: return "WaterEssence";
		case 2: return "AirEssence";
		case 3: return "EarthEssence";
		default : return "FireEssence";

		}
	}
	@SideOnly(Side.CLIENT)
	public void getSubItems(int i, CreativeTabs tab, List list)
	{
		for(int j=0;j < 4; j++)
		{
			list.add(new ItemStack(i, 1, j));
		}		
	}
}
