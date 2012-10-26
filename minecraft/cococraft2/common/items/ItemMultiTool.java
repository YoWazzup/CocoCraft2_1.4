package cococraft2.common.items;

import net.minecraft.src.Block;
import net.minecraft.src.EnumToolMaterial;
import net.minecraft.src.Item;
import net.minecraft.src.CreativeTabs;
import cococraft2.common.CommonProxy;

public class ItemMultiTool extends ToolMulti {

	public ItemMultiTool(int i, EnumToolMaterial tool) {
		super(i, tool);
		setCreativeTab(CreativeTabs.tabTools);
	}
	public String getTextureFile() {
		return CommonProxy.ItemTex;
	}
	public boolean canHarvestBlock(Block block) {
		
		if(block.blockID == Block.stone.blockID || block.blockID == Block.sandStone.blockID) {
			return true;
		}
		return true;
	}

}
