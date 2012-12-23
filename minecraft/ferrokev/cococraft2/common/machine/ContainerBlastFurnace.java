package ferrokev.cococraft2.common.machine;

import java.util.Iterator;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.inventory.SlotFurnace;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ContainerBlastFurnace extends Container {

	private TileEntityBlastFurnace blast;
	private int lastBurn = 0;
	private int lastCook = 0;
	private int lastItem = 0;

	public ContainerBlastFurnace(InventoryPlayer inv, TileEntityBlastFurnace tile) {
		blast = tile;
		addSlotToContainer(new Slot(tile, 0, 33, 17));
		addSlotToContainer(new Slot(tile, 1, 45, 53));
		addSlotToContainer(new Slot(tile, 3, 56, 17));
		addSlotToContainer(new SlotFurnace(inv.player, tile, 2, 116, 35));

		int var3;

		for (var3 = 0; var3 < 3; ++var3)
		{
			for (int var4 = 0; var4 < 9; ++var4)
			{
				addSlotToContainer(new Slot(inv, var4 + var3 * 9 + 9, 8 + var4 * 18, 84 + var3 * 18));
			}
		}

		for (var3 = 0; var3 < 9; ++var3)
		{
			addSlotToContainer(new Slot(inv, var3, 8 + var3 * 18, 142));
		}
	}

	public void addCraftingToCrafters(ICrafting crafting)
	{
		super.addCraftingToCrafters(crafting);
		crafting.sendProgressBarUpdate(this, 0, blast.blastCook);
		crafting.sendProgressBarUpdate(this, 1, blast.blastBurn);
		crafting.sendProgressBarUpdate(this, 2, blast.currentBurn);
	}

	public void updateCraftingResults()
	{
		super.updateCraftingResults();
		Iterator var1 = this.crafters.iterator();

		while (var1.hasNext())
		{
			ICrafting var2 = (ICrafting)var1.next();

			if (this.lastCook != this.blast.blastCook)
			{
				var2.sendProgressBarUpdate(this, 0, this.blast.blastCook);
			}

			if (this.lastBurn != this.blast.blastBurn)
			{
				var2.sendProgressBarUpdate(this, 1, this.blast.blastBurn);
			}

			if (this.lastItem != this.blast.currentBurn)
			{
				var2.sendProgressBarUpdate(this, 2, this.blast.currentBurn);
			}
		}

		this.lastCook = blast.blastCook;
		this.lastBurn = blast.blastBurn;
		this.lastItem = blast.currentBurn;
	}

	@SideOnly(Side.CLIENT)
	public void updateProgressBar(int par1, int par2)
	{
		if (par1 == 0)
		{
			this.blast.blastCook = par2;
		}

		if (par1 == 1)
		{
			this.blast.blastBurn = par2;
		}

		if (par1 == 2)
		{
			this.blast.currentBurn = par2;
		}
	}

	public ItemStack transferStackInSlot(EntityPlayer player, int i) {

		ItemStack item = null;
		Slot slot = (Slot)inventorySlots.get(i);

		if(slot != null && slot.getHasStack()) {
			ItemStack item2 = slot.getStack();
			item = item2.copy();

			if(i == 2) {
				if(!mergeItemStack(item2, 3, 39, true)) {
					return null;
				}
				slot.onSlotChange(item2, item);
			}
			else if (i != 1 && i != 0) {
				if(TileEntityBlastFurnace.getRecipe(item, item2) != null) {
					if(!mergeItemStack(item2, 0, 1, false)) {
						return null;
					}
				}
				else if(TileEntityBlastFurnace.isItemFuel(item2)) {
					if(!mergeItemStack(item2, 1, 2, false)) {
						return null;
					}
				}
				else if (i >= 3 && i < 30) {
					if (!mergeItemStack(item2, 30, 39, false)) {
						return null;
					}
				}
				else if(i >= 30 && i < 39 && !mergeItemStack(item2, 2, 30, false)) {
					if(!mergeItemStack(item2, 30, 39, false)) {
						return null;
					}
				}
				else if (!mergeItemStack(item2, 3, 39, false))
				{
					return null;
				}

				if (item2.stackSize == 0)
				{
					slot.putStack((ItemStack)null);
				}
				else
				{
					slot.onSlotChanged();
				}

				if (item2.stackSize == item.stackSize)
				{
					return null;
				}

				slot.onPickupFromSlot(player, item2);
			}
		}
		return item;
	}

	@Override
	public boolean canInteractWith(EntityPlayer player) {
		return blast.isUseableByPlayer(player);
	}

}
