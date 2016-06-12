package net.pizzacrust.concrete;

import net.techcable.event4j.EventHandler;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.fountainmc.api.event.server.ServerStartEvent;
import org.fountainmc.api.event.server.ServerStopEvent;
import org.fountainmc.api.event.world.BlockBreakEvent;
import org.fountainmc.api.event.world.ChunkUnloadEvent;

public class InternalEventTest {
    public static final Logger LOGGER = LogManager.getLogger("InternalEventTest");

    @EventHandler
    public void onBlockBreak(BlockBreakEvent e) {
        LOGGER.debug("BlockBreakEvent at " + e.getBlockPosition().getWorld().getName() + ":" + e.getBlockPosition().getX() + ":" + e.getBlockPosition().getY() + ":" + e.getBlockPosition().getZ() );
    }

    @EventHandler
    public void onServerStart(ServerStartEvent e) {
        LOGGER.debug("ServerStartEvent triggered!");
    }

    @EventHandler
    public void onServerStop(ServerStopEvent e) {
        LOGGER.debug("ServerStopEvent triggered!");
    }

    @EventHandler
    public void onChunkUnloaded(ChunkUnloadEvent e) { LOGGER.debug("ChunkUnloadedEvent triggered!");}
}
