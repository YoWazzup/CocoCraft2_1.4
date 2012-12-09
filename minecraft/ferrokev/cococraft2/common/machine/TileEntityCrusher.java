package ferrokev.cococraft2.common.machine;

import net.minecraft.src.Block;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.IInventory;
import net.minecraft.src.Item;
import net.minecraft.src.ItemBlock;
import net.minecraft.src.ItemStack;
import net.minecraft.src.NBTTagCompound;
import net.minecraft.src.NBTTagList;
import net.minecraft.src.TileEntity;
import net.minecraftforge.common.ForgeDirection;
import net.minecraftforge.common.ISidedInventory;
import cpw.mods.fml.common.Side;
import cpw.mods.fml.common.asm.SideOnly;
import cpw.mods.fml.common.registry.GameRegistry;
import ferrokev.cococraft2.common.ConfigurationSettings;
import ferrokev.cococraft2.common.items.CocoCraftItems;

public class TileEntityCrusher extends TileEntity implements IInventory, ISidedInventory
{
	private ItemStack[] crusherItemStacks = new ItemStack[3];
	public int crusherBurnTime = 0;
	public int currentItemBurnTime = 0;
	public int crusherCookTime = 0;

	public int getSizeInventory()
	{
		return crusherItemStacks.length;
	}

	public ItemStack getStackInSlot(int i)
	{
		return crusherItemStacks[i];
	}

	public ItemStack decrStackSize(int i, int j)
	{
		if (crusherItemStacks[i] != null)
		{
			ItemStack item;

			if (crusherItemStacks[i].stackSize <= j)
			{
				item = crusherItemStacks[i];
				crusherItemStacks[i] = null;
				return item;
			}
			else
			{
				item = crusherItemStacks[i].splitStack(j);

				if (crusherItemStacks[i].stackSize == 0)
				{
					crusherItemStacks[i] = null;
				}

				return item;
			}
		}
		else
		{
			return null;
		}
	}

	public ItemStack getStackInSlotOnClosing(int i)
	{
		if (crusherItemStacks[i] != null)
		{
			ItemStack item = crusherItemStacks[i];
			crusherItemStacks[i] = null;
			return item;
		}
		else
		{
			return null;
		}
	}

	public void setInventorySlotContents(int i, ItemStack item)
	{
		crusherItemStacks[i] = item;

		if (item != null && item.stackSize > getInventoryStackLimit())
		{
			item.stackSize = getInventoryStackLimit();
		}
	}

	public String getInvName()
	{
		return "Crusher";
	}

	public void readFromNBT(NBTTagCompound nbttag)
	{
		super.readFromNBT(nbttag);
		NBTTagList var2 = nbttag.getTagList("Items");
		crusherItemStacks = new ItemStack[getSizeInventory()];

		for (int var3 = 0; var3 < var2.tagCount(); ++var3)
		{
			NBTTagCompound var4 = (NBTTagCompound)var2.tagAt(var3);
			byte var5 = var4.getByte("Slot");

			if (var5 >= 0 && var5 < crusherItemStacks.length)
			{
				crusherItemStacks[var5] = ItemStack.loadItemStackFromNBT(var4);
			}
		}

		crusherBurnTime = nbttag.getShort("BurnTime");
		crusherCookTime = nbttag.getShort("CookTime");
		currentItemBurnTime = getItemBurnTime(crusherItemStacks[1]);
	}

	public void writeToNBT(NBTTagCompound nbttag)
	{
		super.writeToNBT(nbttag);
		nbttag.setShort("BurnTime", (short)crusherBurnTime);
		nbttag.setShort("CookTime", (short)crusherCookTime);
		NBTTagList var2 = new NBTTagList();

		for (int var3 = 0; var3 < crusherItemStacks.length; ++var3)
		{
			if (crusherItemStacks[var3] != null)
			{
				NBTTagCompound var4 = new NBTTagCompound();
				var4.setByte("Slot", (byte)var3);
				crusherItemStacks[var3].writeToNBT(var4);
				var2.appendTag(var4);
			}
		}

		nbttag.setTag("Items", var2);
	}

	public int getInventoryStackLimit()
	{
		return 64;
	}

	@SideOnly(Side.CLIENT)
	public int getCookProgressScaled(int i)
	{
		return crusherCookTime * i / ConfigurationSettings.DURATION_PROCESS_CRUSHER;
	}

