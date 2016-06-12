package net.pizzacrust.concrete;

import net.minecraft.server.MinecraftServer;
import net.pizzacrust.concrete.api.NetworkUser;
import org.fountainmc.api.ServerInfo;

import java.net.InetSocketAddress;

public class SolidInfo implements ServerInfo {
    private final MinecraftServer server;

    public SolidInfo(MinecraftServer server) {
        this.server = server;
    }

    @Override
    public String getName() {
        return server.getName();
    }

    @Override
    public String getVersion() {
        return server.getVersion();
    }

    @Override
    public String getMotd() {
        return server.getMotd();
    }

    @Override
    public int getMaxPlayers() {
        return server.getPlayerList().getMaxPlayers();
    }

    @Override
    public String getOwner() {
        return "Notch";
    }

    @Override
    public InetSocketAddress getAddress() {
        NetworkUser networkUser = (NetworkUser) server;
        return new InetSocketAddress(networkUser.getAddress(), networkUser.getPort());
    }
}
