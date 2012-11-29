package ferrokev.cococraft2.common.blocks;
/**
 * @author Ferrokev
 */
import net.minecraft.src.Block;
import net.minecraft.src.ItemBlock;
import net.minecraft.src.ItemStack;

public class ItemBlockOre extends ItemBlock
{
  public ItemBlockOre(int i, Block block)
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
      name = "cocoStone"; break;
    case 1:
      name = "mithrilOre"; break;
    case 2:
      name = "silverOre"; break;
    case 3:
      name = "amethystOre"; break;
    default:
      name = "cocoStone";
    }
    return getItemName() + "." + name;
  }
}