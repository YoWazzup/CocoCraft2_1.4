package ferrokev.cococraft2.common.blocks;
/**
 * @author Ferrokev
 */
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import java.io.File;

import ferrokev.cococraft2.common.ConfigurationSettings;
import ferrokev.cococraft2.common.Reference;
import net.minecraft.client.Minecraft;
import net.minecraft.src.Block;
import net.minecraft.src.Item;
import net.minecraftforge.common.Configuration;
import net.minecraftforge.common.Property;

public class CocoCraftBlocks
{
	
	public static Block BlockOre;
	public static Block BlockOreBlock;

	public static GameRegistry gr;
	public static LanguageRegistry lg;

	public static void init()
	{
		BlockOre = new BlockOre(ConfigurationSettings.ID_ORES, Reference.SHEET_LOCATION_BLOCK_ORE);
		BlockOreBlock = new BlockOreBlock(ConfigurationSettings.ID_BLOCKORE, Reference.SHEET_LOCATION_BLOCK_OREBLOCK);

		lg.instance().addStringLocalization("tile.BlockOre.cocoStone.name", "Coco Stone");
		lg.instance().addStringLocalization("tile.BlockOre.mithrilOre.name", "Mithril Ore");
		lg.instance().addStringLocalization("tile.BlockOre.silverOre.name", "Silver Ore");
		lg.instance().addStringLocalization("tile.BlockOre.amethystOre.name", "Amethyst Ore");

		lg.instance().addStringLocalization("tile.OreBlock.cocoBlock.name", "Coco Block");
		lg.instance().addStringLocalization("tile.OreBlock.mithrilBlock.name", "Mithril Block");
		lg.instance().addStringLocalization("tile.OreBlock.silverBlock.name", "Silver Block");
		lg.instance().addStringLocalization("tile.OreBlock.amethystBlock.name", "Amethyst Block");
		lg.instance().addStringLocalization("tile.OreBlock.superStone.name", "Super Stone");
		lg.instance().addStringLocalization("tile.OreBlock.coalBlock.name", "Coal Block");


		Item.itemsList[ConfigurationSettings.ID_ORES] = new ItemBlockOre(ConfigurationSettings.ID_ORES-256, BlockOre).setItemName("ores");
		Item.itemsList[ConfigurationSettings.ID_BLOCKORE] = new ItemBlockOreBlock(ConfigurationSettings.ID_BLOCKORE-256, BlockOreBlock).setItemName("oreBlocks");
		
	}

	@PreInit
	public static void preLoad(FMLPreInitializationEvent event)
	{
		Configuration config = new Configuration(event.getSuggestedConfigurationFile());

		config.load();
		
		ConfigurationSettings.ID_ORES = Integer.parseInt(config.getBlock(config.CATEGORY_BLOCK, "ID_ORES", ConfigurationSettings.ID_ORES_DEFAULT).value);
		ConfigurationSettings.ID_BLOCKORE = Integer.parseInt(config.getBlock(config.CATEGORY_BLOCK, "ID_BLOCKORE", ConfigurationSettings.ID_BLOCKORE_DEFAULT).value);
		
		ConfigurationSettings.RARITY_COCO = (config.get(Reference.CATEGORY_RARITY, "RARITY_COCO", ConfigurationSettings.RARITY_COCO_DEFAULT).getInt());
		ConfigurationSettings.RARITY_MITHRIL = (config.get(Reference.CATEGORY_RARITY, "RARITY_MITHRIL", ConfigurationSettings.RARITY_MITHRIL_DEFAULT).getInt());
		ConfigurationSettings.RARITY_SILVER = (config.get(Reference.CATEGORY_RARITY, "RARITY_SILVER", ConfigurationSettings.RARITY_SILVER_DEFAULT).getInt());
		ConfigurationSettings.RARITY_AMETHYST = (config.get(Reference.CATEGORY_RARITY, "RARITY_AMETHYST", ConfigurationSettings.RARITY_AMETHYST_DEFAULT).getInt());
	
		config.save();
	}
}