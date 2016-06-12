package net.pizzacrust.concrete.world;

import net.minecraft.server.WorldData;
import org.fountainmc.api.world.BlockPosition;
import org.fountainmc.api.world.Chunk;
import org.fountainmc.api.world.World;

public class SolidWorld implements World {
    private final net.minecraft.server.World world;

    public SolidWorld(net.minecraft.server.World world) {
        this.world = world;
    }

    @Override
    public String getName() {
        WorldData info = world.worldData;
        return info.getName();
    }

    @Override
    public Chunk getChunk(int x, int y) {
        return new SolidChunk(world.getChunkAt(x, y));
    }

    @Override
    public BlockPosition getBlockAt(int x, int y, int z) {
        return new BlockPosition(this, x, y, z);
    }
}
