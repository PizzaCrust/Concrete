package net.pizzacrust.concrete.block;

import net.minecraft.server.BlockWood;
import org.fountainmc.api.BlockType;
import org.fountainmc.api.Blocks;
import org.fountainmc.api.world.block.plants.Leaves;

import javax.annotation.Nonnull;

import static net.minecraft.server.BlockLeaves.DECAYABLE;

public class BlockLeaves extends BlockPlant implements Leaves {
    private final net.minecraft.server.BlockLeaves leaves;

    public BlockLeaves(net.minecraft.server.BlockLeaves handle) {
        this.leaves = handle;
    }

    @Nonnull
    @Override
    public BlockType getBlockType() {
        return Blocks.LEAVES;
    }

    @Override
    public boolean canDecay() {
        return ((Boolean)leaves.getBlockData().get(DECAYABLE)).booleanValue();
    }

    @Override
    public LeafType getType() {
        BlockWood.EnumLogVariant variant = this.leaves.e(0);
        for (LeafType leafType : LeafType.values()) {
            if (variant.name().equals(leafType.name())) {
                return leafType;
            }
        }
        return LeafType.OAK;
    }
}
