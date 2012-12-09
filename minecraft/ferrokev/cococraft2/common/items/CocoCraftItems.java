package ferrokev.cococraft2.common.items;
/**
 * @author Ferrokev
 */
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
import net.minecraftforge.common.Configuration;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import ferrokev.cococraft2.common.ConfigurationSettings;
import ferrokev.cococraft2.common.Enums;
import ferrokev.cococraft2.common.Reference;

public class CocoCraftItems
{
	public static GameRegistry gr;
	public static LanguageRegistry lg;

	public static Item ModItem;
	public static Item ItemHammer;
	public static Item ItemEssence;
	public static Item ItemPickaxeCoco;
	public static Item ItemPickaxeMithril;
	public static Item ItemPickaxeSilver;
	public static Item ItemPickaxeAmethyst;
	public static Item ItemAxeCoco;
	public static Item ItemAxeMithril;
	public static Item ItemAxeSilver;
	public static Item ItemAxeAmethyst;
	public static Item ItemShovelCoco;
	public static Item ItemShovelMithril;
	public static Item ItemShovelSilver;
	public static Item ItemShovelAmethyst;
	public static Item ItemSwordCoco;
	public static Item ItemSwordMithril;
	public static Item ItemSwordSilver;
	public static Item ItemSwordAmethyst;
	public static Item ItemHoeCoco;
	public static Item ItemHoeMithril;
	public static Item ItemHoeSilver;
	public static Item ItemHoeAmethyst;

	public static void init()
	{
		ModItem = new ModItem(ConfigurationSettings.ID_MODITEM);
		ItemHammer = new ItemHammer(ConfigurationSettings.ID_HAMMER).setIconCoord(15, 2);
		ItemEssence = new ItemEssence(ConfigurationSettings.ID_ESSENCE);
		
		ItemPickaxeCoco = new ModItemPickaxe(ConfigurationSettings.ID_PICKAXE_COCO, Enums.Coco).setItemName("ItemPickaxeCoco").setIconCoord(0, 1);
		ItemPickaxeMithril = new ModItemPickaxe(ConfigurationSettings.ID_PICKAXE_MITHRIL, Enums.Mithril).setItemName("ItemPickaxeMithril").setIconCoord(5, 1);
		ItemPickaxeSilver = new ModItemPickaxe(ConfigurationSettings.ID_PICKAXE_SILVER, Enums.Silver).setItemName("ItemPickaxeSilver").setIconCoord(10, 1);
		ItemPickaxeAmethyst = new ModItemPickaxe(ConfigurationSettings.ID_PICKAXE_AMETHYST, Enums.Amethyst).setItemName("ItemPickaxeAmethyst").setIconCoord(15, 1);
		
		ItemAxeCoco = new ModItemAxe(ConfigurationSettings.ID_AXE_COCO, Enums.Coco).setItemName("ItemAxeCoco").setIconCoord(1, 1);
		ItemAxeMithril = new ModItemAxe(ConfigurationSettings.ID_AXE_MITHRIL, Enums.Mithril).setItemName("ItemAxeMithril").setIconCoord(6, 1);
		ItemAxeSilver = new ModItemAxe(ConfigurationSettings.ID_AXE_SILVER, Enums.Silver).setItemName("ItemAxeSilver").setIconCoord(11, 1);
		ItemAxeAmethyst = new ModItemAxe(ConfigurationSettings.ID_AXE_AMETHYST, Enums.Amethyst).setItemName("ItemAxeAmethyst").setIconCoord(0, 2);
		
		ItemShovelCoco = new ModItemShovel(ConfigurationSettings.ID_SHOVEL_COCO, Enums.Coco).setItemName("ItemShovelCoco").setIconCoord(2, 1);
		ItemShovelMithril = new ModItemShovel(ConfigurationSettings.ID_SHOVEL_MITHRIL, Enums.Mithril).setItemName("ItemShovelMithril").setIconCoord(7, 1);
		ItemShovelSilver = new ModItemShovel(ConfigurationSettings.ID_SHOVEL_SILVER, Enums.Silver).setItemName("ItemShovelSilver").setIconCoord(12, 1);
		ItemShovelAmethyst = new ModItemShovel(ConfigurationSettings.ID_SHOVEL_AMETHYST, Enums.Amethyst).setItemName("ItemShovelAmethyst").setIconCoord(1, 2);
		
		ItemSwordCoco = new ModItemSword(ConfigurationSettings.ID_SWORD_COCO, Enums.Coco).setItemName("ItemSwordCoco").setIconCoord(3, 1);
		ItemSwordMithril = new ModItemSword(ConfigurationSettings.ID_SWORD_MITHRIL, Enums.Mithril).setItemName("ItemSwordMithril").setIconCoord(8, 1);
		ItemSwordSilver = new ModItemSword(ConfigurationSettings.ID_SWORD_SILVER, Enums.Silver).setItemName("ItemSwordSilver").setIconCoord(13, 1);
		ItemSwordAmethyst = new ModItemSword(ConfigurationSettings.ID_SWORD_AMETHYST, Enums.Amethyst).setItemName("ItemSwordAmethyst").setIconCoord(2, 2);
		
		ItemHoeCoco = new ModItemHoe(ConfigurationSettings.ID_HOE_COCO, Enums.Coco).setItemName("ItemHoeCoco").setIconCoord(4, 1);
		ItemHoeMithril = new ModItemHoe(ConfigurationSettings.ID_HOE_MITHRIL, Enums.Mithril).setItemName("ItemHoeMithril").setIconCoord(9, 1);
		ItemHoeSilver = new ModItemHoe(ConfigurationSettings.ID_HOE_SILVER, Enums.Silver).setItemName("ItemHoeSilver").setIconCoord(14, 1);
		ItemHoeAmethyst = new ModItemHoe(ConfigurationSettings.ID_HOE_AMETHYST, Enums.Amethyst).setItemName("ItemHoeAmethyst").setIconCoord(3, 2);

		ItemHammer.setContainerItem(ItemHammer);

		addName();
	}

