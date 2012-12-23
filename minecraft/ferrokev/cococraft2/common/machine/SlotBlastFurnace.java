package ferrokev.cococraft2.common.machine;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class SlotBlastFurnace extends Slot {

	private EntityPlayer thePlayer;
	private int func;

	public SlotBlastFurnace(EntityPlayer player, IInventory inventory, int x, int y, int z) {
		super(inventory, x, y, z);
		thePlayer = player;
	}

	public boolean isItemValid(ItemStack item) {
		return false;
	}

	public ItemStack decrStackSize(int i) {
		if(getHasStack()) {
			func += Math.min(i, getStack().stackSize);
		}
		return super.decrStackSize(i);
	}

	public void onPickupFromSlot(ItemStack item, EntityPlayer player)
	{
		this.onCrafting(item);
		super.onPickupFromSlot(player, item);
	}
	
	 protected void onCrafting(ItemStack item, int i)
	    {
	        this.func += i;
	        this.onCrafting(item);
	    }
}
