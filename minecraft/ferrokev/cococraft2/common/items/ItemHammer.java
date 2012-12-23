package ferrokev.cococraft2.common.items;
/**
 * @author Ferrokev
 */
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import ferrokev.cococraft2.common.Reference;

public class ItemHammer extends Item
{
	public ItemHammer(int i)
	{
		super(i);
		setMaxStackSize(1);
		setItemName("ItemHammer");
		setCreativeTab(CreativeTabs.tabTools);
	}

	@SideOnly(Side.CLIENT)
	public String getTextureFile() {
		return Reference.ITEM_SHEET_LOCATION;
	}

	public boolean doesContainerItemLeaveCraftingGrid(ItemStack i)
	{
		return false;
	}
}