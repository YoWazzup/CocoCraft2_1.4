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
import ferrokev.cococraft2.common.machine.TileEntityBlastFurnace;

public class BlockBlastFurnace extends BlockContainer{

	private Random blastRand = new Random();
	private final boolean isActive;
	private static boolean keepInventory = false;

	public BlockBlastFurnace(int i, boolean bool) {
		super(i, Material.iron);
		isActive = bool;
		blockIndexInTexture = 21;
		setCreativeTab(CreativeTabs.tabBlock);
		setBlockName("BlastFurnace");
		setResistance(3F);
		setHardness(3F);
	}

	@SideOnly(Side.CLIENT)
	public String getTextureFile() {
		return Reference.BLOCK_SHEET_LOCATION;
	}

	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float f1, float f2, float f3) {

		if(world.isRemote){ 
			return true;
		}
		else {
			//TileEntityBlastFurnace tile = (TileEntityBlastFurnace)world.getBlockTileEntity(y, y, z);
			TileEntity tile = (TileEntity)world.getBlockTileEntity(x, y, z);
			
			if(player.isSneaking()) {
				
				return false;
			}
			if(tile instanceof TileEntityBlastFurnace) {
				player.openGui(CocoCraft2.instance, 7, world, x, y, z);
			}
			
			return true;
		}
	}
	
	public TileEntity createNewTileEntity(World world) {
		return new TileEntityBlastFurnace();
	}

	public int idDropped(int i, Random rand, int j) {
		return blockID;
	}

	private void setDefaultDirection(World world, int x, int y, int z) {
		if(!world.isRemote) {
			int side1 = world.getBlockId(x, y, z - 1);
			int side2 = world.getBlockId(x, y, z + 1);
			int side3 = world.getBlockId(x - 1, y, z);
			int side4 = world.getBlockId(x + 1, y, z);
			byte side = 3;

			if(Block.opaqueCubeLookup[side1] && !Block.opaqueCubeLookup[side2]) {
				side = 3;
			}
			if(Block.opaqueCubeLookup[side2] && !Block.opaqueCubeLookup[side1]) {
				side = 2;
			}
			if(Block.opaqueCubeLookup[side3] && !Block.opaqueCubeLookup[side4]) {
				side = 5;
			}
			if(Block.opaqueCubeLookup[side4] && !Block.opaqueCubeLookup[side3]) {
				side = 4;

			}
			world.setBlockMetadataWithNotify(x, y, z, side);
		}
	}

	public void onBlockAdded(World world, int x, int y, int z) {
		super.onBlockAdded(world, x, y, z);
		setDefaultDirection(world, x, y, z);
	}

	@SideOnly(Side.CLIENT)
	public int getBlockTexture(IBlockAccess access, int x, int y, int z, int side) {
		if(side == 1) {
			return blockIndexInTexture;
		}
		else if(side == 0) {
			return blockIndexInTexture;
		}
		else {
			int alternateSides = access.getBlockMetadata(x, y, z);
			return side != alternateSides ? blockIndexInTexture : (isActive ? blockIndexInTexture - 1 : blockIndexInTexture -1);
		}
	}

	public int getBlockTextureFromSide(int side) {
		return side == 1 ? blockIndexInTexture : (side == 0 ? blockIndexInTexture : (side == 3 ? blockIndexInTexture - 1 :  blockIndexInTexture));
	}

	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLiving entityliving) {
		int  mathHelper = MathHelper.floor_double((double)(entityliving.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;

		if(mathHelper == 0) {
			world.setBlockMetadataWithNotify(x, y, z, 2);
		}
		if(mathHelper == 1) {
			world.setBlockMetadataWithNotify(x, y, z, 5);
		}
		if(mathHelper == 2) {
			world.setBlockMetadataWithNotify(x, y, z, 3);
		}
		if(mathHelper == 3) {
			world.setBlockMetadataWithNotify(x, y, z, 4);
		}
	}

	public void breakBlock(World par1World, int par2, int par3, int par4, int par5, int par6)
	{
		if (!keepInventory)
		{
			TileEntityBlastFurnace tile = (TileEntityBlastFurnace)par1World.getBlockTileEntity(par2, par3, par4);

			if (tile != null)
			{
				for (int var8 = 0; var8 < tile.getSizeInventory(); ++var8)
				{
					ItemStack item = tile.getStackInSlot(var8);

					if (item != null)
					{
						float var10 = blastRand.nextFloat() * 0.8F + 0.1F;
						float var11 = blastRand.nextFloat() * 0.8F + 0.1F;
						float var12 = blastRand.nextFloat() * 0.8F + 0.1F;

						while (item.stackSize > 0)
						{
							int blast = this.blastRand.nextInt(21) + 10;

							if (blast > item.stackSize)
							{
								blast = item.stackSize;
							}

							item.stackSize -= blast;
							EntityItem entityItem = new EntityItem(par1World, (double)((float)par2 + var10), (double)((float)par3 + var11), (double)((float)par4 + var12), new ItemStack(item.itemID, blast, item.getItemDamage()));

							if (item.hasTagCompound())
							{
								item.setTagCompound((NBTTagCompound)item.getTagCompound().copy());
							}

							float var15 = 0.05F;
							entityItem.motionX = (double)((float)this.blastRand.nextGaussian() * var15);
							entityItem.motionY = (double)((float)this.blastRand.nextGaussian() * var15 + 0.2F);
							entityItem.motionZ = (double)((float)this.blastRand.nextGaussian() * var15);
							par1World.spawnEntityInWorld(entityItem);
						}
					}
				}
			}
		}

		super.breakBlock(par1World, par2, par3, par4, par5, par6);
	}
}







