package ferrokev.cococraft2.common;
/**
 * @author Ferrokev
 */
import java.util.logging.Level;

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
import ferrokev.cococraft2.common.machine.TileEntityCrusher;

@Mod(modid=Reference.MOD_ID, name=Reference.MOD_NAME, version=Reference.MOD_VERSION)
@NetworkMod(clientSideRequired=true, serverSideRequired=false)

public class CocoCraft2
{

	@Instance(Reference.MOD_ID)
	public static CocoCraft2 instance;

	@SidedProxy(clientSide=Reference.CLIENT_PROXY_CLASS, serverSide=Reference.SERVER_PROXY_CLASS)
	public static CommonProxy proxy;

	@Init
	public void load(FMLInitializationEvent event)
	{
		toolClass();
		addSmelting();

		proxy.renderStuffs();
		CocoCraftLogger.init();

		CocoCraftBlocks.init();
		CocoCraftItems.init();
		CocoCraftRecipes.init();

		GameRegistry.registerWorldGenerator(new WorldGenerator());
		NetworkRegistry.instance().registerGuiHandler(this, proxy);

		GameRegistry.registerTileEntity(TileEntityCrusher.class, "Crusher");

		CocoCraftLogger.log(Level.INFO, "Loading Mod: " + Reference.MOD_NAME + " , Version: " + Reference.MOD_VERSION );
		
	}

	@PreInit
	public void preLoad(FMLPreInitializationEvent event) {
		CocoCraftBlocks.preLoad(event);
		CocoCraftItems.preLoad(event);
		
		
	}
	
	@PostInit
	public void postLoad(FMLPostInitializationEvent event) {
		CocoCraftLogger.log(Level.INFO, "Loaded Mod: " + Reference.MOD_NAME + " Succesfully!");
	}

	public static void toolClass()
	{
		MinecraftForge.setToolClass(CocoCraftItems.ItemPickaxeCoco, "pickaxe", 3);
		MinecraftForge.setToolClass(CocoCraftItems.ItemPickaxeMithril, "pickaxe", 2);
		MinecraftForge.setToolClass(CocoCraftItems.ItemPickaxeSilver, "pickaxe", 2);
		MinecraftForge.setToolClass(CocoCraftItems.ItemPickaxeAmethyst, "pickaxe", 3);
	}
	//TODO Find out why my smelting throws a NullPointer.
	public static void addSmelting() {
		//FurnaceRecipes.smelting().addSmelting(CocoCraftBlocks.BlockOre.blockID, 0, new ItemStack(Item.appleGold), 1f);

	}

}