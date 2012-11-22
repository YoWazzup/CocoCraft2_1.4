package cococraft2.common.items;

import net.minecraft.src.Block;
import net.minecraft.src.EnumToolMaterial;
import net.minecraft.src.ItemStack;
import net.minecraft.src.ItemTool;
import net.minecraft.src.Material;

public class ToolMulti extends ItemTool {

	private static Block blocksEffectiveAgainst[];

	public ToolMulti(int i, EnumToolMaterial tool) {
		super(i, 1 ,tool, blocksEffectiveAgainst);
	}

	public boolean canHarvestBlock(Block block) {

		if(block == Block.obsidian) {
			return toolMaterial.getHarvestLevel() == 3;
		}
		if(block == Block.blockDiamond || block == Block.blockEmerald || block == Block.blockGold || block == Block.blockLapis || block == Block.blockSteel) {
			return toolMaterial.getHarvestLevel() >= 2;
		}
		if(block == Block.oreDiamond || block == Block.oreEmerald || block == Block.oreGold || block == Block.oreLapis || block == Block.oreIron) {
			return toolMaterial.getHarvestLevel() >= 2;
		}
		if(block == Block.stone || block == Block.cobblestone || block == Block.cobblestoneMossy) {
			return toolMaterial.getHarvestLevel() >= 2;
		}
		if (block.blockMaterial == Material.rock) {
			return true;
		}
		if (block.blockMaterial == Material.iron) {
			return true;
		}
		if (block == Block.snow) {
			return true;
		}
		return block == Block.blockSnow;
	}
	public float getStrVsBlock(ItemStack par1ItemStack, Block par2Block)
	{
		if (par2Block != null && (par2Block.blockMaterial == Material.iron || par2Block.blockMaterial == Material.rock))
		{
			return efficiencyOnProperMaterial;
		}
		if (par2Block != null && par2Block.blockMaterial == Material.wood)
		{
			return efficiencyOnProperMaterial;
		}
		else
		{
			return super.getStrVsBlock(par1ItemStack, par2Block);
		}
	}
	static
	{
	blocksEffectiveAgainst = (new Block[]
	{
	Block.cobblestone, Block.stone, Block.sandStone, Block.cobblestoneMossy, Block.oreIron, Block.blockSteel, Block.oreCoal, Block.blockGold,
	Block.oreGold, Block.oreDiamond, Block.blockDiamond, Block.ice, Block.netherrack, Block.oreLapis, Block.blockLapis, Block.oreRedstone, Block.oreRedstoneGlowing, Block.rail,
	Block.railDetector, Block.railPowered, Block.grass, Block.dirt, Block.sand, Block.gravel, Block.snow, Block.blockSnow, Block.blockClay, Block.tilledField, Block.slowSand, Block.mycelium,
	Block.planks, Block.bookShelf, Block.wood, Block.chest, Block.pumpkin, Block.pumpkinLantern
	});
}
}
