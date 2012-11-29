package ferrokev.cococraft2.common;
/**
 * @author Ferrokev
 */
import net.minecraft.src.EnumArmorMaterial;
import net.minecraft.src.EnumToolMaterial;
import net.minecraftforge.common.EnumHelper;

public class Enums
{
  public static EnumToolMaterial Coco = EnumHelper.addToolMaterial("COCO", 2, 2500, 15.0F, 13, 8);
  public static EnumToolMaterial Mithril = EnumHelper.addToolMaterial("MITHRIL", 2, 650, 9.0F, 7, 4);
  public static EnumToolMaterial Silver = EnumHelper.addToolMaterial("SILVER", 2, 451, 7.0F, 8, 3);
  public static EnumToolMaterial Amethyst = EnumHelper.addToolMaterial("AMETHYSY", 2, 3334, 15.0F, 15, 12);
  public static EnumToolMaterial Steel = EnumHelper.addToolMaterial("STEEL", 2, 998, 7.0F, 8, 16);
  public static EnumToolMaterial DragonStone = EnumHelper.addToolMaterial("DRAGON", 2, 4734, 9.0F, 8, 16);
  public static EnumToolMaterial Obsidian = EnumHelper.addToolMaterial("OBSIDIAN", 2, 2012, 10.0F, 7, 2);

  public static EnumArmorMaterial COCO = EnumHelper.addArmorMaterial("COCO", 48, new int[] { 4, 8, 6, 2 }, 4);
  public static EnumArmorMaterial MITHRIL = EnumHelper.addArmorMaterial("MITHRIL", 22, new int[] { 2, 5, 4, 2 }, 5);
  public static EnumArmorMaterial SILVER = EnumHelper.addArmorMaterial("SILVER", 26, new int[] { 3, 6, 5, 3 }, 5);
  public static EnumArmorMaterial AMETHYST = EnumHelper.addArmorMaterial("AMETHYST", 36, new int[] { 3, 6, 6, 2 }, 5);
}