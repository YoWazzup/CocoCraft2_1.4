package ferrokev.cococraft2.common.items;
/**
 * @author Ferrokev
 */
import cpw.mods.fml.common.Side;
import cpw.mods.fml.common.asm.SideOnly;
import ferrokev.cococraft2.common.Reference;
import net.minecraft.src.CreativeTabs;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;

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