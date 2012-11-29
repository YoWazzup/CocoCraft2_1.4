package ferrokev.cococraft2.common;
/**
 * @author Ferrokev
 */
import cpw.mods.fml.common.registry.GameRegistry;
import ferrokev.cococraft2.common.blocks.CocoCraftBlocks;
import ferrokev.cococraft2.common.items.CocoCraftItems;
import net.minecraft.src.Block;
import net.minecraft.src.ItemStack;

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
	}

	private static void addArmorRecipes()
	{
	}

	private static void addShapedRecipes()
	{
		GameRegistry.addRecipe(new ItemStack(CocoCraftBlocks.BlockOreBlock, 1, 5), new Object[] {
			"XXX", "XXX", "XXX", 'X', new ItemStack(CocoCraftItems.ModItem, 1, 6) });
	}

	private static void addShapelessRecipes()
	{
		GameRegistry.addShapelessRecipe(new ItemStack(CocoCraftItems.ModItem, 1, 13), new Object[] { 
			new ItemStack(CocoCraftItems.ModItem, 1, 12), new ItemStack(CocoCraftItems.ModItem, 1, 12), new ItemStack(CocoCraftItems.ModItem, 1, 12) });

		GameRegistry.addShapelessRecipe(new ItemStack(CocoCraftItems.ModItem, 1, 15), new Object[] { 
			new ItemStack(CocoCraftItems.ItemHammer, 1, -1), new ItemStack(CocoCraftItems.ModItem, 1, 14) });
		GameRegistry.addShapelessRecipe(new ItemStack(CocoCraftItems.ModItem, 11, 4), new Object[] { 
			Block.dragonEgg });
		GameRegistry.addShapelessRecipe(new ItemStack(CocoCraftItems.ModItem, 9, 6), new Object[] {
			new ItemStack(CocoCraftBlocks.BlockOreBlock, 1, 5) });
	}
	
	private static void test()
	{
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