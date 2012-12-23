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

public class BlockOreBlock extends Block
{
	public BlockOreBlock(int id, int tex)
	{
		super(id, tex, Material.iron);
		setResistance(3.0F);
		setHardness(3.0F);
		setBlockName("OreBlock");

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
			return 4;
		case 1:
			return 5;
		case 2:
			return 6;
		case 3:
			return 7;
		case 4:
			return 8;
		case 5:
			return 10;
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
		for (int j = 0; j < 6; j++)
		{
			list.add(new ItemStack(i, 1, j));
		}
	}
}