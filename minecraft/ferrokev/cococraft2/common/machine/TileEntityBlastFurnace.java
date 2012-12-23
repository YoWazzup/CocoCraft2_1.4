package ferrokev.cococraft2.common.machine;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.ForgeDirection;
import net.minecraftforge.common.ISidedInventory;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import ferrokev.cococraft2.common.ConfigurationSettings;
import ferrokev.cococraft2.common.blocks.CocoCraftBlocks;
import ferrokev.cococraft2.common.items.CocoCraftItems;

public class TileEntityBlastFurnace extends TileEntity implements IInventory, ISidedInventory{

	private ItemStack[] blastStacks = new ItemStack[4];
	public int blastBurn = 0;
	public int blastCook = 0;
	public int currentBurn = 0;

	public int getSizeInventory() {
		return blastStacks.length;
	}

	public ItemStack getStackInSlot(int i)
	{
		return blastStacks[i];
	}

	public int getInventoryStackLimit() {
		return 64;
	}

	public ItemStack decrStackSize(int invSlot, int num) {
		if(blastStacks[invSlot] != null) {
			ItemStack item;

			if(blastStacks[invSlot].stackSize <= num) {
				item = blastStacks[invSlot];
				blastStacks[invSlot] = null;
				return item;
			}
			else
				item = blastStacks[invSlot].splitStack(num);

			if(blastStacks[invSlot].stackSize == 0) {
				blastStacks[invSlot] = null;
			}

			return item;
		}
		else {
			return null;
		}
	}

	public ItemStack getStackInSlotOnClosing(int i) {
		if(blastStacks[i] != null) {
			ItemStack item = blastStacks[i];
			blastStacks[i] = null;
			return item;
		}
		else {
			return null;
		}
	}

	public void setInventorySlotContents(int i, ItemStack item) {
		blastStacks[i] = item;
		if(item != null && item.stackSize > getInventoryStackLimit()) {
			item.stackSize = getInventoryStackLimit();
		}
	}

	public String getInvName() {
		return "BlastFurnace";
	}

	public void readFromNBT(NBTTagCompound nbttagcompound)
	{
		super.readFromNBT(nbttagcompound);
		NBTTagList nbttaglist = nbttagcompound.getTagList("Items");
		blastStacks = new ItemStack[getSizeInventory()];
		for (int i = 0; i < nbttaglist.tagCount(); i++)
		{
			NBTTagCompound nbttagcompound1 = (NBTTagCompound)nbttaglist.tagAt(i);
			byte byte0 = nbttagcompound1.getByte("Slot");
			if (byte0 >= 0 && byte0 < blastStacks.length)
			{
				blastStacks[byte0] = ItemStack.loadItemStackFromNBT(nbttagcompound1);
			}
		}

		blastBurn = nbttagcompound.getShort("BurnTime");
		blastCook = nbttagcompound.getShort("CookTime");
		currentBurn = getItemBurnTime(blastStacks[1]);
	}

	public void writeToNBT(NBTTagCompound nbttagcompound)
	{
		super.writeToNBT(nbttagcompound);
		nbttagcompound.setShort("BurnTime", (short)blastBurn);
		nbttagcompound.setShort("CookTime", (short)blastCook);
		NBTTagList nbttaglist = new NBTTagList();
		for (int i = 0; i < blastStacks.length; i++)
		{
			if (blastStacks[i] != null)
			{
				NBTTagCompound nbttagcompound1 = new NBTTagCompound();
				nbttagcompound1.setByte("Slot", (byte)i);
				blastStacks[i].writeToNBT(nbttagcompound1);
				nbttaglist.appendTag(nbttagcompound1);
			}
		}

		nbttagcompound.setTag("Items", nbttaglist);
	}

	@SideOnly(Side.CLIENT)
	public int getCookProgressScaled(int i) {
		return blastCook * i / ConfigurationSettings.DURATION_PROCESS_BLAST;
	}

	@SideOnly(Side.CLIENT)
	public int getBurnTimeRemainingScaled(int i) {
		if(currentBurn == 0) {
			currentBurn = ConfigurationSettings.DURATION_PROCESS_BLAST;
		}

		return blastBurn * i / currentBurn;
	}

	public boolean isBurning() {
		return blastBurn > 0;
	}
	//Important for dual input! Not the same as one input
	private boolean canSmelt() {
		ItemStack result = getRecipe(blastStacks[0], blastStacks[3]);

		if(result == null) return false;

		if(blastStacks[2] == null) return true;
		if(blastStacks[2] != null && blastStacks[2].itemID == result.itemID && blastStacks[2].stackSize < (blastStacks[2].getMaxStackSize() - (result.stackSize-1)))
			return true;

		return false;
	}

