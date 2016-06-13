package net.pizzacrust.concrete.world;

import net.minecraft.server.BlockPosition;
import net.minecraft.server.WorldData;
import net.pizzacrust.concrete.MagicEnum;
import org.fountainmc.api.world.Chunk;
import org.fountainmc.api.world.World;
import org.fountainmc.api.world.block.BlockState;

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
    public BlockState getBlockAt(int x, int y, int z) {
        return MagicEnum.fromBlock(world.getChunkAt(x >> 4, z >> 4).getBlockData(new BlockPosition(x, y, z)).getBlock());
    }
}
