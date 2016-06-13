package net.pizzacrust.concrete.world;

import net.pizzacrust.concrete.MagicEnum;
import org.fountainmc.api.world.Chunk;
import org.fountainmc.api.world.World;
import org.fountainmc.api.world.block.BlockState;

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
    public BlockState getBlockAt(int x, int y, int z) {
        return MagicEnum.fromBlock(chunk.getBlockData(new net.minecraft.server.BlockPosition(x, y, z)).getBlock());
    }
}
