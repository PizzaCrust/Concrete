package net.pizzacrust.concrete.mixin;

import net.minecraft.server.*;
import net.pizzacrust.concrete.api.NetworkUser;
import org.apache.logging.log4j.LogManager;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

import java.io.File;
import java.net.Proxy;

@Mixin(value = DedicatedServer.class, remap = false)
public abstract class MixinDedicatedServer extends MinecraftServer implements IMinecraftServer, NetworkUser {

    protected MixinDedicatedServer(File file, Proxy proxy, DataConverterManager dataConverterManager, com.mojang.authlib.yggdrasil.YggdrasilAuthenticationService yggdrasilAuthenticationService, com.mojang.authlib.minecraft.MinecraftSessionService minecraftSessionService, com.mojang.authlib.GameProfileRepository gameProfileRepository, UserCache userCache) {
        super(file, proxy, dataConverterManager, yggdrasilAuthenticationService, minecraftSessionService, gameProfileRepository, userCache);
    }

    @Override
    public int getPort() {
        return P();
    }

    @Override
    public String getAddress() {
        return getServerIp();
    }

    @Overwrite
    public void aN() {
        LogManager.getLogger("GuiFaker").info("Just faked Minecraft!");
    }
}
