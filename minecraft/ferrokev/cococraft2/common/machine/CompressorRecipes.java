package ferrokev.cococraft2.common.machine;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import net.minecraft.src.Block;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
import ferrokev.cococraft2.common.blocks.CocoCraftBlocks;
import ferrokev.cococraft2.common.items.CocoCraftItems;

public class CompressorRecipes {
	
	private static final CompressorRecipes compressingBase = new CompressorRecipes();
	
	private Map compressingList = new HashMap();
	private Map metaCompressingList = new HashMap();
	
	public static final CompressorRecipes compressing() {
		return compressingBase;
	}
	
	public CompressorRecipes() {
		
	}
	
	public void addCrushing(int input, ItemStack output) {
		compressingList.put(Integer.valueOf(input), output);
	}
	
	public void addMetaCrushing(int input, int meta, ItemStack output) {
		metaCompressingList.put(Arrays.asList(input, meta), output);
	}
	
	public ItemStack getSmeltingResult(ItemStack item) {
		if(item == null) {
			return null;
		}
		ItemStack ret = (ItemStack)metaCompressingList.get(Arrays.asList(item.itemID, item.getItemDamage()));
		if(ret != null) {
			return ret;
		}
		return (ItemStack)compressingList.get(Integer.valueOf(item.itemID));
	}
}
