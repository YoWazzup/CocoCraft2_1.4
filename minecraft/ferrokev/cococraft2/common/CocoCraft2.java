package ferrokev.cococraft2.common;
/**
 * @author Ferrokev
 */
import java.util.logging.Level;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.PostInit;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import ferrokev.cococraft2.common.blocks.CocoCraftBlocks;
import ferrokev.cococraft2.common.items.CocoCraftItems;
import ferrokev.cococraft2.common.machine.CrusherRecipes;
import ferrokev.cococraft2.common.machine.TileEntityBlastFurnace;
import ferrokev.cococraft2.common.machine.TileEntityCompressor;
import ferrokev.cococraft2.common.machine.TileEntityCrusher;

@Mod(modid=Reference.MOD_ID, name=Reference.MOD_NAME, version=Reference.MOD_VERSION)
@NetworkMod(clientSideRequired=true, serverSideRequired=false)

public class CocoCraft2
{

	//MinecraftServer.getServer().worldServers[var3].setWorldTime((long)par2);

	@Instance(Reference.MOD_ID)
	public static CocoCraft2 instance;

	@SidedProxy(clientSide=Reference.CLIENT_PROXY_CLASS, serverSide=Reference.SERVER_PROXY_CLASS)
	public static CommonProxy proxy;

	@Init
	public void load(FMLInitializationEvent event)
	{
		toolClass();
		

		proxy.renderStuffs();
		CocoCraftLogger.init();

		CocoCraftBlocks.init();
		CocoCraftItems.init();
		CocoCraftRecipes.init();

		GameRegistry.registerWorldGenerator(new WorldGenerator());
		NetworkRegistry.instance().registerGuiHandler(this, proxy);

		GameRegistry.registerTileEntity(TileEntityCrusher.class, "Crusher");
		GameRegistry.registerTileEntity(TileEntityCompressor.class, "Compressor");
		GameRegistry.registerTileEntity(TileEntityBlastFurnace.class, "BlastFurnace");
		

		CocoCraftLogger.log(Level.INFO, "Loading Mod: " + Reference.MOD_NAME + " , Version: " + Reference.MOD_VERSION );
		
	}

	@PreInit
	public void preLoad(FMLPreInitializationEvent event) {
		
		
		CocoCraftBlocks.preLoad(event);
		CocoCraftItems.preLoad(event);
		
		
	}
	
	@PostInit
	public void postLoad(FMLPostInitializationEvent event) {
		addSmelting();
		addCrushing();
		CocoCraftLogger.log(Level.INFO, "Loaded Mod: " + Reference.MOD_NAME + " Succesfully!");
	}

	public static void toolClass()
	{
		MinecraftForge.setToolClass(CocoCraftItems.ItemPickaxeCoco, "pickaxe", 3);
		MinecraftForge.setToolClass(CocoCraftItems.ItemPickaxeMithril, "pickaxe", 2);
		MinecraftForge.setToolClass(CocoCraftItems.ItemPickaxeSilver, "pickaxe", 2);
		MinecraftForge.setToolClass(CocoCraftItems.ItemPickaxeAmethyst, "pickaxe", 3);
	}
	
	public static void addSmelting() {
		
		FurnaceRecipes.smelting().addSmelting(CocoCraftBlocks.BlockOre.blockID, 0, new ItemStack(CocoCraftItems.ModItem, 1, 0), 0.7F);
		FurnaceRecipes.smelting().addSmelting(CocoCraftBlocks.BlockOre.blockID, 1, new ItemStack(CocoCraftItems.ModItem, 1, 1), 0.4F);
		FurnaceRecipes.smelting().addSmelting(CocoCraftBlocks.BlockOre.blockID, 2, new ItemStack(CocoCraftItems.ModItem, 1, 2), 0.4F);

		FurnaceRecipes.smelting().addSmelting(CocoCraftItems.ModItem.shiftedIndex, 9, new ItemStack(CocoCraftItems.ModItem, 1, 1), 0.0F);
		FurnaceRecipes.smelting().addSmelting(CocoCraftItems.ModItem.shiftedIndex, 10, new ItemStack(CocoCraftItems.ModItem, 1, 2), 0.0F);
		FurnaceRecipes.smelting().addSmelting(CocoCraftItems.ModItem.shiftedIndex, 7, new ItemStack(Item.ingotIron, 1), 0.0F);
		FurnaceRecipes.smelting().addSmelting(CocoCraftItems.ModItem.shiftedIndex, 8, new ItemStack(Item.ingotGold, 1), 0.0F);


	}
	
	public static void addCrushing() {
		// Mithril Ore -> Mithril Dust
		addMetaCrushing(CocoCraftBlocks.BlockOre.blockID, 1, new ItemStack(CocoCraftItems.ModItem, 2, 9));
		// Silver Ore -> Silver Dust
		addMetaCrushing(CocoCraftBlocks.BlockOre.blockID, 2, new ItemStack(CocoCraftItems.ModItem, 2, 10));
		// Coal -> Coal Dust
		addCrushing(Item.coal.shiftedIndex, new ItemStack(CocoCraftItems.ModItem, 1, 6));
		// Iron Ore -> Iron Dust
		addCrushing(Block.oreIron.blockID, new ItemStack(CocoCraftItems.ModItem, 2, 7));
		// Gold Ore -> Gold Dust (You see me mashing up your airwaves)
		addCrushing(Block.oreGold.blockID, new ItemStack(CocoCraftItems.ModItem, 2, 8));
		// Obsidian -> Obsidian Dust
		addCrushing(Block.obsidian.blockID, new ItemStack(CocoCraftItems.ModItem, 1, 12));
	}

	public static void addCrushing(int input, ItemStack output) {
		CrusherRecipes.crushing().addCrushing(input, output);
	}
	
	public static void addMetaCrushing(int input, int meta, ItemStack out) {
		CrusherRecipes.crushing().addMetaCrushing(input, meta, out);
	}
	
}