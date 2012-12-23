package ferrokev.cococraft2.common.blocks;
/**
 * @author Ferrokev
 */
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.Configuration;
import net.minecraftforge.oredict.OreDictionary;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import ferrokev.cococraft2.common.ConfigurationSettings;
import ferrokev.cococraft2.common.Reference;

public class CocoCraftBlocks
{
	
	public static Block BlockOre;
	public static Block BlockOreBlock;
	public static Block BlockEssence;
	public static Block BlockCrusher;
	public static Block BlockCompressor;
	public static Block BlockBlastFurnace;

	public static GameRegistry gr;
	public static LanguageRegistry lg;

	public static final String CATEGORY_RARITY = "sets rarity of ores, the higher the number the more common";
	public static final String CATEGORY_DURATIONS = "sets the duration of fuel and how long it takes to smelt";

	
	public static void init()
	{
		BlockOre = new BlockOre(ConfigurationSettings.ID_ORES, Reference.SHEET_LOCATION_BLOCK_ORE);
		BlockOreBlock = new BlockOreBlock(ConfigurationSettings.ID_BLOCKORE, Reference.SHEET_LOCATION_BLOCK_OREBLOCK);
		BlockEssence = new BlockEssence(ConfigurationSettings.ID_BLOCKESSENCE, Reference.SHEET_LOCATION_BLOCK_ESSENCE_DEFAULT);
		BlockCrusher = new BlockCrusher(ConfigurationSettings.ID_BLOCK_CRUSHER, false);
		BlockCompressor = new BlockCompressor(ConfigurationSettings.ID_BLOCK_COMPRESSOR, false);
		BlockBlastFurnace = new BlockBlastFurnace(ConfigurationSettings.ID_BLOCK_BLASTFURNACE, false);

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
		
		lg.instance().addStringLocalization("tile.essenceBlock.fireEssence.name", "Fire Essence");
		lg.instance().addStringLocalization("tile.essenceBlock.waterEssence.name", "Water Essence");
		lg.instance().addStringLocalization("tile.essenceBlock.airEssence.name", "Air Essence");
		lg.instance().addStringLocalization("tile.essenceBlock.earthEssence.name", "Earth Essence");
		
		lg.addName(BlockCrusher, "Crusher");
		lg.addName(BlockCompressor, "Compressor");
		lg.addName(BlockBlastFurnace, "Blast Furnace");
		
		gr.registerBlock(BlockCrusher);
		gr.registerBlock(BlockCompressor);
		gr.registerBlock(BlockBlastFurnace);
		
		Item.itemsList[ConfigurationSettings.ID_ORES] = new ItemBlockOre(ConfigurationSettings.ID_ORES-256, BlockOre).setItemName("ores");
		Item.itemsList[ConfigurationSettings.ID_BLOCKORE] = new ItemBlockOreBlock(ConfigurationSettings.ID_BLOCKORE-256, BlockOreBlock).setItemName("oreBlocks");	
		Item.itemsList[ConfigurationSettings.ID_BLOCKESSENCE] = new ItemBlockEssence(ConfigurationSettings.ID_BLOCKESSENCE-256, BlockEssence).setItemName("essence");	
		
		OreDictionary.registerOre("oreSilver", new ItemStack(BlockOre, 2));
	}

