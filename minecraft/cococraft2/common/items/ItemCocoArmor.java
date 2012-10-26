package cococraft2.common.items;

import java.util.ArrayList;

import cococraft2.client.ClientProxy;
import cococraft2.common.CommonProxy;

import net.minecraft.src.CreativeTabs;
import net.minecraft.src.EnumArmorMaterial;
import net.minecraft.src.ItemArmor;
import net.minecraft.src.ItemStack;
import net.minecraftforge.common.IArmorTextureProvider;

public class ItemCocoArmor extends ItemArmor implements IArmorTextureProvider
{
	public static CocoCraftItems cci;
	public static CommonProxy proxy;

	public ItemCocoArmor(int i, EnumArmorMaterial enumarmormaterial, int j, int k)
	{
		super(i, enumarmormaterial, j, k);
		setCreativeTab(CreativeTabs.tabCombat);
	}

	public String getTextureFile()
	{
		return proxy.ItemTex;
	}
	public String getArmorTextureFile(ItemStack itemstack)
	{
		//Coco Armor
		if(itemstack.itemID == cci.CocoHelmet.shiftedIndex || itemstack.itemID == cci.CocoChest.shiftedIndex || itemstack.itemID == cci.CocoBoots.shiftedIndex)
		{
			return proxy.CocoArmor1;
		}
		if(itemstack.itemID == cci.CocoLegs.shiftedIndex)
		{
			return proxy.CocoArmor2;
		}
		//Mithril Armor
		if(itemstack.itemID == cci.MithrilHelmet.shiftedIndex || itemstack.itemID == cci.MithrilChest.shiftedIndex || itemstack.itemID == cci.MithrilBoots.shiftedIndex)
		{
			return proxy.MithrilArmor1;
		}
		if(itemstack.itemID == cci.MithrilLegs.shiftedIndex)
		{
			return proxy.MithrilArmor2;
		}
		//Silver Armor
		if(itemstack.itemID == cci.SilverHelmet.shiftedIndex || itemstack.itemID == cci.SilverChest.shiftedIndex || itemstack.itemID == cci.SilverBoots.shiftedIndex)
		{
			return proxy.SilverArmor1;
		}
		if(itemstack.itemID == cci.SilverLegs.shiftedIndex)
		{
			return proxy.SilverArmor2;
		}
		//Amethyst Armor
        if(itemstack.itemID == cci.AmethystHelmet.shiftedIndex || itemstack.itemID == cci.AmethystChest.shiftedIndex || itemstack.itemID == cci.AmethystBoots.shiftedIndex)
        {
                return proxy.AmethystArmor1;
        }
        if(itemstack.itemID == cci.AmethystLegs.shiftedIndex)
        {
                return proxy.AmethystArmor2;
        }
		return  proxy.CocoArmor2;
	}
}