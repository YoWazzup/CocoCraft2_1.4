package ferrokev.cococraft2.common.blocks;
/**
 * @author Ferrokev
 */
import java.util.List;
import java.util.Random;

import cpw.mods.fml.common.Side;
import cpw.mods.fml.common.asm.SideOnly;
import ferrokev.cococraft2.common.Reference;
import net.minecraft.src.Block;
import net.minecraft.src.CreativeTabs;
import net.minecraft.src.ItemStack;
import net.minecraft.src.Material;

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
		return this.blockID;
	}

	public int damageDropped(int i) {
		return i;
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