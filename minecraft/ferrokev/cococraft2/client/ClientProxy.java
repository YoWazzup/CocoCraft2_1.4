package ferrokev.cococraft2.client;

import net.minecraftforge.client.MinecraftForgeClient;
import ferrokev.cococraft2.common.CommonProxy;
import ferrokev.cococraft2.common.Reference;

public class ClientProxy extends CommonProxy {

	public void renderStuffs() {
		MinecraftForgeClient.preloadTexture(Reference.BLOCK_SHEET_LOCATION);
		MinecraftForgeClient.preloadTexture(Reference.ITEM_SHEET_LOCATION);
	}
}
