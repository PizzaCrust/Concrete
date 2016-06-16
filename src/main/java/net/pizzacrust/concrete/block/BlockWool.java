package net.pizzacrust.concrete.block;

import net.minecraft.server.BlockCloth;
import org.fountainmc.api.BlockType;
import org.fountainmc.api.Blocks;
import org.fountainmc.api.Color;
import org.fountainmc.api.world.block.WoolBlock;

import javax.annotation.Nonnull;

public class BlockWool extends BlockColouredBlock implements WoolBlock {

    public BlockWool(BlockCloth cloth) {
        super(cloth);
    }

    @Override
    public WoolBlock withColor(Color color) {
        super.withColor(color);
        return this;
    }

    @Nonnull
    @Override
    public BlockType getBlockType() {
        return Blocks.WOOL;
    }
}
