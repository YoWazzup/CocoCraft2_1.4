package cococraft2.common.items;

import net.minecraft.src.Block;
import net.minecraft.src.CreativeTabs;
import net.minecraft.src.EnumToolMaterial;
import cococraft2.client.ClientProxy;
import cpw.mods.fml.common.Side;
import cpw.mods.fml.common.asm.SideOnly;

public class ItemMultiTool extends ToolMulti {

	public ItemMultiTool(int i, EnumToolMaterial tool) {
		super(i, tool);
		setCreativeTab(CreativeTabs.tabTools);
	}
	@SideOnly(Side.CLIENT)
	public String getTextureFile() {
		return ClientProxy.ItemTex;
	}
	public boolean canHarvestBlock(Block block) {
		
		if(block.blockID == Block.stone.blockID || block.blockID == Block.sandStone.blockID) {
			return true;
		}
		return true;
	}

}
