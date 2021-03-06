package ferrokev.cococraft2.common.items;
/**
 * @author Ferrokev
 */
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemHoe;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import ferrokev.cococraft2.common.Reference;

public class ModItemHoe extends ItemHoe
{
  public ModItemHoe(int i, EnumToolMaterial enums)
  {
    super(i, enums);

    setCreativeTab(CreativeTabs.tabTools);
  }
  @SideOnly(Side.CLIENT)
  public String getTextureFile() {
    return Reference.ITEM_SHEET_LOCATION;
  }
}