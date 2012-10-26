package cococraft2.common.blocks;

import java.util.List;
import java.util.Random;

import cococraft2.common.CommonProxy;
import cococraft2.common.items.CocoCraftItems;
import cpw.mods.fml.common.Side;
import cpw.mods.fml.common.asm.SideOnly;

import net.minecraft.src.Block;
import net.minecraft.src.CreativeTabs;
import net.minecraft.src.ItemStack;
import net.minecraft.src.Material;
import net.minecraft.src.World;

public class BlockEssence extends Block
{
	private static CocoCraftItems cci;

	public BlockEssence(int i, int j)
	{
		super(i, j, Material.iron);
		setCreativeTab(CreativeTabs.tabBlock);
		setRequiresSelfNotify();
	}
	public String getTextureFile()
	{
		return CommonProxy.BlockTex;
	}
	public int getBlockTextureFromSideAndMetadata(int i, int j)
	{
		switch(j)
		{
		case 0 : return 9;
		case 1 : return 9;
		case 2 : return 9;
		case 3 : return 9;
		case 4 : return 11;
		default : return 9;
		}
	}
	public int idDropped(int i, Random rand, int j)
	{
		switch(i)
		{
		case 0:
			return cci.Essence.shiftedIndex;
		case 1:
			return cci.Essence.shiftedIndex;
		case 2:
			return cci.Essence.shiftedIndex;
		case 3:
			return cci.Essence.shiftedIndex;
		case 4: 
			return cci.Essence.shiftedIndex;
			
		default : return cci.Essence.shiftedIndex;
		}
	}
	@Override
	public int damageDropped(int i) {
		
		
		switch(i)
		{
		case 0 : return 0;
		case 1 : return 1;
		case 2 : return 2;
		case 3 : return 3;
		case 4 : return 4;
		
		default : return 0;
		}
		
	}
	@SideOnly(Side.CLIENT)
	public void getSubBlocks(int i, CreativeTabs tabs, List list)
	{
		for(int j = 0; j < 5; j++)
		{
			list.add(new ItemStack(i, 1, j));
		}
	}
	
}