	@PreInit
	public static void preLoad(FMLPreInitializationEvent event)
	{
		Configuration config = new Configuration(event.getSuggestedConfigurationFile());

		config.load();
		
		ConfigurationSettings.ID_ORES = Integer.parseInt(config.getBlock(config.CATEGORY_BLOCK, "ID_ORES", ConfigurationSettings.ID_ORES_DEFAULT).value);
		ConfigurationSettings.ID_BLOCKORE = Integer.parseInt(config.getBlock(config.CATEGORY_BLOCK, "ID_BLOCKORE", ConfigurationSettings.ID_BLOCKORE_DEFAULT).value);
		ConfigurationSettings.ID_BLOCKESSENCE = Integer.parseInt(config.getBlock(config.CATEGORY_BLOCK, "ID_ESSENCEBLOCK", ConfigurationSettings.ID_BLOCKESSENCE_DEFAULT).value);
		ConfigurationSettings.ID_BLOCK_CRUSHER = Integer.parseInt(config.getBlock(config.CATEGORY_BLOCK, "ID_BLOCK_CRUSHER", ConfigurationSettings.ID_BLOCK_CRUSHER_DEFAULT).value);
		ConfigurationSettings.ID_BLOCK_COMPRESSOR = Integer.parseInt(config.getBlock(config.CATEGORY_BLOCK, "ID_BLOCK_COMPRESSOR", ConfigurationSettings.ID_BLOCK_COMPRESSOR_DEFAULT).value);
		ConfigurationSettings.ID_BLOCK_BLASTFURNACE = Integer.parseInt(config.getBlock(config.CATEGORY_BLOCK, "ID_BLOCK_BLASTFURNACE", ConfigurationSettings.ID_BLOCK_BLASTFURNACE_DEFAULT).value);
		
		
		ConfigurationSettings.RARITY_COCO = config.get(CATEGORY_RARITY, "RARITY_COCO", ConfigurationSettings.RARITY_COCO_DEFAULT).getInt();
		ConfigurationSettings.RARITY_MITHRIL = config.get(CATEGORY_RARITY, "RARITY_MITHRIL", ConfigurationSettings.RARITY_MITHRIL_DEFAULT).getInt();
		ConfigurationSettings.RARITY_SILVER = config.get(CATEGORY_RARITY, "RARITY_SILVER", ConfigurationSettings.RARITY_SILVER_DEFAULT).getInt();
		ConfigurationSettings.RARITY_AMETHYST = config.get(CATEGORY_RARITY, "RARITY_AMETHYST", ConfigurationSettings.RARITY_AMETHYST_DEFAULT).getInt();
		ConfigurationSettings.RARITY_ESSENCE_OVERWORLD = config.get(CATEGORY_RARITY, "RARITY_ESSENCE_OVERWORLD", ConfigurationSettings.RARITY_ESSENCE_OVERWORLD_DEFAULT).getInt();
		
		ConfigurationSettings.DURATION_FUEL_CRUSHER = config.get(CATEGORY_DURATIONS, "DURATION_FUEL_CRUSHER", ConfigurationSettings.DURATION_FUEL_CRUSHER_DEFAULT).getInt();
		ConfigurationSettings.DURATION_FUEL_COMPRESSOR = config.get(CATEGORY_DURATIONS, "DURATION_FUEL_COMPRESSOR", ConfigurationSettings.DURATION_FUEL_COMPRESSOR_DEFAULT).getInt();
		ConfigurationSettings.DURATION_FUEL_BLAST = config.get(CATEGORY_DURATIONS, "DURATION_FUEL_BLAST", ConfigurationSettings.DURATION_FUEL_BLAST_DEFAULT).getInt();
		
		ConfigurationSettings.DURATION_PROCESS_CRUSHER = config.get(CATEGORY_DURATIONS, "DURATION_PROCESS_CRUSHER", ConfigurationSettings.DURATION_PROCESS_CRUSHER_DEFAULT).getInt();
		ConfigurationSettings.DURATION_PROCESS_COMPRESSOR = config.get(CATEGORY_DURATIONS, "DURATION_PROCESS_COMPRESSOR", ConfigurationSettings.DURATION_PROCESS_COMPRESSOR_DEFAULT).getInt();
		ConfigurationSettings.DURATION_PROCESS_BLAST = config.get(CATEGORY_DURATIONS, "DURATION_PROCESS_BLAST", ConfigurationSettings.DURATION_PROCESS_BLAST_DEFAULT).getInt();
		
		
		config.save();
	}
}