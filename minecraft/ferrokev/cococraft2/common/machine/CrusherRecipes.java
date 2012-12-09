package ferrokev.cococraft2.common.machine;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import ferrokev.cococraft2.common.CocoCraft2;
import ferrokev.cococraft2.common.blocks.CocoCraftBlocks;
import ferrokev.cococraft2.common.items.CocoCraftItems;

import net.minecraft.src.Block;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;

public class CrusherRecipes {
	
	private static final CrusherRecipes crushingBase = new CrusherRecipes();
	
	private Map crushingList = new HashMap();
	private Map metaCrushingList = new HashMap();
	
	public static final CrusherRecipes crushing() {
		return crushingBase;
	}
	
	public CrusherRecipes() {
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
	
	public void addCrushing(int input, ItemStack output) {
		crushingList.put(Integer.valueOf(input), output);
	}
	
	public void addMetaCrushing(int input, int meta, ItemStack output) {
		metaCrushingList.put(Arrays.asList(input, meta), output);
	}
	
	public ItemStack getSmeltingResult(ItemStack item) {
		if(item == null) {
			return null;
		}
		ItemStack ret = (ItemStack)metaCrushingList.get(Arrays.asList(item.itemID, item.getItemDamage()));
		if(ret != null) {
			return ret;
		}
		return (ItemStack)crushingList.get(Integer.valueOf(item.itemID));
	}
}
