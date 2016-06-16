package net.pizzacrust.concrete.block;

import org.fountainmc.api.world.block.DirectionalBlock;

public abstract class BlockDirectional extends AbstractBlockState implements DirectionalBlock {
    private final net.minecraft.server.BlockDirectional directional;

    public BlockDirectional(net.minecraft.server.BlockDirectional directional) {
        this.directional = directional;
    }

}
