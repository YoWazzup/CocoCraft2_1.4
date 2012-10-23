package cococraft2.common.blocks;

import java.util.List;
import java.util.Random;

import cococraft2.client.ClientProxy;
import cococraft2.common.CommonProxy;
import cococraft2.common.items.CocoCraftItems;

import cpw.mods.fml.common.Side;
import cpw.mods.fml.common.asm.SideOnly;
import net.minecraft.src.Block;
import net.minecraft.src.CreativeTabs;
import net.minecraft.src.ItemStack;
import net.minecraft.src.Material;

public class BlockOreBlock extends Block
{
	private static CocoCraftItems cci;
	
	public BlockOreBlock(int i, int j)
	{
		super(i, j, Material.iron);
		this.setCreativeTab(CreativeTabs.tabBlock);
		this.setRequiresSelfNotify();
	}
	
	public String getTextureFile()
	{
		return CommonProxy.BlockTex;
	}
	
	public int getBlockTextureFromSideAndMetadata(int i, int j)
	{
		switch(j)
		{
		case 0 : return 4;
		case 1 : return 5;
		case 2 : return 6;
		case 3 : return 7;
		case 4 : return 8;
		case 5 : return 10;
		
		default : return 4;
		}
	}
	
	public int damageDropped(int i)
	{
		return i;
	}
	public int idDropped(int i, Random rand, int j)
	{
		switch(i)
		{
		case 0:
			return blockID;
		case 1:
			return blockID;
		case 2:
			return blockID;
		case 3:
			return blockID;
		case 4:
			return blockID;
		case 5:
			return blockID;
			
		default : return blockID;
		}
	}
	@SideOnly(Side.CLIENT)
	public void getSubBlocks(int i, CreativeTabs tabs, List list)
	{
		for(int j = 0; j < 6; j++)
		{
			list.add(new ItemStack(i, 1, j));
		}
	}
}
