package ferrokev.cococraft2.common.machine;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntityFurnace;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ContainerCrusher extends Container
{
    private TileEntityCrusher crusher;
    private int lastCookTime = 0;
    private int lastBurnTime = 0;
    private int lastItemBurnTime = 0;

    public ContainerCrusher(InventoryPlayer inv, TileEntityCrusher tile)
    {
        crusher = tile;
        addSlotToContainer(new Slot(tile, 0, 56, 17));
        addSlotToContainer(new Slot(tile, 1, 56, 53));
        addSlotToContainer(new SlotCrusher(inv.player, tile, 2, 116, 35));
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

    public void addCraftingToCrafters(ICrafting icrafting)
    {
        super.addCraftingToCrafters(icrafting);
        icrafting.sendProgressBarUpdate(this, 0, crusher.crusherCookTime);
        icrafting.sendProgressBarUpdate(this, 1, crusher.crusherBurnTime);
        icrafting.sendProgressBarUpdate(this, 2, crusher.currentItemBurnTime);
    }

    /**
     * Updates crafting matrix; called from onCraftMatrixChanged. Args: none
     */
    public void updateCraftingResults()
    {
        super.updateCraftingResults();

        for (int var1 = 0; var1 < crafters.size(); ++var1)
        {
            ICrafting var2 = (ICrafting)crafters.get(var1);

            if (lastCookTime != crusher.crusherCookTime)
            {
                var2.sendProgressBarUpdate(this, 0, crusher.crusherCookTime);
            }

            if (lastBurnTime != crusher.crusherBurnTime)
            {
                var2.sendProgressBarUpdate(this, 1, crusher.crusherBurnTime);
            }

            if (lastItemBurnTime != crusher.currentItemBurnTime)
            {
                var2.sendProgressBarUpdate(this, 2, crusher.currentItemBurnTime);
            }
        }

        lastCookTime = crusher.crusherCookTime;
        lastBurnTime = crusher.crusherBurnTime;
        lastItemBurnTime = crusher.currentItemBurnTime;
    }

    @SideOnly(Side.CLIENT)
    public void updateProgressBar(int i, int j)
    {
        if (i == 0)
        {
        	crusher.crusherCookTime = j;
        }

        if (i == 1)
        {
        	crusher.crusherBurnTime = j;
        }

        if (i == 2)
        {
        	crusher.currentItemBurnTime = j;
        }
    }

    public boolean canInteractWith(EntityPlayer player)
    {
        return crusher.isUseableByPlayer(player);
    }

    /**
     * Called when a player shift-clicks on a slot. You must override this or you will crash when someone does that.
     */
    public ItemStack transferStackInSlot(EntityPlayer player, int i)
    {
        ItemStack item = null;
        Slot slot = (Slot)inventorySlots.get(i);

        if (slot != null && slot.getHasStack())
        {
            ItemStack item2 = slot.getStack();
            item = item2.copy();

            if (i == 2)
            {
                if (!mergeItemStack(item2, 3, 39, true))
                {
                    return null;
                }

                slot.onSlotChange(item2, item);
            }
            else if (i != 1 && i != 0)
            {
                if (CrusherRecipes.crushing().getSmeltingResult(item2) != null)
                {
                    if (!mergeItemStack(item2, 0, 1, false))
                    {
                        return null;
                    }
                }
                else if (TileEntityFurnace.isItemFuel(item2))
                {
                    if (!mergeItemStack(item2, 1, 2, false))
                    {
                        return null;
                    }
                }
                else if (i >= 3 && i < 30)
                {
                    if (!mergeItemStack(item2, 30, 39, false))
                    {
                        return null;
                    }
                }
                else if (i >= 30 && i < 39 && !mergeItemStack(item2, 3, 30, false))
                {
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

        return item;
    }
}