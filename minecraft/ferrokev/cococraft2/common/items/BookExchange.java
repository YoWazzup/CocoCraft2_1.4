package ferrokev.cococraft2.common.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import ferrokev.cococraft2.common.Reference;

public class BookExchange extends Item {

	public BookExchange(int i) {
		super(i);
		setCreativeTab(CreativeTabs.tabMisc);
		maxStackSize = 1;
		setMaxDamage(52);
	}
	public String getTextureFile() {
		return Reference.ITEM_SHEET_LOCATION;
	}

	public ItemStack onCrafting(World world, EntityPlayer player, int i) {
		return null;
	}

	public boolean doesContainerItemLeaveCraftingGrid(ItemStack i)
	{
		return false;
	}

	@Override
	public boolean getShareTag() {

		return true;
	}

	@Override
	public ItemStack getContainerItemStack(ItemStack itemStack) {

		itemStack.setItemDamage(itemStack.getItemDamage() + 1);

		return itemStack;
	}
}