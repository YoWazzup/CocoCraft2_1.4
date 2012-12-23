package ferrokev.cococraft2.common;
/**
 * @author Ferrokev
 */
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.registry.GameRegistry;
import ferrokev.cococraft2.common.blocks.CocoCraftBlocks;
import ferrokev.cococraft2.common.items.CocoCraftItems;

public class CocoCraftRecipes
{
	public static GameRegistry gr;
	public static CocoCraftBlocks blocks;
	public static CocoCraftItems items;

	public static void init()
	{
		addToolRecipes();
		addArmorRecipes();
		addShapedRecipes();
		addShapelessRecipes();
		test();
	}

	private static void addToolRecipes()
	{
		//Recipes for Coco tools
		gr.addRecipe(new ItemStack(items.ItemPickaxeCoco, 1), new Object[] {"III", " S ", " S ", 'I', new ItemStack(items.ModItem, 1, 0), 'S', Item.stick});
		gr.addRecipe(new ItemStack(items.ItemAxeCoco, 1), new Object[] {"II ", "IS ", " S ", 'I', new ItemStack(items.ModItem, 1, 0), 'S', Item.stick});
		gr.addRecipe(new ItemStack(items.ItemShovelCoco, 1), new Object[] {" I ", " S ", " S ", 'I', new ItemStack(items.ModItem, 1, 0), 'S', Item.stick});
		gr.addRecipe(new ItemStack(items.ItemSwordCoco, 1), new Object[] {" I ", " I ", " S ", 'I', new ItemStack(items.ModItem, 1, 0), 'S', Item.stick});
		gr.addRecipe(new ItemStack(items.ItemHoeCoco, 1), new Object[] {"II ", " S ", " S ", 'I', new ItemStack(items.ModItem, 1, 0), 'S', Item.stick});
		
		//Recipes for Mithril tools
		gr.addRecipe(new ItemStack(items.ItemPickaxeMithril, 1), new Object[] {"III", " S ", " S ", 'I', new ItemStack(items.ModItem, 1, 1), 'S', Item.stick});
		gr.addRecipe(new ItemStack(items.ItemAxeMithril, 1), new Object[] {"II ", "IS ", " S ", 'I', new ItemStack(items.ModItem, 1, 1), 'S', Item.stick});
		gr.addRecipe(new ItemStack(items.ItemShovelMithril, 1), new Object[] {" I ", " S ", " S ", 'I', new ItemStack(items.ModItem, 1, 1), 'S', Item.stick});
		gr.addRecipe(new ItemStack(items.ItemSwordMithril, 1), new Object[] {" I ", " I ", " S ", 'I', new ItemStack(items.ModItem, 1, 1), 'S', Item.stick});
		gr.addRecipe(new ItemStack(items.ItemHoeMithril, 1), new Object[] {"II ", " S ", " S ", 'I', new ItemStack(items.ModItem, 1, 1), 'S', Item.stick});

		//Recipes for Silver tools
		gr.addRecipe(new ItemStack(items.ItemPickaxeSilver, 1), new Object[] {"III", " S ", " S ", 'I', new ItemStack(items.ModItem, 1, 2), 'S', Item.stick});
		gr.addRecipe(new ItemStack(items.ItemAxeSilver, 1), new Object[] {"II ", "IS ", " S ", 'I', new ItemStack(items.ModItem, 1, 2), 'S', Item.stick});
		gr.addRecipe(new ItemStack(items.ItemShovelSilver, 1), new Object[] {" I ", " S ", " S ", 'I', new ItemStack(items.ModItem, 1, 2), 'S', Item.stick});
		gr.addRecipe(new ItemStack(items.ItemSwordSilver, 1), new Object[] {" I ", " I ", " S ", 'I', new ItemStack(items.ModItem, 1, 2), 'S', Item.stick});
		gr.addRecipe(new ItemStack(items.ItemHoeSilver, 1), new Object[] {"II ", " S ", " S ", 'I', new ItemStack(items.ModItem, 1, 2), 'S', Item.stick});
		
		//Recipes for Amethyst tools
		gr.addRecipe(new ItemStack(items.ItemPickaxeAmethyst, 1), new Object[] {"III", " S ", " S ", 'I', new ItemStack(items.ModItem, 1, 3), 'S', Item.stick});
		gr.addRecipe(new ItemStack(items.ItemAxeAmethyst, 1), new Object[] {"II ", "IS ", " S ", 'I', new ItemStack(items.ModItem, 1, 3), 'S', Item.stick});
		gr.addRecipe(new ItemStack(items.ItemShovelAmethyst, 1), new Object[] {" I ", " S ", " S ", 'I', new ItemStack(items.ModItem, 1, 3), 'S', Item.stick});
		gr.addRecipe(new ItemStack(items.ItemSwordAmethyst, 1), new Object[] {" I ", " I ", " S ", 'I', new ItemStack(items.ModItem, 1, 3), 'S', Item.stick});
		gr.addRecipe(new ItemStack(items.ItemHoeAmethyst, 1), new Object[] {"II ", " S ", " S ", 'I', new ItemStack(items.ModItem, 1, 3), 'S', Item.stick});

	}