	public static void addName() {
		LanguageRegistry.addName(new ItemStack(ModItem, 1, 0), "Coco Ingot");
		LanguageRegistry.addName(new ItemStack(ModItem, 1, 1), "Mithril Ingot");
		LanguageRegistry.addName(new ItemStack(ModItem, 1, 2), "Silver Ingot");
		LanguageRegistry.addName(new ItemStack(ModItem, 1, 3), "Amethyst Gem");
		LanguageRegistry.addName(new ItemStack(ModItem, 1, 4), "Dragonstone Shard");
		LanguageRegistry.addName(new ItemStack(ModItem, 1, 5), "Diamond Stick");
		LanguageRegistry.addName(new ItemStack(ModItem, 1, 6), "Coal Dust");
		LanguageRegistry.addName(new ItemStack(ModItem, 1, 7), "Iron Dust");
		LanguageRegistry.addName(new ItemStack(ModItem, 1, 8), "Gold Dust");
		LanguageRegistry.addName(new ItemStack(ModItem, 1, 9), "Mithril Dust");
		LanguageRegistry.addName(new ItemStack(ModItem, 1, 10), "Silver Dust");
		LanguageRegistry.addName(new ItemStack(ModItem, 1, 11), "Magic Dust");
		LanguageRegistry.addName(new ItemStack(ModItem, 1, 12), "Obsidian Dust");
		LanguageRegistry.addName(new ItemStack(ModItem, 1, 13), "Obsidian Ingot");
		LanguageRegistry.addName(new ItemStack(ModItem, 1, 14), "Unworked Steel");
		LanguageRegistry.addName(new ItemStack(ModItem, 1, 15), "Steel Ingot");

		LanguageRegistry.addName(new ItemStack(ItemEssence, 1, 0), "Fire Essence");
		LanguageRegistry.addName(new ItemStack(ItemEssence, 1, 1), "Water Essence");
		LanguageRegistry.addName(new ItemStack(ItemEssence, 1, 2), "Air Essence");
		LanguageRegistry.addName(new ItemStack(ItemEssence, 1, 3), "Earth Essence");
		LanguageRegistry.addName(new ItemStack(ItemEssence, 1, 4), "Magma Essence");

		LanguageRegistry.addName(ItemHammer, "Hammer");

		LanguageRegistry.addName(ItemPickaxeCoco, "Coco Pickaxe");
		LanguageRegistry.addName(ItemPickaxeMithril, "Mithril Pickaxe");
		LanguageRegistry.addName(ItemPickaxeSilver, "Silver Pickaxe");
		LanguageRegistry.addName(ItemPickaxeAmethyst, "Amethyst Pickaxe");
		LanguageRegistry.addName(ItemAxeCoco, "Coco Axe");
		LanguageRegistry.addName(ItemAxeMithril, "Mithril Axe");
		LanguageRegistry.addName(ItemAxeSilver, "Silver Axe");
		LanguageRegistry.addName(ItemAxeAmethyst, "Amethyst Axe");
		LanguageRegistry.addName(ItemShovelCoco, "Coco Shovel");
		LanguageRegistry.addName(ItemShovelMithril, "Mithril Shovel");
		LanguageRegistry.addName(ItemShovelSilver, "Silver Shovel");
		LanguageRegistry.addName(ItemShovelAmethyst, "Amethyst Shovel");
		LanguageRegistry.addName(ItemSwordCoco, "Coco Sword");
		LanguageRegistry.addName(ItemSwordMithril, "Mithril Sword");
		LanguageRegistry.addName(ItemSwordSilver, "Silver Sword");
		LanguageRegistry.addName(ItemSwordAmethyst, "Amethyst Sword");
		LanguageRegistry.addName(ItemHoeCoco, "Coco Hoe");
		LanguageRegistry.addName(ItemHoeMithril, "Mithril Hoe");
		LanguageRegistry.addName(ItemHoeSilver, "Silver Hoe");
		LanguageRegistry.addName(ItemHoeAmethyst, "Amethyst Hoe");
	}

