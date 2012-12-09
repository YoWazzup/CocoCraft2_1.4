package ferrokev.cococraft2.common;

import java.util.logging.Level;
import java.util.logging.Logger;

import cpw.mods.fml.common.FMLLog;

public class CocoCraftLogger {

	private static Logger CocoCraft2Logger = Logger.getLogger(Reference.MOD_ID);

	public static void init() {
		CocoCraft2Logger.setParent(FMLLog.getLogger());

	}

	public static void log(Level level, String msg) {
		CocoCraft2Logger.log(level, msg);
	}
}
