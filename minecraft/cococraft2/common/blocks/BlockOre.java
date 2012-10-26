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
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
import net.minecraft.src.Material;

public class BlockOre extends Block
{
	public static CocoCraftItems cci;
	
	public BlockOre(int i, int j)
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
		case 0 : return 0;
		case 1 : return 1;
		case 2 : return 2;
		case 3 : return 3;
		
		case 4 : return 64;
		case 5 : return 65;
		case 6 : return 66;
		case 7 : return 67;
			
		default : return 0;
		}
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
			return cci.Ingots.shiftedIndex;
		case 4:
			return blockID;
		case 5:
			return blockID;
		case 6:
			return blockID;
		case 7:
			return cci.Ingots.shiftedIndex;
			
		default : return blockID;
		}
	}
	@Override
	public int damageDropped(int i) {
		
		switch(i)
		{

		case 3 : return 3;
		case 7 : return 3;
		
		
		default : return 0;
		}
		
	}
	@SideOnly(Side.CLIENT)
	public void getSubBlocks(int i, CreativeTabs tabs, List list)
	{
		for(int j = 0; j < 8; j++)
		{
			list.add(new ItemStack(i, 1, j));
		}
	}
}