	@PreInit
	public static void preLoad(FMLPreInitializationEvent event)
	{
		Configuration config = new Configuration(event.getSuggestedConfigurationFile());

		config.load();

		ConfigurationSettings.ID_MODITEM = config.getItem(config.CATEGORY_ITEM, "ID_MODITEM", ConfigurationSettings.ID_MODITEM_DEFAULT).getInt();
		ConfigurationSettings.ID_HAMMER = config.getItem(config.CATEGORY_ITEM ,"ID_HAMMER", ConfigurationSettings.ID_HAMMER_DEFAULT).getInt();
		ConfigurationSettings.ID_ESSENCE = config.getItem(config.CATEGORY_ITEM, "ID_ESSENCE", ConfigurationSettings.ID_ESSENCE_DEFAULT).getInt();

		ConfigurationSettings.ID_PICKAXE_COCO = config.getItem(Reference.CATEGORT_TOOL, "ID_PICKAXE_COCO", ConfigurationSettings.ID_PICKAXE_COCO_DEFAULT).getInt();
		ConfigurationSettings.ID_AXE_COCO = config.getItem(Reference.CATEGORT_TOOL, "ID_AXE_COCO", ConfigurationSettings.ID_AXE_COCO_DEFAULT).getInt();
		ConfigurationSettings.ID_SHOVEL_COCO = config.getItem(Reference.CATEGORT_TOOL, "ID_SHOVEL_COCO", ConfigurationSettings.ID_SHOVEL_COCO_DEFAULT).getInt();
		ConfigurationSettings.ID_SWORD_COCO = config.getItem(Reference.CATEGORT_TOOL, "ID_SWORD_COCO", ConfigurationSettings.ID_SWORD_COCO_DEFAULT).getInt();
		ConfigurationSettings.ID_HOE_COCO = config.getItem(Reference.CATEGORT_TOOL, "ID_HOE_COCO", ConfigurationSettings.ID_HOE_COCO_DEFAULT).getInt();

		ConfigurationSettings.ID_PICKAXE_MITHRIL = config.getItem(Reference.CATEGORT_TOOL, "ID_PICKAXE_MITHRIL", ConfigurationSettings.ID_PICKAXE_MITHRIL_DEFAULT).getInt();
		ConfigurationSettings.ID_AXE_MITHRIL = config.getItem(Reference.CATEGORT_TOOL, "ID_AXE_MITHRIL", ConfigurationSettings.ID_AXE_MITHRIL_DEFAULT).getInt();
		ConfigurationSettings.ID_SHOVEL_MITHRIL = config.getItem(Reference.CATEGORT_TOOL, "ID_SHOVEL_MITHRIL", ConfigurationSettings.ID_SHOVEL_MITHRIL_DEFAULT).getInt();
		ConfigurationSettings.ID_SWORD_MITHRIL = config.getItem(Reference.CATEGORT_TOOL, "ID_SWORD_MITHRIL", ConfigurationSettings.ID_SWORD_MITHRIL_DEFAULT).getInt();
		ConfigurationSettings.ID_HOE_MITHRIL = config.getItem(Reference.CATEGORT_TOOL, "ID_HOE_MITHRIL", ConfigurationSettings.ID_HOE_MITHRIL_DEFAULT).getInt();
		
		ConfigurationSettings.ID_PICKAXE_SILVER = config.getItem(Reference.CATEGORT_TOOL, "ID_PICKAXE_SILVER", ConfigurationSettings.ID_PICKAXE_SILVER_DEFAULT).getInt();
		ConfigurationSettings.ID_AXE_SILVER = config.getItem(Reference.CATEGORT_TOOL, "ID_AXE_SILVER", ConfigurationSettings.ID_AXE_SILVER_DEFAULT).getInt();
		ConfigurationSettings.ID_SHOVEL_SILVER = config.getItem(Reference.CATEGORT_TOOL, "ID_SHOVEL_SILVER", ConfigurationSettings.ID_SHOVEL_SILVER_DEFAULT).getInt();
		ConfigurationSettings.ID_SWORD_SILVER = config.getItem(Reference.CATEGORT_TOOL, "ID_SWORD_SILVER", ConfigurationSettings.ID_SWORD_SILVER_DEFAULT).getInt();
		ConfigurationSettings.ID_HOE_SILVER = config.getItem(Reference.CATEGORT_TOOL, "ID_HOE_SILVER", ConfigurationSettings.ID_HOE_SILVER_DEFAULT).getInt();
		
		ConfigurationSettings.ID_PICKAXE_AMETHYST = config.getItem(Reference.CATEGORT_TOOL, "ID_PICKAXE_AMETHYST", ConfigurationSettings.ID_PICKAXE_AMETHYST_DEFAULT).getInt();
		ConfigurationSettings.ID_AXE_AMETHYST = config.getItem(Reference.CATEGORT_TOOL, "ID_AXE_AMETHYST", ConfigurationSettings.ID_AXE_AMETHYST_DEFAULT).getInt();
		ConfigurationSettings.ID_SHOVEL_AMETHYST = config.getItem(Reference.CATEGORT_TOOL, "ID_SHOVEL_AMETHYST", ConfigurationSettings.ID_SHOVEL_AMETHYST_DEFAULT).getInt();
		ConfigurationSettings.ID_SWORD_AMETHYST = config.getItem(Reference.CATEGORT_TOOL, "ID_SWORD_AMETHYST", ConfigurationSettings.ID_SWORD_AMETHYST_DEFAULT).getInt();
		ConfigurationSettings.ID_HOE_AMETHYST = config.getItem(Reference.CATEGORT_TOOL, "ID_HOE_AMETHYST", ConfigurationSettings.ID_HOE_AMETHYST_DEFAULT).getInt();



		config.save();
	}
}