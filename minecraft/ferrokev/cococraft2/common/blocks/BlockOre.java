package ferrokev.cococraft2.common.blocks;
/**
 * @author Ferrokev
 */
import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import ferrokev.cococraft2.common.Reference;
import ferrokev.cococraft2.common.items.CocoCraftItems;

public class BlockOre extends Block {
	
	public BlockOre(int id, int tex) {
		super(id, tex, Material.iron);
		setHardness(3F);
		setResistance(3F);
		setBlockName("BlockOre");
		
		setCreativeTab(CreativeTabs.tabBlock);
		setRequiresSelfNotify();
	}
	
	@SideOnly(Side.CLIENT)
	public String getTextureFile() {
		return Reference.BLOCK_SHEET_LOCATION;
	}

	public int getBlockTextureFromSideAndMetadata(int id, int meta)
	{
		switch (meta) {
		case 0:
			return 0;
		case 1:
			return 1;
		case 2:
			return 2;
		case 3:
			return 3;
		}
		return 0;
	}

	public int idDropped(int i, Random rand, int j)
	{
		switch(j) 
		{
		case 0 : return blockID;
		case 1 : return blockID;
		case 2 : return blockID;
		case 3 : return CocoCraftItems.ModItem.shiftedIndex;
		default : return blockID;
		}
	}

	public int damageDropped(int i) {
		switch(i) 
		{
		case 0 : return 0;
		case 1 : return 1;
		case 2 : return 2;
		case 3 : return 3;
		default : return 0;
		}
	}

	@SideOnly(Side.CLIENT)
	public void getSubBlocks(int i, CreativeTabs tabs, List list)
	{
		for (int j = 0; j < 4; j++)
		{
			list.add(new ItemStack(i, 1, j));
		}
	}
}