	public void smeltItem() {
		if(!canSmelt()) {
			return;
		}
		ItemStack item = getRecipe(blastStacks[0], blastStacks[3]);

		if(blastStacks[2] == null) {
			blastStacks[2] = item.copy();
		}
		else if(blastStacks[2].itemID == item.itemID) {
			blastStacks[2].stackSize += item.stackSize;
		}
		if(blastStacks[0] != null) {
			blastStacks[0].stackSize--;
			if(blastStacks[0].stackSize <= 0) {
				blastStacks[0] = null;
			}
		}
		if(blastStacks[3] != null) {
			blastStacks[3].stackSize--;
			if(blastStacks[3].stackSize <= 3) {
				blastStacks[3] = null;
			}
		}
	}

	public void updateEntity()
	{
		boolean var1 = this.blastBurn > 0;
		boolean var2 = false;

		if (this.blastBurn > 0)
		{
			--this.blastBurn;
		}

		if (!this.worldObj.isRemote)
		{
			if (this.blastBurn == 0 && this.canSmelt())
			{
				this.currentBurn = this.blastBurn = getItemBurnTime(this.blastStacks[1]);

				if (this.blastBurn > 0)
				{
					var2 = true;

					if (this.blastStacks[1] != null)
					{
						--this.blastStacks[1].stackSize;

						if (this.blastStacks[1].stackSize == 0)
						{
							this.blastStacks[1] = this.blastStacks[1].getItem().getContainerItemStack(blastStacks[1]);
						}
					}
				}
			}

			if (this.isBurning() && this.canSmelt())
			{
				++this.blastCook;

				if (this.blastCook == ConfigurationSettings.DURATION_PROCESS_BLAST)
				{
					this.blastCook = 0;
					this.smeltItem();
					var2 = true;
				}
			}
			else
			{
				this.blastCook = 0;
			}

			if (var1 != this.blastBurn > 0)
			{
				var2 = true;

			}
		}

		if (var2)
		{
			this.onInventoryChanged();
		}
	}

	private static int getItemBurnTime(ItemStack item) {
		if(item == null) {
			return 0;
		}
		int i = item.getItem().shiftedIndex;
		if(i == Item.coal.shiftedIndex) {
			return ConfigurationSettings.DURATION_FUEL_BLAST;
		}
		else {
			return 0;
		}
	}

	public static boolean isItemFuel(ItemStack item) {
		return getItemBurnTime(item) > 0;
	}

	public boolean isUseableByPlayer(EntityPlayer player)
	{
		return worldObj.getBlockTileEntity(xCoord, yCoord, zCoord) != this ? false : player.getDistanceSq((double)xCoord + 0.5D, (double)yCoord + 0.5D, (double)zCoord + 0.5D) <= 64.0D;
	}

	/**
	 * 	Recipes!
	 */
	private static CocoCraftBlocks ccb;
	private static CocoCraftItems cci;
	
	public static ItemStack getRecipe(ItemStack item, ItemStack item2) {
		int i1, i2;

		if(item  == null) i1 = 0; else i1 = item.itemID;
		if(item2 == null) i2 = 0; else i2 = item2.itemID;

		if(i1 == 0 && i2 == Block.cobblestone.blockID) return new ItemStack(Block.stone);
		if(i2 == 0 && i1 == Block.cobblestone.blockID) return new ItemStack(Block.stone);
		if(i1 == i2 && i1 == Block.cobblestone.blockID) return new ItemStack(Block.stone, 2);

		if(i1 == 0 && i2 == Block.oreIron.blockID) return new ItemStack(Item.ingotIron);
		if(i2 == 0 && i1 == Block.oreIron.blockID) return new ItemStack(Item.ingotIron);
		if(i1 == i2 && i2 == Block.oreIron.blockID) return new ItemStack(Item.ingotIron, 2);

		if(i1 == 0 && i2 == Block.oreGold.blockID) return new ItemStack(Item.ingotGold);
		if(i2 == 0 && i1 == Block.oreGold.blockID) return new ItemStack(Item.ingotGold);
		if(i1 == i2 && i2 == Block.oreGold.blockID) return new ItemStack(Item.ingotGold, 2);
		
		if(i1 == ccb.BlockOre.blockID && item.getItemDamage() == 0 && i2 == 0) return new ItemStack(cci.ModItem, 1, 0);
		if(i2 == i1 && i1 == ccb.BlockOre.blockID && item.getItemDamage() == 0) return new ItemStack(cci.ModItem, 2, 0);

		if(i1 == ccb.BlockOre.blockID && item.getItemDamage() == 1 && i2 == 0) return new ItemStack(cci.ModItem, 1, 1);
		if(i2 == i1 && i1 == ccb.BlockOre.blockID && item.getItemDamage() == 1) return new ItemStack(cci.ModItem, 2, 1);

		if(i1 == ccb.BlockOre.blockID && item.getItemDamage() == 2 && i2 == 0) return new ItemStack(cci.ModItem, 1, 2);
		if(i2 == i1 && i1 == ccb.BlockOre.blockID && item.getItemDamage() == 2) return new ItemStack(cci.ModItem, 2, 2);

		if(i1 == ccb.BlockOreBlock.blockID && item.getItemDamage() == 5 && i2 == Item.ingotIron.shiftedIndex) return new ItemStack(cci.ModItem, 1, 14);


		return null;
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






