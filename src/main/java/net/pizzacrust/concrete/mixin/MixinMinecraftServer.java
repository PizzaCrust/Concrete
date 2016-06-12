package net.pizzacrust.concrete.mixin;

import net.minecraft.server.IAsyncTaskHandler;
import net.minecraft.server.ICommandListener;
import net.minecraft.server.IMojangStatistics;
import net.minecraft.server.MinecraftServer;
import net.pizzacrust.concrete.Concrete;
import net.pizzacrust.concrete.SolidServer;
import net.pizzacrust.concrete.api.NetworkUser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.fountainmc.api.Fountain;
import org.fountainmc.api.event.server.ServerStartEvent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.io.IOException;

@Mixin(value = MinecraftServer.class, remap = false)
public abstract class MixinMinecraftServer implements Runnable, ICommandListener, IAsyncTaskHandler, IMojangStatistics {

    @Inject(method = "t()V", at = @At(value = "RETURN", remap = false))
    private void serverReady(CallbackInfo ci) throws IOException {
        Logger logger = LogManager.getLogger("Concrete");
        NetworkUser networkUser = (NetworkUser) h();
        logger.info("Network User: {}:{}", networkUser.getAddress(), networkUser.getPort());
        logger.info("API Construction is in progress...");
        MinecraftServer server = h();
        SolidServer apiImpl = new SolidServer(server);
        Fountain.setServer(apiImpl);
        if (!Concrete.PLUGINS_DIR.exists()) {
            Concrete.PLUGINS_DIR.mkdir();
        }
        logger.info("Plugins directory: {}", Concrete.PLUGINS_DIR.getAbsolutePath());
        logger.info("Plugin construction is in progress...");
        apiImpl.getPluginManager().loadPlugins(Concrete.PLUGINS_DIR);
        logger.info("Server is ready for plugin start!");
        apiImpl.getPluginManager().fireEvent(new ServerStartEvent(Fountain.getServer()));
    }
}
