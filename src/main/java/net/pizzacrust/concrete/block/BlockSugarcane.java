package net.pizzacrust.concrete.block;

import net.minecraft.server.BlockReed;
import org.fountainmc.api.BlockType;
import org.fountainmc.api.Blocks;
import org.fountainmc.api.world.block.plants.Sugarcane;

import javax.annotation.Nonnegative;
import javax.annotation.Nonnull;

public class BlockSugarcane extends BlockGrowingPlant implements Sugarcane {
    private final BlockReed blockReed;

    public BlockSugarcane(BlockReed reed) {
        this.blockReed = reed;
    }

    @Override
    public double getGrowthPercentage() {
        return (getGrowth() / getMaxGrowth()) * 100;
    }

    @Override
    public int getGrowth() {
        return ((Integer) blockReed.getBlockData().get(BlockReed.AGE)).intValue();
    }

    @Override
    public Sugarcane withGrowth(@Nonnegative int i) {
        blockReed.getBlockData().set(BlockReed.AGE, i);
        return this;
    }

    @Nonnull
    @Override
    public BlockType getBlockType() {
        return Blocks.REEDS;
    }
}
