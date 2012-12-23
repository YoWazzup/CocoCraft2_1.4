package ferrokev.cococraft2.common.machine;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class SlotCompressor extends Slot
{
    /** The player that is using the GUI where this slot resides. */
    private EntityPlayer thePlayer;
    private int field_75228_b;

    public SlotCompressor(EntityPlayer player, IInventory inv, int x, int y, int z)
    {
        super(inv, x, y, z);
        this.thePlayer = player;
    }

    /**
     * Check if the stack is a valid item for this slot. Always true beside for the armor slots.
     */
    public boolean isItemValid(ItemStack item)
    {
        return false;
    }

    /**
     * Decrease the size of the stack in slot (first int arg) by the amount of the second int arg. Returns the new
     * stack.
     */
    public ItemStack decrStackSize(int i)
    {
        if (this.getHasStack())
        {
            this.field_75228_b += Math.min(i, this.getStack().stackSize);
        }

        return super.decrStackSize(i);
    }

    /**
     * Called when the player picks up an item from an inventory slot
     */
    public void onPickupFromSlot(ItemStack item, EntityPlayer player)
    {
        this.onCrafting(item);
        super.onPickupFromSlot(player, item);
    }

    /**
     * the itemStack passed in is the output - ie, iron ingots, and pickaxes, not ore and wood. Typically increases an
     * internal count then calls onCrafting(item).
     */
    protected void onCrafting(ItemStack item, int i)
    {
        this.field_75228_b += i;
        this.onCrafting(item);
    }

   
}