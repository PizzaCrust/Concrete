package net.pizzacrust.concrete.world;

import org.fountainmc.api.world.BlockPosition;
import org.fountainmc.api.world.Chunk;
import org.fountainmc.api.world.World;

public class SolidChunk implements Chunk {
    private final net.minecraft.server.Chunk chunk;

    public SolidChunk(net.minecraft.server.Chunk chunk) {
        this.chunk = chunk;
    }

    @Override
    public int getX() {
        return chunk.locX;
    }

    @Override
    public int getZ() {
        return chunk.locZ;
    }

    @Override
    public World getWorld() {
        return new SolidWorld(chunk.getWorld());
    }

    @Override
    public BlockPosition getBlockAt(int x, int y, int z) {
        return new BlockPosition(getWorld(), x, y, z);
    }
}
