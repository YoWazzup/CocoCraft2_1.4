package ferrokev.cococraft2.common.blocks;
/**
 * @author Ferrokev
 */
import net.minecraft.src.Block;
import net.minecraft.src.ItemBlock;
import net.minecraft.src.ItemStack;

public class ItemBlockOreBlock extends ItemBlock
{
  public ItemBlockOreBlock(int i, Block block)
  {
    super(i);
    setHasSubtypes(true);
  }

  public int getMetadata(int meta) {
    return meta;
  }

  public String getItemNameIS(ItemStack item)
  {
    String name = "";

    switch (item.getItemDamage()) {
    case 0:
      name = "cocoBlock"; break;
    case 1:
      name = "mithrilBlock"; break;
    case 2:
      name = "silverBlock"; break;
    case 3:
      name = "amethystBlock"; break;
    case 4:
      name = "superStone"; break;
    case 5:
      name = "coalBlock"; break;
    default:
      name = "cocoBlock";
    }
    return getItemName() + "." + name;
  }
}