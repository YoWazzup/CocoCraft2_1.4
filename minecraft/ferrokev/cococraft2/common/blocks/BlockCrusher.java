package ferrokev.cococraft2.common.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import ferrokev.cococraft2.common.CocoCraft2;
import ferrokev.cococraft2.common.Reference;
import ferrokev.cococraft2.common.machine.TileEntityCrusher;

public class BlockCrusher extends BlockContainer
{
	private Random crusherRand = new Random();
	private final boolean isActive;
	private static boolean keepCrusherInventory = false;

	public BlockCrusher(int i, boolean bool)
	{
		super(i, Material.rock);
		isActive = bool;
		blockIndexInTexture = 17;
		setCreativeTab(CreativeTabs.tabBlock);
		setBlockName("Crusher");
	}

	public int idDropped(int i, Random rand, int j)
	{
		return blockID;
	}
	
	@SideOnly(Side.CLIENT)
	public String getTextureFile()
	{
		return Reference.BLOCK_SHEET_LOCATION;
	}

	public void onBlockAdded(World world, int x, int y, int z)
	{
		super.onBlockAdded(world, x, y, z);
		setDefaultDirection(world, x, y, z);
	}

	private void setDefaultDirection(World world, int x, int y, int z)
	{
		if (!world.isRemote)
		{
			int var5 = world.getBlockId(x, y, z - 1);
			int var6 = world.getBlockId(x, y, z + 1);
			int var7 = world.getBlockId(x - 1, y, z);
			int var8 = world.getBlockId(x + 1, y, z);
			byte var9 = 3;

			if (Block.opaqueCubeLookup[var5] && !Block.opaqueCubeLookup[var6])
			{
				var9 = 3;
			}

			if (Block.opaqueCubeLookup[var6] && !Block.opaqueCubeLookup[var5])
			{
				var9 = 2;
			}

			if (Block.opaqueCubeLookup[var7] && !Block.opaqueCubeLookup[var8])
			{
				var9 = 5;
			}

			if (Block.opaqueCubeLookup[var8] && !Block.opaqueCubeLookup[var7])
			{
				var9 = 4;
			}

			world.setBlockMetadataWithNotify(x, y, z, var9);
		}
	}

	@SideOnly(Side.CLIENT)
	public int getBlockTexture(IBlockAccess blockaccess, int x, int y, int z, int par5)
	{
		if (par5 == 1)
		{
			return blockIndexInTexture ;
		}
		else if (par5 == 0)
		{
			return blockIndexInTexture ;
		}
		else
		{
			int var6 = blockaccess.getBlockMetadata(x, y, z);
			return par5 != var6 ? blockIndexInTexture : (isActive ? blockIndexInTexture - 1 : blockIndexInTexture - 1);
		}
	}

	public int getBlockTextureFromSide(int i)
	{
		return i == 1 ? blockIndexInTexture : (i == 0 ? blockIndexInTexture : (i == 3 ? blockIndexInTexture - 1 : blockIndexInTexture));
	}

	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int poep, float f, float f2, float f3)
	{
		if (world.isRemote)
		{
			return true;
		}
		else
		{
			TileEntityCrusher var10 = (TileEntityCrusher)world.getBlockTileEntity(x, y, z);

			if(player.isSneaking())
			{
				return false;
			}

			if (var10 != null)
			{
				player.openGui(CocoCraft2.instance, 5, world, x, y, z);
			}

			return true;
		}
	}

	public TileEntity createNewTileEntity(World world)
	{
		return new TileEntityCrusher();
	}

	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLiving entityliving)
	{
		int var6 = MathHelper.floor_double((double)(entityliving.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;

		if (var6 == 0)
		{
			world.setBlockMetadataWithNotify(x, y, z, 2);
		}

		if (var6 == 1)
		{
			world.setBlockMetadataWithNotify(x, y, z, 5);
		}

		if (var6 == 2)
		{
			world.setBlockMetadataWithNotify(x, y, z, 3);
		}

		if (var6 == 3)
		{
			world.setBlockMetadataWithNotify(x, y, z, 4);
		}
	}

	public void breakBlock(World world, int x, int y, int z, int i, int j)
	{
		if (!keepCrusherInventory)
		{
			TileEntityCrusher var7 = (TileEntityCrusher)world.getBlockTileEntity(x, y, z);

			if (var7 != null)
			{
				for (int var8 = 0; var8 < var7.getSizeInventory(); ++var8)
				{
					ItemStack var9 = var7.getStackInSlot(var8);

					if (var9 != null)
					{
						float var10 = crusherRand.nextFloat() * 0.8F + 0.1F;
						float var11 = crusherRand.nextFloat() * 0.8F + 0.1F;
						float var12 = crusherRand.nextFloat() * 0.8F + 0.1F;

						while (var9.stackSize > 0)
						{
							int var13 = crusherRand.nextInt(21) + 10;

							if (var13 > var9.stackSize)
							{
								var13 = var9.stackSize;
							}

							var9.stackSize -= var13;
							EntityItem var14 = new EntityItem(world, (double)((float)x + var10), (double)((float)y + var11), (double)((float)z + var12), new ItemStack(var9.itemID, var13, var9.getItemDamage()));

							if (var9.hasTagCompound())
							{
								var9.setTagCompound((NBTTagCompound)var9.getTagCompound().copy());
							}

							float var15 = 0.05F;
							var14.motionX = (double)((float)crusherRand.nextGaussian() * var15);
							var14.motionY = (double)((float)crusherRand.nextGaussian() * var15 + 0.2F);
							var14.motionZ = (double)((float)crusherRand.nextGaussian() * var15);
							world.spawnEntityInWorld(var14);
						}
					}
				}
			}
		}

		super.breakBlock(world, x, y, z, i, j);
	}
}