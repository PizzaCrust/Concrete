package net.pizzacrust.concrete.block;

import net.minecraft.server.BlockCloth;
import net.pizzacrust.concrete.MagicEnum;
import org.fountainmc.api.Color;
import org.fountainmc.api.world.block.ColoredBlock;

public abstract class BlockColouredBlock extends AbstractBlockState implements ColoredBlock {
    private final BlockCloth cloth;

    public BlockColouredBlock(BlockCloth cloth) {
        this.cloth = cloth;
    }

    @Override
    public Color getColor() {
        return MagicEnum.convert(cloth.getBlockData().get(BlockCloth.COLOR));
    }

    @Override
    public ColoredBlock withColor(Color color) {
        cloth.getBlockData().set(BlockCloth.COLOR, MagicEnum.convert(color));
        return this;
    }
}
