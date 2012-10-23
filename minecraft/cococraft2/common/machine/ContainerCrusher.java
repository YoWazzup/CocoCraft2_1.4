package cococraft2.common.machine;

import cpw.mods.fml.common.Side;
import cpw.mods.fml.common.asm.SideOnly;
import java.util.Iterator;

import net.minecraft.src.*;

public class ContainerCrusher extends Container
{
    private TileEntityCrusher crusher;
    private int lastCookTime = 0;
    private int lastBurnTime = 0;
    private int lastItemBurnTime = 0;

    public ContainerCrusher(InventoryPlayer par1InventoryPlayer, TileEntityCrusher par2TileEntityCrusher)
    {
        crusher = par2TileEntityCrusher;
        addSlotToContainer(new Slot(par2TileEntityCrusher, 0, 56, 17));
        addSlotToContainer(new Slot(par2TileEntityCrusher, 1, 56, 53));
        addSlotToContainer(new SlotCrusher(par1InventoryPlayer.player, par2TileEntityCrusher, 2, 116, 35));
        int var3;

        for (var3 = 0; var3 < 3; ++var3)
        {
            for (int var4 = 0; var4 < 9; ++var4)
            {
                addSlotToContainer(new Slot(par1InventoryPlayer, var4 + var3 * 9 + 9, 8 + var4 * 18, 84 + var3 * 18));
            }
        }

        for (var3 = 0; var3 < 9; ++var3)
        {
            addSlotToContainer(new Slot(par1InventoryPlayer, var3, 8 + var3 * 18, 142));
        }
    }

    public void addCraftingToCrafters(ICrafting par1ICrafting)
    {
        super.addCraftingToCrafters(par1ICrafting);
        par1ICrafting.updateCraftingInventoryInfo(this, 0, this.crusher.crusherCookTime);
        par1ICrafting.updateCraftingInventoryInfo(this, 1, this.crusher.crusherBurnTime);
        par1ICrafting.updateCraftingInventoryInfo(this, 2, this.crusher.currentItemBurnTime);
    }

    /**
     * Updates crafting matrix; called from onCraftMatrixChanged. Args: none
     */
    public void updateCraftingResults()
    {
        super.updateCraftingResults();
        Iterator var1 = this.crafters.iterator();

        while (var1.hasNext())
        {
            ICrafting var2 = (ICrafting)var1.next();

            if (this.lastCookTime != this.crusher.crusherCookTime)
            {
                var2.updateCraftingInventoryInfo(this, 0, this.crusher.crusherCookTime);
            }

            if (this.lastBurnTime != this.crusher.crusherBurnTime)
            {
                var2.updateCraftingInventoryInfo(this, 1, this.crusher.crusherBurnTime);
            }

            if (this.lastItemBurnTime != this.crusher.currentItemBurnTime)
            {
                var2.updateCraftingInventoryInfo(this, 2, this.crusher.currentItemBurnTime);
            }
        }

        this.lastCookTime = this.crusher.crusherCookTime;
        this.lastBurnTime = this.crusher.crusherBurnTime;
        this.lastItemBurnTime = this.crusher.currentItemBurnTime;
    }

    @SideOnly(Side.CLIENT)
    public void updateProgressBar(int par1, int par2)
    {
        if (par1 == 0)
        {
            this.crusher.crusherCookTime = par2;
        }

        if (par1 == 1)
        {
            this.crusher.crusherBurnTime = par2;
        }

        if (par1 == 2)
        {
            this.crusher.currentItemBurnTime = par2;
        }
    }

    public boolean canInteractWith(EntityPlayer par1EntityPlayer)
    {
        return this.crusher.isUseableByPlayer(par1EntityPlayer);
    }

    /**
     * Called to transfer a stack from one inventory to the other eg. when shift clicking.
     */
    public ItemStack func_82846_b(EntityPlayer par1EntityPlayer, int par2)
    {
        ItemStack var3 = null;
        Slot var4 = (Slot)this.inventorySlots.get(par2);

        if (var4 != null && var4.getHasStack())
        {
            ItemStack var5 = var4.getStack();
            var3 = var5.copy();

            if (par2 == 2)
            {
                if (!this.mergeItemStack(var5, 3, 39, true))
                {
                    return null;
                }

                var4.onSlotChange(var5, var3);
            }
            else if (par2 != 1 && par2 != 0)
            {
                if (FurnaceRecipes.smelting().getSmeltingResult(var5) != null)
                {
                    if (!this.mergeItemStack(var5, 0, 1, false))
                    {
                        return null;
                    }
                }
                else if (TileEntityFurnace.isItemFuel(var5))
                {
                    if (!this.mergeItemStack(var5, 1, 2, false))
                    {
                        return null;
                    }
                }
                else if (par2 >= 3 && par2 < 30)
                {
                    if (!this.mergeItemStack(var5, 30, 39, false))
                    {
                        return null;
                    }
                }
                else if (par2 >= 30 && par2 < 39 && !this.mergeItemStack(var5, 3, 30, false))
                {
                    return null;
                }
            }
            else if (!this.mergeItemStack(var5, 3, 39, false))
            {
                return null;
            }

            if (var5.stackSize == 0)
            {
                var4.putStack((ItemStack)null);
            }
            else
            {
                var4.onSlotChanged();
            }

            if (var5.stackSize == var3.stackSize)
            {
                return null;
            }

            var4.func_82870_a(par1EntityPlayer, var5);
        }

        return var3;
    }
}
