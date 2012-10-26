package cococraft2.common.items;

import java.io.File;

import cococraft2.common.CocoCraft2;
import net.minecraft.client.Minecraft;
import net.minecraft.src.EnumArmorMaterial;
import net.minecraft.src.EnumToolMaterial;
import net.minecraft.src.Item;
import net.minecraft.src.ItemReed;
import net.minecraft.src.ItemStack;
import net.minecraft.src.ModLoader;
import net.minecraftforge.common.Configuration;
import net.minecraftforge.common.EnumHelper;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class CocoCraftItems 
{
	static Configuration config = new Configuration(new File(Minecraft.getMinecraftDir(), "/CocoCraft2/CocoCraft2Items.cfg"));


	//Sets Item IDs	
	public static int IngotsID;
	public static int CocoPickaxeID, CocoAxeID, CocoShovelID, CocoSwordID, CocoHoeID = configProperties(config);
	public static int MithrilPickaxeID, MithrilAxeID, MithrilShovelID, MithrilSwordID, MithrilHoeID;
	public static int SilverPickaxeID, SilverAxeID, SilverShovelID, SilverSwordID,SilverHoeID;
	public static int SteelPickaxeID, SteelAxeID, SteelShovelID, SteelSwordID,SteelHoeID;
	public static int DragonStonePickaxeID, DragonStoneAxeID, DragonStoneShovelID, DragonStoneSwordID,DragonStoneHoeID;
	
	public static int CocoHelmetID ,CocoChestID, CocoLegsID, CocoBootsID;
	public static int MithrilHelmetID ,MithrilChestID, MithrilLegsID, MithrilBootsID;
	public static int SilverHelmetID ,SilverChestID, SilverLegsID, SilverBootsID;
	public static int AmethystHelmetID ,AmethystChestID, AmethystLegsID, AmethystBootsID;
	
	public static int HammerID;
	public static int EssenceID;
	public static int ObsidianMultiToolID;
	

	//Instances for the items
	public static Item CocoPickaxe, CocoAxe, CocoShovel, CocoSword, CocoHoe;
	public static Item MithrilPickaxe, MithrilAxe, MithrilShovel, MithrilSword, MithrilHoe;
	public static Item SilverPickaxe, SilverAxe, SilverShovel, SilverSword, SilverHoe;
	public static Item CocoHelmet, CocoChest, CocoLegs, CocoBoots;
	public static Item MithrilHelmet, MithrilChest, MithrilLegs, MithrilBoots;
	public static Item SilverHelmet, SilverChest, SilverLegs, SilverBoots;
	public static Item AmethystHelmet, AmethystChest, AmethystLegs, AmethystBoots;

	
	public static Item Ingots;
	public static Item Hammer, ItemBookTime;
	public static Item SteelPickaxe, SteelAxe, SteelShovel, SteelSword, SteelHoe;
	public static Item Essence;
	public static Item DragonStonePickaxe, DragonStoneAxe, DragonStoneShovel, DragonStoneSword, DragonStoneHoe;
	public static Item ObsidianMultiTool;
	
	//Shortened shit
	public static GameRegistry gr;
	public static LanguageRegistry lg;
	public static CocoCraft2 cc2;


	public static void init()
	{
		//inits the items
		Ingots = new ItemIngot(IngotsID).setItemName("Ingots");
		Hammer = new ItemHammer(HammerID).setItemName("Hammer").setIconCoord(15, 2);
		
		CocoPickaxe = new ModPickaxe(CocoPickaxeID, cc2.Coco).setItemName("CocoPickaxe").setIconCoord(0,1);
		CocoAxe = new ModAxe(CocoAxeID, cc2.Coco).setItemName("CocoAxe").setIconCoord(1,1);
		CocoShovel = new ModShovel(CocoShovelID, cc2.Coco).setItemName("CocoShovel").setIconCoord(2,1);
		CocoSword = new ModSword(CocoSwordID, cc2.Coco).setItemName("CocoSword").setIconCoord(3,1);
		CocoHoe = new ModHoe(CocoHoeID, cc2.Coco).setItemName("CocoHoe").setIconCoord(4,1);

		MithrilPickaxe = new ModPickaxe(MithrilPickaxeID, cc2.Mithril).setItemName("MithrilPickaxe").setIconCoord(5,1);
		MithrilAxe = new ModAxe(MithrilAxeID, cc2.Mithril).setItemName("MithrilAxe").setIconCoord(6,1);
		MithrilShovel = new ModShovel(MithrilShovelID, cc2.Mithril).setItemName("MithrilShovel").setIconCoord(7,1);
		MithrilSword = new ModSword(MithrilSwordID, cc2.Mithril).setItemName("MithrilSword").setIconCoord(8,1);
		MithrilHoe = new ModHoe(MithrilHoeID, cc2.Mithril).setItemName("MithrilHoe").setIconCoord(9,1);

		SilverPickaxe = new ModPickaxe(SilverPickaxeID, cc2.Silver).setItemName("SilverPickaxe").setIconCoord(10,1);
		SilverAxe = new ModAxe(SilverAxeID, cc2.Silver).setItemName("SilverAxe").setIconCoord(11,1);
		SilverShovel = new ModShovel(SilverShovelID, cc2.Silver).setItemName("SilverShovel").setIconCoord(12,1);
		SilverSword = new ModSword(SilverSwordID, cc2.Silver).setItemName("SilverSword").setIconCoord(13,1);
		SilverHoe = new ModHoe(SilverHoeID, cc2.Silver).setItemName("SilverHoe").setIconCoord(14,1);

		SteelPickaxe = new ModPickaxe(SteelPickaxeID, cc2.Steel).setItemName("SteelPickaxe").setIconCoord(9,2);
		SteelAxe = new ModAxe(SteelAxeID, cc2.Steel).setItemName("SteelAxe").setIconCoord(10,2);
		SteelShovel = new ModShovel(SteelShovelID, cc2.Steel).setItemName("SteelShovel").setIconCoord(11,2);
		SteelSword = new ModSword(SteelSwordID, cc2.Steel).setItemName("SteelSword").setIconCoord(12,2);
		SteelHoe = new ModHoe(SteelHoeID, cc2.Steel).setItemName("SteelHoe").setIconCoord(13,2);

		DragonStonePickaxe = new ModPickaxe(DragonStonePickaxeID, cc2.DragonStone).setItemName("DragonStonePickaxe").setIconCoord(4,2);
		DragonStoneAxe = new ModAxe(DragonStoneAxeID, cc2.DragonStone).setItemName("DragonStoneAxe").setIconCoord(5,2);
		DragonStoneShovel = new ModShovel(DragonStoneShovelID, cc2.DragonStone).setItemName("DragonStoneShovel").setIconCoord(6,2);
		DragonStoneSword = new ModSword(DragonStoneSwordID, cc2.DragonStone).setItemName("DragonStoneSword").setIconCoord(7,2);
		DragonStoneHoe = new ModHoe(DragonStoneHoeID, cc2.DragonStone).setItemName("DragonStoneHoe").setIconCoord(8,2);

		CocoHelmet = new ItemCocoArmor(CocoHelmetID, cc2.COCO, ModLoader.addArmor("Coco"), 0).setIconCoord(0,3).setItemName("CocoHelmet");
		CocoChest = new ItemCocoArmor(CocoChestID, cc2.COCO,  ModLoader.addArmor("Coco"), 1).setIconCoord(1,3).setItemName("CocoChest");
		CocoLegs = new ItemCocoArmor(CocoLegsID, cc2.COCO,  ModLoader.addArmor("Coco"), 2).setIconCoord(2,3).setItemName("CocoLegs");
		CocoBoots = new ItemCocoArmor(CocoBootsID, cc2.COCO,  ModLoader.addArmor("Coco"), 3).setIconCoord(3,3).setItemName("CocoBoots");

		MithrilHelmet = new ItemCocoArmor(MithrilHelmetID, cc2.MITHRIL, ModLoader.addArmor("Mithril"), 0).setIconCoord(4,3).setItemName("MithrilHelmet");
		MithrilChest = new ItemCocoArmor(MithrilChestID, cc2.MITHRIL,  ModLoader.addArmor("Mithril"), 1).setIconCoord(5,3).setItemName("MithrilChest");
		MithrilLegs = new ItemCocoArmor(MithrilLegsID, cc2.MITHRIL,  ModLoader.addArmor("Mithril"), 2).setIconCoord(6,3).setItemName("MithrilLegs");
		MithrilBoots = new ItemCocoArmor(MithrilBootsID, cc2.MITHRIL,  ModLoader.addArmor("Mithril"), 3).setIconCoord(7,3).setItemName("MithrilBoots");

		SilverHelmet = new ItemCocoArmor(SilverHelmetID, cc2.SILVER, ModLoader.addArmor("Silver"), 0).setIconCoord(8,3).setItemName("SilverHelmet");
		SilverChest = new ItemCocoArmor(SilverChestID, cc2.SILVER,  ModLoader.addArmor("Silver"), 1).setIconCoord(9,3).setItemName("SilverChest");
		SilverLegs = new ItemCocoArmor(SilverLegsID, cc2.SILVER,  ModLoader.addArmor("Silver"), 2).setIconCoord(10,3).setItemName("SilverLegs");
		SilverBoots = new ItemCocoArmor(SilverBootsID, cc2.SILVER,  ModLoader.addArmor("Silver"), 3).setIconCoord(11,3).setItemName("SilverBoots");

		AmethystHelmet = new ItemCocoArmor(AmethystHelmetID, cc2.AMETHYST, ModLoader.addArmor("Amethyst"), 0).setIconCoord(12,3).setItemName("AmethystHelmet");
		AmethystChest = new ItemCocoArmor(AmethystChestID, cc2.AMETHYST,  ModLoader.addArmor("Amethyst"), 1).setIconCoord(13,3).setItemName("AmethystChest");
		AmethystLegs = new ItemCocoArmor(AmethystLegsID, cc2.AMETHYST,  ModLoader.addArmor("Amethyst"), 2).setIconCoord(14,3).setItemName("AmethystLegs");
		AmethystBoots = new ItemCocoArmor(AmethystBootsID, cc2.AMETHYST,  ModLoader.addArmor("Amethyst"), 3).setIconCoord(15,3).setItemName("AmethystBoots");

		Essence = new ItemEssence(EssenceID).setItemName("Essence");

		ObsidianMultiTool = new ItemMultiTool(ObsidianMultiToolID, cc2.Obsidian).setItemName("ObsMultiTool").setIconCoord(14, 2);
		
		//Adds the names for items

		lg.addName(CocoPickaxe, "Coco Pickaxe");
		lg.addName(CocoAxe, "Coco Axe");
		lg.addName(CocoShovel, "Coco Shovel");
		lg.addName(CocoSword, "Coco Sword");
		lg.addName(CocoHoe, "Coco Hoe");

		lg.addName(MithrilPickaxe, "Mithril Pickaxe");
		lg.addName(MithrilAxe, "Mithril Axe");
		lg.addName(MithrilShovel, "Mithril Shovel");
		lg.addName(MithrilSword, "Mithril Sword");
		lg.addName(MithrilHoe, "Mithril Hoe");

		lg.addName(SilverPickaxe, "Silver Pickaxe");
		lg.addName(SilverAxe, "Silver Axe");
		lg.addName(SilverShovel, "Silver Shovel");
		lg.addName(SilverSword, "Silver Sword");
		lg.addName(SilverHoe, "Silver Hoe");

		lg.addName(CocoHelmet, "Coco Helmet");
		lg.addName(CocoChest, "Coco Chest");
		lg.addName(CocoLegs, "Coco Legs");
		lg.addName(CocoBoots, "Coco Boots");
		
		lg.addName(MithrilHelmet, "Mithril Helmet");
		lg.addName(MithrilChest, "Mithril Chest");
		lg.addName(MithrilLegs, "Mithril Legs");
		lg.addName(MithrilBoots, "Mithril Boots");
		
		lg.addName(SilverHelmet, "Silver Helmet");
		lg.addName(SilverChest, "Silver Chest");
		lg.addName(SilverLegs, "Silver Legs");
		lg.addName(SilverBoots, "Silver Boots");
		
		lg.addName(AmethystHelmet, "Amethyst Helmet");
		lg.addName(AmethystChest, "Amethyst Chest");
		lg.addName(AmethystLegs, "Amethyst Legs");
		lg.addName(AmethystBoots, "Amethyst Boots");
		
		lg.addName(Hammer, "Hammer");
		
		lg.addName(SteelPickaxe, "Steel Pickaxe");
		lg.addName(SteelAxe, "Steel Axe");
		lg.addName(SteelShovel, "Steel Shovel");
		lg.addName(SteelSword, "Steel Sword");
		lg.addName(SteelHoe, "Steel Hoe");

		lg.addName(DragonStonePickaxe, "Dragonstone Pickaxe");	
		lg.addName(DragonStoneAxe, "Dragonstone Axe");
		lg.addName(DragonStoneShovel, "Dragonstone Shovel");
		lg.addName(DragonStoneSword, "Dragonstone Sword");
		lg.addName(DragonStoneHoe, "Dragonstone Hoe");
		
		lg.addName(ObsidianMultiTool, "Obsidian Multi Tool");		
		
		lg.addName(new ItemStack(Ingots,1,0), "Coco Ingot");
		lg.addName(new ItemStack(Ingots,1,1), "Mithril Ingot");
		lg.addName(new ItemStack(Ingots,1,2), "Silver Ingot");
		lg.addName(new ItemStack(Ingots,1,3), "Amethyst Gem");
		lg.addName(new ItemStack(Ingots,1,4), "Dragonstone Shard");
		lg.addName(new ItemStack(Ingots,1,5), "Diamond Stick");
		lg.addName(new ItemStack(Ingots,1,6), "Coal Dust");
		lg.addName(new ItemStack(Ingots,1,7), "Iron Dust");
		lg.addName(new ItemStack(Ingots,1,8), "Gold Dust");
		lg.addName(new ItemStack(Ingots,1,9), "Mithril Dust");
		lg.addName(new ItemStack(Ingots,1,10), "Silver Dust");
		lg.addName(new ItemStack(Ingots,1,11), "Magic Dust");
		lg.addName(new ItemStack(Ingots,1,12), "Obsidian Dust");
		lg.addName(new ItemStack(Ingots,1,13), "Obsidian Ingot");
		lg.addName(new ItemStack(Ingots,1,14), "Unworked Steel");
		lg.addName(new ItemStack(Ingots,1,15), "Steel Ingot");
		
		lg.addName(new ItemStack(Essence,1,0), "Fire Essence");
		lg.addName(new ItemStack(Essence,1,1), "Water Essence");
		lg.addName(new ItemStack(Essence,1,2), "Air Essence");
		lg.addName(new ItemStack(Essence,1,3), "Earth Essence");
		lg.addName(new ItemStack(Essence,1,4), "Magma Essence");
		
		
		Hammer.setContainerItem(Hammer);



	}
	public static int configProperties(Configuration config)
	{
		config.load();

		IngotsID = config.getItem("IngotsAndStufIDs", "item", 15000).getInt();

		HammerID = config.getItem("HammerID", "item", 15001).getInt();
		
		EssenceID = config.getItem("EssenceID", "item", 15002).getInt();
		
		ObsidianMultiToolID = config.getItem("ObsidianMultiToolID", "item", 15003).getInt();
		
		CocoPickaxeID = config.getItem("CocoPickaxeID", "item", 15004).getInt();
		CocoAxeID = config.getItem("CocoAxeID", "item", 15005).getInt();
		CocoShovelID = config.getItem("CocoShovelID", "item", 15006).getInt();
		CocoSwordID = config.getItem("CocoSwordID", "item", 15007).getInt();
		CocoHoeID = config.getItem("CocoHoeID", "item", 15008).getInt();

		MithrilPickaxeID = config.getItem("MithrilPickaxeID", "item", 15009).getInt();
		MithrilAxeID = config.getItem("MithrilAxeID", "item", 15010).getInt();
		MithrilShovelID = config.getItem("MithrilShovelID", "item", 15011).getInt();
		MithrilSwordID = config.getItem("MithrilSwordID", "item", 15012).getInt();
		MithrilHoeID = config.getItem("MithrilHoeID", "item", 15013).getInt();

		SilverPickaxeID = config.getItem("SilverPickaxeID", "item", 15014).getInt();
		SilverAxeID = config.getItem("SilverAxeID", "item", 15015).getInt();
		SilverShovelID = config.getItem("SilverShovelID", "item", 15016).getInt();
		SilverSwordID = config.getItem("SilverSwordID", "item", 15017).getInt();
		SilverHoeID = config.getItem("SilverHoeID", "item", 15018).getInt();

		SteelPickaxeID = config.getItem("SteelPickaxeID", "item", 15019).getInt();
		SteelAxeID = config.getItem("SteelAxeID", "item", 15020).getInt();
		SteelShovelID = config.getItem("SteelShovelID", "item", 15021).getInt();
		SteelSwordID = config.getItem("SteelSwordID", "item", 15022).getInt();
		SteelHoeID = config.getItem("SteelHoeID", "item", 15023).getInt();

		DragonStonePickaxeID = config.getItem("DragonStonePickaxeID", "item", 15024).getInt();
		DragonStoneAxeID = config.getItem("DragonStoneAxeID", "item", 15025).getInt();
		DragonStoneShovelID = config.getItem("DragonStoneShovelID", "item", 15026).getInt();
		DragonStoneSwordID = config.getItem("DragonStoneSwordID", "item", 15027).getInt();
		DragonStoneHoeID = config.getItem("DragonStoneHoeID", "item", 15028).getInt();

		CocoHelmetID = config.getItem("CocoHelmetID", "item", 15029).getInt();
		CocoChestID = config.getItem("CocoChestID", "item", 15030).getInt();
		CocoLegsID = config.getItem("CocoLegsID", "item", 15031).getInt();
		CocoBootsID = config.getItem("CocoBootsID", "item", 15032).getInt();
		
		MithrilHelmetID = config.getItem("MithrilHelmetID", "item", 15033).getInt();
		MithrilChestID = config.getItem("MithrilChestID", "item", 15034).getInt();
		MithrilLegsID = config.getItem("MithrilLegsID", "item", 15035).getInt();
		MithrilBootsID = config.getItem("MithrilBootsID", "item", 15036).getInt();
		
		SilverHelmetID = config.getItem("SilverHelmetID", "item", 15037).getInt();
		SilverChestID = config.getItem("SilverChestID", "item", 15038).getInt();
		SilverLegsID = config.getItem("SilverLegsID", "item", 15039).getInt();
		SilverBootsID = config.getItem("SilverBootsID", "item", 15040).getInt();
		
		AmethystHelmetID = config.getItem("AmethystHelmetID", "item", 15041).getInt();
		AmethystChestID = config.getItem("AmethystChestID", "item", 15042).getInt();
		AmethystLegsID = config.getItem("AmethystLegsID", "item", 15043).getInt();
		AmethystBootsID = config.getItem("AmethystBootsID", "item", 15044).getInt();
		
			
		config.save();
		return CocoHoeID;
	}

}
