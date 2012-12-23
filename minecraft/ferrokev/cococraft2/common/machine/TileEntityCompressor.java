package ferrokev.cococraft2.common.machine;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.ForgeDirection;
import net.minecraftforge.common.ISidedInventory;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import ferrokev.cococraft2.common.ConfigurationSettings;
import ferrokev.cococraft2.common.items.CocoCraftItems;

public class TileEntityCompressor extends TileEntity implements IInventory, ISidedInventory
{
	private ItemStack[] compressorItemStacks = new ItemStack[3];
	public int compressorBurnTime = 0;
	public int currentItemBurnTime = 0;
	public int compressorCookTime = 0;

	public int getSizeInventory()
	{
		return compressorItemStacks.length;
	}

	public ItemStack getStackInSlot(int i)
	{
		return compressorItemStacks[i];
	}

	public ItemStack decrStackSize(int i, int j)
	{
		if (compressorItemStacks[i] != null)
		{
			ItemStack item;

			if (compressorItemStacks[i].stackSize <= j)
			{
				item = compressorItemStacks[i];
				compressorItemStacks[i] = null;
				return item;
			}
			else
			{
				item = compressorItemStacks[i].splitStack(j);

				if (compressorItemStacks[i].stackSize == 0)
				{
					compressorItemStacks[i] = null;
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
		if (compressorItemStacks[i] != null)
		{
			ItemStack item = compressorItemStacks[i];
			compressorItemStacks[i] = null;
			return item;
		}
		else
		{
			return null;
		}
	}

	public void setInventorySlotContents(int i, ItemStack item)
	{
		compressorItemStacks[i] = item;

		if (item != null && item.stackSize > getInventoryStackLimit())
		{
			item.stackSize = getInventoryStackLimit();
		}
	}

	public String getInvName()
	{
		return "Compressor";
	}

	public void readFromNBT(NBTTagCompound nbttag)
	{
		super.readFromNBT(nbttag);
		NBTTagList var2 = nbttag.getTagList("Items");
		compressorItemStacks = new ItemStack[getSizeInventory()];

		for (int var3 = 0; var3 < var2.tagCount(); ++var3)
		{
			NBTTagCompound var4 = (NBTTagCompound)var2.tagAt(var3);
			byte var5 = var4.getByte("Slot");

			if (var5 >= 0 && var5 < compressorItemStacks.length)
			{
				compressorItemStacks[var5] = ItemStack.loadItemStackFromNBT(var4);
			}
		}

		compressorBurnTime = nbttag.getShort("BurnTime");
		compressorCookTime = nbttag.getShort("CookTime");
		currentItemBurnTime = getItemBurnTime(compressorItemStacks[1]);
	}

	public void writeToNBT(NBTTagCompound nbttag)
	{
		super.writeToNBT(nbttag);
		nbttag.setShort("BurnTime", (short)compressorBurnTime);
		nbttag.setShort("CookTime", (short)compressorCookTime);
		NBTTagList var2 = new NBTTagList();

		for (int var3 = 0; var3 < compressorItemStacks.length; ++var3)
		{
			if (compressorItemStacks[var3] != null)
			{
				NBTTagCompound var4 = new NBTTagCompound();
				var4.setByte("Slot", (byte)var3);
				compressorItemStacks[var3].writeToNBT(var4);
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
		return compressorCookTime * i / ConfigurationSettings.DURATION_PROCESS_CRUSHER;
	}

	@SideOnly(Side.CLIENT)
	public int getBurnTimeRemainingScaled(int i)
	{
		if (currentItemBurnTime == 0)
		{
			currentItemBurnTime = ConfigurationSettings.DURATION_PROCESS_CRUSHER;
		}

		return compressorBurnTime * i / currentItemBurnTime;
	}

	public boolean isBurning()
	{
		return compressorBurnTime > 0;
	}

	public void updateEntity()
	{
		boolean compressorburn = compressorBurnTime > 0;
		boolean bool = false;

		if (compressorBurnTime > 0)
		{
			--compressorBurnTime;
		}

		if (!worldObj.isRemote)
		{
			if (compressorBurnTime == 0 && canSmelt())
			{
				currentItemBurnTime = compressorBurnTime = getItemBurnTime(compressorItemStacks[1]);

				if (compressorBurnTime > 0)
				{
					bool = true;

					if (compressorItemStacks[1] != null)
					{
						--compressorItemStacks[1].stackSize;

						if (compressorItemStacks[1].stackSize == 0)
						{
							compressorItemStacks[1] = compressorItemStacks[1].getItem().getContainerItemStack(compressorItemStacks[1]);
						}
					}
				}
			}

			if (isBurning() && canSmelt())
			{
				++compressorCookTime;

				if (compressorCookTime == ConfigurationSettings.DURATION_PROCESS_CRUSHER)
				{
					compressorCookTime = 0;
					smeltItem();
					bool = true;
				}
			}
			else
			{
				compressorCookTime = 0;
			}

			if (compressorburn != compressorBurnTime > 0)
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
		if (compressorItemStacks[0] == null)
		{
			return false;
		}
		else
		{
			ItemStack item = CompressorRecipes.compressing().getSmeltingResult(compressorItemStacks[0]);
			if (item == null) return false;
			if (compressorItemStacks[2] == null) return true;
			if (!compressorItemStacks[2].isItemEqual(item)) return false;
			int result = compressorItemStacks[2].stackSize + item.stackSize;
			return (result <= getInventoryStackLimit() && result <= item.getMaxStackSize());
		}
	}

	public void smeltItem()
	{
		if (canSmelt())
		{
			ItemStack item = CompressorRecipes.compressing().getSmeltingResult(compressorItemStacks[0]);

			if (compressorItemStacks[2] == null)
			{
				compressorItemStacks[2] = item.copy();
			}
			else if (compressorItemStacks[2].isItemEqual(item))
			{
				compressorItemStacks[2].stackSize += item.stackSize;
			}

			--compressorItemStacks[0].stackSize;

			if (compressorItemStacks[0].stackSize <= 0)
			{
				compressorItemStacks[0] = null;
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