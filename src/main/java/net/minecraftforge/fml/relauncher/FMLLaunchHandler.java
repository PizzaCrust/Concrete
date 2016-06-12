package net.minecraftforge.fml.relauncher;

import org.apache.logging.log4j.LogManager;

public class FMLLaunchHandler {

    public static Side side() {
        LogManager.getLogger("FMLFaker").info("Just faked SpongePowered Mixin!");
        return Side.SERVER;
    }

    public enum Side {
        CLIENT,
        SERVER,
    }
}
