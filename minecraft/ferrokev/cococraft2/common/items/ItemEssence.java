package ferrokev.cococraft2.common.items;
/**
 * @author Ferrokev
 */
import java.util.List;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import ferrokev.cococraft2.common.Reference;

public class ItemEssence extends Item
{
	public ItemEssence(int i)
	{
		super(i);
		setCreativeTab(CreativeTabs.tabMisc);
		setHasSubtypes(true);
	}

	@SideOnly(Side.CLIENT)
	public String getTextureFile() {
		return Reference.ITEM_SHEET_LOCATION;
	}

	@SideOnly(Side.CLIENT)
	public int getIconFromDamage(int i)
	{
		switch (i) {
		case 0:
			return 82;
		case 1:
			return 83;
		case 2:
			return 84;
		case 3:
			return 81;

		}return 82;
	}

	public int getMetadata(int i)
	{
		return i;
	}

	public String getItemNameIS(ItemStack i)
	{
		switch (i.getItemDamage()) { 
		case 0:
			return "FireEssence";
		case 1:
			return "WaterEssence";
		case 2:
			return "AirEssence";
		case 3:
			return "EarthEssence";
		}
		return "FireEssence";
	}

	@SideOnly(Side.CLIENT)
	public void getSubItems(int i, CreativeTabs tab, List list)
	{
		for (int j = 0; j < 4; j++)
		{
			list.add(new ItemStack(i, 1, j));
		}
	}
}