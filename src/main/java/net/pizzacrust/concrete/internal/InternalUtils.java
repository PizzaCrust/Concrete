package net.pizzacrust.concrete.internal;

import net.minecraft.server.EntityPlayer;
import net.minecraft.server.ICommandListener;
import net.minecraft.server.MinecraftServer;

public class InternalUtils {
    public static boolean isPermitted(MinecraftServer server, ICommandListener listener, boolean isConsolePermitted) {
        if (listener instanceof EntityPlayer) {
            EntityPlayer player = (EntityPlayer) listener;
            return server.getPlayerList().isOp(player.getProfile());
        } else {
            return isConsolePermitted;
        }
    }
}