	@SideOnly(Side.CLIENT)
	public int getBurnTimeRemainingScaled(int i)
	{
		if (currentItemBurnTime == 0)
		{
			currentItemBurnTime = ConfigurationSettings.DURATION_PROCESS_CRUSHER;
		}

		return crusherBurnTime * i / currentItemBurnTime;
	}

	public boolean isBurning()
	{
		return crusherBurnTime > 0;
	}

	public void updateEntity()
	{
		boolean crusherburn = crusherBurnTime > 0;
		boolean bool = false;

		if (crusherBurnTime > 0)
		{
			--crusherBurnTime;
		}

		if (!worldObj.isRemote)
		{
			if (crusherBurnTime == 0 && canSmelt())
			{
				currentItemBurnTime = crusherBurnTime = getItemBurnTime(crusherItemStacks[1]);

				if (crusherBurnTime > 0)
				{
					bool = true;

					if (crusherItemStacks[1] != null)
					{
						--crusherItemStacks[1].stackSize;

						if (crusherItemStacks[1].stackSize == 0)
						{
							crusherItemStacks[1] = crusherItemStacks[1].getItem().getContainerItemStack(crusherItemStacks[1]);
						}
					}
				}
			}

			if (isBurning() && canSmelt())
			{
				++crusherCookTime;

				if (crusherCookTime == ConfigurationSettings.DURATION_PROCESS_CRUSHER)
				{
					crusherCookTime = 0;
					smeltItem();
					bool = true;
				}
			}
			else
			{
				crusherCookTime = 0;
			}

			if (crusherburn != crusherBurnTime > 0)
			{
				bool = true;

			}
		}

		if (bool)
		{
			onInventoryChanged();
		}
	}

	private boolean canSmelt()
	{
		if (crusherItemStacks[0] == null)
		{
			return false;
		}
		else
		{
			ItemStack item = CrusherRecipes.crushing().getSmeltingResult(crusherItemStacks[0]);
			if (item == null) return false;
			if (crusherItemStacks[2] == null) return true;
			if (!crusherItemStacks[2].isItemEqual(item)) return false;
			int result = crusherItemStacks[2].stackSize + item.stackSize;
			return (result <= getInventoryStackLimit() && result <= item.getMaxStackSize());
		}
	}

	public void smeltItem()
	{
		if (canSmelt())
		{
			ItemStack item = CrusherRecipes.crushing().getSmeltingResult(crusherItemStacks[0]);

			if (crusherItemStacks[2] == null)
			{
				crusherItemStacks[2] = item.copy();
			}
			else if (crusherItemStacks[2].isItemEqual(item))
			{
				crusherItemStacks[2].stackSize += item.stackSize;
			}

			--crusherItemStacks[0].stackSize;

			if (crusherItemStacks[0].stackSize <= 0)
			{
				crusherItemStacks[0] = null;
			}
		}
	}

	public static int getItemBurnTime(ItemStack item)
	{
		if (item == null)
		{
			return 0;
		}
		else
		{
			int getItem = item.getItem().shiftedIndex;
			Item getItem2 = item.getItem();

			if (item.getItem() instanceof ItemBlock && Block.blocksList[getItem] != null)
			{
				Block var3 = Block.blocksList[getItem];
			}

			if(getItem == CocoCraftItems.ModItem.shiftedIndex && item.getItemDamage() == 11)
			{
				return ConfigurationSettings.DURATION_FUEL_CRUSHER;
			}
			return GameRegistry.getFuelValue(item);
		}
	}

	public static boolean isItemFuel(ItemStack item)
	{
		return getItemBurnTime(item) > 0;
	}

	public boolean isUseableByPlayer(EntityPlayer player)
	{
		return worldObj.getBlockTileEntity(xCoord, yCoord, zCoord) != this ? false : player.getDistanceSq((double)xCoord + 0.5D, (double)yCoord + 0.5D, (double)zCoord + 0.5D) <= 64.0D;
	}

	public void openChest() {}

	public void closeChest() {}

	@Override
	public int getStartInventorySide(ForgeDirection side)
	{
		if (side == ForgeDirection.DOWN) return 1;
		if (side == ForgeDirection.UP) return 0; 
		return 2;
	}

	@Override
	public int getSizeInventorySide(ForgeDirection side)
	{
		return 1;
	}

	@Override
	public void onInventoryChanged() {

	}
}