	private static void addArmorRecipes()
	{
	}

	private static void addShapedRecipes()
	{
		//9 Coal Dust -> Coal Block
		gr.addRecipe(new ItemStack(CocoCraftBlocks.BlockOreBlock, 1, 5), new Object[] {
			"XXX", "XXX", "XXX", 'X', new ItemStack(CocoCraftItems.ModItem, 1, 6) });
		//Crusher Recipe	
		gr.addRecipe(new ItemStack(blocks.BlockCrusher, 1), new Object[]{
			"SMS", "SDS", "SDS", 'S', new ItemStack(blocks.BlockOreBlock, 1, 4), 'M', new ItemStack(items.ModItem, 1, 11), 'D', Item.diamond});
		//Compressor Recipe
		gr.addRecipe(new ItemStack(blocks.BlockCompressor, 1), new Object[]{
			"SMS", "SDS", "SDS", 'S', new ItemStack(blocks.BlockOreBlock, 1, 4), 'M', new ItemStack(items.ModItem, 1, 0), 'D', Item.diamond});
		//Blast Furnace Recipe
		gr.addRecipe(new ItemStack(blocks.BlockBlastFurnace, 1), new Object[] {
			"XXX", "XSX", "XXX", 'X', Block.blockSteel, 'S', new ItemStack(blocks.BlockOreBlock, 1, 2)
		});
		//Magic Dust Recipe
		gr.addRecipe(new ItemStack(items.ModItem, 2, 11), new Object[]{"GRR", "RSR", "RRG", 'G', Item.gunpowder, 'R', Item.redstone, 'S', Item.sugar});
		//Hammer Recipe
		gr.addRecipe(new ItemStack(items.ItemHammer), new Object[] {"XXX", " S ", " S ", 'X', new ItemStack(blocks.BlockOreBlock, 1, 4), 'S', Item.stick});

	}

	private static void addShapelessRecipes()
	{
		//3 Obsidian Dust -> Obsidian Ingot
		GameRegistry.addShapelessRecipe(new ItemStack(CocoCraftItems.ModItem, 1, 13), new Object[] { 
			new ItemStack(CocoCraftItems.ModItem, 1, 12), new ItemStack(CocoCraftItems.ModItem, 1, 12), new ItemStack(CocoCraftItems.ModItem, 1, 12) });
		//Hammer + Unworked Steel == Steel Ingot
		GameRegistry.addShapelessRecipe(new ItemStack(CocoCraftItems.ModItem, 1, 15), new Object[] { 
			new ItemStack(CocoCraftItems.ItemHammer, 1, -1), new ItemStack(CocoCraftItems.ModItem, 1, 14) });
		//Recipe for the unrenewable Dragonstone Shards
		GameRegistry.addShapelessRecipe(new ItemStack(CocoCraftItems.ModItem, 11, 4), new Object[] { 
			Block.dragonEgg });
		//Coal Block -> 9 Coal Dust
		GameRegistry.addShapelessRecipe(new ItemStack(CocoCraftItems.ModItem, 9, 6), new Object[] {
			new ItemStack(CocoCraftBlocks.BlockOreBlock, 1, 5) });
	}
	
	private static void test()
	{
		/*This uses for loops to get recipes. read it a few times, and you'll get it. */
		ItemStack[] oreBlocks = { new ItemStack(CocoCraftBlocks.BlockOreBlock, 1, 0), new ItemStack(CocoCraftBlocks.BlockOreBlock, 1, 1), new ItemStack(CocoCraftBlocks.BlockOreBlock, 1, 2), new ItemStack(CocoCraftBlocks.BlockOreBlock, 1, 3)};
		ItemStack[] ingots = { new ItemStack(CocoCraftItems.ModItem, 1, 0), new ItemStack(CocoCraftItems.ModItem, 1, 1), new ItemStack(CocoCraftItems.ModItem, 1, 2), new ItemStack(CocoCraftItems.ModItem, 1, 3) };

		for (int j = 0; j < 4; j++) {
			GameRegistry.addShapelessRecipe(new ItemStack(CocoCraftItems.ModItem, 9, j), new Object[] { 
				oreBlocks[j] });
		}
		for (int i = 0; i < 4; i++)
		{
			GameRegistry.addRecipe(new ItemStack(CocoCraftBlocks.BlockOreBlock, 1, i), new Object[] { "III", "III", "III", Character.valueOf('I'), ingots[i] });
		}
	}
}