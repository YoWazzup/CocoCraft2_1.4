package ferrokev.cococraft2.common.items;
/**
 * @author Ferrokev
 */
import net.minecraft.src.CreativeTabs;
import net.minecraft.src.EnumToolMaterial;
import net.minecraft.src.ItemSpade;
import cpw.mods.fml.common.Side;
import cpw.mods.fml.common.asm.SideOnly;
import ferrokev.cococraft2.common.Reference;

public class ModItemShovel extends ItemSpade
{
  public ModItemShovel(int i, EnumToolMaterial enums)
  {
    super(i, enums);

    setCreativeTab(CreativeTabs.tabTools);
  }
  @SideOnly(Side.CLIENT)
  public String getTextureFile() {
    return Reference.ITEM_SHEET_LOCATION;
  }
}