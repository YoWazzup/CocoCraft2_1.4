package ferrokev.cococraft2.common;
/**
 * @author Ferrokev
 */
import cpw.mods.fml.common.IWorldGenerator;
import ferrokev.cococraft2.common.blocks.CocoCraftBlocks;
import java.util.Random;
import net.minecraft.src.Block;
import net.minecraft.src.IChunkProvider;
import net.minecraft.src.World;
import net.minecraft.src.WorldGenMinable;
import net.minecraft.src.WorldProvider;

public class WorldGenerator
implements IWorldGenerator
{
	public void generate(Random rand, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider)
	{
		switch (world.provider.dimensionId) {
		case -1:
			generateNether(world, rand, chunkX * 16, chunkZ * 16);
		case 0:
			generateSurface(world, rand, chunkX * 16, chunkZ * 16);
		}
	}

	private void generateSurface(World world, Random rand, int blockX, int blockZ)
	{
		int i;

		for (i = 0; i < ConfigurationSettings.RARITY_COCO; i++)
		{
			//Coco Stone
			int Xcoord = blockX + rand.nextInt(16);
			int Ycoord = rand.nextInt(20);
			int Zcoord = blockZ + rand.nextInt(16);
			new WorldGenMinable(CocoCraftBlocks.BlockOre.blockID, 0, 4).generate(world, rand, Xcoord, Ycoord, Zcoord);
		}
		for (i = 0; i < ConfigurationSettings.RARITY_MITHRIL; i++)
		{
			//Mithril Ore
			int Xcoord = blockX + rand.nextInt(16);
			int Ycoord = rand.nextInt(50);
			int Zcoord = blockZ + rand.nextInt(16);
			new WorldGenMinable(CocoCraftBlocks.BlockOre.blockID, 1, 4).generate(world, rand, Xcoord, Ycoord, Zcoord);
		}
		for (i = 0; i < ConfigurationSettings.RARITY_SILVER; i++)
		{
			//Silver Ore
			int Xcoord = blockX + rand.nextInt(16);
			int Ycoord = rand.nextInt(50);
			int Zcoord = blockZ + rand.nextInt(16);
			new WorldGenMinable(CocoCraftBlocks.BlockOre.blockID, 2, 7).generate(world, rand, Xcoord, Ycoord, Zcoord);
		}
		for (i = 0; i < ConfigurationSettings.RARITY_AMETHYST; i++)
		{
			//Amethyst Ore
			int Xcoord = blockX + rand.nextInt(16);
			int Ycoord = rand.nextInt(18);
			int Zcoord = blockZ + rand.nextInt(16);
			new WorldGenMinable(CocoCraftBlocks.BlockOre.blockID, 3, 4).generate(world, rand, Xcoord, Ycoord, Zcoord);
		}
		/* Essences */
		for (i = 0; i < ConfigurationSettings.RARITY_ESSENCE_OVERWORLD; i++)
		{
			int Xcoord = blockX + rand.nextInt(16);
			int Ycoord = rand.nextInt(64);
			int Zcoord = blockZ + rand.nextInt(16);
			new WorldGenMinable(CocoCraftBlocks.BlockEssence.blockID, 0, 5).generate(world, rand, Xcoord, Ycoord, Zcoord);
		}
		for (i = 0; i < ConfigurationSettings.RARITY_ESSENCE_OVERWORLD; i++)
		{
			int Xcoord = blockX + rand.nextInt(16);
			int Ycoord = rand.nextInt(64);
			int Zcoord = blockZ + rand.nextInt(16);
			new WorldGenMinable(CocoCraftBlocks.BlockEssence.blockID, 1, 5).generate(world, rand, Xcoord, Ycoord, Zcoord);
		}
		for (i = 0; i < ConfigurationSettings.RARITY_ESSENCE_OVERWORLD; i++)
		{
			int Xcoord = blockX + rand.nextInt(16);
			int Ycoord = rand.nextInt(64);
			int Zcoord = blockZ + rand.nextInt(16);
			new WorldGenMinable(CocoCraftBlocks.BlockEssence.blockID, 2, 5).generate(world, rand, Xcoord, Ycoord, Zcoord);
		}
		for (i = 0; i < ConfigurationSettings.RARITY_ESSENCE_OVERWORLD; i++)
		{
			int Xcoord = blockX + rand.nextInt(16);
			int Ycoord = rand.nextInt(64);
			int Zcoord = blockZ + rand.nextInt(16);
			new WorldGenMinable(CocoCraftBlocks.BlockEssence.blockID, 3, 5).generate(world, rand, Xcoord, Ycoord, Zcoord);
		}
		
	}

	private void generateNether(World world, Random rand, int blockX, int blockZ)
	{
	}
}