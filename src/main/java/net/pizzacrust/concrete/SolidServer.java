package net.pizzacrust.concrete;

import net.minecraft.server.MinecraftServer;
import org.fountainmc.api.Server;
import org.fountainmc.api.ServerInfo;
import org.fountainmc.api.plugin.PluginManager;

public class SolidServer extends SolidInfo implements Server {
    private final MinecraftServer server;

    public static final PluginManager PLUGIN_MANAGER = new PluginManager();

    public SolidServer(MinecraftServer server) {
        super(server);
        this.server = server;
    }

    @Override
    public ServerInfo getServerInfo() {
        return new SolidInfo(server);
    }

    @Override
    public PluginManager getPluginManager() {
        return PLUGIN_MANAGER;
    }

    @Override
    public String[] getLaunchArguments() {
        return Concrete.LAUNCH_ARGS;
    }
}
